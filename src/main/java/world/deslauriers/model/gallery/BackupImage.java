package world.deslauriers.model.gallery;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Serdeable
public record BackupImage(
        @NotNull Long id,
        @NonNull String filename, // string of UUID
        @Nullable String title,
        @Nullable String description,
        @JsonFormat(pattern="yyyy-MM-dd") @NonNull LocalDate date,
        @NonNull Boolean published,
        @NotNull byte[] thumbnail,
        @NotNull byte[] presentation,
        @NotNull byte[] image
) {
}
