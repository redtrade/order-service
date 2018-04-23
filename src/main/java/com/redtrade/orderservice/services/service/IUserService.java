package com.redtrade.orderservice.services.service;

import com.redtrade.orderservice.model.user.User;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
  Optional<User> findById(Long id);
  List<User> findAll();
  User save(User entity);
  User update(User entity);
  void remove(Long id);
}
