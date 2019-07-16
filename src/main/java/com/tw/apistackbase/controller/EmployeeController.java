package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    public List<Employee> testEmployees = Employee.createTestEmployees();


    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return testEmployees.stream().filter(e -> e.getId() == id).collect(Collectors.toList()).get(0);
    }

    @GetMapping
    public List<Employee> getEmployeeQueryPage(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize) {
        return page != null&& pageSize != null ? testEmployees.subList((page - 1 ) * pageSize, page * pageSize) : testEmployees;
    }










}