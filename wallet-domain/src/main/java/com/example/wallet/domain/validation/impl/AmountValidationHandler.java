package com.example.wallet.domain.validation.impl;

import com.example.wallet.client.dto.WalletChargeCmd;
import com.example.wallet.domain.validation.AbstractValidationHandler;

/**
 * 金额验证处理器 - 验证充值金额是否合法
 */
public class AmountValidationHandler extends AbstractValidationHandler {

    @Override
    protected void validate(WalletChargeCmd cmd) {
        System.out.println("[Validation] 执行金额合法性验证...");

        if (cmd.getAmount() <= 0) {
            throw new IllegalArgumentException("充值金额必须大于0！");
        }

        // 可以添加更多的金额验证规则，如单日限额、单笔限额等
        if (cmd.getAmount() > 5000) {
            throw new IllegalArgumentException("单笔充值金额不能超过5000！");
        }

        System.out.println("[Validation] 金额合法性验证通过！");
    }
}