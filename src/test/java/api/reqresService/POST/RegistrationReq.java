package api.reqresService.POST;

public class RegistrationReq {
    private String email;
    private String password;

    public RegistrationReq(String email, String password) {
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
