package com.redtrade.services.orderservice.controller;


import com.redtrade.services.orderservice.model.account.Account;
import com.redtrade.services.orderservice.model.holding.Holding;
import com.redtrade.services.orderservice.repository.IAccountRepository;
import com.redtrade.services.orderservice.repository.IHoldingRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private IAccountRepository accountRepository;

  @Autowired
  private IHoldingRepository holdingRepository;

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  private ResponseEntity<Optional<Account>> retrieveAccount(@PathVariable String id) {
    return new ResponseEntity<>(accountRepository.findById(id), HttpStatus.OK);
  }

  @RequestMapping(path = "/{id}/holdings/", method = RequestMethod.GET)
  private ResponseEntity<List<Holding>> retrieveHoldings(@PathVariable String id) {
    return new ResponseEntity<>(holdingRepository.findByAccountId(id), HttpStatus.OK);
  }

  @RequestMapping(path = "/{id}/holdings/", method = RequestMethod.POST)
  private ResponseEntity<Holding> createHolding(@PathVariable String id, @RequestBody Holding holding) {
    Optional<Account> account = accountRepository.findById(id);
    if(account.isPresent()) {
      holding.setAccountId(account.get().getId());
      return new ResponseEntity<>(holdingRepository.save(holding), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(holding, HttpStatus.BAD_REQUEST);
    }
  }
//  private ResponseEntity removeaccount(@PathVariable("id") String id) {
//    accountService.deleteById(id);
//    return new ResponseEntity(HttpStatus.OK);
//  }
}