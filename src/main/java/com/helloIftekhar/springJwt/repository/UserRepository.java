package com.helloIftekhar.springJwt.repository;

import com.helloIftekhar.springJwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

//    @Query("select u from User u where u. like %?1%")
//    public List<User> findByFullName(String fullName);

    public void deleteByUsername(String username);
}
