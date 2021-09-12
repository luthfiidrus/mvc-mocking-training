package ardi.springintro.model.swapi;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("swapiclient")
public class SwapiConfig {
  String host;

  public SwapiConfig() {
  }

  public SwapiConfig(String host) {
    this.host = host;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }
}
