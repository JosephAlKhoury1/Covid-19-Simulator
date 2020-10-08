package models.location1;

import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import models.client1.City;
import models.client1.Data;

/**
 *
 * @author Joseph
 */
public class RefugeeCamp extends Location {


    public RefugeeCamp(String name, int x, int y, double average_sick, int locationCategoryId, City city) {
        super(name, x, y, average_sick,  locationCategoryId, city);
        this.setWidth(LocationData.WTILEREFUGEECAMP * Data.TileWidth);
        this.setHeight(LocationData.HTILEREFUGEECAMP * Data.TileHeight);
        loadImage();
    }

    public RefugeeCamp(String name, int x, int y, double average_sick,  City city) {
        super(name, x, y, average_sick, city);
        this.setWidth(LocationData.WTILEREFUGEECAMP * Data.TileWidth);
        this.setHeight(LocationData.HTILEREFUGEECAMP * Data.TileHeight);
        loadImage();
    }

    public RefugeeCamp(int id, String name, int x, int y, int width, int height, double average_sick, int locationCategoryId, City c) {
        super(id, name, x, y, width, height, average_sick, locationCategoryId, c);
        loadImage();
    }

    public RefugeeCamp() {
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, map);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    protected void loadImage() {
        ImageIcon ii = new ImageIcon("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\Covid-19Sim\\src\\models\\resources\\refugee camp.png");
        image = ii.getImage();
    }

    @Override
    public void initPopulation() {
    }

    @Override
    public void save() {

    }
}
