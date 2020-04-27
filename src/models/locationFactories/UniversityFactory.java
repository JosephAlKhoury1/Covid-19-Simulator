/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.locationFactories;

import models.client.City;
import models.location.Location;
import models.location.University;

/**
 *
 * @author Joseph
 */
public class UniversityFactory extends LocationFactory {

    public static final UniversityFactory INSTANCE = new UniversityFactory();

    @Override
    public Location creatLocation(int x, int y, double average_sick, City city) {
        return new University(x, y, average_sick, city);
    }

}
