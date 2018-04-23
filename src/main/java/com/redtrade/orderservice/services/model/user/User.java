package com.redtrade.orderservice.model.user;

import java.util.ArrayList;
import java.util.List;
import com.redtrade.orderservice.services.model.account.Account;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

  @Id
  private Long id;

  private String email;

  @OneToMany(mappedBy = "user")
  private List<Account> accounts = new ArrayList<>();

  public User() {}

  public User(final String email) {
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public List<Account> getAccounts() {
    return accounts;
  }
}
