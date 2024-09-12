import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostRequestInputClassExampleTest extends TypicodeBaseTest {

    @Test
    public void entityPostRequest(){
        Post postEntity = new Post();
        postEntity.setId(1);
        postEntity.setTitle("Title of the post");
        postEntity.setBody("The body of the post");

    }

    private void createPost(Post postEntity) {
        given()
                .contentType(ContentType.JSON)
                .body(postEntity)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON);
    }
}
