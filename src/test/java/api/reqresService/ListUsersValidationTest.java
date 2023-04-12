package api.reqresService;

import api.reqresService.config.EndPoints;
import api.reqresService.config.ReqresServiceSpecifications;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ListUsersValidationTest {

    @Test
    public void successListUsersValidTest(){
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(EndPoints.baseUrl),
                ReqresServiceSpecifications.respSpec200());

        given()
                .when()
                .get(EndPoints.usersEndpoint, 2)
                .then().log().all()
                .assertThat().body(matchesJsonSchemaInClasspath("reqresService/ListUsersShema.json"));
    }
}
