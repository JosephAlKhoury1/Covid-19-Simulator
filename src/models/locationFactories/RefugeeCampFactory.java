package models.locationFactories;

import models.client.City;
import models.location.Location;
import models.location.RefugeeCamp;

/**
 *
 * @author Joseph
 */
public class RefugeeCampFactory extends LocationFactory {

    public static final RefugeeCampFactory INSTANCE = new RefugeeCampFactory();

    @Override
    public Location creatLocation(int x, int y, double average_sick, City city) {
        return new RefugeeCamp(x, y, average_sick, city);
    }

}
