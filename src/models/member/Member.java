package models.member;

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
import models.client.City;
import models.client.Day;
import models.client.HumanCityAgeType;
import Properties.MonteCarlo;
import static Properties.MonteCarlo.uniformFixedSeed;
import models.client.SexeType;
import models.location.House;
import models.location.Location;
import models.model.SymptomStage;
import models.model.SymptomStageType;
import models.model.SymptomType;
import resources.Colors.Colors;
import views.tile.Tile;
import views1.city.panel.CityPanel;
import views1.city.panel.Maps;

public abstract class Member implements Serializable, Cloneable {

    protected int x, y;
    protected int id;
    protected Location ownHouse;
    protected City city;
    protected Tile myTile;
    protected int age;
    protected SexeType sexeType;
    protected int locationIndex;
    protected Tile currentTile;
    protected Maps map;
    protected CityPanel cityPanel;
    protected List<Tile> listTileWaked = new ArrayList();
    protected HumanCityAgeType humanAgeType;
    protected Day day;
    protected Location school = null;
    protected Location university = null;
    protected Location hospital = null;
    protected Location work1;
    protected int hourInLocation = 0;
    protected int hour;

    protected boolean infected = false;
    protected int dayInfected = 0;
    protected SymptomStage stage;
    protected SymptomType symptomType;
    protected SymptomStageType symptomStageType;
    protected int stageNum = 0;
    protected Color color;
    protected boolean immune = false, death = false;

    protected boolean goWork = false;
    protected boolean goUniversity = false;
    protected boolean goSchool = false;

    protected SpecifiedLocation sch;
    protected SpecifiedLocation univ;
    protected SpecifiedLocation wor;
    protected boolean hospitalWork = false;
    protected int hospitalWorkTime = 0;

    protected boolean worker = false;
    protected Map<String, Boolean> mapIfGo;
    protected LocationLinkedList listLocatioOfDay;
    protected SpecifiedLocation currentLocationGo;
    protected int runDay = 0;

    protected boolean canMove = true;

    protected int step = 2;

    public Member(int id, int x, int y, House ownHouse, City city) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.city = city;
        this.ownHouse = ownHouse;

        this.currentTile = this.city.getTile(x, y);
        this.day = city.getWeek().getMONDAY();
        this.hour = city.getWeek().getHour();
        this.infected = false;
        this.mapIfGo = new HashMap();
        this.listLocatioOfDay = new LocationLinkedList(this.ownHouse);
    }

    public Member(int x, int y, House ownHouse, City city) {
        this.x = x;
        this.y = y;
        this.ownHouse = ownHouse;
        this.city = city;
        this.myTile = city.getTile(x, y);
        this.day = city.getWeek().getMONDAY();
        this.hour = city.getWeek().getHour();
        this.infected = false;
        this.mapIfGo = new HashMap();
        this.listLocatioOfDay = new LocationLinkedList(this.ownHouse);
    }

    public Member() {
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
        if (this.infected) {
            this.runDay++;
        }
        initiateLocationToGo(day.getDay().getName());
    }

    public void refresh() {
        this.setInfected(false);
        this.dayInfected = 0;
        this.runDay = 0;
        this.immune = false;
        this.death = false;
        this.canMove = true;
        this.stageNum = 0;
        this.stage = null;
        if (this.symptomStageType != null) {
            this.symptomStageType.getSymptomStage().getListMember().remove(this);
        }
        this.symptomStageType = null;
        this.x = this.ownHouse.getX();
        this.y = this.ownHouse.getY();
        this.currentLocationGo.getLocation().getListMember().remove(this);
        this.ownHouse.getListMember().add(this);
        color = Color.green;
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        if (!infected) {
            this.infected = false;
            return;
        }
        if (this.isInfected()) {
            return;
        }
        int value = this.city.getModel().getTotalSick() + 1;
        this.city.getModel().setTotalSick(value);
        if (this.symptomType != null && !this.immune && !this.death) {
            this.infected = infected;
            this.symptomStageType = this.symptomType.getListSage().get(0);
            this.stage = this.symptomStageType.getSymptomStage();
            this.stage.getListMember().add(this);
            this.city.getModel().getListHealth().remove(this);
            this.color = this.stage.getColor();
        }
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
        if (this.currentLocationGo != null) {
            this.currentLocationGo.checkToGoNext(hour, this);
        }
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

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public void move(String day) {
        if (this.isInfected() && !this.immune && !this.death) {
            this.dayInfected++;
            if (this.stage != null) {
                if (this.stage.getInHospital() == 1) {
                    this.canMove = false;
                    if (this.hospital != null) {
                        this.currentLocationGo = new SpecifiedLocation(this.hospital, "hospital");
                    } else {
                        this.currentLocationGo = new SpecifiedLocation(this.ownHouse, "house");
                    }
                }
            }
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
                                this.city.getModel().getListImmune().add(this);
                                this.setImmune(true);
                                this.canMove = true;
                                this.currentLocationGo.getLocation().getListMember().remove(this);
                                this.initiateLocationToGo(this.day.getDay().getName());
                            } else {
                                this.color = Colors.BLACK;
                                this.stage.getListMember().remove(this);
                                this.city.getModel().getListDeath().add(this);
                                this.setDeath(true);
                                this.currentLocationGo.getLocation().getListMember().remove(this);
                            }
                            break;
                        }
                    }
                }

            }
        }

        if (this.currentLocationGo == null) {
            return;
        }
        if (this.listLocatioOfDay.isEmpty()) {
            return;
        }
        if (currentTile == null) {
            currentTile = this.city.getTile(this.x, this.y);
        }
        boolean containX = currentLocationGo.getLocation().containX(this.x);
        boolean containY = currentLocationGo.getLocation().containY(this.y);

//        if (this.currentLocationGo.getGoTime() == this.city.getCurrentDay().getHour()) {
//            this.x = this.currentLocationGo.getLocation().getX();
//            this.y = this.currentLocationGo.getLocation().getY();
//        }
        if (containX && containY) {
            if (!this.currentLocationGo.getLocation().getListMember().contains(this)) {
                this.currentLocationGo.getLocation().getListMember().add(this);
            }
            
            if (this.isInfected() && canMove) {
                for (Member m : this.currentLocationGo.getLocation().getListMember()) {
                    if (m != this && this.runDay >= this.city.getModel().getContagiousDay()) {
                        boolean canInfect = MonteCarlo.checkProb(this.currentLocationGo.getLocation().getPercentageToBeSick());
                        if (canInfect) {
                            m.setInfected(true);
                        }
                    }
                }
            }
            this.currentLocationGo = this.currentLocationGo.checkToGoNext(this.city.getWeek().getCurrentDay().getHour(), this);
        }

        if (this.currentLocationGo.getLocation().isHigherX(this.x)) {
            this.x -= step;
        } else if (this.currentLocationGo.getLocation().isSmallerX(this.x)) {
            this.x += step;
        } else {
            if (this.currentLocationGo.getLocation().isHigherY(this.y)) {
                this.y -= step;
            } else if (this.currentLocationGo.getLocation().isSmallerY(this.y)) {
                this.y += step;
            } else {

            }
        }
    }

    public void move() {
        if (this.isInfected() && !this.immune && !this.death) {
            if (this.stage != null) {
                if (this.stage.getInHospital() == 1) {
                    this.canMove = false;
                    if (this.hospital != null) {
                        this.currentLocationGo = new SpecifiedLocation(this.hospital, "hospital");
                    } else {
                        this.currentLocationGo = new SpecifiedLocation(this.ownHouse, "house");
                    }
                }
            }
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
                                this.city.getModel().getListImmune().add(this);
                                this.setImmune(true);
                                this.canMove = true;
                                this.currentLocationGo.getLocation().getListMember().remove(this);
                                this.initiateLocationToGo(this.day.getDay().getName());
                            } else {
                                this.color = Colors.BLACK;
                                this.stage.getListMember().remove(this);
                                this.city.getModel().getListDeath().add(this);
                                this.setDeath(true);
                                this.currentLocationGo.getLocation().getListMember().remove(this);
                                this.city.getListMember().remove(this.getId());
                            }
                            break;
                        }
                    }
                }

            }
        }
        if (this.currentLocationGo == null) {
            return;
        }

        if (this.listLocatioOfDay.isEmpty()) {
            return;
        }

        if (currentTile == null) {
            currentTile = this.city.getTile(this.x, this.y);
        }

//        if (this.currentLocationGo.getGoTime() == this.city.getCurrentDay().getHour()) {
//            this.x = this.currentLocationGo.getLocation().getX();
//            this.y = this.currentLocationGo.getLocation().getY();
//        }
        boolean containX = currentLocationGo.getLocation().containX(this.x);
        boolean containY = currentLocationGo.getLocation().containY(this.y);

        if (containX && containY) {
            if (!this.currentLocationGo.getLocation().getListMember().contains(this)) {
                this.currentLocationGo.getLocation().getListMember().add(this);
            }
            if (this.isInfected() && canMove) {
                for (Member m : this.currentLocationGo.getLocation().getListMember()) {
                    if (m != this && this.runDay >= this.city.getModel().getContagiousDay()) {
                        boolean canInfect = MonteCarlo.checkProb(this.currentLocationGo.getLocation().getPercentageToBeSick());
                        if (canInfect) {
                            m.setInfected(true);
                        }
                    }
                }
            }
            this.currentLocationGo = this.currentLocationGo.checkToGoNext(this.city.getWeek().getCurrentDay().getHour(), this);
        }

        if (this.currentLocationGo.getLocation().isHigherX(this.x)) {
            this.x -= step;
        } else if (this.currentLocationGo.getLocation().isSmallerX(this.x)) {
            this.x += step;
        } else {
            if (this.currentLocationGo.getLocation().isHigherY(this.y)) {
                this.y -= step;
            } else if (this.currentLocationGo.getLocation().isSmallerY(this.y)) {
                this.y += step;
            } else {

            }
        }
    }

    public SpecifiedLocation getCurrentLocationGo() {
        return currentLocationGo;
    }

    public void setCurrentLocationGo(SpecifiedLocation currentLocationGo) {
        this.currentLocationGo = currentLocationGo;
    }

    public HumanCityAgeType getHumanAgeType() {
        return humanAgeType;
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

    public LocationLinkedList getListLocatioOfDay() {
        return listLocatioOfDay;
    }

    public void setUniversity(Location university) {
        this.university = university;
    }

    public Location getWork1() {
        return work1;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Member m = (Member) super.clone();
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

    public void initiateLocationToGo(String day) {
        this.listLocatioOfDay.clear();

        SpecifiedLocation speScho = null;
        SpecifiedLocation speUni = null;
        SpecifiedLocation speWo = null;
        List<SpecifiedLocation> list = new ArrayList();

        if (this.school != null) {
            speScho = new SpecifiedLocation(this.school, day, 1);
        }
        if (this.university != null) {
            speUni = new SpecifiedLocation(this.university, day, 1);
        }
        if (this.work1 != null) {
            if (this.work1.isHospital()) {
                this.hospitalWork = true;
                speWo = new SpecifiedLocation(this.work1, day, "hos");
            } else {
                speWo = new SpecifiedLocation(this.work1, day, 1);
            }
        }
        for (Entry<String, Boolean> e : this.mapIfGo.entrySet()) {
            if (e.getValue()) {
                int index = MonteCarlo.getNextInt(10);
                Location l = null;
                if (index > 5) {
                    l = this.city.getLocationDay(e.getKey(), day);
                }
                if (l != null) {
                    SpecifiedLocation spec = new SpecifiedLocation(l, day, 0);
                    list.add(spec);

                }
            }
        }
        this.listLocatioOfDay.add(list, speScho, speUni, speWo, this.currentLocationGo);

        if (this.listLocatioOfDay.getFirst() != null) {
            this.currentLocationGo = this.listLocatioOfDay.getFirst();
        }
    }
}
