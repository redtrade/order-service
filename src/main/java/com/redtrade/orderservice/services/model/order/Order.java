package com.redtrade.orderservice.services.model.order;

import com.redtrade.orderservice.services.model.account.Account;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Order {

  public enum OrderStatus {
    PENDING, COMPLETED, REJECTED
  }

  public enum OrderAction {
    BUY, SELL
  }

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private Account account;

  private String symbol;
  private Double quantity;
  private OrderStatus status;

  public Order() {
  }

  public Order(final Account account, final String symbol, final Double quantity) {
    this.account = account;
    this.symbol = symbol;
    this.quantity = quantity;
    this.status = OrderStatus.PENDING;
  }
}
