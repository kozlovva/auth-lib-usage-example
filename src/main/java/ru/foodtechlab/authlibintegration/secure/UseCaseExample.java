package ru.foodtechlab.authlibintegration.secure;

import com.rcore.domain.commons.usecase.UseCase;
import com.rcore.domain.commons.usecase.UseCaseActor;
import com.rcore.domain.commons.usecase.model.SingleInput;
import com.rcore.domain.commons.usecase.model.SingleOutput;
import org.springframework.stereotype.Component;

@Component
public class UseCaseExample extends UseCase<SingleInput<UseCaseActor>, SingleOutput<UseCaseActor>> {

    @Override
    public SingleOutput<UseCaseActor> execute(SingleInput<UseCaseActor> useCaseActorSingleInput) {
        return SingleOutput.of(useCaseActorSingleInput.getValue());
    }
}
