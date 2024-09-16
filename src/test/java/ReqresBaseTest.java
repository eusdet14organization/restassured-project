import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeEach;
import utils.Config;

public class ReqresBaseTest {

    @BeforeEach
    public void setUp(){
        RestAssured.baseURI = Config.getConfig("reqresURL");
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

    }
}
