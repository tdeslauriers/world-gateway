package world.deslauriers.model.allowance;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record BackupAllowance(
        Long userId,
        String balance,
        String userUuid
) {
}
