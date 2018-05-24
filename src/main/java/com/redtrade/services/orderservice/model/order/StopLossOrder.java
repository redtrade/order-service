package com.redtrade.services.orderservice.model.order;

import com.redtrade.services.orderservice.model.account.Account;

public class StopLossOrder extends Order {

  private Double triggerPrice;

  public StopLossOrder() {
  }

  public StopLossOrder(final Account account, final String symbol, final Double quantity,
      final Double triggerPrice) {
    super(account, symbol, quantity);
    this.triggerPrice = triggerPrice;
  }
}
