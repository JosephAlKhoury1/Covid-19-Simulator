package models.locationFactories1;

import models.client1.City;
import models.location1.Location;
import models.location1.LocationData;
import models.location1.Shop;

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
