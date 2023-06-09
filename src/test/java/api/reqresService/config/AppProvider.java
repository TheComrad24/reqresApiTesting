package api.reqresService.config;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface AppProvider {
    static Config readConfig() {
        return ConfigFactory.load("app.conf");
    }

    String URL = readConfig().getString("baseUrl");
    String REGISTER_ENDPOINT = readConfig().getString("registerEndpoint");
    String UNKNOWN_ENDPOINT = readConfig().getString("unknownEndpoint");
    String USERS_ENDPOINT = readConfig().getString("usersEndpoint");
    String USERS_UPDATE_ENDPOINT = readConfig().getString("usersUpdateEndpoint");

    String USER_LOGIN = readConfig().getString("userParams.testUser.login");
    String USER_PASSWORD = readConfig().getString("userParams.testUser.password");
    String USER_EMAIL = readConfig().getString("userParams.testUser.email");

}