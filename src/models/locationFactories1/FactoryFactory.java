package models.locationFactories1;

import models.client1.City;
import models.location1.Factory;
import models.location1.Location;
import models.location1.LocationData;

public class FactoryFactory extends LocationFactory {

    public static final FactoryFactory INSTANCE = new FactoryFactory();

    @Override
    public Location creatLocation(String name, int x, int y, double average_sick, City city) {
        return new Factory(name, x, y, average_sick,city);
    }

    @Override
    public int getWTile() {
        return LocationData.WTILEFACTORY;
    }

    @Override
    public int getHTile() {
        return LocationData.HTILEFACTORY;
    }

}
