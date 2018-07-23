package com.redtrade.services.orderservice.controller;

import com.redtrade.services.orderservice.repository.IAccountRepository;
import com.redtrade.services.orderservice.repository.IHoldingRepository;
import com.redtrade.services.orderservice.repository.IOrderRepository;
import com.redtrade.services.orderservice.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootController {
  private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);

  @Autowired
  private IAccountRepository accountRepository;

  @Autowired
  private IHoldingRepository holdingRepository;

  @Autowired
  private IOrderRepository orderRepository;

  @Autowired
  private IUserRepository userRepository;

  @RequestMapping(path = "/ping", method = RequestMethod.GET)
  private ResponseEntity<String> root() {
    return new ResponseEntity("pong", HttpStatus.OK);
  }

  @RequestMapping(path = "/clear", method = RequestMethod.DELETE)
  private ResponseEntity<String> clear() {
    accountRepository.deleteAll();
    holdingRepository.deleteAll();
    orderRepository.deleteAll();
    userRepository.deleteAll();

   return new ResponseEntity<>("Done", HttpStatus.OK);

  }

}
