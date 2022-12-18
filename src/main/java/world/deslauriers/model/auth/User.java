package world.deslauriers.model.auth;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Set;

@Serdeable
public record User(
        Long id,
        String username,
        String password,
        String firstname,
        String lastname,
        String dateCreated,
        Boolean enabled,
        Boolean accountExpired,
        Boolean accountLocked,
        @Nullable String birthday,
        Set<UserRole> userRoles,
        @Nullable Set<UserAddress> userAddresses,
        @Nullable Set<UserPhone> userPhones
) {
}
