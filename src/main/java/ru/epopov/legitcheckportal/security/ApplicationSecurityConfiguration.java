package ru.epopov.legitcheckportal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfiguration {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests((requests) -> requests
            .antMatchers("/api/v1/items/**")
            .hasAuthority("Customer"))
        .httpBasic()
        .and()
        .authorizeRequests((requests) -> requests
            .antMatchers("/api/v1/orders/**")
            .hasAuthority("LegitChecker"))
        .httpBasic();

    return http.build();
  }

  /*
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/items", "/items/**")
  }

   */

  @Bean
  public WebSecurityCustomizer ignoringCustomizer() throws Exception {
    return (web) -> web
        .ignoring()
        .antMatchers("/h2-console/**");
  }
}
