
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.member;

import models.client.ReligionType;
import models.client.HumanAgeType;
import models.client.MonteCarlo;
import models.client.Data;
import models.client.HumanStat;
import java.awt.Graphics;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.client.City;
import models.location.House;
import models.location.School;
import models.location.University;

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

    private School school;
    private University university;

    @Override
    public void draw(Graphics g) {
        g.setColor(Data.getColor(humanStat));
        g.drawOval(x, y, 5, 5);
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

        boolean goSchool = MonteCarlo.checkProb(humanAgeType.getGoSchoolPercentage());
        boolean goUniversity = MonteCarlo.checkProb(humanAgeType.getGoUniversityPercentage());
        if (goSchool) {
            try {
                this.school = city.getSchool();
                this.listLocation.add(school);
            } catch (RemoteException ex) {
                Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (goUniversity) {
            try {
                this.university = city.getUniversity();
                this.listLocation.add(this.university);
            } catch (RemoteException ex) {
                Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

}
