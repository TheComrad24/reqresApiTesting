package api.reqresService;

import api.reqresService.config.EndPoints;
import api.reqresService.config.ReqresServiceSpecifications;
import api.reqresService.unknown.ListResourceData;
import api.reqresService.unknown.ListResourceGet;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.stream.Collectors;


public class ListResourceTest {

    @Test
    public void sortedYearsAscList(){
        ReqresServiceSpecifications.installSpecification(ReqresServiceSpecifications.reqSpec(EndPoints.baseUrl),
                ReqresServiceSpecifications.respSpec200());

        // Отправлен запрос, получен массив объектов data, стримом отобраны года каждого объекта и заполнены
        // в массив yearsResp
        List<Integer> yearsResp = ListResourceGet.sendRequestGetDataList().stream()
                .map(ListResourceData::getYear).collect(Collectors.toList());

        //Ожидаемый результат. Как должны выглядеть года в отсортированном порядке
        List<Integer> expectedSortedYears = yearsResp.stream().sorted().collect(Collectors.toList());

        Assert.assertEquals(expectedSortedYears,yearsResp);
    }
}
