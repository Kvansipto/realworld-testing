package testdata;

import io.realworld.dto.ArticleRequest;

import java.util.List;
import java.util.UUID;

public class ArticleFactory {

    public static ArticleRequest random() {

        String unique = UUID.randomUUID().toString().substring(0, 8);

        return ArticleRequest.builder()
                .title("Test title " + unique)
                .description("Test description " + unique)
                .body("Test body " + unique)
                .tagList(List.of("test", "api"))
                .build();
    }

    public static ArticleRequest withTitle(String title) {

        return ArticleRequest.builder()
                .title(title)
                .description("Test description")
                .body("Test body")
                .tagList(List.of("test"))
                .build();
    }
}