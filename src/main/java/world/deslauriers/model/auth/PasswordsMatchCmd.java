package world.deslauriers.model.auth;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Serdeable
public record PasswordsMatchCmd(
        @NonNull @NotBlank @Size(min = 12) String password,
        @NonNull @NotBlank @Size(min = 12) String confirmPassword
) {
}
