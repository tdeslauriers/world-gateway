package world.deslauriers.model.gallery;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record BackupAlbum(
        Long id,
        String album,
        @Nullable String description
) {
    public BackupAlbum(Long id, String album) {
        this(id, album, null);
    }
}
