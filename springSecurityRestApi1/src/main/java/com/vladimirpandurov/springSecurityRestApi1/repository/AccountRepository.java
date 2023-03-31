package com.vladimirpandurov.springSecurityRestApi1.repository;

import com.vladimirpandurov.springSecurityRestApi1.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
