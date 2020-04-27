/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.locationFactories;

import models.client.City;
import models.location.Hospital;
import models.location.Location;

/**
 *
 * @author Joseph
 */
public class HospitalFactory extends LocationFactory {

    public static final HospitalFactory INSTANCE = new HospitalFactory();

    @Override
    public Location creatLocation(int x, int y, double average_sick, City city) {
        return new Hospital(x, y, average_sick, city);
    }

}
