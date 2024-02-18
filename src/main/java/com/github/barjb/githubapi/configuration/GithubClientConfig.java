package com.github.barjb.githubapi.configuration;

import com.github.barjb.githubapi.exception.FeignErrorDecoder;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GithubClientConfig {
  @Value("${githubToken}")
  private String token;

  @Bean
  public ErrorDecoder errorDecoder() {
    return new FeignErrorDecoder();
  }

  @Bean
  public RequestInterceptor basicAuthenticationInterceptor() {
    return requestTemplate -> requestTemplate.header("Authorization", "Bearer %s".formatted(token));
  }
}
