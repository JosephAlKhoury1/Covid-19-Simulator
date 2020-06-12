package models.model;

import controller.controllers.ModelController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import models.client1.City;
import views1.MainFrame;
import views1.MapModel;
import views1.model.panel.ModelPanel;

public class Model {

    private int modelId;
    private String modelName;

    private int isMain;
    private boolean saved;
    private boolean newModel;
    private boolean deleted;

    private MainFrame mainFrame;
    private ModelPanel modelPanel;

    private List<SymptomType> listSymptomsType;
    private List<SymptomStage> listSymptomStage;
    private List<SymptomStage> listDeleted;
    private List<SymptomStage> listAdd;

    private List<HumanAge> listHumanAge;
    private List<HumanAge> listHumanAgeAdd;
    private List<HumanAge> listHumanAgeDeleted;

    private City city;
    private MapModel currentMap;
    private JMenuItem mapMenu, runMenu, pauseMenu, populationMenu;

    public Model(int modelId, String modelName, List<SymptomType> list, List<SymptomStage> listSS, List<HumanAge> listHA) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.listSymptomsType = list;
        this.listSymptomStage = listSS;
        this.listHumanAge = listHA;
        this.listDeleted = new ArrayList();
        this.listAdd = new ArrayList();
        this.listHumanAgeAdd = new ArrayList();
        this.listHumanAgeDeleted = new ArrayList();
        this.isMain = 1;

        this.mapMenu = new JMenuItem(this.modelName + " Map");
        this.mapMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateMapLocation();
                mapMenu.setEnabled(false);
            }
        });

        this.populationMenu = new JMenuItem(this.modelName + " Model");
        this.populationMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city.initPopulation();
                populationMenu.setEnabled(false);
            }
        });

        this.runMenu = new JMenuItem("Run " + this.modelName);
        this.runMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city.start();
            }
        });

        this.pauseMenu = new JMenuItem("Pause " + this.modelName);
        this.pauseMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city.pause();
            }
        });
        this.newModel = false;
        this.saved = true;
        this.deleted = false;
    }

    public Model(String name, MainFrame frame, City c) {
        this.modelName = name;
        this.mainFrame = frame;
        this.isMain = 1;
        this.city = c;
        this.newModel = true;
        this.saved = false;
        this.deleted = false;
        this.listDeleted = new ArrayList();
        this.listAdd = new ArrayList();

        this.mapMenu = new JMenuItem(this.modelName + " Map");
        this.mapMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateMapLocation();
                mapMenu.setEnabled(false);
            }
        });

        this.populationMenu = new JMenuItem(this.modelName + " Population");
        this.populationMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city.initPopulation();
                populationMenu.setEnabled(false);
            }
        });

        this.runMenu = new JMenuItem("Run " + this.modelName);
        this.runMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city.start();
            }
        });

        this.pauseMenu = new JMenuItem("Pause " + this.modelName);
        this.pauseMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city.pause();
            }
        });

        this.listSymptomsType = new ArrayList();
        this.listSymptomStage = new ArrayList();
        this.listHumanAge = new ArrayList();
        this.listHumanAgeAdd = new ArrayList();
        this.listHumanAgeDeleted = new ArrayList();

        frame.getListSymptomName().forEach((sn) -> {
            SymptomType st = new SymptomType(sn.getName(), 0, frame.getListSymptomStageNames(), frame.getListHumanAgeName(), this);
            this.listSymptomsType.add(st);
        });

        int index = 0;
        for (SymptomStageName ssn : frame.getListSymptomStageNames()) {
            this.listSymptomStage.add(new SymptomStage(ssn.getName(), 0.0, 0.0, index, this));
            index++;
        }
        for (HumanAgeName han : frame.getListHumanAgeName()) {
            this.listHumanAge.add(new HumanAge(han.getName(), han.getMinAge(), han.getMaxAge(), this));
        }
    }

    public void generateMapLocation() {
//        this.currentMap = new MapModel(mainFrame, this);
//        JScrollPane p = new JScrollPane(this.currentMap);
//        this.currentMap.setScrollPane(p);
//        this.mainFrame.getjTabbedPane2().addTab("Map", this.currentMap.getScrollPane());
//        this.mainFrame.getjTabbedPane2().setTabComponentAt(this.mainFrame.getjTabbedPane2().getTabCount() - 1, this.currentMap.getButton());
        this.city.generateMapLocation();
//        this.maps = new Maps(this.mainFrame, this.city);
//        JScrollPane p = new JScrollPane(this.currentMap);
//        this.maps.setScrollPane(p);
//        this.mainFrame.getjTabbedPane2().addTab("Map", this.maps.getScrollPane());
//        this.mainFrame.getjTabbedPane2().setTabComponentAt(this.mainFrame.getjTabbedPane2().getTabCount() - 1, this.maps.getButton());
    }

    public String getModelName() {
        return modelName;
    }

    public JMenuItem getRunMenu() {
        return runMenu;
    }

    public JMenuItem getPopulationMenu() {
        return populationMenu;
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

    public JMenuItem getMapMenu() {
        return mapMenu;
    }

    public void setMapMenu(JMenuItem mapMenu) {
        this.mapMenu = mapMenu;
    }

    public boolean isSaved() {
        return saved;
    }

    public MapModel getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(MapModel currentMap) {
        this.currentMap = currentMap;
    }

    public void setCity(City c) {
        this.city = c;
    }

    public List<SymptomStage> getListSymptomStage() {
        return listSymptomStage;
    }

    public void setListSymptomStage(List<SymptomStage> listSymptomStage) {
        this.listSymptomStage = listSymptomStage;
    }

    public City getCity() {
        return city;
    }

    public int getIsMain() {
        return isMain;
    }

    public void setIsMain(int isMain) {
        this.isMain = isMain;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public boolean isNewModel() {
        return newModel;
    }

    public void setNewModel(boolean newModel) {
        this.newModel = newModel;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        for (SymptomType ss : this.listSymptomsType) {
            ss.setModel(this);
        }
        /*for (SymptomStage st : this.listSymptomStage) {
            st.setModel(this);
        }*/
    }

    public List<SymptomType> getListSymptomsType() {
        return listSymptomsType;
    }

    public void setListSymptomsType(List<SymptomType> listSymptomsType) {
        this.listSymptomsType = listSymptomsType;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public ModelPanel getModelPanel() {
        return modelPanel;
    }

    public void setModelPanel(ModelPanel modelPanel) {
        this.modelPanel = modelPanel;
    }

    public void removeSymptomStage(List<SymptomStage> list) {
        listSymptomsType.forEach((st) -> {
            st.updateSymptomStage(list);
        });
        for (SymptomStage sts : list) {
            if (sts.isIsNew()) {
                if (!sts.isDeleted()) {
                    SymptomStage ss = new SymptomStage(sts.getName(), sts.getDeathPercentage(), sts.getImmunePercentage(), sts.getIndex(), this);
                    this.listSymptomStage.add(ss);
                    //this.listAdd.add(ss);
                } else {
                }
            } else {
                for (SymptomStage st : this.listSymptomStage) {
                    if (st.getName().equals(sts.getName())) {
                        if (sts.isDeleted()) {
                            st.setDeleted(true);
                            this.listDeleted.add(st);
                        } else {
                            st.setIndex(sts.getIndex());
                            st.setSaved(false);
                        }
                    }
                }
            }
        }
        for (SymptomStage st : this.listDeleted) {
            this.listSymptomStage.remove(st);
        }

        SymptomStage[] tab = new SymptomStage[listSymptomStage.size()];
        for (SymptomStage ss : listSymptomStage) {
            tab[ss.getIndex()] = ss;
        }

        listSymptomStage.clear();

        for (SymptomStage ss : tab) {
            listSymptomStage.add(ss);
        }
    }

    public void removeHumanAge(List<HumanAge> list) {
        for (SymptomType st : this.listSymptomsType) {
            st.updateHumanAge(list);
        }
        for (HumanAge ha : list) {
            if (ha.isIsNew()) {
                if (!ha.isDeleted()) {
                    HumanAge han = new HumanAge(ha.getName(), ha.getMinAge(), ha.getMaxAge(), this);
                    this.listHumanAge.add(han);
                    this.listHumanAgeAdd.add(han);
                } else {

                }
            } else {
                if (ha.isDeleted()) {
                    HumanAge tmp = null;
                    for (HumanAge hat : this.listHumanAge) {
                        if (hat.getName().equals(ha.getName())) {
                            hat.setDeleted(true);
                            tmp = hat;
                            break;
                        }
                    }
                    if (this.listHumanAgeAdd.contains(tmp)) {
                        this.listHumanAgeAdd.remove(tmp);
                    }
                    this.listHumanAge.remove(tmp);
                    this.listHumanAgeDeleted.add(tmp);
                } else {

                }
            }
        }
    }

    public List<HumanAge> getListHumanAge() {
        return listHumanAge;
    }

    public void setListHumanAge(List<HumanAge> listHumanAge) {
        this.listHumanAge = listHumanAge;
    }

    public void save() {
        if (this.isNewModel()) {
            this.modelId = ModelController.INSTANCE.insertModel(this);
            this.setNewModel(false);
            this.setSaved(true);
        } else {
            if (!this.isSaved()) {
                ModelController.INSTANCE.updateModel(this);
                this.setSaved(true);
            }
        }

        this.listSymptomsType.stream().map((st) -> {
            st.setModel(this);
            return st;
        }).forEachOrdered((st) -> {
            st.save();
        });

        for (SymptomStage ss : this.listSymptomStage) {
            //ss.setModel(this);
            ss.save1();
        }
        for (SymptomStage ss : this.listDeleted) {
            // ss.setModel(this);
            ss.save1();
        }
        for (HumanAge ha : this.listHumanAge) {
            ha.setModel(this);
            ha.save1();
        }
        for (HumanAge ha : this.listHumanAgeDeleted) {
            ha.setModel(this);
            ha.save1();
        }
        this.listHumanAgeDeleted.clear();
        this.listHumanAgeAdd.clear();
        this.listAdd.clear();
        this.listDeleted.clear();

    }
}
