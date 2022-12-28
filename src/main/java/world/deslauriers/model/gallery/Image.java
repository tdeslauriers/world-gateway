package world.deslauriers.model.gallery;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Set;

@Serdeable
public record Image(
        Long id,
        String filename, // string of UUID
        @Nullable String title,
        @Nullable String description,
        String date,
        @NonNull Boolean published,
        String thumbnail, // byte[] => base64 string from jackson
        String presentation, // byte[] => base64 string from jackson
        @Nullable String image, // byte[] => base64 string from jackson
        @Nullable Set<AlbumImage> albumImages
) {
}
