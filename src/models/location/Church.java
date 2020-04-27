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
public class Church extends Location {

    public Church(int x, int y, double average_sick, City city) {
        super(x, y, average_sick, city);
        this.setWidth(LocationData.WTILECHURCH * Data.TileWidth);
        this.setHeight(LocationData.HTILECHURCH * Data.TileHeight);
        loadImage();
    }

    public Church() {
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, city.getCityPanel());
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    protected void loadImage() {
        ImageIcon ii = new ImageIcon("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\Covid-19Sim\\src\\models\\resources\\Church.png");
        image = ii.getImage();
    }

    @Override
    public void initPopulation() {
    }

}
