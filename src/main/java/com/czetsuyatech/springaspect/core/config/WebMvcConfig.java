package com.czetsuyatech.springaspect.core.config;

import com.czetsuyatech.springaspect.core.security.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // register the interceptor
    registry.addInterceptor(securityInterceptor());
  }

  @Bean
  public SecurityInterceptor securityInterceptor() {
    return new SecurityInterceptor();
  }
}
