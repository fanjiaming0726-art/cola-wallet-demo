package com.example.wallet.infrastructure.service;

import com.example.wallet.client.WalletService;
import com.example.wallet.client.dto.WalletChargeCmd;
import com.example.wallet.client.dto.data.WalletCO;
import com.example.wallet.app.service.WalletAppService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import io.opentracing.Span;
import io.opentracing.Tracer;

/**
 * Dubbo 接口的实现，作为服务的提供者 (Provider)
 */
@DubboService(version = "1.0.0")
public class WalletDubboServiceImpl implements WalletService {
    @Autowired
    private WalletAppService walletAppService;

    @Autowired
    private Tracer tracer;

    @Override
    public void charge(WalletChargeCmd cmd) {
        System.out.println("[Interface] 接收到充值请求，转发到 App Service...");
        // 创建Jaeger Span，用于追踪充值操作
        Span span = tracer.buildSpan("WalletService.charge")
                .withTag("walletId", cmd.getWalletId())
                .withTag("amount", cmd.getAmount())
                .withTag("currency", (String) cmd.getCurrency())
                .start();

        try {
            walletAppService.charge(cmd);
            span.setTag("success", true);
        } catch (Exception e) {
            span.setTag("success", false);
            span.setTag("error", true);
            span.log("充值操作失败: " + e.getMessage());
            throw e;
        } finally {
            span.finish();
        }
    }

    @Override
    public WalletCO getWallet(Long walletId) {
        // 创建Jaeger Span，用于追踪查询操作
        Span span = tracer.buildSpan("WalletService.getWallet")
                .withTag("walletId", walletId)
                .start();

        try {
            // 这里简化实现，实际项目中应该有对应的查询方法
            WalletCO result = new WalletCO(walletId, 0.0);
            span.setTag("success", true);
            span.setTag("balance", result.getBalance());
            return result;
        } catch (Exception e) {
            span.setTag("success", false);
            span.setTag("error", true);
            span.log("查询钱包失败: " + e.getMessage());
            throw e;
        } finally {
            span.finish();
        }
    }
}