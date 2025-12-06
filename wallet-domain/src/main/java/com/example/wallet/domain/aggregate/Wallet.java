package com.example.wallet.domain.aggregate;

import com.example.wallet.client.dto.WalletChargeCmd;
import com.example.wallet.domain.service.factory.ChargeStrategyFactory;
import com.example.wallet.domain.service.strategy.ChargeStrategy;

/**
 * 钱包聚合根
 * 包含钱包的核心状态和业务逻辑。
 */
public class Wallet {
    private Long id;
    private Double balance;

    public Wallet(Long id, Double balance) {
        this.id = id;
        this.balance = balance;
    }

    /** 核心业务方法：充值 */
    public void charge(Double amount) {
        // [DDD 核心业务逻辑]
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("充值金额必须大于0！");
        }

        // 1. 检查业务规则 (例如，每日限额检查...)
        // if (amount > 5000) { throw new RuntimeException("单笔充值不能超过5000"); }

        // 2. 增加余额
        this.balance += amount;

        System.out.println("[Domain] 钱包 ID: " + id + " 充值 " + amount + "，新余额: " + this.balance);
    }

    /**
     * 使用策略模式的充值方法
     */
    public void chargeWithStrategy(WalletChargeCmd cmd) {
        // 根据命令中的货币类型或其他参数选择策略
        String strategyName = (String) cmd.getCurrency(); // 假设currency字段存储的是充值方式

        // 获取策略
        ChargeStrategy strategy = ChargeStrategyFactory.getStrategy(strategyName);

        // 执行策略
        strategy.execute(cmd, this);
    }

    public Long getId() { return id; }
    public Double getBalance() { return balance; }
}