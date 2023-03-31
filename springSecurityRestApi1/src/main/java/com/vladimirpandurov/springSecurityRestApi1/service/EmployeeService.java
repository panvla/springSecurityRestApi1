package com.vladimirpandurov.springSecurityRestApi1.service;

import com.vladimirpandurov.springSecurityRestApi1.domain.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee findById(Integer id);

    Employee updateEmployee(Employee employee);

    Boolean deleteById(Integer id);

}
