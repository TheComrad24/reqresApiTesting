package api.reqresService;

import api.reqresService.config.AppProvider;
import api.reqresService.config.ReqresServiceSpecifications;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ListUsersValidationTest {

    @Test
    public void successListUsersValidTest(){
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(AppProvider.URL),
                ReqresServiceSpecifications.respSpec200());

        given()
                .when()
                .get(AppProvider.USERS_ENDPOINT, 2)
                .then().log().all()
                .assertThat().body(matchesJsonSchemaInClasspath("reqresService/listUsersShema.json"));
    }
}
