package world.deslauriers.model.gallery;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.HashSet;

@Serdeable
public record AlbumDto(
        String album,
        @Nullable String description,
        HashSet<Thumbnail> thumbnails
) {
    public AlbumDto(String album, HashSet<Thumbnail> thumbnails) {
        this(album, null, thumbnails);
    }
}
