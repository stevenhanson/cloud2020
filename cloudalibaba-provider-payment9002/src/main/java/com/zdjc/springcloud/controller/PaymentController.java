package com.zdjc.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author flytiger
 * @since 2020-07-09 18:49
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/nacos/payment/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "nacos registry, serverPort：" + serverPort + "\t, id：" + id;
    }

}
