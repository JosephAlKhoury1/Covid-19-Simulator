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
public class DisplacementCamp extends Location {

    private int openTime;
    private int closeTime;

    public DisplacementCamp(String name, int x, int y, double average_sick, int fixed, int locationCategoryId, City city) {
        super(name, x, y, average_sick, "", locationCategoryId, fixed, city);
        this.setWidth(LocationData.WTILEDISPLACEMENTCAMP * Data.TileWidth);
        this.setHeight(LocationData.HTILEDISPLACEMENTCAMP * Data.TileHeight);
        loadImage();
    }

    public DisplacementCamp(int id, String name, int x, int y, int width, int height, double average_sick, int fixed, int locationCategoryId, City c) {
        super(id, name, x, y, width, height, average_sick, "", fixed, locationCategoryId, c);
        loadImage();
    }

    public DisplacementCamp(String name, int x, int y, double average_sick, int fixed, int openTime, int closeTime, City city) {
        super(name, x, y, average_sick, "", fixed, city);
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

    public int getOpenTime() {
        return openTime;
    }

    @Override
    public void setOpenTime(int openTime) {
        this.openTime = openTime;
    }

    @Override
    public int getCloseTime() {
        return closeTime;
    }

    @Override
    public void setCloseTime(int closeTime) {
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
