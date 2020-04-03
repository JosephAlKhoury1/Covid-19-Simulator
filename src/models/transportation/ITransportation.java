/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.transportation;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Joseph
 */
public interface ITransportation extends Remote {

    public void notify(String message) throws RemoteException;
}
