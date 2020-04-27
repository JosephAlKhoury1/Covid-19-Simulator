/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.locationFactories;

import models.client.City;
import models.location.Location;
import models.location.School;

/**
 *
 * @author Joseph
 */
public class SchoolFactory extends LocationFactory {

    public static final SchoolFactory INSTANCE = new SchoolFactory();

    @Override
    public Location creatLocation(int x, int y, double average_sick, City city) {
        return new School(x, y, average_sick, city);
    }

}
