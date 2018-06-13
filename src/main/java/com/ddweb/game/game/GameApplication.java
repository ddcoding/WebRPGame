package com.ddweb.game.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class GameApplication {

  private static final Logger log = LoggerFactory.getLogger(GameApplication.class);

  public static void main(String[] args) throws UnknownHostException {
    SpringApplication app = new SpringApplication(GameApplication.class);
//    DefaultProfileUtil.appDefaultProfile(app);
		Environment env = app.run(args).getEnvironment();
		String protocol = "http";
		log.info("\n------------------------------------------------\n" +
      "Application '{}' is running! Access URLs:\n\t" +
      "Local: \t\t{}://localhost:{}\n\t" +
      "External: \t{}://{}:{}\n\t" +
      "Profile(s): \t {}\n" +
      "------------------------------------------------",
      env.getProperty("spring.application.name"),
      protocol,
      env.getProperty("server.port"),
      protocol,
      InetAddress.getLocalHost().getHostAddress(),
      env.getProperty("server.port"),
      env.getActiveProfiles()
    );
	}

}
