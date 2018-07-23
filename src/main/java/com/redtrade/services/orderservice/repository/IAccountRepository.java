package com.redtrade.services.orderservice.repository;

import com.redtrade.services.orderservice.model.account.Account;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends MongoRepository<Account, String> {
  List<Account> findByUserId(String id);
}
