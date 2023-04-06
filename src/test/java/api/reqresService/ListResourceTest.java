package api.reqresService;

import api.reqresService.GET.ListResource;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ListResourceTest {
    private final static String URL = "https://reqres.in";

    @Test
    public void sortedYearsAscList(){
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(URL),
                ReqresServiceSpecifications.respSpec200());

        List<ListResource> resource = given()
                .when()
                .get("/api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data",ListResource.class);
        // Создан новый миссив из значений годов присланных объектов
        List<Integer> years = resource.stream().map(ListResource::getYear).collect(Collectors.toList());
        List<Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());

        Assert.assertEquals(sortedYears,years);
    }
}
