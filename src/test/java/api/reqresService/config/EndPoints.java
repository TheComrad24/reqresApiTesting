package api.reqresService.config;

public final class EndPoints {
    public static final String baseUrl = "https://reqres.in";

    public static final String registerEndpoint = "/api/register";
    public static final String unknownEndpoint = "/api/unknown";
    public static final String usersEndpoint = "/api/users?page={int}";
    public static final String usersUpdateEndpoint = "/api/users/{int}";
}
