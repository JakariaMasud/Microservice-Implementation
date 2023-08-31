package com.phoenixCoder.os.api.services;

import com.phoenixCoder.os.api.dtos.Payment;
import com.phoenixCoder.os.api.dtos.TransactionRequest;
import com.phoenixCoder.os.api.dtos.TransactionResponse;
import com.phoenixCoder.os.api.models.Order;
import com.phoenixCoder.os.api.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository repository;
    private final RestTemplate restTemplate;

    @Override
    public TransactionResponse saveOrder(TransactionRequest request) {
        Order order = request.getOrder();
        Order savedOrder = repository.save(order);
        Payment payment = request.getPayment();
        payment.setOrderId(savedOrder.getId());
        payment.setAmount(savedOrder.getPrice());
        Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
        String msg =paymentResponse.getPaymentStatus().equals("Success")?"Payment Successful":"Payment Failed";

        return new TransactionResponse(savedOrder,paymentResponse.getTransactionId(),paymentResponse.getAmount(),msg);
    }
}
