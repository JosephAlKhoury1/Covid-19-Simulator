package models.locationFactories1;

import models.client1.City;
import models.location1.*;

public class ChurchFactory extends LocationFactory {

    public static final ChurchFactory INSTANCE = new ChurchFactory();

    @Override
    public Location creatLocation(String name, int x, int y, double average_sick, int fixed, int openTime, int closeTime, String days, City city) {
        return new Church(name, x, y, average_sick, fixed, openTime, closeTime, days,city);
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
