package models.locationFactories1;

import models.client1.City;
import models.location1.*;

/**
 *
 * @author Joseph
 */
public class RefugeeCampFactory extends LocationFactory {

    public static final RefugeeCampFactory INSTANCE = new RefugeeCampFactory();

    @Override
    public Location creatLocation(String name, int x, int y, double average_sick,  City city) {
        return new RefugeeCamp(name, x, y, average_sick, city);
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
