package com.tw.apistackbase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Company {

    @JsonIgnore
    private int id;
    private String companyName;
    private Integer employeesNumber;
    private List<Employee> employees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Company(int id, String companyName, Integer employeesNumber) {
        this.id = id;
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
    }

    public Company() {
    }

    public static List<Company> createTestCompanys() {
        Company company1 = new Company(1,"oocl", 100);
        Company company2 = new Company(2,"ooil", 200);
        List<Company> companies = new ArrayList<>();
        companies.add(company1);
        companies.add(company2);
        return companies;
    }

}
