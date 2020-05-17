package models.location1;

import controller.locationController.LocationCategoryController;
import java.util.ArrayList;
import java.util.List;
import models.client1.City;
import models.client1.Data;
import models.client1.Day;
import models.client1.MonteCarlo;
import models.locationFactories1.*;
import views.tile.TileType;

public class LocationCategory {

    private int id;
    private String name;
    private int cityId;
    private String kind;
    private List<Location> listLocation;
    private double percentageToBeSick;
    private int quantity;
    private double openTime, closeTime;
    private LocationFactory factory;
    private City city;
    private List<Day> listDay = new ArrayList();

    private boolean isNew;
    private boolean saved;
    private boolean deleted = false;

    public LocationCategory(String name, String kind, double percentage, int quantity, double openTime,
            double closeTime, List<Location> listLocation) {
        this.name = name;
        this.listLocation = listLocation;
        this.kind = kind;
        this.percentageToBeSick = percentage;
        this.quantity = quantity;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.isNew = true;
        this.saved = false;
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
                default:
                    break;
            }
        }
    }

    public LocationCategory(String name, String kind, double percentage, int quantity, double openTime,
            double closeTime, City city) {
        this.name = name;
        this.listLocation = new ArrayList();
        this.kind = kind;
        this.percentageToBeSick = percentage;
        this.quantity = quantity;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.city = city;
        this.isNew = true;
        this.saved = false;
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
                default:
                    break;
            }
        }
        this.initLocation();
    }

    public LocationCategory(int id, String name, String kind, double percentage, int quantity,
            double openTime, double closeTime, City city, List<Location> list) {
        this.id = id;
        this.name = name;
        this.cityId = city.getId();
        this.kind = kind;
        this.city = city;
        this.percentageToBeSick = percentage;
        this.quantity = quantity;
        this.openTime = openTime;
        this.closeTime = closeTime;
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

    public double getOpenTime() {
        return openTime;
    }

    public void setOpenTime(double openTime) {
        this.openTime = openTime;
    }

    public double getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(double closeTime) {
        this.closeTime = closeTime;
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
            System.out.println("indelete location category");
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

    public void initLocation() {
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
                Location l = factory.creatLocation(" ", this.city.getMap()[ii][jj].getX(), this.city.getMap()[ii][jj].getY(), this.percentageToBeSick, this.openTime, this.closeTime);
                this.listLocation.add(l);
                l.setCity(this.city);
                for (Day d : listDay) {
                    l.addDay(d);
                }
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

    public void initLocationFromDataBase() {
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
}
