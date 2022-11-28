package world.deslauriers.model.auth;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Serdeable
public record LoginRequest(
        @NonNull @NotBlank @Email @Size(max = 255)String username,
        @NonNull @NotBlank @Size(max = 255)String password
) {
}
