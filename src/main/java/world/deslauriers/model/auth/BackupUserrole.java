package world.deslauriers.model.auth;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record BackupUserrole(
        Long id,
        Long userId,
        Long roleId
) {
}
