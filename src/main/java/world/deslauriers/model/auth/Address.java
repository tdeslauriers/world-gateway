package world.deslauriers.model.auth;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Serdeable
public record Address(
       Long id,
        @NonNull @NotBlank @Size(max = 128) String address,
        @NonNull @NotBlank @Size(max = 64) String city,
        @NonNull @NotBlank  @Size(min = 2, max = 2) String state,
        @NotNull @NotBlank  @Size(min = 5, max = 5) String zip

) {
        public Address(Long id, @NonNull String address, @NonNull String city, @NonNull String state, String zip) {
                this.id = id;
                this.address = address;
                this.city = city;
                this.state = state;
                this.zip = zip;
        }
}
