package net.usermd.userservice.users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class UserInitializer {
    private UserRepo userRepo;

    @PostConstruct
    public void addAdminUser() {
        if (!userRepo.existsByUsername("admin")) {
            RegisteredUser user = new RegisteredUser();
            user.setUsername("admin");
            user.setPassword("admin");
            userRepo.save(user);
        }
    }
}
