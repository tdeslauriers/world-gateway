package world.deslauriers.model.gallery;

import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Serdeable
public record Album(
        Long id,
        @NotNull String album,
        Set<AlbumImage> albumImages
) {
}
