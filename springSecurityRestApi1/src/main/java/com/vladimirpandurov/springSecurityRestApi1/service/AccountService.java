package com.vladimirpandurov.springSecurityRestApi1.service;

import com.vladimirpandurov.springSecurityRestApi1.domain.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    Account findByUsername(String username);
    List<Account> getAccounts();
}
