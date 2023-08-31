package com.phoenixcoder.ps.api.repositories;

import com.phoenixcoder.ps.api.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {

    Payment findByOrderId(int orderId);
}
