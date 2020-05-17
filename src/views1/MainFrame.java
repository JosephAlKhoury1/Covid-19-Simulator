package views1;

import controller.controllers.ModelController;
import controller.locationController.CityController;
import java.awt.BorderLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import models.client1.City;
import models.client1.Data;
import models.client1.Week;
import models.model.Model;
import views.dialog1.LoadCityDialog;
import views.dialog1.NewCityDialog;
import views.dialog1.SaveModelDialog;

public class MainFrame extends JFrame {

    private City currentCity;
    private Model currentModel;
    private ModelPanel currentModelPanel;
    private Maps currentMap;
    private CityPanel currentCityPanel;
    private final List<ModelPanel> listModelPanel;
    private final List<Maps> listMap;
    public LocationListPanel locationListPanel;
    private final String[] hours = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};

    public MainFrame() {
        this.listModelPanel = new ArrayList();
        this.listMap = new ArrayList();
        initComponents();
        Data.initData();
        this.locationPanel.setLayout(new BorderLayout());
        this.jTabbedPane2.removeTabAt(0);
        this.currentCity = CityController.INSTANCE.getMainCity(1);
        if (this.currentCity != null) {
            this.currentCityPanel = new CityPanel(this, this.jTabbedPane2, this.currentCity);
            this.jTabbedPane2.addTab(this.currentCity.getName(), this.currentCityPanel);
            this.jTabbedPane2.setTabComponentAt(this.jTabbedPane2.getTabCount() - 1, this.currentCityPanel.getButton());
            this.locationListPanel = this.currentCityPanel.getCurrentLocationListPanel();
            this.locationPanel.removeAll();
            this.locationListPanel.setSize(this.locationPanel.getSize());
            this.locationPanel.add(this.locationListPanel);
        } else {
            this.loadCityButton.setEnabled(false);
            this.loadCityMenuItem.setEnabled(false);
        }
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
        this.jTabbedPane2.removeAll();
        this.currentCity = CityController.INSTANCE.select(cityId);
        this.currentCityPanel = new CityPanel(this, jTabbedPane2, this.currentCity);
        this.currentCity = this.currentCityPanel.getCity1();
        this.locationListPanel = this.currentCityPanel.getCurrentLocationListPanel();
        this.currentCity.save();
        this.jTabbedPane2.addTab(this.currentCity.getName(), this.currentCityPanel);
        this.jTabbedPane2.setTabComponentAt(0, this.currentCityPanel.getButton());
        for (ModelPanel mp : this.listModelPanel) {
            this.jTabbedPane2.addTab("", mp);
            this.jTabbedPane2.setTabComponentAt(this.jTabbedPane2.getTabCount() - 1, mp.getButton());
        }
        this.locationPanel.removeAll();
        this.locationListPanel.setSize(this.locationPanel.getSize());
        this.locationPanel.add(this.locationListPanel);
        this.repaint();
    }

    public void saveModel() {
        String ti = "Save Model";
        String message = "Would you like to save the current model?";
        // this.initModelParameters();
        if (this.currentModel.isNewModel()) {
            int reply = JOptionPane.showConfirmDialog(this, message, ti, JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                SaveModelDialog dialog = new SaveModelDialog(this, this.currentModel);
                this.currentModel.setNewModel(false);
                this.currentModel.setSaved(true);
                dialog.setVisible(true);
                this.setEnabled(false);
            } else if (reply == JOptionPane.NO_OPTION) {
            }
        } else {
            if (!this.currentModel.isSaved()) {
                int reply = JOptionPane.showConfirmDialog(this, message, ti, JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    ModelController.INSTANCE.updateModel(currentModel);
                    this.currentModel.setSaved(true);
                } else if (reply == JOptionPane.NO_OPTION) {
                }
            }
        }
        this.saveModelButton.setEnabled(false);
        this.saveModelMenuItem.setEnabled(false);
    }

    public void newModel() {
        if (this.currentModel != null) {
            String ti = "Save Model";
            String message = "Would you like to save the current model?";
            // this.initModelParameters();
            if (this.currentModel.isNewModel()) {
                int reply = JOptionPane.showConfirmDialog(this, message, ti, JOptionPane.YES_NO_CANCEL_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    SaveModelDialog dialog = new SaveModelDialog(this, this.currentModel);
                    dialog.setVisible(true);
                    this.setEnabled(false);
                } else if (reply == JOptionPane.NO_OPTION) {
                    this.initNewModel();
                }
            } else {
                if (!this.currentModel.isSaved()) {
                    int reply = JOptionPane.showConfirmDialog(this, message, ti, JOptionPane.YES_NO_CANCEL_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        ModelController.INSTANCE.updateModel(currentModel);
                        this.initNewModel();
                    } else if (reply == JOptionPane.NO_OPTION) {
                        this.initNewModel();
                    }
                } else {
                    this.initNewModel();
                }
            }
        } else {
            this.initNewModel();
        }
    }

    public void newCity(String name) {
        if (this.currentCity != null) {
            CityController.INSTANCE.setCityNonMain(this.currentCity.getId());
        }
        this.jTabbedPane2.removeAll();
        this.currentCityPanel = new CityPanel(this, jTabbedPane2, name);
        this.currentCity = this.currentCityPanel.getCity1();
        this.locationListPanel = this.currentCityPanel.getCurrentLocationListPanel();
        this.currentCity.save();
        this.jTabbedPane2.addTab(this.currentCity.getName(), this.currentCityPanel);
        this.jTabbedPane2.setTabComponentAt(0, this.currentCityPanel.getButton());
        for (ModelPanel mp : this.listModelPanel) {
            this.jTabbedPane2.addTab("", mp);
            this.jTabbedPane2.setTabComponentAt(this.jTabbedPane2.getTabCount() - 1, mp.getButton());
        }
        this.locationPanel.removeAll();
        this.locationListPanel.setSize(this.locationPanel.getSize());
        this.locationPanel.add(this.locationListPanel);
        this.repaint();
    }

    public void initNewModel() {
        this.currentModel = new Model(" ");
        this.currentModel.setNewModel(true);
        this.currentModel.setSaved(true);
        //this.setJtextFieldsModelValues(currentModel);
        /*int index = this.jTabbedPane2.indexOfComponent(this.jScrollPane2);
        if (index == -1) {
            this.jTabbedPane2.addTab("Model", this.jScrollPane2);
            this.jTabbedPane2.setSelectedComponent(this.jScrollPane2);
        }*/
    }

    public void initNewCity() {

    }

    public Model getCurrentModel() {
        return currentModel;
    }

    public void setCurrentModel(Model currentModel) {
        this.currentModel = currentModel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        locationPanel = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel17 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        healthylabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sickLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        deathLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        weekLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dayLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        hourLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        minuteLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        newModelButton = new javax.swing.JButton();
        newCityButton = new javax.swing.JButton();
        loadModelButton = new javax.swing.JButton();
        loadCityButton = new javax.swing.JButton();
        saveModelButton = new javax.swing.JButton();
        saveCityButton = new javax.swing.JButton();
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
        jMenu2 = new javax.swing.JMenu();
        generateLoactionMenuItem = new javax.swing.JMenuItem();
        generateTransportationMenuItem = new javax.swing.JMenuItem();
        generatePopulationMenuItem = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        runMenuItem = new javax.swing.JMenuItem();
        pauseMenuItem = new javax.swing.JMenuItem();
        continueMenuItem = new javax.swing.JMenu();
        stopMenuItem = new javax.swing.JMenuItem();

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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane2StateChanged(evt);
            }
        });

        jPanel34.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Population:");

        jLabel5.setText("Healthy:");

        healthylabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthylabel.setText("0");
        healthylabel.setToolTipText("");

        jLabel6.setText("Sick:");

        sickLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sickLabel.setText("0");
        sickLabel.setToolTipText("");

        jLabel7.setText("Death:");

        deathLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deathLabel.setText("0");
        deathLabel.setToolTipText("");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(healthylabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sickLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(healthylabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(sickLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(deathLabel)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Week:");

        weekLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weekLabel.setToolTipText("");

        jLabel2.setText("Day:");

        dayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayLabel.setToolTipText("");

        jLabel11.setText("Hour:");

        hourLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hourLabel.setToolTipText("");

        jLabel9.setText("Minute:");

        minuteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minuteLabel.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(weekLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(minuteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hourLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weekLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minuteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hourLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1014, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(771, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel17);

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
                .addContainerGap(482, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newCityButton, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
            .addComponent(newModelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(loadModelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(loadCityButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(saveModelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(saveCityButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jMenu2.setText("Build");
        jMenu2.setToolTipText("");

        generateLoactionMenuItem.setText("Generate Locations");
        generateLoactionMenuItem.setToolTipText("Generate the city location");
        generateLoactionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateLoactionMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(generateLoactionMenuItem);

        generateTransportationMenuItem.setText("Generate transportations");
        generateTransportationMenuItem.setToolTipText("Generate the city transportation");
        jMenu2.add(generateTransportationMenuItem);

        generatePopulationMenuItem.setText("Generate Population");
        generatePopulationMenuItem.setToolTipText("Generate Population");
        generatePopulationMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatePopulationMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(generatePopulationMenuItem);

        jMenuBar1.add(jMenu2);

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
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void newModelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newModelButtonActionPerformed
        //this.newModel();
        ModelPanel mp = new ModelPanel(this, jTabbedPane2);
        this.jTabbedPane2.addTab("New Model", mp);
        this.jTabbedPane2.setTabComponentAt(this.jTabbedPane2.getTabCount() - 1, mp.getButton());
        this.listModelPanel.add(mp);
    }//GEN-LAST:event_newModelButtonActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(1);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void generateLoactionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateLoactionMenuItemActionPerformed
        this.currentCityPanel.generateMapLocation();
        this.currentMap = this.currentCityPanel.getCurrentMap();
    }//GEN-LAST:event_generateLoactionMenuItemActionPerformed

    private void generatePopulationMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatePopulationMenuItemActionPerformed
        Data.numberPopulation = 0;
        //this.city1.initPopulation();
        //populationLabel.setText(Data.numberPopulation + "");
        this.currentMap.repaint();
        this.setVisible(true);
    }//GEN-LAST:event_generatePopulationMenuItemActionPerformed

    private void runMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runMenuItemActionPerformed
        this.generateLoactionMenuItem.setEnabled(false);
        this.generatePopulationMenuItem.setEnabled(false);
        this.generateTransportationMenuItem.setEnabled(false);
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
        this.newModel();
    }//GEN-LAST:event_newModelMenuItemActionPerformed

    private void loadModelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadModelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadModelButtonActionPerformed

    private void saveModelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveModelButtonActionPerformed
        this.saveModel();
    }//GEN-LAST:event_saveModelButtonActionPerformed

    private void saveModelMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveModelMenuItemActionPerformed
        this.saveModel();
    }//GEN-LAST:event_saveModelMenuItemActionPerformed

    private void jTabbedPane2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane2StateChanged
        int index = this.jTabbedPane2.getSelectedIndex();
        if (index >= 0) {
            ModelPanel.ButtonTilte mp = null;
            CityPanel.ButtonTilte cp = null;
            Maps.ButtonTilte ma = null;
            try {
                mp = (ModelPanel.ButtonTilte) this.jTabbedPane2.getTabComponentAt(index);
            } catch (Exception e) {
            }
            try {
                cp = (CityPanel.ButtonTilte) this.jTabbedPane2.getTabComponentAt(index);
            } catch (Exception e) {
            }
            try {
                ma = (Maps.ButtonTilte) this.jTabbedPane2.getTabComponentAt(index);
            } catch (Exception e) {
            }
            if (mp != null) {
                for (ModelPanel m : this.listModelPanel) {
                    if (m.getButton() == mp) {
                        this.currentModelPanel = m;
                        this.currentModel = this.currentModelPanel.getModel();
                    }
                }
            }
            if (ma != null) {
                for (Maps m : this.listMap) {
                    if (m.getButton() == ma) {
                        this.currentMap = m;
                        this.jTabbedPane2.setSelectedComponent(ma);
                    }
                }
            }
            if (cp != null) {
                if (this.currentCityPanel.getButton() == cp) {
                    this.locationListPanel = this.currentCityPanel.getCurrentLocationListPanel();
                    // this.jTabbedPane2.setSelectedComponent(cp);
                }
            }
        }
    }//GEN-LAST:event_jTabbedPane2StateChanged

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
        }
        this.setCitySavedButtonDisable();
    }//GEN-LAST:event_loadCityButtonActionPerformed

    public Maps getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(Maps currentMap) {
        this.currentMap = currentMap;
    }

    public void updateTime(Week week) {
        this.weekLabel.setText(week.getWeekNumber() + "");
        this.dayLabel.setText(week.getCurrentDay().name());
        this.hourLabel.setText(week.getHour() + "");
        this.minuteLabel.setText(week.getMinute() + "");
        this.setVisible(true);
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
        this.saveCityButton.setEnabled(false);
        this.saveCityMenuItm.setEnabled(false);
        this.saveAsCityMenuItem.setEnabled(false);
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

    private class JTextFieldDoubleListener implements DocumentListener, FocusListener {

        private final JTextField jtextField;
        private final MainFrame mainFrame;
        private String currentString = "0.0";
        private final String greaterMessage = "Number can't be greater 100!";
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = false;

        public JTextFieldDoubleListener(JTextField textField, MainFrame mainFrame) {
            this.jtextField = textField;
            this.mainFrame = mainFrame;
        }

        private void insertZero(String s) {
            Runnable doHighlight = () -> {
                jtextField.setText(s);
            };
            SwingUtilities.invokeLater(doHighlight);
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            String numTxt = this.jtextField.getText();
            setModelSavedButtonEnable();
            if (currentModel != null) {
                currentModel.setSaved(false);
            }
            try {
                Double d = Double.parseDouble(numTxt);
                if (d > 100) {
                    JOptionPane.showOptionDialog(this.mainFrame, this.greaterMessage, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    insertZero(this.currentString);
                    this.insert = false;
                }
            } catch (NumberFormatException ex) {
                this.insert = true;
                JOptionPane.showOptionDialog(this.mainFrame, this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                insertZero(this.currentString);
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            this.insert = false;
            setModelSavedButtonEnable();
            if (currentModel != null) {
                currentModel.setSaved(false);
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }

        @Override
        public void focusGained(FocusEvent e) {
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (!insert) {
                if (this.jtextField.getText().equals("")) {
                    insertZero(this.currentString);
                    return;
                }
                int index = this.jtextField.getText().lastIndexOf('.');
                int len = this.jtextField.getText().length();
                System.out.println("index=" + index);
                System.out.println("len=" + len);
                String s = this.jtextField.getText();
                if (index == (len - 1)) {
                    s += 0;
                }
                this.currentString = s;
                insertZero(this.currentString);
            }
        }

    }

    private class JTextFieldIntegerListener implements DocumentListener, FocusListener {

        private final JTextField jtextField;
        private final MainFrame mainFrame;
        private String currentString = "0";
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = false;

        public JTextFieldIntegerListener(JTextField textField, MainFrame mainFrame) {
            this.jtextField = textField;
            this.mainFrame = mainFrame;
        }

        private void insertZero(String s) {
            Runnable doHighlight = new Runnable() {
                @Override
                public void run() {
                    jtextField.setText(s);
                }
            };
            SwingUtilities.invokeLater(doHighlight);
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            String numTxt = this.jtextField.getText();
            setModelSavedButtonEnable();
            if (currentModel != null) {
                currentModel.setSaved(false);
            }
            try {
                int d = Integer.parseInt(numTxt);
            } catch (NumberFormatException ex) {
                this.insert = true;
                JOptionPane.showOptionDialog(this.mainFrame, this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                insertZero(this.currentString);
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            this.insert = false;
            setModelSavedButtonEnable();
            if (currentModel != null) {
                currentModel.setSaved(false);
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }

        @Override
        public void focusGained(FocusEvent e) {
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (!insert) {
                if (this.jtextField.getText().equals("")) {
                    insertZero(this.currentString);
                    return;
                }
                String s = this.jtextField.getText();
                this.currentString = s;
                insertZero(this.currentString);
            }
        }

    }

    public void setModelPanelVisible() {
        //this.jTabbedPane2.setSelectedComponent(this.jScrollPane2);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu continueMenuItem;
    private javax.swing.JLabel dayLabel;
    private javax.swing.JLabel deathLabel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem generateLoactionMenuItem;
    private javax.swing.JMenuItem generatePopulationMenuItem;
    private javax.swing.JMenuItem generateTransportationMenuItem;
    private javax.swing.JLabel healthylabel;
    private javax.swing.JLabel hourLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton loadCityButton;
    private javax.swing.JMenuItem loadCityMenuItem;
    private javax.swing.JButton loadModelButton;
    private javax.swing.JMenuItem loadModelMenuItm;
    private javax.swing.JPanel locationPanel;
    private javax.swing.JLabel minuteLabel;
    private javax.swing.JButton newCityButton;
    private javax.swing.JMenuItem newCityMenuItem;
    private javax.swing.JButton newModelButton;
    private javax.swing.JMenuItem newModelMenuItem;
    private javax.swing.JMenuItem pauseMenuItem;
    private javax.swing.JMenuItem runMenuItem;
    private javax.swing.JMenuItem saveAsCityMenuItem;
    private javax.swing.JMenuItem saveAsModelMenuItem;
    private javax.swing.JButton saveCityButton;
    private javax.swing.JMenuItem saveCityMenuItm;
    private javax.swing.JButton saveModelButton;
    private javax.swing.JMenuItem saveModelMenuItem;
    private javax.swing.JLabel sickLabel;
    private javax.swing.JMenuItem stopMenuItem;
    private javax.swing.JLabel weekLabel;
    // End of variables declaration//GEN-END:variables
}
