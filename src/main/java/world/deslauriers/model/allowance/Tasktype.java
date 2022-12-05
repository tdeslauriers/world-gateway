package world.deslauriers.model.allowance;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Set;

@Serdeable
public record Tasktype(
        Long id,
        @NonNull String name,
        @NonNull String cadence,
        Set<TasktypeAllowance> tasktypeAllowances,
        Set<Task> tasks
) {
}
