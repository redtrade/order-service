package com.redtrade.services.orderservice.model.account;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Account {
  @Id
  private String id;

  private String userId;

  private Double cash;

}
