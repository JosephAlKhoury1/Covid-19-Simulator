package models.location;

import controller.locationController.DayRowController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joseph
 */
public class DayRow implements Cloneable {

    private int id;
    private String name;
    private LocationCategory lc;
    private List<TimeRow> listTimeRow;
    private List<TimeRow> listDeleted;
    private int used;

    private boolean isNew, deleted, saved;

    private DayRow previousDayRow, nextDayRow;

    public DayRow(int id, String name, int used, LocationCategory lc) {
        this.id = id;
        this.name = name;
        this.lc = lc;
        this.used = used;
        this.isNew = false;
        this.deleted = false;
        this.saved = true;
        this.listDeleted = new ArrayList();
    }

    public DayRow(String name, LocationCategory lc) {
        this.name = name;
        this.lc = lc;
        this.used = 0;
        this.listTimeRow = new ArrayList();
        this.listTimeRow.add(new TimeRow(this));
        this.deleted = false;
        this.isNew = true;
        this.saved = false;
        this.listDeleted = new ArrayList();
    }

    public DayRow getPreviousDayRow() {
        return previousDayRow;
    }

    public void setPreviousDayRow(DayRow previousDayRow) {
        this.previousDayRow = previousDayRow;
    }

    public DayRow getNextDayRow() {
        return nextDayRow;
    }

    public void setNextDayRow(DayRow nextDayRow) {
        this.nextDayRow = nextDayRow;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
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

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public LocationCategory getLc() {
        return lc;
    }

    public void setLc(LocationCategory lc) {
        this.lc = lc;
    }

    public List<TimeRow> getListTimeRow() {
        return listTimeRow;
    }

    public void setListTimeRow(List<TimeRow> listTimeRow) {
        this.listTimeRow = listTimeRow;
        if (listTimeRow.isEmpty()) {
            this.setUsed(0);
        } else if (listTimeRow.size() == 1) {
            if (listTimeRow.get(0).getOpenTime() != -2 && listTimeRow.get(0).getCloseTime() != -1) {
                this.setUsed(1);
            } else {
                this.setUsed(0);
            }
        }
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public void setPreviousNextDay(DayRow previous, DayRow next) {
        this.previousDayRow = previous;
        this.nextDayRow = next;
    }

    public List<TimeRow> getListDeleted() {
        return listDeleted;
    }

    public void setListDeleted(List<TimeRow> listDeleted) {
        this.listDeleted = listDeleted;
    }

    public void save() {
        if (this.isDeleted()) {
            if (this.isNew) {
            } else {
                for(TimeRow tr:this.listTimeRow){
                    tr.setDeleted(true);
                    tr.save();
                }
                DayRowController.INSTANCE.delete(id);
            }
        } else {
            if (this.isNew) {
                this.id = DayRowController.INSTANCE.insert(this);
                this.setIsNew(false);
                this.saved = true;
            } else if (!this.saved) {
                DayRowController.INSTANCE.update(this);
                this.saved = true;
            }
        }
        for (TimeRow t : this.listTimeRow) {
            t.setDayrow(this);
            t.save();
        }
        for (TimeRow t : this.listDeleted) {
            t.setDayrow(this);
            t.save();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        DayRow dr = (DayRow) super.clone();
        dr.listTimeRow = new ArrayList();
        for (TimeRow tr : this.listTimeRow) {
            TimeRow trNew = (TimeRow) tr.clone();
            dr.listTimeRow.add(trNew);
        }
        return dr;
    }

    public Object clone(LocationCategory lc) throws CloneNotSupportedException {
        DayRow dr = (DayRow) this.clone();
        dr.setLc(lc);
        dr.listTimeRow = new ArrayList();
        for (TimeRow tr : this.listTimeRow) {
            TimeRow trNew = (TimeRow) tr.clone(dr);
            dr.listTimeRow.add(trNew);
        }
        return dr;
    }
}
