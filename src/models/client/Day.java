package models.client;

import models.location.LocationCategory;
import models.location.Location;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Day implements Cloneable {

    private DayName day;
    private DayName nextDay;
    private int index;
    private List<Location> listLocation;
    private Map<String, LocationCategory> listLocationCategory;

    private int hour, minute;

    public Day(DayName dayName, DayName nextDay, int index) {
        this.day = dayName;
        this.hour = 0;
        this.nextDay = nextDay;
        this.index = index;
        this.listLocation = new ArrayList();
        this.listLocationCategory = new HashMap();
    }

    public int getIndex() {
        return this.index;
    }

    public void addLocation(Location l) {
        this.listLocation.add(l);
    }

    public void removeLocation(Location l) {
        this.listLocation.remove(l);
    }

    public DayName getDay() {
        return day;
    }

    public Map<String, LocationCategory> getListLocationCategory() {
        return listLocationCategory;
    }

    public void setListLocationCategory(Map<String, LocationCategory> listLocationCategory) {
        this.listLocationCategory = listLocationCategory;
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        Day d = (Day) super.clone();
        d.day = this.day;
        d.nextDay = nextDay;
        d.listLocation = new ArrayList();
        return d;
    }

    public List<LocationCategory> getLocationCategory(String kind) {
        List<LocationCategory> list = new ArrayList();

        for (Entry<String, LocationCategory> lc : this.listLocationCategory.entrySet()) {
            if (lc.getValue().getKind().equals(kind)) {
                list.add(lc.getValue());
            }
        }
        return list;
    }
}
