/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.Server;

/**
 *
 * @author Joseph
 */
public enum HumanAgeType {
    under5("underTen", 0, 5, 0d, 0d, 5d, 10d),
    between5and10("between5and10", 6, 10, 75d, 0d, 10d, 10d),
    between10and18("between10and18", 11, 18, 70d, 0d, 20d, 10d),
    between18and27("between18and27", 19, 27, 10d, 50d, 40d, 10d),
    between27and40("between27and40", 28, 40, 5d, 10d, 60d, 10d),
    between40and50("between40and50", 41, 50, 5d, 5d, 60d, 20d),
    between50and60("between50and60", 51, 60, 5d, 10d, 50d, 30d),
    between60and70("between60and70", 61, 70, 5d, 5d, 50d, 40d),
    between70and80("between70and80", 71, 80, 0d, 0d, 30d, 50d),
    above80("above80", 81, 100, 0d, 0d, 10d, 50d);

    private String type;
    private ReligionType religionType;
    private int min;
    private int max;

    private Double goSchoolPercentage;
    private Double goShopPercentage;
    private Double goUniversityPercentage;
    private Double goHospitalPercentage;

    private HumanAgeType(String type, int min, int max, double goSchoolPercentage, double goUniversityPercentage,
            double goShopPercentage, double goHospitalPercentage) {
        this.type = type;
        this.min = min;
        this.max = max;
        this.goSchoolPercentage = goSchoolPercentage;
        this.goUniversityPercentage = goUniversityPercentage;
        this.goShopPercentage = goShopPercentage;
        this.goHospitalPercentage = goHospitalPercentage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public ReligionType getReligionType() {
        return religionType;
    }

    public void setReligionType(ReligionType religionType) {
        this.religionType = religionType;
    }

    public Double getGoSchoolPercentage() {
        return goSchoolPercentage;
    }

    public void setGoSchoolPercentage(Double goSchoolPercentage) {
        this.goSchoolPercentage = goSchoolPercentage;
    }

    public Double getGoShopPercentage() {
        return goShopPercentage;
    }

    public void setGoShopPercentage(Double goShopPercentage) {
        this.goShopPercentage = goShopPercentage;
    }

    public Double getGoUniversityPercentage() {
        return goUniversityPercentage;
    }

    public void setGoUniversityPercentage(Double goUniversityPercentage) {
        this.goUniversityPercentage = goUniversityPercentage;
    }

    public Double getGoHospitalPercentage() {
        return goHospitalPercentage;
    }

    public void setGoHospitalPercentage(Double goHospitalPercentage) {
        this.goHospitalPercentage = goHospitalPercentage;
    }

}
