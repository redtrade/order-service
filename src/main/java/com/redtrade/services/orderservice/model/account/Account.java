package com.redtrade.services.orderservice.model.account;

import com.redtrade.services.orderservice.model.holding.Holding;
import com.redtrade.services.orderservice.model.order.Order;
import com.redtrade.services.orderservice.model.user.User;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account {

  private String id;
  private User owner;
  private Double cash;
  private List<Order> orders = new ArrayList<>();
  private List<Holding> holdings = new ArrayList<>();

  public Account(final User owner, final Double cash) {
    this.owner = owner;
    this.cash = cash;
  }
}
