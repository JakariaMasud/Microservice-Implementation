package com.phoenixCoder.os.api.services;

import com.phoenixCoder.os.api.dtos.TransactionRequest;
import com.phoenixCoder.os.api.dtos.TransactionResponse;
import com.phoenixCoder.os.api.models.Order;

public interface OrderService {
    TransactionResponse saveOrder(TransactionRequest request);
}
