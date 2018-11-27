package com.oracle.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class StatusServiceConfig {
  private final static Logger LOGGER = LoggerFactory.getLogger(StatusService.class);

  @Bean
  public StatusService statusService() {
    return new StatusServiceImpl(getVersion(), getIpAddress());
  }

  private Version getVersion() {
    Version version = new Version(null, null, null, null);
    final ClassPathResource cpr = new ClassPathResource("version.json");
    try (InputStream inStream = cpr.getInputStream()) {
      if (inStream != null) {
        final ObjectMapper mapper = new ObjectMapper();
        version = mapper.readValue(inStream, Version.class);
        LOGGER.info("Reporting status: {}", mapper.writeValueAsString(version));
      }
    } catch (IOException e) {
      LOGGER.error("Failed to read version.json", e);
    }
    return version;
  }

  private String getIpAddress() {
    String ipAddress = "";
    try {
      ipAddress = InetAddress.getLocalHost().getHostAddress();
    } catch (UnknownHostException e) {
      LOGGER.error("Failed to read host ip address", e);
    }
    return ipAddress;
  }
}