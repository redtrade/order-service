package com.redtrade.services.orderservice.controller;

import com.redtrade.services.orderservice.model.account.Account;
import com.redtrade.services.orderservice.model.user.User;
import com.redtrade.services.orderservice.repository.IAccountRepository;
import com.redtrade.services.orderservice.repository.IUserRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private IUserRepository userRepository;

  @Autowired
  private IAccountRepository accountRepository;

  @RequestMapping(path = "/", method = RequestMethod.GET)
  private ResponseEntity<List<User>> retrieveAllUsers() {
    return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
  }

  @RequestMapping(path = "/", method = RequestMethod.POST, consumes = "application/json")
  private ResponseEntity<User> createUser(@RequestBody User user) {
    LOGGER.info("User created");
    User newUser = new User();
    if (user.getEmail().length() > 0) {
      newUser.setEmail(user.getEmail());
      User returnUser = userRepository.save(newUser);
      return new ResponseEntity<>(returnUser, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  private ResponseEntity<Optional<User>> retrieveUser(@PathVariable String id) {
    return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
  }

  @RequestMapping(path = "/{id}/accounts/", method = RequestMethod.GET)
  private ResponseEntity<List<Account>> retrieveAccounts(@PathVariable String id) {
    return new ResponseEntity<>(accountRepository.findByUserId(id), HttpStatus.OK);
  }

  @RequestMapping(path = "/{id}/accounts/", method = RequestMethod.POST)
  private ResponseEntity<Account> createAccount(@PathVariable String id,
      @RequestBody Account account) {
    Optional<User> user = userRepository.findById(id);
    if (user.isPresent()) {
      account.setUserId(user.get().getId());
      return new ResponseEntity<>(accountRepository.save(account), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(account, HttpStatus.BAD_REQUEST);
    }

  }

//  private ResponseEntity removeUser(@PathVariable("id") String id) {
//    userService.deleteById(id);
//    return new ResponseEntity(HttpStatus.OK);
//  }
}