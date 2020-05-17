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
public class SexeType {

    private int id;
    private int modelId;
    private final String name;
    private double humanPercentage;

    public SexeType(String name, double humanPercentage) {
        this.name = name;
        this.humanPercentage = humanPercentage;
    }

    public SexeType(int id, int modelId, String name, double humanPercentage) {
        this.id = id;
        this.modelId = modelId;
        this.name = name;
        this.humanPercentage = humanPercentage;
    }

    public double getHumanPercentage() {
        return humanPercentage;
    }

    public void setHumanPercentage(double humanPercentage) {
        this.humanPercentage = humanPercentage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
