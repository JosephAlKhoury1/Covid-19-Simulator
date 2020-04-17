/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.member;

import java.awt.Graphics;
import models.City;
import models.Server.HumanAgeType;
import models.Server.MonteCarlo;
import models.Server.ReligionType;
import models.location.House;

/**
 *
 * @author Joseph
 */
public class Human extends Member {

    private String firstName;
    private String lastName;
    private ReligionType religionType;
    private HumanAgeType humanAgeType;

    @Override
    protected void draw(Graphics g) {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Human(String firstName, String lastName, int id, int x, int y, House ownHouse, City city) {
        super(id, x, y, ownHouse, city);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Human(int id, int x, int y, House ownHouse, City city, ReligionType religionType) {
        super(id, x, y, ownHouse, city);
        this.religionType = religionType;
        this.humanAgeType = MonteCarlo.getHumanAgeType();
        this.age = MonteCarlo.getHumanAge(humanAgeType);
    }

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Human() {
        super();
    }

}
