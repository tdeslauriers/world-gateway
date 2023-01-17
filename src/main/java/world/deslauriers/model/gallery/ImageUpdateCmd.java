package world.deslauriers.model.gallery;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ImageUpdateCmd(
        Long id,
        String title,
        String description,
        Boolean published
) {
}
