package models.member1;

import java.awt.Color;
import models.client1.*;
import java.awt.Graphics;
import java.rmi.RemoteException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.location1.*;
import models.model.HumanAge;
import models.model.HumanStat;

/**
 *
 * @author Joseph
 */
public class Human extends Member {
    
    private String firstName;
    private String lastName;
    private ReligionType religionType;
    //private SexeType sexeType;
    private HumanStat humanStat;
    
    public Human(int x, int y, House ownHouse, City city) {
        super(x, y, ownHouse, city);
        this.listDeleted = new ArrayList();
        if (ownHouse.getListPopulation().size() > 0) {
            this.humanAgeType = MonteCarlo.getHumanAgeType();
            this.numberLocationToGo = this.humanAgeType.getPlaceNumber();
        } else {
            this.humanAgeType = MonteCarlo.getHumanAgeTypeWithoutChildren();
            this.numberLocationToGo = this.humanAgeType.getPlaceNumber();
        }
        // this.humanStat = HumanStat.healthy;
        if (city.getModel() != null) {
            //this.humanStat = city.getModel();
        }
        this.age = MonteCarlo.getHumanAge(humanAgeType);
        
        for (HumanAge ha : city.getModel().getListHumanAge()) {
            if (this.age >= ha.getMinAge() && this.age <= ha.getMaxAge()) {
                this.symptomType = ha.monteCarlo();
                break;
            }
        }
        this.sexeType = MonteCarlo.getSexeType();
        boolean goWork = false;
        boolean goUniversity = false;
        boolean goSchool = false;
        
        if (this.humanAgeType != null) {
            goWork = MonteCarlo.checkProb(this.humanAgeType.getWorkPercentage());
            if (goWork) {
                try {
                    Location l = city.getLocation("work");
                    this.workPlace = new SimpleEntry(l, l.getWorkTime());
                    if (this.workPlace != null) {
                        this.workPlace.getKey().setFixedLocation(1);
                        this.numberLocationToGo--;
                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            for (LocationToGo l : this.humanAgeType.getListLocationToGo()) {
                if (l.getName().equals("School")) {
                    goSchool = MonteCarlo.checkProb(l.getPercentage());
                    if (goSchool) {
                        try {
                            this.school = this.city.getLocation("School");
                            if (this.school != null) {
                                this.school.setFixedLocation(1);
                                this.numberLocationToGo--;
                            }
                        } catch (RemoteException ex) {
                            Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else if (l.getName().equals("University")) {
                    goUniversity = MonteCarlo.checkProb(l.getPercentage());
                    if (goUniversity) {
                        try {
                            this.university = this.city.getLocation("University");
                            if (this.university != null) {
                                this.university.setFixedLocation(1);
                                this.numberLocationToGo--;
                            }
                        } catch (RemoteException ex) {
                            Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    boolean b = MonteCarlo.checkProb(l.getPercentage());
                    if (b) {
                        try {
                            Location loc = this.city.getLocation(l.getName());
                            if (loc != null) {
                                int index = MonteCarlo.getNextInt(this.hourIn.length);
                                this.listLocation.put(loc, this.hourIn[index]);
                                this.numberLocationToGo--;
                                this.listDeleted.add(l);
                            }
                        } catch (RemoteException ex) {
                            Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
            }
        }
        int o = this.numberLocationToGo;
        while (o > 0) {
            Location loc = city.getRandomLocation();
            if (loc != null && this.workPlace != loc && !this.listLocation.containsKey(loc)) {
                int index = MonteCarlo.getNextInt(this.hourIn.length);
                this.listLocation.put(loc, this.hourIn[index]);
                o--;
            }
        }
        getLocationToGo();
    }
    
    int xs = 10, ys = 10;
    
    @Override
    public void draw(Graphics g) {
        if (!isInfected()) {
            g.setColor(Color.green);
        } else {
            g.setColor(color);
        }
        g.fillOval(x, y, xs, ys);
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
    
    public void initHuman(City city) {
        /* if (this.school == null) {
            if (goSchool) {
                try {
                    this.school = (School) city.getLocation("School");
                    if (this.school != null) {
                        this.listLocation.add(school);
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
        }*/
    }
    
    public ReligionType getReligionType() {
        return religionType;
    }
    
    public void setReligionType(ReligionType religionType) {
        this.religionType = religionType;
    }
    
    public HumanStat getHumanStat() {
        return humanStat;
    }
    
    public void setHumanStat(HumanStat humanStat) {
        this.humanStat = humanStat;
    }
}
