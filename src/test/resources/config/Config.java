// src/test/java/com/orange/config/Config.java
package com.orange.config;

import java.io.InputStream;
import java.util.Properties;

public final class Config {
  private static final Properties P = new Properties();
  static {
    try {
      // 1) defaults from main resources
      try (InputStream in = ClassLoader.getSystemResourceAsStream("system.properties")) {
        if (in != null) P.load(in);
      }
      // 2) env-specific from test resources
      String env = System.getProperty("env", P.getProperty("env", "dev"));
      try (InputStream in = ClassLoader.getSystemResourceAsStream("config/" + env + ".properties")) {
        if (in != null) P.load(in);
      }
      // 3) JVM -D overrides already visible via System.getProperty
    } catch (Exception e) {
      throw new RuntimeException("Failed to load config", e);
    }
  }

  public static String get(String key) {
    return System.getProperty(key, P.getProperty(key));
  }

  public static int getInt(String key, int def) {
    String v = get(key);
    return v == null ? def : Integer.parseInt(v);
  }
}
