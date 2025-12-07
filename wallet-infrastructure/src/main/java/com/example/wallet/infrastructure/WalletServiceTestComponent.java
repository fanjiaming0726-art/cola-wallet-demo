package com.example.wallet.infrastructure;

import com.example.wallet.client.WalletService;
import com.example.wallet.client.dto.WalletChargeCmd;
import com.example.wallet.client.dto.data.WalletCO;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.apache.dubbo.config.annotation.Reference;

/**
 * 钱包服务测试组件：应用启动后自动执行测试
 */
@Component
public class WalletServiceTestComponent implements ApplicationListener<ContextRefreshedEvent> {

    // 引用本地暴露的服务
    @Reference(version = "1.0.0", url = "dubbo://localhost:20880")
    private WalletService walletService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 避免重复执行（防止父子容器都触发事件）
        if (event.getApplicationContext().getParent() == null) {
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
}