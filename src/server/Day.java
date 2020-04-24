/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author Joseph
 */
public enum Day {
    monday(DayName.monday, DayName.tuesday),
    tuesday(DayName.tuesday, DayName.wednesday),
    wednesday(DayName.wednesday, DayName.thursday),
    thursday(DayName.thursday, DayName.friday),
    friday(DayName.friday, DayName.saturday),
    saturday(DayName.saturday, DayName.sunday),
    sunday(DayName.sunday, DayName.monday);

    private DayName day;
    private DayName nextDay;

    private Day(DayName dayName, DayName nextDay) {
        this.day = day;
        this.nextDay = nextDay;
    }
}
