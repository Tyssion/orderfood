package com.qing.feign;

import com.qing.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: zhching
 * @Date: 2019/7/23 14:49
 * @Version 1.0
 */
@FeignClient(value = "account")
public interface AccountFeignClient {
    @GetMapping("account/login/{username}/{password}/{type}")
    Account login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("type") String type);

}
