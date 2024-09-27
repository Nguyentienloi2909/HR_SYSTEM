package com.helloIftekhar.springJwt.service;


import com.helloIftekhar.springJwt.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String email);
    public List<User> getALlUser();
    public Boolean addUser(User user);
    public Boolean update(User user);
    public Boolean deleteUserByUsername(String username);

}
