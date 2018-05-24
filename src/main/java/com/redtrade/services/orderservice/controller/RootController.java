package com.redtrade.services.orderservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
  private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);

  @RequestMapping(path = "/", method = RequestMethod.GET)
  private static ResponseEntity<String> root() {
    return new ResponseEntity("pong", HttpStatus.OK);
  }

}
