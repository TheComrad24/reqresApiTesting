package api.reqresService.users.request;

import api.reqresService.config.EndPoints;
import java.util.List;
import static io.restassured.RestAssured.given;

public class ListUsersGet {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    ListUsersData listUsersData;

    public ListUsersGet() {};

    public static List<ListUsersData> sendRequestGetUserList(Integer page){
        List<ListUsersData> users = given()
                .when()
                .get(EndPoints.usersEndpoint, page)
                .then().log().all()
                .extract().body().jsonPath().getList("data", ListUsersData.class);
        return  users;
    }
}
