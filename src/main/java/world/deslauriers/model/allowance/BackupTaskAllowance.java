package world.deslauriers.model.allowance;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record BackupTaskAllowance(
        String id,
        String taskId,
        String allowanceId
) {
}
