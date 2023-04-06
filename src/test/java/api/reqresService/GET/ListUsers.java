package api.reqresService.GET;

public class ListUsers {
    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    //Пустой конструктор для сериализации. Иначе ошибка
    public ListUsers() {};

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
