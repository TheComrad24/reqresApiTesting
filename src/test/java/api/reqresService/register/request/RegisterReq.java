package api.reqresService.register.request;

public class RegisterReq {
    private String email;
    private String password;

    public RegisterReq(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
