package com.example.springindiv2.repository;

import com.example.springindiv2.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {

    List<Order> findOrdersByOrderStatusAndPaymentStatus(Integer orderStatus, Integer paymentStatus);

}
