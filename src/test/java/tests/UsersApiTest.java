package tests;

import io.realworld.api.UsersApi;
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
}