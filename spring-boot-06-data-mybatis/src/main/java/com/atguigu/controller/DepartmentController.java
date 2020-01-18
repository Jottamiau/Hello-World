package com.atguigu.controller;

import com.atguigu.bean.Department;
import com.atguigu.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentMapper departmentMapper;

    @PutMapping("/dept/insert")
    public Department insertDepartment(@RequestBody @Validated Department department) {
        departmentMapper.insertDepartment(department);
        return department;
    }

    @GetMapping("/dept/query/{id}")
    public Department insertDepartment(@PathVariable(required = true) Integer id) {
        Department department = departmentMapper.getDepartmentById(id);
        return department;
    }

    @PostMapping("/dept/update")
    public Department updateDepartment(@RequestBody @Validated Department department) {
        departmentMapper.updateDepartment(department);
        return department;
    }

    @DeleteMapping("/dept/delete/{id}")
    public int deleteDepartment(@PathVariable(required = true) Integer id) {
        int count = departmentMapper.deleteDepartmentById(id);
        return count;
    }
}
