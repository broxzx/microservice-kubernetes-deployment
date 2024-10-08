package com.project.orderservice.orders.service;

import com.project.orderservice.orders.data.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
