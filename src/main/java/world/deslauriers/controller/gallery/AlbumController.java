package world.deslauriers.controller.gallery;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.client.GalleryFetcher;
import world.deslauriers.model.gallery.Album;

import javax.validation.constraints.Size;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/gallery/albums")
public class AlbumController {

    protected final GalleryFetcher galleryFetcher;

    public AlbumController(GalleryFetcher galleryFetcher) {
        this.galleryFetcher = galleryFetcher;
    }

    @Secured({"GALLERY_READ", "GALLERY_EDIT"})
    @Get
    Flux<Album> getAllAlbums(){
        return galleryFetcher.getAllAlbums();
    }

    @Secured({"GALLERY_READ", "GALLERY_EDIT"})
    @Get("/{album}")
    Mono<Album> getByAlbum(@Size(min = 2, max = 32) String album){
        return galleryFetcher.getAlbumByName(album);
    }
}
