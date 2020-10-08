package models.locationFactories1;

import models.client1.City;
import models.location1.*;

/**
 *
 * @author Joseph
 */
public class RestaurantFactory extends LocationFactory {

    public static final RestaurantFactory INSTANCE = new RestaurantFactory();

    @Override
    public Location creatLocation(String name, int x, int y, double average_sick,  City city) {
        return new Restaurant(name, x, y, average_sick,  city);
    }

    @Override
    public int getWTile() {
        return LocationData.WTILERESTAURANT;
    }

    @Override
    public int getHTile() {
        return LocationData.HTILERESTAURANT;
    }
}
