package tests;

import io.realworld.api.UsersApi;
import io.realworld.dto.LoginRequest;
import org.junit.jupiter.api.Test;
import testdata.UserFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersApiTest {

    private final UsersApi usersApi = new UsersApi();

    @Test
    void userCanRegister() {

        var user = UserFactory.randomUser();
        var userResponse = usersApi.register(user);

        assertThat(userResponse.email())
                .isEqualTo(user.email());
    }

    @Test
    void userCanLogin() {

        var user = UserFactory.randomUser();

       usersApi.register(user);

        var loginResponse = usersApi.login(
                new LoginRequest(user.email(), user.password())
        );

        assertThat(loginResponse.email())
                .isEqualTo(user.email());

        assertThat(loginResponse.token())
                .isNotNull();
    }

    @Test
    void shouldReturnCurrentUser() {

        var user = UserFactory.createAndRegister(usersApi);

        var current = usersApi.getCurrentUser(user.token);

        assertThat(current.email()).isEqualTo(user.email);
    }
}