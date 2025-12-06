package com.example.wallet.infrastructure.repository.impl;

import com.example.wallet.domain.aggregate.Wallet;
import com.example.wallet.domain.gateway.WalletRepository;
import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 仓储接口的具体实现，使用内存Map模拟数据库操作。
 */
@Component
public class InMemoryWalletRepositoryImpl implements WalletRepository {
    // 内存模拟数据库
    private static final ConcurrentMap<Long, Wallet> WALLET_MAP = new ConcurrentHashMap<>();

    @Override
    public Wallet findById(Long walletId) {
        System.out.println("[Infra] 从内存加载钱包: " + walletId);
        return WALLET_MAP.get(walletId);
    }

    @Override
    public void save(Wallet wallet) {
        System.out.println("[Infra] 保存钱包 ID: " + wallet.getId() + "，当前余额: " + wallet.getBalance());
        WALLET_MAP.put(wallet.getId(), wallet);
    }
}