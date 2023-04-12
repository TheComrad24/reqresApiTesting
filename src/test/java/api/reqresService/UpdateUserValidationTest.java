package api.reqresService;

import api.reqresService.config.EndPoints;
import api.reqresService.config.ReqresServiceSpecifications;
import api.reqresService.users.request.UpdateUserReq;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UpdateUserValidationTest {

    @Test
    public void updateUserValidationTest(){
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(EndPoints.baseUrl),
                ReqresServiceSpecifications.respSpec200());

        UpdateUserReq updateUserReq = new UpdateUserReq("morpheus","zion resident");
        given()
                .body(updateUserReq)
                .when()
                .put(EndPoints.usersUpdateEndpoint,2)
                .then().log().all()
                .assertThat().body(matchesJsonSchemaInClasspath("reqresService/UpdateUserShema.json"));
    }
}
