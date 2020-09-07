package models.model;

public class SymptomStageName {

    private int id;
    private String name;
    private int inHospital;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getInHospital() {
        return inHospital;
    }

    public void setInHospital(int inHospital) {
        this.inHospital = inHospital;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SymptomStageName(int id, String name, int inHospital) {
        this.id = id;
        this.name = name;
        this.inHospital = inHospital;
    }

    public SymptomStageName(String name, int inHospital) {
        this.name = name;
        this.inHospital = inHospital;
    }

}
