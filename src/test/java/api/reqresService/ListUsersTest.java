package api.reqresService;

import api.reqresService.config.ReqresServiceSpecifications;
import api.reqresService.users.request.ListUsersReq;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import static io.restassured.RestAssured.given;

public class ListUsersTest {
    private final static String URL = "https://reqres.in";

    @Test
    public void checkAvatarAndIdTest() {
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(URL),
                ReqresServiceSpecifications.respSpec200());

        List<ListUsersReq> users = given()
                .when()
                .get("/api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ListUsersReq.class);

        users.forEach(x -> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
        // #Почитать про stream()
        Assert.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));
    }


}