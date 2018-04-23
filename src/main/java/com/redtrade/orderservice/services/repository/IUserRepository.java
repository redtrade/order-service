package com.redtrade.orderservice.services.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository<User, Long> extends CrudRepository<User, Long> {

}
