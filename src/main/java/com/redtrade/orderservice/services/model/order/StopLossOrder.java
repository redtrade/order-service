package com.redtrade.orderservice.services.model.order;

import com.redtrade.orderservice.services.model.account.Account;
import javax.persistence.Entity;

@Entity
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
