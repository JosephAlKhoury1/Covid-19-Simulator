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
import models.client.MonteCarlo;
import models.client.ReligionType;
import models.member.Human;

/**
 *
 * @author Joseph
 */
public class House extends Location {

    private int nbPopulation = 0;
    private ReligionType religionType;

    public House(int x, int y, double average_sick, City city) {
        super(x, y, average_sick, city);
        this.religionType = MonteCarlo.getHouseReligionType();
        this.setWidth(LocationData.WTILEHOUSE * Data.TileWidth);
        this.setHeight(LocationData.HTILEHOUSE * Data.TileHeight);
        loadImage();
    }

    public House() {
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, city.getCityPanel());
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    protected final void loadImage() {
        ImageIcon ii = new ImageIcon("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\Covid-19Sim\\src\\models\\resources\\house.jpg");
        image = ii.getImage();
    }

    public int getNbPopulation() {
        return nbPopulation;
    }

    public void setNbPopulation(int nbPopulation) {
        this.nbPopulation = nbPopulation;
    }

    @Override
    public void initPopulation() {
        this.nbPopulation = MonteCarlo.getHousePopulation();
        this.listMember.clear();
        for (int i = 0; i < nbPopulation; i++) {
            addMember(new Human(Data.numberPopulation++, x, y, this, city, this.religionType));
        }
    }

}
