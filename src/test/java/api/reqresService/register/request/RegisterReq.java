package api.reqresService.register.request;

import api.reqresService.config.AppProvider;
import api.reqresService.register.response.RegisterSuccessResp;
import api.reqresService.register.response.RegisterUnSuccessResp;

import static io.restassured.RestAssured.given;

public class RegisterReq {
    private String email;
    private String password;

    public RegisterReq(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public RegisterSuccessResp sendValidRequest(RegisterReq registerReq){

        RegisterSuccessResp resp = given()
                .body(registerReq)
                .when()
                .post(AppProvider.REGISTER_ENDPOINT)
                .then().log().all()
                .extract().as(RegisterSuccessResp.class);
        return resp;
    }

    public RegisterUnSuccessResp sendInvalidRequest(RegisterReq registerReq){

        RegisterUnSuccessResp resp = given()
                .body(registerReq)
                .when()
                .post(AppProvider.REGISTER_ENDPOINT)
                .then().log().all()
                .extract().as(RegisterUnSuccessResp.class);
        return resp;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}
