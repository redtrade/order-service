package com.redtrade.orderservice.services.service;

import com.redtrade.orderservice.model.user.User;
import com.redtrade.orderservice.services.repository.IUserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

  @Autowired
  private IUserRepository<User, Long> userRepository;

  @Override
  public Optional<User> findById(Long id) {
    return userRepository.findById(id);
  }

  @Override
  public List<User> findAll() {
    Iterable<User> users = userRepository.findAll();
    List<User> ret = new ArrayList<>();
    for (User user : users) {
      ret.add(user);
    }
    return ret;
  }

  @Override
  public User save(User entity) {
    return userRepository.save(entity);
  }

  @Override
  public User update(User entity) {
    userRepository.delete(entity);
    return userRepository.save(entity);
  }

  @Override
  public void remove(Long id) {
    userRepository.deleteById(id);
  }
}
