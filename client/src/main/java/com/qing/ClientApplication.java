package com.qing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: zhching
 * @Date: 2019/7/16 9:32
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class,args);
    }
}
