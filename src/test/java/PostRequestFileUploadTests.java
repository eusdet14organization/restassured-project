import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.io.*;

import static io.restassured.RestAssured.given;

public class PostRequestFileUploadTests {

    @Test
    public void fileUploadTest() throws IOException {
        RestAssured.baseURI = "https://httpbin.org";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        File fileToUpload = new File("src/main/resources/img.png");
        InputStream inputStream = new FileInputStream(fileToUpload);
        byte[] bytes = inputStream.readAllBytes();

        given()
                .multiPart("file", bytes)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);

    }
}
