package world.deslauriers.model.allowance;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record BackupTasktypeAllowance(
        String id,
        String tasktypeId,
        String allowanceId
) {
}
