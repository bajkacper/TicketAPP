package com.service.TicketApp.dataInit;

import com.service.TicketApp.entity.UserTypes;
import com.service.TicketApp.entity.Users;
import com.service.TicketApp.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final UserRepository userRepository;
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Users admin = new Users();
        admin.setUsername("adminUser");
        admin.setEmail("admin@example.com");
        admin.setPassword("password");
        admin.setUserType(UserTypes.ADMIN);
        userRepository.save(admin);

        Users customer = new Users();
        customer.setUsername("customerUser");
        customer.setEmail("customer@example.com");
        customer.setPassword("password");
        customer.setUserType(UserTypes.CUSTOMER);
        userRepository.save(customer);
    }
}
