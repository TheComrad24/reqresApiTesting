package api.reqresService;

import api.reqresService.config.AppProvider;
import api.reqresService.config.ReqresServiceSpecifications;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ListResourceValidationTest {

    @Test
    public void successListResShemaTest(){
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(AppProvider.URL),
                ReqresServiceSpecifications.respSpec200());

        given()
                .when()
                .get(AppProvider.UNKNOWN_ENDPOINT)
                .then().assertThat().body(matchesJsonSchemaInClasspath("reqresService/listResourceShema.json"));
    }
}
