package com.redtrade.services.orderservice.controller;

import com.redtrade.services.orderservice.model.order.Order;
import com.redtrade.services.orderservice.repository.IOrderRepository;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

  @Autowired
  private IOrderRepository orderRepository;

  @RequestMapping(path = "/", method = RequestMethod.GET)
  private ResponseEntity<Optional<Order>> retrieveOrder(@PathVariable String id) {
    return new ResponseEntity<Optional<Order>>(orderRepository.findById(id), HttpStatus.OK);
  }
}
