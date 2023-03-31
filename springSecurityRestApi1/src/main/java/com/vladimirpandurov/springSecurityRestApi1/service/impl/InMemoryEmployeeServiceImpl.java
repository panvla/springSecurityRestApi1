package com.vladimirpandurov.springSecurityRestApi1.service.impl;

import com.vladimirpandurov.springSecurityRestApi1.domain.Employee;
import com.vladimirpandurov.springSecurityRestApi1.repository.InMemoryEmployeeRepository;
import com.vladimirpandurov.springSecurityRestApi1.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier(value="inMemoryEmployeeService")
public class InMemoryEmployeeServiceImpl implements EmployeeService {

    private final InMemoryEmployeeRepository inMemoryEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return this.inMemoryEmployeeRepository.addEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.inMemoryEmployeeRepository.getAllEmployees();
    }

    @Override
    public Employee findById(Integer id) {
        return this.inMemoryEmployeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
      return  this.inMemoryEmployeeRepository.updateEmployee(employee);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return this.inMemoryEmployeeRepository.deleteById(id);
    }
}
