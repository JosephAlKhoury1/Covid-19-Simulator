/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.locationFactories;

import models.location.Location;

/**
 *
 * @author Joseph
 */
public abstract class LocationFactory {

    public abstract Location creatLocation(int x, int y, int width, int length);
}
