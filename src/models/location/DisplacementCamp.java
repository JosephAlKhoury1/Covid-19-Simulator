/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.location;

import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import models.client.City;
import models.client.Data;

/**
 *
 * @author Joseph
 */
public class DisplacementCamp extends Location{

    public DisplacementCamp(int x, int y, double average_sick, City city) {
        super(x, y, average_sick,city);
        this.setWidth(LocationData.WTILEDISPLACEMENTCAMP * Data.TileWidth);
        this.setHeight(LocationData.HTILEDISPLACEMENTCAMP * Data.TileHeight);
        loadImage();
    }

    public DisplacementCamp() {
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height,city.getCityPanel());
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    protected void loadImage() {
        ImageIcon ii = new ImageIcon("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\Covid-19Sim\\src\\models\\resources\\displacement camp.jpg");
        image = ii.getImage();
    }

    @Override
    public void initPopulation() {
    }


    
}
