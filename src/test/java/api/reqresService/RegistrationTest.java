package api.reqresService;

import api.reqresService.POST.RegistrationReq;
import api.reqresService.POST.RegistrationSuccessResp;
import api.reqresService.POST.RegistrationUnSuccessResp;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RegistrationTest {
    private final static String URL = "https://reqres.in";

    @Test
    public void successRegTest(){
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(URL),
                ReqresServiceSpecifications.respSpec200());

        int id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        RegistrationReq registrationReq = new RegistrationReq("eve.holt@reqres.in","pistol");
        RegistrationSuccessResp registrationSuccessResp = given()
                .body(registrationReq)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(RegistrationSuccessResp.class);

        Assert.assertNotNull(registrationSuccessResp.getId());
        Assert.assertNotNull(registrationSuccessResp.getToken());
        Assert.assertEquals(id, registrationSuccessResp.getId());
        Assert.assertEquals(token, registrationSuccessResp.getToken());
    }

    @Test
    public void regWithoutPass(){
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(URL),
                ReqresServiceSpecifications.respSpec400());
        String error = "Missing password";

        RegistrationReq registrationReq = new RegistrationReq("sydney@fife","");
        RegistrationUnSuccessResp registrationUnSuccessResp = given()
                .body(registrationReq)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(RegistrationUnSuccessResp.class);

        Assert.assertEquals(error,registrationUnSuccessResp.getError());
    }
}
