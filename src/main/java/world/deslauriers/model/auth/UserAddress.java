package world.deslauriers.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record UserAddress(
        Long id,
        @JsonIgnore @Nullable User user,
        @Nullable Address address
) {
}
