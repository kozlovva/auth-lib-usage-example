package ru.foodtechlab.authlibintegration.secure;

import com.rcore.domain.commons.usecase.UseCaseActor;
import com.rcore.domain.commons.usecase.model.SingleInput;
import com.rcore.rest.api.spring.security.CredentialPrincipal;
import com.rcore.rest.api.spring.security.CurrentCredential;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RequiredArgsConstructor
@Secured("ADMIN")
@RestController
public class SecureEndpoints {

    private final UseCaseExample useCaseExample;

    @GetMapping(value = "/api/v1/test")
    ResponseEntity<String> test(@ApiIgnore @CurrentCredential CredentialPrincipal currentCredential) {
        return ResponseEntity.ok("currentUserId=" + useCaseExample.execute(SingleInput.of(UseCaseActor.of(currentCredential.getId())))
                .getValue()
                .getId());
    }

}
