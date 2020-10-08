package models.location1;

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

    private boolean openTimeNotSet;
    private boolean closeTimeNotSet;

    private TimeRow previousTimeRow = null;
    private TimeRow nextTimeRow = null;
    private boolean canBeUsed;

    public TimeRow(DayRow dayRow) {
        this.name = "From   to   ";
        this.openTime = -2;
        this.closeTime = -1;
        this.humanPercentage = 0.0;
        this.dayrow = dayRow;

        this.isNew = true;
        this.saved = false;
        this.deleted = false;
        this.openTimeNotSet = true;
        this.closeTimeNotSet = true;
        this.panel = new TimeRowPanel(this);
        this.canBeUsed = false;

    }

    public TimeRow(int id, String name, int openTime, int closeTime, double humanPercentage, DayRow dayRow) {
        this.id = id;
        this.name = name;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.humanPercentage = humanPercentage;
        this.dayrow = dayRow;
        this.isNew = false;
        this.saved = false;
        this.deleted = false;
        this.canBeUsed = true;
        if (this.openTime == -2) {
            this.openTimeNotSet = true;
            this.canBeUsed = false;
        } else {
            this.openTimeNotSet = false;
        }

        if (this.closeTime == -1) {
            this.closeTimeNotSet = true;
            this.canBeUsed = false;
        } else {
            this.closeTimeNotSet = false;
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

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isOpenTimeNotSet() {
        return openTimeNotSet;
    }

    public void setOpenTimeNotSet(boolean openTimeNotSet) {
        this.openTimeNotSet = openTimeNotSet;
    }

    public boolean isCloseTimeNotSet() {
        return closeTimeNotSet;
    }

    public void setCloseTimeNotSet(boolean closeTimeNotSet) {
        this.closeTimeNotSet = closeTimeNotSet;
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
        tr.initPanel();
        return tr;
    }

    public Object clone(DayRow d) {
        try {
            TimeRow tr = (TimeRow) this.clone();
            tr.setDayrow(d);
            return tr;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(TimeRow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
