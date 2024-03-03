package com.n11homework2.service.impl;

import com.n11homework2.entity.Order;
import com.n11homework2.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final List<Order> orders;

    public OrderServiceImpl (List<Order> orders) {
        this.orders = orders;
    }

}