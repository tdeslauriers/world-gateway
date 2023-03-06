package world.deslauriers.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Serdeable
public record RefreshTokenCmd(
        @NonNull
        @NotBlank
        @Pattern(regexp = "refresh_token")
        @JsonProperty("grant_type")
        String grantType,
        @NonNull
        @NotBlank
        @JsonProperty("refresh_token")
        String refreshToken
) {
}
