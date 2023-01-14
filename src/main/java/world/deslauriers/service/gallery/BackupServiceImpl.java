package world.deslauriers.service.gallery;

import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.client.GalleryFetcher;
import world.deslauriers.model.gallery.Image;

@Singleton
public class BackupServiceImpl implements BackupService{

    private final GalleryFetcher galleryFetcher;

    public BackupServiceImpl(GalleryFetcher galleryFetcher) {
        this.galleryFetcher = galleryFetcher;
    }

    @Override
    public Mono<Image> getImageForBackup(Long id){
        return galleryFetcher.getImageById(id);
    }

    @Override
    public Flux<Long> listImageIds() {
        return galleryFetcher.listImageIds();
    }
}
