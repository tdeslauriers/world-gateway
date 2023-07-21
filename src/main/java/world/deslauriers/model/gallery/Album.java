package world.deslauriers.model.gallery;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Serdeable
public record Album(
        @Nullable Long id,
        @NotNull String album,

        @Nullable String description,

        @Nullable Set<AlbumImage> albumImages
) {

    public Album(String album, @Nullable String description) {
        this(null, album, description, null);
    }

    public Album(Long id, String album, @Nullable String description) {
        this(id, album, description, null);
    }

    public Album(Long id, String album) {
        this(id, album, null, null);
    }
}
