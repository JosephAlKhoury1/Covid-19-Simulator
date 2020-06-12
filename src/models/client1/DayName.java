/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.client1;

/**
 *
 * @author Joseph
 */
public enum DayName {
    monday("Monday"),
    tuesday("Tuesday"),
    wednesday("Wednesday"),
    thursday("Thursday"),
    friday("Friday"),
    saturday("Saturday"),
    sunday("Sunday");
    private String name;

    private DayName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
