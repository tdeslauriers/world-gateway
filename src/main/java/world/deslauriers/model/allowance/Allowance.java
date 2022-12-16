package world.deslauriers.model.allowance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Set;

@Serdeable
public record Allowance(
        Long id,
        Double balance,
        Long userId,
        @Nullable Set<TasktypeAllowance> tasktypeAllowances,
        @Nullable Set<TaskAllowance> taskAllowances
) {
}
