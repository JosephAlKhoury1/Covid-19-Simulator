package models.member;

import models.location.House;
import models.client.LocationToGo;
import Properties.MonteCarlo;
import models.client.ReligionType;
import models.client.City;
import java.awt.Color;
import java.awt.Graphics;
import models.model.HumanStat;

public class Human extends Member {

    private ReligionType religionType;
    private HumanStat humanStat;

    public Human(int x, int y, House ownHouse, City city) {
        super(x, y, ownHouse, city);
        if (ownHouse.getListPopulation().size() > 0) {
            this.humanAgeType = MonteCarlo.getHumanAgeType();
        } else {
            this.humanAgeType = MonteCarlo.getHumanAgeTypeWithoutChildren();
        }

        this.age = MonteCarlo.getHumanAge(humanAgeType);

        this.symptomType = city.getModel().getSymptomType(age);

        this.sexeType = MonteCarlo.getSexeType();

        if (this.humanAgeType != null) {
            goWork = MonteCarlo.checkProb(this.humanAgeType.getWorkPercentage());
            if (goWork) {
                this.worker = true;
//                try {
                work1 = city.getLocationForWork();

//                } catch (RemoteException ex) {
//                    Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
            for (LocationToGo l : this.humanAgeType.getListLocationToGo()) {
                if (l.getName().equals("School")) {
                    if (!worker) {
                        goSchool = MonteCarlo.checkProb(l.getPercentage());
                        if (goSchool) {
//                            try {
                            this.school = this.city.getSchool();
//                            } catch (RemoteException ex) {
//                                Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
//                            }
                        }
                    }
                } else if (l.getName().equals("University")) {
                    goUniversity = MonteCarlo.checkProb(l.getPercentage());
                    if (goUniversity) {
//                        try {
                        this.university = this.city.getUniversity();
//                        } catch (RemoteException ex) {
//                            Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
//                        }
                    }
                } else {
                    boolean b = MonteCarlo.checkProb(l.getPercentage());
                    this.mapIfGo.put(l.getName(), b);
                }
            }

        } else {
            goWork = MonteCarlo.checkProb(50);
            if (goWork) {
                this.worker = true;
//                try {
                work1 = city.getLocationDay("work", "Monday");
//                } catch (RemoteException ex) {
//                    Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
            String[] locationName = {"School", "University", "Church", "Shop", "Mosque", "Hospital", "Restaurant"};
            for (String l : locationName) {
                if (l.equals("School")) {
                    if (!worker) {
                        goSchool = MonteCarlo.checkProb(50);
                        if (goSchool) {
//                            try {
                            this.school = this.city.getLocationDay("School", "Monday");
//                            } catch (RemoteException ex) {
//                                Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
//                            }
                        }
                    }
                } else if (l.equals("University")) {
                    goUniversity = MonteCarlo.checkProb(50);
                    if (goUniversity) {
//                        try {
                        this.university = this.city.getLocationDay("University", "Monday");
//                        } catch (RemoteException ex) {
//                            Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
//                        }
                    }
                } else {
                    boolean b = MonteCarlo.checkProb(50);
                    this.mapIfGo.put(l, b);
                }
            }

        }
//        try {
        this.hospital = this.city.getLocationDay("Hospital", "Monday");
//        } catch (RemoteException ex) {
//            Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
//        }
        initiateLocationToGo("Monday");
    }

    int xs = 10, ys = 10;

    @Override
    public void draw(Graphics g) {
        if (!this.death) {
            if (!isInfected()) {
                g.setColor(Color.green);
            } else {
                g.setColor(color);
            }
            g.fillOval(x, y, xs, ys);
        }
//        if (currentLocationGo != null) {
//            g.drawString("x=" + currentLocationGo.getLocation().getX() + " y=" + currentLocationGo.getLocation().getY(), x, y);
//        }

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
