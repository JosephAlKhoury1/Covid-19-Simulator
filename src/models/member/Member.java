/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.member;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import models.client.City;
import models.client.SexeType;
import models.location.House;
import models.location.Location;
import views.tile.Tile;

/**
 *
 * @author Joseph
 */
public abstract class Member implements Runnable, Serializable {

    protected int x, y;
    protected int id;
    protected House ownHouse;
    protected City city;
    protected Tile myTile;
    protected int age;
    protected SexeType sexeType;
    protected List<Location> listLocation;
    protected int locationIndex;
    protected Location currentLocationToGo;
    protected Tile currentTile;

    protected List<Tile> listTileWaked = new ArrayList();

    public abstract void draw(Graphics g);

    public List<Location> getListLocation() {
        return listLocation;
    }

    public void setListLocation(List<Location> listLocation) {
        this.listLocation = listLocation;
    }

    public int getLocationIndex() {
        return locationIndex;
    }

    public void setLocationIndex(int locationIndex) {
        this.locationIndex = locationIndex;
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

    public Member(int id, int x, int y, House ownHouse, City city) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.city = city;
        this.ownHouse = ownHouse;
        this.listLocation = new ArrayList();
        this.currentTile = city.getTile(x, y);
    }

    public Member() {
    }

    public int getId() {
        return this.id;
    }

    public House getOwnHouse() {
        return ownHouse;
    }

    public void setOwnHouse(House ownHouse) {
        this.ownHouse = ownHouse;
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

  

    public void move() {
        if (this.currentLocationToGo == null) {
            return;
        }
        if (currentTile == null) {
            currentTile = city.getTile(this.x, this.y);
        }
        final int step = 6;
        boolean containX = currentLocationToGo.containX(this.x);
        boolean containY = currentLocationToGo.containY(this.y);

        if (containX && containY) {
            return;
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
                return;
            }
        }
    }

    @Override
    public void run() {
        while (true) {

        }
    }
}
