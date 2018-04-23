package com.redtrade.orderservice.services.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
}
