/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import models.ICity;

/**
 *
 * @author Joseph
 */
public interface IServer extends Remote {

    public void addCity(ICity ic) throws RemoteException;

    public void removeCity(ICity ic) throws RemoteException;
}
