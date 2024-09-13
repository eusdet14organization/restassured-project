package wrappers;

import dto.GadgetPost;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiWrapper {
    private final static int DEFAULT_STATUS_CODE = 200;
    public static GadgetPost sendPostRequest(String endpoint, GadgetPost requestBody) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(endpoint)
                .then()
                .assertThat()
                .statusCode(DEFAULT_STATUS_CODE)
                .contentType(ContentType.JSON)
                .log().ifValidationFails()
                .extract().as(GadgetPost.class);
    }

    public static ValidatableResponse sendGetRequest(RequestSpecification requestSpecification, String callPath, int statusCode){
        return given()
                .spec(requestSpecification)
                .when()
                .get(callPath)
                .then()
                .statusCode(statusCode)
                .contentType(ContentType.JSON)
                .log().ifValidationFails();
    }

    public static ValidatableResponse sendGetRequest(String callPath, int statusCode){
        return sendGetRequest(given(), callPath, statusCode);
    }

    public static ValidatableResponse sendGetRequest(RequestSpecification requestSpecification, String callPath){
        return sendGetRequest(requestSpecification, callPath, DEFAULT_STATUS_CODE);
    }

    public static ValidatableResponse sendGetRequest(String callPath){
        return sendGetRequest(given(), callPath, DEFAULT_STATUS_CODE);
    }
}
