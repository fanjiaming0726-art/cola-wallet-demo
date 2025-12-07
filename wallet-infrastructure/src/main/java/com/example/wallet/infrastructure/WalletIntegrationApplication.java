package com.example.wallet.infrastructure;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 整合后的启动类：同时作为Dubbo服务提供者和消费者
 */
@SpringBootApplication(scanBasePackages = "com.example.wallet")
@EnableDubbo(scanBasePackages = {
        "com.example.wallet.infrastructure.service",  // 扫描服务提供者实现
        "com.example.wallet.infrastructure"  // 扫描服务消费者组件
})
public class WalletIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletIntegrationApplication.class, args);
    }
}