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

    private List<HumanAge> listHumanAge;
    private List<HumanAge> listHumanAgeAdd;
    private List<HumanAge> listHumanAgeDeleted;

    private List<SymptomType> listSymptomType;

    private List<SymptomStage> listSymptomStage1s, listStageDeleted;

    private City city;
    private MapModel currentMap;
    private JMenuItem mapMenu, runMenu, pauseMenu, populationMenu;

    private boolean run = false, pause = false, stop = false;

    public Model(int modelId, String modelName, List<SymptomType> list, List<SymptomStage> listSS, List<HumanAge> listHA) {
        this.modelId = modelId;
        this.modelName = modelName;

        this.listHumanAge = listHA;
        this.listSymptomStage1s = listSS;
        this.listSymptomType = list;
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
                setRun(true);
                setPause(false);
                mainFrame.getRunButton().setEnabled(false);
                mainFrame.getPauseButton().setEnabled(true);
                runMenu.setEnabled(false);
                pauseMenu.setEnabled(true);
            }
        });

        this.pauseMenu = new JMenuItem("Pause " + this.modelName);
        this.pauseMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city.pause();
                setPause(true);
                setRun(false);
                mainFrame.getRunButton().setEnabled(true);
                mainFrame.getPauseButton().setEnabled(false);
                runMenu.setEnabled(true);
                pauseMenu.setEnabled(false);
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
        if (this.city != null) {
            this.city.setModel(this);
        }
        this.newModel = true;
        this.saved = false;
        this.deleted = false;

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

        this.listHumanAge = new ArrayList();
        this.listHumanAgeAdd = new ArrayList();
        this.listHumanAgeDeleted = new ArrayList();

        this.listSymptomType = new ArrayList();
        this.listSymptomStage1s = new ArrayList();
        this.listStageDeleted = new ArrayList();

        for (SymptomStageName stn : this.mainFrame.getListSymptomStageNames()) {
            SymptomStage stgn = new SymptomStage(stn.getName(), 0.0, 0.0, 0, this);
            this.listSymptomStage1s.add(stgn);
        }
        for (SymptomName sn : this.mainFrame.getListSymptomName()) {
            SymptomType st1 = new SymptomType(sn.getName(), 0, this.mainFrame.getListSymptomStageNames(), this.listSymptomStage1s, this);
            this.listSymptomType.add(st1);
        }
        for (HumanAgeName hu : this.mainFrame.getListHumanAgeName()) {
            HumanAge hum = new HumanAge(hu.getName(), hu.getMinAge(), hu.getMaxAge(), this.listSymptomType, this);
            this.listHumanAge.add(hum);
        }

    }

    public void generateMapLocation() {
        this.city.generateMapLocation();
    }

    public List<SymptomStage> getListSymptomStage1s() {
        return listSymptomStage1s;
    }

    public void setListSymptomStage1s(List<SymptomStage> listSymptomStage1s) {
        this.listSymptomStage1s = listSymptomStage1s;
    }

    public String getModelName() {
        return modelName;
    }

    public JMenuItem getRunMenu() {
        return runMenu;
    }

    public List<SymptomType> getListSymptomType() {
        return listSymptomType;
    }

    public void setListSymptomType(List<SymptomType> listSymptomType) {
        this.listSymptomType = listSymptomType;
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

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public void setCity(City c) {
        this.city = c;
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

        /*for (SymptomStage st : this.listSymptomStage) {
            st.setModel(this);
        }*/
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

    public void removeHumanAge(List<HumanAge> list) {
//        for (SymptomType st : this.listSymptomsType) {
//            st.updateHumanAge(list);
//        }
        for (HumanAge ha : list) {
            if (ha.isIsNew()) {
                if (!ha.isDeleted()) {
                    //HumanAge han = new HumanAge(ha.getName(), ha.getMinAge(), ha.getMaxAge(), this);
                    //this.listHumanAge.add(han);
                    //this.listHumanAgeAdd.add(han);
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

        for (SymptomStage stage : this.listSymptomStage1s) {
            stage.setModel(this);
            stage.save1();
        }

        for (SymptomType st : this.listSymptomType) {
            st.setModel(this);
            st.save();
        }

        for (HumanAge ha : this.listHumanAge) {
            ha.setModel(this);
            ha.save();
        }

        /*for (HumanAge ha : this.listHumanAgeDeleted) {
            ha.setModel(this);
            ha.save1();
        }*/
        this.listHumanAgeDeleted.clear();
        this.listHumanAgeAdd.clear();
    }

    public void removeSymptomStage(List<SymptomStage> list) {
        listSymptomType.forEach((st) -> {
            st.updateSymptomStage(list);
        });
        for (SymptomStage sts : list) {
            if (sts.isIsNew()) {
                if (!sts.isDeleted()) {
                    SymptomStage ss = new SymptomStage(sts.getName(), sts.getDeathPercentage(), sts.getImmunePercentage(), sts.getIndex(), this);
                    this.listSymptomStage1s.add(ss);
                    //this.listAdd.add(ss);
                } else {
                }
            } else {
                for (SymptomStage st : this.listSymptomStage1s) {
                    if (st.getName().equals(sts.getName())) {
                        if (sts.isDeleted()) {
                            st.setDeleted(true);
                            this.listStageDeleted.add(st);
                        } else {
                            st.setIndex(sts.getIndex());
                            st.setSaved(false);
                        }
                    }
                }
            }
        }
        for (SymptomStage st : this.listStageDeleted) {
            this.listSymptomStage1s.remove(st);
        }

        SymptomStage[] tab = new SymptomStage[listSymptomStage1s.size()];
        for (SymptomStage ss : listSymptomStage1s) {
            tab[ss.getIndex()] = ss;
        }

        listSymptomStage1s.clear();

        for (SymptomStage ss : tab) {
            listSymptomStage1s.add(ss);
        }
    }

    public void changeState(int num) {
        this.city.changeState(num);
    }
}
