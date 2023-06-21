package world.deslauriers.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.gallery.*;

@Client(id = "gallery")
public interface GalleryClient extends GalleryFetcher{

    // images
    @Override
    @Get("/images/{filename}")
    Mono<Image> getImageByFilename(String filename);

    @Override
    @Get("/images/fullresolution/{filename}")
    Mono<FullResolutionDto> getFullResolution(String filename);

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

    // backup
    @Override
    @Get("/backup/list")
    Flux<Long> listImageIds();

    @Override
    @Get("/backup/{id}")
    Mono<Image> getImageById(Long id);

    // restore
    @Override
    @Post("/restore/album")
    public Mono<HttpResponse<?>> restoreAlbum(@Body BackupAlbum backupAlbum);

    @Override
    @Post("/restore/image")
    public Mono<HttpResponse<?>> restoreImage(@Body BackupImage backupImage);

    @Override
    @Post("/restore/album_image")
    public Mono<HttpResponse<?>> restoreAlbumImage(@Body BackupAlbumImage backupAlbumImage);
}
