package com.redtrade.services.orderservice;

import com.redtrade.services.orderservice.model.account.Account;
import com.redtrade.services.orderservice.model.user.User;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void Create_User_ReturnsCreatedUser() {
    User user = new User();
    user.setEmail("test@test.com");

    ResponseEntity<User> response = restTemplate.postForEntity("/users/", user, User.class);

    Assert.assertEquals(response.getBody().getEmail(), user.getEmail());
    Assert.assertTrue(response.getBody().getId() != null);
  }

  @Test
  public void Get_UserById_ReturnsUser() {
    User user = new User();
    user.setEmail("test@test.com");

    ResponseEntity<User> response = restTemplate.postForEntity("/users/", user, User.class);

    response = restTemplate.getForEntity("/users/" + response.getBody().getId(), User.class);

    Assert.assertEquals(response.getBody().getEmail(), user.getEmail());
    Assert.assertTrue(response.getBody().getId() != null);
  }

  @Test
  public void Create_UserWithNoEmail_ReturnsBadRequest() {
    User user = new User();

    ResponseEntity<User> response = restTemplate.postForEntity("/users/", user, User.class);

    Assert.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
  }

  @Test
  public void Get_NonExistantUser_ReturnsBadRequest() {
    ResponseEntity<Optional> response = restTemplate.getForEntity("/users/", Optional.class);

    Assert.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
  }

  @Test
  public void Create_Account_ReturnsCreatedAccount() {
    User user = new User();
    user.setEmail("test@test.com");

    Account account = new Account();
    account.setCash(1000.0);

    ResponseEntity<User> userResponse = restTemplate.postForEntity("/users/", user, User.class);

    ResponseEntity<Account> accountResponse = restTemplate
        .postForEntity("/users/" + userResponse.getBody().getId() + "/accounts/", account,
            Account.class);

    Assert.assertEquals(accountResponse.getBody().getCash(), account.getCash());
    Assert.assertTrue(accountResponse.getBody().getId() != null);
    Assert.assertEquals(accountResponse.getBody().getUserId(), userResponse.getBody().getId());
  }

}
