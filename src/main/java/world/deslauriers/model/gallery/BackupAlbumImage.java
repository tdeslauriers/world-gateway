package world.deslauriers.model.gallery;

import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotNull;

@Serdeable
public record BackupAlbumImage(
    @NotNull Long id,
    @NotNull Long album_id,
    @NotNull Long image_id
) {
}
