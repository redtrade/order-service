package com.redtrade.orderservice.services.repository;

import com.redtrade.orderservice.model.user.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("local")
@Repository
public class LocalUserRepository implements IUserRepository<User, Long> {

  private static final Logger LOGGER = LoggerFactory.getLogger(LocalUserRepository.class);

  private static Map<Long, User> repository = new HashMap<>();

  @Override
  public <S extends User> S save(S entity) {
    LOGGER.info("Saving entity");
    repository.put(entity.getId(), entity);
    return entity;
  }

  @Override
  public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
    LOGGER.info("Saving all entities");
    for (User user : entities) {
      save(user);
    }
    return entities;
  }

  @Override
  public Optional<User> findById(Long aLong) {
    LOGGER.info("Finding by ID");
    return Optional.ofNullable(repository.get(aLong));
  }

  @Override
  public boolean existsById(Long aLong) {
    LOGGER.info("Exists by ID");
    return repository.containsKey(aLong);
  }

  @Override
  public Iterable<User> findAll() {
    LOGGER.info("Finding all");
    return repository.values();
  }

  @Override
  public Iterable<User> findAllById(Iterable<Long> longs) {
    LOGGER.info("Find all by ID");
    // TODO: Make this less terrible
    List<User> matches = new ArrayList<>();
    for (Long id : longs) {
      if (repository.containsKey(id)) {
        matches.add(repository.get(id));
      }
    }
    return matches;
  }

  @Override
  public long count() {
    LOGGER.info("Counting");
    return repository.size();
  }

  @Override
  public void deleteById(Long aLong) {
    LOGGER.info("Deleting by ID");
    repository.remove(aLong);
  }

  @Override
  public void delete(User entity) {
    LOGGER.info("Delete by entity");
    repository.remove(entity.getId());
  }

  @Override
  public void deleteAll(Iterable<? extends User> entities) {
    LOGGER.info("Deleting all provided list");
    for (User user : entities) {
      delete(user);
    }
  }

  @Override
  public void deleteAll() {
    LOGGER.info("Delete all");
    repository.clear();
  }
}
