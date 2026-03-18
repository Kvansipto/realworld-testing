package testdata;

import io.realworld.api.UsersApi;
import io.realworld.dto.UserRegisterRequest;

import java.util.UUID;

public class UserFactory {

    public static UserRegisterRequest randomUser() {

        String unique = UUID.randomUUID().toString().substring(0, 8);

        return new UserRegisterRequest("user" + unique + "@test.com", "user" + unique, "password");
    }

    public static TestUser createAndRegister(UsersApi usersApi) {

        var request = randomUser();
        var response = usersApi.register(request);

        return new TestUser(
                request.email(),
                request.password(),
                response.token()
        );
    }
}
