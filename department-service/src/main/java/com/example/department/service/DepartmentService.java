package com.example.department.service;

import com.example.department.entity.Department;
import com.example.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
        return this.departmentRepository.save(department);
    }

    public Department getById(Long id) {
        return this.departmentRepository.findById(id).orElseGet(null);
    }
}
