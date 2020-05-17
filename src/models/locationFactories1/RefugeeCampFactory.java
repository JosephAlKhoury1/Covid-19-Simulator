package models.locationFactories1;

import models.location1.*;

/**
 *
 * @author Joseph
 */
public class RefugeeCampFactory extends LocationFactory {

    public static final RefugeeCampFactory INSTANCE = new RefugeeCampFactory();

    @Override
    public Location creatLocation(String name, int x, int y, double average_sick, double openTime, double closeTime) {
        return new RefugeeCamp(name, x, y, average_sick, openTime, closeTime);
    }

    @Override
    public int getWTile() {
        return LocationData.WTILEREFUGEECAMP;
    }

    @Override
    public int getHTile() {
        return LocationData.HTILEREFUGEECAMP;
    }

}
