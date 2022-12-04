package world.deslauriers.model.auth;

import io.micronaut.core.annotation.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record PasswordsMatchCmd(
        @NonNull @NotBlank @Size(min = 16) String password,
        @NonNull @NotBlank @Size(min = 16) String confirmPassword
) {
}
