package models.location1;

import controller.locationController.LocationCategoryController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.client1.City;
import models.client1.Data;
import models.client1.Day;
import models.client1.MonteCarlo;
import models.locationFactories1.*;
import views.tile.TileType;

public class LocationCategory implements Cloneable {

    private int id;
    private String name;
    private int cityId;
    private String kind;
    private List<Location> listLocation;
    private double percentageToBeSick = 0.0;
    private int quantity;
    private int openTime, closeTime;
    private LocationFactory factory;
    private City city;
    private List<Day> listDay = new ArrayList();
    private String days = "";
    private int fixedLocation;

    private boolean isNew;
    private boolean saved;
    private boolean deleted = false;

    public LocationCategory(String name, String kind, double percentage, int quantity, String days, int openTime,
            int closeTime, int fixedLocation, City city) {
        this.name = name;
        this.listLocation = new ArrayList();
        this.kind = kind;
        this.percentageToBeSick = percentage;
        this.quantity = quantity;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.city = city;
        this.fixedLocation = fixedLocation;
        this.isNew = true;
        this.saved = false;
        this.listDay = new ArrayList();
        this.days = days;
        String[] tab = days.split(" ");
        for (String s : tab) {
            switch (s) {
                case "Monday":
                    this.listDay.add(city.getWeek().getMONDAY());
                    this.city.getWeek().getMONDAY().getListLocationCategory().put(this.name, this);
                    break;
                case "Tuesday":
                    this.listDay.add(city.getWeek().getTUESDAY());
                    this.city.getWeek().getTUESDAY().getListLocationCategory().put(this.name, this);
                    break;
                case "Wednesday":
                    this.listDay.add(city.getWeek().getWEDNESDAY());
                    this.city.getWeek().getWEDNESDAY().getListLocationCategory().put(this.name, this);
                    break;
                case "Thursday":
                    this.listDay.add(city.getWeek().getTHURSDAY());
                    this.city.getWeek().getTHURSDAY().getListLocationCategory().put(this.name, this);
                    break;
                case "Friday":
                    this.listDay.add(city.getWeek().getFRIDAY());
                    this.city.getWeek().getFRIDAY().getListLocationCategory().put(this.name, this);
                    break;
                case "Saturday":
                    this.listDay.add(city.getWeek().getSATURDAY());
                    this.city.getWeek().getSATURDAY().getListLocationCategory().put(this.name, this);
                    break;
                case "Sunday":
                    this.listDay.add(city.getWeek().getSUNDAY());
                    this.city.getWeek().getSUNDAY().getListLocationCategory().put(this.name, this);
                    break;
                default:
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

    public LocationCategory(int id, String name, String kind, double percentage, String days, int quantity,
            int openTime, int closeTime, int fixedLocation, City city, List<Location> list) {
        this.id = id;
        this.name = name;
        this.cityId = city.getId();
        this.kind = kind;
        this.city = city;
        this.percentageToBeSick = percentage;
        this.fixedLocation = fixedLocation;
        this.quantity = quantity;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.listLocation = list;
        this.days = days;
        this.isNew = false;
        this.saved = true;
        this.listDay = new ArrayList();
        String[] tab = days.split(" ");
        for (String s : tab) {
            switch (s) {
                case "Monday":
                    this.listDay.add(city.getWeek().getMONDAY());
                    this.city.getWeek().getMONDAY().getListLocationCategory().put(this.name, this);
                    break;
                case "Tuesday":
                    this.listDay.add(city.getWeek().getTUESDAY());
                    this.city.getWeek().getTUESDAY().getListLocationCategory().put(this.name, this);
                    break;
                case "Wednesday":
                    this.listDay.add(city.getWeek().getWEDNESDAY());
                    this.city.getWeek().getWEDNESDAY().getListLocationCategory().put(this.name, this);
                    break;
                case "Thursday":
                    this.listDay.add(city.getWeek().getTHURSDAY());
                    this.city.getWeek().getTHURSDAY().getListLocationCategory().put(this.name, this);
                    break;
                case "Friday":
                    this.listDay.add(city.getWeek().getFRIDAY());
                    this.city.getWeek().getFRIDAY().getListLocationCategory().put(this.name, this);
                    break;
                case "Saturday":
                    this.listDay.add(city.getWeek().getSATURDAY());
                    this.city.getWeek().getSATURDAY().getListLocationCategory().put(this.name, this);
                    break;
                case "Sunday":
                    this.listDay.add(city.getWeek().getSUNDAY());
                    this.city.getWeek().getSUNDAY().getListLocationCategory().put(this.name, this);
                    break;
                default:
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
        this.initLocationFromDataBase();
    }

    public LocationFactory getFactory() {
        return factory;
    }

    public void setFactory(LocationFactory factory) {
        this.factory = factory;
    }

    public String getKind() {
        return kind;
    }

    public int getFixedLocation() {
        return fixedLocation;
    }

    public void setFixedLocation(int fixedLocation) {
        this.fixedLocation = fixedLocation;
    }

    public int getOpenTime() {
        return openTime;
    }

    public void setOpenTime(int openTime) {
        this.openTime = openTime;
        for (Location l : this.listLocation) {
            l.setOpenTime(openTime);
            l.setSaved(false);
        }
        this.setSaved(false);
        this.city.setIsSaved(false);
        this.city.getMainFrame().setCitySavedButtonEnable();
    }

    public void setOpenTimeModel(int openTime) {
        this.openTime = openTime;
        for (Location l : this.listLocation) {
            l.setOpenTime(openTime);
        }
    }

    public int getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(int closeTime) {
        this.closeTime = closeTime;
        for (Location l : this.listLocation) {
            l.setCloseTime(closeTime);
            l.setSaved(false);
        }
        this.setSaved(false);
        this.city.setIsSaved(false);
        this.city.getMainFrame().setCitySavedButtonEnable();
    }

    public void setCloseTimeModel(int closeTime) {
        this.closeTime = closeTime;
        for (Location l : this.listLocation) {
            l.setCloseTime(closeTime);
        }
    }

    public double getPercentageToBeSick() {
        return percentageToBeSick;
    }

    public void setPercentageToBeSick(double percentageToBeSick) {
        this.percentageToBeSick = percentageToBeSick;
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
            for (Location l : this.listLocation) {
                l.save();
            }
            LocationCategoryController.INSTANCE.delete(id);
            return;
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
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public void removeDay(Day d) {
        this.listDay.remove(d);
        for (Location l : this.listLocation) {
            l.removeDay(d);
        }
        this.days = "";
        for (Day dd : this.listDay) {
            days += dd.getDay().getName() + " ";
        }
        this.city.setIsSaved(false);
        this.setSaved(false);
        this.city.getMainFrame().setCitySavedButtonEnable();
    }

    public void removeDayModel(Day d) {
        this.listDay.remove(d);
        for (Location l : this.listLocation) {
            l.removeDay(d);
        }
        this.days = "";
        for (Day dd : this.listDay) {
            days += dd.getDay().getName() + " ";
        }
    }

    public void addDay(Day d) {
        this.listDay.add(d);
        for (Location l : this.listLocation) {
            l.addDay(d);
        }
        this.days = "";
        for (Day dd : this.listDay) {
            days += dd.getDay().getName() + " ";
        }
        this.city.setIsSaved(false);
        this.setSaved(false);
        this.city.getMainFrame().setCitySavedButtonEnable();
    }

    public void addDayModel(Day d) {
        this.listDay.add(d);
        for (Location l : this.listLocation) {
            l.addDay(d);
        }
        this.days = "";
        for (Day dd : this.listDay) {
            days += dd.getDay().getName() + " ";
        }
    }

    private void initLocation() {
        int q;
        this.listLocation.clear();
        q = this.quantity;
        while (q > 0) {
            int ii = MonteCarlo.getNextIntBetween(1, this.factory.getWTile() + 3, this.city.getWidth() / Data.TileWidth);
            int jj = MonteCarlo.getNextIntBetween(1, this.factory.getHTile() + 3, this.city.getHeight() / Data.TileHeight);
            boolean draw = true;
            for (int a = 0; a < factory.getWTile(); a++) {
                for (int b = 0; b < factory.getHTile(); b++) {
                    if (this.city.getMap()[ii + a][jj + b].getTileType() == TileType.buildingTile && this.city.getMap()[ii + a][jj + b].isDrawable()) {
                    } else {
                        draw = false;
                    }
                }
            }
            if (draw) {
                Location l = factory.creatLocation(" ", this.city.getMap()[ii][jj].getX(), this.city.getMap()[ii][jj].getY(), this.percentageToBeSick, this.fixedLocation, this.openTime, this.closeTime, this.days, this.city);
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
            }
        }
    }

    private void initLocationFromDataBase() {
        for (Location l : this.listLocation) {
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

    public List<Day> getListDay() {
        return listDay;
    }

    public void setListDay(List<Day> listDay) {
        this.listDay = listDay;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        LocationCategory lc = (LocationCategory) super.clone();
        lc.listLocation = new ArrayList();
        lc.listDay = new ArrayList();
        return lc;
    }

    public Object clone(City c) {
        LocationCategory lc = null;
        try {
            lc = (LocationCategory) this.clone();
            lc.setCity(c);
            String[] tab = this.days.split(" ");
            for (String s : tab) {
                switch (s) {
                    case "Monday":
                        c.getWeek().getMONDAY().getListLocationCategory().put(lc.getName(), lc);
                        break;
                    case "Tuesday":
                        c.getWeek().getTUESDAY().getListLocationCategory().put(lc.getName(), lc);
                        break;
                    case "Wednesday":
                        c.getWeek().getWEDNESDAY().getListLocationCategory().put(lc.getName(), lc);
                        break;
                    case "Thursday":
                        c.getWeek().getTHURSDAY().getListLocationCategory().put(lc.getName(), lc);
                        break;
                    case "Friday":
                        c.getWeek().getFRIDAY().getListLocationCategory().put(lc.getName(), lc);
                        break;
                    case "Saturday":
                        c.getWeek().getSATURDAY().getListLocationCategory().put(lc.getName(), lc);
                        break;
                    case "Sunday":
                        c.getWeek().getSUNDAY().getListLocationCategory().put(lc.getName(), lc);
                        break;
                    default:
                        break;
                }
            }
            for (Location l : this.getListLocation()) {
                lc.listLocation.add((Location) l.clone(c));
            }
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(LocationCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lc;
    }
}
