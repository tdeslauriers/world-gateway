package world.deslauriers.model.auth;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;

@Serdeable
public record Profile(
        Long id,
        @NonNull @NotBlank @Email @Size(max = 255) String username,
        @NonNull @NotBlank @Size(min = 1, max = 32) String firstname,
        @NonNull @NotBlank @Size(min = 1, max = 32) String lastname,
        String dateCreated,
        Boolean enabled,
        Boolean accountExpired,
        Boolean accountLocked,
        @Nullable String birthday,

        @Nullable HashSet<Role> roles,
        @Nullable HashSet<Address> addresses,
        @Nullable HashSet<Phone> phones
) {}
