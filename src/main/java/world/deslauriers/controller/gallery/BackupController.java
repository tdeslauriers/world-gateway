package world.deslauriers.controller.gallery;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.model.gallery.Image;
import world.deslauriers.service.gallery.BackupService;

@Secured({"COLD_STORAGE"})
@Controller("/gallery/backup")
public class BackupController {

    protected final BackupService backupService;

    public BackupController(BackupService backupService) {
        this.backupService = backupService;
    }

    @Get("/list")
    Flux<Long> listImageIds(){
        return backupService.listImageIds();
    }

    @Get("/{filename}")
    Mono<Image> getBackupImage(String filename){
        return backupService.getImageForBackup(filename);
    }
}
