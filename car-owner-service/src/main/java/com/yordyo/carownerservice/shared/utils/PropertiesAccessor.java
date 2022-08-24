package com.yordyo.carownerservice.shared.utils;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class PropertiesAccessor {
  public static Properties getErrorProperties(String fileName) throws IOException {
    Resource resource = new ClassPathResource("/errors/" + fileName);
    return PropertiesLoaderUtils.loadProperties(resource);
  }

  public static Properties getSuccessProperties(String fileName) throws IOException {
    Resource resource = new ClassPathResource("/success/" + fileName);
    return PropertiesLoaderUtils.loadProperties(resource);
  }

  private PropertiesAccessor() {}
}
