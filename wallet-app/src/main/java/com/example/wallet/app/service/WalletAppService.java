package com.example.wallet.app.service;

import com.example.wallet.app.service.template.AbstractWalletChargeFlow;
import com.example.wallet.client.dto.WalletChargeCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional; // 实际项目中此处应有事务管理

/**
 * 钱包应用服务 (Application Service)
 * 职责：流程编排、事务控制、权限校验。
 */
@Service
public class WalletAppService {

    @Autowired
    private AbstractWalletChargeFlow walletChargeFlow;

    // @Transactional
    public void charge(WalletChargeCmd cmd) {
        // 使用模板模式执行充值流程
        walletChargeFlow.execute(cmd);
    }
}