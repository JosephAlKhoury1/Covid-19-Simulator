package models.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Joseph
 */
public class ResultOfDay {

    private int health;
    private int immune;
    private int death;

    private int week;
    private String dayName;

    private Map<String, Integer> listStageResult;
    private int sick = 0;

    public ResultOfDay(int health, int immune, int death, List<SymptomStage> listHospital, List<SymptomStage> listNonHospital, int week, String dayName, int sick) {
        this.health = health;
        this.immune = immune;
        this.death = death;
        this.week = week;
        this.sick = sick;
        this.dayName = dayName;
        listStageResult = new HashMap();
        listNonHospital.forEach((ss) -> {
            listStageResult.put(ss.getName(), ss.getListMember().size());
        });
        listHospital.forEach((ss) -> {
            listStageResult.put(ss.getName(), ss.getListMember().size());
        });
        this.listStageResult.put("sick", this.sick);
    }

    public int getWeek() {
        return week;
    }

    public int getSick() {
        return sick;
    }

    public void setSick(int sick) {
        this.sick = sick;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getImmune() {
        return immune;
    }

    public void setImmune(int immune) {
        this.immune = immune;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public Map<String, Integer> getListStageResult() {
        return listStageResult;
    }

    public void setListStageResult(Map<String, Integer> listStageResult) {
        this.listStageResult = listStageResult;
    }

}
