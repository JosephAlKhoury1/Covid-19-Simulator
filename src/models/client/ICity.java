/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.client;

import models.location.Location;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;
import models.member.Member;
import models.transportation.Transportation;

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
