package api.reqresService.PUT;

import com.fasterxml.jackson.annotation.JsonCreator;

public class UpdateUserReq {
    private String name;
    private String job;


    public UpdateUserReq(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public UpdateUserReq(){}

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
