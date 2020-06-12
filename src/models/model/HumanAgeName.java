package models.model;

public class HumanAgeName {

    private int id;
    private String name;
    private int minAge;
    private int maxAge;

    public HumanAgeName(int id, String name, int minAge, int maxAge) {
        this.id = id;
        this.name = name;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public HumanAgeName(String name, int minAge, int maxAge) {
        this.name = name;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

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

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

}
