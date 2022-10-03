package ru.epopov.legitcheckportal.security;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class UserManagementConfig {

  @Bean
  public UserDetailsService userDetailsService(DataSource dataSource) {
    String usersByUsernameQuery =
        "select username, password, enabled from users where username = ?";
    String authsByUserQuery = "select username, dtype from users where username = ?";
    JdbcUserDetailsManager detailsManager = new JdbcUserDetailsManager(dataSource);
    detailsManager.setUsersByUsernameQuery(usersByUsernameQuery);
    detailsManager.setAuthoritiesByUsernameQuery(authsByUserQuery);
    return detailsManager;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

}
