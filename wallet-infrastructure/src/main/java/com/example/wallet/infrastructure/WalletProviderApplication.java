package com.example.wallet.infrastructure;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo(scanBasePackages = "com.example.wallet.infrastructure.service")
// 扫描整个项目包 com.example.wallet 下的 Spring 组件
@SpringBootApplication(scanBasePackages = "com.example.wallet")
public class WalletProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(WalletProviderApplication.class, args);
    }
}