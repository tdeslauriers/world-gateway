package world.deslauriers.model.allowance;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record BackupTasktype(
        Long id,
        String name,
        String cadence,
        String category,
        String archived
) {
}
