package models.client;

import Properties.MonteCarlo;
import models.location.LocationCategory;
import models.location.Location;
import controller.controllers.LocationToGoController;
import controller.locationController.CityController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import models.member.Member;
import models.model.HumanAgeName;
import models.model.Model;
import models.model.PauseTime;
import models.model.ReligionName;
import models.model.SymptomStage;
import models.transportation.Transportation;
import resources.Colors.Colors;
import resources.icon.Icons;
import resources.Messages.Messages;
import tools.Excel;
import views.tile.Tile;
import views.tile.TileType;
import views1.city.panel.CityPanel;
import views1.MainFrame;
import views1.city.panel.Maps;
import views1.model.panel.FileChooser;

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
    private JMenuItem mapMenu, populationMenu;
    private JSeparator separator, separatorPopulation;

    private boolean populationGenerated = false;

    private int speed = 5;

    private Model model;

    private int runTime = 0;

    private boolean haveBadHumanPercentageSum = false;

    private boolean hourChanged = false;
    private int currentHour;

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
            this.listHumanAgeType.add(new HumanCityAgeType(han.getName(), han.getMinAge(), han.getMaxAge(), 0.0, 0.0, this));
        }
        this.listLocationToGo = new ArrayList();
        for (String s : Data.tabLocation) {
            if (!"House".equals(s)) {
                this.listLocationToGo.add(new LocationToGo(s, this));
            }
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
        Runnable r = new Runnable() {
            @Override
            public void run() {
                pause();
            }
        };

        Data.initData(this.listrelReligionTypes, this.listHousePopulations, this.listHumanAgeType, this.listSexeType);
    }

    public List<HumanCityAgeType> getListHumanAgeType() {
        return listHumanAgeType;
    }

    public CityPanel getCityPanel() {
        return cityPanel;
    }

    public void generateMapLocation() {
        if (this.currentMap == null) {
            this.currentMap = new Maps(mainFrame, this);
        }
        JScrollPane p = new JScrollPane(this.currentMap);
        this.currentMap.setScrollPane(p);
        this.model.getModelPanel().getjTabbedPane1().addTab("Map", this.currentMap.getScrollPane());
        this.model.getModelPanel().getjTabbedPane1().setTabComponentAt(this.model.getModelPanel().getjTabbedPane1().getTabCount() - 1, this.currentMap.getButton());
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isPopulationGenerated() {
        return populationGenerated;
    }

    public void setPopulationGenerated(boolean populationGenerated) {
        this.populationGenerated = populationGenerated;
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

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public Day getCurrentDay() {
        return currentDay;
    }

    public void setCityPanel(CityPanel cityPanel) {
        this.cityPanel = cityPanel;
    }

    public boolean isHaveBadHumanPercentageSum() {
        return haveBadHumanPercentageSum;
    }

    public void setHaveBadHumanPercentageSum(boolean haveBadHumanPercentageSum) {
        this.haveBadHumanPercentageSum = haveBadHumanPercentageSum;
    }

    public void setCurrentDay(Day currentDay) {
        this.currentDay = currentDay;
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
        this.model.getListHealth().clear();
        this.model.getListDeath().clear();
        this.model.getListImmune().clear();
        for (SymptomStage ss : this.model.getListSymptomStage1sHospital()) {
            ss.getListMember().clear();
        }
        for (SymptomStage ss : this.model.getListSymptomStage1sNonHospital()) {
            ss.getListMember().clear();
        }
        Data.populationNumber = 0;
        mapLocation.entrySet().forEach((Entry<String, LocationCategory> e) -> {
            e.getValue().getListLocation().forEach((l) -> {
                l.initPopulation();
            });
        });
        this.populationGenerated = true;
        int infected = this.model.getInfectedNumber();
        if (infected > 0 && !this.listMember.isEmpty()) {
            this.model.changeState(infected);
        }
        this.model.getModelPanel().getStatistiquePane().updateState();
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

    public Location getLocationDay(String kind, String day) {
        List<LocationCategory> list = week.getLocationPerDay(day, kind);
        if (!list.isEmpty()) {
            while (true) {
                int index = MonteCarlo.getNextInt(list.size());
                LocationCategory lc = list.get(index);
                if (!lc.getListLocation().isEmpty()) {
                    int index2 = MonteCarlo.getNextInt(lc.getListLocation().size());
                    Location l = lc.getListLocation().get(index2);
                    return l;
                }
            }
        } else {
            return null;
        }
    }

    public Location getLocationForWork() {
        List<LocationCategory> list = new ArrayList();
        for (Entry<String, LocationCategory> e : this.mapLocation.entrySet()) {
            if (!e.getKey().equals("House") && !e.getKey().equals("Church") && !e.getKey().equals("Mosque")) {
                list.add(e.getValue());
            }
        }
        if (list.isEmpty()) {
            return null;
        }
        while (true) {
            int index = MonteCarlo.getNextInt(list.size());
            LocationCategory lc = list.get(index);
            if (!lc.getListLocation().isEmpty()) {
                int index2 = MonteCarlo.getNextInt(lc.getListLocation().size());
                Location l = lc.getListLocation().get(index2);
                return l;
            }
        }
    }
    
    public Location getSchool(){
      List<LocationCategory> list = new ArrayList();
        for (Entry<String, LocationCategory> e : this.mapLocation.entrySet()) {
            if (e.getKey().equals("School")) {
                list.add(e.getValue());
            }
        }
        if (list.isEmpty()) {
            return null;
        }
        while (true) {
            int index = MonteCarlo.getNextInt(list.size());
            LocationCategory lc = list.get(index);
            if (!lc.getListLocation().isEmpty()) {
                int index2 = MonteCarlo.getNextInt(lc.getListLocation().size());
                Location l = lc.getListLocation().get(index2);
                return l;
            }
        }
    }
    
    public Location getUniversity(){
      List<LocationCategory> list = new ArrayList();
        for (Entry<String, LocationCategory> e : this.mapLocation.entrySet()) {
            if (e.getKey().equals("University")) {
                list.add(e.getValue());
            }
        }
        if (list.isEmpty()) {
            return null;
        }
        while (true) {
            int index = MonteCarlo.getNextInt(list.size());
            LocationCategory lc = list.get(index);
            if (!lc.getListLocation().isEmpty()) {
                int index2 = MonteCarlo.getNextInt(lc.getListLocation().size());
                Location l = lc.getListLocation().get(index2);
                return l;
            }
        }
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
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
        for (Entry<String, LocationCategory> e : this.mapLocation.entrySet()) {
            if (e.getValue().getKind().equals(kind)) {
                list.add(e.getKey());
            }
        }
        while (list.size() > 0) {
            int index = MonteCarlo.getNextInt(list.size());
            String n = list.get(index);
            if (mapLocation.get(n).getListLocation().size() > 0) {
                int in = MonteCarlo.getNextInt(mapLocation.get(n).getListLocation().size());
                return mapLocation.get(n).getListLocation().get(in);
            } else {
                list.remove(n);
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
        String message = " ";
        if (this.model.getRunTime() == 0) {
            message = message + Messages.runTimeEqual0();
        }

        if (this.model.getInfectedNumber() == 0) {
            message = message + Messages.infectedNumberEqual0();
        }
        int reply = 0;
        if (!message.equals(" ")) {
            message = message + Messages.doYouWantToContinue();
            reply = JOptionPane.showOptionDialog(mainFrame, message, "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
        }
        if (reply == JOptionPane.NO_OPTION || reply == JOptionPane.CLOSED_OPTION) {
            return;
        }

        this.model.setDisable();
        this.model.getModelPanel().setDisable();
        this.model.setRun(true);
        this.model.setPause(false);
        this.model.setStop(false);
        this.model.setRefresh(false);
        this.model.setFirstTimeRun(false);
        this.model.setCanBuild(false);
        this.thread.start();
        if (this.mainFrame.getCurrentModel() == this.model) {
            this.mainFrame.getRunButton().setEnabled(false);
            this.mainFrame.getPauseButton().setEnabled(true);
            this.mainFrame.getStopButton().setEnabled(true);
            this.mainFrame.getBuildButton().setEnabled(false);
        }
        this.model.getRunMenu().setEnabled(false);
        this.model.getPauseMenu().setEnabled(true);
        this.model.getStopMenu().setEnabled(true);
        this.populationMenu.setEnabled(false);

        this.model.getModelPanel().getStatistiquePane().getChart().init();
    }

    public void pause() {
        this.model.setRun(false);
        this.model.setPause(true);
        this.model.setStop(false);
        if (this.mainFrame.getCurrentModel() == this.model) {
            this.mainFrame.getRunButton().setEnabled(true);
            this.mainFrame.getPauseButton().setEnabled(false);
        }
        this.model.getRunMenu().setEnabled(true);
        this.model.getPauseMenu().setEnabled(false);
        this.thread.suspend();
        //this.mainFrame.pause();
    }

    public void resume(String hello) {
        this.model.setRun(true);
        this.model.setPause(false);
        this.model.setStop(false);
        System.out.println(hello);

        if (this.mainFrame.getCurrentModel() == this.model) {
            this.mainFrame.getRunButton().setEnabled(false);
            this.mainFrame.getPauseButton().setEnabled(true);
        }
        this.model.getRunMenu().setEnabled(false);
        this.model.getPauseMenu().setEnabled(true);
        this.thread.resume();

    }

    public void stopRun() {
        this.model.setStop(true);
        this.week.addResult();
        this.model.setRefresh(true);
        this.mainFrame.saveToFileButton.setEnabled(true);
        if (this.mainFrame.getCurrentModel() == this.model) {
            this.mainFrame.getRunButton().setEnabled(false);
            this.mainFrame.getPauseButton().setEnabled(false);
            this.mainFrame.getStopButton().setEnabled(false);
            this.mainFrame.getRefleshButton().setEnabled(true);
        }
        this.model.getRunMenu().setEnabled(false);
        this.model.getPauseMenu().setEnabled(false);
        this.model.getStopMenu().setEnabled(false);
        this.model.getModelPanel().getStatistiquePane().getChart().stop();
        JFrame f = new JFrame();
        f.setSize(700, 500);
        f.setLocation(300, 200);

        FileChooser cf = new FileChooser(this.name + " " + this.model.getModelName());
        cf.setSize(700, 500);
        int r = cf.j.showSaveDialog(cf.j);
        f.add(cf);

        if (r == JFileChooser.APPROVE_OPTION) {
            File file = cf.getFile();
            Excel.writeResult1(file, model);
        }
    }

    public void pauseRun() {
        this.model.setRun(false);
        this.model.setPause(true);
        this.model.setStop(false);
        if (this.mainFrame.getCurrentModel() == this.model) {
            this.mainFrame.getRunButton().setEnabled(true);
            this.mainFrame.getPauseButton().setEnabled(false);
        }
        this.model.getRunMenu().setEnabled(true);
        this.model.getPauseMenu().setEnabled(false);
    }

    public void stop() {
        this.thread.stop();
        stopRun();
    }

    public Tile[][] getMap() {
        return map;
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

    public void reshapMapTile() {
        this.setWidth(this.getWidth() + 400);
        this.setHeight(this.getHeight() + 200);

        this.nbw = this.getWidth() / (Data.TileWidth + 1);
        int dw = this.getWidth() % (Data.TileWidth + 1);
        this.setWidth(this.getWidth() - dw);
        this.nbh = this.getHeight() / (Data.TileHeight + 1);
        int dh = this.getHeight() % (Data.TileHeight + 1);
        this.setHeight(this.getHeight() - dh);

        map = new Tile[nbw][nbh];

        for (int a = 0; a < nbw; a++) {
            for (int b = 0; b < nbh; b++) {
                if (map[a][b] == null) {
                    map[a][b] = new Tile(a * (Data.TileWidth + 1), b * (Data.TileHeight + 1), TileType.buildingTile, this.cityPanel);
                    if (a > 0) {
                        map[a][b].setTopTile(map[a - 1][b]);
                    }
                    if (b > 0) {
                        map[a][b].setLeftTile(map[a][b - 1]);
                    }
                }
            }
        }
        for (Entry<String, LocationCategory> e : this.mapLocation.entrySet()) {
            e.getValue().initLocation();
        }
        if (this.currentMap != null) {
            this.currentMap.reshape();
        }

        if (this.model == null) {
            for (Model m : this.mainFrame.getListModel()) {
                m.getCity().reshapMapTile();
            }
        }
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

    public boolean dayChanged = false;

    @Override
    public void run() {
        boolean stop = false;
        while (true) {
            try {
                this.thread.sleep(speed);
                week.changeTime();
                model.getModelPanel().getStatistiquePane().updateState();
                model.getModelPanel().getStatistiquePane().updateTime(week);
                if (dayChanged) {
                    this.runTime++;
                }
                for (Entry<Integer, Member> e : listMember.entrySet()) {
                    if (dayChanged) {
                        if (this.hourChanged = true) {
                            e.getValue().setHour(this.currentHour);
                        }
                        e.getValue().setDay(this.currentDay);
                        e.getValue().move(week.getCurrentDay().getDay().getName());
                    } else {
                        if (this.hourChanged = true) {
                            e.getValue().setHour(this.currentHour);
                        }
                        e.getValue().move();
                    }
                }
                this.hourChanged = false;
                this.setDayChanged(false);
                if (this.currentMap != null) {
                    this.currentMap.repaint();
                }
                for (PauseTime pt : model.getListPauseTime()) {
                    if (this.runTime == pt.getDays() && !pt.isHasBeenChecked()) {
                        pt.setHasBeenChecked(true);
                        this.pause();
                    }
                }

                if (this.model.getRunTime() != 0) {
                    if (this.model.getRunTime() == this.runTime) {
                        stop = true;
                    }
                }
                if (stop) {
                    break;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(City.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (stop) {
            this.stopRun();
        }

    }

    public boolean isDayChanged() {
        return dayChanged;
    }

    public void setDayChanged(boolean dayChanged) {
        this.dayChanged = dayChanged;
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
        c.setListHousePopulations(this.listHousePopulations);
        c.setListHumanAgeType(this.listHumanAgeType);
        c.thread = new Thread(c);
        c.initMapTile();
        c.mapLocation = new HashMap();
        c.listMember = new HashMap();
        this.mapLocation.entrySet().forEach((e) -> {
            LocationCategory lcNew = (LocationCategory) e.getValue().clone(c);
            c.mapLocation.put(e.getKey(), lcNew);

        });
        return c;
    }

    public void changeDay(Day d) {
        this.currentDay = d;
        this.model.incrementDay();
    }

    public void changeHour(int hour) {
        this.hourChanged = true;
        this.currentHour = hour;
    }

    public void changeState(int num) {
        if (this.populationGenerated) {
            if (num >= this.listMember.size()) {
                for (Entry<Integer, Member> m : this.listMember.entrySet()) {
                    this.model.getListHealth().remove(m.getValue());
                    m.getValue().setInfected(true);
                }
            } else {
                for (int i = 0; i < num; i++) {
                    int y = MonteCarlo.getNextInt(this.model.getListHealth().size());
                    Member m = this.model.getListHealth().get(y);
                    this.model.getListHealth().remove(y);
                    m.setInfected(true);
                }
                this.model.getModelPanel().getStatistiquePane().updateState();
            }
        }
    }

    public void refresh() {
        this.week.refresh();
        this.thread = new Thread(this);
        this.runTime = 0;
        for (Entry<Integer, Member> e : this.listMember.entrySet()) {
            e.getValue().refresh();
            this.model.getListHealth().add(e.getValue());
        }
        if (this.currentMap != null) {
            this.currentMap.repaint();
        }
    }

    public void checkHousePopulationPercentage() {
        double newPer = 0;
        for (HousePopulation h : this.listHousePopulations) {
            newPer += h.getPercentage();
        }
        if (newPer != 100) {
            this.cityPanel.housePopulationPercentageLabel.setBackground(Colors.WARNINGCOLOR);
            this.cityPanel.housePopulationPercentageLabel.setIcon(Icons.WARNINGICON);
            this.cityPanel.housePopulationPercentageLabel.setToolTipText(Messages.HousePopulationPercentageBad());
            for (HousePopulation h : getListHousePopulations()) {
                h.percentageTxt.setBackground(Colors.WARNINGCOLOR);
            }
        } else {
            this.cityPanel.housePopulationPercentageLabel.setBackground(Colors.WHITE);
            this.cityPanel.housePopulationPercentageLabel.setIcon(null);
            this.cityPanel.housePopulationPercentageLabel.setToolTipText(null);
            for (HousePopulation h : getListHousePopulations()) {
                h.percentageTxt.setBackground(Colors.WHITE);
            }
        }
    }

    public void checkAgePercentage() {
        double newPer = 0;
        newPer = this.listHumanAgeType.stream().map((h) -> h.getHumanPercentage()).reduce(newPer, (accumulator, _item) -> accumulator + _item);
        if (newPer != 100) {
            this.getListHumanAgeType().forEach((ha) -> {
                ha.getPercentageJtxt().setBackground(Colors.WARNINGCOLOR);
            });
            this.cityPanel.percentageOfHumanLabel.setIcon(Icons.WARNINGICON);
            this.cityPanel.percentageOfHumanLabel.setToolTipText(Messages.PERCENTAGEOFHUMANHAVINTHISAGEWITHWARNING);
            this.cityPanel.percentageOfHumanLabel.setBackground(Colors.WARNINGCOLOR);
        } else {
            this.getListHumanAgeType().forEach((ha) -> {
                ha.getPercentageJtxt().setBackground(Colors.NOWARNINGCOLOR);
            });
            this.cityPanel.percentageOfHumanLabel.setIcon(null);
            this.cityPanel.percentageOfHumanLabel.setToolTipText(Messages.PERCENTAGEOFHUMANHAVINTHISAGE);
            this.cityPanel.percentageOfHumanLabel.setBackground(Colors.NOWARNINGCOLOR);
        }
    }
}
