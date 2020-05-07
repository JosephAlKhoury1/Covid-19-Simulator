package models.location;

import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import models.client.City;
import models.client.Data;

/**
 *
 * @author Joseph
 */
public class Restaurant extends Location {

    public Restaurant(int x, int y, double average_sick, City city) {
        super(x, y, average_sick, city);
        this.setWidth(LocationData.WTILERESTAURANT * Data.TileWidth);
        this.setHeight(LocationData.HTILERESTAURANT * Data.TileHeight);
        loadImage();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, city.getCityPanel());
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    protected void loadImage() {
        ImageIcon ii = new ImageIcon("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\Covid-19 Simulator\\src\\models\\resources\\restaurant.png");
        image = ii.getImage();
    }

    @Override
    public void initPopulation() {
    }

}
