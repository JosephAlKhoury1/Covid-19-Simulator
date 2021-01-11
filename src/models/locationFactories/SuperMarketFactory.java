package models.locationFactories;

import models.location.SuperMarket;
import models.location.LocationData;
import models.location.Location;
import models.client.City;

/**
 *
 * @author Joseph
 */
public class SuperMarketFactory extends LocationFactory {

    public static final SuperMarketFactory INSTANCE = new SuperMarketFactory();

    @Override
    public Location creatLocation(String name, int x, int y, double average_sick, City city) {
        return new SuperMarket(name, x, y, average_sick,  city);
    }

    @Override
    public int getWTile() {
        return LocationData.WTILESUPERMARKET;
    }

    @Override
    public int getHTile() {
        return LocationData.HTILESUPERMARKET;
    }
}
