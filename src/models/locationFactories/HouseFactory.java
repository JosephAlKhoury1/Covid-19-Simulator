/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.locationFactories;

import models.client.City;
import models.location.House;
import models.location.Location;

/**
 *
 * @author Joseph
 */
public class HouseFactory extends LocationFactory {

    public static final HouseFactory INSTANCE = new HouseFactory();

    @Override
    public Location creatLocation(int x, int y, double average_sick, City city) {
        return new House(x, y, average_sick, city);
    }

}
