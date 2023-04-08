package api.reqresService;

import api.reqresService.config.ReqresServiceSpecifications;
import api.reqresService.register.request.RegisterReq;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RegisterValidationTest {
    private final static String URL = "https://reqres.in";

    @Test
    public void successRegTest(){
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(URL),
                ReqresServiceSpecifications.respSpec200());

        RegisterReq registerReq = new RegisterReq("eve.holt@reqres.in","pistol");

        given()
                .body(registerReq)
                .when()
                .post("/api/register")
                .then().assertThat().body(matchesJsonSchemaInClasspath("reqresService/RegisterSuccessShema.json"));
    }
}
