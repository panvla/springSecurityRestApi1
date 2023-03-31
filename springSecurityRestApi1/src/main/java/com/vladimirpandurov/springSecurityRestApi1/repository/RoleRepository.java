package com.vladimirpandurov.springSecurityRestApi1.repository;

import com.vladimirpandurov.springSecurityRestApi1.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
