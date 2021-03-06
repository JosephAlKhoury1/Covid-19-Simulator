package views1.city.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import models.client.City;
import models.client.Data;
import models.client.HousePopulation;
import models.client.HumanCityAgeType;
import models.client.LocationToGo;
import models.client.ReligionType;
import models.client.SexeType;
import resources.Colors.Colors;
import resources.icon.Icons;
import resources.Messages.Messages;
import views1.MainFrame;
import views1.city.dialog.ManageLocationToGoDistributionDialog;
import views1.city.dialog.ManageReligionGoDistributionDialog;

/**
 *
 * @author Joseph
 */
public class CityPanel extends javax.swing.JPanel {

    private final MainFrame mainFrame;
    private City currentCity;
    private final LocationListPanel currentLocationListPanel;
    private Maps currentMap;
    private final JTabbedPane pane;
    private final ButtonTilte button;
    private boolean isSaved = false;

    public CityPanel(MainFrame mainFrame, JTabbedPane pane, City city) {
        this.mainFrame = mainFrame;
        this.pane = pane;
        this.currentCity = city;
        this.currentCity.setMainFrame(mainFrame);
        this.button = new ButtonTilte(this);
        this.currentCity.setCityPanel(this);

        this.initComponents();
        jPanel9.setVisible(false);
        jPanel12.setVisible(false);

        this.locationPanel.setLayout(new BorderLayout());
        this.locationPropertiesPanel.setLayout(new BorderLayout());

        this.currentLocationListPanel = new LocationListPanel(this.mainFrame, this);
        this.locationPanel.removeAll();
        this.currentLocationListPanel.setSize(this.locationPanel.getSize());
        this.locationPanel.add(this.currentLocationListPanel);

        this.sexePanel.setLayout(new BoxLayout(this.sexePanel, BoxLayout.Y_AXIS));
        this.religionPanel.setLayout(new BoxLayout(this.religionPanel, BoxLayout.Y_AXIS));
        this.housePopulationPanel.setLayout(new BoxLayout(this.housePopulationPanel, BoxLayout.Y_AXIS));
        this.agePanel.setLayout(new BoxLayout(this.agePanel, BoxLayout.Y_AXIS));
        this.locationToGoPanel.setLayout(new BoxLayout(this.locationToGoPanel, BoxLayout.X_AXIS));

        for (LocationToGo lt : this.currentCity.getListLocationToGo()) {
            this.locationToGoPanel.add(lt.getNameLabel());
            this.locationToGoPanel.add(lt.getcName());

        }
        this.currentCity.getListrelReligionTypes().stream().map((rl) -> {
            this.religionPanel.add(rl);
            this.religionPanel.add(rl.getComp());
            return rl;
        }).forEachOrdered((rl) -> {
            rl.setCity(city);
        });

        double totalHumanAgePercentage = 0;
        this.currentCity.getListHumanAgeType().stream().map((hu) -> {
            this.agePanel.add(hu.getPanel());
            this.agePanel.add(hu.getComp());
            return hu;
        }).forEachOrdered((hu) -> {
            hu.setCity(city);
        });

        for (HumanCityAgeType ha : this.currentCity.getListHumanAgeType()) {
            totalHumanAgePercentage += ha.getHumanPercentage();
        }
        if (totalHumanAgePercentage != 100) {
            for (HumanCityAgeType ha : this.currentCity.getListHumanAgeType()) {
                ha.getPercentageJtxt().setBackground(Colors.WARNINGCOLOR);
            }
            this.percentageOfHumanLabel.setIcon(Icons.WARNINGICON);
            this.percentageOfHumanLabel.setToolTipText(Messages.PERCENTAGEOFHUMANHAVINTHISAGEWITHWARNING);
            this.percentageOfHumanLabel.setBackground(Colors.WARNINGCOLOR);
            this.currentCity.setHaveBadHumanPercentageSum(true);
        } else {
            for (HumanCityAgeType ha : this.currentCity.getListHumanAgeType()) {
                ha.getPercentageJtxt().setBackground(Colors.NOWARNINGCOLOR);
            }
            this.percentageOfHumanLabel.setIcon(null);
            this.percentageOfHumanLabel.setToolTipText(Messages.PERCENTAGEOFHUMANHAVINTHISAGE);
            this.percentageOfHumanLabel.setBackground(Colors.NOWARNINGCOLOR);
            this.currentCity.setHaveBadHumanPercentageSum(false);
        }

        this.currentCity.getListHousePopulations().stream().map((hp) -> {
            Component c = Box.createVerticalStrut(3);
            hp.setComp(c);
            this.housePopulationPanel.add(hp);
            this.housePopulationPanel.add(c);
            return hp;
        }).forEachOrdered((hp) -> {
            hp.setCity(city);
        });
        this.currentCity.checkHousePopulationPercentage();

        this.currentCity.getListSexeType().stream().map((st) -> {
            Component c = Box.createVerticalStrut(3);
            st.setComponent(c);
            this.sexePanel.add(st);
            this.sexePanel.add(c);
            return st;
        }).forEachOrdered((st) -> {
            st.setCity(this.currentCity);
        });
    }

    public CityPanel(MainFrame mainFrame, JTabbedPane pane, String name) {
        this.mainFrame = mainFrame;
        this.pane = pane;
        try {
            this.currentCity = new City(name, 0, 2000, 1000, 1, mainFrame);
            this.currentCity.setMainFrame(mainFrame);
            this.currentCity.setCityPanel(this);
        } catch (RemoteException ex) {
            Logger.getLogger(CityPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.button = new ButtonTilte(this);
        this.initComponents();
        jPanel9.setVisible(false);
        jPanel12.setVisible(false);
        this.currentLocationListPanel = new LocationListPanel(this.mainFrame, this);

        this.locationPanel.setLayout(new BorderLayout());

        this.locationPanel.removeAll();
        this.currentLocationListPanel.setSize(this.locationPanel.getSize());
        this.locationPanel.add(this.currentLocationListPanel);

        this.locationPropertiesPanel.setLayout(new BorderLayout());

        this.sexePanel.setLayout(new BoxLayout(this.sexePanel, BoxLayout.Y_AXIS));
        this.religionPanel.setLayout(new BoxLayout(this.religionPanel, BoxLayout.Y_AXIS));
        this.housePopulationPanel.setLayout(new BoxLayout(this.housePopulationPanel, BoxLayout.Y_AXIS));
        this.agePanel.setLayout(new BoxLayout(this.agePanel, BoxLayout.Y_AXIS));
        this.locationToGoPanel.setLayout(new BoxLayout(this.locationToGoPanel, BoxLayout.X_AXIS));

        for (LocationToGo lt : this.currentCity.getListLocationToGo()) {
            this.locationToGoPanel.add(lt.getNameLabel());
            this.locationToGoPanel.add(lt.getcName());
        }
        this.currentCity.getListrelReligionTypes().stream().map((rl) -> {
            Component c = Box.createVerticalStrut(3);
            rl.setComp(c);
            this.religionPanel.add(rl);
            this.housePopulationPanel.add(c);
            return rl;
        }).forEachOrdered((rl) -> {
            rl.setCity(this.currentCity);
        });

        this.currentCity.getListHumanAgeType().stream().map((hu) -> {
            this.agePanel.add(hu.getPanel());
            this.housePopulationPanel.add(hu.getComp());
            return hu;
        }).forEachOrdered((hu) -> {
            hu.setCity(this.currentCity);
        });
        double totalHumanAgePercentage = 0;
        for (HumanCityAgeType ha : this.currentCity.getListHumanAgeType()) {
            totalHumanAgePercentage += ha.getHumanPercentage();
        }
        if (totalHumanAgePercentage != 100) {
            for (HumanCityAgeType ha : this.currentCity.getListHumanAgeType()) {
                ha.getPercentageJtxt().setBackground(Colors.WARNINGCOLOR);
            }
            this.percentageOfHumanLabel.setIcon(Icons.WARNINGICON);
            this.percentageOfHumanLabel.setToolTipText(Messages.PERCENTAGEOFHUMANHAVINTHISAGEWITHWARNING);
            this.percentageOfHumanLabel.setBackground(Colors.WARNINGCOLOR);
            this.currentCity.setHaveBadHumanPercentageSum(true);
        } else {
            for (HumanCityAgeType ha : this.currentCity.getListHumanAgeType()) {
                ha.getPercentageJtxt().setBackground(Colors.NOWARNINGCOLOR);
            }
            this.percentageOfHumanLabel.setIcon(null);
            this.percentageOfHumanLabel.setToolTipText(Messages.PERCENTAGEOFHUMANHAVINTHISAGE);
            this.percentageOfHumanLabel.setBackground(Colors.NOWARNINGCOLOR);
            this.currentCity.setHaveBadHumanPercentageSum(false);
        }

        this.currentCity.getListHousePopulations().stream().map((hp) -> {
            Component c = Box.createVerticalStrut(3);
            hp.setComp(c);
            this.housePopulationPanel.add(hp);
            this.housePopulationPanel.add(c);
            return hp;
        }).forEachOrdered((hp) -> {
            hp.setCity(this.currentCity);
        });
        this.currentCity.checkHousePopulationPercentage();

        this.currentCity.getListSexeType().stream().map((st) -> {
            Component c = Box.createVerticalStrut(3);
            st.setComponent(c);
            this.sexePanel.add(st);
            this.sexePanel.add(c);
            return st;
        }).forEachOrdered((st) -> {
            st.setCity(this.currentCity);
        });
    }

    public boolean isIsSaved() {
        return isSaved;
    }

    public void setIsSaved(boolean isSaved) {
        this.isSaved = isSaved;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentMap(Maps currentMap) {
        this.currentMap = currentMap;
    }

    public ButtonTilte getButton() {
        return button;
    }

    public JPanel getLocationPropertiesPanel() {
        return locationPropertiesPanel;
    }

    public LocationListPanel getCurrentLocationListPanel() {
        return currentLocationListPanel;
    }

    public Maps getCurrentMap() {
        return currentMap;
    }

    public void addCity(City city) {
        this.currentCity = city;
    }

    public City getCity1() {
        return currentCity;
    }

    public void setCity1(City city) {
        this.currentCity = city;
    }

    public void removeThisTab() {
        int i = pane.indexOfComponent(this);
        pane.removeTabAt(i);
    }

    public void updateAgePanel() {
        this.locationToGoPanel.removeAll();
        this.agePanelFathef.setPreferredSize(new Dimension(this.currentCity.getListLocationToGo().size() * 123 + 600, this.agePanelFathef.getHeight()));
        for (LocationToGo lt : this.currentCity.getListLocationToGo()) {
            this.locationToGoPanel.add(lt.getNameLabel());
            this.locationToGoPanel.add(lt.getcName());
        }
        this.repaint();
    }

    public void updateReligionPanel() {
        this.religionPanel.removeAll();
        this.religionPanel.setPreferredSize(new Dimension(this.religionPanel.getWidth(), this.currentCity.getListrelReligionTypes().size() * 35));
        for (ReligionType rt : this.currentCity.getListrelReligionTypes()) {
            this.religionPanel.add(rt);
            this.religionPanel.add(rt.getComp());
        }
        this.repaint();
    }

    public void reinitAgePanel() {
        this.agePanel.removeAll();
        this.agePanelFathef.setPreferredSize(new Dimension(this.agePanel.getWidth(), (this.currentCity.getListHumanAgeType().size() * 39) + 40));
        for (HumanCityAgeType ha : this.currentCity.getListHumanAgeType()) {
            this.agePanel.add(ha.getPanel());
            this.agePanel.add(ha.getComp());
        }
        this.agePanel.revalidate();
        this.agePanel.repaint();
    }

    public class ButtonTilte extends JPanel implements ActionListener {

        private CityPanel mp;

        public ButtonTilte(CityPanel mp) {
            initComponents();
            this.mp = mp;
        }

        public CityPanel getMp() {
            return mp;
        }

        private void initComponents() {

            this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            jLabel1 = new JLabel();
            jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel1.setText(currentCity.getName() + " city");

            this.add(this.jLabel1);
        }

        private JLabel jLabel1;

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = pane.indexOfComponent(mp);
            pane.removeTabAt(i);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel17 = new javax.swing.JPanel();
        locationPanel = new javax.swing.JPanel();
        locationPropertiesPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        addHousePopulationButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        housePopulationPercentageLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        housePopulationPanel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sexePanel = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        addAgeButton = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        religionPanel = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        addYeardistributionButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        agePanelFathef = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        percentageOfHumanLabel = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        locationToGoPanel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        agePanel = new javax.swing.JPanel();

        locationPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout locationPanelLayout = new javax.swing.GroupLayout(locationPanel);
        locationPanel.setLayout(locationPanelLayout);
        locationPanelLayout.setHorizontalGroup(
            locationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        locationPanelLayout.setVerticalGroup(
            locationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 816, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout locationPropertiesPanelLayout = new javax.swing.GroupLayout(locationPropertiesPanel);
        locationPropertiesPanel.setLayout(locationPropertiesPanelLayout);
        locationPropertiesPanelLayout.setHorizontalGroup(
            locationPropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1354, Short.MAX_VALUE)
        );
        locationPropertiesPanelLayout.setVerticalGroup(
            locationPropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(locationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locationPropertiesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(locationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(locationPropertiesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Locations", null, jPanel17, "");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(900, 700));
        jPanel5.setRequestFocusEnabled(false);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setMinimumSize(new java.awt.Dimension(100, 230));
        jPanel15.setName(""); // NOI18N
        jPanel15.setPreferredSize(new java.awt.Dimension(957, 230));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMaximumSize(new java.awt.Dimension(278, 32767));
        jPanel1.setMinimumSize(new java.awt.Dimension(278, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(278, 231));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("  House Population:");

        addHousePopulationButton.setText("+");
        addHousePopulationButton.setToolTipText("Add new population");
        addHousePopulationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHousePopulationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addHousePopulationButton))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addHousePopulationButton))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Number");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        housePopulationPercentageLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        housePopulationPercentageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        housePopulationPercentageLabel.setText("Percentage");
        housePopulationPercentageLabel.setToolTipText("");
        housePopulationPercentageLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(housePopulationPercentageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(housePopulationPercentageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout housePopulationPanelLayout = new javax.swing.GroupLayout(housePopulationPanel);
        housePopulationPanel.setLayout(housePopulationPanelLayout);
        housePopulationPanelLayout.setHorizontalGroup(
            housePopulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );
        housePopulationPanelLayout.setVerticalGroup(
            housePopulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(housePopulationPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setMinimumSize(new java.awt.Dimension(278, 0));
        jPanel12.setPreferredSize(new java.awt.Dimension(278, 231));

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel13.setPreferredSize(new java.awt.Dimension(130, 29));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setText("Sexe Distribution");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Name");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Percentage");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout sexePanelLayout = new javax.swing.GroupLayout(sexePanel);
        sexePanel.setLayout(sexePanelLayout);
        sexePanelLayout.setHorizontalGroup(
            sexePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );
        sexePanelLayout.setVerticalGroup(
            sexePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(sexePanel);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setMaximumSize(new java.awt.Dimension(430, 32767));
        jPanel9.setMinimumSize(new java.awt.Dimension(430, 0));
        jPanel9.setPreferredSize(new java.awt.Dimension(430, 231));

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setPreferredSize(new java.awt.Dimension(165, 29));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("  House Religion");
        jLabel9.setToolTipText("");

        addAgeButton.setText("+");
        addAgeButton.setToolTipText("Add new Religion");
        addAgeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAgeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addAgeButton))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addAgeButton)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setPreferredSize(new java.awt.Dimension(228, 35));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Religion name");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel11.setPreferredSize(new java.awt.Dimension(110, 18));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Percentage");
        jLabel12.setToolTipText("");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel12.setPreferredSize(new java.awt.Dimension(110, 18));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Prayer's place");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel17.setMaximumSize(new java.awt.Dimension(163, 14));
        jLabel17.setMinimumSize(new java.awt.Dimension(163, 14));
        jLabel17.setPreferredSize(new java.awt.Dimension(163, 14));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout religionPanelLayout = new javax.swing.GroupLayout(religionPanel);
        religionPanel.setLayout(religionPanelLayout);
        religionPanelLayout.setHorizontalGroup(
            religionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );
        religionPanelLayout.setVerticalGroup(
            religionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );

        jScrollPane6.setViewportView(religionPanel);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
            .addComponent(jScrollPane6)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        jPanel47.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel47.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel47.setName(""); // NOI18N
        jPanel47.setPreferredSize(new java.awt.Dimension(600, 378));

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setPreferredSize(new java.awt.Dimension(174, 29));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Year Distribution");

        addYeardistributionButton.setBackground(new java.awt.Color(255, 255, 255));
        addYeardistributionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/plus icon.jpg"))); // NOI18N
        addYeardistributionButton.setToolTipText("Add new distribution");
        addYeardistributionButton.setPreferredSize(new java.awt.Dimension(30, 30));
        addYeardistributionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addYeardistributionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                .addComponent(addYeardistributionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addYeardistributionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        agePanelFathef.setPreferredSize(new java.awt.Dimension(1500, 500));

        jPanel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setBackground(new Color(255,204,51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Min");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setPreferredSize(new java.awt.Dimension(20, 35));

        jLabel2.setBackground(new Color(255,204,51));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Max");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setPreferredSize(new java.awt.Dimension(24, 35));

        percentageOfHumanLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        percentageOfHumanLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        percentageOfHumanLabel.setText("% of human");
        percentageOfHumanLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        percentageOfHumanLabel.setPreferredSize(new java.awt.Dimension(63, 35));

        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel16.setPreferredSize(new java.awt.Dimension(124, 35));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("year");
        jLabel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        locationToGoPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        locationToGoPanel.setPreferredSize(new java.awt.Dimension(229, 35));

        javax.swing.GroupLayout locationToGoPanelLayout = new javax.swing.GroupLayout(locationToGoPanel);
        locationToGoPanel.setLayout(locationToGoPanelLayout);
        locationToGoPanelLayout.setHorizontalGroup(
            locationToGoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        locationToGoPanelLayout.setVerticalGroup(
            locationToGoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Work");
        jLabel18.setToolTipText("");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(percentageOfHumanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locationToGoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(percentageOfHumanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(locationToGoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        agePanel.setPreferredSize(new java.awt.Dimension(0, 400));

        javax.swing.GroupLayout agePanelLayout = new javax.swing.GroupLayout(agePanel);
        agePanel.setLayout(agePanelLayout);
        agePanelLayout.setHorizontalGroup(
            agePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1500, Short.MAX_VALUE)
        );
        agePanelLayout.setVerticalGroup(
            agePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout agePanelFathefLayout = new javax.swing.GroupLayout(agePanelFathef);
        agePanelFathef.setLayout(agePanelFathefLayout);
        agePanelFathefLayout.setHorizontalGroup(
            agePanelFathefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(agePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1500, Short.MAX_VALUE)
            .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        agePanelFathefLayout.setVerticalGroup(
            agePanelFathefLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agePanelFathefLayout.createSequentialGroup()
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(agePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(agePanelFathef);

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1332, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, 1336, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jScrollPane5.setViewportView(jPanel5);

        jTabbedPane1.addTab("Properties", null, jScrollPane5, "");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addHousePopulationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHousePopulationButtonActionPerformed
        HousePopulation hp = new HousePopulation(this.currentCity);
        this.housePopulationPanel.add(hp);
        Component c = Box.createVerticalStrut(3);
        hp.setComp(c);
        this.housePopulationPanel.add(c);
        this.currentCity.getListHousePopulations().add(hp);
        this.housePopulationPanel.revalidate();
        this.currentCity.setIsSaved(false);
        this.currentCity.checkHousePopulationPercentage();
        this.mainFrame.setCitySavedButtonEnable();
        this.mainFrame.setVisible(true);
    }//GEN-LAST:event_addHousePopulationButtonActionPerformed

    private void addYeardistributionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addYeardistributionButtonActionPerformed
//        ManageLocationToGoDistributionDialog dialog = new ManageLocationToGoDistributionDialog(this.mainFrame);
//        dialog.setVisible(true);
//        this.mainFrame.setEnabled(false);
        for (HumanCityAgeType ha : this.currentCity.getListHumanAgeType()) {
            if (!ha.isMinIsValid() || !ha.isMaxIsValid()) {
                JOptionPane.showOptionDialog(this.mainFrame, Messages.cantAddCityAge(), "Warning", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, Icons.WARNINGICON, null, null);
                return;
            }
        }
        HumanCityAgeType newAge = new HumanCityAgeType("Between -1 and -1", -1, -1, 0, 0, this.currentCity);
        this.currentCity.getListHumanAgeType().add(newAge);
        if (this.currentCity.isHaveBadHumanPercentageSum()) {
            newAge.getPercentageJtxt().setBackground(Colors.WARNINGCOLOR);
        }
        this.reinitAgePanel();
    }//GEN-LAST:event_addYeardistributionButtonActionPerformed

    private void addAgeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAgeButtonActionPerformed
        /* ReligionType rt = new ReligionType(" ", 10.0, this.currentCity);
        this.religionPanel.add(rt);
        Component c = Box.createVerticalStrut(3);
        rt.setComp(c);
        this.religionPanel.add(c);
        this.currentCity.getListrelReligionTypes().add(rt);
        this.currentCity.setIsSaved(false);
        this.mainFrame.setCitySavedButtonEnable();
        this.mainFrame.setVisible(true);*/
        ManageReligionGoDistributionDialog dialog = new ManageReligionGoDistributionDialog(this.mainFrame);
        dialog.setVisible(true);
        this.mainFrame.setEnabled(false);
    }//GEN-LAST:event_addAgeButtonActionPerformed

    public void removeReligion(ReligionType t) {
        this.religionPanel.remove(t);
        this.religionPanel.remove(t.getComp());
        this.mainFrame.setCitySavedButtonEnable();
        this.mainFrame.repaint();
    }

    public void removeHumaneAgeType(HumanCityAgeType ha) {
        this.agePanel.remove(ha);
        this.agePanel.remove(ha.getComp());
        this.mainFrame.setCitySavedButtonEnable();
        this.mainFrame.repaint();
    }

    public void removeHousePopulation(HousePopulation hp) {
        this.housePopulationPanel.remove(hp);
        this.housePopulationPanel.remove(hp.getComp());
        this.mainFrame.setCitySavedButtonEnable();
        this.mainFrame.repaint();
    }

    public void removeSexeType(SexeType s) {
        this.sexePanel.remove(s);
        this.sexePanel.remove(s.getComponent());
        this.mainFrame.setCitySavedButtonEnable();
        this.mainFrame.repaint();
    }

    public void addHousePopulationUse(boolean state) {
        if (state) {
            this.jPanel1.setVisible(true);
            Data.initHousePopulationPercentage(this.currentCity.getListHousePopulations());

        } else {
            this.jPanel1.setVisible(false);
            Data.initHousePopulationPercentage(new ArrayList());
        }
    }

    public void addSexeTypeUse(boolean state) {
        if (state) {
            this.jPanel12.setVisible(true);
            Data.initHumanSex(this.currentCity.getListSexeType());

        } else {
            this.jPanel12.setVisible(false);
            Data.initHumanSex(new ArrayList());
        }
    }

    public void addHouseReligionUse(boolean state) {
        if (state) {
            this.jPanel9.setVisible(true);
            Data.initHouseReligionTypePercentage(this.currentCity.getListrelReligionTypes());

        } else {
            this.jPanel9.setVisible(false);
            Data.initHouseReligionTypePercentage(new ArrayList());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAgeButton;
    private javax.swing.JButton addHousePopulationButton;
    private javax.swing.JButton addYeardistributionButton;
    private javax.swing.JPanel agePanel;
    private javax.swing.JPanel agePanelFathef;
    private javax.swing.JPanel housePopulationPanel;
    public javax.swing.JLabel housePopulationPercentageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel locationPanel;
    private javax.swing.JPanel locationPropertiesPanel;
    private javax.swing.JPanel locationToGoPanel;
    public javax.swing.JLabel percentageOfHumanLabel;
    private javax.swing.JPanel religionPanel;
    private javax.swing.JPanel sexePanel;
    // End of variables declaration//GEN-END:variables
}
