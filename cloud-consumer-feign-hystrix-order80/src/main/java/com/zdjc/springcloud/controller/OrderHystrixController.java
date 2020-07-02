package com.zdjc.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zdjc.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author flytiger
 * @since 2020-07-02 18:02
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentInfo_Global_FallBackHandler")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Long id) {
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("****** paymentInfo_OK, result：" + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
//    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Long id) {
        String result = paymentHystrixService.paymentInfo_Timeout(id);
        log.info("****** paymentInfo_Timeout, result：" + result);
        return result;
    }

    public String paymentInfo_TimeoutHandler(Long id) {
        return "我是消费者80，对方支付系统繁忙，请10秒后再试或者自己远行出错检查自己。";
    }

    public String paymentInfo_Global_FallBackHandler() {
        return "Global异常处理信息，请稍后再试。";
    }

}
