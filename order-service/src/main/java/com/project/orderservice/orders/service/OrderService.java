package com.project.orderservice.orders.service;

import com.project.orderservice.orders.data.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    @Value("${base-uri.inventory-service}")
    private String baseInventoryServiceUri;

    public Order createOrder(Order order) {
        Order savedOrder = orderRepository.save(order);

        HttpEntity<Order> requestEntity = new HttpEntity<>(savedOrder);
        restTemplate.exchange(baseInventoryServiceUri + "/check", HttpMethod.POST, requestEntity, Void.class);

        return savedOrder;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
