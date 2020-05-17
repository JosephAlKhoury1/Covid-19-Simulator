package models.member1;

import models.client1.*;
import java.awt.Graphics;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.location1.*;

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

    private School school = null;
    private University university = null;
    private Location WorkPlace = null;
    private boolean goSchool;
    private boolean goUniversity;
    private boolean goWork;

    @Override
    public void draw(Graphics g) {
        g.setColor(Data.getColor(humanStat));
        g.fillOval(x, y, 10, 10);
        if (currentLocationToGo != null) {
            g.drawString("x=" + currentLocationToGo.getX() + " y=" + currentLocationToGo.getY(), x, y);
        }
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
        if (ownHouse.getListPopulation().size() > 0) {
            this.humanAgeType = MonteCarlo.getHumanAgeType();
        } else {
            this.humanAgeType = MonteCarlo.getHumanAgeTypeWithoutChildren();
        }
        this.age = MonteCarlo.getHumanAge(humanAgeType);
        this.setSexeType(MonteCarlo.getSexeType());
        this.humanStat = HumanStat.healthy;
        goSchool = MonteCarlo.checkProb(this.humanAgeType.getGoSchoolPercentage());
        goUniversity = MonteCarlo.checkProb(this.humanAgeType.getGoUniversityPercentage());
        goWork = MonteCarlo.checkProb(this.humanAgeType.getGoWorkPercentage());
        initHuman(city);
        if (listLocation.size() > 0) {
            this.currentLocationToGo = listLocation.get(0);
        }
    }

    public void initHuman(City city) {
        if (this.school == null) {
            if (goSchool) {
                try {
                    this.school = (School) city.getLocation("School");
                    if (this.school != null) {
                        this.listLocation.add(school);
                        System.out.println("school added");
                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NullPointerException ex) {
                    this.school = null;
                }
            }
        }

        if (this.university == null) {
            if (goUniversity) {
                try {
                    this.university = (University) city.getLocation("University");
                    if (this.university != null) {
                        this.listLocation.add(this.university);
                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NullPointerException ex) {
                    this.university = null;
                }
            }
        }
        if (this.WorkPlace == null) {
            if (goWork) {
                try {
                    this.WorkPlace = city.getLocation("Work");
                    if (this.WorkPlace != null) {
                        this.listLocation.add(this.WorkPlace);
                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
                }
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
