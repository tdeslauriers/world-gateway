package world.deslauriers.model.auth;

import io.micronaut.core.annotation.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record RegisterCmd(

        @NonNull @NotBlank @Email @Size(max = 255) String username,
        @NonNull @NotBlank String password, // different size from db cuz raw
        @NonNull @NotBlank String confirmPassword,
        @NonNull @NotBlank @Size(min = 1, max = 32)String firstname,
        @NonNull @NotBlank @Size(min = 1, max = 32)String lastname
) {
}
