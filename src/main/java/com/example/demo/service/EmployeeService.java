package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> listEmployees();

    public Employee createEmployee(Employee employee);

    public Employee getById(Integer id);

    public void deleteById(Integer id);
}