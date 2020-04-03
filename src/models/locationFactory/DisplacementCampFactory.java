/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.locationFactory;

import models.location.DisplacementCamp;
import models.location.Location;

/**
 *
 * @author Joseph
 */
public class DisplacementCampFactory extends LocationFactory {

    @Override
    protected Location createLocation(int id, int x, int y, int width, int height, double average_sick) {
        return new DisplacementCamp(id, x, y, width, height, average_sick);
    }

}
