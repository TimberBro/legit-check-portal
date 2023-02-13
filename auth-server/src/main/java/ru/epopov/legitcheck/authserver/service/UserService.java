package ru.epopov.legitcheck.authserver.service;

import java.util.Optional;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    Optional<User> optionalUser = this.findUserByUserName(user.getUsername());

    if (optionalUser.isEmpty()) {
      user.setUuid(UUID.randomUUID());
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      User save = userRepository.save(user);
      return save.getUuid();
    } else {
      throw new IllegalArgumentException("The username is already taken");
    }
  }

  public boolean authUser(User user) {
    Optional<User> foundUser = this.findUserByUserName(user.getUsername());

    if (foundUser.isPresent()) {
      return foundUser.get().getPassword().equals(user.getPassword());
    }
    return false;
  }
}
