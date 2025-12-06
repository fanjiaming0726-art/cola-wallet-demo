package com.example.wallet.client.dto;

import java.io.Serializable;

public class WalletChargeCmd implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long walletId;
    private Double amount;
    private String currency;
    public WalletChargeCmd(Long walletId, Double amount,String currency) {
        this.walletId = walletId;
        this.amount = amount;
        this.currency = currency;
    }

    public Long getWalletId() { return walletId; }
    public void setWalletId(Long walletId) { this.walletId = walletId; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public CharSequence getCurrency() {
        return currency;
    }
}