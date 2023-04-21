package world.deslauriers.model.allowance;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record BackupTaskAllowance(
        Long id,
        String taskId,
        String allowanceId
) {
}
