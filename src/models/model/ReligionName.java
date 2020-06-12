package models.model;

public class ReligionName {

    private int id;
    private String name;
    private String prayLocation;

    public ReligionName(String name, String prayLoc) {
        this.name = name;
        this.prayLocation = prayLoc;
    }

    public ReligionName(int id, String name, String prayLoc) {
        this.id = id;
        this.name = name;
        this.prayLocation = prayLoc;
    }

    public int getId() {
        return id;
    }

    public String getPrayLocation() {
        return prayLocation;
    }

    public void setPrayLocation(String prayLocation) {
        this.prayLocation = prayLocation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
