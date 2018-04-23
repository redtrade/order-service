package com.redtrade.orderservice.services.model.order;

import com.redtrade.orderservice.services.model.account.Account;

public class LimitOrder extends Order {

  private OrderAction action;
  private Double triggerPrice;

  public LimitOrder() {
  }

  public LimitOrder(final Account account, final String symbol, final Double quantity,
      final OrderAction action, final Double triggerPrice) {
    super(account, symbol, quantity);
    this.action = action;
    this.triggerPrice = triggerPrice;
  }
}
