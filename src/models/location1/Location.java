package models.location1;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.client1.City;
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
    protected double percentageToBeSick = 0.0;

    protected List<Member> listMember;

    protected boolean isNew, saved, deleted = false;

    protected City city;

    protected int fixedLocation;
    protected Image image;

    protected List<Tile> listTile;
    protected int openTimeToVisit;
    protected int closeTimeToVisit;

    protected List<DayRow> listDayRow;

    public Location(String name, int x, int y, double average_sick, int locationCategoryId, City city) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.city = city;
        this.average_sick = average_sick;
        this.locationCategoryId = locationCategoryId;
        this.listTile = new ArrayList();
        this.listMember = new ArrayList();
        this.isNew = true;
        this.saved = false;
    }

    public Location(String name, int x, int y, double average_sick, City city) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.city = city;
        this.average_sick = average_sick;
        this.listTile = new ArrayList();
        this.listMember = new ArrayList();
        this.isNew = true;
        this.saved = false;
    }

    public Location(int id, String name, int x, int y, int width, int height, double average_sick, int locationCategoryId, City c) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.average_sick = average_sick;
        this.locationCategoryId = locationCategoryId;
        this.listTile = new ArrayList();
        this.listMember = new ArrayList();
        this.isNew = false;
        this.saved = true;
        this.city = c;
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

    public List<DayRow> getListDayRow() {
        return listDayRow;
    }

    public void setListDayRow(List<DayRow> listDayRow) {
        this.listDayRow = listDayRow;
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
        this.city.getModel().getListHealth().add(m);
    }

    public int getFixedLocation() {
        return fixedLocation;
    }

    public void setFixedLocation(int fixedLocation) {
        this.fixedLocation = fixedLocation;
    }


    public boolean containX(int x) {
        if (this.x <= x && this.x + this.width > x) {
            return true;
        }
        return false;
    }

    public boolean containY(int y) {
        if (this.y <= y && this.y + this.height > y) {
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

    public abstract void draw(Graphics g);

    protected abstract void loadImage();

    public abstract void initPopulation();

    public abstract void save();

    @Override
    public Object clone() throws CloneNotSupportedException {
        Location lNew = (Location) super.clone();
        lNew.listMember = new ArrayList();
        return lNew;
    }

    public Object clone(City c) {
        Location lNew = null;
        try {
            lNew = (Location) this.clone();
            lNew.setCity(c);
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
