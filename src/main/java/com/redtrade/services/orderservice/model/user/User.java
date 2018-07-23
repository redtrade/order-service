package com.redtrade.services.orderservice.model.user;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {
  @Id
  private String id;
  private String email;
}
