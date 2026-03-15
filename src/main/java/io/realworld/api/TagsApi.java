package io.realworld.api;

import io.restassured.response.Response;

public class TagsApi extends RestClient {

    public Response getTags() {
        return request()
                .get("/tags");
    }

}
