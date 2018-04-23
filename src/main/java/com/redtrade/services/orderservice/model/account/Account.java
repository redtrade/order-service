package com.redtrade.services.orderservice.model.account;

import com.redtrade.services.orderservice.model.holding.Holding;
import com.redtrade.services.orderservice.model.order.Order;
import com.redtrade.services.orderservice.model.user.User;

import java.util.List;

public class Account {
    private User owner;
    private List<Holding> holdings;
    private List<Order> orders;
    private Double cash;
}
