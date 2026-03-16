package io.realworld.api;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import tools.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.given;

public class RestClient {

    protected static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    private static final String BASE_URL = "http://localhost:8080";

    protected RequestSpecification request() {
        return given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .log().ifValidationFails();
    }
}
