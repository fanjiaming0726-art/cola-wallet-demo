package com.example.wallet.domain.validation;

import com.example.wallet.client.dto.WalletChargeCmd;

/**
 * 抽象验证处理器 - 实现了责任链的基本逻辑
 */
public abstract class AbstractValidationHandler implements ValidationHandler {

    protected ValidationHandler nextHandler;

    @Override
    public void setNext(ValidationHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(WalletChargeCmd cmd) {
        // 1. 执行当前处理器的验证逻辑
        validate(cmd);

        // 2. 如果有下一个处理器，则传递给下一个处理器
        if (nextHandler != null) {
            nextHandler.handle(cmd);
        }
    }

    /**
     * 具体的验证逻辑由子类实现
     */
    protected abstract void validate(WalletChargeCmd cmd);
}