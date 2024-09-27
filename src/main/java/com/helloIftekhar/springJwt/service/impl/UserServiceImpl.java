package com.helloIftekhar.springJwt.service.impl;

import com.helloIftekhar.springJwt.model.User;
import com.helloIftekhar.springJwt.repository.UserRepository;
import com.helloIftekhar.springJwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<User> findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public List<User> getALlUser() {
        return this.userRepository.findAll();
    }


    @Override
    @Transactional
    public Boolean addUser(User user) {
        try {
            this.userRepository.save(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean update(User user) {
        try {
            this.userRepository.saveAndFlush(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean deleteUserByUsername(String username) {
        try {
            this.userRepository.deleteByUsername(username);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


}
