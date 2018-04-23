package com.redtrade.orderservice.services.model.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import com.redtrade.orderservice.services.model.holding.Holding;
import com.redtrade.orderservice.services.model.order.Order;
import com.redtrade.orderservice.model.user.User;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account {

  @Id
  @GeneratedValue
  private Long id;

  @JsonIgnore
  @ManyToOne
  private User owner;

  private Double cash;

  @OneToMany(mappedBy = "account")
  private List<Order> orders = new ArrayList<>();

  @OneToMany(mappedBy = "holdings")
  private List<Holding> holdings = new ArrayList<>();

  private Account() {}

  public Account(final User owner, final Double cash) {
    this.owner = owner;
    this.cash = cash;
  }
}
