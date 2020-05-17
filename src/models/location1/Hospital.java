package models.location1;

import controller.locationController.HospitalController;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import models.client1.Data;
import views.tile.Tile;

/**
 *
 * @author Joseph
 */
public class Hospital extends Location {

    private double openTime;
    private double closeTime;

    public Hospital(String name, int x, int y, double average_sick, int locationCategoryId, double openTime, double closeTime) {
        super(name, x, y, average_sick, locationCategoryId);
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.setWidth(LocationData.WTILEHOSPITAL * Data.TileWidth);
        this.setHeight(LocationData.HTILEHOSPITAL * Data.TileHeight);
        loadImage();
    }

    public Hospital(String name, int x, int y, double average_sick, double openTime, double closeTime) {
        super(name, x, y, average_sick);
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.setWidth(LocationData.WTILEHOSPITAL * Data.TileWidth);
        this.setHeight(LocationData.HTILEHOSPITAL * Data.TileHeight);
        loadImage();
    }

    public Hospital(int id, String name, int x, int y, int width, int height, double average_sick,
            double openTime, double closeTime, int locationCategoryId) {
        super(id, name, x, y, width, height, average_sick, locationCategoryId);
        this.openTime = openTime;
        this.closeTime = closeTime;
        loadImage();
    }

    public Hospital() {
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
        ImageIcon ii = new ImageIcon("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\Covid-19Sim\\src\\models\\resources\\hospital.png");
        image = ii.getImage();
    }

    @Override
    public void initPopulation() {
    }

    @Override
    public void save() {
        if (this.isDeleted()) {
            if (this.id != -1) {
                HospitalController.INSTANCE.delete(this.id);
                for (Tile t : this.listTile) {
                    t.setDrawable(true);
                    t.setWalking(true);
                }
                return;
            }
        }
        if (this.isNew) {
            HospitalController.INSTANCE.insert(this);
            this.isNew = false;
            this.saved = true;
        } else {
            if (!this.saved) {
                HospitalController.INSTANCE.update(this);
                this.saved = true;
            } else {

            }
        }
    }
}
