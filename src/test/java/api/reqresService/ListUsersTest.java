package api.reqresService;

import api.reqresService.config.AppProvider;
import api.reqresService.config.ReqresServiceSpecifications;
import api.reqresService.users.request.ListUsersData;
import api.reqresService.users.request.ListUsersGet;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class ListUsersTest {

    @Test
    @Description("Запрос списка пользователей на странице" +
                 "Аватар должен включать в себя id. Почта оканчиваться на @reqres.in")
    public void checkAvatarAndIdTest() {
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(AppProvider.URL),
                ReqresServiceSpecifications.respSpec200());

        List<ListUsersData> users = ListUsersGet.sendRequestGetUserList(2);

        users.forEach(x -> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
        Assert.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));
    }
}