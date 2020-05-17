package models.location1;

import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import models.client1.Data;

/**
 *
 * @author Joseph
 */
public class RefugeeCamp extends Location {

    private double openTime;
    private double closeTime;

    public RefugeeCamp(String name, int x, int y, double average_sick, int locationCategoryId) {
        super(name, x, y, average_sick, locationCategoryId);
        this.setWidth(LocationData.WTILEREFUGEECAMP * Data.TileWidth);
        this.setHeight(LocationData.HTILEREFUGEECAMP * Data.TileHeight);
        loadImage();
    }

    public RefugeeCamp(String name, int x, int y, double average_sick, double openTime, double closeTime) {
        super(name, x, y, average_sick);
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.setWidth(LocationData.WTILEREFUGEECAMP * Data.TileWidth);
        this.setHeight(LocationData.HTILEREFUGEECAMP * Data.TileHeight);
        loadImage();
    }

    public RefugeeCamp(int id, String name, int x, int y, int width, int height, double average_sick, int locationCategoryId) {
        super(id, name, x, y, width, height, average_sick, locationCategoryId);
        loadImage();
    }

    public RefugeeCamp() {
    }

    public double getOpenTime() {
        return openTime;
    }

    public void setOpenTime(double openTime) {
        this.openTime = openTime;
    }

    public double getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(double closeTime) {
        this.closeTime = closeTime;
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
