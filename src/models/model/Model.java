package models.model;

import controller.controllers.ModelController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import models.client.City;
import models.member.Member;
import resources.Messages.Messages;
import views1.MainFrame;
import views1.model.panel.ModelPanel;

public class Model {
    
    private int modelId;
    private String modelName;
    
    private int isMain;
    private int infectedNumber = 0;
    private int runTime = 0;
    
    private String virusName;
    private int contagiousDay;
    
    private boolean saved;
    private boolean newModel;
    private boolean deleted;
    
    private MainFrame mainFrame;
    private ModelPanel modelPanel;
    
    private List<HumanAge> listHumanAge;
    private List<HumanAge> listHumanAgeAdd;
    private List<HumanAge> listHumanAgeDeleted;
    
    private List<SymptomType> listSymptomType;
    private List<SymptomType> listSymptomTypeDeleted;
    
    private List<SymptomStage> listSymptomStage1sNonHospital, listSymptomStage1sHospital;
    private List<SymptomStage> listSympStageNonHosDeleted, listSymptomStagesHosDeleted;
    private List<SymptomStage> listSymptomStagesNonHosAdded, listSymptomStagesHosAdded;
    
    private List<PauseTime> listPauseTime;
    private List<PauseTime> listPauseTimeDeleted;
    
    private City city;
    private JMenuItem mapMenu, populationMenu;
    private JMenuItem runMenu, pauseMenu, stopMenu;
    
    private int totalSick = 0;
    
    private boolean run = false, pause = false, stop = false, firstTimeRun = true, refresh = false, canBuild = true;
    private boolean mainCanCheck = false;
    private boolean mainPause = false;
    
    private List<ResultOfDay> listResult;
    
    private List<Member> listHealth;
    private List<Member> listDeath;
    private List<Member> listImmune;
    
    private int day = 1;
    
    public Model(int modelId, String modelName, int infectedNumber, int runTime, String virusName, int contagiousDay, List<SymptomType> list, List<SymptomStage> listSS, List<HumanAge> listHA, List<PauseTime> listPt) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.virusName = virusName;
        this.contagiousDay = contagiousDay;
        this.infectedNumber = infectedNumber;
        this.runTime = runTime;
        this.listSymptomStage1sHospital = new ArrayList();
        this.listSymptomStage1sNonHospital = new ArrayList();
        this.listPauseTimeDeleted = new ArrayList();
        
        this.listHealth = new ArrayList();
        this.listDeath = new ArrayList();
        this.listImmune = new ArrayList();
        
        this.refresh = false;
        
        this.listResult = new ArrayList();
        this.listSymptomTypeDeleted = new ArrayList();
        this.listHumanAge = listHA;
        this.listPauseTime = listPt;
        this.listSympStageNonHosDeleted = new ArrayList();
        this.listSymptomStagesHosDeleted = new ArrayList();
        this.listSymptomStagesHosAdded = new ArrayList();
        this.listSymptomStagesNonHosAdded = new ArrayList();
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
                generatePopulation();
            }
        });
        
        this.runMenu = new JMenuItem("Run " + this.modelName);
        this.runMenu.setEnabled(false);
        this.runMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isFirstTimeRun()) {
                    city.resume("");
                } else {
                    city.start();
                }
            }
        });
        
        this.pauseMenu = new JMenuItem("Pause " + this.modelName);
        this.pauseMenu.setEnabled(false);
        this.pauseMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city.pause();
            }
        });
        
        this.stopMenu = new JMenuItem("Stop " + this.modelName);
        this.stopMenu.setEnabled(false);
        this.stopMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = JOptionPane.showOptionDialog(modelPanel, Messages.STOPRUNNING, "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
                if (index == JOptionPane.NO_OPTION) {
                    return;
                }
                city.stop();
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
        for (PauseTime pt : this.listPauseTime) {
            pt.setModel(this);
        }
    }
    
    public Model(String name, MainFrame frame, City c) {
        this.modelName = name;
        this.infectedNumber = 0;
        this.runTime = 0;
        this.mainFrame = frame;
        this.virusName = " ";
        this.contagiousDay = 0;
        this.isMain = 1;
        
        this.refresh = false;
        
        this.listResult = new ArrayList();
        
        this.listSymptomStage1sHospital = new ArrayList();
        this.listSymptomStage1sNonHospital = new ArrayList();
        this.listSympStageNonHosDeleted = new ArrayList();
        this.listSymptomStagesHosDeleted = new ArrayList();
        this.listSymptomStagesHosAdded = new ArrayList();
        this.listSymptomStagesNonHosAdded = new ArrayList();
        this.listSymptomTypeDeleted = new ArrayList();
        this.listPauseTime = new ArrayList();
        this.listPauseTimeDeleted = new ArrayList();
        
        this.listHealth = new ArrayList();
        this.listDeath = new ArrayList();
        this.listImmune = new ArrayList();
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
                generatePopulation();
            }
        });
        
        this.runMenu = new JMenuItem("Run " + this.modelName);
        this.runMenu.setEnabled(false);
        this.runMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isFirstTimeRun()) {
                    city.resume("");
                } else {
                    city.start();
                }
            }
        });
        
        this.pauseMenu = new JMenuItem("Pause " + this.modelName);
        this.pauseMenu.setEnabled(false);
        this.pauseMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city.pause();
            }
        });
        
        this.stopMenu = new JMenuItem("Stop " + this.modelName);
        this.stopMenu.setEnabled(false);
        this.stopMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = JOptionPane.showOptionDialog(modelPanel, Messages.STOPRUNNING, "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
                if (index == JOptionPane.NO_OPTION) {
                    return;
                }
                city.stop();
            }
        });
        
        this.listHumanAge = new ArrayList();
        this.listHumanAgeAdd = new ArrayList();
        this.listHumanAgeDeleted = new ArrayList();
        
        this.listSymptomType = new ArrayList();
        
        int i = 1;
        for (SymptomStageName stn : this.mainFrame.getListSymptomStageNames()) {
            SymptomStage stgn = new SymptomStage(stn.getName(), 0.0, 0.0, i, stn.getInHospital(), this);
            if (stgn.getInHospital() == 0) {
                this.listSymptomStage1sNonHospital.add(stgn);
            } else {
                this.listSymptomStage1sHospital.add(stgn);
            }
            i++;
        }
        for (SymptomName sn : this.mainFrame.getListSymptomName()) {
            SymptomType st1 = new SymptomType(sn.getName(), this.listSymptomStage1sHospital, this.listSymptomStage1sNonHospital, this);
            this.listSymptomType.add(st1);
        }
        for (HumanAgeName hu : this.mainFrame.getListHumanAgeName()) {
            HumanAge hum = new HumanAge(hu.getName(), hu.getMinAge(), hu.getMaxAge(), this.listSymptomType, this);
            this.listHumanAge.add(hum);
        }
        
    }
    
    public Model(Model model, String name) {
        this.modelName = name;
        this.virusName = model.getVirusName();
        this.contagiousDay = model.getContagiousDay();
        this.infectedNumber = model.getInfectedNumber();
        this.runTime = model.getRunTime();
        this.listSymptomStage1sHospital = new ArrayList();
        this.listSymptomStage1sNonHospital = new ArrayList();
        
        this.listPauseTime = new ArrayList();
        this.listPauseTimeDeleted = new ArrayList();
        
        this.listHealth = new ArrayList();
        this.listDeath = new ArrayList();
        this.listImmune = new ArrayList();
        
        this.refresh = false;
        
        this.listResult = new ArrayList();
        this.listSymptomTypeDeleted = new ArrayList();
        
        for (SymptomStage ss : model.getListSymptomStage1sNonHospital()) {
            SymptomStage newSS = new SymptomStage(ss.getName(), ss.getDeathPercentage(), ss.getImmunePercentage(), ss.getIndex(), 0, this);
            this.listSymptomStage1sNonHospital.add(newSS);
        }
        for (SymptomStage ss : model.getListSymptomStage1sHospital()) {
            SymptomStage newSS = new SymptomStage(ss.getName(), ss.getDeathPercentage(), ss.getImmunePercentage(), ss.getIndex(), 1, this);
            this.listSymptomStage1sHospital.add(newSS);
        }
        
        this.listSymptomType = new ArrayList();
        for (SymptomType st : model.getListSymptomType()) {
            SymptomType newSt = new SymptomType(st, this);
            this.listSymptomType.add(newSt);
        }
        
        this.listHumanAge = new ArrayList();
        for (HumanAge ha : model.getListHumanAge()) {
            HumanAge newAge = new HumanAge(ha, this);
            this.listHumanAge.add(newAge);
        }
        
        for (PauseTime pt : model.getListPauseTime()) {
            PauseTime newPt = new PauseTime(pt.getDays(), this);
            this.listPauseTime.add(newPt);
        }
        
        this.listSympStageNonHosDeleted = new ArrayList();
        this.listSymptomStagesHosDeleted = new ArrayList();
        this.listSymptomStagesHosAdded = new ArrayList();
        this.listSymptomStagesNonHosAdded = new ArrayList();
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
                generatePopulation();
            }
        });
        
        this.runMenu = new JMenuItem("Run " + this.modelName);
        this.runMenu.setEnabled(false);
        this.runMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isFirstTimeRun()) {
                    city.resume("");
                } else {
                    city.start();
                }
            }
        });
        
        this.pauseMenu = new JMenuItem("Pause " + this.modelName);
        this.pauseMenu.setEnabled(false);
        this.pauseMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city.pause();
            }
        });
        
        this.stopMenu = new JMenuItem("Stop " + this.modelName);
        this.stopMenu.setEnabled(false);
        this.stopMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = JOptionPane.showOptionDialog(modelPanel, Messages.STOPRUNNING, "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
                if (index == JOptionPane.NO_OPTION) {
                    return;
                }
                city.stop();
            }
        });
        this.newModel = true;
        this.saved = false;
        this.deleted = false;
    }
    
    public void generatePopulation() {
        city.initPopulation();
        this.totalSick = this.infectedNumber;
        runMenu.setEnabled(true);
        if (mainFrame.getCurrentModel() == this) {
            mainFrame.getRunButton().setEnabled(true);
        }
        if (!city.getListMember().isEmpty()) {
            double per = this.infectedNumber * 100 / city.getListMember().size();
            this.modelPanel.getPercentageOfSickHumanTxt().setText(per + "");
            this.modelPanel.getPercentageOfSickHumanTxt().setVisible(true);
        }
    }
    
    public boolean isMainPause() {
        return mainPause;
    }
    
    public void setMainPause(boolean mainPause) {
        this.mainPause = mainPause;
    }
    
    public List<ResultOfDay> getListResult() {
        return listResult;
    }
    
    public void setListResult(List<ResultOfDay> listResult) {
        this.listResult = listResult;
    }
    
    public boolean isFirstTimeRun() {
        return firstTimeRun;
    }
    
    public List<HumanAge> getListHumanAgeAdd() {
        return listHumanAgeAdd;
    }
    
    public void setListHumanAgeAdd(List<HumanAge> listHumanAgeAdd) {
        this.listHumanAgeAdd = listHumanAgeAdd;
    }
    
    public List<PauseTime> getListPauseTime() {
        return listPauseTime;
    }
    
    public void setListPauseTime(List<PauseTime> listPauseTime) {
        this.listPauseTime = listPauseTime;
    }
    
    public List<PauseTime> getListPauseTimeDeleted() {
        return listPauseTimeDeleted;
    }
    
    public void setListPauseTimeDeleted(List<PauseTime> listPauseTimeDeleted) {
        this.listPauseTimeDeleted = listPauseTimeDeleted;
    }
    
    public void setFirstTimeRun(boolean firstTimeRun) {
        this.firstTimeRun = firstTimeRun;
    }
    
    public String getVirusName() {
        return virusName;
    }
    
    public void setVirusName(String virusName) {
        this.virusName = virusName;
    }
    
    public int getContagiousDay() {
        return contagiousDay;
    }
    
    public void setContagiousDay(int contagiousDay) {
        this.contagiousDay = contagiousDay;
    }
    
    public int getRunTime() {
        return runTime;
    }
    
    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }
    
    public void generateMapLocation() {
        this.city.generateMapLocation();
    }
    
    public JMenuItem getStopMenu() {
        return stopMenu;
    }
    
    public int getDay() {
        return day;
    }
    
    public void setDay(int day) {
        this.day = day;
    }
    
    public void incrementDay() {
        this.day++;
        this.modelPanel.getStatistiquePane().getChart().checkValue();
    }
    
    public List<SymptomType> getListSymptomTypeDeleted() {
        return listSymptomTypeDeleted;
    }
    
    public boolean isCanBuild() {
        return canBuild;
    }
    
    public void setCanBuild(boolean canBuild) {
        this.canBuild = canBuild;
    }
    
    public int getInfectedNumber() {
        return infectedNumber;
    }
    
    public boolean isRefresh() {
        return refresh;
    }
    
    public void setRefresh(boolean refresh) {
        this.refresh = refresh;
    }
    
    public void setInfectedNumber(int infectedNumber) {
        this.infectedNumber = infectedNumber;
    }
    
    public List<Member> getListHealth() {
        return listHealth;
    }
    
    public List<Member> getListDeath() {
        return listDeath;
    }
    
    public List<Member> getListImmune() {
        return listImmune;
    }
    
    public void setListSymptomTypeDeleted(List<SymptomType> listSymptomTypeDeleted) {
        this.listSymptomTypeDeleted = listSymptomTypeDeleted;
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
        City newCity = null;
        try {
            newCity = (City) c.clone();
            this.city = newCity;
            newCity.setModel(this);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
                System.out.println("save");
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
        
        for (SymptomType st : this.listSymptomTypeDeleted) {
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
        
        for (PauseTime pt : this.listPauseTime) {
            pt.setModel(this);
            pt.save();
        }
        for (PauseTime pt : this.listPauseTimeDeleted) {
            pt.setModel(this);
            pt.save();
        }
        this.listHumanAgeDeleted.clear();
        this.listHumanAgeAdd.clear();
        this.listPauseTimeDeleted.clear();
    }
    
    public int getTotalSick() {
        return totalSick;
    }
    
    public void setTotalSick(int totalSick) {
        this.totalSick = totalSick;
    }
    
    public void refresh() {
        this.listHealth.clear();
        this.totalSick = 0;
        this.day = 1;
        this.listDeath.clear();
        this.listImmune.clear();
        this.listResult.clear();
        this.listSymptomStage1sHospital.forEach((st) -> {
            st.getListMember().clear();
        });
        this.listSymptomStage1sNonHospital.forEach((st) -> {
            st.getListMember().clear();
        });
        this.listPauseTime.forEach((pt) -> {
            pt.setHasBeenChecked(false);
        });
        run = false;
        pause = false;
        stop = false;
        firstTimeRun = true;
        refresh = false;
        canBuild = true;
        this.mainFrame.getRunButton().setEnabled(true);
        this.mainFrame.getBuildButton().setEnabled(true);
        this.runMenu.setEnabled(true);
        this.populationMenu.setEnabled(true);
        this.city.refresh();
        this.totalSick = this.infectedNumber;
        this.changeState(this.infectedNumber);
        this.setEnable();
        this.modelPanel.setEnable();
        this.getModelPanel().getStatistiquePane().updateState();
        this.getModelPanel().getStatistiquePane().updateTime(this.city.getWeek());
        this.getModelPanel().getStatistiquePane().getChart().init();
    }
    
    public void addNewHumanAge() {
        HumanAge age = new HumanAge("Invalid", -1, -1, this.getListSymptomType(), this);
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
        
        this.listSymptomType.stream().map((st) -> {
            st.addSymptomStage(new SymptomStageType(st, ss, 0, this));
            return st;
        }).forEachOrdered((st) -> {
            st.reintSymptomStagePanel();
        });
        
        this.modelPanel.reinitPanel();
        this.modelPanel.reinitSymptomPanel();
        this.mainFrame.setModelSavedButtonEnable();
    }
    
    public void addNewSymptom(String name) {
        SymptomType st = new SymptomType(name, listSymptomStage1sHospital, listSymptomStage1sNonHospital, this);
        this.listSymptomType.add(st);
        this.listHumanAge.forEach((ha) -> {
            ha.addSymptomType(st);
        });
        this.modelPanel.reinitPanel();
        this.modelPanel.reinitAgePanel();
        this.mainFrame.setModelSavedButtonEnable();
    }
    
    public void changeState(int num) {
        this.city.changeState(this.infectedNumber);
    }
    
    public void setEnable() {
        this.listHumanAge.forEach((ha) -> {
            ha.setEnable();
        });
        this.listSymptomType.forEach((st) -> {
            st.setEnable();
        });
        this.listSymptomStage1sHospital.forEach((ss) -> {
            ss.setEnable();
        });
        this.listSymptomStage1sNonHospital.forEach((ss) -> {
            ss.setEnable();
        });
        this.listPauseTime.forEach((pt) -> {
            pt.setEnable();
        });
    }
    
    public void setDisable() {
        this.listHumanAge.forEach((ha) -> {
            ha.setDisable();
        });
        this.listSymptomType.forEach((st) -> {
            st.setDisable();
        });
        this.listSymptomStage1sHospital.forEach((ss) -> {
            ss.setDisable();
        });
        this.listSymptomStage1sNonHospital.forEach((ss) -> {
            ss.setDisable();
        });
        this.listPauseTime.forEach((pt) -> {
            pt.setDisable();
        });
    }
    
    public boolean isMainCanCheck() {
        return mainCanCheck;
    }
    
    public void setMainCanCheck(boolean mainCanCheck) {
        this.mainCanCheck = mainCanCheck;
    }
    
    public SymptomType getSymptomType(int age) {
        for (HumanAge ha : getListHumanAge()) {
            if (ha.isMinAgeValid() && ha.isMaxAgeValid()) {
                if (age >= ha.getMinAge() && age <= ha.getMaxAge()) {
                    return ha.monteCarlo();
                }
            }
        }
        return null;
    }
}
