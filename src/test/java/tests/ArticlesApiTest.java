package tests;

import io.realworld.api.ArticlesApi;
import io.realworld.api.UsersApi;
import org.junit.jupiter.api.Test;
import testdata.ArticleFactory;
import testdata.UserFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class ArticlesApiTest {

    private final ArticlesApi articlesApi = new ArticlesApi();
    private final UsersApi usersApi = new UsersApi();

    @Test
    void userCanCreateArticle() {

        var user = UserFactory.createAndRegister(usersApi);

        var article = ArticleFactory.random();

        var created = articlesApi.create(user.token, article);

        assertThat(created.title()).isEqualTo(article.title());
    }
}