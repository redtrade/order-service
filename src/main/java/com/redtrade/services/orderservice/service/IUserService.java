package com.redtrade.services.orderservice.service;

import com.redtrade.services.orderservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {
    @Autowired
    private UserRepository userRepository;
}
