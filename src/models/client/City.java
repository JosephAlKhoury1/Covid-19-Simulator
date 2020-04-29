/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.client;

import java.awt.Graphics;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.location.*;
import models.member.Member;
import models.transportation.Transportation;
import views.CityPanel;
import views.MainFrame;
import views.tile.Tile;
import views.tile.TileType;

public class City extends UnicastRemoteObject implements ICity, Runnable {

    private Map<Integer, Member> listMember;
    private Map<Integer, Location> listLocations;
    private Map<Integer, Transportation> listTransportations;
    private final Map<Integer, ICity> leftCities;
    private final Map<Integer, ICity> rightCities;
    private final Map<Integer, ICity> topCities;
    private final Map<Integer, ICity> bottomCities;
    private Map<Integer, House> listHouse;
    private List<Hospital> listHospital;
    private List<School> listSchool;
    private List<University> listUniversity;
    private List<Church> listChurch;
    private List<Mosque> listMosque;
    private List<Shop> listShop;
    private List<RefugeeCamp> listRefugeeCamp;
    private List<DisplacementCamp> listDisplacementCamp;

    private Map<String, List<Location>> mapLocation;

    private final Map<Integer, Member> healthyMembers = new HashMap();
    private final Map<Integer, Member> sickMembers = new HashMap();
    private final Map<Integer, Member> recoveryMembers = new HashMap();
    private final Map<Integer, Member> deathMembers = new HashMap();

    private int nbPopulation = 0;
    private int id;
    private int width = 2000, height = 800;
    private int nbw;
    private int nbh;
    private Tile[][] map;
    public CityPanel cityPanel;
    public MainFrame mainFrame;
    private int percentageOfsick = 50;
    private Week week;

    private Thread thread;

    public City(MainFrame mainFrame) throws RemoteException {
        this.thread = new Thread(this);
        mainFrame.setCity1(this);
        this.mainFrame = mainFrame;
        this.week = new Week(Day.monday, 0, 0);
        this.mapLocation = new HashMap();
        this.listMember = new HashMap();
        this.listLocations = new HashMap();
        this.listChurch = new ArrayList();
        this.listDisplacementCamp = new ArrayList();
        this.listHospital = new ArrayList();
        this.listHouse = new HashMap();
        this.listMosque = new ArrayList();
        this.listSchool = new ArrayList();
        this.listUniversity = new ArrayList();
        this.listRefugeeCamp = new ArrayList();
        this.listShop = new ArrayList();
        this.listTransportations = new HashMap();
        this.leftCities = new HashMap();
        this.rightCities = new HashMap();
        this.bottomCities = new HashMap();
        this.topCities = new HashMap();
    }

    public void addLeftCity(City c) {
        this.leftCities.put(leftCities.size(), c);
        c.addRigthCity(this);
    }

    public void addRigthCity(City c) {
        this.rightCities.put(rightCities.size(), c);
        c.addLeftCity(this);
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

    public int getId() {
        return this.id;
    }

    public void initPopulation() {
        for (Entry<String, List<Location>> e : mapLocation.entrySet()) {
            for (Location l : e.getValue()) {
                l.initPopulation();
            }
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < nbw; i++) {
            for (int j = 0; j < nbh; j++) {
                map[i][j].draw(g);
            }
        }
        for (Entry<String, List<Location>> e : mapLocation.entrySet()) {
            for (Location l : e.getValue()) {
                l.draw(g);
            }
        }
        for (Entry<Integer, Location> e : listLocations.entrySet()) {
            e.getValue().draw(g);
        }
        for (Entry<Integer, Member> e : listMember.entrySet()) {
            e.getValue().draw(g);
        }
    }

    public Map<String, List<Location>> getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(Map<String, List<Location>> mapLocation) {
        this.mapLocation = mapLocation;
    }

    @Override
    public int getPopulation() throws RemoteException {
        return this.nbPopulation;
    }

    public Tile[][] getMap() {
        return this.map;
    }

    public int getNbPopulation() {
        return nbPopulation;
    }

    public void setNbPopulation(int nbPopulation) {
        this.nbPopulation = nbPopulation;
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

    @Override
    public Map<Integer, Location> getListLocations() throws RemoteException {
        return listLocations;
    }

    public void setListLocations(Map<Integer, Location> listLocations) {
        this.listLocations = listLocations;
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

    public CityPanel getCityPanel() {
        return cityPanel;
    }

    public void setCityPanel(CityPanel cityPanel) {
        this.cityPanel = cityPanel;
        this.width = cityPanel.getWidth();
        this.height = cityPanel.getHeight();
        nbw = width / (Data.TileWidth + 1);
        int dw = width % (Data.TileWidth + 1);
        width -= dw;
        nbh = height / (Data.TileHeight + 1);
        int dh = height % (Data.TileHeight + 1);
        height -= dh;
        map = new Tile[nbw][nbh];
        for (int i = 0; i < nbw; i++) {
            for (int j = 0; j < nbh; j++) {
                map[i][j] = new Tile(i * (Data.TileWidth + 1), j * (Data.TileHeight + 1), TileType.buildingTile, this.cityPanel);
            }
        }
    }

    public void addLocation(String name, List<Location> listLocation) {
        mapLocation.put(name, listLocation);
    }

    @Override
    public Location getLocation(String kind) throws RemoteException {
        List<String> list = new ArrayList();
        for (Entry<String, List<Location>> e : mapLocation.entrySet()) {
            String[] tab = e.getKey().split(" ");
            if (tab[1].equals(kind)) {
                list.add(e.getKey());
            }
        }
        if (list.size() > 0) {
            while (list.size() > 0) {
                int index = MonteCarlo.getNextInt(list.size());
                String name = list.get(index);
                if (mapLocation.get(name).size() > 0) {
                    int in = MonteCarlo.getNextInt(mapLocation.get(name).size());
                    return mapLocation.get(name).get(in);
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

    @Override
    public void run() {
        while (true) {
            try {
                this.thread.sleep(50);
                week.changeTime();
                mainFrame.updateTime(week);
            } catch (InterruptedException ex) {
                Logger.getLogger(City.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
