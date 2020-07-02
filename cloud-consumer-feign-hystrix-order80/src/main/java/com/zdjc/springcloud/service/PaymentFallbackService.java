package com.zdjc.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @author flytiger
 * @since 2020-07-02 19:03
 */
@Service
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Long id) {
        return "PaymentFallbackService paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout(Long id) {
        return "PaymentFallbackService paymentInfo_Timeout";
    }
}
