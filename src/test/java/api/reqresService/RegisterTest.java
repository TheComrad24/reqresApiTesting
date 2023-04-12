package api.reqresService;

import api.reqresService.config.EndPoints;
import api.reqresService.config.ReqresServiceSpecifications;
import api.reqresService.register.request.RegisterReq;
import api.reqresService.register.response.RegisterSuccessResp;
import api.reqresService.register.response.RegisterUnSuccessResp;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;

public class RegisterTest {

    @Test
    @Description("Успешная регистрация клиента")
    public void successRegTest(){
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(EndPoints.baseUrl),
                ReqresServiceSpecifications.respSpec200());

        int expectedId = 4;
        String expectedToken = "QpwL5tke4Pnpja7X4";

        RegisterReq registerReq = new RegisterReq("eve.holt@reqres.in","pistol");
        RegisterSuccessResp registerSuccessResp = registerReq.sendValidRequest(registerReq);

        Assert.assertEquals(expectedId, registerSuccessResp.getId());
        Assert.assertEquals(expectedToken, registerSuccessResp.getToken());
    }

    @Test
    @Description("Регистрация клиента без пароля")
    public void regWithoutPass(){
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(EndPoints.baseUrl),
                ReqresServiceSpecifications.respSpec400());
        String expectedError = "Missing password";

        RegisterReq registerReq = new RegisterReq("sydney@fife","");
        RegisterUnSuccessResp registerUnSuccessResp = registerReq.sendInvalidRequest(registerReq);

        Assert.assertEquals(expectedError, registerUnSuccessResp.getError());
    }

    //e.t.c
}
