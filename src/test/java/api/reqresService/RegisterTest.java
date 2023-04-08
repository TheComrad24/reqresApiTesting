package api.reqresService;

import api.reqresService.config.ReqresServiceSpecifications;
import api.reqresService.register.request.RegisterReq;
import api.reqresService.register.response.RegisterSuccessResp;
import api.reqresService.register.response.RegisterUnSuccessResp;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RegisterTest {
    private final static String URL = "https://reqres.in";

    @Test
    public void successRegTest(){
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(URL),
                ReqresServiceSpecifications.respSpec200());

        int id = 4;
        String expectedToken = "QpwL5tke4Pnpja7X4";
        RegisterReq registerReq = new RegisterReq("eve.holt@reqres.in","pistol");
        RegisterSuccessResp registerSuccessResp = given()
                .body(registerReq)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(RegisterSuccessResp.class);

        Assert.assertNotNull(registerSuccessResp.getId());
        Assert.assertNotNull(registerSuccessResp.getToken());
        Assert.assertEquals(id, registerSuccessResp.getId());
        Assert.assertEquals(expectedToken, registerSuccessResp.getToken());
    }

    @Test
    public void regWithoutPass(){
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(URL),
                ReqresServiceSpecifications.respSpec400());
        String expectedError = "Missing password";

        RegisterReq registerReq = new RegisterReq("sydney@fife","");
        RegisterUnSuccessResp registerUnSuccessResp = given()
                .body(registerReq)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(RegisterUnSuccessResp.class);

        Assert.assertEquals(expectedError, registerUnSuccessResp.getError());
    }
}
