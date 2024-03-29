package ru.epopov.legitcheck.authserver.controller;

import java.util.Optional;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.epopov.legitcheck.authserver.model.User;
import ru.epopov.legitcheck.authserver.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class AuthController {

  private final UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/add")
  public UUID addUser(@RequestBody User user) {
    try {
      return userService.addUser(user);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @PostMapping("/auth")
  public ResponseEntity<String> authUser(@RequestBody User user) {
    if (userService.authUser(user)) {
      return ResponseEntity.ok().body("Ok");
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not authorized");
    }
  }
}
