package models.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Properties.MonteCarlo;
import static Properties.MonteCarlo.uniformFixedSeed;
import models.location.DayRow;
import models.location.Location;
import models.location.TimeRow;

public class SpecifiedLocation {

    private Location location;
    private int timeIn;
    private TimeRow timeRow;
    private DayRow dayRow;
    private int goTime;
    private int fixed;
    private int leaveTime;
    private int remainingTime;
    private int hour;
    private String kind = null;
    private boolean isNull = false;

    private SpecifiedLocation previousLocation;
    private SpecifiedLocation nextLocation;
    private int[] tab = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    private int[] tabIn = {1, 2, 3, 4};

    public SpecifiedLocation(Location l, String day, int fixed) {
        this.location = l;
        if (fixed == 0) {
            specifyTimeNotFixed(day);
        } else {
            specifyTimeFixed(day);
        }
        this.fixed = fixed;
        hour = 0;
    }

    public SpecifiedLocation(Location ownHouse, int beg, int leave) {
        this.location = ownHouse;
        this.goTime = beg;
        this.leaveTime = leave;
    }

    public SpecifiedLocation(Location location, String kind) {
        this.location = location;
        this.kind = kind;
    }

    SpecifiedLocation(Location work1, String day, String hos) {
        this.location = work1;
        for (DayRow dr : work1.getListDayRow()) {
            if (dr.getName().equals(day)) {
                this.dayRow = dr;
                break;
            }
        }
        if (this.dayRow != null) {
            this.timeRow = getTimeRow(dayRow);
        }
        if (this.timeRow != null) {
            int tmp = this.timeRow.getCloseTime() - this.timeRow.getOpenTime();
            if (tmp > 10) {
                this.timeIn = MonteCarlo.getNextIntBetween2Number(tmp / 4, tmp / 2);
            } else {
                timeIn = tmp;
            }
            this.goTime = this.timeRow.getOpenTime() - timeIn;
            if (this.goTime < 0) {
                this.goTime = 0;
            }
            this.leaveTime = this.goTime + this.timeIn;
            hour = 0;
            this.remainingTime = this.timeIn;
        }
    }

    public void setLeaveTime(int leaveTime) {
        this.leaveTime = leaveTime;
    }

    public int getLeaveTime() {
        return leaveTime;
    }

    private void specifyTimeFixed(String day) {
        for (DayRow d : location.getListDayRow()) {
            if (d.getName().equals(day)) {
                if (d.getUsed() == 1) {
                    this.dayRow = d;
                    this.timeRow = getTimeRow(d);
                    if (this.timeRow != null) {
                        this.goTime = this.timeRow.getOpenTime();
                        this.timeIn = this.timeRow.getCloseTime() - this.timeRow.getOpenTime();
                    } else {
                        this.goTime = 8;
                        this.timeIn = 8;
                    }
                    this.leaveTime = this.goTime + this.timeIn;
                    if (this.leaveTime > 24) {
                        this.leaveTime = this.leaveTime - 24;
                    }
                    this.remainingTime = timeIn;
                    if (this.goTime > 0) {
                        this.goTime--;
                    }
                    break;
                } else {
                    isNull = true;
                }
            }
        }
    }

    public boolean isIsNull() {
        return isNull;
    }

    public void setIsNull(boolean isNull) {
        this.isNull = isNull;
    }

    private void specifyTimeNotFixed(String day) {
        for (DayRow d : location.getListDayRow()) {
            if (d.getName().equals(day)) {
                this.dayRow = d;
                this.timeRow = getTimeRow(d);
                this.goTime = getGoTime(timeRow);
                this.timeIn = getTimeIn(this.goTime, timeRow);
                this.leaveTime = this.goTime + this.timeIn;
                if (this.leaveTime > 24) {
                    this.leaveTime = this.leaveTime - 24;
                }
                this.remainingTime = timeIn;
                if (this.goTime > 0) {
                    this.goTime--;
                }
                break;
            }
        }
    }

    private TimeRow getTimeRow(DayRow d) {
        if (d.getListTimeRow().isEmpty()) {
            return null;
        } else if (d.getListTimeRow().size() == 1) {
            return d.getListTimeRow().get(0);
        }

        double sumPer = 0;
        boolean allZero = true;
        for (TimeRow tr : d.getListTimeRow()) {
            if (tr.isMaxValid() && tr.isMinValid()) {
                sumPer += tr.getHumanPercentage();
                if (tr.getHumanPercentage() != 0) {
                    allZero = false;
                }
            }
        }

        List<TimeRow> newList = new ArrayList();
        Map<TimeRow, Double> newMap = new HashMap();
        if (allZero) {
            double newPer = 100 / d.getListTimeRow().size();
            for (TimeRow tr : d.getListTimeRow()) {
                if (tr.isMaxValid() && tr.isMinValid()) {
                    newList.add(tr);
                    newMap.put(tr, newPer);
                }
            }
        } else {
            for (TimeRow tr : d.getListTimeRow()) {
                if (tr.isMaxValid() && tr.isMinValid()) {
                    double newPer = tr.getHumanPercentage() * 100 / sumPer;
                    newList.add(tr);
                    newMap.put(tr, newPer);
                }
            }
        }
        while (true) {
            int index = uniformFixedSeed.nextInt(newList.size());
            TimeRow tr = (TimeRow) newList.get(index);
            Double prob = newMap.get(tr) / 100d;
            double newRandom = uniformFixedSeed.nextDouble();
            if (newRandom <= prob) {
                return tr;
            }
        }
    }

    public int getGoTime(TimeRow t) {
        if (t == null) {
            int index = MonteCarlo.getNextInt(tab.length);
            return tab[index];
        }
        List<Integer> list = new ArrayList();
        for (int i = t.getOpenTime(); i < t.getCloseTime(); i++) {
            list.add(i);
        }
        int index = uniformFixedSeed.nextInt(list.size());
        return list.get(index);
    }

    public int getTimeIn(int first, TimeRow tr) {
        if (tr == null) {
            int index = MonteCarlo.getNextInt(tabIn.length);
            return tabIn[index];
        }
        int time = this.timeRow.getCloseTime() - this.goTime;
        int t1 = uniformFixedSeed.nextInt(time) + 1;
        int t2 = 0;
        if (this.timeRow.getNextTimeRow() != null) {
            time = this.timeRow.getNextTimeRow().getCloseTime() - this.timeRow.getNextTimeRow().getOpenTime();
            t2 = MonteCarlo.getNextIntBetween2Number(0, time);
        }
        return t1 + t2;
    }

    public Location getLocation() {
        return location;
    }

    public int getFixed() {
        return fixed;
    }

    public int getTimeIn() {
        return timeIn;
    }

    public TimeRow getTimeRow() {
        return timeRow;
    }

    public DayRow getDayRow() {
        return dayRow;
    }

    public int getGoTime() {
        return goTime;
    }

    public SpecifiedLocation getPreviousLocation() {
        return previousLocation;
    }

    public void setPreviousLocation(SpecifiedLocation previousLocation) {
        this.previousLocation = previousLocation;
    }

    public SpecifiedLocation getNextLocation() {
        return nextLocation;
    }

    public void setNextLocation(SpecifiedLocation nextLocation) {
        this.nextLocation = nextLocation;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public SpecifiedLocation checkToGoNext(int hour, Member m) {
        if (this.hour != hour) {
            this.remainingTime -= 1;
            this.hour = hour;
        }
        if (!m.canMove && kind != null) {
            return this;
        }
        if (this.leaveTime == hour) {
            if (this.getNextLocation() != null) {
                //member
                int x = m.getX();
                int y = m.getY();
                int lx = this.nextLocation.getLocation().getX();
                int ly = this.nextLocation.getLocation().getY();
                int lh = this.nextLocation.getGoTime();

                int dh = lh - hour;
                this.location.getListMember().remove(m);
                return this.nextLocation;
            } else {
                return this;
            }
        } else {
            return this;
        }
    }

}
