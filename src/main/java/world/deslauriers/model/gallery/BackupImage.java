package world.deslauriers.model.gallery;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotNull;

@Serdeable
public record BackupImage(
        @NotNull Long id,
        @NonNull String filename, // string of UUID
        @Nullable String title,
        @Nullable String description,
        @NonNull String date,
        @NonNull Boolean published,
        @Nullable String thumbnail,
        @Nullable String presentation,
        @Nullable String image
) {
}
