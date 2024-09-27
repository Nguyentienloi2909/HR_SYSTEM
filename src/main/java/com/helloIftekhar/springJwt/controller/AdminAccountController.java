package com.helloIftekhar.springJwt.controller;

import com.helloIftekhar.springJwt.model.User;
import com.helloIftekhar.springJwt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/account")
public class AdminAccountController {
    public static final Logger logger = LoggerFactory.getLogger(AdminAccountController.class);
    private UserService userService;
    @Autowired
    public AdminAccountController(UserService userService) {
        this.userService = userService;
    }
    // rest api
    @GetMapping(value = "getUserByUsername/{username}", produces = "application/json")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = this.userService.findByUsername(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "getAllAccount", produces = "application/json")
    public ResponseEntity<List<User>> getAllAccount() {
        List<User> users = this.userService.getALlUser();
        return ResponseEntity.ok(users);
    }


}
