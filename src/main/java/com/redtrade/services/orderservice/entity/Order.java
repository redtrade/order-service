package com.redtrade.services.orderservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Order")
public class Order implements Serializable {
    public enum Type {
        BUY, SELL
    }

    @Id
    private long id;

    private Type type;
    private String symbol;
    private double quantity;

    public Order(Type type, String symbol, double quantity) {
        this.type = type;
        this.symbol = symbol;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "type=" + type +
                ", symbol='" + symbol + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
