package models.member1;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.client1.City;
import models.client1.Day;
import models.client1.HumanCityAgeType;
import models.client1.LocationToGo;
import models.client1.MonteCarlo;
import static models.client1.MonteCarlo.uniformFixedSeed;
import models.client1.SexeType;
import models.location1.House;
import models.location1.Location;
import models.model.SymptomStage;
import models.model.SymptomStageType;
import models.model.SymptomType;
import resources.icon.Colors;
import views.tile.Tile;
import views1.CityPanel;
import views1.Maps;

public abstract class Member implements Serializable, Cloneable {

    protected int x, y;
    protected int id;
    protected Location ownHouse;
    protected City city;
    protected Tile myTile;
    protected int age;
    protected SexeType sexeType;
    protected Map<Location, Integer> listLocation;
    protected List<Location> listLocDeleted;
    protected int locationIndex;
    protected Location currentLocationToGo = null;
    protected Tile currentTile;
    protected Maps map;
    protected CityPanel cityPanel;
    protected List<Tile> listTileWaked = new ArrayList();
    protected HumanCityAgeType humanAgeType;
    protected int numberLocationToGo;
    protected Day day;
    protected Location school = null;
    protected Location university = null;
    protected Entry<Location, Integer> workPlace = null;
    protected List<LocationToGo> listDeleted;
    protected int hourInLocation = 0;
    protected int hour;
    protected int[] hourIn = {1, 2, 3, 4};

    protected boolean infected = false;
    protected int dayInfected = 0;
    protected SymptomStage stage;
    protected SymptomType symptomType;
    protected SymptomStageType symptomStageType;
    protected int stageNum = 0;
    protected Color color;
    protected boolean immune = false, death = false;

    public Member(int id, int x, int y, House ownHouse, City city) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.city = city;
        this.ownHouse = ownHouse;
        this.listLocation = new HashMap();
        this.listLocDeleted = new ArrayList();
        this.currentTile = this.city.getTile(x, y);
        this.day = city.getWeek().getMONDAY();
        this.hour = city.getWeek().getHour();
        this.infected = false;
    }

    public Member(int x, int y, House ownHouse, City city) {
        this.x = x;
        this.y = y;
        this.ownHouse = ownHouse;
        this.city = city;
        this.myTile = city.getTile(x, y);
        this.listLocDeleted = new ArrayList();
        this.listLocation = new HashMap();
        this.day = city.getWeek().getMONDAY();
        this.hour = city.getWeek().getHour();
        this.infected = false;

    }

    public Member() {
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
        if (this.workPlace != null) {
            this.workPlace.setValue(this.workPlace.getKey().getWorkTime());
        }
        this.listLocation.clear();
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

    public void refresh() {
        this.setInfected(false);
        this.dayInfected = 0;
        this.stageNum = 0;
        this.stage = null;
        if (this.symptomStageType != null) {
            this.symptomStageType.getSymptomStage().getListMember().remove(this);
        }
        this.symptomStageType = null;
        color = Color.green;
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        if (this.isInfected()) {
            return;
        }
        this.infected = infected;
        this.symptomStageType = this.symptomType.getListSage().get(0);
        this.stage = this.symptomStageType.getSymptomStage();
        this.stage.getListMember().add(this);
        this.city.getListHealth().remove(this);
        this.color = this.stage.getColor();
    }

    public int getId() {
        return this.id;
    }

    public SymptomType getSymptomType() {
        return symptomType;
    }

    public boolean isImmune() {
        return immune;
    }

    public void setImmune(boolean immune) {
        this.immune = immune;
    }

    public boolean isDeath() {
        return death;
    }

    public void setDeath(boolean death) {
        this.death = death;
    }

    public void setSymptomType(SymptomType symptomType) {
        this.symptomType = symptomType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getOwnHouse() {
        return ownHouse;
    }

    public void setOwnHouse(Location ownHouse) {
        this.ownHouse = ownHouse;
    }

    public Maps getMap() {
        return map;
    }

    public void setMap(Maps map) {
        this.map = map;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Tile getMyTile() {
        return myTile;
    }

    public void setMyTile(Tile myTile) {
        this.myTile = myTile;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SexeType getSexeType() {
        return sexeType;
    }

    public void setSexeType(SexeType sexeType) {
        this.sexeType = sexeType;
    }

    public abstract void draw(Graphics g);

    public int getLocationIndex() {
        return locationIndex;
    }

    public void setLocationIndex(int locationIndex) {
        this.locationIndex = locationIndex;
    }

    public int getX() {
        return x;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        this.hourInLocation++;
        checkChangeLocaion();
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(boolean dayChanged) {
        if (this.isInfected() && !this.immune && !this.death) {
            this.dayInfected++;
            if (this.dayInfected > this.symptomStageType.getDay()) {
                this.stageNum++;
                this.dayInfected = 0;

                int in = this.symptomType.getListSage().indexOf(this.symptomStageType);
                SymptomStageType tmp = null;
                for (int i = in + 1; i < this.symptomType.getListSage().size(); i++) {
                    if (this.symptomType.getListSage().get(i).getDay() != 0) {
                        tmp = this.symptomType.getListSage().get(i);
                        break;
                    }
                }

                if (tmp != null) {
                    this.symptomStageType = tmp;
                    this.stage.getListMember().remove(this);
                    this.stage = this.symptomStageType.getSymptomStage();
                    this.stage.getListMember().add(this);
                    this.color = stage.getColor();
                } else {
                    List<Double> listPer = new ArrayList();
                    listPer.add(this.stage.getImmunePercentage());
                    listPer.add(this.stage.getDeathPercentage());
                    while (true) {
                        int index = uniformFixedSeed.nextInt(listPer.size());
                        double per = listPer.get(index);
                        Double prob = per / 100d;
                        double newRandom = uniformFixedSeed.nextDouble();
                        if (newRandom <= prob) {
                            if (index == 0) {
                                this.color = Color.CYAN;
                                this.stage.getListMember().remove(this);
                                this.city.getListImmune().add(this);
                                this.setImmune(true);
                            } else {
                                this.color = Colors.BLACK;
                                this.stage.getListMember().remove(this);
                                this.city.getListDeath().add(this);
                                this.setDeath(true);
                            }
                            break;
                        }
                    }
                }

            }
        }

        if (this.currentLocationToGo == null) {
            return;
        }
        if (this.listLocation.isEmpty()) {
            return;
        }
        if (currentTile == null) {
            currentTile = this.city.getTile(this.x, this.y);
        }
        final int step = 6;
        boolean containX = currentLocationToGo.containX(this.x);
        boolean containY = currentLocationToGo.containY(this.y);

        if (containX && containY) {
            this.currentLocationToGo.getListMember().add(this);
            /*boolean containSick = false;
            for (Member m : this.currentLocationToGo.getListMember()) {
                if (m.isInfected()) {
                    containSick = true;
                    break;
                }
            }
            if (containSick) {
                boolean isSick = false;
                isSick = MonteCarlo.checkProb(this.currentLocationToGo.getPercentageToBeSick());
                if (isSick) {
                    this.setInfected(true);
                }
            }*/
            if (this.isInfected()) {
                int listMemberSize = this.currentLocationToGo.getListMember().size();
                int toInfect = (int) this.currentLocationToGo.getPercentageToBeSick() * listMemberSize / 100;
                for (int i = 0; i < toInfect; i++) {
                    int index = MonteCarlo.getNextInt(this.currentLocationToGo.getListMember().size());
                    this.currentLocationToGo.getListMember().get(index).setInfected(true);
                }
            }
            checkChangeLocaion();
        }

        if (this.currentLocationToGo.isHigherX(this.x)) {
            this.x -= step;
        } else if (this.currentLocationToGo.isSmallerX(this.x)) {
            this.x += step;
        } else {
            if (this.currentLocationToGo.isHigherY(this.y)) {
                this.y -= step;
            } else if (this.currentLocationToGo.isSmallerY(this.y)) {
                this.y += step;
            } else {

            }
        }
    }

    public void move() {
        if (this.isInfected() && !this.immune && !this.death) {
            if (this.dayInfected > this.symptomStageType.getDay()) {
                this.stageNum++;
                this.dayInfected = 0;

                int in = this.symptomType.getListSage().indexOf(this.symptomStageType);
                SymptomStageType tmp = null;
                for (int i = in + 1; i < this.symptomType.getListSage().size(); i++) {
                    if (this.symptomType.getListSage().get(i).getDay() != 0) {
                        tmp = this.symptomType.getListSage().get(i);
                        break;
                    }
                }

                if (tmp != null) {
                    this.symptomStageType = this.symptomType.getListSage().get(this.stageNum);
                    this.stage.getListMember().remove(this);
                    this.stage = this.symptomStageType.getSymptomStage();
                    this.color = stage.getColor();
                    this.stage.getListMember().add(this);
                } else {
                    List<Double> listPer = new ArrayList();
                    listPer.add(this.stage.getImmunePercentage());
                    listPer.add(this.stage.getDeathPercentage());
                    while (true) {
                        int index = uniformFixedSeed.nextInt(listPer.size());
                        double per = listPer.get(index);
                        Double prob = per / 100d;
                        double newRandom = uniformFixedSeed.nextDouble();
                        if (newRandom <= prob) {
                            if (index == 0) {
                                this.color = Color.CYAN;
                                this.stage.getListMember().remove(this);
                                this.city.getListImmune().add(this);
                                this.setImmune(true);
                            } else {
                                this.color = Colors.BLACK;
                                this.stage.getListMember().remove(this);
                                this.city.getListDeath().add(this);
                                this.setDeath(true);
                            }
                            break;
                        }
                    }
                }

            }
        }
        if (this.currentLocationToGo
                == null) {
            return;
        }

        if (this.listLocation.isEmpty()) {
            return;
        }
        if (currentTile == null) {
            currentTile = this.city.getTile(this.x, this.y);
        }
        final int step = 6;
        boolean containX = currentLocationToGo.containX(this.x);
        boolean containY = currentLocationToGo.containY(this.y);

        if (containX && containY) {
            this.currentLocationToGo.getListMember().add(this);
            /*boolean containSick = false;
            for (Member m : this.currentLocationToGo.getListMember()) {
                if (m.isInfected()) {
                    containSick = true;
                    break;
                }
            }
            if (containSick) {
                boolean isSick = false;
                isSick = MonteCarlo.checkProb(this.currentLocationToGo.getPercentageToBeSick());
                if (isSick) {
                    this.setInfected(true);
                }
            }*/
            if (this.isInfected()) {
                int listMemberSize = this.currentLocationToGo.getListMember().size();
                int toInfect = (int) this.currentLocationToGo.getPercentageToBeSick() * listMemberSize / 100;
                for (int i = 0; i < toInfect; i++) {
                    int index = MonteCarlo.getNextInt(this.currentLocationToGo.getListMember().size());
                    this.currentLocationToGo.getListMember().get(index).setInfected(true);
                }
            }
            checkChangeLocaion();
        }

        if (this.currentLocationToGo.isHigherX(
                this.x)) {
            this.x -= step;
        } else if (this.currentLocationToGo.isSmallerX(
                this.x)) {
            this.x += step;
        } else {
            if (this.currentLocationToGo.isHigherY(this.y)) {
                this.y -= step;
            } else if (this.currentLocationToGo.isSmallerY(this.y)) {
                this.y += step;
            } else {

            }
        }
    }

    public void checkChangeLocaion() {
        if (this.currentLocationToGo != null) {
            if (this.currentLocationToGo == this.school) {
                if (this.currentLocationToGo.getCloseTime() == this.city.getWeek().getHour()) {
                    getLocationToGo();
                    this.currentLocationToGo.getListMember().remove(this);
                } else {
                    return;
                }
            }
            if (this.currentLocationToGo == this.university) {
                if (this.currentLocationToGo.getCloseTime() == this.city.getWeek().getHour()) {
                    getLocationToGo();
                    this.currentLocationToGo.getListMember().remove(this);
                } else {
                    return;
                }
            }
            if (this.workPlace != null) {
                if (this.currentLocationToGo == this.workPlace.getKey()) {
                    if (this.workPlace.getValue() == 0 || this.currentLocationToGo.getCloseTime() <= this.city.getWeek().getHour()) {
                        getLocationToGo();
                        this.currentLocationToGo.getListMember().remove(this);
                    } else {
                        this.workPlace.setValue(this.workPlace.getValue() - 1);
                        return;
                    }
                }
            }
            if (this.listLocation.containsKey(this.currentLocationToGo)) {
                if (this.listLocation.get(this.currentLocationToGo) == 0 || this.currentLocationToGo.getCloseTimeToVisit() == this.city.getWeek().getHour()) {
                    //this.listLocation.remove(this.currentLocationToGo);
                    getLocationToGo();
                    this.currentLocationToGo.getListMember().remove(this);
                } else {
                    this.listLocation.put(this.currentLocationToGo, (this.listLocation.get(this.currentLocationToGo) - 1));
                    return;
                }
            }
            if (this.currentLocationToGo == this.ownHouse) {
                getLocationToGo();
                this.currentLocationToGo.getListMember().remove(this);
            }
        } else {
            getLocationToGo();
        }
    }

    public void getLocationToGo() {
        if (this.school != null) {
            if (this.school.getListDay().contains(this.city.getWeek().getCurrentDay())) {
                if (this.school.getOpenTime() == this.city.getWeek().getCurrentDay().getHour() + 1) {
                    this.currentLocationToGo = this.school;
                    this.hourInLocation = 0;
                    return;
                }
            }
        }
        if (this.university != null) {
            if (this.university.getListDay().contains(this.city.getWeek().getCurrentDay())) {
                if (this.university.getOpenTime() == this.city.getWeek().getCurrentDay().getHour() + 1
                        && this.university.getCloseTime() >= this.city.getWeek().getCurrentDay().getHour() + 5) {
                    this.currentLocationToGo = this.university;
                    this.hourInLocation = 0;
                    return;
                }
            }
        }
        if (this.workPlace != null) {
            if (this.workPlace.getKey().getListDay().contains(this.city.getWeek().getCurrentDay())) {
                if (this.workPlace.getKey().getOpenTime() == this.city.getWeek().getCurrentDay().getHour() + 1
                        && this.workPlace.getKey().getCloseTime() >= this.city.getWeek().getCurrentDay().getHour()
                        && this.workPlace.getValue() > 0) {
                    this.currentLocationToGo = this.workPlace.getKey();
                    this.hourInLocation = 0;
                    return;
                }
            }
        }
        if (this.listLocation.size() > 0) {
            for (Entry<Location, Integer> e : this.listLocation.entrySet()) {
                if (e.getKey().getOpenTimeToVisit() <= this.city.getWeek().getHour() + 1
                        && e.getKey().getCloseTimeToVisit() >= this.city.getWeek().getHour() + e.getValue()
                        && e.getValue() > 0) {
                    this.currentLocationToGo = e.getKey();
                    this.hourInLocation = 0;
                    return;
                } else {
                    this.currentLocationToGo = this.ownHouse;
                    this.hourInLocation = 0;
                    return;
                }
                /*} else {
                    i++;
                }*/
            }
        } else {
            this.currentLocationToGo = this.ownHouse;
            this.hourInLocation = 0;
        }
    }

    public HumanCityAgeType getHumanAgeType() {
        return humanAgeType;
    }

    public Location getCurrentLocationToGo() {
        return currentLocationToGo;
    }

    public void setCurrentLocationToGo(Location currentLocationToGo) {
        this.currentLocationToGo = currentLocationToGo;
    }

    public void setHumanAgeType(HumanCityAgeType humanAgeType) {
        this.humanAgeType = humanAgeType;
    }

    public Location getSchool() {
        return school;
    }

    public void setSchool(Location school) {
        this.school = school;
    }

    public Location getUniversity() {
        return university;
    }

    public Map<Location, Integer> getListLocation() {
        return listLocation;
    }

    public void setListLocation(Map<Location, Integer> listLocation) {
        this.listLocation = listLocation;
    }

    public void setUniversity(Location university) {
        this.university = university;
    }

    public Location getWorkPlace() {
        if (this.workPlace != null) {
            return workPlace.getKey();
        } else {
            return null;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Member m = (Member) super.clone();
        m.listLocation = new HashMap();
        return m;
    }

    public Object clone(City c) {
        Member m = null;
        try {
            m = (Member) this.clone();
            m.setCity(c);
            m.setHumanAgeType(this.getHumanAgeType());

        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Member.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
}
