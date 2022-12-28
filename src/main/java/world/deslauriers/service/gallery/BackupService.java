package world.deslauriers.service.gallery;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.gallery.Image;

public interface BackupService {
    Mono<Image> getImageForBackup(String filename);

    Flux<Long> listImageIds();
}
