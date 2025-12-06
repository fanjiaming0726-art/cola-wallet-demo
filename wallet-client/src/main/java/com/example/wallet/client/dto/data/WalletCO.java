package com.example.wallet.client.dto.data;

import java.io.Serializable;

public class WalletCO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long walletId;
    private Double balance;

    public WalletCO(Long walletId, Double balance) {
        this.walletId = walletId;
        this.balance = balance;
    }

    public Long getWalletId() { return walletId; }
    public void setWalletId(Long walletId) { this.walletId = walletId; }

    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }
}