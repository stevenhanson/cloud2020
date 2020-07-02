package com.zdjc.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author flytiger
 * @since 2020-07-02 12:38
 */
@Service
public class PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_OK(Long id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_OK, id：" + id;
    }

    /**
     * 超时
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_Timeout(Long id) {
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {e.printStackTrace();}

        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_Timeout, id：" + id + ", spend time: " + timeNumber;
    }

    public String paymentInfo_TimeoutHandler(Long id) {
        return "线程池：" + Thread.currentThread().getName() + " 系统繁忙，请稍后再试, id：" + id + ", 哈哈 ";
    }

}
