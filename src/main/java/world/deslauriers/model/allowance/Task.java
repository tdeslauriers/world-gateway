package world.deslauriers.model.allowance;

import io.micronaut.serde.annotation.Serdeable;

import java.util.Set;

@Serdeable
public record Task(
        Long id,
        String date,
        Boolean complete,
        Boolean satisfactory,
        Tasktype tasktype,
        Set<TaskAllowance> taskAllowances
) {

}
