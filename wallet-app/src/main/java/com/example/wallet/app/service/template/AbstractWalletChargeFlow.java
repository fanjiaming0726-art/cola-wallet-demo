package com.example.wallet.app.service.template;

import com.example.wallet.client.dto.WalletChargeCmd;
import com.example.wallet.domain.aggregate.Wallet;
import com.example.wallet.domain.gateway.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 钱包充值流程模板 - 模板模式的抽象类
 */

public abstract class AbstractWalletChargeFlow {

    @Autowired
    protected WalletRepository walletRepository;

    /**
     * 充值流程模板方法 - 定义了算法的骨架
     */
    public final void execute(WalletChargeCmd cmd) {
        // 1. 执行验证
        validate(cmd);

        // 2. 准备充值
        prepareCharge(cmd);

        // 3. 执行充值
        Wallet wallet = doCharge(cmd);

        // 4. 完成充值
        completeCharge(cmd, wallet);
    }

    /**
     * 验证步骤 - 由子类实现具体验证逻辑
     */
    protected abstract void validate(WalletChargeCmd cmd);

    /**
     * 准备充值步骤 - 可以由子类重写
     */
    protected void prepareCharge(WalletChargeCmd cmd) {
        System.out.println("[Template] 准备充值...");
        // 默认实现，可以由子类重写
    }

    /**
     * 执行充值步骤 - 核心充值逻辑
     */
    protected final Wallet doCharge(WalletChargeCmd cmd) {
        System.out.println("[Template] 执行充值...");

        // 加载或创建钱包
        Wallet wallet = walletRepository.findById(cmd.getWalletId());
        if (wallet == null) {
            wallet = new Wallet(cmd.getWalletId(), 0.0);
        }

        // 调用聚合根的策略充值方法
        wallet.chargeWithStrategy(cmd);

        // 保存钱包
        walletRepository.save(wallet);

        return wallet;
    }

    /**
     * 完成充值步骤 - 可以由子类重写
     */
    protected void completeCharge(WalletChargeCmd cmd, Wallet wallet) {
        System.out.println("[Template] 充值完成，钱包ID: " + wallet.getId() + "，新余额: " + wallet.getBalance());
        // 默认实现，可以由子类重写
    }
}