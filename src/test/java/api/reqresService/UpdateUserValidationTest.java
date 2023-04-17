package api.reqresService;

import api.reqresService.config.AppProvider;
import api.reqresService.config.ReqresServiceSpecifications;
import api.reqresService.users.request.UpdateUserReq;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UpdateUserValidationTest {

    @Test
    public void updateUserValidationTest(){
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(AppProvider.URL),
                ReqresServiceSpecifications.respSpec200());

        UpdateUserReq updateUserReq = new UpdateUserReq("morpheus","zion resident");
        given()
                .body(updateUserReq)
                .when()
                .put(AppProvider.USERS_UPDATE_ENDPOINT,2)
                .then().log().all()
                .assertThat().body(matchesJsonSchemaInClasspath("reqresService/updateUserShema.json"));
    }
}
