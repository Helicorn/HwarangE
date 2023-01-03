package com.hwarang.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

   @Bean
   public CorsFilter corsFilter() {
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowCredentials(true);
      config.addAllowedOrigin("*"); //모든 ip
      config.addAllowedHeader("*"); //모든 header
      config.addAllowedMethod("*"); //모든 http method 허용

     // source.registerCorsConfiguration("/user/**", config); // api/** 를 통하는 모든 요청이 config를 따름
      source.registerCorsConfiguration("/user/**", config); // api/** 를 통하는 모든 요청이 config를 따름
      return new CorsFilter(source);
   }

}