package com.vladimirpandurov.springSecurityRestApi1.service.impl;

import com.vladimirpandurov.springSecurityRestApi1.domain.Employee;
import com.vladimirpandurov.springSecurityRestApi1.repository.JpaEmployeeRepository;
import com.vladimirpandurov.springSecurityRestApi1.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier(value="mySQLEmployeeService")
public class JpaEmployeeServiceImpl implements EmployeeService {

    private final JpaEmployeeRepository jpaEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return this.jpaEmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.jpaEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return this.jpaEmployeeRepository.findById(id).get();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return this.jpaEmployeeRepository.save(employee);
    }

    @Override
    public Boolean deleteById(Integer id) {
        this.jpaEmployeeRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
