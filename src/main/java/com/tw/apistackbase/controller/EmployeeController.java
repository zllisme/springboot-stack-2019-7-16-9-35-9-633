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
    public List<Employee> getEmployeeQueryPage(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize, @RequestParam(required = false) String gender) {
        List<Employee> resultEmployees = null;
        if(page != null&& pageSize != null && gender == null){
            return testEmployees.subList((page - 1 ) * pageSize, page * pageSize);
        }
        if(gender != null) {
            return testEmployees.stream().filter(e -> e.getGender().equals(gender)).collect(Collectors.toList());
        }
        return testEmployees;

    }

    @PostMapping
    public List<Employee> addEmployee(@RequestBody Employee employee) {
        testEmployees.add(employee);
        return testEmployees;
    }

    @PutMapping("/{id}")
    public List<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        for(Employee each : testEmployees) {
            if(each.getId() == id) {
                each.setAge(employee.getAge());
                each.setGender(employee.getGender());
                each.setId(id);
                each.setName(employee.getName());
                break;
            }
        }
        return testEmployees;
    }

    @DeleteMapping("/{id}")
    public List<Employee> deleteEmployee(@PathVariable int id) {
        for(Employee employee : testEmployees) {
            if(employee.getId() == id) {
                testEmployees.remove(employee);
                break;
            }
        }
        return testEmployees;
    }










}