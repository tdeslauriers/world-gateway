package world.deslauriers.model.allowance;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record TasktypeAllowance(
        @Nullable Long id,
        @Nullable Tasktype tasktype,
        Allowance allowance
) {
    public TasktypeAllowance(Allowance allowance) {
        this(null, null, allowance);
    }
}
