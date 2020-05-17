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
public class DisplacementCampFactory extends LocationFactory {

    public static final DisplacementCampFactory INSTANCE = new DisplacementCampFactory();

    @Override
    public Location creatLocation(String name, int x, int y, double average_sick, double openTime, double closeTime) {
        return new DisplacementCamp(name, x, y, average_sick, openTime, closeTime);
    }

    @Override
    public int getWTile() {
        return LocationData.WTILEDISPLACEMENTCAMP;
    }

    @Override
    public int getHTile() {
        return LocationData.HTILEDISPLACEMENTCAMP;
    }

}
