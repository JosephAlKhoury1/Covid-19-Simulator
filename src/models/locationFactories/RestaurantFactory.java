package models.locationFactories;

import models.location.Restaurant;
import models.location.LocationData;
import models.location.Location;
import models.client.City;

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
