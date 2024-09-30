package com.helloIftekhar.springJwt.repository;

import com.helloIftekhar.springJwt.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Optional<Role> findByRoleName(String roleName);
}
