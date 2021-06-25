package com.example.usersservice.service;

import com.example.usersservice.models.User;
import com.example.usersservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userEntityRepository;

    public User saveUser(User userEntity) {
        userEntity.setPassword((userEntity.getPassword()));
        return userEntityRepository.save(userEntity);
    }

    public User findByLogin(String email) {
        return userEntityRepository.findByEmail(email);
    }

    public User findByLoginAndPassword(String email, String password) {
        User userEntity = findByLogin(email);
        if (userEntity != null) {
            if (password.equals( userEntity.getPassword() )) {
                return userEntity;
            }
        }
        return null;
    }

}
