package com.czetsuyatech.springaspect.web.config;

import com.czetsuyatech.springaspect.web.security.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
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
