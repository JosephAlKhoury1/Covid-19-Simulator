/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.member;

import java.awt.Graphics;
import java.io.Serializable;
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
    protected List<Location>listLocation;
    public abstract void draw(Graphics g);

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
        this.ownHouse = ownHouse;
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

    public void moveUp() {
        y = y - 1;
    }

    public void moveDown() {
        y = y + 1;
    }

    public void moveLeft() {
        x = x - 1;
    }

    public void moveRight() {
        x = x + 1;
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
    

    @Override
    public void run() {
        while (true) {

        }
    }
}
