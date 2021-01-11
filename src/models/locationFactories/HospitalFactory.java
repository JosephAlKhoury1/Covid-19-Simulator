package models.locationFactories;

import models.location.Hospital;
import models.location.LocationData;
import models.location.Location;
import models.client.City;

/**
 *
 * @author Joseph
 */
public class HospitalFactory extends LocationFactory {

    public static final HospitalFactory INSTANCE = new HospitalFactory();

    @Override
    public Location creatLocation(String name, int x, int y, double average_sick,City city) {
        return new Hospital(name, x, y, average_sick,city);
    }

    @Override
    public int getWTile() {
        return LocationData.WTILEHOSPITAL;
    }

    @Override
    public int getHTile() {
        return LocationData.HTILEHOSPITAL;
    }

}
