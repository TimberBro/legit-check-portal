package ru.epopov.legitcheck.authserver.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import ru.epopov.legitcheck.authserver.model.User;

public interface UserRepository extends CrudRepository<User, UUID> {

  Optional<User> findUserByUsername(String username);

}
