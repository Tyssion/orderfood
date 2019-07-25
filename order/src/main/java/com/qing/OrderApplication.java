package com.qing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: zhching
 * @Date: 2019/7/15 9:56
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.qing.dao")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
