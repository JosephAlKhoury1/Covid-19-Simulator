package models.locationFactories;

import models.location.LocationData;
import models.location.Mosque;
import models.location.Location;
import models.client.City;

/**
 *
 * @author Joseph
 */
public class MosqueFactory extends LocationFactory {

    public static final MosqueFactory INSTANCE = new MosqueFactory();

    @Override
    public Location creatLocation(String name, int x, int y, double average_sick,  City city) {
        return new Mosque(name, x, y, average_sick, city);
    }

    @Override
    public int getWTile() {
        return LocationData.WTILEMOSQUE;
    }

    @Override
    public int getHTile() {
        return LocationData.HTILEMOSQUE;
    }

}
