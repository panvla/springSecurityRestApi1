package com.vladimirpandurov.springSecurityRestApi1.controller;

import com.vladimirpandurov.springSecurityRestApi1.domain.Account;
import com.vladimirpandurov.springSecurityRestApi1.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.vladimirpandurov.springSecurityRestApi1.controller.EmployeeController.getLocation;

@RestController
@RequestMapping(path="/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account newAccount = accountService.createAccount(account);
        return ResponseEntity.created(getLocation(newAccount.getId().intValue())).body(newAccount);
    }

    @GetMapping
    public ResponseEntity<List<Account>>getAccount(){
        return ResponseEntity.ok(accountService.getAccounts());
    }

}
