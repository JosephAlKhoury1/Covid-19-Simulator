package models.location;

import java.awt.Graphics;
import models.client.City;

/**
 *
 * @author Joseph
 */
public class Restaurant extends Location {

    public Restaurant(int x, int y, double average_sick, City city) {
        super(x, y, average_sick, city);
    }

    @Override
    public void draw(Graphics g) {
    }

    @Override
    protected void loadImage() {
    }

    @Override
    public void initPopulation() {
    }

}
