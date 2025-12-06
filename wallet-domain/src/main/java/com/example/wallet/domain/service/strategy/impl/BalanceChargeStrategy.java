package com.example.wallet.domain.service.strategy.impl;

import com.example.wallet.client.dto.WalletChargeCmd;
import com.example.wallet.domain.aggregate.Wallet;
import com.example.wallet.domain.service.strategy.ChargeStrategy;

/**
 * 余额充值策略 - 直接增加余额
 */
public class BalanceChargeStrategy implements ChargeStrategy {

    @Override
    public String getStrategyName() {
        return "BALANCE";
    }

    @Override
    public void execute(WalletChargeCmd cmd, Wallet wallet) {
        System.out.println("[Strategy] 使用余额充值策略...");
        // 直接增加余额（这里复用了Wallet的charge方法）
        wallet.charge(cmd.getAmount());
    }
}