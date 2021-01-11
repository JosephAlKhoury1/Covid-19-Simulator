package models.locationFactories;

import models.client.City;
import models.location.Location;
import models.location.LocationData;
import models.location.Shop;

public class ShopFactory extends LocationFactory {

    public static final ShopFactory INSTANCE = new ShopFactory();

    @Override
    public Location creatLocation(String name, int x, int y, double average_sick,  City city) {
        return new Shop(name, x, y, average_sick,city);
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
