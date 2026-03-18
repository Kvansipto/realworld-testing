package io.realworld.api;

import io.realworld.dto.*;

import java.util.Map;

public class ArticlesApi extends RestClient {

    public ArticleResponse create(String token, ArticleRequest request) {
        var map = authorized(token)
                .body(Map.of("article", request))
                .post("/articles")
                .then()
                // NOTE: API returns 200 instead of 201 (known inconsistency)
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("article");

        return MAPPER.convertValue(map, ArticleResponse.class);
    }
}