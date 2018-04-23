package com.redtrade.orderservice.services.model.holding;

import com.redtrade.orderservice.services.model.account.Account;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Holding {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private Account account;

  private String symbol;
  private Double quantity;


}
