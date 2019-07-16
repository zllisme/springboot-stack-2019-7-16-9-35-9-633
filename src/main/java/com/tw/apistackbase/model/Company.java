package com.tw.apistackbase.model;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private String companyName;
    private Integer employeesNumber;
    private List<Employee> employees;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(Integer employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Company(String companyName, Integer employeesNumber) {
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
    }

    public Company() {
    }

    public static List<Company> createTestCompanys() {
        Company company1 = new Company("oocl", 100);
        Company company2 = new Company("ooil", 200);
        List<Company> companies = new ArrayList<>();
        companies.add(company1);
        companies.add(company2);
        return companies;
    }

}
