package com.example.wallet.domain.service.factory;

import com.example.wallet.domain.service.strategy.ChargeStrategy;
import com.example.wallet.domain.service.strategy.impl.BalanceChargeStrategy;
import com.example.wallet.domain.service.strategy.impl.BankCardChargeStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 充值策略工厂 - 用于获取不同的充值策略
 */
public class ChargeStrategyFactory {

    private static final Map<String, ChargeStrategy> STRATEGY_MAP = new HashMap<>();

    // 静态初始化策略
    static {
        STRATEGY_MAP.put("BALANCE", new BalanceChargeStrategy());
        STRATEGY_MAP.put("BANK_CARD", new BankCardChargeStrategy());
    }

    /**
     * 获取充值策略
     */
    public static ChargeStrategy getStrategy(String strategyName) {
        ChargeStrategy strategy = STRATEGY_MAP.get(strategyName);
        if (strategy == null) {
            // 默认使用余额充值策略
            strategy = new BalanceChargeStrategy();
        }
        return strategy;
    }
}