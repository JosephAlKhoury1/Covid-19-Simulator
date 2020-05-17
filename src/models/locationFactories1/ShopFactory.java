package models.locationFactories1;

import models.location1.Location;
import models.location1.LocationData;
import models.location1.Shop;

public class ShopFactory extends LocationFactory {

    public static final ShopFactory INSTANCE = new ShopFactory();

    @Override
    public Location creatLocation(String name, int x, int y, double average_sick, double openTime, double closeTime) {
        return new Shop(name, x, y, average_sick, openTime, closeTime);
    }

    @Override
    public int getWTile() {
        return LocationData.WTILESHOP;
    }

    @Override
    public int getHTile() {
        return LocationData.HTILESHOP;
    }

}
