/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.model;

/**
 *
 * @author Joseph
 */
public class HumanStat {

    private final String name;
    private double humanPercentage;

    public HumanStat(String name, double humanPercentage) {
        this.name = name;
        this.humanPercentage = humanPercentage;
    }

    public String getName() {
        return name;
    }

    public double getHumanPercentage() {
        return humanPercentage;
    }

    public void setHumanPercentage(double humanPercentage) {
        this.humanPercentage = humanPercentage;
    }

}
