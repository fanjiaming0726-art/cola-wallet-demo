package com.example.wallet.domain.gateway;

import com.example.wallet.domain.aggregate.Wallet;

/**
 * 钱包仓储接口 (Repository Interface)
 * 职责：负责 Wallet 聚合根的持久化操作。
 */
public interface WalletRepository {
    Wallet findById(Long walletId);
    void save(Wallet wallet); // 负责更新或插入
}