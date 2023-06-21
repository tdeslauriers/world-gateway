package world.deslauriers.client;

import io.micronaut.http.HttpResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.gallery.*;

public interface GalleryFetcher {

    // Images
    Mono<Image> getImageByFilename(String filename);
    Mono<FullResolutionDto> getFullResolution(String filename);
    Flux<Thumbnail> getAllUnpublished();
    Mono<HttpResponse> updateImage(ImageUpdateCmd imageUpdateCmd);

    Mono<HttpResponse> deleteImage(String filename);

    // albums
    Flux<Album> getAllAlbums();
    Mono<AlbumDto> getAlbumByName(String album);

    // backup
    Flux<Long> listImageIds();
    Mono<Image> getImageById(Long id);

    // restore
    Mono<HttpResponse<?>> restoreAlbum(BackupAlbum backupAlbum);

    Mono<HttpResponse<?>> restoreImage(BackupImage backupImage);

    Mono<HttpResponse<?>> restoreAlbumImage(BackupAlbumImage backupAlbumImage);
}
