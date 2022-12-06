package world.deslauriers.model.gallery;

import io.micronaut.serde.annotation.Serdeable;

import java.util.HashSet;

@Serdeable
public record AlbumDto(
        String album,
        HashSet<Thumbnail> thumbnails
) {
}
