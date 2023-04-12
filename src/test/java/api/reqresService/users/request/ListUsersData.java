package api.reqresService.users.request;

public class ListUsersData {
    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    public ListUsersData(){};

    public Integer getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getFirst_name() {
        return first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public String getAvatar() {
        return avatar;
    }
}
