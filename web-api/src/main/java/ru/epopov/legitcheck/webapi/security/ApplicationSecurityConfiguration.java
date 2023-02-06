package ru.epopov.legitcheck.webapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfiguration {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/h2-console/**")
        .permitAll()
        .and()
        .authorizeRequests()
        .antMatchers("/items", "/items/**")
        .hasAuthority("Customer")
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();

    return http.build();
  }
}
