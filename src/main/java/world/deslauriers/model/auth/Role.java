package world.deslauriers.model.auth;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Serdeable
public record Role(
        @Nullable Long id,
        @NotNull @NotBlank @Size(min = 2, max = 32) String role,
        @NotNull @NotBlank @Size(min = 2, max = 32) String title,
        @NotNull @NotBlank @Size(min = 2, max = 64) String description

) {
        public Role(String role, String title, String description) {
                this(null, role, title, description);
        }
}
