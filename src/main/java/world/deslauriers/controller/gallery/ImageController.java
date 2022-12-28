package world.deslauriers.controller.gallery;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.client.GalleryFetcher;
import world.deslauriers.model.gallery.FullResolutionDto;
import world.deslauriers.model.gallery.Image;
import world.deslauriers.model.gallery.ImageUpdateCmd;
import world.deslauriers.model.gallery.Thumbnail;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/gallery/images")
public class ImageController {

    protected final GalleryFetcher galleryFetcher;

    public ImageController(GalleryFetcher galleryFetcher) {
        this.galleryFetcher = galleryFetcher;
    }

    @Secured({"GALLERY_READ", "GALLERY_EDIT", "COLD_STORAGE"})
    @Get("/{filename}")
    Mono<Image> getImage(String filename){
        return galleryFetcher.getImage(filename);
    }

    @Secured({"GALLERY_READ", "GALLERY_EDIT", "COLD_STORAGE"})
    @Get("/fullresolution/{filename}")
    Mono<FullResolutionDto> getFullResolution(String filename){
        return galleryFetcher.getFullResolution(filename);
    }

    @Secured({"GALLERY_EDIT"})
    @Get("/unpublished")
    public Flux<Thumbnail> getAllUnpublished(){
        return galleryFetcher.getAllUnpublished();
    }

    @Secured({"GALLERY_EDIT"})
    @Put
    Mono<HttpResponse> update(@Body ImageUpdateCmd imageUpdateCmd){
        return galleryFetcher.updateImage(imageUpdateCmd);
    }

    @Secured({"GALLERY_EDIT"})
    @Delete("/{filename}")
    Mono<HttpResponse> delete(@Size(min = 2, max = 64) String filename){
        return galleryFetcher.deleteImage(filename);
    }
}
