package world.deslauriers.service.allowance;

import io.micronaut.http.HttpResponse;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AllowanceFetcher;
import world.deslauriers.client.AuthFetcher;
import world.deslauriers.model.allowance.Allowance;
import world.deslauriers.model.allowance.AllowanceDto;

@Singleton
public class AllowanceServiceImpl implements AllowanceService{

    private final AllowanceFetcher allowanceFetcher;
    private final AuthFetcher authFetcher;

    public AllowanceServiceImpl(AllowanceFetcher allowanceFetcher, AuthFetcher authFetcher) {
        this.allowanceFetcher = allowanceFetcher;
        this.authFetcher = authFetcher;
    }

    @Override
    public Flux<AllowanceDto> getAll() {
        return allowanceFetcher
                .getAllowances()
                .flatMap(allowance -> authFetcher
                            .getProfileById(allowance.userId())
                            .map(profile -> new AllowanceDto(
                                    allowance.id(),
                                    allowance.balance(),
                                    profile.username(),
                                    profile.firstname(),
                                    profile.lastname(),
                                    profile.birthday())));
    }

    @Override
    public Mono<HttpResponse<Allowance>> saveAllownace(Allowance cmd) {
        return allowanceFetcher.saveAllowance(cmd);
    }
}
