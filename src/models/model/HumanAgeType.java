package models.model;



public class HumanAgeType {

    private int id;
    private int cityId;
    private final String type;
    private final int min;
    private final int max;

    private Double humanPercentage;
    private Double goSchoolPercentage;
    private Double goUniversityPercentage;
    private Double goWorkPercentage;

    public HumanAgeType(String type, int min, int max, Double humanPercentage, double goSchoolPercentage, double goUniversityPercentage,
            double goWorkPercentage) {
        this.type = type;
        this.min = min;
        this.max = max;
        this.humanPercentage = humanPercentage;
        this.goSchoolPercentage = goSchoolPercentage;
        this.goUniversityPercentage = goUniversityPercentage;
        this.goWorkPercentage = goWorkPercentage;
    }

    public HumanAgeType(int id, int cityId, String type, int min, int max, Double humanPercentage, double goSchoolPercentage, double goUniversityPercentage,
            double goWorkPercentage) {
        this.id = id;
        this.cityId = cityId;
        this.type = type;
        this.min = min;
        this.max = max;
        this.humanPercentage = humanPercentage;
        this.goSchoolPercentage = goSchoolPercentage;
        this.goUniversityPercentage = goUniversityPercentage;
        this.goWorkPercentage = goWorkPercentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int modelId) {
        this.cityId = modelId;
    }

    public String getType() {
        return type;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }


    public Double getGoSchoolPercentage() {
        return goSchoolPercentage;
    }

    public Double getGoUniversityPercentage() {
        return goUniversityPercentage;
    }

    public Double getGoWorkPercentage() {
        return goWorkPercentage;
    }

    public void setGoSchoolPercentage(Double goSchoolPercentage) {
        this.goSchoolPercentage = goSchoolPercentage;
    }

    public void setGoUniversityPercentage(Double goUniversityPercentage) {
        this.goUniversityPercentage = goUniversityPercentage;
    }

    public void setGoWorkPercentage(Double goWorkPercentage) {
        this.goWorkPercentage = goWorkPercentage;
    }

    public Double getHumanPercentage() {
        return humanPercentage;
    }

    public void setHumanPercentage(Double humanPercentage) {
        this.humanPercentage = humanPercentage;
    }

}
