package com.example.wallet.client;

import com.example.wallet.client.dto.WalletChargeCmd;
import com.example.wallet.client.dto.data.WalletCO; // Command Object

public interface WalletService {
    /** 充值操作 */
    void charge(WalletChargeCmd cmd);

    /** 查询钱包信息（简化，仅查询余额） */
    WalletCO getWallet(Long walletId);
}
