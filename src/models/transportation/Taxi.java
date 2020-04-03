/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.transportation;

import java.awt.Graphics;
import java.rmi.RemoteException;
import models.member.Member;

/**
 *
 * @author Joseph
 */
public class Taxi extends Transportation{

    public Taxi(int id, int x, int y, int width, int height, double averageSick, int numberMember) throws RemoteException {
        super(id, x, y, width, height, averageSick, numberMember);
    }

    public Taxi() throws RemoteException {
    }

    @Override
    protected void draw(Graphics g) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean isIn(Member m) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notify(String message) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
