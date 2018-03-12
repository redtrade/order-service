package com.redtrade.services.orderservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class Controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @RequestMapping("/")
    public String ping() {
        LOGGER.info("Received ping");
        return "order pong";
    }
}
