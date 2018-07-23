package com.redtrade.services.orderservice.repository;

import com.redtrade.services.orderservice.model.holding.Holding;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHoldingRepository extends MongoRepository<Holding, String> {
  List<Holding> findByAccountId(String id);
}
