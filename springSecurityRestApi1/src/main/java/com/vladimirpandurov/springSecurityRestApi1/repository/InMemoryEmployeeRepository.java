package com.vladimirpandurov.springSecurityRestApi1.repository;

import com.vladimirpandurov.springSecurityRestApi1.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryEmployeeRepository {

    private static final List<Employee> DATABASE = new ArrayList<>();

    static {
        DATABASE.add(new Employee(1, "John", "Smith", "jogn@gmail.com"));
        DATABASE.add(new Employee(2, "Alex", "Raymond", "alex@gmail.com"));
        DATABASE.add(new Employee(3, "David", "Cameron", "david@gmail.com"));
    }

    public Employee addEmployee(Employee employee){
        DATABASE.add(employee);
        return employee;
    }

    public  List<Employee> getAllEmployees() {
        return List.copyOf(DATABASE);
    }

    public Employee findById(Integer id) {
        return DATABASE.stream().filter(emp -> id.equals(emp.getId())).findFirst().orElseThrow();
    }

    public Employee updateEmployee(Employee employee) {
           Employee updateEmployee = DATABASE.stream().filter(emp -> employee.getId().equals(emp.getId())).findFirst().get();
           if(updateEmployee!=null) {
               updateEmployee.setFirstName(employee.getFirstName());
               updateEmployee.setLastName(employee.getLastName());
               updateEmployee.setEmail(employee.getEmail());
           }
           return updateEmployee;
    }

    public Boolean deleteById(Integer id){
        Employee employee = DATABASE.stream().filter(emp -> id.equals(emp.getId())).findFirst().orElseThrow();
        DATABASE.remove(employee);
        return Boolean.TRUE;
    }

}
