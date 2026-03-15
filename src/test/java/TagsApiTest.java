import io.realworld.api.TagsApi;
import org.junit.jupiter.api.Test;

public class TagsApiTest {

    private final TagsApi tagsApi = new TagsApi();

    @Test
    void shouldReturnTags() {

        tagsApi.getTags()
                .then()
                .statusCode(200);
    }
}