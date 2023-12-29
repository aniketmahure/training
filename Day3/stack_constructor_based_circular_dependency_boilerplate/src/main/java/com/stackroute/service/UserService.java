package com.stackroute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class UserService {
    private String userName="John Doe";
    /**
     * declare a orderService variable as private final
     */
    private final OrderService orderService;
    /**
     * Autowire the OrderService bean using constructor-based injection
     */
    @Autowired
    public UserService(OrderService orderService) {
        super();
        this.orderService = orderService;
    }

    /**
     return user details
     */
    public String getUserDetails() {
        // Simulate fetching user details
        return this.userName;
    }

    /**
     * return the user's order details.
     */
    public String getUserOrders() {
        // return String with user details as User orders: orderService.getOrders()
        return "User orders: "+orderService.getOrders();
    }
}
