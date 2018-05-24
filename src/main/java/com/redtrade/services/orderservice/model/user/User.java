package com.redtrade.services.orderservice.model.user;

import com.redtrade.services.orderservice.model.account.Account;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

  private String id;
  private String email;
  private List<Account> accounts = new ArrayList<>();

  public User(final String email) {
    this.email = email;
  }
}
