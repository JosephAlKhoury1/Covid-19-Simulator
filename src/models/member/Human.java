/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.member;

import java.awt.Graphics;
import java.rmi.RemoteException;

/**
 *
 * @author Joseph
 */
public class Human extends Member {

    private String firstName;
    private String lastName;

    @Override
    protected void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notify(String message) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Human(String firstName, String lastName, int id, int age, int x, int y, double rNumber) throws RemoteException {
        super(id, age, x, y, rNumber);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Human(int id, int age, int x, int y, double rNumber) throws RemoteException {
        super(id, age, x, y, rNumber);
    }

}
