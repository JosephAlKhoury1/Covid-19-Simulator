package models.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import models.location.Location;

public class LocationLinkedList {

    private SpecifiedLocation head = null;
    private int nb = 0;
    private Location ownHouse;

    private int[] timeTab;
    private SpecifiedLocation[] specTab;

    public LocationLinkedList(Location ownHouse) {
        this.timeTab = new int[25];
        specTab = new SpecifiedLocation[25];
        this.ownHouse = ownHouse;
        for (int i = 0; i < 25; i++) {
            this.timeTab[i] = i;
        }
    }

    public int size() {
        int n = 0;
        SpecifiedLocation tmp = head;
        while (tmp != null) {
            n++;
            tmp = tmp.getNextLocation();
        }
        return n;
    }

    public boolean isEmpty() {
        return nb <= 0;
    }

    public boolean contains(Object o) {
        return true;
    }

    public void add(List<SpecifiedLocation> list, SpecifiedLocation school,
            SpecifiedLocation university, SpecifiedLocation work, SpecifiedLocation old) {
        SpecifiedLocation sc = school;
        SpecifiedLocation un = university;
        SpecifiedLocation wo = work;

        if (old != null) {
            int rem = old.getRemainingTime();
            if (rem > 0) {
                for (int i = 0; i < rem; i++) {
                    timeTab[i] = -1;
                    specTab[i] = old;
                }
            }
        }

        boolean isOk = true;
        if (school != null) {
            int beg = school.getGoTime();
            if (beg < 0) {
                beg = 0;
            }

            int leave = school.getLeaveTime();
            if (leave > 24) {
                leave = 24;
            }
            for (int i = beg; i < leave; i++) {
                if (timeTab[i] == -1) {
                    isOk = false;
                    sc = null;
                    break;
                }
            }
            if (sc != null && sc.isIsNull()) {
                isOk = false;
            }
            if (isOk) {
                for (int i = beg; i < leave; i++) {
                    timeTab[i] = -1;
                    specTab[i] = sc;
                }
            }
        }
        isOk = true;
        if (university != null) {
            int beg = university.getGoTime();
            if (beg < 0) {
                beg = 0;
            }

            int leave = university.getLeaveTime();
            if (leave > 24) {
                leave = 24;
            }
            for (int i = beg; i < leave; i++) {
                if (timeTab[i] == -1) {
                    isOk = false;
                    un = null;
                    break;
                }
            }
            if (un != null && un.isIsNull()) {
                isOk = false;
            }
            if (isOk) {
                for (int i = beg; i < leave; i++) {
                    timeTab[i] = -1;
                    specTab[i] = un;
                }
            }
        }
        isOk = true;
        if (work != null) {
            int beg = work.getGoTime();
            if (beg < 0) {
                beg = 0;
            }

            int leave = work.getLeaveTime();
            if (leave > 24) {
                leave = 24;
            }
            for (int i = beg; i < leave; i++) {
                if (timeTab[i] == -1) {
                    isOk = false;
                    wo = null;
                    break;
                }
            }
            if (wo != null && wo.isIsNull()) {
                isOk = false;
            }
            if (isOk) {
                for (int i = beg; i < leave; i++) {
                    timeTab[i] = -1;
                    specTab[i] = wo;
                }
            }
        }

        List<SpecifiedLocation> tmp = new ArrayList();
        for (SpecifiedLocation sl : list) {
            isOk = true;
            int beg = sl.getGoTime();
            if (beg < 0) {
                beg = 0;
            }

            int leave = sl.getLeaveTime();
            if (leave > 24) {
                leave = 24;
            }
            for (int i = beg; i < leave; i++) {
                if (timeTab[i] == -1) {
                    isOk = false;
                    tmp.add(sl);
                    break;
                }
            }
            if (isOk) {
                for (int i = beg; i < leave; i++) {
                    timeTab[i] = -1;
                    specTab[i] = sl;
                }
            }
        }
        for (SpecifiedLocation sl : tmp) {
            list.remove(sl);
        }

        if (sc != null) {
            list.add(sc);
        }
        if (un != null) {
            list.add(un);
        }
        if (wo != null) {
            list.add(wo);
        }
        Map<Integer, Integer> tmpMap = new HashMap();

        int between = 0;
        for (int i = 0; i < timeTab.length; i++) {
            if (timeTab[i] != -1) {
                between++;
                if (i == 24) {
                    if (between > 0) {
                        tmpMap.put(i - between + 1, 24);
                        between = 0;
                    }
                }
            } else {
                if (between > 0) {
                    tmpMap.put(i - between, i);
                    between = 0;
                }
            }
        }
        for (Entry<Integer, Integer> e : tmpMap.entrySet()) {
            SpecifiedLocation house = new SpecifiedLocation(ownHouse, e.getKey(), e.getValue());
            if (e.getValue() == 24) {
                for (int z = e.getKey(); z <= e.getValue(); z++) {
                    specTab[z] = house;
                }
            } else {
                for (int z = e.getKey(); z < e.getValue(); z++) {
                    specTab[z] = house;
                }
            }
        }

        SpecifiedLocation current = null;
        for (SpecifiedLocation sp : specTab) {
            if (current == null) {
                current = sp;
            }
            if (this.head == null) {
                this.head = sp;
                nb++;
            }
            if (current != sp) {
                current.setNextLocation(sp);
                sp.setPreviousLocation(current);
                current = sp;
            }

        }
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void clear() {
        head = null;
        nb = 0;
        for (int i = 0; i < 25; i++) {
            timeTab[i] = i;
            specTab[i] = null;
        }
    }

    public SpecifiedLocation getFirst() {
        return this.head;
    }

    public int[] getTimeTab() {
        return timeTab;
    }

}
