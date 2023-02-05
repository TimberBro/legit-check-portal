package ru.epopov.legitcheck.authserver.service;

import java.util.Optional;
import java.util.UUID;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.epopov.legitcheck.authserver.model.User;
import ru.epopov.legitcheck.authserver.repository.UserRepository;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public Optional<User> findUserByUserName(String username) {
    return userRepository.findUserByUsername(username);
  }

  public UUID addUser(User user) {
    user.setUuid(UUID.randomUUID());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    User save = userRepository.save(user);
    return save.getUuid();
  }
}
