package com.example.wallet.infrastructure.service;

import com.example.wallet.client.WalletService;
import com.example.wallet.client.dto.WalletChargeCmd;
import com.example.wallet.client.dto.data.WalletCO;
import com.example.wallet.app.service.WalletAppService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Dubbo 接口的实现，作为服务的提供者 (Provider)
 */
@DubboService(version = "1.0.0")
public class WalletDubboServiceImpl implements WalletService {
    @Autowired
    private WalletAppService walletAppService;

    @Override
    public void charge(WalletChargeCmd cmd) {
        System.out.println("[Interface] 接收到充值请求，转发到 App Service...");
        walletAppService.charge(cmd);
    }

    @Override
    public WalletCO getWallet(Long walletId) {
        // 这里简化实现，实际项目中应该有对应的查询方法
        return new WalletCO(walletId, 0.0);
    }
}