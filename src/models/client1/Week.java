package models.client1;

import java.util.ArrayList;
import java.util.List;

public class Week {

    private Day currentDay;
    private int hour;
    private int minute;
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
        this.listDay = new ArrayList();
        this.listDay.add(MONDAY);
        this.listDay.add(TUESDAY);
        this.listDay.add(WEDNESDAY);
        this.listDay.add(THURSDAY);
        this.listDay.add(FRIDAY);
        this.listDay.add(SATURDAY);
        this.listDay.add(SUNDAY);
    }

    public Week(City c) {
        this.city = c;
        this.currentDay = MONDAY;
        this.hour = 0;
        this.listDay = new ArrayList();
        this.listDay.add(MONDAY);
        this.listDay.add(TUESDAY);
        this.listDay.add(WEDNESDAY);
        this.listDay.add(THURSDAY);
        this.listDay.add(FRIDAY);
        this.listDay.add(SATURDAY);
        this.listDay.add(SUNDAY);
    }

    public List<Day> getListDay() {
        return listDay;
    }

    public void setListDay(List<Day> listDay) {
        this.listDay = listDay;
    }

    public void changeTime() {
        this.minute++;
        if (this.minute == 60) {
            this.hour++;
            this.minute = 0;
            this.city.changeHour(this.hour);
            if (this.hour == 24) {
                this.hour = 0;
                int i = currentDay.getIndex();
                this.city.setDayChanged(true);
                i++;
                if (i > 6) {
                    currentDay = listDay.get(0);
                    weekNumber++;
                } else {
                    //System.out.println("i = " + (i));
                    currentDay = listDay.get(i);
                }
                this.city.changeDay(this.currentDay);
            }
        }
        this.currentDay.setHour(hour);
        this.currentDay.setMinute(minute);
    }

    public Day getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(Day currentDay) {
        this.currentDay = currentDay;
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

}
