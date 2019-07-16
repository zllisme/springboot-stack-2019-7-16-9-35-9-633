package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}
