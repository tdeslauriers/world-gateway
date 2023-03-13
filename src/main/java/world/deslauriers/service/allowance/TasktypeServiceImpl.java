package world.deslauriers.service.allowance;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AllowanceFetcher;
import world.deslauriers.client.AuthFetcher;
import world.deslauriers.model.allowance.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;

@Singleton
public class TasktypeServiceImpl implements TasktypeService{

    private final AllowanceFetcher allowanceFetcher;
    private final AuthFetcher authFetcher;

    @Inject
    @Client("auth")
    HttpClient client;


    public TasktypeServiceImpl(AllowanceFetcher allowanceFetcher, AuthFetcher authFetcher) {
        this.allowanceFetcher = allowanceFetcher;
        this.authFetcher = authFetcher;
    }

    @Override
    public Flux<TasktypeDto> getTasktypesAll(){

        return allowanceFetcher.getAllTasktypes()
                .map(tasktype -> {
                    return new TasktypeDto(
                            tasktype.id(),
                            tasktype.name(),
                            tasktype.cadence(),
                            tasktype.category(),
                            tasktype.archived(),
                            collectAllowances(tasktype)
                    );
                });
    }

    @Override
    public Mono<TasktypeDto> getTasktypeById(Long id) {
        return allowanceFetcher
                .getTasktypeById(id)
                .map(tasktype -> {
                    return new TasktypeDto(
                            tasktype.id(),
                            tasktype.name(),
                            tasktype.cadence(),
                            tasktype.category(),
                            tasktype.archived(),
                            collectAllowances(tasktype));
                });
    }

    @Override
    public Mono<HttpResponse<TasktypeDto>> updateTasktype(TasktypeDto cmd) {
        var taskTypeAllowances = new HashSet<TasktypeAllowance>();
        if (cmd.allowances() != null && cmd.allowances().size() > 0){
            cmd.allowances().forEach(allowanceDto -> {
                var a = new Allowance(allowanceDto.getId(), allowanceDto.getBalance(), allowanceDto.getUserUuid());
                taskTypeAllowances.add(new TasktypeAllowance(a));
            });
        }

        return allowanceFetcher.updateTasktype(new Tasktype(cmd.id(), cmd.name(), cmd.cadence(), cmd.category(), cmd.archived(), taskTypeAllowances))
                .map(tasktypeHttpResponse -> {
                    var dto = new TasktypeDto(
                            tasktypeHttpResponse.body().id(),
                            tasktypeHttpResponse.body().name(),
                            tasktypeHttpResponse.body().cadence(),
                            tasktypeHttpResponse.body().category(),
                            tasktypeHttpResponse.body().archived(),
                            collectAllowances(tasktypeHttpResponse.body())
                    );
                    return HttpResponse.ok(dto);
                });
    }

    @Override
    public Mono<HttpResponse<TasktypeDto>> saveTasktype(TasktypeDto cmd) {
        var taskTypeAllowances = new HashSet<TasktypeAllowance>();
        if (cmd.allowances() != null && cmd.allowances().size() > 0){
            cmd.allowances().forEach(allowanceDto -> {
                var a = new Allowance(allowanceDto.getId(), allowanceDto.getBalance(), allowanceDto.getUserUuid());
                taskTypeAllowances.add(new TasktypeAllowance(a));
            });
        }
        return allowanceFetcher.saveTasktype(new Tasktype(cmd.name(), cmd.cadence(), cmd.category(), cmd.archived(), taskTypeAllowances))
                .map(tasktypeHttpResponse -> {
                    var dto = new TasktypeDto(
                            tasktypeHttpResponse.body().id(),
                            tasktypeHttpResponse.body().name(),
                            tasktypeHttpResponse.body().cadence(),
                            tasktypeHttpResponse.body().category(),
                            tasktypeHttpResponse.body().archived(),
                            collectAllowances(tasktypeHttpResponse.body())
                    );
                    return HttpResponse.created(dto);
                });
    }

    private HashSet<AllowanceDto> collectAllowances(Tasktype tasktype){
        var allowances = new HashSet<AllowanceDto>();
        if (tasktype.tasktypeAllowances() != null) {
            Flux.fromStream(tasktype
                .tasktypeAllowances()
                .stream()
                .map(tasktypeAllowance -> {
                    return authFetcher
                            .getProfileByUuid(tasktypeAllowance.allowance().userUuid())
                            .map(profile -> {
                                return new AllowanceDto(
                                        tasktypeAllowance.allowance().id(),
                                        tasktypeAllowance.allowance().balance(),
                                        profile.uuid(),
                                        profile.username(),
                                        profile.firstname(),
                                        profile.lastname(),
                                        Period.between(LocalDate.parse(profile.birthday()), LocalDate.now()).getYears()
                                );
                            })
                            .block();
            }))
            .doOnNext(allowances::add)
            .blockLast();
        }
        return allowances;
    }

}
