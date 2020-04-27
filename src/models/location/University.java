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
public class University extends Location {

    public University(int x, int y, double average_sick, City city) {
        super(x, y, average_sick, city);
        this.fixedLocation = true;
        this.setWidth(LocationData.WTILEUNIVERSITY * Data.TileWidth);
        this.setHeight(LocationData.HTILEUNIVERSITY * Data.TileHeight);
        loadImage();
    }

    public University() {
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, city.getCityPanel());
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    protected void loadImage() {
        ImageIcon ii = new ImageIcon("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\Covid-19Sim\\src\\models\\resources\\university.jpg");
        image = ii.getImage();
    }

    @Override
    public void initPopulation() {
    }

}
