package com.redtrade.orderservice.services.controller;

import com.redtrade.orderservice.model.user.User;
import com.redtrade.orderservice.services.service.IUserService;
import java.util.List;
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
@RequestMapping("/user")
public class UserController {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private IUserService userService;

  @RequestMapping(path = "/all", method = RequestMethod.GET)
  private ResponseEntity<List<User>> allUsers() {
    return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
  }

  @RequestMapping(path = "/create", method = RequestMethod.POST, consumes = "application/json")
  private ResponseEntity<User> createUser(@RequestBody User user) {
    return new ResponseEntity<User>(userService.save(new User(user.getEmail())), HttpStatus.OK);
  }

  @RequestMapping(path = "/remove/{id}", method = RequestMethod.DELETE)
  private ResponseEntity removeUser(@PathVariable("id") Long id) {
    userService.remove(id);
    return new ResponseEntity(HttpStatus.OK);
  }
}