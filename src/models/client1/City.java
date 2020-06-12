package models.client1;

import controller.controllers.LocationToGoController;
import controller.locationController.CityController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import models.location1.*;
import models.member1.Member;
import models.model.HumanAgeName;
import models.model.ReligionName;
import models.transportation1.Transportation;
import tools.FileUtilities;
import views.tile.Tile;
import views.tile.TileType;
import views1.CityPanel;
import views1.MainFrame;
import views1.Maps;

public class City extends UnicastRemoteObject implements ICity, Runnable, Cloneable {

    private int id;
    private String name;
    private int countryId;
    private int nbPopulation = 0;
    private int width;
    private int height;
    private int isMain;
    private CityPanel cityPanel;
    private MainFrame mainFrame;
    private Maps currentMap;

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

    private List<HumanCityAgeType> listHumanAgeType;
    private List<HumanCityAgeType> listHumanAgeTypeDeleted;

    private List<ReligionType> listrelReligionTypes;
    private List<ReligionType> listReligionDeleted;
    private List<ReligionType> listReligionAdd;

    private List<HousePopulation> listHousePopulations;
    private List<HousePopulation> listHousePopulationsDeleted;

    private List<SexeType> listSexeType;
    private List<SexeType> listSexeTypeDeleted;

    private Map<String, LocationCategory> mapLocation;
    private Map<String, LocationCategory> mapLocationDeleted;

    private List<LocationToGo> listLocationToGo;
    private List<LocationToGo> listLocationAdd;
    private List<LocationToGo> listLocationDeleted;

    private Week week;
    private Day currentDay;
    private Thread thread;
    private JMenuItem mapMenu, runMenu, pauseMenu, populationMenu;
    private JSeparator separator, runSeparator, pauseSeparator, separatorPopulation;

    public City(int id, String name, int nbPopulation, int width, int height, int isMain,
            int countryId, List<HumanCityAgeType> list, List<ReligionType> listR, List<HousePopulation> listHp, List<SexeType> listSt) throws RemoteException {
        this.thread = new Thread(this);
        this.week = new Week(this);
        this.currentDay = this.week.MONDAY;
        this.id = id;
        this.name = name;
        this.nbPopulation = nbPopulation;
        this.width = width;
        this.height = height;
        this.isMain = isMain;
        this.countryId = countryId;
        this.listLocationAdd = new ArrayList();
        this.listLocationDeleted = new ArrayList();

        this.mapMenu = new JMenuItem(this.name + " Map");
        this.mapMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateMapLocation();
                mapMenu.setEnabled(false);
            }
        });

        this.separator = new JSeparator(SwingConstants.HORIZONTAL);

        this.populationMenu = new JMenuItem(this.name + " Map");
        this.populationMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initPopulation();
                populationMenu.setEnabled(false);
            }
        });
        this.separatorPopulation = new JSeparator(SwingConstants.HORIZONTAL);

        this.runMenu = new JMenuItem("Run " + this.name);
        this.runMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });

        this.pauseMenu = new JMenuItem("Pause " + this.name);
        this.pauseMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pause();
            }
        });

        this.runSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        this.pauseSeparator = new JSeparator(SwingConstants.HORIZONTAL);

        this.listHumanAgeType = list;
        this.listHumanAgeTypeDeleted = new ArrayList();

        this.listrelReligionTypes = listR;
        this.listReligionDeleted = new ArrayList();
        this.listReligionAdd = new ArrayList();

        this.listHousePopulations = listHp;
        this.listHousePopulationsDeleted = new ArrayList();

        this.listSexeType = listSt;
        this.listSexeTypeDeleted = new ArrayList();

        Data.initData(this.listrelReligionTypes, this.listHousePopulations, this.listHumanAgeType, this.listSexeType);

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

        this.listLocationToGo = LocationToGoController.INSTANCE.selectAllCity(this.id);
        this.listHumanAgeType.forEach((h) -> {
            h.setCity(this);
        });
        this.listrelReligionTypes.forEach((rt) -> {
            rt.setCity(this);
        });
        this.listHousePopulations.forEach((hp) -> {
            hp.setCity(this);
        });

        this.listSexeType.forEach((st) -> {
            st.setCity(this);
        });

    }

    public City(String name, int nbPopulation, int width, int height,
            int countryId, MainFrame frame) throws RemoteException {
        this.thread = new Thread(this);
        this.week = new Week(this);
        this.currentDay = this.week.MONDAY;
        this.name = name;
        this.nbPopulation = nbPopulation;
        this.width = width;
        this.height = height;
        this.isMain = 1;
        this.mainFrame = frame;
        this.countryId = countryId;

        this.listLocationAdd = new ArrayList();
        this.listLocationDeleted = new ArrayList();

        this.isNew = true;
        this.isSaved = false;

        this.listHumanAgeType = new ArrayList();
        this.listHumanAgeTypeDeleted = new ArrayList();

        for (HumanAgeName han : this.mainFrame.getListHumanAgeName()) {
            this.listHumanAgeType.add(new HumanCityAgeType(han.getName(), han.getMinAge(), han.getMaxAge(), 0.0, 0, 0.0, this));
        }
        this.listLocationToGo = new ArrayList();
        for (String s : Data.tabLocation) {
            this.listLocationToGo.add(new LocationToGo(s, this));
        }
        this.listrelReligionTypes = new ArrayList();
        this.listReligionDeleted = new ArrayList();
        this.listReligionAdd = new ArrayList();

        this.mapMenu = new JMenuItem(this.name + " Map");
        this.mapMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateMapLocation();
                mapMenu.setEnabled(false);
            }
        });
        this.separator = new JSeparator(SwingConstants.HORIZONTAL);

        this.populationMenu = new JMenuItem(this.name + " Map");
        this.populationMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initPopulation();
                populationMenu.setEnabled(false);
            }
        });
        this.separatorPopulation = new JSeparator(SwingConstants.HORIZONTAL);

        this.runMenu = new JMenuItem("Run " + this.name);
        this.runMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                run();
            }
        });

        this.pauseMenu = new JMenuItem("Pause " + this.name);
        this.pauseMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pause();
            }
        });

        this.runSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        this.pauseSeparator = new JSeparator(SwingConstants.HORIZONTAL);

        for (ReligionName rn : this.mainFrame.getListReligionName()) {
            this.listrelReligionTypes.add(new ReligionType(rn.getName(), 100 / this.mainFrame.getListReligionName().size(), rn.getPrayLocation(), this));
        }

        this.listHousePopulations = new ArrayList();
        this.listHousePopulationsDeleted = new ArrayList();
        this.listHousePopulations.add(new HousePopulation(0, 10.0, this));
        this.listHousePopulations.add(new HousePopulation(1, 10.0, this));
        this.listHousePopulations.add(new HousePopulation(2, 10.0, this));
        this.listHousePopulations.add(new HousePopulation(3, 10.0, this));
        this.listHousePopulations.add(new HousePopulation(4, 10.0, this));
        this.listHousePopulations.add(new HousePopulation(5, 10.0, this));
        this.listHousePopulations.add(new HousePopulation(6, 10.0, this));
        this.listHousePopulations.add(new HousePopulation(7, 10.0, this));
        this.listHousePopulations.add(new HousePopulation(8, 10.0, this));

        this.listSexeType = new ArrayList();
        this.listSexeTypeDeleted = new ArrayList();

        this.listSexeType.add(new SexeType("Male", 10.0, this));
        this.listSexeType.add(new SexeType("Female", 10.0, this));

        this.mapLocationDeleted = new HashMap();
        this.initMapTile();
        this.mapLocation = new HashMap();
        this.listMember = new HashMap();
        this.listTransportations = new HashMap();
        this.leftCities = new HashMap();
        this.rightCities = new HashMap();
        this.bottomCities = new HashMap();
        this.topCities = new HashMap();

        Data.initData(this.listrelReligionTypes, this.listHousePopulations, this.listHumanAgeType, this.listSexeType);
    }

    public List<HumanCityAgeType> getListHumanAgeType() {
        return listHumanAgeType;
    }

    public void generateMapLocation() {
        this.currentMap = new Maps(mainFrame, this);
        //this.mainFrame.setCurrentMap(this.currentMap);
        JScrollPane p = new JScrollPane(this.currentMap);
        this.currentMap.setScrollPane(p);
        this.mainFrame.getjTabbedPane2().addTab("Map", this.currentMap.getScrollPane());
        this.mainFrame.getjTabbedPane2().setTabComponentAt(this.mainFrame.getjTabbedPane2().getTabCount() - 1, this.currentMap.getButton());
    }

    public int getWidth() {
        return width;
    }

    public JMenuItem getMapMenu() {
        return mapMenu;
    }

    public JSeparator getSeparator() {
        return separator;
    }

    public void setSeparator(JSeparator separator) {
        this.separator = separator;
    }

    public void setMapMenu(JMenuItem mapMenu) {
        this.mapMenu = mapMenu;
    }

    public JSeparator getRunSeparator() {
        return runSeparator;
    }

    public Day getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(Day currentDay) {
        this.currentDay = currentDay;
    }

    public JSeparator getPauseSeparator() {
        return pauseSeparator;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public List<LocationToGo> getListLocationToGo() {
        return listLocationToGo;
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
        t.getListMember().entrySet().forEach((e) -> {
            this.listMember.put(listMember.size(), e.getValue());
        });
    }

    public void initPopulation() {
        this.listMember.clear();
        Data.populationNumber = 0;
        mapLocation.entrySet().forEach((Entry<String, LocationCategory> e) -> {
            e.getValue().getListLocation().forEach((l) -> {
                l.initPopulation();
            });
        });
        FileUtilities.saveStat(this.listMember);
    }

    public Map<String, LocationCategory> getMapLocation() {
        return mapLocation;
    }

    public JMenuItem getPopulationMenu() {
        return populationMenu;
    }

    public JSeparator getSeparatorPopulation() {
        return separatorPopulation;
    }

    public void setMapLocation(Map<String, LocationCategory> mapLocation) {
        this.mapLocation = mapLocation;
        FileUtilities.saveWeek(this.week);
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

    public List<ReligionType> getListrelReligionTypes() {
        return listrelReligionTypes;
    }

    public void setListrelReligionTypes(List<ReligionType> listrelReligionTypes) {
        this.listrelReligionTypes = listrelReligionTypes;
    }

    public void addLocation(String name, LocationCategory lc) {
        mapLocation.put(name, lc);
    }

    public List<SexeType> getListSexeType() {
        return listSexeType;
    }

    public void setListSexeType(List<SexeType> listSexeType) {
        this.listSexeType = listSexeType;
    }

    public List<SexeType> getListSexeTypeDeleted() {
        return listSexeTypeDeleted;
    }

    public void setListSexeTypeDeleted(List<SexeType> listSexeTypeDeleted) {
        this.listSexeTypeDeleted = listSexeTypeDeleted;
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

    public void removeReligion(ReligionType rt) {
        this.listrelReligionTypes.remove(rt);
        this.listReligionDeleted.add(rt);
    }

    public void removeHumanAgeType(HumanCityAgeType ha) {
        this.listHumanAgeType.remove(ha);
        this.listHumanAgeTypeDeleted.add(ha);
    }

    public void removeHousePopulation(HousePopulation hp) {
        this.listHousePopulations.remove(hp);
        this.listHousePopulationsDeleted.add(hp);
    }

    public void removeSexeType(SexeType s) {
        this.listSexeType.remove(s);
        this.listSexeTypeDeleted.add(s);
    }

    public Location getLocationDay(String kind) {
        List<String> list = new ArrayList();
        for (Entry<String, LocationCategory> e : this.currentDay.getListLocationCategory().entrySet()) {
            if (e.getValue().getKind().equals(kind)) {
                list.add(e.getKey());
            }
        }
        while (list.size() > 0) {
            int index = MonteCarlo.getNextInt(list.size());
            String name = list.get(index);
            if (this.currentDay.getListLocationCategory().get(name).getListLocation().size() > 0) {
                int in = MonteCarlo.getNextInt(this.currentDay.getListLocationCategory().get(name).getListLocation().size());
                return this.currentDay.getListLocationCategory().get(name).getListLocation().get(in);
            } else {
                list.remove(name);
            }
        }
        return null;
    }

    public Location getRandomLocation() {
        while (true) {
            int index = MonteCarlo.getNextInt(this.week.getCurrentDay().getListLocationCategory().size());
            List<Location> list = null;
            int i = 0;
            for (Entry<String, LocationCategory> e : this.week.getCurrentDay().getListLocationCategory().entrySet()) {
                if (i == index) {
                    list = e.getValue().getListLocation();
                    break;
                } else {
                    i++;
                }
            }
            if (list != null && list.size() > 0) {
                int index1 = MonteCarlo.getNextInt(list.size());
                Location l = list.get(index1);
                return l;
            }
        }
    }

    @Override
    public Location getLocation(String kind) throws RemoteException {
        List<String> list = new ArrayList();
        if (kind.equals("work")) {
            for (Entry<String, LocationCategory> e : this.mapLocation.entrySet()) {
                if (!e.getValue().getKind().equals("House") && !e.getValue().getKind().equals("Mosque") && !e.getValue().getKind().equals("Church")) {
                    list.add(e.getKey());
                }
            }
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
        } else {
            for (Entry<String, LocationCategory> e : this.mapLocation.entrySet()) {
                if (e.getValue().getKind().equals(kind)) {
                    list.add(e.getKey());
                }
            }
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

    public Tile[][] getMap() {
        return map;
    }

    public JMenuItem getRunMenu() {
        return runMenu;
    }

    public void setRunMenu(JMenuItem runMenu) {
        this.runMenu = runMenu;
    }

    public JMenuItem getPauseMenu() {
        return pauseMenu;
    }

    public void setPauseMenu(JMenuItem pauseMenu) {
        this.pauseMenu = pauseMenu;
    }

    public List<HousePopulation> getListHousePopulations() {
        return listHousePopulations;
    }

    public void setListHousePopulations(List<HousePopulation> listHousePopulations) {
        this.listHousePopulations = listHousePopulations;
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

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public Tile getTile(int x, int y) {
        int xi = x / (Data.TileWidth + 1);
        int yi = y / (Data.TileHeight + 1);
        return this.map[xi][yi];
    }

    public void initMapTile() {
        this.nbw = this.getWidth() / (Data.TileWidth + 1);
        int dw = this.getWidth() % (Data.TileWidth + 1);
        this.setWidth(this.getWidth() - dw);
        this.nbh = this.getHeight() / (Data.TileHeight + 1);
        int dh = this.getHeight() % (Data.TileHeight + 1);
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
                this.thread.sleep(5);
                week.changeTime();
                mainFrame.updateTime(week);
                for (Entry<Integer, Member> e : listMember.entrySet()) {
                    e.getValue().move();
                }
                this.currentMap.repaint();
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
        this.mapLocation.entrySet().stream().map((e) -> {
            e.getValue().setCityId(this.id);
            return e;
        }).forEachOrdered((e) -> {
            e.getValue().save();
        });
        this.mapLocationDeleted.entrySet().stream().map((e) -> {
            e.getValue().setCityId(this.id);
            return e;
        }).forEachOrdered((e) -> {
            e.getValue().save();
        });
        this.listHumanAgeType.stream().map((h) -> {
            //h.setCity(this);
            return h;
        }).forEachOrdered((h) -> {
            h.save();
        });

        this.listHumanAgeTypeDeleted.stream().map((h) -> {
            // h.setCity(this);
            return h;
        }).forEachOrdered((h) -> {
            h.save();
        });
        this.listrelReligionTypes.stream().map((rt) -> {
            rt.setCity(this);
            return rt;
        }).forEachOrdered((rt) -> {
            rt.save();
        });
        this.listReligionDeleted.stream().map((rt) -> {
            rt.setCity(this);
            return rt;
        }).forEachOrdered((rt) -> {
            rt.save();
        });
        this.listHousePopulations.stream().map((hp) -> {
            hp.setCity(this);
            return hp;
        }).forEachOrdered((hp) -> {
            hp.save();
        });
        this.listHousePopulationsDeleted.stream().map((hp) -> {
            hp.setCity(this);
            return hp;
        }).forEachOrdered((hp) -> {
            hp.save();
        });
        for (SexeType st : this.listSexeType) {
            st.setCity(this);
            st.save();
        }

        for (SexeType st : this.listSexeTypeDeleted) {
            st.setCity(this);
            st.save();
        }
        for (LocationToGo l : this.listLocationToGo) {
            l.save1();
        }
        for (LocationToGo l : this.listLocationDeleted) {
            l.save1();
        }
        this.listLocationDeleted.clear();
    }

    public void removeLocationToGo(List<LocationToGo> list) {
        for (HumanCityAgeType st : this.listHumanAgeType) {
            st.updateLocation(list);
        }
        for (LocationToGo ha : list) {
            if (ha.isIsNew()) {
                if (!ha.isDeleted()) {
                    LocationToGo han = new LocationToGo(ha.getName(), this);
                    this.listLocationToGo.add(han);
                    this.listLocationAdd.add(han);
                } else {

                }
            } else {
                if (ha.isDeleted()) {
                    LocationToGo tmp = null;
                    for (LocationToGo hat : this.listLocationToGo) {
                        if (hat.getName().equals(ha.getName())) {
                            hat.setDeleted(true);
                            tmp = hat;
                            break;
                        }
                    }
                    if (this.listLocationAdd.contains(tmp)) {
                        this.listLocationAdd.remove(tmp);
                    }
                    this.listLocationToGo.remove(tmp);
                    this.listLocationDeleted.add(tmp);
                } else {

                }
            }
        }
    }

    public void removeReligion(List<ReligionType> list) {
        for (ReligionType ha : list) {
            if (ha.isIsNew()) {
                if (!ha.isIsdelete()) {
                    ReligionType han = new ReligionType(ha.getName(), 0.0, ha.getPrayLocation(), this);
                    this.listrelReligionTypes.add(han);
                    this.listReligionAdd.add(han);
                } else {

                }
            } else {
                if (ha.isIsdelete()) {
                    ReligionType tmp = null;
                    for (ReligionType hat : this.listrelReligionTypes) {
                        if (hat.getName().equals(ha.getName())) {
                            hat.setIsdelete(true);
                            tmp = hat;
                            break;
                        }
                    }
                    if (this.listReligionAdd.contains(tmp)) {
                        this.listReligionAdd.remove(tmp);
                    }
                    this.listrelReligionTypes.remove(tmp);
                    this.listReligionDeleted.add(tmp);
                } else {

                }
            }
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        City c = (City) super.clone();
        c.week = new Week(c);
        c.thread = new Thread(c);
        c.initMapTile();
        c.mapLocation = new HashMap();
        c.listMember = new HashMap();
        this.mapLocation.entrySet().forEach((e) -> {
            c.mapLocation.put(e.getKey(), (LocationCategory) e.getValue().clone(c));
        });
        return c;
    }

    public void changeDay(Day d) {
        this.currentDay = d;
        this.listMember.entrySet().forEach((e) -> {
            e.getValue().setDay(d);
        });
    }

    public void changeHour(int hour) {
        this.listMember.entrySet().forEach((e) -> {
            e.getValue().setHour(hour);
        });
    }
}
