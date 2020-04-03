/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.locationFactory;

import models.location.Location;
import models.location.Mosque;

/**
 *
 * @author Joseph
 */
public class MosqueFactory extends LocationFactory {

    @Override
    protected Location createLocation(int id, int x, int y, int width, int height, double average_sick) {
        return new Mosque(id, x, y, width, height, average_sick);
    }

}
