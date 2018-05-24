package com.redtrade.services.orderservice.model.holding;

import com.redtrade.services.orderservice.model.account.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Holding {

  private String id;

  private Account account;

  private String symbol;
  private Double quantity;

}
