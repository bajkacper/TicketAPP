package com.service.TicketApp.dataInit;

import com.service.TicketApp.entity.UserTypes;
import com.service.TicketApp.entity.Users;
import com.service.TicketApp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataLoader implements CommandLineRunner {
    private final UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createUserIfNotExist("adminUser", "admin@example.com", "Admin", "password", UserTypes.ADMIN);
        createUserIfNotExist("customerUser", "customer@example.com", "Customer", "password", UserTypes.CUSTOMER);
    }

    private void createUserIfNotExist(String userName, String email, String lastName, String password, UserTypes userType) {
        Optional<Users> existingUser = userRepository.findByEmail(email);
        if (existingUser.isEmpty()) {
            Users user = new Users();
            user.setUserName(userName);
            user.setEmail(email);
            user.setLastName(lastName);
            user.setPassword(password);
            user.setUserType(userType);
            user.setActivated(true);
            user.setVerification("123456");
            userRepository.save(user);
        }
    }
}
