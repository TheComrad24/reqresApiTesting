package api.reqresService.register.request;

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

    public RegisterUnSuccessResp sendInvalidRequest(RegisterReq registerReq,String endPoint){

        RegisterUnSuccessResp response = given()
                .body(registerReq)
                .when()
                .post(endPoint)
                .then().log().all()
                .extract().as(RegisterUnSuccessResp.class);
        return response;
    }

    public RegisterSuccessResp sendValidRequest(RegisterReq registerReq, String endPoint){

        RegisterSuccessResp response = given()
                .body(registerReq)
                .when()
                .post(endPoint)
                .then().log().all()
                .extract().as(RegisterSuccessResp.class);
        return response;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}
