package api.reqresService.users.request;

import api.reqresService.config.AppProvider;
import api.reqresService.users.response.UpdateUserResp;
import static io.restassured.RestAssured.given;

public class UpdateUserReq {
    private String name;
    private String job;

    public UpdateUserReq(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public UpdateUserReq(){}

    public static UpdateUserResp sendUpdateRequest(UpdateUserReq updateUserReq, int user){
        UpdateUserResp updateUserResp = given()
                .body(updateUserReq)
                .when()
                .put(AppProvider.USERS_UPDATE_ENDPOINT, user)
                .then().log().all()
                .extract().as(UpdateUserResp.class);
        return updateUserResp;
    }

    public String getName() {
        return name;
    }
    public String getJob() {
        return job;
    }
}
