package com.helloLoiNguyen.springJwt.service;

import com.helloLoiNguyen.springJwt.repository.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Optional<Department> findByDepartmentName(String departmentName);
    public List<Department> getAllDepartment();

    public boolean addDepartment(Department department);

}
