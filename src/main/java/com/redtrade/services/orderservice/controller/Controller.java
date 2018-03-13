package com.redtrade.services.orderservice.controller;

import com.redtrade.services.orderservice.entity.Order;
import com.redtrade.services.orderservice.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class Controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private OrderRepository orderRepository;

//    @RequestMapping("/")
//    public String ping() {
//        LOGGER.info("Received ping");
//        return "order pong";
//    }

    @RequestMapping("/")
    public String order() {
        LOGGER.info("Received order");
        Order order = new Order(Order.Type.BUY, "AAPL", 100.0);
        orderRepository.save(order);
        LOGGER.info("Order submitted");
        LOGGER.info("All orders: {}", orderRepository.findAll());
        return "OK";
    }
}
