package models.locationFactories;

import models.client.City;
import models.location.Location;
import models.location.Restaurant;

/**
 *
 * @author Joseph
 */
public class RestaurantFactory extends LocationFactory {

    public static final RestaurantFactory INSTANCE = new RestaurantFactory();

    @Override
    public Location creatLocation(int x, int y, double average_sick, City city) {
        return new Restaurant(x, y, average_sick, city);
    }
}
