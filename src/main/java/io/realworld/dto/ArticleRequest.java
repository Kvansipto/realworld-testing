package io.realworld.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record ArticleRequest(
        String title,
        String description,
        String body,
        List<String> tagList
) {
}
