package com.redtrade.services.orderservice.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.redtrade.services.orderservice.model.account.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("accounts")
    private List<Account> accounts;

    public User() {}

    public User(User other) {
        this.id = new Random().nextLong();
        this.email = other.email;
        this.accounts = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }
}
