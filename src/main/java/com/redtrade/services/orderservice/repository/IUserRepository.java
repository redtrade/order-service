package com.redtrade.services.orderservice.repository;

import com.redtrade.services.orderservice.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository extends MongoRepository<User, String> { }
