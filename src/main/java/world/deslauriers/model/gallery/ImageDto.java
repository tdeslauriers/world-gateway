package world.deslauriers.model.gallery;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Set;

@Serdeable
public record ImageDto(
        Long id,
        String filename, // string of UUID
        @Nullable String title,
        @Nullable String description,
        String date,
        @NonNull Boolean published,
        @Nullable Set<Album> albums, // moved up above long image byte array values for ease of reading in json
        byte[] thumbnail,
        byte[] presentation,
        @Nullable byte[] image
) {
}
