package com.phoenixcoder.ps.api.services;

import com.phoenixcoder.ps.api.models.Payment;

public interface PaymentService {
    Payment doPayment(Payment payment);
    Payment findPaymentByOrderId(int orderId);
}
