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


    @GetMapping
    public List<Employee> getAllEmployees() {
        return testEmployees;
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return testEmployees.stream().filter(e -> e.getId() == id).collect(Collectors.toList()).get(0);
    }








}