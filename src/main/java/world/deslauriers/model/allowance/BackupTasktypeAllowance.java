package world.deslauriers.model.allowance;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record BackupTasktypeAllowance(
        Long id,
        String tasktypeId,
        String allowanceId
) {
}
