package com.zdjc.springcloud.service.impl;

import com.zdjc.springcloud.dao.PaymentDao;
import com.zdjc.springcloud.entities.Payment;
import com.zdjc.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author flytiger
 * @since 2020-06-26 17:19
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
