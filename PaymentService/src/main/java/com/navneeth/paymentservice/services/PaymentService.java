package com.navneeth.paymentservice.services;

import org.springframework.stereotype.Service;

import com.navneeth.paymentservice.model.PaymentRequest;
import com.navneeth.paymentservice.model.PaymentResponse;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(String orderId);
}
