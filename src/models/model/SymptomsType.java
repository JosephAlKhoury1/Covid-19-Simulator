/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Joseph
 */
public class SymptomsType {

    private int id;
    private int modelId;
    private final String name;
    private double humanPercentage;
    private double deathPercentage;
    private int contagiousDays;
    private SymptomsStage noSymptoms;
    private SymptomsStage mildSymptoms;
    private SymptomsStage severeSymptoms;
    private SymptomsStage hospitalization;
    private SymptomsStage icu;
    private List<SymptomsStage> listSymptomsStage;
    private final Map<Integer, SymptomsStage> mapSymptomsEvolution;

    public SymptomsType(int id, int modelId, String name, double humanPercentage, double deathPercentage,
            int contagiousDays, List<SymptomsStage> list) {
        this.id = id;
        this.modelId = modelId;
        this.name = name;
        this.humanPercentage = humanPercentage;
        this.deathPercentage = deathPercentage;
        this.contagiousDays = contagiousDays;

        for (SymptomsStage ss : list) {
            if (ss.getName().equals("No symptoms")) {
                this.noSymptoms = ss;
            } else if (ss.getName().equals("Mild symptoms")) {
                this.noSymptoms = ss;
            } else if (ss.getName().equals("Severe symptoms")) {
                this.noSymptoms = ss;
            } else if (ss.getName().equals("Hospitalization")) {
                this.noSymptoms = ss;
            } else if (ss.getName().equals("Icu")) {
                this.noSymptoms = ss;
            }
        }
        this.listSymptomsStage = new ArrayList();
        this.listSymptomsStage.add(this.noSymptoms);
        this.listSymptomsStage.add(this.mildSymptoms);
        this.listSymptomsStage.add(this.severeSymptoms);
        this.listSymptomsStage.add(this.hospitalization);
        this.listSymptomsStage.add(this.icu);

        this.mapSymptomsEvolution = new HashMap();
        this.initMapSymptomsEvolution();
    }

    public SymptomsType(String name, double percentage, double deathPercentage, int contadiousDay) {
        this.name = name;
        this.humanPercentage = percentage;
        this.deathPercentage = deathPercentage;
        this.contagiousDays = contadiousDay;

        this.listSymptomsStage = new ArrayList();
        this.listSymptomsStage.add(this.noSymptoms = new SymptomsStage("No symptoms", 0, 0d, 0d));
        this.listSymptomsStage.add(this.mildSymptoms = new SymptomsStage("Mild symptoms", 0, 0d, 0d));
        this.listSymptomsStage.add(this.severeSymptoms = new SymptomsStage("Severe symptoms", 0, 0d, 0d));
        this.listSymptomsStage.add(this.hospitalization = new SymptomsStage("Hospitalization", 0, 0d, 0d));
        this.listSymptomsStage.add(this.icu = new SymptomsStage("Icu", 0, 0d, 0d));

        this.mapSymptomsEvolution = new HashMap();
        this.initMapSymptomsEvolution();
    }

    public int getId() {
        return id;
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

    public double getHumanPercentage() {
        return humanPercentage;
    }

    public void setHumanPercentage(double humanPercentage) {
        this.humanPercentage = humanPercentage;
    }

    public int getContagiousDays() {
        return contagiousDays;
    }

    public void setContagiousDays(int contagiousDays) {
        this.contagiousDays = contagiousDays;
    }

    public double getDeathPercentage() {
        return deathPercentage;
    }

    public void setDeathPercentage(double deathPercentage) {
        this.deathPercentage = deathPercentage;
    }

    public double getPercentage() {
        return humanPercentage;
    }

    public void setPercentage(double percentage) {
        this.humanPercentage = percentage;
    }

    public String getName() {
        return name;
    }

    public SymptomsStage getNoSymptoms() {
        return noSymptoms;
    }

    public SymptomsStage getMildSymptoms() {
        return mildSymptoms;
    }

    public SymptomsStage getSevereSymptoms() {
        return severeSymptoms;
    }

    public SymptomsStage getHospitalization() {
        return hospitalization;
    }

    public SymptomsStage getIcu() {
        return icu;
    }

    public List<SymptomsStage> getListSymptomsStage() {
        return listSymptomsStage;
    }

    public void initMapSymptomsEvolution() {
        int index = 0;
        for (SymptomsStage stage : this.listSymptomsStage) {
            for (int i = 0; i < stage.getDay(); i++) {
                this.mapSymptomsEvolution.put(index, stage);
                index++;
            }
        }
    }
}
