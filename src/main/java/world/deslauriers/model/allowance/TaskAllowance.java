package world.deslauriers.model.allowance;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record TaskAllowance(
        Long id,
        @Nullable Task task,
        @Nullable Allowance allowance
) {
}
