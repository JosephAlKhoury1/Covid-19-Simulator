/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.transportation;

import java.awt.Graphics;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import models.member.Member;

/**
 *
 * @author Joseph
 */
public abstract class Transportation extends UnicastRemoteObject implements ITransportation {

    protected int id;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected double averageSick;
    protected int numberMember;

    public Transportation(int id, int x, int y, int width, int height, double averageSick, int numberMember) throws RemoteException {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.averageSick = averageSick;
        this.numberMember = numberMember;
    }

    public Transportation() throws RemoteException {
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

    protected abstract void draw(Graphics g) throws RemoteException;

    protected abstract boolean isIn(Member m) throws RemoteException;
}
