package com.zdjc.springcloud.controller;

import com.zdjc.springcloud.entities.CommonResult;
import com.zdjc.springcloud.entities.Payment;
import com.zdjc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author flytiger
 * @since 2020-06-26 17:21
 */
@RestController
@Slf4j
@EnableDiscoveryClient
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果: " + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败", result);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询结果： " + payment);

        if (null != payment) {
            return new CommonResult(200, "查询成功,serverPort: " + serverPort, payment);
        } else {
            return new CommonResult(444, "没有找到对应数据，查询ID" + id, null);
        }

    }

    @GetMapping(value = "/payment/discovery")
    public CommonResult discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(service -> log.info(service));

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance -> log.info("instanceId : " + instance.getInstanceId()));

        return new CommonResult(200, "发现成功", services);
    }

    @GetMapping(value = "/payment/lb")
    public String paymentLB() {
        return this.serverPort;
    }

    @GetMapping("/payment/feign/timeout")
     public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.serverPort;
     }

     @GetMapping("/payment/zipkin")
      public String paymentZipkin() {
        return "hi, i'am paymentzipkin server fall back, welcome to paymentzipkin";
      }

}
