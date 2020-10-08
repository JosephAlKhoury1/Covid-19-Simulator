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
import models.member1.SpecifiedLocation;

/**
 *
 * @author Joseph
 */
public class FileUtilities {

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
                if (e.getValue().getWork1() != null) {
                    pr.print("work x = " + e.getValue().getWork1().getX() + " y = " + e.getValue().getWork1().getY());
                }
//                pr.print("list size = " + e.getValue().getListLocation().size());
//                for (Entry<Location, Integer> ee : e.getValue().getListLocation().entrySet()) {
//                    pr.print("time in = " + ee.getValue());
//                    pr.print("location x = " + ee.getKey().getX() + " y = " + ee.getKey().getY());
//                    pr.println();
//                }
//                if (e.getValue().getCurrentLocationToGo() != null) {
//                    pr.print("current location x =" + e.getValue().getCurrentLocationToGo().getX() + " y = " + e.getValue().getCurrentLocationToGo().getY());
//                }
                pr.println();

                pr.print("age = " + e.getValue().getAge());
                pr.println();

                pr.print("symptom type = " + e.getValue().getSymptomType().getName());
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
//            for (Day d : week.getListDay()) {
//                pr.print("Day : " + d.getDay().getName());
//                pr.println();
//                for (Entry<String, LocationCategory> e : d.getListLocationCategory().entrySet()) {
//                    pr.print("category = " + e.getValue().getKind());
//                    pr.println();
//                    for (Location l : e.getValue().getListLocation()) {
//                        pr.println("location : x = " + l.getX() + " y = " + l.getY());
//                        pr.println("days = " + l.getDays());
//                    }
//                }
//            }
//
//            pr.print("size = " + week.getCity().getListMember().size());
            for (Entry<Integer, Member> e : week.getCity().getListMember().entrySet()) {
                SpecifiedLocation tmp = e.getValue().getListLocatioOfDay().getFirst();
                while (tmp != null) {
                    pr.print("X= " + tmp.getLocation().getX() + " Y = " + tmp.getLocation().getY());
                    pr.print("go= " + tmp.getGoTime() + " leave= " + tmp.getLeaveTime() + " timeIn= " + tmp.getTimeIn());
                    tmp=tmp.getNextLocation();
                    pr.println();
                }
                pr.println();
                pr.println();
                pr.println();
//                pr.print("ID= " + e.getKey());
//                pr.println();
//                if (e.getValue().getSchool() != null) {
//                    pr.print("school : X= " + e.getValue().getSchool().getX() + " Y= " + e.getValue().getSchool().getY());
//                    pr.println();
//                }
//                if (e.getValue().getUniversity() != null) {
//                    pr.print("University : X= " + e.getValue().getUniversity().getX() + " Y= " + e.getValue().getUniversity().getY());
//                    pr.println();
//                }
//                if (e.getValue().getWorkPlace() != null) {
//                    pr.print("work : X= " + e.getValue().getWorkPlace().getX() + " Y= " + e.getValue().getWorkPlace().getY());
//                    pr.println();
//                }
//
//                if (e.getValue().getCurrentLocationGo() != null) {
//                    pr.print("current Location : X= " + e.getValue().getCurrentLocationGo().getLocation().getX() + " Y = " + e.getValue().getCurrentLocationGo().getLocation().getY());
//                    pr.println();
//                    if (e.getValue().getCurrentLocationGo().getDayRow() != null) {
//                        pr.print("Day row= " + e.getValue().getCurrentLocationGo().getDayRow().getName());
//                        pr.println();
//                    }
//                    if (e.getValue().getCurrentLocationGo().getTimeRow() != null) {
//                        pr.print("Time row: " + e.getValue().getCurrentLocationGo().getTimeRow().getName());
//                        pr.println();
//                    }
//
//                    pr.print("time in :" + e.getValue().getCurrentLocationGo().getTimeIn());
//                    pr.println();
//                    pr.print("time go:" + e.getValue().getCurrentLocationGo().getGoTime());
//                    pr.println();
//                }
            }
            pr.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
