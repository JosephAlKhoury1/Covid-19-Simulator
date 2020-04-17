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
import models.Server.Data;
import models.Server.MonteCarlo;
import models.Server.ReligionType;
import static models.location.LocationData.*;
import models.member.Human;

/**
 *
 * @author Joseph
 */
public class House extends Location {

    private int nbPopulation = 0;
    private ReligionType religionType;

    public House(int x, int y, double average_sick, JPanel panel, City city) {
        super(x, y, WTILEHOUSE, HTILEHOUSE, average_sick, panel, city);
        loadImage();
        this.religionType = MonteCarlo.getHouseReligionType();
    }

    public House() {
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, panel);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    protected void loadImage() {
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
            addMember(new Human(Data.numberPopulation++, x, y, this, city,this.religionType));
        }
    }

}
