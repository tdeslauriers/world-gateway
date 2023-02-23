package world.deslauriers.model.auth;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Serdeable
public record ResetPasswordCmd(
        @NonNull @NotBlank @Size(min = 12) String current, // different size from db cuz raw
        @NonNull @NotBlank @Size(min = 12) String updated,
        @NonNull @NotBlank @Size(min = 12) String confirm
        ) {
}
