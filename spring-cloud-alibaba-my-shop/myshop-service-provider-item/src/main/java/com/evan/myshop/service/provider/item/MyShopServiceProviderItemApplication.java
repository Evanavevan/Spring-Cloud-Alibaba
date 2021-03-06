package com.evan.myshop.service.provider.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.evan.myshop")
@EnableDiscoveryClient
@MapperScan(basePackages = "com.evan.myshop.commons.mapper")
@EnableSwagger2
public class MyShopServiceProviderItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyShopServiceProviderItemApplication.class, args);
    }
}
