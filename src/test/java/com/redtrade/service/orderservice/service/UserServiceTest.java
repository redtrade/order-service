package com.redtrade.service.orderservice.service;

import com.redtrade.services.orderservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest {

  @Autowired
  private static IUserService userService;

//  @Test
//  public void User_save_success() {
//    userService.save(new User("abc@abc.com"));
//    Assert.assertEquals(1L, userService.findAll().size());
//  }
//
//  @Test
//  public void User_retrieved_isOriginal() {
//    User user = userService.save(new User("abc@abc.com"));
//    Assert.assertEquals(user, userService.findById(user.getId()));
//  }
}
