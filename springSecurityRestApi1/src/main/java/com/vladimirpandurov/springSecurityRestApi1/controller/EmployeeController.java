package com.vladimirpandurov.springSecurityRestApi1.controller;

import com.vladimirpandurov.springSecurityRestApi1.domain.Employee;
import com.vladimirpandurov.springSecurityRestApi1.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(@Qualifier(value="mySQLEmployeeService")EmployeeService employeeService){
      this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        return ResponseEntity.ok(this.employeeService.getAllEmployees());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id){
        return ResponseEntity.ok(this.employeeService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        //employee.setId(this.employeeService.getAllEmployees().size() + 1);
        return ResponseEntity.created(getLocation(employee.getId())).body(this.employeeService.addEmployee(employee));
    }
    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(this.employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Integer id){
        return ResponseEntity.ok(this.employeeService.deleteById(id));
    }

    protected static URI getLocation(Integer id){
        return ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }


}
