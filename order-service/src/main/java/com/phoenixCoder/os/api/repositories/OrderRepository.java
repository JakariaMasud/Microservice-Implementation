package com.phoenixCoder.os.api.repositories;

import com.phoenixCoder.os.api.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
