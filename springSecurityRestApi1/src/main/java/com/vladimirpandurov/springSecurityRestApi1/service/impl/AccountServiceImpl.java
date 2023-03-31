package com.vladimirpandurov.springSecurityRestApi1.service.impl;

import com.vladimirpandurov.springSecurityRestApi1.domain.Account;
import com.vladimirpandurov.springSecurityRestApi1.domain.Role;
import com.vladimirpandurov.springSecurityRestApi1.repository.AccountRepository;
import com.vladimirpandurov.springSecurityRestApi1.repository.RoleRepository;
import com.vladimirpandurov.springSecurityRestApi1.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    @Override
    public Account createAccount(Account account) {
        account.setPassword(encoder.encode(account.getPassword()));
        Role role = this.roleRepository.findByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        account.setRoles(roles);
        return this.accountRepository.save(account);
    }

    @Override
    public Account findByUsername(String username) {
        return this.accountRepository.findByUsername(username);
    }

    @Override
    public List<Account> getAccounts() {
        return this.accountRepository.findAll();
    }
}
