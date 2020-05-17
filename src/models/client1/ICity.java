/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.client1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;
import models.location1.*;
import models.member1.Member;
import models.transportation1.Transportation;

/**
 *
 * @author Joseph
 */
public interface ICity extends Remote {

    public void notifyHuman(Member m) throws RemoteException;

    public void notifyTransportation(Transportation t) throws RemoteException;

    public int getPopulation() throws RemoteException;

    public Map<Integer, Location> getListLocations() throws RemoteException;

    public Location getLocation(String kind) throws RemoteException;
}
