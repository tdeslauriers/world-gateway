package world.deslauriers.model.auth;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.Size;

@Serdeable
public record Phone(
        @Nullable Long id,
        @NonNull @Size(min = 9, max = 32) String phone,
        @NonNull  @Size(min = 4, max= 4) String type

) {
        public Phone(@NonNull String phone, @NonNull String type) {
                this(null, phone, type);
        }
}
