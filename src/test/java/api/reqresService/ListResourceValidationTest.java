package api.reqresService;

import api.reqresService.config.EndPoints;
import api.reqresService.config.ReqresServiceSpecifications;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ListResourceValidationTest {

    @Test
    public void successListResShemaTest(){
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(EndPoints.baseUrl),
                ReqresServiceSpecifications.respSpec200());

        given()
                .when()
                .get(EndPoints.unknownEndpoint)
                .then().assertThat().body(matchesJsonSchemaInClasspath("reqresService/ListResourceShema.json"));
    }
}
