package api.reqresService;

import api.reqresService.config.EndPoints;
import api.reqresService.config.ReqresServiceSpecifications;
import api.reqresService.unknown.request.ListResourceData;
import api.reqresService.unknown.request.ListResourceGet;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.stream.Collectors;


public class ListResourceTest {

    @Test
    @Description("Метод Get /api/unknown возвращает список объектов отсортированных по возрастанию по годам")
    public void sortedYearsAscList(){
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(EndPoints.baseUrl),
                ReqresServiceSpecifications.respSpec200());

        List<Integer> yearsResp = ListResourceGet.sendRequestGetDataList().stream()
                .map(ListResourceData::getYear).collect(Collectors.toList());
        List<Integer> expectedSortedYears = yearsResp.stream().sorted().collect(Collectors.toList());

        Assert.assertEquals(expectedSortedYears,yearsResp);
    }
}
