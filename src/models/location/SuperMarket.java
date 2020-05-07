/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class SuperMarket extends Location {

    public SuperMarket(int x, int y, double average_sick, City city) {
        super(x, y, average_sick, city);
        this.fixedLocation = true;
        this.setWidth(LocationData.WTILESUPERMARKET * Data.TileWidth);
        this.setHeight(LocationData.HTILESUPERMARKET * Data.TileHeight);
        loadImage();
    }

    public SuperMarket() {
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, city.getCityPanel());
        //g.drawRect(x, y, width, height);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    protected void loadImage() {
        ImageIcon ii = new ImageIcon("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\Covid-19 Simulator\\src\\models\\resources\\superMarket.png");
        image = ii.getImage();
    }

    @Override
    public void initPopulation() {
    }
}
