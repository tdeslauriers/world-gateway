package world.deslauriers.model.gallery;

import io.micronaut.serde.annotation.Serdeable;

import java.util.Set;

@Serdeable
public record ImageUpdateCmd(
        String filename, // uuid
        String title,
        String description,
        Boolean published,
        Set<Album> albums
) {
}
