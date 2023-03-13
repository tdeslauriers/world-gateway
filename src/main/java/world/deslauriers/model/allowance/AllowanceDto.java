package world.deslauriers.model.allowance;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Serdeable
public class AllowanceDto {

        private Long id;

        @NonNull
        private Double balance;

        @NonNull
        String userUuid;

        @NonNull
        @NotBlank
        @Email
        @Size(max = 255)
        private String username;

        @NonNull
        @NotBlank
        @Size(min = 1, max = 32)
        private String firstname;
        @NonNull
        @NotBlank
        @Size(min = 1, max = 32)
        private String lastname;

        @Nullable
        private Integer age;

        @Nullable
        private Set<TaskDto> tasks;

    public AllowanceDto() {
    }

    public AllowanceDto(Long id, @NonNull Double balance, @NonNull String userUuid, @NonNull String username, @NonNull String firstname, @NonNull String lastname, @Nullable Integer age) {
        this.id = id;
        this.balance = balance;
        this.userUuid = userUuid;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public AllowanceDto(Long id, @NonNull Double balance, @NonNull String userUuid, @NonNull String username, @NonNull String firstname, @NonNull String lastname, @Nullable Integer age, @Nullable Set<TaskDto> tasks) {
        this.id = id;
        this.balance = balance;
        this.userUuid = userUuid;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public Double getBalance() {
        return balance;
    }

    public void setBalance(@NonNull Double balance) {
        this.balance = balance;
    }

    @NonNull
    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(@NonNull String userUuid) {
        this.userUuid = userUuid;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(@NonNull String firstname) {
        this.firstname = firstname;
    }

    @NonNull
    public String getLastname() {
        return lastname;
    }

    public void setLastname(@NonNull String lastname) {
        this.lastname = lastname;
    }

    @Nullable
    public Integer getAge() {
        return age;
    }

    public void setAge(@Nullable Integer age) {
        this.age = age;
    }

    @Nullable
    public Set<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(@Nullable Set<TaskDto> tasks) {
        this.tasks = tasks;
    }



    @Override
    public String toString() {
        return "AllowanceDto{" +
                "id=" + id +
                ", balance=" + balance +
                ", userUuid='" + userUuid + '\'' +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", tasks=" + tasks +
                '}';
    }
}
