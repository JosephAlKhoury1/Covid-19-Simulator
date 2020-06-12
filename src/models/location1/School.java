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
import models.client1.City;
import models.client1.Data;
import views.tile.Tile;

/**
 *
 * @author Joseph
 */
public class School extends Location {

    private int openTime;
    private int closeTime;

    public School(String name, int x, int y, double average_sick, int fixed, int locationCategoryId, int openTime, int closeTime, String days, City city) {
        super(name, x, y, average_sick, days, fixed, locationCategoryId, city);
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.days = days;
        this.openTimeToVisit = this.openTime;
        this.closeTimeToVisit = this.closeTime;
        this.workTime = this.closeTime - this.openTime;
        this.setWidth(LocationData.WTILESCHOOL * Data.TileWidth);
        this.setHeight(LocationData.HTILESCHOOL * Data.TileHeight);
        loadImage();
    }

    public School(String name, int x, int y, double average_sick, int fixed, int openTime, int closeTime, String days, City city) {
        super(name, x, y, average_sick, days, fixed, city);
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.days = days;
        this.openTimeToVisit = this.openTime;
        this.closeTimeToVisit = this.closeTime;
        this.setWidth(LocationData.WTILESCHOOL * Data.TileWidth);
        this.setHeight(LocationData.HTILESCHOOL * Data.TileHeight);
        this.workTime = this.closeTime - this.openTime;
        loadImage();
    }

    public School(int id, String name, int x, int y, int width, int height, double average_sick, int fixed,
            int openTime, int closeTime, String days, int locationCategoryId, City c) {
        super(id, name, x, y, width, height, average_sick, days, fixed, locationCategoryId, c);
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.openTimeToVisit = this.openTime;
        this.closeTimeToVisit = this.closeTime;
        this.workTime = this.closeTime - this.openTime;
        this.days = days;
        loadImage();
    }

    public School() {
    }

    @Override
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
