package world.deslauriers.model.gallery;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
@Serdeable
public record Thumbnail(
        Long id,
        String filename,
        @Nullable String title,
        @Nullable String description,
        String date,
        Boolean published,
        String thumbnail // []byte => base64 string from jackson
) {
}
