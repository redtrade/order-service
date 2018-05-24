package com.redtrade.services.orderservice.embedded;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EmbeddedMongo {

  private static final Logger LOGGER = LoggerFactory.getLogger(EmbeddedMongo.class);


  private static final String LOCALHOST = "127.0.0.1";
  private static final String DB_NAME = "embedded";
  private static final int PORT = 27028;

  private static MongodProcess mongod;
  private static MongodExecutable mongodExecutable;

  private static EmbeddedMongo instance = null;

  private EmbeddedMongo() throws IOException {
    MongodStarter starter = MongodStarter.getDefaultInstance();

    IMongodConfig mongodConfig = new MongodConfigBuilder().version(Version.Main.PRODUCTION)
        .net(new Net(LOCALHOST, PORT,
            Network.localhostIsIPv6())).build();

    mongodExecutable = starter.prepare(mongodConfig);
  }

  public static EmbeddedMongo getInstance() throws IOException {
    if (instance == null) {
      instance = new EmbeddedMongo();
    }
    return instance;
  }

  public void start() throws IOException {
    if (mongod == null) {
      LOGGER.info("Starting embedded MongoDB");
      mongod = mongodExecutable.start();
    } else {
      LOGGER.info("Embedded MongoDB already started");
    }
  }

  public void stop() {
    if (mongod != null) {
      LOGGER.info("Stopping embedded MongoDB");
      mongod.stop();
    } else {
      LOGGER.info("MongoDB has not been started.");
    }
  }

}
