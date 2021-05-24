package ru.foodtechlab.authlibintegration.config;

import com.rcore.domain.auth.credential.config.CredentialConfig;
import com.rcore.domain.auth.credential.entity.CredentialEntity;
import com.rcore.domain.auth.credential.port.CredentialRepository;
import com.rcore.domain.auth.credential.usecases.CreateCredentialUseCase;
import com.rcore.domain.auth.role.config.RoleConfig;
import com.rcore.domain.auth.role.entity.RoleEntity;
import com.rcore.domain.auth.role.port.RoleRepository;
import com.rcore.domain.auth.role.usecases.CreateRoleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Configuration
public class InitData implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final RoleConfig roleConfig;
    private final CredentialConfig credentialConfig;
    private final CredentialRepository credentialRepository;

    @Override
    public void run(String... args) throws Exception {

        if (credentialRepository.count() > 0)
            return;

        var role = roleConfig.createRoleUseCase().execute(CreateRoleUseCase.InputValues.builder()
                .name("ADMIN")
                .hasBoundlessAccess(false)
                .availableAuthTypes(Collections.singletonList(RoleEntity.AuthType.PASSWORD))
                .build())
                .getEntity();
        credentialConfig.createCredentialUseCase()
                .execute(CreateCredentialUseCase.InputValues.builder()
                        .username("test")
                        .password("test")
                        .status(CredentialEntity.Status.ACTIVE)
                        .roles(Collections.singletonList(CreateCredentialUseCase.InputValues.Role.builder()
                                .roleId(role.getId())
                                .isBlocked(false)
                                .build()))
                        .build())
                .getEntity();
    }
}
