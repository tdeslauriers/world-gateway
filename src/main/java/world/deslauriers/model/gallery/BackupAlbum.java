package world.deslauriers.model.gallery;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record BackupAlbum(
        Long id,
        String album
) {
}
