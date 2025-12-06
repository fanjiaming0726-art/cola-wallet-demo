package com.example.wallet.domain.validation.impl;

import com.example.wallet.client.dto.WalletChargeCmd;
import com.example.wallet.domain.validation.AbstractValidationHandler;

/**
 * 参数验证处理器 - 验证充值参数是否完整
 */
public class ParamValidationHandler extends AbstractValidationHandler {

    @Override
    protected void validate(WalletChargeCmd cmd) {
        System.out.println("[Validation] 执行参数完整性验证...");

        if (cmd.getWalletId() == null) {
            throw new IllegalArgumentException("钱包ID不能为空！");
        }

        if (cmd.getAmount() == null) {
            throw new IllegalArgumentException("充值金额不能为空！");
        }

        if (cmd.getCurrency() == null || cmd.getCurrency().isEmpty()) {
            throw new IllegalArgumentException("货币类型不能为空！");
        }

        System.out.println("[Validation] 参数完整性验证通过！");
    }
}