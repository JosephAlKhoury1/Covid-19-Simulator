package models.model;

import controller.controllers.ModelController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import models.client1.City;
import views1.MainFrame;
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

    private List<SymptomStage> listSymptomStage1sNonHospital, listSymptomStage1sHospital;
    private List<SymptomStage> listSympStageNonHosDeleted, listSymptomStagesHosDeleted;
    private List<SymptomStage> listSymptomStagesNonHosAdded, listSymptomStagesHosAdded;

    private City city;
    private JMenuItem mapMenu, runMenu, pauseMenu, populationMenu;

    private boolean run = false, pause = false, stop = false;

    public Model(int modelId, String modelName, List<SymptomType> list, List<SymptomStage> listSS, List<HumanAge> listHA) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.listSymptomStage1sHospital = new ArrayList();
        this.listSymptomStage1sNonHospital = new ArrayList();
        this.listHumanAge = listHA;
        this.listSympStageNonHosDeleted = new ArrayList();
        this.listSymptomStagesHosDeleted = new ArrayList();
        this.listSymptomStagesHosAdded = new ArrayList();
        this.listSymptomStagesNonHosAdded = new ArrayList();
        //this.listSymptomStage1s = listSS;
        for (SymptomStage ss : listSS) {
            if (ss.getInHospital() == 0) {
                this.listSymptomStage1sNonHospital.add(ss);
            } else {
                this.listSymptomStage1sHospital.add(ss);
            }
        }
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
                modelPanel.setDisable();
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

        for (SymptomType st : list) {
            st.setModel(this);
        }
        for (HumanAge ha : listHA) {
            ha.setModel(this);
        }
        for (SymptomStage sta : listSS) {
            sta.setModel(this);
        }
    }

    public Model(String name, MainFrame frame, City c) {
        this.modelName = name;
        this.mainFrame = frame;
        this.isMain = 1;
        this.listSymptomStage1sHospital = new ArrayList();
        this.listSymptomStage1sNonHospital = new ArrayList();
        this.listSympStageNonHosDeleted = new ArrayList();
        this.listSymptomStagesHosDeleted = new ArrayList();
        this.listSymptomStagesHosAdded = new ArrayList();
        this.listSymptomStagesNonHosAdded = new ArrayList();
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
                setRun(true);
                setPause(false);
                mainFrame.getRunButton().setEnabled(false);
                mainFrame.getPauseButton().setEnabled(true);
                modelPanel.setDisable();
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

        this.listHumanAge = new ArrayList();
        this.listHumanAgeAdd = new ArrayList();
        this.listHumanAgeDeleted = new ArrayList();

        this.listSymptomType = new ArrayList();

        int i = 1;
        for (SymptomStageName stn : this.mainFrame.getListSymptomStageNames()) {
            SymptomStage stgn = new SymptomStage(stn.getName(), 0.0, 0.0, i, stn.getInHospital(), this);
            //this.listSymptomStage1s.add(stgn);
            if (stgn.getInHospital() == 0) {
                this.listSymptomStage1sNonHospital.add(stgn);
            } else {
                this.listSymptomStage1sHospital.add(stgn);
            }
            i++;
        }
        for (SymptomName sn : this.mainFrame.getListSymptomName()) {
            SymptomType st1 = new SymptomType(sn.getName(), 0, this.mainFrame.getListSymptomStageNames(), this.listSymptomStage1sHospital, this.listSymptomStage1sNonHospital, this);
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

    public List<SymptomStage> getListSymptomStage1sNonHospital() {
        return listSymptomStage1sNonHospital;
    }

    public void setListSymptomStage1sNonHospital(List<SymptomStage> listSymptomStage1sNonHospital) {
        this.listSymptomStage1sNonHospital = listSymptomStage1sNonHospital;
    }

    public List<SymptomStage> getListSympStageNonHosDeleted() {
        return listSympStageNonHosDeleted;
    }

    public List<SymptomStage> getListSymptomStagesNonHosAdded() {
        return listSymptomStagesNonHosAdded;
    }

    public void setListSymptomStagesNonHosAdded(List<SymptomStage> listSymptomStagesNonHosAdded) {
        this.listSymptomStagesNonHosAdded = listSymptomStagesNonHosAdded;
    }

    public List<SymptomStage> getListSymptomStagesHosAdded() {
        return listSymptomStagesHosAdded;
    }

    public void setListSymptomStagesHosAdded(List<SymptomStage> listSymptomStagesHosAdded) {
        this.listSymptomStagesHosAdded = listSymptomStagesHosAdded;
    }

    public void setListSympStageNonHosDeleted(List<SymptomStage> listSympStageNonHosDeleted) {
        this.listSympStageNonHosDeleted = listSympStageNonHosDeleted;
    }

    public List<SymptomStage> getListSymptomStagesHosDeleted() {
        return listSymptomStagesHosDeleted;
    }

    public void setListSymptomStagesHosDeleted(List<SymptomStage> listSymptomStagesHosDeleted) {
        this.listSymptomStagesHosDeleted = listSymptomStagesHosDeleted;
    }

    public List<SymptomStage> getListSymptomStage1sHospital() {
        return listSymptomStage1sHospital;
    }

    public void setListSymptomStage1sHospital(List<SymptomStage> listSymptomStage1sHospital) {
        this.listSymptomStage1sHospital = listSymptomStage1sHospital;
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

    public List<HumanAge> getListHumanAgeDeleted() {
        return listHumanAgeDeleted;
    }

    public void setListHumanAgeDeleted(List<HumanAge> listHumanAgeDeleted) {
        this.listHumanAgeDeleted = listHumanAgeDeleted;
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

        for (SymptomStage stage : this.listSymptomStage1sHospital) {
            stage.setModel(this);
            stage.save1();
        }

        for (SymptomStage stage : this.listSymptomStage1sNonHospital) {
            stage.setModel(this);
            stage.save1();
        }

        for (SymptomStage stage : this.listSympStageNonHosDeleted) {
            stage.setModel(this);
            stage.save1();
        }
        this.listSympStageNonHosDeleted.clear();

        for (SymptomStage stage : this.listSymptomStagesHosDeleted) {
            stage.setModel(this);
            stage.save1();
        }
        this.listSymptomStagesHosDeleted.clear();

        for (SymptomType st : this.listSymptomType) {
            st.setModel(this);
            st.save();
        }
        for (HumanAge ha : this.listHumanAge) {
            ha.setModel(this);
            ha.save();
        }

        for (HumanAge ha : this.listHumanAgeDeleted) {
            ha.setModel(this);
            ha.save();
        }

        this.listHumanAgeDeleted.clear();
        this.listHumanAgeAdd.clear();
    }

    /* public void removeSymptomStage(List<SymptomStage> list) {
        listSymptomType.forEach((st) -> {
            st.updateSymptomStage(list);
        });
        for (SymptomStage sts : list) {
            if (sts.isIsNew()) {
                if (!sts.isDeleted()) {
                    SymptomStage ss = new SymptomStage(sts.getName(), sts.getDeathPercentage(), sts.getImmunePercentage(), sts.getIndex(), sts.getInHospital(), this);
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
    }*/
    public void addNewHumanAge() {
        HumanAge age = new HumanAge("between 999 and 1000", 999, 1000, this.getListSymptomType(), this);
        this.listHumanAge.add(age);
        this.mainFrame.setModelSavedButtonEnable();
        this.modelPanel.reinitAgePanel();
    }

    public void addNewSymptomStage(SymptomStage ss) {
        if (ss.getInHospital() == 0) {
            this.listSymptomStage1sNonHospital.add(ss);
        } else {
            this.listSymptomStage1sHospital.add(ss);
        }

        for (SymptomType st : this.listSymptomType) {
            st.getListSage().add(new SymptomStageType(st, ss, 0, 0.0, this));
            st.reintSymptomStagePanel();
        }

        this.modelPanel.reinitPanel();
        this.modelPanel.reinitSymptomPanel();
        this.mainFrame.setModelSavedButtonEnable();
    }

    public void changeState(int num) {
        this.city.changeState(num);
    }

    public void setEnable() {
        for (HumanAge ha : this.listHumanAge) {
            ha.setEnable();
        }
        for (SymptomType st : this.listSymptomType) {
            st.setEnable();
        }
        for (SymptomStage ss : this.listSymptomStage1sHospital) {
            ss.setEnable();
        }
        for (SymptomStage ss : this.listSymptomStage1sNonHospital) {
            ss.setEnable();
        }
    }

    public void setDisable() {
        for (HumanAge ha : this.listHumanAge) {
            ha.setDisable();
        }
        for (SymptomType st : this.listSymptomType) {
            st.setDisable();
        }
        for (SymptomStage ss : this.listSymptomStage1sHospital) {
            ss.setDisable();
        }
        for (SymptomStage ss : this.listSymptomStage1sNonHospital) {
            ss.setDisable();
        }
    }
}
