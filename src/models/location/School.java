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
import models.City;
import static models.location.LocationData.*;

/**
 *
 * @author Joseph
 */
public class School extends Location {

    public School(int x, int y, double average_sick, JPanel panel, City city) {
        super(x, y,WTILESCHOOL,HTILESCHOOL, average_sick, panel, city);
        loadImage();
    }

    public School() {
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, panel);
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

}
