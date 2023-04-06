package api.reqresService;

import org.junit.Test;
import static io.restassured.RestAssured.given;

public class DeleteUserTest {
    private final static String URL = "https://reqres.in";

    @Test
    public void wrongDeleteUserTest(){
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(URL),
                ReqresServiceSpecifications.respSpecUnique(204));
        given()
                .when()
                .delete("/api/users/2")
                .then().log().all();
        // Если нужна проверка только на статус, то можно не писать ассерт, т.к на спецификации уже указана проверка на
        // статус код статус код
    }
}
