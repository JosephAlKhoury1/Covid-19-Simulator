/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.transportation1;

import java.awt.Graphics;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import models.member1.Member;

/**
 *
 * @author Joseph
 */
public abstract class Transportation implements Serializable {

    protected int id;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected double averageSick;
    protected int numberMember;
    protected Map<Integer, Member> listMember;

    public Transportation(int id, int x, int y, int width, int height, double averageSick, int numberMember) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.averageSick = averageSick;
        this.numberMember = numberMember;
        this.listMember = new HashMap();
    }

    public Transportation() {
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

    public double getAverageSick() {
        return averageSick;
    }

    public void setAverageSick(double averageSick) {
        this.averageSick = averageSick;
    }

    public int getNumberMember() {
        return numberMember;
    }

    public void setNumberMember(int numberMember) {
        this.numberMember = numberMember;
    }

    public void addMember(Member m) {
        this.listMember.put(m.getId(), m);
    }

    public void removeMember(int id) {
        this.listMember.remove(id);
    }

    public Map<Integer, Member> getListMember() {
        return this.listMember;
    }

    protected abstract void draw(Graphics g) throws RemoteException;

}
