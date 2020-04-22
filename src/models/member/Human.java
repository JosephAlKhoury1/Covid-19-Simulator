/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.member;

import java.awt.Graphics;
import models.City;
import models.Server.HumanAgeType;
import models.Server.HumanStat;
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
    private HumanStat humanStat;

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
        if (ownHouse.getListMember().size() > 0) {
            this.humanAgeType = MonteCarlo.getHumanAgeType();
        } else {
            this.humanAgeType = MonteCarlo.getHumanAgeTypeWithoutChildren();
        }
        this.age = MonteCarlo.getHumanAge(humanAgeType);
        this.setSexeType(MonteCarlo.getSexeType());
        this.humanStat = HumanStat.healthy;
    }

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Human() {
        super();
    }

    public ReligionType getReligionType() {
        return religionType;
    }

    public void setReligionType(ReligionType religionType) {
        this.religionType = religionType;
    }

    public HumanAgeType getHumanAgeType() {
        return humanAgeType;
    }

    public void setHumanAgeType(HumanAgeType humanAgeType) {
        this.humanAgeType = humanAgeType;
    }

    public HumanStat getHumanStat() {
        return humanStat;
    }

    public void setHumanStat(HumanStat humanStat) {
        this.humanStat = humanStat;
    }

}
