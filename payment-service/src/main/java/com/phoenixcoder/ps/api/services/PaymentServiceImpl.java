package com.phoenixcoder.ps.api.services;

import com.phoenixcoder.ps.api.models.Payment;
import com.phoenixcoder.ps.api.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Random;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository repository;
    @Override
    public Payment doPayment(Payment payment) {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return repository.save(payment);
    }

    @Override
    public Payment findPaymentByOrderId(int orderId) {
         return repository.findByOrderId(orderId);
    }

    private String paymentProcessing(){
        return new Random().nextBoolean()? "Success":"Failed";
    }
}