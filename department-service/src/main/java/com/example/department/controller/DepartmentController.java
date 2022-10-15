package com.example.department.controller;

import com.example.department.entity.Department;
import com.example.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department save(@RequestBody Department department) {
        log.info("Inside save department of DepartmentController");
        return this.departmentService.save(department);
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable("id") Long id) {
        log.info("Inside find department id of DepartmentController");
        return this.departmentService.getById(id);
    }
}
