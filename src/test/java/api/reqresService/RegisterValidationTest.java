package api.reqresService;

import api.reqresService.config.EndPoints;
import api.reqresService.config.ReqresServiceSpecifications;
import api.reqresService.register.request.RegisterReq;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RegisterValidationTest {
    // Есть вариации: можно реализовать проверку Json схемы в методе отправки запроса, либо создавать
    // дополнительные спецификации.
    // Мне ближе подход с формированием отдельного класса для проверок схемы/схем для конкретного ендпоинта,
    // на случай, если по одному ендпоинту, в зависимости от бизнес логики, может быть 2 и более валидных схемы.
    // В этом случае не прийдется делать дополнительных спецификаций или дописывать методы.

    @Test
    public void successRegShemaTest(){
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(EndPoints.baseUrl),
                ReqresServiceSpecifications.respSpec200());

        RegisterReq registerReq = new RegisterReq("eve.holt@reqres.in","pistol");

        given()
                .body(registerReq)
                .when()
                .post("/api/register")
                .then().assertThat().body(matchesJsonSchemaInClasspath("reqresService/RegisterSuccessShema.json"));
    }
}
