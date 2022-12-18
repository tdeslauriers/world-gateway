package world.deslauriers.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record UserPhone(
        Long id,
        @JsonIgnore @Nullable User user,
        @Nullable Phone phone
) {
}
