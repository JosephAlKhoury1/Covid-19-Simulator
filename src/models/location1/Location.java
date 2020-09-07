package models.location1;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.client1.City;
import models.client1.Day;
import models.member1.Member;
import views.tile.Tile;
import views1.Maps;

public abstract class Location implements Cloneable {

    protected int id = -1;
    protected String name;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected double average_sick;
    protected int locationCategoryId;
    protected Maps map;
    protected String days;
    protected int workTime;
    protected double percentageToBeSick = 0.0;

    protected List<Member> listMember;

    protected boolean isNew, saved, deleted = false;

    protected City city;

    protected int fixedLocation;
    protected Image image;

    protected List<Day> listDay;
    protected List<Tile> listTile;
    protected int openTimeToVisit;
    protected int closeTimeToVisit;

    public Location(String name, int x, int y, double average_sick, String days, int fixed, int locationCategoryId, City city) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.city = city;
        this.fixedLocation = fixed;
        this.average_sick = average_sick;
        this.locationCategoryId = locationCategoryId;
        this.days = days;
        this.listDay = new ArrayList();
        this.listTile = new ArrayList();
        this.listMember = new ArrayList();
        this.isNew = true;
        this.saved = false;

        String[] tab = days.split(" ");
        for (String s : tab) {
            switch (s) {
                case "Monday":
                    this.listDay.add(city.getWeek().getMONDAY());
                    break;
                case "Tuesday":
                    this.listDay.add(city.getWeek().getTUESDAY());
                    break;
                case "Wednesday":
                    this.listDay.add(city.getWeek().getWEDNESDAY());
                    break;
                case "Thursday":
                    this.listDay.add(city.getWeek().getTHURSDAY());
                    break;
                case "Friday":
                    this.listDay.add(city.getWeek().getFRIDAY());
                    break;
                case "Saturday":
                    this.listDay.add(city.getWeek().getSATURDAY());
                    break;
                case "Sunday":
                    this.listDay.add(city.getWeek().getSUNDAY());
                    break;
                default:
                    break;
            }
        }
    }

    public Location(String name, int x, int y, double average_sick, String days, int fixed, City city) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.city = city;
        this.fixedLocation = fixed;
        this.average_sick = average_sick;
        this.days = days;
        this.listDay = new ArrayList();
        this.listTile = new ArrayList();
        this.listMember = new ArrayList();
        this.isNew = true;
        this.saved = false;
        String[] tab = days.split(" ");
        for (String s : tab) {
            switch (s) {
                case "Monday":
                    this.listDay.add(city.getWeek().getMONDAY());
                    break;
                case "Tuesday":
                    this.listDay.add(city.getWeek().getTUESDAY());
                    break;
                case "Wednesday":
                    this.listDay.add(city.getWeek().getWEDNESDAY());
                    break;
                case "Thursday":
                    this.listDay.add(city.getWeek().getTHURSDAY());
                    break;
                case "Friday":
                    this.listDay.add(city.getWeek().getFRIDAY());
                    break;
                case "Saturday":
                    this.listDay.add(city.getWeek().getSATURDAY());
                    break;
                case "Sunday":
                    this.listDay.add(city.getWeek().getSUNDAY());
                    break;
                default:
                    break;
            }
        }
    }

    public Location(int id, String name, int x, int y, int width, int height, double average_sick, String days, int fixed, int locationCategoryId, City c) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fixedLocation = fixed;
        this.days = days;
        this.average_sick = average_sick;
        this.locationCategoryId = locationCategoryId;
        this.listDay = new ArrayList();
        this.listTile = new ArrayList();
        this.listMember = new ArrayList();
        this.isNew = false;
        this.saved = true;
        this.city = c;
        String[] tab = days.split(" ");
        for (String s : tab) {
            switch (s) {
                case "Monday":
                    this.listDay.add(city.getWeek().getMONDAY());
                    break;
                case "Tuesday":
                    this.listDay.add(city.getWeek().getTUESDAY());
                    break;
                case "Wednesday":
                    this.listDay.add(city.getWeek().getWEDNESDAY());
                    break;
                case "Thursday":
                    this.listDay.add(city.getWeek().getTHURSDAY());
                    break;
                case "Friday":
                    this.listDay.add(city.getWeek().getFRIDAY());
                    break;
                case "Saturday":
                    this.listDay.add(city.getWeek().getSATURDAY());
                    break;
                case "Sunday":
                    this.listDay.add(city.getWeek().getSUNDAY());
                    break;
                default:
                    break;
            }
        }
    }

    public boolean isIsNew() {
        return isNew;
    }

    public Maps getMap() {
        return map;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public double getPercentageToBeSick() {
        return percentageToBeSick;
    }

    public void setPercentageToBeSick(double percentageToBeSick) {
        this.percentageToBeSick = percentageToBeSick;
    }

    public void setMap(Maps map) {
        this.map = map;
    }

    public Location() {
    }

    public List<Day> getListDay() {
        return listDay;
    }

    public void setListDay(List<Day> listDay) {
        this.listDay = listDay;
    }

    public int getLocationCategoryId() {
        return locationCategoryId;
    }

    public void setLocationCategoryId(int locationCategoryId) {
        this.locationCategoryId = locationCategoryId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getAverage_sick() {
        return average_sick;
    }

    public void setAverage_sick(double average_sick) {
        this.average_sick = average_sick;
    }

    public void addMember(Member m) {
        this.listMember.add(m);
        this.city.getListMember().put(m.getId(), m);
        this.city.getListHealth().add(m);
    }

    public int getFixedLocation() {
        return fixedLocation;
    }

    public void setFixedLocation(int fixedLocation) {
        this.fixedLocation = fixedLocation;
    }

    public void addDay(Day d) {
        this.listDay.add(d);
        d.addLocation(this);
        this.days = "";
        for (Day dd : this.listDay) {
            days += dd.getDay().getName() + " ";
        }
    }

    public void removeDay(Day d) {
        this.listDay.remove(d);
        d.removeLocation(this);
        this.days = "";
        for (Day dd : this.listDay) {
            days += dd.getDay().getName() + " ";
        }
    }

//    public void addWorker(Human h) {
//        this.listWorker.add(h);
//    }
    public boolean containX(int x) {
        if (this.x < x && this.x + this.width > x) {
            return true;
        }
        return false;
    }

    public boolean containY(int y) {
        if (this.y < y && this.y + this.height > y) {
            return true;
        }
        return false;
    }

    public boolean isSmallerX(int x) {
        if (this.x > x) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSmallerY(int y) {
        if (this.y > y) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isHigherX(int x) {
        if ((this.x + this.width) < x) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isHigherY(int y) {
        if ((this.y + this.height) < y) {
            return true;
        } else {
            return false;
        }
    }

    public void addTile(Tile t) {
        this.listTile.add(t);
    }

    public abstract void setOpenTime(int openTime);

    public abstract void setCloseTime(int closeTime);

    public abstract int getOpenTime();

    public abstract int getCloseTime();

    public String getDays() {
        return this.days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public int getOpenTimeToVisit() {
        return openTimeToVisit;
    }

    public void setOpenTimeToVisit(int openTimeToVisit) {
        this.openTimeToVisit = openTimeToVisit;
    }

    public int getCloseTimeToVisit() {
        return closeTimeToVisit;
    }

    public void setCloseTimeToVisit(int closeTimeToVisit) {
        this.closeTimeToVisit = closeTimeToVisit;
    }

    public abstract void draw(Graphics g);

    protected abstract void loadImage();

    public abstract void initPopulation();

    public abstract void save();

    @Override
    public Object clone() throws CloneNotSupportedException {
        Location lNew = (Location) super.clone();
        lNew.listMember = new ArrayList();
        lNew.listDay = new ArrayList();
        return lNew;
    }

    public Object clone(City c) {
        Location lNew = null;
        try {
            lNew = (Location) this.clone();
            lNew.setCity(c);
            String[] tab = lNew.getDays().split(" ");
            for (String s : tab) {
                switch (s) {
                    case "Monday":
                        lNew.listDay.add(c.getWeek().getMONDAY());
                        break;
                    case "Tuesday":
                        lNew.listDay.add(c.getWeek().getTUESDAY());
                        break;
                    case "Wednesday":
                        lNew.listDay.add(c.getWeek().getWEDNESDAY());
                        break;
                    case "Thursday":
                        lNew.listDay.add(c.getWeek().getTHURSDAY());
                        break;
                    case "Friday":
                        lNew.listDay.add(c.getWeek().getFRIDAY());
                        break;
                    case "Saturday":
                        lNew.listDay.add(c.getWeek().getSATURDAY());
                        break;
                    case "Sunday":
                        lNew.listDay.add(c.getWeek().getSUNDAY());
                        break;
                    default:
                        break;
                }
            }

            lNew.listMember = new ArrayList();
            for (Member m : this.listMember) {
                Member mNew = (Member) m.clone(c);
                mNew.setOwnHouse(lNew);
                lNew.addMember(mNew);
                c.getListMember().put(mNew.getId(), mNew);
            }
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lNew;
    }

    public List<Member> getListMember() {
        return listMember;
    }

    public void setListMember(List<Member> listMember) {
        this.listMember = listMember;
    }

}
