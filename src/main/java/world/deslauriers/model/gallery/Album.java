package world.deslauriers.model.gallery;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Serdeable
public record Album(
        Long id,
        @NotNull String album,
        @Nullable Set<AlbumImage> albumImages
) {
    public Album(Long id, String album) {
        this(id, album, null);
    }
}
