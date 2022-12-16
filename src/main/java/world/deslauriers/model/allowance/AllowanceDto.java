package world.deslauriers.model.allowance;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Serdeable
public record AllowanceDto(

        Long id,
        @NonNull Double balance,
        @NonNull @NotBlank @Email @Size(max = 255) String username,
        @NonNull @NotBlank @Size(min = 1, max = 32) String firstname,
        @NonNull @NotBlank @Size(min = 1, max = 32) String lastname,
        @Nullable Integer age
) {
}
