package com.redtrade.services.orderservice.controller;

import com.redtrade.services.orderservice.model.holding.Holding;
import com.redtrade.services.orderservice.model.order.Order;
import com.redtrade.services.orderservice.model.order.Order.OrderStatus;
import com.redtrade.services.orderservice.repository.IHoldingRepository;
import com.redtrade.services.orderservice.repository.IOrderRepository;
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
@RequestMapping("/holding")
public class HoldingController {

  private static final Logger LOGGER = LoggerFactory.getLogger(HoldingController.class);

  @Autowired
  private IHoldingRepository holdingRepository;

  @Autowired
  private IOrderRepository orderRepository;


  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  private ResponseEntity<Optional<Holding>> retrieveHolding(@PathVariable String id) {
    return new ResponseEntity<>(holdingRepository.findById(id), HttpStatus.OK);
  }

  @RequestMapping(path = "/{id}/orders/", method = RequestMethod.GET)
  private ResponseEntity<List<Order>> retrieveOrders(@PathVariable String id) {
    return new ResponseEntity<>(orderRepository.findByHoldingId(id), HttpStatus.OK);
  }

  @RequestMapping(path = "/{id}/orders/", method = RequestMethod.POST)
  private ResponseEntity<Order> createOrder(@PathVariable String id, @RequestBody Order order) {
    Optional<Holding> holding = holdingRepository.findById(id);
    if (holding.isPresent()) {
      order.setHoldingId(holding.get().getId());
      order.setStatus(OrderStatus.PENDING);
      return new ResponseEntity<>(orderRepository.save(order), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(order, HttpStatus.BAD_REQUEST);
    }

  }
}
