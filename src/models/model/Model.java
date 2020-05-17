package models.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.location1.Location;

/**
 *
 * @author Joseph
 */
public class Model {

    private int modelId;
    private String modelName;
    private boolean saved = false;
    private boolean newModel = true;
    private HumanAgeType under4;
    private HumanAgeType between4and10;
    private HumanAgeType between11and18;
    private HumanAgeType between19and27;
    private HumanAgeType between28and40;
    private HumanAgeType between41and50;
    private HumanAgeType between51and60;
    private HumanAgeType between61and70;
    private HumanAgeType between71and80;
    private HumanAgeType above80;

    private SexeType male;
    private SexeType female;

    private SymptomsType noSymptoms;
    private SymptomsType mildSymptoms;
    private SymptomsType severeSymptoms;
    private SymptomsType criticalSymptoms;

    private HumanStat sick;
    private HumanStat healthy;
    private HumanStat immune;
    private HumanStat infected;
    private HumanStat dead;
    private HumanStat inHospital;
    private HumanStat inIcu;

    private final List<HumanAgeType> listHumanAgeTypePercentage = new ArrayList();
    private final List<SexeType> listSexeType = new ArrayList();
    private final List<SymptomsType> listSymptomsType = new ArrayList();
    private final Map<Integer, Location> mapLocation = new HashMap();

    public Model(int modelId, String modelName, List<SymptomsType> list) {
        this.modelId = modelId;
        this.modelName = modelName;
        for (SymptomsType st : list) {
            if (st.getName().equals("No symptoms")) {
                this.noSymptoms = st;
            } else if (st.getName().equals("Mild symptoms")) {
                this.mildSymptoms = st;
            } else if (st.getName().equals("Severe Symptoms")) {
                this.severeSymptoms = st;
            } else if (st.getName().equals("Critical symptoms")) {
                this.criticalSymptoms = st;
            }
        }
    }

    public Model(String name) {
        this.modelName = name;
        this.male = new SexeType("male", 0d);
        this.female = new SexeType("female", 0d);
        this.under4 = new HumanAgeType("under4", 0, 4, 5d, 0d, 0d, 0d);
        this.between4and10 = new HumanAgeType("between4and10", 5, 10, 0d, 0d, 0d, 0d);
        this.between11and18 = new HumanAgeType("between11and18", 11, 18, 0d, 0d, 0d, 0d);
        this.between19and27 = new HumanAgeType("between19and27", 19, 27, 0d, 0d, 0d, 0d);
        this.between28and40 = new HumanAgeType("between28and40", 28, 40, 0d, 0d, 0d, 0d);
        this.between41and50 = new HumanAgeType("between41and50", 41, 50, 0d, 0d, 0d, 0d);
        this.between51and60 = new HumanAgeType("between51and60", 51, 60, 0d, 0d, 0d, 0d);
        this.between61and70 = new HumanAgeType("between61and70", 61, 70, 0d, 0d, 0d, 0d);
        this.between71and80 = new HumanAgeType("between71and80", 71, 80, 0d, 0d, 0d, 0d);
        this.above80 = new HumanAgeType("above80", 81, 100, 0d, 0d, 0d, 0d);
        this.noSymptoms = new SymptomsType("No symptoms", 0d, 0d, 0);
        this.mildSymptoms = new SymptomsType("Mild symptoms", 0d, 0d, 0);
        this.severeSymptoms = new SymptomsType("Severe Symptoms", 0d, 0d, 0);
        this.criticalSymptoms = new SymptomsType("Critical symptoms", 0d, 0d, 0);
        this.listSymptomsType.add(this.noSymptoms);
        this.listSymptomsType.add(this.mildSymptoms);
        this.listSymptomsType.add(this.severeSymptoms);
        this.listSymptomsType.add(this.criticalSymptoms);

        this.sick = new HumanStat("Sick", 0d);
        this.immune = new HumanStat("Immune", 0d);
        this.healthy = new HumanStat("Healthy", 0d);
        this.infected = new HumanStat("Infected", 0d);
        this.dead = new HumanStat("Dead", 0d);
        this.inHospital = new HumanStat("InHospital", 0d);
        this.inIcu = new HumanStat("InIcu", 0d);
    }

    public void initHumanAgeTypePer() {
        this.listHumanAgeTypePercentage.add(this.under4);
        this.listHumanAgeTypePercentage.add(this.between4and10);
        this.listHumanAgeTypePercentage.add(this.between11and18);
        this.listHumanAgeTypePercentage.add(this.between19and27);
        this.listHumanAgeTypePercentage.add(this.between28and40);
        this.listHumanAgeTypePercentage.add(this.between41and50);
        this.listHumanAgeTypePercentage.add(this.between51and60);
        this.listHumanAgeTypePercentage.add(this.between61and70);
        this.listHumanAgeTypePercentage.add(this.between71and80);
        this.listHumanAgeTypePercentage.add(this.above80);
    }

    public void initHumanSexe() {
        this.listSexeType.add(this.male);
        this.listSexeType.add(this.female);
    }

    public void initHumanSymptomsType() {
        this.listSymptomsType.add(this.noSymptoms);
        this.listSymptomsType.add(this.mildSymptoms);
        this.listSymptomsType.add(this.severeSymptoms);
        this.listSymptomsType.add(this.criticalSymptoms);
    }

    public String getModelName() {
        return modelName;
    }

    public HumanAgeType getUnder4() {
        return under4;
    }

    public HumanAgeType getBetween4and10() {
        return between4and10;
    }

    public HumanAgeType getBetween11and18() {
        return between11and18;
    }

    public HumanAgeType getBetween19and27() {
        return between19and27;
    }

    public HumanAgeType getBetween28and40() {
        return between28and40;
    }

    public HumanAgeType getBetween41and50() {
        return between41and50;
    }

    public HumanAgeType getBetween51and60() {
        return between51and60;
    }

    public HumanAgeType getBetween61and70() {
        return between61and70;
    }

    public HumanAgeType getBetween71and80() {
        return between71and80;
    }

    public HumanAgeType getAbove80() {
        return above80;
    }

    public SexeType getMale() {
        return male;
    }

    public SexeType getFemale() {
        return female;
    }

    public SymptomsType getNoSymptoms() {
        return noSymptoms;
    }

    public SymptomsType getMildSymptoms() {
        return mildSymptoms;
    }

    public SymptomsType getSevereSymptoms() {
        return severeSymptoms;
    }

    public SymptomsType getCriticalSymptoms() {
        return criticalSymptoms;
    }

    public HumanStat getSick() {
        return sick;
    }

    public HumanStat getHealthy() {
        return healthy;
    }

    public HumanStat getImmune() {
        return immune;
    }

    public HumanStat getInfected() {
        return infected;
    }

    public HumanStat getDead() {
        return dead;
    }

    public HumanStat getInHospital() {
        return inHospital;
    }

    public HumanStat getInIcu() {
        return inIcu;
    }

    public List<HumanAgeType> getListHumanAgeTypePercentage() {
        return listHumanAgeTypePercentage;
    }

    public List<SexeType> getListSexeType() {
        return listSexeType;
    }

    public List<SymptomsType> getListSymptomsType() {
        return listSymptomsType;
    }

    public Map<Integer, Location> getMapLocation() {
        return mapLocation;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public boolean isNewModel() {
        return newModel;
    }

    public void setNewModel(boolean newModel) {
        this.newModel = newModel;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

}
