package api.reqresService.unknown.request;

import api.reqresService.config.AppProvider;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ListResourceGet {
    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private ListResourceData listResourceData;

    public ListResourceGet() {};

    public static List <ListResourceData> sendRequestGetDataList() {
        List<ListResourceData> response = given()
                .when()
                .get(AppProvider.UNKNOWN_ENDPOINT)
                .then().log().all()
                .extract().body().jsonPath().getList("data",ListResourceData.class);
        return response;
    }

    public Integer getPage() {
        return page;
    }
    public Integer getPer_page() {
        return per_page;
    }
    public Integer getTotal() {
        return total;
    }
    public Integer getTotal_pages() {
        return total_pages;
    }
    public ListResourceData getListResourceData() {
        return listResourceData;
    }
}
