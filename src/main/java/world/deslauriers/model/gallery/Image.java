package world.deslauriers.model.gallery;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.time.LocalDate;
import java.util.Set;

@Serdeable
public record Image(
        Long id,
        String filename, // string of UUID
        @Nullable String title,
        @Nullable String description,
        String date,
        @NonNull Boolean published,
        byte[] thumbnail,
        byte[] image,

        Set<AlbumImage> albumImages
) {
}
