package world.deslauriers.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.gallery.*;

@Client(id = "gallery")
public interface GalleryClient extends GalleryFetcher{

    // images
    @Override
    @Get("/images/{filename}")
    Mono<Image> getImage(String filename);

    @Override
    @Get("/images/unpublished")
    Flux<Thumbnail> getAllUnpublished();

    @Override
    @Put("/images")
    Mono<HttpResponse> updateImage(@Body ImageUpdateCmd imageUpdateCmd);

    @Override
    @Delete("/images/{filename}")
    Mono<HttpResponse> deleteImage(String filename);

    // albums
    @Override
    @Get("/albums")
    Flux<Album> getAllAlbums();

    @Override
    @Get("/albums/{album}")
    Mono<AlbumDto> getAlbumByName(String album);

    @Override
    @Get("/backup")
    Flux<Image> backupImages();
}
