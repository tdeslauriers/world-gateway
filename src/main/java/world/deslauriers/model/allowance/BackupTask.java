package world.deslauriers.model.allowance;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record BackupTask(
        Long id,
        String date,
        String complete,
        String satisfactory,
        String tasktypeId
) {
}
