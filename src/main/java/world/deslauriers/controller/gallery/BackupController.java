package world.deslauriers.controller.gallery;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import reactor.core.publisher.Flux;
import world.deslauriers.client.GalleryFetcher;
import world.deslauriers.model.gallery.Image;

@Secured({"COLD_STORAGE"})
@Controller("/gallery/backup")
public class BackupController {

    protected final GalleryFetcher galleryFetcher;

    public BackupController(GalleryFetcher galleryFetcher) {
        this.galleryFetcher = galleryFetcher;
    }

    @Get("/list")
    Flux<Long> listImageIds(){
        return galleryFetcher.listImageIds();
    }
}
