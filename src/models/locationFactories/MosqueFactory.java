/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.locationFactories;

import models.client.City;
import models.location.Location;
import models.location.Mosque;

/**
 *
 * @author Joseph
 */
public class MosqueFactory extends LocationFactory {

    public static final MosqueFactory INSTANCE = new MosqueFactory();

    @Override
    public Location creatLocation(int x, int y, double average_sick, City city) {
        return new Mosque(x, y, average_sick, city);
    }

}
