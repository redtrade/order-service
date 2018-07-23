package com.redtrade.services.orderservice.model.holding;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Holding {

  @Id
  private String id;

  private String accountId;

  private String symbol;
  private Double quantity;

}
