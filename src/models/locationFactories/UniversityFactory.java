package models.locationFactories;

import models.location.LocationData;
import models.location.University;
import models.location.Location;
import models.client.City;

/**
 *
 * @author Joseph
 */
public class UniversityFactory extends LocationFactory {

    public static final UniversityFactory INSTANCE = new UniversityFactory();

    @Override
    public Location creatLocation(String name, int x, int y, double average_sick, City city) {
        return new University(name, x, y, average_sick, city);
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
