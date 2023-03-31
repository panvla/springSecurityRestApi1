package com.vladimirpandurov.springSecurityRestApi1.repository;

import com.vladimirpandurov.springSecurityRestApi1.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<Employee, Integer> {



}
