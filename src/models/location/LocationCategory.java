package models.location;

import models.locationFactories.ShopFactory;
import models.locationFactories.UniversityFactory;
import models.locationFactories.SchoolFactory;
import models.locationFactories.DisplacementCampFactory;
import models.locationFactories.HouseFactory;
import models.locationFactories.ChurchFactory;
import models.locationFactories.FactoryFactory;
import models.locationFactories.RefugeeCampFactory;
import models.locationFactories.MosqueFactory;
import models.locationFactories.RestaurantFactory;
import models.locationFactories.HospitalFactory;
import models.locationFactories.LocationFactory;
import models.locationFactories.SuperMarketFactory;
import controller.locationController.LocationCategoryController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.client.City;
import models.client.Data;
import Properties.MonteCarlo;
import views.tile.TileType;
import views1.city.panel.LocationProperties;
import views1.model.panel.ModelLocationProperties;

public class LocationCategory implements Cloneable {

    private int id;
    private String name;
    private int cityId;
    private String kind;
    private List<Location> listLocation;
    private double percentageToBeSick = 0.0;
    private int quantity;
    private LocationFactory factory;
    private City city;
    private int fixedLocation;

    private boolean isNew;
    private boolean saved;
    private boolean deleted = false;

    private LocationProperties locationProperties;
    private ModelLocationProperties modelLocatioProperties;

    private List<DayRow> listDayRow;
    private List<DayRow> listDayRowTmp;
    private DayRow mondayRow, tuesdayRow, wednesdayRow, thursdayRow, fridayRow, satursayRow, sundayRow;

    public LocationCategory(String name, String kind, double percentage, int quantity, City city) {
        this.name = name;
        this.listLocation = new ArrayList();

        this.listDayRow = new ArrayList();
        this.listDayRow.add(this.mondayRow = new DayRow("Monday", this));
        this.listDayRow.add(this.tuesdayRow = new DayRow("Tuesday", this));
        this.listDayRow.add(this.wednesdayRow = new DayRow("Wednesday", this));
        this.listDayRow.add(this.thursdayRow = new DayRow("Thursday", this));
        this.listDayRow.add(this.fridayRow = new DayRow("Friday", this));
        this.listDayRow.add(this.satursayRow = new DayRow("Saturday", this));
        this.listDayRow.add(this.sundayRow = new DayRow("Sunday", this));

        this.listDayRowTmp = new ArrayList();
        this.listDayRowTmp.add(this.mondayRow);
        this.listDayRowTmp.add(this.tuesdayRow);
        this.listDayRowTmp.add(this.wednesdayRow);
        this.listDayRowTmp.add(this.thursdayRow);
        this.listDayRowTmp.add(this.fridayRow);
        this.listDayRowTmp.add(this.satursayRow);
        this.listDayRowTmp.add(this.sundayRow);

        this.mondayRow.setPreviousNextDay(this.sundayRow, this.tuesdayRow);
        this.tuesdayRow.setPreviousNextDay(this.mondayRow, this.wednesdayRow);
        this.wednesdayRow.setPreviousNextDay(this.tuesdayRow, this.thursdayRow);
        this.thursdayRow.setPreviousNextDay(this.wednesdayRow, this.fridayRow);
        this.fridayRow.setPreviousNextDay(this.thursdayRow, this.satursayRow);
        this.satursayRow.setPreviousNextDay(this.fridayRow, this.sundayRow);
        this.sundayRow.setPreviousNextDay(this.satursayRow, this.mondayRow);

        this.kind = kind;
        this.percentageToBeSick = percentage;
        this.quantity = quantity;
        this.city = city;
        this.isNew = true;
        this.saved = false;
        for (DayRow dr : this.listDayRow) {
            switch (dr.getName()) {
                case "Monday":
                    this.city.getWeek().MONDAY.getListLocationCategory().put(this.name, this);
                    break;
                case "Tuesday":
                    this.city.getWeek().TUESDAY.getListLocationCategory().put(this.name, this);
                    break;
                case "Wednesday":
                    this.city.getWeek().WEDNESDAY.getListLocationCategory().put(this.name, this);
                    break;
                case "Thursday":
                    this.city.getWeek().THURSDAY.getListLocationCategory().put(this.name, this);
                    break;
                case "Friday":
                    this.city.getWeek().FRIDAY.getListLocationCategory().put(this.name, this);
                    break;
                case "Saturday":
                    this.city.getWeek().SATURDAY.getListLocationCategory().put(this.name, this);
                    break;
                case "Sunday":
                    this.city.getWeek().SUNDAY.getListLocationCategory().put(this.name, this);
                    break;
            }
        }
        if (null != kind) {
            switch (kind) {
                case "House":
                    this.factory = HouseFactory.INSTANCE;
                    break;
                case "Hospital":
                    this.factory = HospitalFactory.INSTANCE;
                    break;
                case "Church":
                    this.factory = ChurchFactory.INSTANCE;
                    break;
                case "Mosque":
                    this.factory = MosqueFactory.INSTANCE;
                    break;
                case "School":
                    this.factory = SchoolFactory.INSTANCE;
                    break;
                case "University":
                    this.factory = UniversityFactory.INSTANCE;
                    break;
                case "Restaurant":
                    this.factory = RestaurantFactory.INSTANCE;
                    break;
                case "Shop":
                    this.factory = ShopFactory.INSTANCE;
                    break;
                case "SuperMarket":
                    this.factory = SuperMarketFactory.INSTANCE;
                    break;
                case "RefugeeCamp":
                    this.factory = RefugeeCampFactory.INSTANCE;
                    break;
                case "DisplacementCamp":
                    this.factory = DisplacementCampFactory.INSTANCE;
                    break;
                case "Factory":
                    this.factory = FactoryFactory.INSTANCE;
                    break;
                default:
                    break;
            }
        }
        this.initLocation();
    }

    public LocationCategory(int id, String name, String kind, double percentage, int quantity,
            City city, List<Location> list) {
        this.id = id;
        this.name = name;
        this.cityId = city.getId();
        this.kind = kind;
        this.city = city;
        this.listDayRowTmp = new ArrayList();
        this.percentageToBeSick = percentage;
        this.quantity = quantity;
        this.listLocation = list;
        this.isNew = false;
        this.saved = true;
        if (null != kind) {
            switch (kind) {
                case "House":
                    this.factory = HouseFactory.INSTANCE;
                    break;
                case "Hospital":
                    this.factory = HospitalFactory.INSTANCE;
                    break;
                case "Church":
                    this.factory = ChurchFactory.INSTANCE;
                    break;
                case "Mosque":
                    this.factory = MosqueFactory.INSTANCE;
                    break;
                case "School":
                    this.factory = SchoolFactory.INSTANCE;
                    break;
                case "University":
                    this.factory = UniversityFactory.INSTANCE;
                    break;
                case "Restaurant":
                    this.factory = RestaurantFactory.INSTANCE;
                    break;
                case "Shop":
                    this.factory = ShopFactory.INSTANCE;
                    break;
                case "SuperMarket":
                    this.factory = SuperMarketFactory.INSTANCE;
                    break;
                case "RefugeeCamp":
                    this.factory = RefugeeCampFactory.INSTANCE;
                    break;
                case "DisplacementCamp":
                    this.factory = DisplacementCampFactory.INSTANCE;
                    break;
                case "Factory":
                    this.factory = FactoryFactory.INSTANCE;
                    break;
                default:
                    break;
            }
        }
        this.initLocationFromDataBase();
    }

    public LocationFactory getFactory() {
        return factory;
    }

    public void setFactory(LocationFactory factory) {
        this.factory = factory;
    }

    public List<DayRow> getListDayRow() {
        return listDayRow;
    }

    public void setListDayRow(List<DayRow> listDayRow) {
        this.listDayRow = new ArrayList();
        for (DayRow d : listDayRow) {
            this.listDayRowTmp.add(d);
            if ("Monday".equals(d.getName())) {
                this.mondayRow = d;
                if (d.getUsed() == 1) {
                    this.city.getWeek().MONDAY.getListLocationCategory().put(this.name, this);
                    this.listDayRow.add(d);
                }
            }
            if (d.getName().equals("Tuesday")) {
                this.tuesdayRow = d;
                if (d.getUsed() == 1) {
                    this.city.getWeek().TUESDAY.getListLocationCategory().put(this.name, this);
                    this.listDayRow.add(d);
                }
            }
            if (d.getName().equals("Wednesday")) {
                this.wednesdayRow = d;
                if (d.getUsed() == 1) {
                    this.city.getWeek().WEDNESDAY.getListLocationCategory().put(this.name, this);
                    this.listDayRow.add(d);
                }
            }
            if (d.getName().equals("Thursday")) {
                this.thursdayRow = d;
                if (d.getUsed() == 1) {
                    this.city.getWeek().THURSDAY.getListLocationCategory().put(this.name, this);
                    this.listDayRow.add(d);
                }
            }
            if (d.getName().equals("Friday")) {
                this.fridayRow = d;
                if (d.getUsed() == 1) {
                    this.city.getWeek().FRIDAY.getListLocationCategory().put(this.name, this);
                    this.listDayRow.add(d);
                }
            }
            if (d.getName().equals("Saturday")) {
                this.satursayRow = d;
                if (d.getUsed() == 1) {
                    this.city.getWeek().SATURDAY.getListLocationCategory().put(this.name, this);
                    this.listDayRow.add(d);
                }
            }
            if (d.getName().equals("Sunday")) {
                this.sundayRow = d;
                if (d.getUsed() == 1) {
                    this.city.getWeek().SUNDAY.getListLocationCategory().put(this.name, this);
                    this.listDayRow.add(d);
                }
            }
        }
        for (Location l : this.listLocation) {
            l.setListDayRow(listDayRow);
        }
        this.mondayRow.setPreviousNextDay(this.sundayRow, this.tuesdayRow);
        this.tuesdayRow.setPreviousNextDay(this.mondayRow, this.wednesdayRow);
        this.wednesdayRow.setPreviousNextDay(this.tuesdayRow, this.thursdayRow);
        this.thursdayRow.setPreviousNextDay(this.wednesdayRow, this.fridayRow);
        this.fridayRow.setPreviousNextDay(this.thursdayRow, this.satursayRow);
        this.satursayRow.setPreviousNextDay(this.fridayRow, this.sundayRow);
        this.sundayRow.setPreviousNextDay(this.satursayRow, this.mondayRow);

        this.listDayRowTmp = new ArrayList();
        this.listDayRowTmp.add(this.mondayRow);
        this.listDayRowTmp.add(this.tuesdayRow);
        this.listDayRowTmp.add(this.wednesdayRow);
        this.listDayRowTmp.add(this.thursdayRow);
        this.listDayRowTmp.add(this.fridayRow);
        this.listDayRowTmp.add(this.satursayRow);
        this.listDayRowTmp.add(this.sundayRow);

    }

    public String getKind() {
        return kind;
    }

    public int getFixedLocation() {
        return fixedLocation;
    }

    public DayRow getMondayRow() {
        return mondayRow;
    }

    public void setMondayRow(DayRow mondayRow) {
        this.mondayRow = mondayRow;
    }

    public ModelLocationProperties getModelLocatioProperties() {
        return modelLocatioProperties;
    }

    public void setModelLocatioProperties(ModelLocationProperties modelLocatioProperties) {
        this.modelLocatioProperties = modelLocatioProperties;
    }

    public DayRow getTuesdayRow() {
        return tuesdayRow;
    }

    public void setTuesdayRow(DayRow tuesdayRow) {
        this.tuesdayRow = tuesdayRow;
    }

    public DayRow getWednesdayRow() {
        return wednesdayRow;
    }

    public void setWednesdayRow(DayRow wednesdayRow) {
        this.wednesdayRow = wednesdayRow;
    }

    public DayRow getThursdayRow() {
        return thursdayRow;
    }

    public void setThursdayRow(DayRow thursdayRow) {
        this.thursdayRow = thursdayRow;
    }

    public DayRow getFridayRow() {
        return fridayRow;
    }

    public void setFridayRow(DayRow fridayRow) {
        this.fridayRow = fridayRow;
    }

    public DayRow getSatursayRow() {
        return satursayRow;
    }

    public void setSatursayRow(DayRow satursayRow) {
        this.satursayRow = satursayRow;
    }

    public DayRow getSundayRow() {
        return sundayRow;
    }

    public void setSundayRow(DayRow sundayRow) {
        this.sundayRow = sundayRow;
    }

    public void setFixedLocation(int fixedLocation) {
        this.fixedLocation = fixedLocation;
    }

    public double getPercentageToBeSick() {
        return percentageToBeSick;
    }

    public void setPercentageToBeSick(double percentageToBeSick) {
        this.percentageToBeSick = percentageToBeSick;
        for (Location l : this.getListLocation()) {
            l.setPercentageToBeSick(percentageToBeSick);
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
        for (Location l : this.listLocation) {
            l.setDeleted(true);
        }
    }

    public List<Location> getListLocation() {
        return listLocation;
    }

    public void setListLocation(List<Location> listLocation) {
        this.listLocation = listLocation;
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

    public LocationProperties getLocationProperties() {
        return locationProperties;
    }

    public void setLocationProperties(LocationProperties locationProperties) {
        this.locationProperties = locationProperties;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
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

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public void save() {
        if (deleted) {
            if (!this.isNew) {
                for (Location l : this.listLocation) {
                    l.setDeleted(true);
                    l.save();
                }
                for (DayRow dr : this.listDayRowTmp) {
                    dr.setDeleted(true);
                    dr.save();
                }
                LocationCategoryController.INSTANCE.delete(id);
                return;
            }
        }
        if (this.isNew) {
            this.id = LocationCategoryController.INSTANCE.insert(this);
            this.isNew = false;
            this.saved = true;
        } else {
            if (!this.saved) {
                LocationCategoryController.INSTANCE.update(this);
                this.saved = true;
            } else {

            }
        }
        for (Location l : this.listLocation) {
            l.setLocationCategoryId(this.id);
            l.save();
        }

        for (DayRow d : this.listDayRowTmp) {
            d.setLc(this);
            d.save();
        }
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void initLocation() {
        int q;
        this.listLocation.clear();
        q = this.quantity;
        int loop = 0;
        while (q > 0) {
            loop++;
            if (loop == 1000) {
                this.city.reshapMapTile();
                loop = 0;
                return;
            }
            int ii = MonteCarlo.getNextIntBetween(1, this.factory.getWTile() + 3, this.city.getWidth() / Data.TileWidth);
            int jj = MonteCarlo.getNextIntBetween(1, this.factory.getHTile() + 3, this.city.getHeight() / Data.TileHeight);
            boolean draw = true;
            for (int a = 0; a < factory.getWTile(); a++) {
                for (int b = 0; b < factory.getHTile(); b++) {
                    if ((ii + a) < this.city.getMap().length && (jj + b) < this.city.getMap()[ii + a].length) {
                        if (this.city.getMap()[ii + a][jj + b].getTileType() == TileType.buildingTile && this.city.getMap()[ii + a][jj + b].isDrawable()) {
                        } else {
                            draw = false;
                        }
                    } else {
                        draw = false;
                    }
                }
            }
            if (draw) {
                Location l = factory.creatLocation(" ", this.city.getMap()[ii][jj].getX(), this.city.getMap()[ii][jj].getY(), this.percentageToBeSick, this.city);
                l.setListDayRow(listDayRow);
                this.listLocation.add(l);

                for (int a = 0; a < factory.getWTile(); a++) {
                    for (int b = 0; b < factory.getHTile(); b++) {
                        city.getMap()[ii + a][jj + b].setWalking(false);
                        l.addTile(city.getMap()[ii + a][jj + b]);
                    }
                }
                q--;
                for (int k = 0; k <= factory.getWTile(); k++) {
                    for (int g = 0; g <= factory.getHTile(); g++) {
                        city.getMap()[ii + k - 1][jj + g - 1].setDrawable(false);
                    }
                }
                loop = 0;
            }
        }
    }

    private void initLocationFromDataBase() {
        for (Location l : this.listLocation) {
            l.setListDayRow(listDayRow);

            int ii = l.getX() / (Data.TileWidth + 1);
            int jj = l.getY() / (Data.TileHeight + 1);
            for (int a = 0; a < this.factory.getWTile(); a++) {
                for (int b = 0; b < this.factory.getHTile(); b++) {
                    this.city.getMap()[ii + a][jj + b].setWalking(false);
                    l.addTile(this.city.getMap()[ii + a][jj + b]);
                }
            }
            for (int k = 0; k <= this.factory.getWTile(); k++) {
                for (int g = 0; g <= this.factory.getHTile(); g++) {
                    this.city.getMap()[ii + k - 1][jj + g - 1].setDrawable(false);
                }
            }
        }
    }

    public List<DayRow> getListDayRowTmp() {
        return listDayRowTmp;
    }

    public void setListDayRowTmp(List<DayRow> listDayRowTmp) {
        this.listDayRowTmp = listDayRowTmp;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        LocationCategory lc = (LocationCategory) super.clone();
        lc.listLocation = new ArrayList();
        lc.listDayRow = new ArrayList();
        lc.listDayRowTmp = new ArrayList();
        lc.setMondayRow((DayRow) this.mondayRow.clone(lc));
        lc.setTuesdayRow((DayRow) this.tuesdayRow.clone(lc));
        lc.setWednesdayRow((DayRow) this.wednesdayRow.clone(lc));
        lc.setThursdayRow((DayRow) this.thursdayRow.clone(lc));
        lc.setFridayRow((DayRow) this.fridayRow.clone(lc));
        lc.setSatursayRow((DayRow) this.satursayRow.clone(lc));
        lc.setSundayRow((DayRow) this.sundayRow.clone(lc));

        if (lc.getMondayRow().getUsed() == 1) {
            lc.getListDayRow().add(lc.getMondayRow());
        }
        lc.listDayRowTmp.add(lc.getMondayRow());

        if (lc.getTuesdayRow().getUsed() == 1) {
            lc.getListDayRow().add(lc.getTuesdayRow());
        }
        lc.listDayRowTmp.add(lc.getTuesdayRow());

        if (lc.getWednesdayRow().getUsed() == 1) {
            lc.getListDayRow().add(lc.getWednesdayRow());
        }
        lc.listDayRowTmp.add(lc.getWednesdayRow());

        if (lc.getThursdayRow().getUsed() == 1) {
            lc.getListDayRow().add(lc.getThursdayRow());
        }
        lc.listDayRowTmp.add(lc.getThursdayRow());

        if (lc.getFridayRow().getUsed() == 1) {
            lc.getListDayRow().add(lc.getFridayRow());
        }
        lc.listDayRowTmp.add(lc.getFridayRow());

        if (lc.getSatursayRow().getUsed() == 1) {
            lc.getListDayRow().add(lc.getSatursayRow());
        }
        lc.listDayRowTmp.add(lc.getSatursayRow());

        if (lc.getSundayRow().getUsed() == 1) {
            lc.getListDayRow().add(lc.getSundayRow());
        }
        lc.listDayRowTmp.add(lc.getSundayRow());

        lc.mondayRow.setPreviousNextDay(lc.sundayRow, lc.tuesdayRow);
        lc.tuesdayRow.setPreviousNextDay(lc.mondayRow, lc.wednesdayRow);
        lc.wednesdayRow.setPreviousNextDay(lc.tuesdayRow, lc.thursdayRow);
        lc.thursdayRow.setPreviousNextDay(lc.wednesdayRow, lc.fridayRow);
        lc.fridayRow.setPreviousNextDay(lc.thursdayRow, lc.satursayRow);
        lc.satursayRow.setPreviousNextDay(lc.fridayRow, lc.sundayRow);
        lc.sundayRow.setPreviousNextDay(lc.satursayRow, lc.mondayRow);
        return lc;
    }

    public Object clone(City c) {
        LocationCategory lc = null;
        try {
            lc = (LocationCategory) this.clone();
            lc.locationProperties = null;
            lc.setCity(c);
            for (DayRow dr : lc.getListDayRowTmp()) {
                switch (dr.getName()) {
                    case ("Monday"):
                        if (dr.getUsed() == 1) {
                            lc.getCity().getWeek().MONDAY.getListLocationCategory().put(lc.getKind(), lc);
                        }
                        break;
                    case ("Tuesday"):
                        if (dr.getUsed() == 1) {
                            lc.getCity().getWeek().TUESDAY.getListLocationCategory().put(lc.getKind(), lc);
                        }
                        break;
                    case ("Wednesday"):
                        if (dr.getUsed() == 1) {
                            lc.getCity().getWeek().WEDNESDAY.getListLocationCategory().put(lc.getKind(), lc);
                        }
                        break;
                    case ("Thursday"):
                        if (dr.getUsed() == 1) {
                            lc.getCity().getWeek().THURSDAY.getListLocationCategory().put(lc.getKind(), lc);
                        }
                        break;
                    case ("Friday"):
                        if (dr.getUsed() == 1) {
                            lc.getCity().getWeek().FRIDAY.getListLocationCategory().put(lc.getKind(), lc);
                        }
                        break;
                    case ("Saturday"):
                        if (dr.getUsed() == 1) {
                            lc.getCity().getWeek().SATURDAY.getListLocationCategory().put(lc.getKind(), lc);
                        }
                        break;
                    case ("Sunday"):
                        if (dr.getUsed() == 1) {
                            lc.getCity().getWeek().SUNDAY.getListLocationCategory().put(lc.getKind(), lc);
                        }
                        break;
                }
            }
            for (Location l : this.getListLocation()) {
                Location lNew = (Location) l.clone(c);
                lNew.setListDayRow(lc.getListDayRow());
                lc.listLocation.add(lNew);
            }
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(LocationCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lc;
    }
}
