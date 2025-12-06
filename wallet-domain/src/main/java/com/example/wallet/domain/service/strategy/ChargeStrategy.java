package com.example.wallet.domain.service.strategy;

import com.example.wallet.client.dto.WalletChargeCmd;
import com.example.wallet.domain.aggregate.Wallet;

/**
 * 充值策略接口 - 策略模式的Strategy
 */
public interface ChargeStrategy {

    /**
     * 获取策略名称
     */
    String getStrategyName();

    /**
     * 执行充值策略
     */
    void execute(WalletChargeCmd cmd, Wallet wallet);
}