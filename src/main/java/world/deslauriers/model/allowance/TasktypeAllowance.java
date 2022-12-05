package world.deslauriers.model.allowance;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record TasktypeAllowance(
        Long id,
        Tasktype tasktype,
        Allowance allowance
) {
}
