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

    @GetMapping("/{id}/employees")
    public List<Employee> getCompanyEmployee(@PathVariable int id) {
        return testCompanies.stream().filter(e -> e.getId() == id).collect(Collectors.toList()).get(0).getEmployees();
    }

    @PutMapping("/{id}")
    public List<Company> updateEmployee(@PathVariable int id, @RequestBody Company company) {
        for(Company each : testCompanies) {
            if(each.getId() == id) {
                each.setCompanyName(company.getCompanyName());
                each.setEmployeesNumber(company.getEmployeesNumber());
                each.setEmployees(company.getEmployees());
                break;
            }
        }
        return testCompanies;
    }

    @DeleteMapping("/{id}")
    public List<Company> deleteEmployee(@PathVariable int id) {
        for(Company company : testCompanies) {
            if(company.getId() == id) {
                testCompanies.remove(company);
                break;
            }
        }
        return testCompanies;
    }

    public void setTestCompanies(List<Company> testCompanies) {
        this.testCompanies = testCompanies;
    }
}
