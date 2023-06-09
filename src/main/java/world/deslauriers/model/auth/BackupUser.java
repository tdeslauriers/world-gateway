package world.deslauriers.model.auth;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record BackupUser(
        Long id,
        String username,
        String password,
        String firstname,
        String lastname,
        String dateCreated,
        Boolean enabled,
        Boolean accountExpired,
        Boolean accountLocked,
        @Nullable String birthday,
        String uuid
) {
}
