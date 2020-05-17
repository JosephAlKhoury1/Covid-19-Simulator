package models.locationFactories1;

import models.location1.*;

/**
 *
 * @author Joseph
 */
public class UniversityFactory extends LocationFactory {

    public static final UniversityFactory INSTANCE = new UniversityFactory();

    @Override
    public Location creatLocation(String name, int x, int y, double average_sick, double openTime, double closeTime) {
        return new University(name, x, y, average_sick, openTime, closeTime);
    }

    @Override
    public int getWTile() {
        return LocationData.WTILEUNIVERSITY;
    }

    @Override
    public int getHTile() {
        return LocationData.HTILEUNIVERSITY;
    }

}
