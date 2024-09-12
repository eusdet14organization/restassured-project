import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class MatchersBasicTests extends ReqresBaseTest {

    @Test
    public void matcherTest(){
        String userId = "1";

        given().pathParam("userId", userId)
                .when()
                .get("/api/users/{userId}")
                .then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id", equalTo(1))
                .body("support.text", containsString("To keep ReqRes free, contributions towards server costs are appreciated!"))
                .body("data.id", greaterThan(0))
                .body("data.id", lessThan(2))
                .body("data.email", matchesRegex("^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$"));
    }

}
