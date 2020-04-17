/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Graphics;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import models.Server.Data;
import models.Server.MonteCarlo;
import models.location.*;
import models.member.Member;
import models.transportation.Transportation;
import views.CityPanel;
import views.tile.Tile;
import views.tile.TileType;
import static models.location.LocationData.*;

/**
 *
 * @author Joseph
 */
public class City extends UnicastRemoteObject implements ICity {

    private Map<Integer, Member> listMember;
    private Map<Integer, Location> listLocations;
    private Map<Integer, Transportation> listTransportations;
    private Map<Integer, ICity> leftCities;
    private Map<Integer, ICity> rightCities;
    private Map<Integer, ICity> topCities;
    private Map<Integer, ICity> bottomCities;
    private Map<Integer, House> listHouse;
    private Map<Integer, Hospital> listHospital;
    private Map<Integer, School> listSchool;
    private Map<Integer, University> listUniversity;
    private Map<Integer, Church> listChurch;
    private Map<Integer, Mosque> listMosque;
    private Map<Integer, Shop> listShop;
    private Map<Integer, RefugeeCamp> listRefugeeCamp;
    private Map<Integer, DisplacementCamp> listDisplacementCamp;
    private int nbPopulation = 0;
    private int id;
    private int width = 2000, height = 800;
    private int hospital = 0;
    private int school = 0;
    private int university = 0;
    private int church = 0;
    private int mosque = 0;
    private int shop = 0;
    private int house = 0;
    private int refugeeCamp = 0;
    private int displacementCamp = 0;
    private int nbw;
    private int nbh;
    private Tile[][] map;
    private CityPanel cityPanel;
    private int percentageOfsick = 50;

    public City(int width, int height, int hospital, int school, int university, int church,
            int mosque, int shop, int house, int refugeeCamp, int displacementCamp) throws RemoteException {
        Data.initHousePopulationPercentage();
        this.listMember = new HashMap();
        this.listLocations = new HashMap();
        this.listChurch = new HashMap();
        this.listDisplacementCamp = new HashMap();
        this.listHospital = new HashMap();
        this.listHouse = new HashMap();
        this.listMosque = new HashMap();
        this.listSchool = new HashMap();
        this.listUniversity = new HashMap();
        this.listRefugeeCamp = new HashMap();
        this.listShop = new HashMap();
        this.listTransportations = new HashMap();
        this.leftCities = new HashMap();
        this.rightCities = new HashMap();
        this.bottomCities = new HashMap();
        this.topCities = new HashMap();
        this.width = width;
        this.height = height;
        this.hospital = hospital;
        this.school = school;
        this.university = university;
        this.church = church;
        this.mosque = mosque;
        this.shop = shop;
        this.house = house;
        this.refugeeCamp = refugeeCamp;
        this.displacementCamp = displacementCamp;
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

        initHospital();
        initUniversity();
        initSchool();
        initChurch();
        initMosque();
        initDisplacementCamp();
        initRefugeeCamp();
        initShop();
        initHouse();
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

    @Override
    public void draw(Graphics g) throws RemoteException {
        for (int i = 0; i < nbw; i++) {
            for (int j = 0; j < nbh; j++) {
                map[i][j].draw(g);
            }
        }
        for (Entry<Integer, Location> e : listLocations.entrySet()) {
            e.getValue().draw(g);
        }
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
    }

    private void initHospital() {
        while (hospital > 0) {
            int i = MonteCarlo.getNextIntBetween(1, 4, nbw);
            int j = MonteCarlo.getNextIntBetween(1, 4, nbh);
            boolean draw = true;
            for (int a = 0; a < WTILEHOSPITAL; a++) {
                for (int b = 0; b < HTILEHOSPITAL; b++) {
                    if (map[i + a][j + b].getTileType() == TileType.buildingTile && map[i + a][j + a].isDrawable()) {
                        // draw = true;
                    } else {
                        draw = false;
                    }
                }
            }
            if (draw) {
                Hospital h = new Hospital(map[i][j].getX(), map[i][j].getY(), percentageOfsick, this.cityPanel, this);
                this.listLocations.put(listLocations.size(), h);
                this.listHospital.put(listLocations.size(), h);
                for (int a = 0; a < WTILEHOSPITAL; a++) {
                    for (int b = 0; b < HTILEHOSPITAL; b++) {
                        map[i + a][j + b].setWalking(false);
                        h.addTile(map[i + a][j + b]);
                    }
                }
                hospital--;
                for (int k = i - 1; k <= i + WTILEHOSPITAL; k++) {
                    for (int g = j - 1; g <= j + HTILEHOSPITAL; g++) {
                        map[k][g].setDrawable(false);
                    }
                }
            }
        }
    }

    private void initSchool() {
        while (school > 0) {
            int i = MonteCarlo.getNextIntBetween(1, 4, nbw);
            int j = MonteCarlo.getNextIntBetween(1, 4, nbh);
            boolean draw = true;
            for (int a = 0; a < WTILESCHOOL; a++) {
                for (int b = 0; b < HTILESCHOOL; b++) {
                    if (map[i + a][j + b].getTileType() == TileType.buildingTile && map[i + a][j + a].isDrawable()) {
                    } else {
                        draw = false;
                    }
                }
            }
            if (draw) {
                School h = new School(map[i][j].getX(), map[i][j].getY(), percentageOfsick, this.cityPanel, this);
                this.listLocations.put(listLocations.size(), h);
                this.listSchool.put(listLocations.size(), h);
                for (int a = 0; a < WTILESCHOOL; a++) {
                    for (int b = 0; b < HTILESCHOOL; b++) {
                        map[i + a][j + b].setWalking(false);
                        h.addTile(map[i + a][j + b]);
                    }
                }
                school--;
                for (int k = i - 1; k <= i + WTILESCHOOL; k++) {
                    for (int g = j - 1; g <= j + HTILESCHOOL; g++) {
                        map[k][g].setDrawable(false);
                    }
                }
            }
        }
    }

    private void initUniversity() {

        while (university > 0) {
            int i = MonteCarlo.getNextIntBetween(1, 4, nbw);
            int j = MonteCarlo.getNextIntBetween(1, 4, nbh);
            boolean draw = true;
            for (int a = 0; a < WTILEUNIVERSITY; a++) {
                for (int b = 0; b < HTILEUNIVERSITY; b++) {
                    if (map[i + a][j + b].getTileType() == TileType.buildingTile && map[i + a][j + a].isDrawable()) {
                    } else {
                        draw = false;
                    }
                }
            }
            if (draw) {
                University h = new University(map[i][j].getX(), map[i][j].getY(), percentageOfsick, this.cityPanel, this);
                this.listLocations.put(listLocations.size(), h);
                this.listUniversity.put(listLocations.size(), h);
                for (int a = 0; a < WTILEUNIVERSITY; a++) {
                    for (int b = 0; b < HTILEUNIVERSITY; b++) {
                        map[i + a][j + b].setWalking(false);
                        h.addTile(map[i + a][j + b]);
                    }
                }
                university--;
                for (int k = i - 1; k <= i + WTILEUNIVERSITY; k++) {
                    for (int g = j - 1; g <= j + HTILEUNIVERSITY; g++) {
                        map[k][g].setDrawable(false);
                    }
                }
            }
        }
    }

    private void initChurch() {
        while (church > 0) {
            int i = MonteCarlo.getNextIntBetween(1, 4, nbw);
            int j = MonteCarlo.getNextIntBetween(1, 4, nbh);
            boolean draw = true;
            for (int a = 0; a < WTILECHURCH; a++) {
                for (int b = 0; b < HTILECHURCH; b++) {
                    if (map[i + a][j + b].getTileType() == TileType.buildingTile && map[i + a][j + a].isDrawable()) {
                        // draw = true;
                    } else {
                        draw = false;
                    }
                }
            }
            if (draw) {
                Church h = new Church(map[i][j].getX(), map[i][j].getY(), percentageOfsick, this.cityPanel, this);
                this.listLocations.put(listLocations.size(), h);
                this.listChurch.put(listLocations.size(), h);
                for (int a = 0; a < WTILECHURCH; a++) {
                    for (int b = 0; b < HTILECHURCH; b++) {
                        map[i + a][j + b].setWalking(false);
                        h.addTile(map[i + a][j + b]);
                    }
                }
                church--;
                for (int k = i - 1; k <= i + WTILECHURCH; k++) {
                    for (int g = j - 1; g <= j + HTILECHURCH; g++) {
                        map[k][g].setDrawable(false);
                    }
                }
            }
        }
    }

    private void initMosque() {
        while (mosque > 0) {
            int i = MonteCarlo.getNextIntBetween(1, 4, nbw);
            int j = MonteCarlo.getNextIntBetween(1, 4, nbh);
            boolean draw = true;
            for (int a = 0; a < WTILEMOSQUE; a++) {
                for (int b = 0; b < HTILEMOSQUE; b++) {
                    if (map[i + a][j + b].getTileType() == TileType.buildingTile && map[i + a][j + a].isDrawable()) {
                        // draw = true;
                    } else {
                        draw = false;
                    }
                }
            }
            if (draw) {
                Mosque h = new Mosque(map[i][j].getX(), map[i][j].getY(), percentageOfsick, this.cityPanel, this);
                this.listLocations.put(listLocations.size(), h);
                this.listMosque.put(listLocations.size(), h);
                for (int a = 0; a < WTILEMOSQUE; a++) {
                    for (int b = 0; b < HTILEMOSQUE; b++) {
                        map[i + a][j + b].setWalking(false);
                        h.addTile(map[i + a][j + b]);
                    }
                }
                mosque--;
                for (int k = i - 1; k <= i + WTILEMOSQUE; k++) {
                    for (int g = j - 1; g <= j + HTILEMOSQUE; g++) {
                        map[k][g].setDrawable(false);
                    }
                }
            }
        }
    }

    private void initShop() {
        while (shop > 0) {
            int i = MonteCarlo.getNextIntBetween(1, 4, nbw);
            int j = MonteCarlo.getNextIntBetween(1, 4, nbh);
            boolean draw = true;
            for (int a = 0; a < WTILESHOP; a++) {
                for (int b = 0; b < HTILESHOP; b++) {
                    if (map[i + a][j + b].getTileType() == TileType.buildingTile && map[i + a][j + a].isDrawable()) {
                        // draw = true;
                    } else {
                        draw = false;
                    }
                }
            }
            if (draw) {
                Shop h = new Shop(map[i][j].getX(), map[i][j].getY(), percentageOfsick, this.cityPanel, this);
                this.listLocations.put(listLocations.size(), h);
                this.listShop.put(listLocations.size(), h);
                for (int a = 0; a < WTILESHOP; a++) {
                    for (int b = 0; b < HTILESHOP; b++) {
                        map[i + a][j + b].setWalking(false);
                        h.addTile(map[i + a][j + b]);
                    }
                }
                shop--;
                for (int k = i - 1; k <= i + WTILESHOP; k++) {
                    for (int g = j - 1; g <= j + HTILESHOP; g++) {
                        map[k][g].setDrawable(false);
                    }
                }
            }
        }
    }

    private void initRefugeeCamp() {
        while (refugeeCamp > 0) {
            int i = MonteCarlo.getNextIntBetween(1, 4, nbw);
            int j = MonteCarlo.getNextIntBetween(1, 4, nbh);
            boolean draw = true;
            for (int a = 0; a < WTILEREFUGEECAMP; a++) {
                for (int b = 0; b < HTILEREFUGEECAMP; b++) {
                    if (map[i + a][j + b].getTileType() == TileType.buildingTile && map[i + a][j + a].isDrawable()) {
                        // draw = true;
                    } else {
                        draw = false;
                    }
                }
            }
            if (draw) {
                RefugeeCamp h = new RefugeeCamp(map[i][j].getX(), map[i][j].getY(), percentageOfsick, this.cityPanel, this);
                this.listLocations.put(listLocations.size(), h);
                this.listRefugeeCamp.put(listLocations.size(), h);
                for (int a = 0; a < WTILEREFUGEECAMP; a++) {
                    for (int b = 0; b < HTILEREFUGEECAMP; b++) {
                        map[i + a][j + b].setWalking(false);
                        h.addTile(map[i + a][j + b]);
                    }
                }
                refugeeCamp--;
                for (int k = i - 1; k <= i + WTILEREFUGEECAMP; k++) {
                    for (int g = j - 1; g <= j + HTILEREFUGEECAMP; g++) {
                        map[k][g].setDrawable(false);
                    }
                }
            }
        }
    }

    private void initDisplacementCamp() {
        while (displacementCamp > 0) {
            int i = MonteCarlo.getNextIntBetween(1, 4, nbw);
            int j = MonteCarlo.getNextIntBetween(1, 4, nbh);
            boolean draw = true;
            for (int a = 0; a < WTILEDISPLACEMENTCAMP; a++) {
                for (int b = 0; b < HTILEDISPLACEMENTCAMP; b++) {
                    if (map[i + a][j + b].getTileType() == TileType.buildingTile && map[i + a][j + a].isDrawable()) {
                        // draw = true;
                    } else {
                        draw = false;
                    }
                }
            }
            if (draw) {
                DisplacementCamp h = new DisplacementCamp(map[i][j].getX(), map[i][j].getY(), percentageOfsick, this.cityPanel, this);
                this.listLocations.put(listLocations.size(), h);
                this.listDisplacementCamp.put(listLocations.size(), h);
                for (int a = 0; a < WTILEDISPLACEMENTCAMP; a++) {
                    for (int b = 0; b < HTILEDISPLACEMENTCAMP; b++) {
                        map[i + a][j + b].setWalking(false);
                        h.addTile(map[i + a][j + b]);
                    }
                }
                displacementCamp--;
                for (int k = i - 1; k <= i + WTILEDISPLACEMENTCAMP; k++) {
                    for (int g = j - 1; g <= j + HTILEDISPLACEMENTCAMP; g++) {
                        map[k][g].setDrawable(false);
                    }
                }
            }
        }

    }

    private void initHouse() {
        while (house > 0) {
            int i = MonteCarlo.getNextIntBetween(1, 4, nbw);
            int j = MonteCarlo.getNextIntBetween(1, 4, nbh);
            boolean draw = true;
            for (int a = 0; a < WTILEHOUSE; a++) {
                for (int b = 0; b < HTILEHOUSE; b++) {
                    if (map[i + a][j + b].getTileType() == TileType.buildingTile && map[i + a][j + a].isDrawable()) {
                        // draw = true;
                    } else {
                        draw = false;
                    }
                }
            }
            if (draw) {
                House h = new House(map[i][j].getX(), map[i][j].getY(), percentageOfsick, this.cityPanel, this);
                this.listLocations.put(listLocations.size(), h);
                this.listHouse.put(listLocations.size(), h);
                for (int a = 0; a < WTILEHOUSE; a++) {
                    for (int b = 0; b < HTILEHOUSE; b++) {
                        map[i + a][j + b].setWalking(false);
                        h.addTile(map[i + a][j + b]);
                    }
                }
                house--;
                for (int k = i - 1; k <= i + WTILEHOUSE; k++) {
                    for (int g = j - 1; g <= j + HTILEHOUSE; g++) {
                        map[k][g].setDrawable(false);
                    }
                }
            }
        }
    }
}
