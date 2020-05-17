package models.client1;

import controller.locationController.CityController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.location1.*;
import models.member1.Member;
import models.transportation1.Transportation;
import views.tile.Tile;
import views.tile.TileType;
import views1.CityPanel;
import views1.MainFrame;

public class City extends UnicastRemoteObject implements ICity, Runnable {

    private int id;
    private String name;
    private int countryId;
    private int nbPopulation = 0;
    private int width;
    private int height;
    private int isMain;
    private CityPanel cityPanel;

    private int nbw;
    private int nbh;
    private Tile[][] map;

    private Map<Integer, Member> listMember;
    private Map<Integer, Transportation> listTransportations;

    private final Map<Integer, ICity> leftCities;
    private final Map<Integer, ICity> rightCities;
    private final Map<Integer, ICity> topCities;
    private final Map<Integer, ICity> bottomCities;

    private boolean isNew = true;
    private boolean isSaved = false;

    private HumanCityAgeType under4;
    private HumanCityAgeType between4and10;
    private HumanCityAgeType between11and18;
    private HumanCityAgeType between19and27;
    private HumanCityAgeType between28and40;
    private HumanCityAgeType between41and50;
    private HumanCityAgeType between51and60;
    private HumanCityAgeType between61and70;
    private HumanCityAgeType between71and80;
    private HumanCityAgeType above80;

    private List<HumanCityAgeType> listHumanAgeType = new ArrayList();

    private Map<String, LocationCategory> mapLocation;
    private Map<String, LocationCategory> mapLocationDeleted;

    public MainFrame mainFrame;
    private Week week;
    private Thread thread;

    public City(int id, String name, int nbPopulation, int width, int height, int isMain,
            int countryId, List<HumanCityAgeType> list) throws RemoteException {
        this.id = id;
        this.name = name;
        this.nbPopulation = nbPopulation;
        this.width = width;
        this.height = height;
        this.isMain = isMain;
        this.countryId = countryId;
        this.listHumanAgeType = list;

        this.isNew = false;
        this.isSaved = true;

        this.initMapTile();
        this.mapLocation = new HashMap();
        this.mapLocationDeleted = new HashMap();
        this.listMember = new HashMap();
        this.listTransportations = new HashMap();
        this.leftCities = new HashMap();
        this.rightCities = new HashMap();
        this.bottomCities = new HashMap();
        this.topCities = new HashMap();
    }

    public City(String name, int nbPopulation, int width, int height,
            int countryId) throws RemoteException {
        this.name = name;
        this.nbPopulation = nbPopulation;
        this.width = width;
        this.height = height;
        this.isMain = 1;
        this.countryId = countryId;

        this.isNew = true;
        this.isSaved = false;

        this.listHumanAgeType = new ArrayList();
        this.mapLocationDeleted = new HashMap();
        this.initMapTile();
        this.mapLocation = new HashMap();
        this.listMember = new HashMap();
        this.listTransportations = new HashMap();
        this.leftCities = new HashMap();
        this.rightCities = new HashMap();
        this.bottomCities = new HashMap();
        this.topCities = new HashMap();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setListHumanAgeType(List<HumanCityAgeType> listHumanAgeType) {
        this.listHumanAgeType = listHumanAgeType;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getIsMain() {
        return isMain;
    }

    public void setIsMain(int isMain) {
        this.isMain = isMain;
    }

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public boolean isIsSaved() {
        return isSaved;
    }

    public void setIsSaved(boolean isSaved) {
        this.isSaved = isSaved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void initHumanAgeTypePer() {
        this.listHumanAgeType.add(this.under4);
        this.listHumanAgeType.add(this.between4and10);
        this.listHumanAgeType.add(this.between11and18);
        this.listHumanAgeType.add(this.between19and27);
        this.listHumanAgeType.add(this.between28and40);
        this.listHumanAgeType.add(this.between41and50);
        this.listHumanAgeType.add(this.between51and60);
        this.listHumanAgeType.add(this.between61and70);
        this.listHumanAgeType.add(this.between71and80);
        this.listHumanAgeType.add(this.above80);
    }

    public void addLeftCity(City c) {
        this.leftCities.put(leftCities.size(), c);
        c.addRigthCity(this);
    }

    public void addRigthCity(City c) {
        this.rightCities.put(rightCities.size(), c);
        c.addLeftCity(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public void addTopCity(City c) {
        this.topCities.put(topCities.size(), c);
        c.addBottomCity(this);
    }

    public void addBottomCity(City c) {
        this.bottomCities.put(bottomCities.size(), c);
        c.addTopCity(c);
    }

    @Override
    public void notifyHuman(Member m) throws RemoteException {
        this.listMember.put(listMember.size(), m);
    }

    @Override
    public void notifyTransportation(Transportation t) throws RemoteException {
        this.listTransportations.put(listTransportations.size(), t);
        for (Entry<Integer, Member> e : t.getListMember().entrySet()) {
            this.listMember.put(listMember.size(), e.getValue());
        }
    }

    public void initPopulation() {
        this.listMember.clear();
        for (Entry<String, LocationCategory> e : mapLocation.entrySet()) {
            for (Location l : e.getValue().getListLocation()) {
                l.initPopulation();
            }
        }
    }

    public Map<String, LocationCategory> getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(Map<String, LocationCategory> mapLocation) {
        this.mapLocation = mapLocation;
    }

    @Override
    public int getPopulation() throws RemoteException {
        return this.nbPopulation;
    }

    public int getNbPopulation() {
        return nbPopulation;
    }

    public void setNbPopulation(int nbPopulation) {
        this.nbPopulation = nbPopulation;
    }

    @Override
    public Map<Integer, Location> getListLocations() throws RemoteException {
        return null;
    }

    public Map<Integer, Member> getListMember() {
        return listMember;
    }

    public void setListMember(Map<Integer, Member> listMember) {
        this.listMember = listMember;
    }

    public Map<Integer, Transportation> getListTransportations() {
        return listTransportations;
    }

    public void setListTransportations(Map<Integer, Transportation> listTransportations) {
        this.listTransportations = listTransportations;
    }

    public void addLocation(String name, LocationCategory lc) {
        mapLocation.put(name, lc);
    }

    public void removeLocation(String name) {
        for (Entry<String, LocationCategory> e : this.mapLocation.entrySet()) {
            if (e.getValue().getName().equals(name)) {
                e.getValue().setDeleted(true);
                this.mapLocation.remove(e.getKey());
                this.mapLocationDeleted.put(e.getKey(), e.getValue());
                break;
            }
        }
    }

    @Override
    public Location getLocation(String kind) throws RemoteException {
        List<String> list = new ArrayList();
        if (kind.equals("Work")) {
            for (Entry<String, LocationCategory> e : mapLocation.entrySet()) {
                String[] tab = e.getKey().split(" ");
                if (!tab[1].equals("House")) {
                    list.add(e.getKey());
                }
            }
            if (list.size() > 0) {
                while (list.size() > 0) {
                    int index = MonteCarlo.getNextInt(list.size());
                    String name = list.get(index);
                    if (mapLocation.get(name).getListLocation().size() > 0) {
                        int in = MonteCarlo.getNextInt(mapLocation.get(name).getListLocation().size());
                        return mapLocation.get(name).getListLocation().get(in);
                    } else {
                        list.remove(name);
                    }
                }
            }
        }
        for (Entry<String, LocationCategory> e : mapLocation.entrySet()) {
            String[] tab = e.getKey().split(" ");
            if (tab[1].equals(kind)) {
                list.add(e.getKey());
            }
        }
        if (list.size() > 0) {
            while (list.size() > 0) {
                int index = MonteCarlo.getNextInt(list.size());
                String name = list.get(index);
                if (mapLocation.get(name).getListLocation().size() > 0) {
                    int in = MonteCarlo.getNextInt(mapLocation.get(name).getListLocation().size());
                    System.out.println("location returned");
                    return mapLocation.get(name).getListLocation().get(in);
                } else {
                    list.remove(name);
                }
            }
        }

        return null;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public void start() {
        this.thread.start();
    }

    public void pause() {
        this.thread.suspend();
    }

    public void resume() {
        this.thread.resume();
    }

    public HumanCityAgeType getUnder4() {
        return under4;
    }

    public void setUnder4(HumanCityAgeType under4) {
        this.under4 = under4;
    }

    public HumanCityAgeType getBetween4and10() {
        return between4and10;
    }

    public void setBetween4and10(HumanCityAgeType between4and10) {
        this.between4and10 = between4and10;
    }

    public HumanCityAgeType getBetween11and18() {
        return between11and18;
    }

    public void setBetween11and18(HumanCityAgeType between11and18) {
        this.between11and18 = between11and18;
    }

    public HumanCityAgeType getBetween19and27() {
        return between19and27;
    }

    public void setBetween19and27(HumanCityAgeType between19and27) {
        this.between19and27 = between19and27;
    }

    public HumanCityAgeType getBetween28and40() {
        return between28and40;
    }

    public void setBetween28and40(HumanCityAgeType between28and40) {
        this.between28and40 = between28and40;
    }

    public HumanCityAgeType getBetween41and50() {
        return between41and50;
    }

    public void setBetween41and50(HumanCityAgeType between41and50) {
        this.between41and50 = between41and50;
    }

    public HumanCityAgeType getBetween51and60() {
        return between51and60;
    }

    public void setBetween51and60(HumanCityAgeType between51and60) {
        this.between51and60 = between51and60;
    }

    public HumanCityAgeType getBetween61and70() {
        return between61and70;
    }

    public void setBetween61and70(HumanCityAgeType between61and70) {
        this.between61and70 = between61and70;
    }

    public HumanCityAgeType getBetween71and80() {
        return between71and80;
    }

    public void setBetween71and80(HumanCityAgeType between71and80) {
        this.between71and80 = between71and80;
    }

    public HumanCityAgeType getAbove80() {
        return above80;
    }

    public void setAbove80(HumanCityAgeType above80) {
        this.above80 = above80;
    }

    public Tile[][] getMap() {
        return map;
    }

    public int getNbw() {
        return nbw;
    }

    public void setNbw(int nbw) {
        this.nbw = nbw;
    }

    public int getNbh() {
        return nbh;
    }

    public void setNbh(int nbh) {
        this.nbh = nbh;
    }

    public Tile getTile(int x, int y) {
        int xi = x / Data.TileWidth;
        int yi = y / Data.TileHeight;
        return this.map[xi][yi];
    }

    public void initMapTile() {
        System.out.println("mapTile:");
        System.out.println("citywidth=" + this.width);
        System.out.println("cityheigth=" + this.height);
        this.nbw = this.getWidth() / (Data.TileWidth + 1);
        System.out.println("nbw=" + this.nbw);
        int dw = this.getWidth() % (Data.TileWidth + 1);
        System.out.println("dw=" + dw);
        this.setWidth(this.getWidth() - dw);
        this.nbh = this.getHeight() / (Data.TileHeight + 1);
        System.out.println("nbh=" + nbh);
        int dh = this.getHeight() % (Data.TileHeight + 1);
        System.out.println("dh=" + dh);
        this.setHeight(this.getHeight() - dh);
        map = new Tile[nbw][nbh];
        for (int i = 0; i < nbw; i++) {
            for (int j = 0; j < nbh; j++) {
                map[i][j] = new Tile(i * (Data.TileWidth + 1), j * (Data.TileHeight + 1), TileType.buildingTile, this.cityPanel);
                if (i > 0) {
                    map[i][j].setTopTile(map[i - 1][j]);
                }
                if (j > 0) {
                    map[i][j].setLeftTile(map[i][j - 1]);
                }
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.thread.sleep(60);
                week.changeTime();
                mainFrame.updateTime(week);
                for (Entry<Integer, Member> e : listMember.entrySet()) {
                    e.getValue().move();

                }
                //print();
                this.mainFrame.getCurrentMap().repaint();
                this.mainFrame.setVisible(true);
            } catch (InterruptedException ex) {
                Logger.getLogger(City.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void save() {
        if (isNew) {
            this.id = CityController.INSTANCE.insert(this);
            this.isNew = false;
            this.isSaved = true;
        } else {
            CityController.INSTANCE.update(this);
            this.isSaved = true;
        }
        for (Entry<String, LocationCategory> e : this.mapLocation.entrySet()) {
            e.getValue().setCityId(this.id);
            e.getValue().save();
        }
        for (Entry<String, LocationCategory> e : this.mapLocationDeleted.entrySet()) {
            e.getValue().setCityId(this.id);
            e.getValue().save();
        }
    }
}
