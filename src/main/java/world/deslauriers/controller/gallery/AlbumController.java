package world.deslauriers.controller.gallery;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.client.GalleryFetcher;
import world.deslauriers.model.gallery.Album;
import world.deslauriers.model.gallery.AlbumDto;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/gallery/albums")
public class AlbumController {

    protected final GalleryFetcher galleryFetcher;

    public AlbumController(GalleryFetcher galleryFetcher) {
        this.galleryFetcher = galleryFetcher;
    }

    @Secured({"GALLERY_READ"})
    @Get
    Flux<Album> getAllAlbums(){
        return galleryFetcher.getAllAlbums();
    }

    @Secured({"GALLERY_READ"})
    @Get("/{album}")
    Mono<AlbumDto> getByAlbum(@Size(min = 2, max = 32) String album){
        return galleryFetcher.getAlbumByName(album);
    }

    @Secured({"GALLERY_EDIT"})
    @Post
    Mono<HttpResponse<Album>> saveAlbum(@Body @Valid Album album){
        return galleryFetcher.saveAlbum(album);

    }

    @Secured({"GALLERY_EDIT"})
    @Put
    Mono<HttpResponse<?>> updateAlbum(@Body @Valid Album album){
        return galleryFetcher.updateAlbum(album);
    }
}
