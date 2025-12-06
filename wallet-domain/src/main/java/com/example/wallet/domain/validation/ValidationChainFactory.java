package com.example.wallet.domain.validation;

import com.example.wallet.domain.validation.impl.AmountValidationHandler;
import com.example.wallet.domain.validation.impl.ParamValidationHandler;

/**
 * 验证责任链工厂 - 用于构建验证责任链
 */
public class ValidationChainFactory {

    /**
     * 创建默认的验证责任链
     */
    public static ValidationHandler createDefaultValidationChain() {
        // 创建各个验证处理器
        ValidationHandler paramHandler = new ParamValidationHandler();
        ValidationHandler amountHandler = new AmountValidationHandler();

        // 构建责任链：参数验证 -> 金额验证
        paramHandler.setNext(amountHandler);

        return paramHandler;
    }
}