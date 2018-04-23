package com.redtrade.orderservice.services.model.order;

import com.redtrade.orderservice.services.model.account.Account;
import javax.persistence.Entity;

@Entity
public class MarketOrder extends Order {

  private OrderAction action;

  public MarketOrder() {

  }

  public MarketOrder(final Account account, final String symbol, final Double quantity,
      final OrderAction action) {
    super(account, symbol, quantity);
    this.action = action;
  }
}
