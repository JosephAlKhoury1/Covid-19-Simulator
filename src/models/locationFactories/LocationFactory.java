package models.locationFactories;

import models.client.City;
import models.location.Location;

/**
 *
 * @author Joseph
 */
public abstract class LocationFactory {

    public abstract Location creatLocation(String name, int x, int y, double average_sick, City city);

    public abstract int getWTile();

    public abstract int getHTile();
}
