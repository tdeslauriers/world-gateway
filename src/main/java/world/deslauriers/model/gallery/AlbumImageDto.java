package world.deslauriers.model.gallery;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotNull;

@Serdeable
public record AlbumImageDto(
    @Nullable Long id,
    @NotNull Long album_id,
    @NotNull Long image_id
) {
    public AlbumImageDto(Long album_id, Long image_id) {
        this(null, album_id, image_id);
    }
}
