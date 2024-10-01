package com.helloLoiNguyen.springJwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Department extends JpaRepository<Department, Integer> {
    public Optional<Department> findByDepartmentName(String departmentName);
}
