package com.example.wallet.domain.validation;

import com.example.wallet.client.dto.WalletChargeCmd;

/**
 * 验证处理器接口 - 责任链模式的Handler
 */
public interface ValidationHandler {
    /**
     * 设置下一个处理器
     */
    void setNext(ValidationHandler nextHandler);

    /**
     * 处理验证
     */
    void handle(WalletChargeCmd cmd);
}