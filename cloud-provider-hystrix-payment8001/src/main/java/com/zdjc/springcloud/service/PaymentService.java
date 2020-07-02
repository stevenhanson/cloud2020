package com.zdjc.springcloud.service;

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
    public String paymentInfo_Timeout(Long id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {e.printStackTrace();}

        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_OK, id：" + id + ", spend time: " + timeNumber;
    }

}
