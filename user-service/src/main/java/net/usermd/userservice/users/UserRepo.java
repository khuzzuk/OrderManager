package net.usermd.userservice.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<RegisteredUser, Long> {
    Optional<RegisteredUser> getByUsername(@Param("userName") String userName);

    boolean existsByUsername(String username);
}
