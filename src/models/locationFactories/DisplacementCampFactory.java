package models.locationFactories;

import models.location.DisplacementCamp;
import models.location.LocationData;
import models.location.Location;
import models.client.City;

/**
 *
 * @author Joseph
 */
public class DisplacementCampFactory extends LocationFactory {

    public static final DisplacementCampFactory INSTANCE = new DisplacementCampFactory();

    @Override
    public Location creatLocation(String name, int x, int y, double average_sick,  City city) {
        return new DisplacementCamp(name, x, y, average_sick, city);
    }

    @Override
    public int getWTile() {
        return LocationData.WTILEDISPLACEMENTCAMP;
    }

    @Override
    public int getHTile() {
        return LocationData.HTILEDISPLACEMENTCAMP;
    }

}
