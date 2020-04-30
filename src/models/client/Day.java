/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.client;

import java.util.ArrayList;
import java.util.List;
import models.location.Location;

/**
 *
 * @author Joseph
 */
public enum Day {
    monday(DayName.monday, DayName.tuesday, 1),
    tuesday(DayName.tuesday, DayName.wednesday, 2),
    wednesday(DayName.wednesday, DayName.thursday, 3),
    thursday(DayName.thursday, DayName.friday, 4),
    friday(DayName.friday, DayName.saturday, 5),
    saturday(DayName.saturday, DayName.sunday, 6),
    sunday(DayName.sunday, DayName.monday, 7);

    private DayName day;
    private DayName nextDay;
    private int index;
    private List<Location> listLocation;

    private Day(DayName dayName, DayName nextDay, int index) {
        this.day = dayName;
        this.nextDay = nextDay;
        this.index = index;
        listLocation = new ArrayList();
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
}
