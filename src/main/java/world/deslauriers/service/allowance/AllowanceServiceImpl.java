package world.deslauriers.service.allowance;

import io.micronaut.http.HttpResponse;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import world.deslauriers.client.AllowanceFetcher;
import world.deslauriers.client.AuthFetcher;
import world.deslauriers.model.allowance.Allowance;
import world.deslauriers.model.allowance.AllowanceDto;

import java.time.LocalDate;
import java.time.Period;

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
                .flatMap(allowance -> {
                    return authFetcher
                            .getProfileByUuid(allowance.userUuid())
                            .map(profile -> {
                                var age = Period.between(LocalDate.parse(profile.birthday()), LocalDate.now());
                                return new AllowanceDto(
                                        allowance.id(),
                                        allowance.balance(),
                                        profile.uuid(),
                                        profile.username(),
                                        profile.firstname(),
                                        profile.lastname(),
                                        age.getYears());
                            });
                });
    }

    @Override
    public Mono<HttpResponse<Allowance>> saveAllownace(Allowance cmd) {
        return allowanceFetcher.saveAllowance(cmd);
    }
}
