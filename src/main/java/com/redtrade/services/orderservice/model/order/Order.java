package com.redtrade.services.orderservice.model.order;

import com.redtrade.services.orderservice.model.user.User;

public abstract class Order {
    public enum OrderStatus { PENDING, COMPLETED, REJECTED }

    public enum OrderAction { BUY, SELL }

    private User owner;
    private String symbol;
    private Double quantity;
    private OrderStatus status;
}
