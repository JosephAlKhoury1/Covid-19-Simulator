package models.locationFactories;

import models.client.City;
import models.location.Factory;
import models.location.Location;
import models.location.LocationData;

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
