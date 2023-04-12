package api.reqresService;
import api.reqresService.config.EndPoints;
import api.reqresService.config.ReqresServiceSpecifications;
import api.reqresService.users.request.UpdateUserReq;
import api.reqresService.users.response.UpdateUserResp;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;

import java.time.Clock;

import static io.restassured.RestAssured.given;

public class UpdateUserTest {

    @Test
    @Description("Успешное обновление пользователя. Локальная дата обновления = Дата сервера")
    public void successUpdate() {
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(EndPoints.baseUrl),
                ReqresServiceSpecifications.respSpec200());

        UpdateUserReq updateUserReq = new UpdateUserReq("morpheus","zion resident");
        UpdateUserResp updateUserResp = UpdateUserReq.sendUpdateRequest(updateUserReq, 2);

        // Регулярка для нахождения последних символов и точки
        String regex = "\\..*$";

        // Получили формат времени такой же,как в ответе Json, кроме последних символов. Отсекаем последние символы
        // при помощи регулярки как у локального времени, так и у времени респонса
        String localTime = Clock.systemUTC().instant().toString().replaceAll(regex,"");

        Assert.assertEquals(localTime, updateUserResp.getUpdatedAt().replaceAll(regex,""));
        Assert.assertEquals(updateUserReq.getName(), updateUserResp.getName());
        Assert.assertEquals(updateUserReq.getJob(), updateUserResp.getJob());
    }
}
