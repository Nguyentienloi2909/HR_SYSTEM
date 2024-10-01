package com.helloLoiNguyen.springJwt.controller;

import com.helloLoiNguyen.springJwt.model.Role;
import com.helloLoiNguyen.springJwt.model.User;
import com.helloLoiNguyen.springJwt.service.RoleService;
import com.helloLoiNguyen.springJwt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/account")
public class AdminAccountController {
    public static final Logger logger = LoggerFactory.getLogger(AdminAccountController.class);
    private UserService userService;
    private RoleService roleService;

    public AdminAccountController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
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

    @PutMapping(value="updateAccount/{username}")
    public ResponseEntity<User> updateAccount(@PathVariable String username,
                                              @RequestBody User request) {

        Optional<User> userOptional = this.userService.findByUsername(username);
        if (!userOptional.isPresent()) {
            return ResponseEntity.notFound().build(); // Return 404 if user is not found
        }

        User user = userOptional.get();

        // Update user details
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setPassword(request.getPassword());
        Role role = roleService.findByRoleName(request.getRole().getRoleName()).get();
        user.setRole(role);
        user.setDepartment( request.getDepartment());
        // Try updating the user in the database
        Boolean updateUser = this.userService.update(user);

        // Return the updated user if successful, otherwise return 500 with error message
        return updateUser ? ResponseEntity.ok(user)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(null); // Use proper status code
    }

}
