package models.location1;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import models.client1.City;
import models.client1.Day;
import models.member1.Member;
import views.tile.Tile;
import views1.Maps;

/**
 *
 * @author Joseph
 */
public abstract class Location {

    protected int id = -1;
    protected String name;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected double average_sick;
    protected int locationCategoryId;
    protected Maps map;

    protected boolean isNew, saved, deleted = false;

    public Maps getMap() {
        return map;
    }

    protected City city;

    protected boolean fixedLocation = false;
    protected Image image;

    protected List<Day> listDay;
    protected List<Tile> listTile;

    public Location(String name, int x, int y, double average_sick, int locationCategoryId) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.average_sick = average_sick;
        this.locationCategoryId = locationCategoryId;
        this.listDay = new ArrayList();
        this.listTile = new ArrayList();
        this.isNew = true;
        this.saved = false;
    }

    public Location(String name, int x, int y, double average_sick) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.average_sick = average_sick;
        this.listDay = new ArrayList();
        this.listTile = new ArrayList();
        this.isNew = true;
        this.saved = false;
    }

    public Location(int id, String name, int x, int y, int width, int height, double average_sick, int locationCategoryId) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.average_sick = average_sick;
        this.locationCategoryId = locationCategoryId;
        this.listDay = new ArrayList();
        this.listTile = new ArrayList();
        this.isNew = false;
        this.saved = true;
    }

    public boolean isIsNew() {
        return isNew;
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
        //this.listMember.put(m.getId(), m);
        this.city.getListMember().put(m.getId(), m);
    }

    public boolean isFixedLocation() {
        return fixedLocation;
    }

    public void setFixedLocation(boolean fixedLocation) {
        this.fixedLocation = fixedLocation;
    }

    public void addDay(Day d) {
        this.listDay.add(d);
        d.addLocation(this);
    }

    public void removeDay(Day d) {
        this.listDay.remove(d);
        d.removeLocation(this);
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

    public abstract void setOpenTime(double openTime);

    public abstract void setCloseTime(double closeTime);

    public abstract void draw(Graphics g);

    protected abstract void loadImage();

    public abstract void initPopulation();

    public abstract void save();
}
