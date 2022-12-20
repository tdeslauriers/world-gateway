package world.deslauriers.model.allowance;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record TasktypeAllowance(
        Long id,
        @Nullable Tasktype tasktype,
        Allowance allowance
) {
}
