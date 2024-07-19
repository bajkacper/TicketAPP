package com.service.TicketApp.service;

import com.service.TicketApp.entity.Users;
import com.service.TicketApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private final UserRepository userRepository;
    @Autowired
    public AdminService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<Users> getUserList(){
        return userRepository.findAll();
    }
    public Optional<Users> getUser(Long id){
        return userRepository.findById(id);
    }
    public Users putUser(Long id, Users userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setUserName(userDetails.getUserName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setUserType(userDetails.getUserType());
            return userRepository.save(user);
        }).orElseGet(() -> {
            userDetails.setId(id);
            return userRepository.save(userDetails);
        });
    }

    public Users postUser(Users user) {
        return userRepository.save(user);
    }

    public void deleteAccount(Long id) {
        userRepository.deleteById(id);
    }
}
