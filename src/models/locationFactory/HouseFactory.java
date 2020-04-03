/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.locationFactory;

import models.location.House;
import models.location.Location;

/**
 *
 * @author Joseph
 */
public class HouseFactory extends LocationFactory{

    @Override
    protected Location createLocation(int id, int x, int y, int width, int height, double average_sick) {
       return new House(id, x, y, width, height, average_sick);
    }
    
}
