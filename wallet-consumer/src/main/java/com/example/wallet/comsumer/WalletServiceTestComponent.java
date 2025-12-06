package com.example.wallet.comsumer;

import com.example.wallet.client.WalletService;
import com.example.wallet.client.dto.WalletChargeCmd;
import com.example.wallet.client.dto.data.WalletCO;
import org.springframework.stereotype.Component;

import org.apache.dubbo.config.annotation.Reference; // <-- 🚀 修正：导入 Dubbo 的 @Reference 注解
import javax.annotation.PostConstruct;

@Component
public class WalletServiceTestComponent {

    // 引用 Provider 暴露的服务 (注意: 需要指定版本)
    @Reference(version = "1.0.0") // <-- 现在不会报红了
    private WalletService walletService;

    @PostConstruct // 确保容器启动后执行一次
    public void testServiceCall() {
        Long userId = 1001L;

        System.out.println(">>> 1. 尝试查询钱包...");
        WalletCO initialWallet = walletService.getWallet(userId);
        System.out.println(">>> 初始钱包余额: " + initialWallet.getBalance());

        System.out.println(">>> 2. 尝试进行充值...");
        walletService.charge(new WalletChargeCmd(userId, 500.0, "CNY"));
        System.out.println(">>> 充值 500.0 完成。");

        System.out.println(">>> 3. 再次查询钱包...");
        WalletCO finalWallet = walletService.getWallet(userId);
        System.out.println(">>> 最终钱包余额: " + finalWallet.getBalance());
    }
}