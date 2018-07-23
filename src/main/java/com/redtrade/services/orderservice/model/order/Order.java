package com.redtrade.services.orderservice.model.order;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Order {

  public enum OrderStatus {
    PENDING, COMPLETED, REJECTED
  }

  public enum OrderAction {
    BUY, SELL
  }

  @Id
  private String id;

  private String holdingId;
  private Double amount;
  private OrderStatus status;
  private OrderAction action;

}
