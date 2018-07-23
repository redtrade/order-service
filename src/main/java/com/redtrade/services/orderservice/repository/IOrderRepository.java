package com.redtrade.services.orderservice.repository;

import com.redtrade.services.orderservice.model.order.Order;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends MongoRepository<Order, String> {
  List<Order> findByHoldingId(String id);

}
