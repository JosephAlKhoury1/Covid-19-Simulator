package models.location;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import models.client.City;
import models.client.Day;
import models.member.Human;
import models.member.Member;
import views.tile.Tile;

/**
 *
 * @author Joseph
 */
public abstract class Location {

    protected int id;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected double average_sick;
    protected int openTime, closeTime;
    protected Map<Integer, Member> listMember;
    protected Image image;
    protected City city;
    protected List<Tile> listTile;
    protected boolean fixedLocation = false;
    protected List<Day> listDay;
    protected List<Human> listWorker;

    public Location(int x, int y, double average_sick, City city) {
        this.x = x;
        this.y = y;
        this.average_sick = average_sick;
        this.listMember = new HashMap();
        this.city = city;
        this.listTile = new ArrayList();
        this.listDay = new ArrayList();

    }

    public List<Day> getListDay() {
        return listDay;
    }

    public void setListDay(List<Day> listDay) {
        this.listDay = listDay;
    }

    public Location() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
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
        this.listMember.put(m.getId(), m);
        this.city.getListMember().put(m.getId(), m);
    }

    public int getOpenTime() {
        return openTime;
    }

    public void setOpenTime(int openTime) {
        this.openTime = openTime;
    }

    public int getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(int closeTime) {
        this.closeTime = closeTime;
    }

    public void removeMember(int id) {
        this.listMember.remove(id);
    }

    public Map<Integer, Member> getListMember() {
        return listMember;
    }

    public void setListMember(Map<Integer, Member> listMember) {
        this.listMember = listMember;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Tile> getListTile() {
        return listTile;
    }

    public void setListTile(List<Tile> listTile) {
        this.listTile = listTile;
    }

    public void addTile(Tile t) {
        this.listTile.add(t);
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

    public void addWorker(Human h) {
        this.listWorker.add(h);
    }

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

    public abstract void draw(Graphics g);

    protected abstract void loadImage();

    public abstract void initPopulation();
}
