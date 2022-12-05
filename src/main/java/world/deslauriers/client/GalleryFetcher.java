package world.deslauriers.client;

import io.micronaut.http.HttpResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.gallery.Album;
import world.deslauriers.model.gallery.Image;
import world.deslauriers.model.gallery.ImageUpdateCmd;
import world.deslauriers.model.gallery.Thumbnail;

public interface GalleryFetcher {

    // Images
    Mono<Image> getImage(String filename);
    Flux<Thumbnail> getAllUnpublished();
    Mono<HttpResponse> updateImage(ImageUpdateCmd imageUpdateCmd);
    Mono<HttpResponse> deleteImage(String filename);

    // albums
    Flux<Album> getAllAlbums();
    Mono<Album> getAlbumByName(String album);

    // backup
    Flux<Image> backupImages();

}
