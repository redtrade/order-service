package com.redtrade.services.orderservice.service;

import com.redtrade.services.orderservice.model.user.User;
import com.redtrade.services.orderservice.repository.IUserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

  @Autowired
  private IUserRepository userRepository;

  @Override
  public List<User> findAll() { return userRepository.findAll(); }

  @Override
  public Optional<User> findById(String id) { return userRepository.findById(id); }

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public void deleteById(String id) { userRepository.deleteById(id); }
}
