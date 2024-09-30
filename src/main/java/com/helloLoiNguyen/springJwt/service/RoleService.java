package com.helloLoiNguyen.springJwt.service;

import com.helloLoiNguyen.springJwt.model.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByRoleName(String roleName);
    public boolean addRole(Role role);
}
