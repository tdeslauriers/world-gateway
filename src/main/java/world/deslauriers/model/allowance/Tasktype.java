package world.deslauriers.model.allowance;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Set;

@Serdeable
public record Tasktype(
        @Nullable Long id,
        @NonNull String name,
        @NonNull String cadence,
        @NonNull String category,
        @NonNull Boolean archived, // jackson changes naming
        @Nullable Set<TasktypeAllowance> tasktypeAllowances,
        @Nullable Set<Task> tasks
) {
    public Tasktype(@NonNull String name, @NonNull String cadence, @NonNull String category, @NonNull Boolean archived) {
        this(null, name, cadence, category, archived, null, null);
    }
}
