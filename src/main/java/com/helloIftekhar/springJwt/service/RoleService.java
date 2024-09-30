package com.helloIftekhar.springJwt.service;

import com.helloIftekhar.springJwt.model.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByRoleName(String roleName);
    public boolean addRole(Role role);
}
