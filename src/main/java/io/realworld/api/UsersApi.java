package io.realworld.api;

import io.realworld.dto.UserRegisterRequest;
import io.realworld.dto.UserRegisterResponse;

import java.util.Map;

public class UsersApi extends RestClient {

    public UserRegisterResponse register(UserRegisterRequest user) {

        var responseMap = request()
                .body(Map.of("user", user))
                .post("/users")
                .then()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getMap("user");

        return MAPPER.convertValue(responseMap, UserRegisterResponse.class);
    }
}