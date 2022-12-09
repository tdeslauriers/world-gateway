package world.deslauriers.model.allowance;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Set;

@Serdeable
public record Tasktype(
        Long id,
        @NonNull String name,
        @NonNull String cadence,
        @NonNull String category,
        @Nullable Set<TasktypeAllowance> tasktypeAllowances,
        @Nullable Set<Task> tasks
) {
}
