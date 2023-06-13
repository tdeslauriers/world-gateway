package world.deslauriers.controller.allowance;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AllowanceFetcher;
import world.deslauriers.model.allowance.*;

@Secured({"COLD_STORAGE"})
@Controller("/allowance/restore")
public class RestoreController {

    private static final Logger log = LoggerFactory.getLogger(RestoreController.class);

    private final AllowanceFetcher allowanceFetcher;

    public RestoreController(AllowanceFetcher allowanceFetcher) {
        this.allowanceFetcher = allowanceFetcher;
    }

    @Post("/allowance")
    public Mono<HttpResponse<?>> restoreAllowance(@Body BackupAllowance backupAllowance){
        return allowanceFetcher.restoreAllowance(backupAllowance);
    }

    @Post("/tasktype")
    public Mono<HttpResponse<?>> restoreTasktype(@Body BackupTasktype backupTasktype){
        return allowanceFetcher.restoreTasktype(backupTasktype);
    }

    @Post("/task")
    public Mono<HttpResponse<?>> restoreTask(@Body BackupTask backupTask){
        return allowanceFetcher.restoreTask(backupTask);
    }

    @Post("/tasktype_allowance")
    public Mono<HttpResponse<?>> restoreTasktypeAllowance(@Body BackupTasktypeAllowance backupTasktypeAllowance){
        return allowanceFetcher.restoreTasktypeAllowance(backupTasktypeAllowance);
    }

    @Post("/task_allowance")
    public Mono<HttpResponse<?>> restoreTaskAllowance(@Body BackupTaskAllowance backupTaskAllowance){
        return allowanceFetcher.restoreTaskAllowance(backupTaskAllowance);
    }
}
