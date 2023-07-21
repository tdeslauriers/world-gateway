package world.deslauriers.client;

import io.micronaut.http.HttpResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.gallery.*;

public interface GalleryFetcher {

    // Images
    Mono<ImageDto> getImageByFilename(String filename);
    Mono<FullResolutionDto> getFullResolution(String filename);
    Flux<Thumbnail> getAllUnpublished();
    Mono<HttpResponse> updateImage(ImageUpdateCmd imageUpdateCmd);

    Mono<HttpResponse> deleteImage(String filename);

    Mono<HttpResponse<?>> deleteAlbumImage(AlbumImageDto cmd);

    // albums
    Flux<Album> getAllAlbums();
    Flux<Thumbnail> getAlbumByName(String album);
    Mono<HttpResponse<Album>> saveAlbum(Album album);

    Mono<HttpResponse<?>> updateAlbum(Album album);
    // backup
    Flux<Long> listImageIds();

    Mono<Image> getImageById(Long id);
    // restore

    Mono<HttpResponse<?>> restoreAlbum(BackupAlbum backupAlbum);

    Mono<HttpResponse<?>> restoreImage(BackupImage backupImage);

    Mono<HttpResponse<?>> restoreAlbumImage(AlbumImageDto backupAlbumImage);
}
