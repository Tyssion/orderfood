package com.qing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: zhching
 * @Date: 2019/7/23 10:14
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.qing.dao")
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class,args);
    }
}
