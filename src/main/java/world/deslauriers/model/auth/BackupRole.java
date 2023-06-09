package world.deslauriers.model.auth;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record BackupRole(
        Long id,
        String role,
        String title,
        String description
) {
}
