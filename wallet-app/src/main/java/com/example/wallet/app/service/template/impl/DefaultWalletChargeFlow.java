package com.example.wallet.app.service.template.impl;

import com.example.wallet.app.service.template.AbstractWalletChargeFlow;
import com.example.wallet.client.dto.WalletChargeCmd;
import com.example.wallet.domain.aggregate.Wallet;
import com.example.wallet.domain.validation.ValidationChainFactory;
import org.springframework.stereotype.Component;

/**
 * 默认钱包充值流程 - 模板模式的具体实现
 */
@Component
public class DefaultWalletChargeFlow extends AbstractWalletChargeFlow {

    @Override
    protected void validate(WalletChargeCmd cmd) {
        System.out.println("[Template] 执行默认验证流程...");
        // 使用责任链进行验证
        ValidationChainFactory.createDefaultValidationChain().handle(cmd);
    }

    @Override
    protected void prepareCharge(WalletChargeCmd cmd) {
        super.prepareCharge(cmd);
        // 可以添加额外的准备逻辑
        System.out.println("[Template] 正在准备充值，钱包ID: " + cmd.getWalletId() + "，金额: " + cmd.getAmount());
    }

    @Override
    protected void completeCharge(WalletChargeCmd cmd, Wallet wallet) {
        super.completeCharge(cmd, wallet);
        // 可以添加额外的完成逻辑，如发送通知等
        System.out.println("[Template] 充值完成通知已发送！");
    }
}