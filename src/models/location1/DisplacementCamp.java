package models.location1;

import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import models.client1.Data;

/**
 *
 * @author Joseph
 */
public class DisplacementCamp extends Location {

    private double openTime;
    private double closeTime;

    public DisplacementCamp(String name, int x, int y, double average_sick, int locationCategoryId) {
        super(name, x, y, average_sick, locationCategoryId);
        this.setWidth(LocationData.WTILEDISPLACEMENTCAMP * Data.TileWidth);
        this.setHeight(LocationData.HTILEDISPLACEMENTCAMP * Data.TileHeight);
        loadImage();
    }

    public DisplacementCamp(int id, String name, int x, int y, int width, int height, double average_sick, int locationCategoryId) {
        super(id, name, x, y, width, height, average_sick, locationCategoryId);
        loadImage();
    }

    public DisplacementCamp(String name, int x, int y, double average_sick, double openTime, double closeTime) {
        super(name, x, y, average_sick);
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.setWidth(LocationData.WTILEDISPLACEMENTCAMP * Data.TileWidth);
        this.setHeight(LocationData.HTILEDISPLACEMENTCAMP * Data.TileHeight);
        loadImage();
    }

    public DisplacementCamp() {
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, map);
        Toolkit.getDefaultToolkit().sync();
    }

    public double getOpenTime() {
        return openTime;
    }

    @Override
    public void setOpenTime(double openTime) {
        this.openTime = openTime;
    }

    public Double getCloseTime() {
        return closeTime;
    }

    @Override
    public void setCloseTime(double closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    protected void loadImage() {
        ImageIcon ii = new ImageIcon("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\Covid-19Sim\\src\\models\\resources\\displacement camp.jpg");
        image = ii.getImage();
    }

    @Override
    public void initPopulation() {
    }
@Override
    public void save() {
        
    }
}
