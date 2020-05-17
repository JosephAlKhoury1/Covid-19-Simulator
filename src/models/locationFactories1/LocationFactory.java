package models.locationFactories1;

import models.location1.Location;

/**
 *
 * @author Joseph
 */
public abstract class LocationFactory {

    public abstract Location creatLocation(String name, int x, int y, double average_sick, double openTime, double closeTime);

    public abstract int getWTile();

    public abstract int getHTile();
}
