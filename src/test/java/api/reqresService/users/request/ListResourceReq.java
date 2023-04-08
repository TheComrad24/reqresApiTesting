package api.reqresService.users.request;

public class ListResourceReq {
    private int id;
    private String name;
    private int year;
    private String color;
    private String pantone_value;

    public ListResourceReq() {};

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getPantone_value() {
        return pantone_value;
    }
}
