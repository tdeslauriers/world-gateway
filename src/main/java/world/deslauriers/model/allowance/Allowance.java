package world.deslauriers.model.allowance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Set;

@Serdeable
public record Allowance(
        Long id,
        Double balance,
        String userUuid,
        @Nullable Set<TasktypeAllowance> tasktypeAllowances,
        @Nullable Set<TaskAllowance> taskAllowances
) {
    public Allowance(Long id, Double balance, String userUuid) {
        this(id, balance, userUuid, null, null);
    }
}
