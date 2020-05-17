/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.client1;

import models.client.*;

/**
 *
 * @author Salah
 */
public enum HumanStat {

    sick("sick"),
    healthy("healthy"),
    immune("immune"),
    infected("infected"),
    dead("dead"),
    inHospital("inHospital"),
    inIcu("inIcu");

    private final String stat;

    private HumanStat(String stat) {
        this.stat = stat;
    }
    
    
}
