package models.client;

/**
 *
 * @author Joseph
 */
public class Week {

    private Day[] dayTab = {Day.monday, Day.tuesday, Day.wednesday, Day.thursday, Day.friday, Day.saturday, Day.sunday};
    private Day currentDay;
    private int hour;
    private int minute;
    private int weekNumber = 0;

    public Week(Day currentDay, int hour, int minute) {
        this.currentDay = currentDay;
        this.hour = hour;
        this.minute = minute;
    }

    public void changeTime() {
        this.minute++;
        if (this.minute == 60) {
            this.hour++;
            this.minute = 0;
            if (this.hour == 24) {
                this.hour = 0;
                int i = currentDay.getIndex();
                i++;
                if (i > 6) {
                    currentDay = dayTab[0];
                    weekNumber++;
                } else {
                    currentDay = dayTab[i - 1];
                }
            }
        }
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

}
