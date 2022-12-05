package world.deslauriers.model.gallery;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record AlbumImage(
        Long id,
        @Nullable Album album,
        @Nullable Image image
) {
}
