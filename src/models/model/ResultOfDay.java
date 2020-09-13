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

    public ResultOfDay(int health, int immune, int death, List<SymptomStage> listHospital, List<SymptomStage> listNonHospital, int week, String dayName) {
        this.health = health;
        this.immune = immune;
        this.death = death;
        this.week = week;
        this.dayName = dayName;
        listStageResult = new HashMap();
        for (SymptomStage ss : listNonHospital) {
            listStageResult.put(ss.getName(), ss.getListMember().size());
        }
        for (SymptomStage ss : listHospital) {
            listStageResult.put(ss.getName(), ss.getListMember().size());
        }
    }

    public int getWeek() {
        return week;
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
