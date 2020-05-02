/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.client;

/**
 *
 * @author Joseph
 */
public enum HumanAgeType {
    under5("underTen", 0, 5, 0d, 0d, 0d),
    between5and10("between5and10", 6, 10, 75d, 0d, 0d),
    between10and18("between10and18", 11, 18, 70d, 0d, 0d),
    between18and27("between18and27", 19, 27, 10d, 50d, 70d),
    between27and40("between27and40", 28, 40, 5d, 10d, 70d),
    between40and50("between40and50", 41, 50, 5d, 5d, 70d),
    between50and60("between50and60", 51, 60, 5d, 10d, 70d),
    between60and70("between60and70", 61, 70, 5d, 5d, 50d),
    between70and80("between70and80", 71, 80, 0d, 0d, 20d),
    above80("above80", 81, 100, 0d, 0d, 5d);

    private final String type;
    private ReligionType religionType;
    private final int min;
    private final int max;

    private final Double goSchoolPercentage;
    private final Double goUniversityPercentage;
    private final Double goWorkPercentage;

    private HumanAgeType(String type, int min, int max, double goSchoolPercentage, double goUniversityPercentage,
            double goWorkPercentage) {
        this.type = type;
        this.min = min;
        this.max = max;
        this.goSchoolPercentage = goSchoolPercentage;
        this.goUniversityPercentage = goUniversityPercentage;
        this.goWorkPercentage = goWorkPercentage;
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

    public ReligionType getReligionType() {
        return religionType;
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

}
