package org.portafiolio.streaming.service;

import org.portafiolio.streaming.exeption.ResourceNotFoundException;
import org.portafiolio.streaming.model.User;
import org.portafiolio.streaming.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
    }
    
    public User createUser(User user){
        return userRepository.save(user);
    }
    
    public User updateUser(Long id,User user){
        User existingUser = userRepository.
                findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User not found"));
        existingUser.setUsername(user.getUsername());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setLanguageId(user.getLanguageId());
        
        return userRepository.save(existingUser);
    }
    
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
