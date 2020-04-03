/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.transportationFactory;

import java.rmi.RemoteException;
import models.transportation.Taxi;
import models.transportation.Transportation;

/**
 *
 * @author Joseph
 */
public class TaxiFactory extends TransportationFactory {

    @Override
    protected Transportation createTransportation(int id, int x, int y, int width, int height, double averageSick, int numberMember) throws RemoteException {
        return new Taxi(id, x, y, width, height, averageSick, numberMember);
    }

}
