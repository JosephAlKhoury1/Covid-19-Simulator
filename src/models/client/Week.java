package models.client;

import java.util.ArrayList;
import java.util.List;
import models.location.LocationCategory;
import models.model.ResultOfDay;

public class Week {

    private Day currentDay;
    private int hour;
    private int minute;
    private int second;
    private int weekNumber = 0;
    private List<Day> listDay;
    private City city;
    public final Day MONDAY = new Day(DayName.monday, DayName.tuesday, 0);
    public final Day TUESDAY = new Day(DayName.tuesday, DayName.wednesday, 1);
    public final Day WEDNESDAY = new Day(DayName.wednesday, DayName.thursday, 2);
    public final Day THURSDAY = new Day(DayName.thursday, DayName.friday, 3);
    public final Day FRIDAY = new Day(DayName.friday, DayName.saturday, 4);
    public final Day SATURDAY = new Day(DayName.saturday, DayName.sunday, 5);
    public final Day SUNDAY = new Day(DayName.sunday, DayName.monday, 6);

    public Week(Day currentDay, int hour, int minute) {
        this.currentDay = currentDay;
        this.hour = hour;
        this.minute = minute;
        this.second = 0;
        this.listDay = new ArrayList();
        this.listDay.add(0, MONDAY);
        this.listDay.add(1, TUESDAY);
        this.listDay.add(2, WEDNESDAY);
        this.listDay.add(3, THURSDAY);
        this.listDay.add(4, FRIDAY);
        this.listDay.add(5, SATURDAY);
        this.listDay.add(6, SUNDAY);
    }

    public Week(City c) {
        this.city = c;
        this.currentDay = MONDAY;
        this.hour = 0;
        this.second = 0;
        this.listDay = new ArrayList();
        this.listDay.add(0, MONDAY);
        this.listDay.add(1, TUESDAY);
        this.listDay.add(2, WEDNESDAY);
        this.listDay.add(3, THURSDAY);
        this.listDay.add(4, FRIDAY);
        this.listDay.add(5, SATURDAY);
        this.listDay.add(6, SUNDAY);
    }

    public void refresh() {
        this.currentDay = MONDAY;
        this.hour = 0;
        this.currentDay.setHour(0);
        this.minute = 0;
        this.currentDay.setMinute(0);
        this.weekNumber = 0;
    }

    public List<Day> getListDay() {
        return listDay;
    }

    public void setListDay(List<Day> listDay) {
        this.listDay = listDay;
    }

    public void changeTime() {
            this.minute++;
            this.second = 0;
            if (this.minute == 60) {
                this.hour++;
                this.minute = 0;
                this.city.changeHour(this.hour);
                if (this.hour == 24) {
                    this.hour = 0;
                    int i = currentDay.getIndex();
                    this.city.setDayChanged(true);
                    addResult();
                    i++;
                    if (i > 6) {
                        currentDay = listDay.get(0);
                        weekNumber++;
                    } else {
                        currentDay = listDay.get(i);
                    }
                    this.city.changeDay(this.currentDay);
                }
        }
        this.currentDay.setHour(hour);
        this.currentDay.setMinute(minute);
    }

    public void addResult() {
        ResultOfDay result = new ResultOfDay(city.getModel().getListHealth().size(), city.getModel().getListImmune().size(),
                city.getModel().getListDeath().size(), city.getModel().getListSymptomStage1sHospital(),
                city.getModel().getListSymptomStage1sNonHospital(), weekNumber + 1, currentDay.getDay().getName(),city.getModel().getTotalSick());

        city.getModel().getListResult().add(result);
    }

    public Day getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(Day currentDay) {
        this.currentDay = currentDay;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public Day getMONDAY() {
        return MONDAY;
    }

    public Day getTUESDAY() {
        return TUESDAY;
    }

    public Day getWEDNESDAY() {
        return WEDNESDAY;
    }

    public Day getTHURSDAY() {
        return THURSDAY;
    }

    public Day getFRIDAY() {
        return FRIDAY;
    }

    public Day getSATURDAY() {
        return SATURDAY;
    }

    public Day getSUNDAY() {
        return SUNDAY;
    }

    public List<LocationCategory> getLocationPerDay(String day, String kind) {
        for (Day d : this.listDay) {
            if (d.getDay().getName().equals(day)) {
                return d.getLocationCategory(kind);
            }
        }
        return null;
    }
    
    
}
