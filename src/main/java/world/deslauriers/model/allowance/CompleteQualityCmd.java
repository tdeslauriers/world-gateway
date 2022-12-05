package world.deslauriers.model.allowance;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record CompleteQualityCmd(
        @NonNull Long taskId,
        @NonNull Boolean status
) {
}
