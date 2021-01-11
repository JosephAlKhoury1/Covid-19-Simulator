package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import models.client.ICity;

/**
 *
 * @author Joseph
 */
public interface IServer extends Remote {

    public void addCity(ICity ic) throws RemoteException;

    public void removeCity(ICity ic) throws RemoteException;
}
