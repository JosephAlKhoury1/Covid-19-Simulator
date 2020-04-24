/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.location;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import models.client.City;
import models.client.Data;
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
    protected int wTile;
    protected int hTile;
    protected double average_sick;
    protected Map<Integer, Member> listMember;
    protected Image image;
    protected JPanel panel;
    protected City city;
    protected List<Tile> listTile;
    protected boolean fixedLocation;

    public Location(int x, int y, int wTile, int hTile, double average_sick, JPanel panel, City city) {
        this.x = x;
        this.y = y;
        this.wTile = wTile;
        this.hTile = hTile;
        this.width = Data.TileWidth * wTile;
        this.height = Data.TileHeight * hTile;
        this.average_sick = average_sick;
        this.listMember = new HashMap();
        this.panel = panel;
        this.city = city;
        this.listTile = new ArrayList();
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

    public int getwTile() {
        return wTile;
    }

    public void setwTile(int wTile) {
        this.wTile = wTile;
    }

    public int gethTile() {
        return hTile;
    }

    public void sethTile(int hTile) {
        this.hTile = hTile;
    }

    public boolean isFixedLocation() {
        return fixedLocation;
    }

    public void setFixedLocation(boolean fixedLocation) {
        this.fixedLocation = fixedLocation;
    }

    public abstract void draw(Graphics g);

    protected abstract void loadImage();

    public abstract void initPopulation();
}
