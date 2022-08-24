package com.yordyo.carownerservice.shared.config;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import static org.h2.tools.Server.createWebServer;

@Configuration
@Profile("dev")
public class H2Config {
  private static final Logger LOGGER = LoggerFactory.getLogger(H2Config.class);
  private Server webServer;

  @Value("${h2-console.port}")
  Integer h2ConsolePort;

  @Bean(initMethod = "start", destroyMethod = "stop")
  public Server h2Server() {
    Server h2Server;
    try {
      h2Server = Server.createTcpServer();
    } catch (SQLException e) {
      throw new RuntimeException("Failed to start H2 server: ", e);
    }
    return h2Server;
  }

  @EventListener(ContextRefreshedEvent.class)
  public void start() throws SQLException {
    LOGGER.info("Starting H2 console at port {}", h2ConsolePort);
    this.webServer = createWebServer("-webPort", h2ConsolePort.toString(), "-tcpAllowOthers").start();
  }

  @EventListener(ContextClosedEvent.class)
  public void stop() {
    LOGGER.info("Stopping H2 console at port {}", h2ConsolePort);
    this.webServer.stop();
  }
}
