/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.memberFactory;

import java.rmi.RemoteException;
import models.member.Human;
import models.member.Member;

/**
 *
 * @author Joseph
 */
public class HumanFactory extends MemberFactory {

    @Override
    protected Member createMember(int id, int age, int x, int y, double rNumber) throws RemoteException{
        return new Human(id, age, x, y, rNumber);
    }

}
