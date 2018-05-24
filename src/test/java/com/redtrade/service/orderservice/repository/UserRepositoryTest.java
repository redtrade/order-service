package com.redtrade.service.orderservice.repository;

import com.redtrade.services.orderservice.OrderServiceApplication;
import com.redtrade.services.orderservice.embedded.EmbeddedMongo;
import com.redtrade.services.orderservice.model.user.User;
import com.redtrade.services.orderservice.repository.IUserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test")
//@TestPropertySource("application-test.properties")
@RunWith(SpringRunner.class)
@SpringBootTest(classes={OrderServiceApplication.class})
public class UserRepositoryTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryTest.class);

  private static EmbeddedMongo embeddedMongo;

  @Autowired
  private IUserRepository userRepository;

//  @BeforeClass
//  public static void init() throws IOException {
//    embeddedMongo = EmbeddedMongo.getInstance();
//    embeddedMongo.start();
//  }

//  @Before
//  public void setUp() throws Exception {
//      LOGGER.info("Setting up database");
//  }

  @Test
  public void testCreateUser() {
    User user = new User("a@a.com");
    Assert.assertNull(user.getId());
    this.userRepository.save(user);
    Assert.assertNotNull(user.getId());
  }

//  @AfterClass
//  public static void tearDown() {
//    embeddedMongo.stop();
//  }
}
