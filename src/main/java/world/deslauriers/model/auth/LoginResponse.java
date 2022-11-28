package world.deslauriers.model.auth;

import io.micronaut.serde.annotation.Serdeable;

import java.util.Set;

@Serdeable
public record LoginResponse(
        String username,
        Set<String> roles,
        String access_token,
        String token_type,
        Integer expires_in
) {
}
