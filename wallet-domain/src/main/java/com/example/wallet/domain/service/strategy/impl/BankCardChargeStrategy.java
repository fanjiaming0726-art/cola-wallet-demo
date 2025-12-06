package com.example.wallet.domain.service.strategy.impl;

import com.example.wallet.client.dto.WalletChargeCmd;
import com.example.wallet.domain.aggregate.Wallet;
import com.example.wallet.domain.service.strategy.ChargeStrategy;

/**
 * 银行卡充值策略 - 可能包含手续费、积分等逻辑
 */
public class BankCardChargeStrategy implements ChargeStrategy {

    private static final double FEE_RATE = 0.001; // 手续费率：0.1%

    @Override
    public String getStrategyName() {
        return "BANK_CARD";
    }

    @Override
    public void execute(WalletChargeCmd cmd, Wallet wallet) {
        System.out.println("[Strategy] 使用银行卡充值策略...");

        // 计算手续费
        double fee = cmd.getAmount() * FEE_RATE;
        System.out.println("[Strategy] 手续费: " + fee);

        // 实际到账金额 = 充值金额 - 手续费
        double actualAmount = cmd.getAmount() - fee;

        // 增加余额
        wallet.charge(actualAmount);

        // 可以添加积分奖励等额外逻辑
        System.out.println("[Strategy] 银行卡充值奖励积分: " + cmd.getAmount());
    }
}