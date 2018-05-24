package com.redtrade.services.orderservice.model.order;

import com.redtrade.services.orderservice.model.account.Account;

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
