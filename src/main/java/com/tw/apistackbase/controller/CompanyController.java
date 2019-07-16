package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    public List<Company> testCompanies = Company.createTestCompanys();

    @GetMapping
    public List<Company> getCompanysQueryPage(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize) {
        return page != null && pageSize != null ? testCompanies.subList((page - 1) * pageSize, page * pageSize) : testCompanies;
    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable int id) {
        return testCompanies.stream().filter(e -> e.getId() == id).collect(Collectors.toList()).get(0);
    }

    @PostMapping
    public List<Company> addCompany(@RequestBody Company company) {
        testCompanies.add(company);
        return testCompanies;
    }



}
