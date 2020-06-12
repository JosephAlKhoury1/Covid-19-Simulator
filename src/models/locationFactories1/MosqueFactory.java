package models.locationFactories1;

import models.client1.City;
import models.location1.*;

/**
 *
 * @author Joseph
 */
public class MosqueFactory extends LocationFactory {

    public static final MosqueFactory INSTANCE = new MosqueFactory();

    @Override
    public Location creatLocation(String name, int x, int y, double average_sick, int fixed, int openTime, int closeTime, String days, City city) {
        return new Mosque(name, x, y, average_sick, fixed, openTime, closeTime, days, city);
    }

    @Override
    public int getWTile() {
        return LocationData.WTILEMOSQUE;
    }

    @Override
    public int getHTile() {
        return LocationData.HTILEMOSQUE;
    }

}
