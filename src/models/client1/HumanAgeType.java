/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.client1;

import models.client.*;

/**
 *
 * @author Joseph
 */
public enum HumanAgeType {
    under5("underTen", 0, 5, 5d, 0d, 0d, 0d),
    between5and10("between5and10", 6, 10, 10d, 75d, 0d, 0d),
    between10and18("between10and18", 11, 18, 13d, 70d, 0d, 0d),
    between18and27("between18and27", 19, 27, 15d, 10d, 50d, 70d),
    between27and40("between27and40", 28, 40, 15d, 5d, 10d, 70d),
    between40and50("between40and50", 41, 50, 15d, 5d, 5d, 70d),
    between50and60("between50and60", 51, 60, 15d, 5d, 10d, 70d),
    between60and70("between60and70", 61, 70, 10d, 5d, 5d, 50d),
    between70and80("between70and80", 71, 80, 10d, 0d, 0d, 20d),
    above80("above80", 81, 100, 5d, 0d, 0d, 5d);

    private final String type;
    private ReligionType religionType;
    private final int min;
    private final int max;

    private Double humanPercentage;
    private Double goSchoolPercentage;
    private Double goUniversityPercentage;
    private Double goWorkPercentage;

    HumanAgeType(String type, int min, int max, Double humanPercentage, double goSchoolPercentage, double goUniversityPercentage,
            double goWorkPercentage) {
        this.type = type;
        this.min = min;
        this.max = max;
        this.humanPercentage = humanPercentage;
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
