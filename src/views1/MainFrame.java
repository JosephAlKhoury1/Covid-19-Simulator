package views1;

import controller.controllers.HumanAgeNameController;
import controller.controllers.HumanStateNameController;
import views1.model.panel.ModelPanel;
import controller.controllers.ModelController;
import controller.controllers.ReligionNameController;
import controller.controllers.SymptomNameController;
import controller.controllers.SymptomStageNameController;
import controller.locationController.CityController;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import models.client1.City;
import models.model.HumanAgeName;
import models.model.HumanStatName;
import models.model.Model;
import models.model.ReligionName;
import models.model.SymptomName;
import models.model.SymptomStageName;
import views.dialog1.LoadCityDialog;
import views.dialog1.NewCityDialog;
import views1.model.dialog.NewModelDialog;
import views1.model.dialog.ManageHumanAgeDialog;
import views1.model.dialog.ManageHumanStateDialog;
import views1.model.dialog.ManageReligionDialog;
import views1.model.dialog.ManageSymptomStageDialog;
import views1.model.dialog.ManageSymptomTypeDialog;

public class MainFrame extends JFrame {

    private City currentCity;
    private Model currentModel;
    private ModelPanel currentModelPanel;
    private Maps currentMap;
    private CityPanel currentCityPanel;
    private final List<ModelPanel> listModelPanel;
    private List<Model> listModel;
    public LocationListPanel locationListPanel;

    private List<SymptomName> listSymptomName;
    private List<SymptomStageName> listSymptomStageNames;
    private List<HumanStatName> listHumanStatName;
    private List<HumanAgeName> listHumanAgeName;
    private List<ReligionName> listReligionName;
    private String[] humanStatTab;

    public MainFrame() {
        this.listModelPanel = new ArrayList();
        this.listModel = new ArrayList();
        this.listSymptomName = SymptomNameController.INSTANCE.selectAll();
        this.listSymptomStageNames = SymptomStageNameController.INSTANCE.selectAll();
        this.listHumanStatName = HumanStateNameController.INSTANCE.selectAll();
        this.listHumanAgeName = HumanAgeNameController.INSTANCE.selectAll();
        this.listReligionName = ReligionNameController.INSTANCE.selectAll();
        this.humanStatTab = new String[this.listHumanStatName.size()];
        for (int i = 0; i < this.listHumanStatName.size(); i++) {
            this.humanStatTab[i] = this.listHumanStatName.get(i).getName();
        }
        initComponents();
        this.statistiquePanel.setLayout(new BoxLayout(this.statistiquePanel, BoxLayout.Y_AXIS));
        this.locationPanel.setLayout(new BorderLayout());
        this.jTabbedPane2.removeTabAt(0);
        this.currentCity = CityController.INSTANCE.getMainCity(1);
        if (this.currentCity != null) {
            this.currentCityPanel = new CityPanel(this, this.jTabbedPane2, this.currentCity);
            this.currentCity.setCityPanel(currentCityPanel);
            this.jTabbedPane2.addTab(this.currentCity.getName(), this.currentCityPanel);
            this.jTabbedPane2.setTabComponentAt(this.jTabbedPane2.getTabCount() - 1, this.currentCityPanel.getButton());
            this.locationListPanel = this.currentCityPanel.getCurrentLocationListPanel();
            this.locationPanel.removeAll();
            this.locationListPanel.setSize(this.locationPanel.getSize());
            this.locationPanel.add(this.locationListPanel);

//            this.generateLocationMenu.add(this.currentCity.getMapMenu());
//            this.generateLocationMenu.add(this.currentCity.getSeparator());
//
//            this.runMenu.add(this.currentCity.getRunMenu());
//            this.runMenu.add(this.currentCity.getRunSeparator());
//
//            this.pauseMenu.add(this.currentCity.getPauseMenu());
//            this.pauseMenu.add(this.currentCity.getPauseSeparator());
//
//            this.generatePopulationMenu.add(this.currentCity.getPopulationMenu());
//            this.generatePopulationMenu.add(this.currentCity.getSeparatorPopulation());
        } else {
            this.generateLocationMenu.setEnabled(false);
        }
        this.listModel = ModelController.INSTANCE.selectAllMain();
        for (Model m : this.listModel) {
            this.currentModel = m;
            City newCity = null;
            try {
                if (this.currentCity != null) {
                    newCity = (City) this.currentCity.clone();
                    this.currentModel.setCity(newCity);
                    newCity.setModel(this.currentModel);
                    //this.statistiquePanel.add(newCity.getStatistiquePanel());
                }
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.currentModel.setMainFrame(this);
            this.currentModelPanel = new ModelPanel(this, this.currentModel, this.jTabbedPane2);

            this.currentModelPanel.getStatistiquePanel().add(newCity.getStatistiquePanel());

            this.jTabbedPane2.addTab(this.currentModel.getModelName(), this.currentModelPanel);
            this.jTabbedPane2.setTabComponentAt(this.jTabbedPane2.getTabCount() - 1, this.currentModelPanel.getButton());
            this.listModelPanel.add(this.currentModelPanel);

            this.generateLocationMenu.add(m.getMapMenu());

            this.generatePopulationMenu.add(m.getPopulationMenu());

            this.runMenu.add(m.getRunMenu());
            this.pauseMenu.add(m.getPauseMenu());
        }
    }

    public String[] getHumanStatTab() {
        return humanStatTab;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public void setHumanStatTab(String[] humanStatTab) {
        this.humanStatTab = humanStatTab;
    }

    public List<ReligionName> getListReligionName() {
        return listReligionName;
    }

    public void setListReligionName(List<ReligionName> listReligionName) {
        this.listReligionName = listReligionName;
    }

    public List<SymptomName> getListSymptomName() {
        return listSymptomName;
    }

    public void setListSymptomName(List<SymptomName> listSymptomName) {
        this.listSymptomName = listSymptomName;
    }

    public List<SymptomStageName> getListSymptomStageNames() {
        return listSymptomStageNames;
    }

    public ModelPanel getCurrentModelPanel() {
        return currentModelPanel;
    }

    public void setCurrentModelPanel(ModelPanel currentModelPanel) {
        this.currentModelPanel = currentModelPanel;
    }

    public void setListSymptomStageNames(List<SymptomStageName> listSymptomStageNames) {
        this.listSymptomStageNames = listSymptomStageNames;
    }

    public CityPanel getCurrentCityPanel() {
        return currentCityPanel;
    }

    public void setCurrentCityPanel(CityPanel currentCityPanel) {
        this.currentCityPanel = currentCityPanel;
    }

    public JPanel getLocationPanel() {
        return locationPanel;
    }

    public void setLocationPanel(JPanel locationPanel) {
        this.locationPanel = locationPanel;
    }

    public void loadCity(int cityId) {
        if (this.currentCity != null) {
            CityController.INSTANCE.setCityNonMain(this.currentCity.getId());
        }
        this.currentCity = CityController.INSTANCE.select(cityId);
        this.currentCity.setIsMain(1);
        this.generateLocationMenu.removeAll();
        this.runMenu.removeAll();
        this.pauseMenu.removeAll();
        if (this.currentCityPanel != null) {
            this.jTabbedPane2.removeTabAt(this.jTabbedPane2.indexOfComponent(this.currentCityPanel));
        }
        if (this.currentMap != null) {
            this.jTabbedPane2.removeTabAt(this.jTabbedPane2.indexOfComponent(this.currentMap.getScrollPane()));
        }
        this.currentCityPanel = new CityPanel(this, jTabbedPane2, this.currentCity);
        this.currentCity = this.currentCityPanel.getCity1();
        this.locationListPanel = this.currentCityPanel.getCurrentLocationListPanel();

        this.generateLocationMenu.add(this.currentCity.getMapMenu());
        this.generateLocationMenu.add(this.currentCity.getSeparator());

//        this.runMenu.add(this.currentCity.getRunMenu());
//        this.runMenu.add(this.currentCity.getRunSeparator());
//
//        this.pauseMenu.add(this.currentCity.getPauseMenu());
//        this.pauseMenu.add(this.currentCity.getPauseSeparator());
        this.jTabbedPane2.addTab(this.currentCity.getName(), this.currentCityPanel);
        this.jTabbedPane2.setTabComponentAt(0, this.currentCityPanel.getButton());
        /*for (ModelPanel mp : this.listModelPanel) {
            this.jTabbedPane2.addTab("", mp);
            this.jTabbedPane2.setTabComponentAt(this.jTabbedPane2.getTabCount() - 1, mp.getButton());
        }*/
        for (Model m : this.listModel) {
            m.setCity(this.currentCity);
        }
        this.locationPanel.removeAll();
        this.locationListPanel.setSize(this.locationPanel.getSize());
        this.locationPanel.add(this.locationListPanel);
        this.repaint();
    }

    public void newModel(String name) {
        City c = null;
        if (this.currentCity != null) {
            try {
                c = (City) this.currentCity.clone();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.currentModelPanel = new ModelPanel(this, name, this.jTabbedPane2, c);
        this.currentModel = this.currentModelPanel.getModel();
        this.generateLocationMenu.add(this.currentModel.getMapMenu());
        this.generatePopulationMenu.add(this.currentModel.getPopulationMenu());
        this.runMenu.add(this.currentModel.getRunMenu());
        this.pauseMenu.add(this.currentModel.getPauseMenu());

        this.listModel.add(this.currentModel);
        this.listModelPanel.add(this.currentModelPanel);
        this.currentModel.save();
        this.jTabbedPane2.addTab(this.currentModel.getModelName(), this.currentModelPanel);
        this.jTabbedPane2.setTabComponentAt(this.jTabbedPane2.getTabCount() - 1, this.currentModelPanel.getButton());
        this.repaint();
    }

    public void newCity(String name) {
        if (this.currentCity != null) {
            CityController.INSTANCE.setCityNonMain(this.currentCity.getId());
        }
        if (this.currentMap != null) {
            this.jTabbedPane2.removeTabAt(this.jTabbedPane2.indexOfComponent(this.currentMap.getScrollPane()));
        }
        if (this.currentCityPanel != null) {
            this.jTabbedPane2.removeTabAt(this.jTabbedPane2.indexOfComponent(this.currentCityPanel));
        }
        this.generateLocationMenu.removeAll();
        this.runMenu.removeAll();
        this.pauseMenu.removeAll();

        this.currentCityPanel = new CityPanel(this, jTabbedPane2, name);
        this.currentCity = this.currentCityPanel.getCity1();
        this.locationListPanel = this.currentCityPanel.getCurrentLocationListPanel();
        this.currentCity.save();

        this.generateLocationMenu.add(this.currentCity.getMapMenu(), 0);
        this.generateLocationMenu.add(this.currentCity.getSeparator(), 1);

//        this.runMenu.add(this.currentCity.getRunMenu());
//        this.runMenu.add(this.currentCity.getRunSeparator());
//
//        this.pauseMenu.add(this.currentCity.getPauseMenu());
//        this.pauseMenu.add(this.currentCity.getPauseSeparator());
        this.jTabbedPane2.addTab(this.currentCity.getName(), this.currentCityPanel);
        this.jTabbedPane2.setTabComponentAt(0, this.currentCityPanel.getButton());

        for (Model m : this.listModel) {
            m.setCity(this.currentCity);
        }
        this.locationPanel.removeAll();
        this.locationListPanel.setSize(this.locationPanel.getSize());
        this.locationPanel.add(this.locationListPanel);
        this.repaint();
    }

    public void closeModel(Model m) {
        String ti = "Save Model";
        String message = "Would you like to save the model before closing?";
        if (m.isNewModel() || !m.isSaved()) {
            int reply = JOptionPane.showConfirmDialog(this, message, ti, JOptionPane.YES_NO_CANCEL_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                m.save();
            } else if (reply == JOptionPane.NO_OPTION) {
            }
        }
        if (currentModel == m) {
            int index = this.listModel.indexOf(m);
            if (index == 0) {
                if (this.listModel.size() > 1) {
                    this.currentModel = this.listModel.get(index + 1);
                    this.currentModelPanel = this.currentModel.getModelPanel();
                    if (!this.currentModel.isSaved()) {
                        this.setModelSavedButtonEnable();
                    } else {
                        this.setModelSavedButtonDisable();
                    }
                } else {
                    this.currentModel = null;
                    this.currentModelPanel = null;
                    this.setModelSavedButtonDisable();
                }
            } else {
                this.currentModel = this.listModel.get(index - 1);
                this.currentModelPanel = this.currentModel.getModelPanel();
                if (!this.currentModel.isSaved()) {
                    this.setModelSavedButtonEnable();
                } else {
                    this.setModelSavedButtonDisable();
                }
            }
        } else {

        }
        this.listModel.remove(m);
        this.listModelPanel.remove(m.getModelPanel());
        ModelController.INSTANCE.setModelNonMain(m.getModelId());
    }

    public Model getCurrentModel() {
        return currentModel;
    }

    public void setCurrentModel(Model currentModel) {
        this.currentModel = currentModel;
    }

    public void removeGenerateLocationMenu(JMenuItem j) {
        this.generateLocationMenu.remove(j);
        this.generateLocationMenu.revalidate();
    }

    public void removeRunMenu(JMenuItem j) {
        this.runMenu.remove(j);
        this.runMenu.revalidate();
    }

    public void removePauseMenu(JMenuItem j) {
        this.pauseMenu.remove(j);
        this.pauseMenu.revalidate();
    }

    /*public JTabbedPane getjTabbedPane2() {
        return jTabbedPane2;
    }*/
    public void setjTabbedPane2(JTabbedPane jTabbedPane2) {
        this.jTabbedPane2 = jTabbedPane2;
    }

    public List<HumanStatName> getListHumanStatName() {
        return listHumanStatName;
    }

    public void setListHumanStatName(List<HumanStatName> listHumanStatName) {
        this.listHumanStatName = listHumanStatName;
    }

    public List<Model> getListModel() {
        return listModel;
    }

    public void setListModel(List<Model> listModel) {
        this.listModel = listModel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        locationPanel = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        statistiquePanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        newModelButton = new javax.swing.JButton();
        newCityButton = new javax.swing.JButton();
        loadModelButton = new javax.swing.JButton();
        loadCityButton = new javax.swing.JButton();
        saveModelButton = new javax.swing.JButton();
        saveCityButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        runButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        RefleshButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newModelMenuItem = new javax.swing.JMenuItem();
        newCityMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        loadModelMenuItm = new javax.swing.JMenuItem();
        loadCityMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        saveModelMenuItem = new javax.swing.JMenuItem();
        saveCityMenuItm = new javax.swing.JMenuItem();
        saveAsModelMenuItem = new javax.swing.JMenuItem();
        saveAsCityMenuItem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        generateLocationMenu = new javax.swing.JMenu();
        generatePopulationMenu = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        runMenuItem = new javax.swing.JMenuItem();
        runMenu = new javax.swing.JMenu();
        pauseMenu = new javax.swing.JMenu();
        pauseMenuItem = new javax.swing.JMenuItem();
        continueMenuItem = new javax.swing.JMenu();
        stopMenuItem = new javax.swing.JMenuItem();
        toolsMenu = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        agePercentageMenu = new javax.swing.JCheckBoxMenuItem();
        goSchoolPercentageMenu = new javax.swing.JCheckBoxMenuItem();
        goUniversityPercentageMenu = new javax.swing.JCheckBoxMenuItem();
        goWorkPercentageMenu = new javax.swing.JCheckBoxMenuItem();
        houseReligionDistributionMenu = new javax.swing.JCheckBoxMenuItem();
        housePopulationDistributionMenu = new javax.swing.JCheckBoxMenuItem();
        sexeDistributionMenu = new javax.swing.JCheckBoxMenuItem();
        jMenu5 = new javax.swing.JMenu();
        symptomMenu = new javax.swing.JMenuItem();
        symptomStageMenu = new javax.swing.JMenuItem();
        humanStateMenu = new javax.swing.JMenuItem();
        ageMenu = new javax.swing.JMenuItem();
        religionMenuItem = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        locationPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout locationPanelLayout = new javax.swing.GroupLayout(locationPanel);
        locationPanel.setLayout(locationPanelLayout);
        locationPanelLayout.setHorizontalGroup(
            locationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        locationPanelLayout.setVerticalGroup(
            locationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        jTabbedPane2.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane2StateChanged(evt);
            }
        });

        javax.swing.GroupLayout statistiquePanelLayout = new javax.swing.GroupLayout(statistiquePanel);
        statistiquePanel.setLayout(statistiquePanelLayout);
        statistiquePanelLayout.setHorizontalGroup(
            statistiquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1239, Short.MAX_VALUE)
        );
        statistiquePanelLayout.setVerticalGroup(
            statistiquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 959, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(statistiquePanel);

        jTabbedPane2.addTab("Statistique", null, jScrollPane3, "");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        newModelButton.setText("New model");
        newModelButton.setToolTipText("Create a new model");
        newModelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newModelButtonActionPerformed(evt);
            }
        });

        newCityButton.setText("New City");
        newCityButton.setToolTipText("create new city");
        newCityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCityButtonActionPerformed(evt);
            }
        });

        loadModelButton.setText("Load model");
        loadModelButton.setToolTipText("Load an existant model");
        loadModelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadModelButtonActionPerformed(evt);
            }
        });

        loadCityButton.setText("Load city");
        loadCityButton.setToolTipText("Load an existing city");
        loadCityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadCityButtonActionPerformed(evt);
            }
        });

        saveModelButton.setText("Save model");
        saveModelButton.setToolTipText("Save this model");
        saveModelButton.setEnabled(false);
        saveModelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveModelButtonActionPerformed(evt);
            }
        });

        saveCityButton.setText("Save city");
        saveCityButton.setToolTipText("save");
        saveCityButton.setEnabled(false);
        saveCityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveCityButtonActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        runButton.setText("Run");
        runButton.setToolTipText("");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        pauseButton.setText("Pause");
        pauseButton.setToolTipText("");
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        stopButton.setText("Stop");
        stopButton.setToolTipText("");
        stopButton.setEnabled(false);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        jSlider1.setMaximum(10);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setToolTipText("");
        jSlider1.setValue(5);
        jSlider1.setInverted(true);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        RefleshButton.setText("Reflesh");
        RefleshButton.setToolTipText("");
        RefleshButton.setEnabled(false);
        RefleshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefleshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(newModelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newCityButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadModelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadCityButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveModelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveCityButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(runButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pauseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stopButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RefleshButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newCityButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(newModelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(loadModelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(loadCityButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(saveModelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(saveCityButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(runButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pauseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(stopButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSlider1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RefleshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        newModelMenuItem.setText("New Model");
        newModelMenuItem.setToolTipText("");
        newModelMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newModelMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(newModelMenuItem);

        newCityMenuItem.setText("New city");
        newCityMenuItem.setToolTipText("create new city");
        jMenu1.add(newCityMenuItem);
        jMenu1.add(jSeparator2);

        loadModelMenuItm.setText("Load Model");
        loadModelMenuItm.setToolTipText("Load an existing model");
        jMenu1.add(loadModelMenuItm);

        loadCityMenuItem.setText("Load city");
        loadCityMenuItem.setToolTipText("Load an existing city");
        jMenu1.add(loadCityMenuItem);
        jMenu1.add(jSeparator3);

        saveModelMenuItem.setText("Save model");
        saveModelMenuItem.setToolTipText("Save this model");
        saveModelMenuItem.setEnabled(false);
        saveModelMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveModelMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(saveModelMenuItem);

        saveCityMenuItm.setText("Save city");
        saveCityMenuItm.setToolTipText("Save this city");
        saveCityMenuItm.setEnabled(false);
        jMenu1.add(saveCityMenuItm);

        saveAsModelMenuItem.setText("Save as model");
        saveAsModelMenuItem.setToolTipText("Save as this model");
        saveAsModelMenuItem.setEnabled(false);
        jMenu1.add(saveAsModelMenuItem);

        saveAsCityMenuItem.setText("Save as city");
        saveAsCityMenuItem.setToolTipText("Save as this city");
        saveAsCityMenuItem.setEnabled(false);
        jMenu1.add(saveAsCityMenuItem);
        jMenu1.add(jSeparator4);

        exitMenuItem.setText("Exit");
        exitMenuItem.setToolTipText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(exitMenuItem);

        jMenuBar1.add(jMenu1);

        generateLocationMenu.setText("Generate map");
        generateLocationMenu.setToolTipText("");
        generateLocationMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        generateLocationMenu.setPreferredSize(new java.awt.Dimension(100, 19));
        jMenuBar1.add(generateLocationMenu);

        generatePopulationMenu.setText("Generate population");
        generatePopulationMenu.setToolTipText("");
        jMenuBar1.add(generatePopulationMenu);

        jMenu3.setText("Run");
        jMenu3.setToolTipText("");

        runMenuItem.setText("Run");
        runMenuItem.setToolTipText("");
        runMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(runMenuItem);

        runMenu.setText("Run");
        runMenu.setToolTipText("");
        jMenu3.add(runMenu);

        pauseMenu.setText("Pause");
        pauseMenu.setToolTipText("");
        jMenu3.add(pauseMenu);

        pauseMenuItem.setText("Pause");
        pauseMenuItem.setToolTipText("");
        pauseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(pauseMenuItem);

        continueMenuItem.setText("Continue");
        continueMenuItem.setToolTipText("");
        jMenu3.add(continueMenuItem);

        stopMenuItem.setText("Stop");
        stopMenuItem.setToolTipText("");
        jMenu3.add(stopMenuItem);

        jMenuBar1.add(jMenu3);

        toolsMenu.setText("Tools");
        toolsMenu.setToolTipText("");

        jMenu4.setText("Age distribution");
        jMenu4.setToolTipText("");

        agePercentageMenu.setSelected(true);
        agePercentageMenu.setText("Percentage");
        agePercentageMenu.setToolTipText("");
        jMenu4.add(agePercentageMenu);

        goSchoolPercentageMenu.setSelected(true);
        goSchoolPercentageMenu.setText("Go school percentage");
        goSchoolPercentageMenu.setToolTipText("");
        jMenu4.add(goSchoolPercentageMenu);

        goUniversityPercentageMenu.setSelected(true);
        goUniversityPercentageMenu.setText("Go university percentage");
        goUniversityPercentageMenu.setToolTipText("");
        jMenu4.add(goUniversityPercentageMenu);

        goWorkPercentageMenu.setSelected(true);
        goWorkPercentageMenu.setText("Go work percentage");
        goWorkPercentageMenu.setToolTipText("");
        jMenu4.add(goWorkPercentageMenu);

        toolsMenu.add(jMenu4);

        houseReligionDistributionMenu.setSelected(true);
        houseReligionDistributionMenu.setText("House religion distribution");
        houseReligionDistributionMenu.setToolTipText("");
        houseReligionDistributionMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                houseReligionDistributionMenuActionPerformed(evt);
            }
        });
        toolsMenu.add(houseReligionDistributionMenu);

        housePopulationDistributionMenu.setSelected(true);
        housePopulationDistributionMenu.setText("House population distribution");
        housePopulationDistributionMenu.setToolTipText("");
        housePopulationDistributionMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                housePopulationDistributionMenuActionPerformed(evt);
            }
        });
        toolsMenu.add(housePopulationDistributionMenu);

        sexeDistributionMenu.setSelected(true);
        sexeDistributionMenu.setText("Sexe distribution ");
        sexeDistributionMenu.setToolTipText("");
        sexeDistributionMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexeDistributionMenuActionPerformed(evt);
            }
        });
        toolsMenu.add(sexeDistributionMenu);

        jMenu5.setText("Model");
        jMenu5.setToolTipText("");

        symptomMenu.setText("Symptoms");
        symptomMenu.setToolTipText("");
        symptomMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                symptomMenuActionPerformed(evt);
            }
        });
        jMenu5.add(symptomMenu);

        symptomStageMenu.setText("Symptom stages");
        symptomStageMenu.setToolTipText("");
        symptomStageMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                symptomStageMenuActionPerformed(evt);
            }
        });
        jMenu5.add(symptomStageMenu);

        humanStateMenu.setText("HumanStat");
        humanStateMenu.setToolTipText("");
        humanStateMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humanStateMenuActionPerformed(evt);
            }
        });
        jMenu5.add(humanStateMenu);

        toolsMenu.add(jMenu5);

        ageMenu.setText("Age");
        ageMenu.setToolTipText("");
        ageMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageMenuActionPerformed(evt);
            }
        });
        toolsMenu.add(ageMenu);

        religionMenuItem.setText("Religion");
        religionMenuItem.setToolTipText("");
        religionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                religionMenuItemActionPerformed(evt);
            }
        });
        toolsMenu.add(religionMenuItem);

        jMenuBar1.add(toolsMenu);
        toolsMenu.getAccessibleContext().setAccessibleName("Option");

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(locationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(locationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void newModelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newModelButtonActionPerformed
        NewModelDialog dialog = new NewModelDialog(this);
        dialog.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_newModelButtonActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(1);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void runMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runMenuItemActionPerformed
        this.currentCityPanel.getCity1().start();
        this.runMenuItem.setEnabled(false);
        this.stopMenuItem.setEnabled(true);
        this.pauseMenuItem.setEnabled(true);
    }//GEN-LAST:event_runMenuItemActionPerformed

    private void pauseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseMenuItemActionPerformed
        this.currentCityPanel.getCity1().pause();
        this.runMenuItem.setEnabled(true);
        this.pauseMenuItem.setEnabled(false);
        this.stopMenuItem.setEnabled(true);
    }//GEN-LAST:event_pauseMenuItemActionPerformed

    private void newModelMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newModelMenuItemActionPerformed
        NewModelDialog dialog = new NewModelDialog(this);
        dialog.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_newModelMenuItemActionPerformed

    private void loadModelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadModelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadModelButtonActionPerformed

    private void saveModelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveModelButtonActionPerformed
        this.currentModel.save();
        this.setModelSavedButtonDisable();
    }//GEN-LAST:event_saveModelButtonActionPerformed

    private void saveModelMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveModelMenuItemActionPerformed
//        this.saveModel();
    }//GEN-LAST:event_saveModelMenuItemActionPerformed

    private void newCityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCityButtonActionPerformed
        String ti = "New city";
        String message = "Would you like to save this city and the result?";
        if (this.currentCity != null) {
            if (!this.currentCity.isIsSaved()) {
                int reply = JOptionPane.showConfirmDialog(this, message, ti, JOptionPane.YES_NO_CANCEL_OPTION);
                switch (reply) {
                    case JOptionPane.YES_OPTION:
                        this.currentCityPanel.getCity1().save();
                        NewCityDialog dialo = new NewCityDialog(this);
                        dialo.setVisible(true);
                        this.setEnabled(false);
                        break;
                    case JOptionPane.NO_OPTION:
                        NewCityDialog dialog = new NewCityDialog(this);
                        dialog.setVisible(true);
                        this.setEnabled(false);
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        return;
                    default:
                        return;
                }
            } else {
                NewCityDialog dialog = new NewCityDialog(this);
                dialog.setVisible(true);
                this.setEnabled(false);
            }
        } else {
            NewCityDialog dialog = new NewCityDialog(this);
            dialog.setVisible(true);
            this.setEnabled(false);
        }
        this.setCitySavedButtonDisable();
    }//GEN-LAST:event_newCityButtonActionPerformed

    private void saveCityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveCityButtonActionPerformed
        this.currentCity.save();
        this.setCitySavedButtonDisable();
    }//GEN-LAST:event_saveCityButtonActionPerformed

    private void loadCityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadCityButtonActionPerformed
        String ti = "New city";
        String message = "Would you like to save this city and the result?";
        if (this.currentCity != null) {
            if (!this.currentCity.isIsSaved()) {
                int reply = JOptionPane.showConfirmDialog(this, message, ti, JOptionPane.YES_NO_CANCEL_OPTION);
                switch (reply) {
                    case JOptionPane.YES_OPTION:
                        this.currentCityPanel.getCity1().save();
                        LoadCityDialog dialog = new LoadCityDialog(this);
                        dialog.setVisible(true);
                        this.setEnabled(false);
                        break;
                    case JOptionPane.NO_OPTION:
                        LoadCityDialog dialo = new LoadCityDialog(this);
                        dialo.setVisible(true);
                        this.setEnabled(false);
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        return;
                    default:
                        return;
                }
            } else {
                LoadCityDialog dialog = new LoadCityDialog(this);
                dialog.setVisible(true);
                this.setEnabled(false);
            }
        } else {
            LoadCityDialog dialog = new LoadCityDialog(this);
            dialog.setVisible(true);
            this.setEnabled(false);
        }
        this.setCitySavedButtonDisable();
    }//GEN-LAST:event_loadCityButtonActionPerformed

    private void houseReligionDistributionMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_houseReligionDistributionMenuActionPerformed
        this.currentCityPanel.addHouseReligionUse(this.houseReligionDistributionMenu.isSelected());
    }//GEN-LAST:event_houseReligionDistributionMenuActionPerformed

    private void housePopulationDistributionMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_housePopulationDistributionMenuActionPerformed
        this.currentCityPanel.addHousePopulationUse(this.housePopulationDistributionMenu.isSelected());
    }//GEN-LAST:event_housePopulationDistributionMenuActionPerformed

    private void sexeDistributionMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexeDistributionMenuActionPerformed
        this.currentCityPanel.addSexeTypeUse(this.sexeDistributionMenu.isSelected());
    }//GEN-LAST:event_sexeDistributionMenuActionPerformed

    private void symptomMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_symptomMenuActionPerformed
        /*ManageSymptomTypeDialog dialog = new ManageSymptomTypeDialog(this);
        dialog.setVisible(true);
        this.setEnabled(false);*/
    }//GEN-LAST:event_symptomMenuActionPerformed

    private void symptomStageMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_symptomStageMenuActionPerformed
        ManageSymptomStageDialog dialog = new ManageSymptomStageDialog(this);
        dialog.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_symptomStageMenuActionPerformed

    private void humanStateMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humanStateMenuActionPerformed
        ManageHumanStateDialog dialog = new ManageHumanStateDialog(this);
        dialog.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_humanStateMenuActionPerformed

    private void ageMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageMenuActionPerformed
        ManageHumanAgeDialog dialog = new ManageHumanAgeDialog(this);
        dialog.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_ageMenuActionPerformed

    private void religionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_religionMenuItemActionPerformed
        ManageReligionDialog dialog = new ManageReligionDialog(this);
        dialog.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_religionMenuItemActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        int value = this.jSlider1.getValue();
        this.currentModel.getCity().setSpeed(value);
    }//GEN-LAST:event_jSlider1StateChanged

    private void jTabbedPane2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane2StateChanged
        int index = this.jTabbedPane2.getSelectedIndex();
        ModelPanel.ButtonTilte mp = null;
        Maps.ButtonTilte ma = null;
        try {
            mp = (ModelPanel.ButtonTilte) this.jTabbedPane2.getTabComponentAt(index);
        } catch (Exception e) {
        }
        try {
            ma = (Maps.ButtonTilte) this.jTabbedPane2.getTabComponentAt(index);
        } catch (Exception e) {
        }

        if (mp != null) {
            this.setModelSavedButtonDisable();
            this.currentModel = this.listModel.get(index - 1);
            this.jSlider1.setEnabled(true);
            this.jSlider1.setValue(this.currentModel.getCity().getSpeed());

            if (this.currentModel.isStop()) {
                this.runButton.setEnabled(false);
                this.pauseButton.setEnabled(false);
                this.pauseButton.setEnabled(false);
                this.jSlider1.setEnabled(false);
            } else {
                if (this.currentModel.isRun()) {
                    this.runButton.setEnabled(false);
                } else {
                    this.runButton.setEnabled(true);
                }

                if (!this.currentModel.isPause() && !this.currentModel.isFirstTimeRun()) {
                    this.pauseButton.setEnabled(true);
                } else {
                    this.pauseButton.setEnabled(false);
                }

                if (!this.currentModel.isStop() && !this.currentModel.isFirstTimeRun()) {
                    this.stopButton.setEnabled(true);
                } else {
                    this.stopButton.setEnabled(false);
                }
            }

            this.currentModelPanel = this.currentModel.getModelPanel();
            if (!this.currentModel.isSaved()) {
                this.setModelSavedButtonEnable();
            }
        } else {
            this.setModelSavedButtonDisable();
            this.jSlider1.setEnabled(false);
            this.runButton.setEnabled(false);
            this.pauseButton.setEnabled(false);
            this.stopButton.setEnabled(false);
        }

        // }
    }//GEN-LAST:event_jTabbedPane2StateChanged

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        if (this.currentModel.isPause()) {
            this.currentModel.getCity().resume();
        } else {
            this.currentModel.getCity().start();
            this.getCurrentModelPanel().setDisable();
        }
    }//GEN-LAST:event_runButtonActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
        this.currentModel.getCity().pause();
    }//GEN-LAST:event_pauseButtonActionPerformed

    private void RefleshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefleshButtonActionPerformed
        this.currentModel.refresh();
    }//GEN-LAST:event_RefleshButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        this.currentModel.getCity().stop();
    }//GEN-LAST:event_stopButtonActionPerformed

    public Maps getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(Maps currentMap) {
        this.currentMap = currentMap;
    }

    public void setModelSavedButtonEnable() {
        this.saveModelButton.setEnabled(true);
        this.saveModelMenuItem.setEnabled(true);
        this.saveAsModelMenuItem.setEnabled(true);
    }

    public void setCitySavedButtonEnable() {
        this.saveCityButton.setEnabled(true);
        this.saveCityMenuItm.setEnabled(true);
        this.saveAsCityMenuItem.setEnabled(true);
    }

    public void setModelSavedButtonDisable() {
        this.saveModelButton.setEnabled(false);
        this.saveModelMenuItem.setEnabled(false);
        this.saveAsModelMenuItem.setEnabled(false);
    }

    public void setCitySavedButtonDisable() {
        this.saveCityButton.setEnabled(false);
        this.saveCityMenuItm.setEnabled(false);
        this.saveAsCityMenuItem.setEnabled(false);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    public List<HumanAgeName> getListHumanAgeName() {
        return listHumanAgeName;
    }

    public void setListHumanAgeName(List<HumanAgeName> listHumanAgeName) {
        this.listHumanAgeName = listHumanAgeName;
    }

    public JButton getPauseButton() {
        return pauseButton;
    }

    public JButton getRunButton() {
        return runButton;
    }

    public JButton getStopButton() {
        return stopButton;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RefleshButton;
    private javax.swing.JMenuItem ageMenu;
    private javax.swing.JCheckBoxMenuItem agePercentageMenu;
    private javax.swing.JMenu continueMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu generateLocationMenu;
    private javax.swing.JMenu generatePopulationMenu;
    private javax.swing.JCheckBoxMenuItem goSchoolPercentageMenu;
    private javax.swing.JCheckBoxMenuItem goUniversityPercentageMenu;
    private javax.swing.JCheckBoxMenuItem goWorkPercentageMenu;
    private javax.swing.JCheckBoxMenuItem housePopulationDistributionMenu;
    private javax.swing.JCheckBoxMenuItem houseReligionDistributionMenu;
    private javax.swing.JMenuItem humanStateMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton loadCityButton;
    private javax.swing.JMenuItem loadCityMenuItem;
    private javax.swing.JButton loadModelButton;
    private javax.swing.JMenuItem loadModelMenuItm;
    private javax.swing.JPanel locationPanel;
    private javax.swing.JButton newCityButton;
    private javax.swing.JMenuItem newCityMenuItem;
    private javax.swing.JButton newModelButton;
    private javax.swing.JMenuItem newModelMenuItem;
    private javax.swing.JButton pauseButton;
    private javax.swing.JMenu pauseMenu;
    private javax.swing.JMenuItem pauseMenuItem;
    private javax.swing.JMenuItem religionMenuItem;
    private javax.swing.JButton runButton;
    private javax.swing.JMenu runMenu;
    private javax.swing.JMenuItem runMenuItem;
    private javax.swing.JMenuItem saveAsCityMenuItem;
    private javax.swing.JMenuItem saveAsModelMenuItem;
    private javax.swing.JButton saveCityButton;
    private javax.swing.JMenuItem saveCityMenuItm;
    private javax.swing.JButton saveModelButton;
    private javax.swing.JMenuItem saveModelMenuItem;
    private javax.swing.JCheckBoxMenuItem sexeDistributionMenu;
    private javax.swing.JPanel statistiquePanel;
    private javax.swing.JButton stopButton;
    private javax.swing.JMenuItem stopMenuItem;
    private javax.swing.JMenuItem symptomMenu;
    private javax.swing.JMenuItem symptomStageMenu;
    private javax.swing.JMenu toolsMenu;
    // End of variables declaration//GEN-END:variables
}
