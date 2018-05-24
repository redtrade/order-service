package com.redtrade.services.orderservice.service;

import com.redtrade.services.orderservice.model.user.User;
import java.util.List;
import java.util.Optional;

public interface IUserService {
  List<User> findAll();
  Optional<User> findById(String id);
  User save(User user);
  void deleteById(String id);
}
