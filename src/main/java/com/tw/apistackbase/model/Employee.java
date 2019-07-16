package com.tw.apistackbase.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int id;
    private int age;
    private String name;
    private String gender;

    public Employee() {
    }

    public Employee(int id, int age, String name, String gender) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public static List<Employee> createTestEmployees() {
        Employee employee = new Employee(1, 12, "Jasmine", "female");
        Employee employee2 = new Employee(2, 13, "Berio", "male");
        Employee employee3 = new Employee(3, 14, "Ray", "male");

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee2);
        employees.add(employee3);
        return employees;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
