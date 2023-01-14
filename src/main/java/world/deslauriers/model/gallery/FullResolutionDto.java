package world.deslauriers.model.gallery;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record FullResolutionDto (
        String filename,
        byte[] image
) {
}
