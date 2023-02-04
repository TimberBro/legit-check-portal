package ru.epopov.legitcheck.authserver.service;

import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import ru.epopov.legitcheck.authserver.model.User;
import ru.epopov.legitcheck.authserver.repository.UserRepository;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Optional<User> findUserByUserName(String username) {
    return userRepository.findUserByUsername(username);
  }

  public UUID addUser(User user) {
    user.setUuid(UUID.randomUUID());
    User save = userRepository.save(user);
    return save.getUuid();
  }
}
