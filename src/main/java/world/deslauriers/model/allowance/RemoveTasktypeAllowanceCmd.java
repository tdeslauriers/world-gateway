package world.deslauriers.model.allowance;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record RemoveTasktypeAllowanceCmd(
        Long tasktypeId,
        Long allowanceId
) {
}
