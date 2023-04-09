package api.reqresService.users.response;

import api.reqresService.users.request.UpdateUserReq;

//Наследуемся от UpdateUserReq т.к в ответе так же используются параметры из запроса + добавляются свои
public class UpdateUserResp extends UpdateUserReq {
    private String updatedAt;

    public UpdateUserResp() {
        super();
    }
    public String getUpdatedAt() {
        return updatedAt;
    }

}
