package com.redtrade.services.orderservice.model.order;

import com.redtrade.services.orderservice.model.account.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Order {

  public enum OrderStatus {
    PENDING, COMPLETED, REJECTED
  }

  public enum OrderAction {
    BUY, SELL
  }

  private String id;

  private Account account;

  private String symbol;
  private Double quantity;
  private OrderStatus status;

  public Order(final Account account, final String symbol, final Double quantity) {
    this.account = account;
    this.symbol = symbol;
    this.quantity = quantity;
    this.status = OrderStatus.PENDING;
  }
}
