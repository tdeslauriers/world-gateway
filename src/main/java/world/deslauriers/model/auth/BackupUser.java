package world.deslauriers.model.auth;

import io.micronaut.serde.annotation.Serdeable;

import java.time.LocalDate;

@Serdeable
public record BackupUser(
        Long id,
        String username,
        String password,
        String firstname,
        String lastname,
        LocalDate dateCreated,
        Boolean enabled,
        Boolean accountExpired,
        Boolean accountLocked,
        LocalDate birthday,
        String uuid
) {
}
