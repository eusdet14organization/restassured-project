import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class JsonPathExamples {

    @Test
    public void jsonpathTest() {
        String jsonResponse = "{\"objects\": ["
                + "{\"id\": 1, \"data\": {\"color\": \"red\", \"price\": 100}}, "
                + "{\"id\": 2, \"data\": {\"color\": null, \"price\": 200}}, "
                + "{\"id\": 3, \"data\": {\"color\": \"blue\", \"price\": 300}}, "
                + "{\"id\": 4, \"data\": {\"color\": \"green\", \"price\": 400}}]" +
                "}";


        // findAll: выбирает все элементы подходящие по условие
        given().contentType(ContentType.JSON)
                .body(jsonResponse).when()
                .get("/objects").then()
                .statusCode(200)
                .body("objects.findAll { it.data.color != null }.size()", equalTo(3));

// find: выбирает первый элемент подходящий под условие
        given().contentType(ContentType.JSON)
                .body(jsonResponse).when()
                .get("/objects").then()
                .statusCode(200)
                .body("objects.find { it.data.color == 'blue' }.data.price", equalTo(300));


        // collect: преобразует указанный путь в коллекцию
        given().contentType(ContentType.JSON)
                .body(jsonResponse).when()
                .get("/objects").then()
                .statusCode(200)
                .body("objects.collect { it.data.price * 2 }", hasItems(200, 400, 600, 800));


        // flatten: преобразует коллекцию в одноуровневый лист
        given().contentType(ContentType.JSON)
                .body(jsonResponse).when()
                .get("/objects").then()
                .statusCode(200).body("objects.flatten().size()", equalTo(8));

        // sum: вычисляет сумму
        given().contentType(ContentType.JSON) .body(jsonResponse)
                .when() .get("/objects")
                .then()
                .statusCode(200)
                .body("objects.data.price.sum()", equalTo(100 + 200 + 300 + 400));

        // join: то же самое что String.join
        given().contentType(ContentType.JSON)
                .body(jsonResponse) .when()
                .get("/objects") .then()
                .statusCode(200)
                .body("objects.data.color.join(', ')", equalTo("red, blue, green"));


        // sort: Сортировка
        given().contentType(ContentType.JSON)
                .body(jsonResponse) .when()
                .get("/objects") .then()
                .statusCode(200)
                .body("objects.data.price.sort()", contains(100, 200, 300, 400));


        // sortBy: Сортировка по критерию
        given().contentType(ContentType.JSON)
                .body(jsonResponse) .when()
                .get("/objects") .then()
                .statusCode(200)
                .body("objects.sortBy { it.data.price }.data.price", contains(100, 200, 300, 400));
    }
}
