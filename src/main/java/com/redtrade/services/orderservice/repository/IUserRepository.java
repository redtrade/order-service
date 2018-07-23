package com.redtrade.services.orderservice.repository;

import com.redtrade.services.orderservice.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {

}
