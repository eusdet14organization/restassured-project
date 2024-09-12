import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PatchRequestTests extends TypicodeBaseTest{

    @Test
    public void patchRequestTest(){
        String postId = "1";
        String newTitle = "New title";

        String partialPayload = "{ \"title\": \"" + newTitle + "\" }";

        given()
                .pathParam("id", postId)
                .body(partialPayload)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .patch("/posts/{id}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().all()
                .body("title", equalTo(newTitle));
    }

    @Test
    public void patchClassRequestTest(){
        String postId = "1";
        String newTitle = "New title";

        PatchPost patchPost = new PatchPost();
        patchPost.setTitle(newTitle);

        given()
                .pathParam("id", postId)
                .body(patchPost)
                .contentType(ContentType.JSON)
                .when()
                .patch("/posts/{id}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .assertThat()
                .body("title", equalTo(newTitle));
    }
}
