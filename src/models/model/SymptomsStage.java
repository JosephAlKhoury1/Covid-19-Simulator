package models.model;

/**
 *
 * @author Joseph
 */
public class SymptomsStage {

    private int id;
    private int symptomId;
    private final String name;
    private int day;
    private double deathPercentage;
    private double immunePercentage;

    public SymptomsStage(int id, int symptomId, String name, int day, double deathPercentage, double immunePercentage) {
        this.id = id;
        this.symptomId = symptomId;
        this.name = name;
        this.day = day;
        this.deathPercentage = deathPercentage;
        this.immunePercentage = immunePercentage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(int symptomId) {
        this.symptomId = symptomId;
    }

    public SymptomsStage(String name, int day, double death, double immune) {
        this.name = name;
        this.day = day;
        this.deathPercentage = death;
        this.immunePercentage = immune;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getDeathPercentage() {
        return deathPercentage;
    }

    public void setDeathPercentage(double deathPercentage) {
        this.deathPercentage = deathPercentage;
    }

    public double getImmunePercentage() {
        return immunePercentage;
    }

    public void setImmunePercentage(double immunePercentage) {
        this.immunePercentage = immunePercentage;
    }

}
