package world.deslauriers.controller.gallery;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import reactor.core.publisher.Mono;
import world.deslauriers.client.GalleryFetcher;
import world.deslauriers.model.gallery.BackupAlbum;
import world.deslauriers.model.gallery.AlbumImageDto;
import world.deslauriers.model.gallery.BackupImage;

@Secured({"COLD_STORAGE"})
@Controller("/gallery/restore")
public class RestoreController {

    private final GalleryFetcher galleryFetcher;

    public RestoreController(GalleryFetcher galleryFetcher) {
        this.galleryFetcher = galleryFetcher;
    }

    @Post("/album")
    public Mono<HttpResponse<?>> restoreAlbum(@Body BackupAlbum backupAlbum){
        return galleryFetcher.restoreAlbum(backupAlbum);
    }

    @Post("/image")
    public Mono<HttpResponse<?>> restoreImage(@Body BackupImage backupImage){
        return galleryFetcher.restoreImage(backupImage);
    }

    @Post("/album_image")
    public Mono<HttpResponse<?>> restoreAlbumImage(@Body AlbumImageDto backupAlbumImage){
        return galleryFetcher.restoreAlbumImage(backupAlbumImage);
    }
}
