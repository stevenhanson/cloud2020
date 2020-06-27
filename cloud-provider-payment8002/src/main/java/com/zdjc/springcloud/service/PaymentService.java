package com.zdjc.springcloud.service;

import com.zdjc.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author flytiger
 * @since 2020-06-26 17:19
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
