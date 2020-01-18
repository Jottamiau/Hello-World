package com.atguigu.controller;

import com.atguigu.bean.Employee;
import com.atguigu.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/emp/query/{id}")
    public Employee getEmployeeById(@PathVariable(required = true) Integer id) {
        Employee employee = employeeMapper.getEmployeeById(id);
        return employee;
    }

    @PutMapping("/emp")
    public Employee insertEmployee(Employee employee){
        employeeMapper.insertEmployee(employee);
        return employee;
    }
}
