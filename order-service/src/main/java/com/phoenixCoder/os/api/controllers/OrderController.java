package com.phoenixCoder.os.api.controllers;

import com.phoenixCoder.os.api.dtos.Payment;
import com.phoenixCoder.os.api.dtos.TransactionRequest;
import com.phoenixCoder.os.api.dtos.TransactionResponse;
import com.phoenixCoder.os.api.models.Order;
import com.phoenixCoder.os.api.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/placeOrder")
    public TransactionResponse placeOrder(@RequestBody TransactionRequest request){

        return orderService.saveOrder(request);
    }

}
