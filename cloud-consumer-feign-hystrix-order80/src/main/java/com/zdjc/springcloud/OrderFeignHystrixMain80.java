package com.zdjc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author flytiger
 * @since 2020-07-02 17:56
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderFeignHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixMain80.class, args);
    }

}
