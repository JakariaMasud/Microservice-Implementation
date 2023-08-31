package com.phoenixcoder.ps.api.controllers;

import com.phoenixcoder.ps.api.models.Payment;
import com.phoenixcoder.ps.api.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment){
        return paymentService.doPayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment findPaymentByOrderId(@PathVariable int orderId){
        return paymentService.findPaymentByOrderId(orderId);
    }


}
