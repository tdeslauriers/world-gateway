package world.deslauriers.model.allowance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Set;

@Serdeable
public record Allowance(
        Long id,
        Double balance,
        Long userId,
        Set<TasktypeAllowance> tasktypeAllowances,
        Set<TaskAllowance> taskAllowances
) {
}
