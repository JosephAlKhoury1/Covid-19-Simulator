/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.member;

import java.awt.Graphics;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Joseph
 */
public abstract class Member extends UnicastRemoteObject implements IMember {

    protected int id;
    protected int age;
    protected int x;
    protected int y;
    protected double rNumber;

    public Member(int id, int age, int x, int y, double rNumber) throws RemoteException {
        this.id = id;
        this.age = age;
        this.x = x;
        this.y = y;
        this.rNumber = rNumber;
    }

    public Member() throws RemoteException {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public double getrNumber() {
        return rNumber;
    }

    public void setrNumber(double rNumber) {
        this.rNumber = rNumber;
    }

    protected abstract void draw(Graphics g);
}
