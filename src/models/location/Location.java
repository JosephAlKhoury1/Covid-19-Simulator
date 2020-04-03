/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.location;

import java.awt.Graphics;
import models.member.Member;

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

    public Location(int id, int x, int y, int width, int height, double average_sick) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.average_sick = average_sick;
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

    protected abstract void draw(Graphics g);
    protected abstract boolean isIn(Member m);
}
