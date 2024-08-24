package com.navneeth.paymentservice.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navneeth.paymentservice.entity.TransactionDetails;
import com.navneeth.paymentservice.model.PaymentMode;
import com.navneeth.paymentservice.model.PaymentRequest;
import com.navneeth.paymentservice.model.PaymentResponse;
import com.navneeth.paymentservice.repository.TransactionsDetailsRepository;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private TransactionsDetailsRepository transactionsDetailsRepository;

    @Override
    public long doPayment(PaymentRequest paymentRequest) {
        log.info("Recording Payment Details: {}", paymentRequest);

        TransactionDetails transactionDetails =
                TransactionDetails.builder()
                        .referenceNumber(paymentRequest.getReferenceNumber())
                        .paymentDate(Instant.now())
                        .paymentMode(paymentRequest.getPaymentMode().name())
                        .amount(paymentRequest.getAmount())
                        .orderId(paymentRequest.getOrderId())
                        .paymentStatus("SUCCESS")
                        .build();
        transactionsDetailsRepository.save(transactionDetails);

        log.info("Transaction completed with Id: {}", transactionDetails.getId());
        return transactionDetails.getId();
    }

    @Override
    public PaymentResponse getPaymentDetailsByOrderId(String orderId) {
        log.info("Getting payment details for the order id: {}", orderId);

        TransactionDetails transactionDetails =
                transactionsDetailsRepository.findByOrderId(Long.parseLong(orderId));

        return PaymentResponse
                .builder()
                .paymentId(transactionDetails.getId())
                .paymentMode(PaymentMode.valueOf(transactionDetails.getPaymentMode()))
                .paymentDate(transactionDetails.getPaymentDate())
                .orderId(transactionDetails.getOrderId())
                .status(transactionDetails.getPaymentStatus())
                .amount(transactionDetails.getAmount())
                .build();
    }
}
