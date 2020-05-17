/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.locationFactories1;

import models.location1.*;

/**
 *
 * @author Joseph
 */
public class SchoolFactory extends LocationFactory {

    public static final SchoolFactory INSTANCE = new SchoolFactory();

    @Override
    public Location creatLocation(String name, int x, int y, double average_sick, double openTime, double closeTime) {
        return new School(name, x, y, average_sick, openTime, closeTime);
    }

    @Override
    public int getWTile() {
        return LocationData.WTILESCHOOL;
    }

    @Override
    public int getHTile() {
        return LocationData.HTILESCHOOL;
    }

}
