package models.locationFactories1;

import models.location1.*;

/**
 *
 * @author Joseph
 */
public class HouseFactory extends LocationFactory {

    public static final HouseFactory INSTANCE = new HouseFactory();

    @Override
    public Location creatLocation(String name, int x, int y, double average_sick, double openTime, double closeTime) {
        return new House(name, x, y, average_sick);
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
