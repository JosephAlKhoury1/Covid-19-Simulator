/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.client1.Day;
import models.client1.Week;
import models.location1.Location;
import models.location1.LocationCategory;
import models.member1.Member;

/**
 *
 * @author Joseph
 */
public class FileUtilities {

    static String path = "‪‪C:\\Users\\Joseph\\Desktop";

    public static void saveStat(Map<Integer, Member> list) {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter("C:\\Users\\Joseph\\Desktop\\simulator.txt"));
            for (Entry<Integer, Member> e : list.entrySet()) {
                pr.print(e.getValue().getId());

                pr.println();
                if (e.getValue().getSchool() != null) {
                    pr.print(" school x = " + e.getValue().getSchool().getX() + " y = " + e.getValue().getSchool().getY());
                }
                if (e.getValue().getUniversity() != null) {
                    pr.print("university x = " + e.getValue().getUniversity().getX() + " y = " + e.getValue().getUniversity().getY());
                }
                if (e.getValue().getWorkPlace() != null) {
                    pr.print("work x = " + e.getValue().getWorkPlace().getX() + " y = " + e.getValue().getWorkPlace().getY());
                }
                pr.print("list size = " + e.getValue().getListLocation().size());
                for (Entry<Location, Integer> ee : e.getValue().getListLocation().entrySet()) {
                    pr.print("time in = " + ee.getValue());
                    pr.print("location x = " + ee.getKey().getX() + " y = " + ee.getKey().getY());
                    pr.println();
                }
                if (e.getValue().getCurrentLocationToGo() != null) {
                    pr.print("current location x =" + e.getValue().getCurrentLocationToGo().getX() + " y = " + e.getValue().getCurrentLocationToGo().getY());
                }
                pr.println();
            }
            pr.close();
            //out.println();// new li
        } catch (IOException ex) {
            Logger.getLogger(FileUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void saveWeek(Week week) {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter("C:\\Users\\Joseph\\Desktop\\simulator.txt"));
            for (Day d : week.getListDay()) {
                pr.print("Day : " + d.getDay().getName());
                pr.println();
                for (Entry<String, LocationCategory> e : d.getListLocationCategory().entrySet()) {
                    pr.print("category = " + e.getValue().getKind());
                    pr.println();
                    for (Location l : e.getValue().getListLocation()) {
                        pr.println("location : x = " + l.getX() + " y = " + l.getY());
                        pr.println("days = " + l.getDays());
                    }
                }
            }
            pr.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
