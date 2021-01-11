package models.locationFactories;

import models.location.LocationData;
import models.location.House;
import models.location.Location;
import models.client.City;

/**
 *
 * @author Joseph
 */
public class HouseFactory extends LocationFactory {

    public static final HouseFactory INSTANCE = new HouseFactory();

    @Override
    public Location creatLocation(String name, int x, int y, double average_sick,  City city) {
        return new House(name, x, y, average_sick,  city);
    }

    @Override
    public int getWTile() {
        return LocationData.WTILEHOUSE;
    }

    @Override
    public int getHTile() {
        return LocationData.HTILEHOUSE;
    }

}
