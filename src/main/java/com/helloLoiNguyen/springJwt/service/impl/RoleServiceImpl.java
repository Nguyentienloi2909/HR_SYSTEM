package com.helloLoiNguyen.springJwt.service.impl;

import com.helloLoiNguyen.springJwt.model.Role;
import com.helloLoiNguyen.springJwt.repository.RoleRepository;
import com.helloLoiNguyen.springJwt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findByRoleName(String roleName) {
        return this.roleRepository.findByRoleName(roleName);
    }

    @Override
    @Transactional
    public boolean addRole(Role role) {
        try {
            this.roleRepository.save(role);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
