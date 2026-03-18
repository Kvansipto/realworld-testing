package io.realworld.api;

import io.realworld.dto.LoginRequest;
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

    public UserRegisterResponse login(LoginRequest request) {

        var responseMap = request()
                .body(Map.of("user", request))
                .post("/users/login")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("user");

        return MAPPER.convertValue(responseMap, UserRegisterResponse.class);
    }

    public UserRegisterResponse getCurrentUser(String token) {

        var responseMap = authorized(token)
                .get("/user")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("user");

        return MAPPER.convertValue(responseMap, UserRegisterResponse.class);
    }
}