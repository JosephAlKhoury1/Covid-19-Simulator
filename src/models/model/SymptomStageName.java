package models.model;

public class SymptomStageName {

    private int id;
    private String name;

    public int getId() {
        return id;
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

    public SymptomStageName(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public SymptomStageName(String name) {
        this.name = name;
    }

}
