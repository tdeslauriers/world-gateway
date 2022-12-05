package world.deslauriers.model.allowance;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record AssignTaskCmd(
        @NonNull Long allowanceId,
        @NonNull Long tasktypeId
) {
}
