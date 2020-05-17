package models.locationFactories1;

import models.location1.*;

public class ChurchFactory extends LocationFactory {

    public static final ChurchFactory INSTANCE = new ChurchFactory();

    @Override
    public Location creatLocation(String name, int x, int y, double average_sick, double openTime, double closeTime) {
        return new Church(name, x, y, average_sick, openTime, closeTime);
    }

    @Override
    public int getWTile() {
        return LocationData.WTILECHURCH;
    }

    @Override
    public int getHTile() {
        return LocationData.HTILECHURCH;
    }

}
