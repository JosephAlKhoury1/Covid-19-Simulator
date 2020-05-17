/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.location1;

import controller.locationController.SchoolController;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import models.client1.Data;
import views.tile.Tile;

/**
 *
 * @author Joseph
 */
public class School extends Location {

    private double openTime;
    private double closeTime;

    public School(String name, int x, int y, double average_sick, int locationCategoryId, double openTime, double closeTime) {
        super(name, x, y, average_sick, locationCategoryId);
        this.fixedLocation = true;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.setWidth(LocationData.WTILESCHOOL * Data.TileWidth);
        this.setHeight(LocationData.HTILESCHOOL * Data.TileHeight);
        loadImage();
    }

    public School(String name, int x, int y, double average_sick, double openTime, double closeTime) {
        super(name, x, y, average_sick);
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.setWidth(LocationData.WTILESCHOOL * Data.TileWidth);
        this.setHeight(LocationData.HTILESCHOOL * Data.TileHeight);
        loadImage();
    }

    public School(int id, String name, int x, int y, int width, int height, double average_sick,
            double openTime, double closeTime, int locationCategoryId) {
        super(id, name, x, y, width, height, average_sick, locationCategoryId);
        this.openTime = openTime;
        this.closeTime = closeTime;
        loadImage();
    }

    public School() {
    }

    public double getOpenTime() {
        return openTime;
    }

    @Override
    public void setOpenTime(double openTime) {
        this.openTime = openTime;
    }

    public double getCloseTime() {
        return closeTime;
    }

    @Override
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
        ImageIcon ii = new ImageIcon("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\Covid-19Sim\\src\\models\\resources\\school.png");
        image = ii.getImage();
    }

    @Override
    public void initPopulation() {
    }

    @Override
    public void save() {
        if (this.isDeleted()) {
            if (this.id != -1) {
                SchoolController.INSTANCE.delete(this.id);
                for (Tile t : this.listTile) {
                    t.setDrawable(true);
                    t.setWalking(true);
                }
                return;
            }
        }
        if (this.isNew) {
            SchoolController.INSTANCE.insert(this);
            this.isNew = false;
            this.saved = true;
        } else {
            if (!this.saved) {
                SchoolController.INSTANCE.update(this);
                this.saved = true;
            } else {

            }
        }
    }
}
