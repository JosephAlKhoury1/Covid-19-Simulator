package models.location;

import controller.locationController.TimeRowController;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimeRow implements Cloneable {

    private int id;
    private String name;
    private int openTime;
    private int closeTime;
    private double humanPercentage;

    private DayRow dayrow;
    private boolean isNew, saved, deleted;
    private TimeRowPanel panel;

    private TimeRow previousTimeRow = null;
    private TimeRow nextTimeRow = null;
    private boolean canBeUsed = true;
    private boolean minValid = false, maxValid = false;

    public TimeRow(DayRow dayRow) {
        this.name = "From   to   ";
        this.openTime = -2;
        this.closeTime = -1;

        if (openTime != -2) {
            this.minValid = true;
        } else {
            this.minValid = false;
            this.name = "Invalid";
        }

        if (closeTime != -1) {
            this.maxValid = true;
        } else {
            this.maxValid = false;
            this.name = "Invalid";
        }

        this.humanPercentage = 0.0;
        this.dayrow = dayRow;

        this.isNew = true;
        this.saved = false;
        this.deleted = false;
        this.panel = new TimeRowPanel(this);
        this.canBeUsed = false;

    }

    public TimeRow(int id, String name, int openTime, int closeTime, double humanPercentage, DayRow dayRow) {
        this.id = id;
        this.name = name;
        this.openTime = openTime;
        this.closeTime = closeTime;

        if (openTime != -2) {
            this.minValid = true;
        } else {
            this.minValid = false;
            this.name = "Invalid";
        }

        if (closeTime != -1) {
            this.maxValid = true;
        } else {
            this.maxValid = false;
            this.name = "Invalid";
        }

        this.humanPercentage = humanPercentage;
        this.dayrow = dayRow;
        this.isNew = false;
        this.saved = false;
        this.deleted = false;
        this.canBeUsed = true;
        if (this.openTime == -2) {
            this.canBeUsed = false;
        }

        if (this.closeTime == -1) {
            this.canBeUsed = false;
        }
    }

    public void initPanel() {
        this.panel = new TimeRowPanel(this);
    }

    public TimeRow getPreviousTimeRow() {
        return previousTimeRow;
    }

    public void setPreviousTimeRow(TimeRow previousTimeRow) {
        this.previousTimeRow = previousTimeRow;
    }

    public TimeRow getNextTimeRow() {
        return nextTimeRow;
    }

    public void setNextTimeRow(TimeRow nextTimeRow) {
        this.nextTimeRow = nextTimeRow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOpenTime() {
        return openTime;
    }

    public void setOpenTime(int openTime) {
        this.openTime = openTime;
    }

    public int getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(int closeTime) {
        this.closeTime = closeTime;
    }

    public double getHumanPercentage() {
        return humanPercentage;
    }

    public void setHumanPercentage(double humanPercentage) {
        this.humanPercentage = humanPercentage;
    }

    public DayRow getDayrow() {
        return dayrow;
    }

    public void setDayrow(DayRow dayrow) {
        this.dayrow = dayrow;
    }

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public boolean isSaved() {
        return saved;
    }

    public TimeRowPanel getPanel() {
        return panel;
    }

    public void setPanel(TimeRowPanel panel) {
        this.panel = panel;
    }

    public boolean isCanBeUsed() {
        return canBeUsed;
    }

    public void setCanBeUsed(boolean canBeUsed) {
        this.canBeUsed = canBeUsed;
    }

    public boolean isMinValid() {
        return minValid;
    }

    public void setMinValid(boolean minValid) {
        this.minValid = minValid;
    }

    public boolean isMaxValid() {
        return maxValid;
    }

    public void setMaxValid(boolean maxValid) {
        this.maxValid = maxValid;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void save() {
        if (this.isDeleted()) {
            if (this.isNew) {
            } else {
                TimeRowController.INSTANCE.delete(id);
            }
        } else {
            if (this.isNew) {
                this.id = TimeRowController.INSTANCE.insert(this);
                this.setIsNew(false);
                this.setSaved(true);
                return;
            }
            if (!this.isSaved()) {
                if (!this.isIsNew()) {
                    TimeRowController.INSTANCE.update(this);
                }
            }
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        TimeRow tr = (TimeRow) super.clone();
        return tr;
    }

    public Object clone(DayRow d) {
        try {
            TimeRow tr = (TimeRow) this.clone();
//            tr = new TimeRow(id, name, openTime, closeTime, humanPercentage, d);
//            tr.initPanel();
            tr.setDayrow(d);
            tr.initPanel();
            return tr;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(TimeRow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
