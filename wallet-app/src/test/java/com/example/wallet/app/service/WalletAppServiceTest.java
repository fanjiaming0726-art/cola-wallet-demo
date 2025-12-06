package com.example.wallet.app.service;

import com.example.wallet.client.dto.WalletChargeCmd;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WalletAppServiceTest {

    @Autowired
    private WalletAppService walletAppService;

    @Test
    public void testCharge() {
        // 创建充值命令
        WalletChargeCmd cmd = new WalletChargeCmd(123L, 100.0, "BANK_CARD");

        // 执行充值
        walletAppService.charge(cmd);

        System.out.println("测试完成！");
    }
}