package io.realworld.dto;

import java.util.List;

public record ArticleResponse(
        String slug,
        String title,
        String description,
        String body,
        List<String> tagList,
        boolean favorited,
        int favoritesCount
) {
}