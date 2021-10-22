package com.example.demo.service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> listEmployees() {
        List<Employee> employeeList=employeeDao.findAll();
        return employeeList;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public Employee getById(Integer id) {
        return employeeDao.getById(id);
    }

    @Override
    public void deleteById(Integer id) {

        employeeDao.deleteById(id);
    }
}