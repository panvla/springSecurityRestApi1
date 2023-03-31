package com.vladimirpandurov.springSecurityRestApi1.init;

import com.vladimirpandurov.springSecurityRestApi1.domain.Role;
import com.vladimirpandurov.springSecurityRestApi1.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

@Component
@RequiredArgsConstructor
public class ApplicationstartRunner implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

        Role roleUser = new Role(1L, "123", "ROLE_USER");
        Role roleAdmin = new Role(2L, "456", "ROLE_ADMIN");
        roleRepository.saveAll(asList(roleUser, roleAdmin));

    }
}
