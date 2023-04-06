package api.reqresService.PUT;

import com.fasterxml.jackson.annotation.JsonCreator;

//Наследуемся от UpdateUserReq т.к в ответе так же используются параметры из запроса + добавляются свои
public class UpdateUserResp extends UpdateUserReq{
    private String updatedAt;


    public UpdateUserResp() {
        super();
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

}
