package views1.model.panel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import models.client1.City;
import models.location1.LocationCategory;
import models.model.HumanAge;
import models.model.Model;
import models.model.ModelLocationRow;
import models.model.SymptomStage;
import models.model.SymptomType;
import views1.MainFrame;
import views1.model.dialog.ManageHumanAgeDistributionDialog;
import views1.model.dialog.ManageSymptomStageDistributionDialog;

public class ModelPanel extends javax.swing.JPanel {

    private final JTabbedPane pane;
    private final ButtonTilte button;
    private Model currentModel;
    private MainFrame mainframe;

    public ModelPanel(MainFrame frame, Model model, JTabbedPane pane) {
        initComponents();
        this.mainframe = frame;
        this.currentModel = model;
        this.currentModel.setModelPanel(this);
        this.pane = pane;
        this.currentModel.setMainFrame(frame);
        this.button = new ButtonTilte(this);
        this.locationPanel.setLayout(new BoxLayout(this.locationPanel, BoxLayout.Y_AXIS));
        initPanel();
        initAgePanel();
        initAgePanel1();
        initLocationPanel();
        int width = this.currentModel.getListSymptomStage().size() * 123 + 300;
        this.jPanel11.setPreferredSize(new Dimension(width, this.jPanel11.getHeight()));
        int wid = this.currentModel.getListHumanAge().size() * 123 + 150;
        this.jPanel6.setPreferredSize(new Dimension(wid, this.jPanel6.getHeight()));
    }

    private void initPanel() {
        this.symptomNamePane.setLayout(new BoxLayout(this.symptomNamePane, BoxLayout.Y_AXIS));
        this.contagiousDaysPanel.setLayout(new BoxLayout(this.contagiousDaysPanel, BoxLayout.Y_AXIS));
        this.symptomsDayPanel.setLayout(new BoxLayout(this.symptomsDayPanel, BoxLayout.Y_AXIS));
        this.symptomStageNamePanel.setLayout(new BoxLayout(this.symptomStageNamePanel, BoxLayout.X_AXIS));
        this.immunePanel.setLayout(new BoxLayout(this.immunePanel, BoxLayout.X_AXIS));
        this.deathPanel.setLayout(new BoxLayout(this.deathPanel, BoxLayout.X_AXIS));
        this.humanStatPanel.setLayout(new BoxLayout(this.humanStatPanel, BoxLayout.X_AXIS));
        for (SymptomType st : this.currentModel.getListSymptomsType()) {
            st.setModel(this.currentModel);
            this.symptomNamePane.add(st.getName1());
            Component c1 = Box.createVerticalStrut(3);
            st.setcName1(c1);
            this.symptomNamePane.add(c1);

            this.contagiousDaysPanel.add(st.getDayTxt());
            Component c2 = Box.createVerticalStrut(3);
            st.setcContDay(c2);
            this.contagiousDaysPanel.add(c2);

            this.symptomsDayPanel.add(st);
            Component c3 = Box.createVerticalStrut(3);
            st.setcState(c3);
            this.symptomsDayPanel.add(c3);
        }

        for (SymptomStage st : this.currentModel.getListSymptomStage()) {
            st.setModel(this.currentModel);
            this.symptomStageNamePanel.add(st.getNameLabel1());
            Component c1 = Box.createHorizontalStrut(3);
            st.setcName1(c1);
            this.symptomStageNamePanel.add(c1);

            this.immunePanel.add(st.getImmunePercentageTxt());
            Component c2 = Box.createHorizontalStrut(3);
            st.setiComponent(c2);
            this.immunePanel.add(c2);

            this.deathPanel.add(st.getDeathPercentageTxt());
            Component c3 = Box.createHorizontalStrut(3);
            st.setdComponent(c3);
            this.deathPanel.add(c3);

            this.humanStatPanel.add(st.getHumanStatBox());
            this.humanStatPanel.add(st.getcHumanStateBox());

        }
    }

    private void initPanel1() {
        this.symptomNamePane.setLayout(new BoxLayout(this.symptomNamePane, BoxLayout.Y_AXIS));
        this.contagiousDaysPanel.setLayout(new BoxLayout(this.contagiousDaysPanel, BoxLayout.Y_AXIS));
        this.symptomsDayPanel.setLayout(new BoxLayout(this.symptomsDayPanel, BoxLayout.Y_AXIS));
        this.symptomStageNamePanel.setLayout(new BoxLayout(this.symptomStageNamePanel, BoxLayout.X_AXIS));
        this.immunePanel.setLayout(new BoxLayout(this.immunePanel, BoxLayout.X_AXIS));
        this.deathPanel.setLayout(new BoxLayout(this.deathPanel, BoxLayout.X_AXIS));
        this.humanStatPanel.setLayout(new BoxLayout(this.humanStatPanel, BoxLayout.X_AXIS));
        for (SymptomType st : this.currentModel.getListSymptomsType()) {
            // st.setModel(this.currentModel);
            this.symptomNamePane.add(st.getName1());
            Component c1 = Box.createVerticalStrut(3);
            st.setcName1(c1);
            this.symptomNamePane.add(c1);

            this.contagiousDaysPanel.add(st.getDayTxt());
            Component c2 = Box.createVerticalStrut(3);
            st.setcContDay(c2);
            this.contagiousDaysPanel.add(c2);

            this.symptomsDayPanel.add(st);
            Component c3 = Box.createVerticalStrut(3);
            st.setcState(c3);
            this.symptomsDayPanel.add(c3);
        }

        for (SymptomStage st : this.currentModel.getListSymptomStage()) {
            // st.setModel(this.currentModel);
            this.symptomStageNamePanel.add(st.getNameLabel1());
            Component c1 = Box.createHorizontalStrut(3);
            st.setcName1(c1);
            this.symptomStageNamePanel.add(c1);

            this.immunePanel.add(st.getImmunePercentageTxt());
            Component c2 = Box.createHorizontalStrut(3);
            st.setiComponent(c2);
            this.immunePanel.add(c2);

            this.deathPanel.add(st.getDeathPercentageTxt());
            Component c3 = Box.createHorizontalStrut(3);
            st.setdComponent(c3);
            this.deathPanel.add(c3);

            this.humanStatPanel.add(st.getHumanStatBox());
            this.humanStatPanel.add(st.getcHumanStateBox());

        }
    }

    private void initAgePanel() {

        this.ageNamePanel.setLayout(new BoxLayout(this.ageNamePanel, BoxLayout.X_AXIS));
        this.symptomsAgeNamePanel.setLayout(new BoxLayout(this.symptomsAgeNamePanel, BoxLayout.Y_AXIS));
        this.symptomsAgePanel.setLayout(new BoxLayout(this.symptomsAgePanel, BoxLayout.Y_AXIS));
        this.minAgePanel.setLayout(new BoxLayout(this.minAgePanel, BoxLayout.X_AXIS));
        this.maxAgePanel.setLayout(new BoxLayout(this.maxAgePanel, BoxLayout.X_AXIS));

        for (SymptomType st : this.currentModel.getListSymptomsType()) {
            this.symptomsAgeNamePanel.add(st.getName2());
            this.symptomsAgeNamePanel.add(st.getcName2());

            this.symptomsAgePanel.add(st.getAgePanel());
            this.symptomsAgePanel.add(st.getcAgePanel());
        }
        for (HumanAge ha : this.currentModel.getListHumanAge()) {
            ha.setModel(this.currentModel);
            this.ageNamePanel.add(ha.getNameLabel());
            this.ageNamePanel.add(ha.getcName());

            this.minAgePanel.add(ha.getMinAgeTxt());
            this.minAgePanel.add(ha.getcMinAge());

            this.maxAgePanel.add(ha.getMaxAgeTxt());
            this.maxAgePanel.add(ha.getcMaxAge());
        }
    }

    private void initAgePanel1() {

        this.ageNamePanel.setLayout(new BoxLayout(this.ageNamePanel, BoxLayout.X_AXIS));
        this.symptomsAgeNamePanel.setLayout(new BoxLayout(this.symptomsAgeNamePanel, BoxLayout.Y_AXIS));
        this.symptomsAgePanel.setLayout(new BoxLayout(this.symptomsAgePanel, BoxLayout.Y_AXIS));
        this.minAgePanel.setLayout(new BoxLayout(this.minAgePanel, BoxLayout.X_AXIS));
        this.maxAgePanel.setLayout(new BoxLayout(this.maxAgePanel, BoxLayout.X_AXIS));

        for (SymptomType st : this.currentModel.getListSymptomsType()) {
            this.symptomsAgeNamePanel.add(st.getName2());
            this.symptomsAgeNamePanel.add(st.getcName2());

            this.symptomsAgePanel.add(st.getAgePanel());
            this.symptomsAgePanel.add(st.getcAgePanel());
        }
        for (HumanAge ha : this.currentModel.getListHumanAge()) {
            //ha.setModel(this.currentModel);
            this.ageNamePanel.add(ha.getNameLabel());
            this.ageNamePanel.add(ha.getcName());

            this.minAgePanel.add(ha.getMinAgeTxt());
            this.minAgePanel.add(ha.getcMinAge());

            this.maxAgePanel.add(ha.getMaxAgeTxt());
            this.maxAgePanel.add(ha.getcMaxAge());
        }
    }

    private void initLocationPanel() {
        if (this.currentModel.getCity() != null) {
            this.jPanel30.setVisible(true);
            System.out.println("city not null");
            for (Entry<String, LocationCategory> e : this.currentModel.getCity().getMapLocation().entrySet()) {
                System.out.println("");
                this.locationPanel.add(new ModelLocationRow(e.getValue(), this.currentModel));
                this.locationPanel.add(Box.createVerticalStrut(3));
            }
        } else {
            this.jPanel30.setVisible(false);
        }
    }

    public ModelPanel(MainFrame frame, String name, JTabbedPane pane, City c) {
        initComponents();
        this.mainframe = frame;
        this.currentModel = new Model(name, frame, c);
        this.currentModel.setModelPanel(this);
        this.pane = pane;
        this.button = new ButtonTilte(this);

        initPanel1();
        initAgePanel1();
        initLocationPanel();
        int width = this.currentModel.getListSymptomStage().size() * 123 + 300;
        this.jPanel11.setPreferredSize(new Dimension(width, this.jPanel11.getHeight()));
        int wid = this.currentModel.getListHumanAge().size() * 123 + 150;
        this.jPanel6.setPreferredSize(new Dimension(wid, this.jPanel6.getHeight()));
        this.mainframe.repaint();
    }

    public ButtonTilte getButton() {
        return button;
    }

    public Model getModel() {
        return currentModel;
    }

    public void setModel(Model model) {
        this.currentModel = model;
    }

    public void removeThisTab() {
        int i = pane.indexOfComponent(this);
        pane.removeTabAt(i);
    }

    public class ButtonTilte extends JPanel implements ActionListener {

        private ModelPanel mp;

        public ButtonTilte(ModelPanel mp) {
            this.mp = mp;
            initComponents();
            this.jButton1.addActionListener(this);
        }

        public ModelPanel getMp() {
            return mp;
        }

        private void initComponents() {

            jLabel1 = new javax.swing.JLabel();
            jButton1 = new javax.swing.JButton();

            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText(this.mp.getModel().getModelName());

            jButton1.setText("X");
            jButton1.setToolTipText("");
            jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(14, 14, 14)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
        }

        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel1;

        @Override
        public void actionPerformed(ActionEvent e) {
            mainframe.closeModel(this.mp.getModel());
            int i = pane.indexOfComponent(mp);
            pane.removeTabAt(i);
            mainframe.removeGenerateLocationMenu(currentModel.getMapMenu());
            mainframe.removePauseMenu(currentModel.getPauseMenu());
            mainframe.removeRunMenu(currentModel.getPauseMenu());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel36 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        manageSymptomStageDistributionButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        symptomStageNamePanel = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel19 = new javax.swing.JPanel();
        symptomNamePane = new javax.swing.JPanel();
        contagiousDaysPanel = new javax.swing.JPanel();
        symptomsDayPanel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        deathPanel = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        immunePanel = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        humanStatPanel = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        manageAgeButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        ageNamePanel = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel10 = new javax.swing.JPanel();
        symptomsAgeNamePanel = new javax.swing.JPanel();
        symptomsAgePanel = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        minAgePanel = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        maxAgePanel = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        modelLocationPanel = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        locationPanel = new javax.swing.JPanel();

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1000, 750));

        jPanel36.setPreferredSize(new java.awt.Dimension(1000, 1200));

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setPreferredSize(new java.awt.Dimension(1000, 400));

        jPanel1.setPreferredSize(new java.awt.Dimension(996, 35));

        manageSymptomStageDistributionButton.setText("ManageButton");
        manageSymptomStageDistributionButton.setToolTipText("");
        manageSymptomStageDistributionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageSymptomStageDistributionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(manageSymptomStageDistributionButton))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(manageSymptomStageDistributionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(996, 373));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(996, 373));

        jPanel11.setPreferredSize(new java.awt.Dimension(994, 310));

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setPreferredSize(new java.awt.Dimension(1000, 35));

        symptomStageNamePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        symptomStageNamePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        symptomStageNamePanel.setPreferredSize(new java.awt.Dimension(687, 4));

        javax.swing.GroupLayout symptomStageNamePanelLayout = new javax.swing.GroupLayout(symptomStageNamePanel);
        symptomStageNamePanel.setLayout(symptomStageNamePanelLayout);
        symptomStageNamePanelLayout.setHorizontalGroup(
            symptomStageNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        symptomStageNamePanelLayout.setVerticalGroup(
            symptomStageNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel15.setAlignmentX(Component.RIGHT_ALIGNMENT);
        jPanel15.setPreferredSize(new java.awt.Dimension(130, 31));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Contagious days");
        jLabel4.setAlignmentX(Component.RIGHT_ALIGNMENT);
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.setPreferredSize(new java.awt.Dimension(130, 18));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel18.setAlignmentX(Component.LEFT_ALIGNMENT);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Symptoms");
        jLabel3.setAlignmentX(Component.LEFT_ALIGNMENT);
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel22.setAlignmentX(Component.RIGHT_ALIGNMENT);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(symptomStageNamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(symptomStageNamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setPreferredSize(new java.awt.Dimension(900, 280));

        jPanel19.setPreferredSize(new java.awt.Dimension(900, 170));

        symptomNamePane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        symptomNamePane.setAlignmentX(Component.LEFT_ALIGNMENT);
        symptomNamePane.setPreferredSize(new java.awt.Dimension(134, 4));

        javax.swing.GroupLayout symptomNamePaneLayout = new javax.swing.GroupLayout(symptomNamePane);
        symptomNamePane.setLayout(symptomNamePaneLayout);
        symptomNamePaneLayout.setHorizontalGroup(
            symptomNamePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        symptomNamePaneLayout.setVerticalGroup(
            symptomNamePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 171, Short.MAX_VALUE)
        );

        contagiousDaysPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        contagiousDaysPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        contagiousDaysPanel.setPreferredSize(new java.awt.Dimension(134, 4));

        javax.swing.GroupLayout contagiousDaysPanelLayout = new javax.swing.GroupLayout(contagiousDaysPanel);
        contagiousDaysPanel.setLayout(contagiousDaysPanelLayout);
        contagiousDaysPanelLayout.setHorizontalGroup(
            contagiousDaysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        contagiousDaysPanelLayout.setVerticalGroup(
            contagiousDaysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        symptomsDayPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        symptomsDayPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        symptomsDayPanel.setPreferredSize(new java.awt.Dimension(687, 173));

        javax.swing.GroupLayout symptomsDayPanelLayout = new javax.swing.GroupLayout(symptomsDayPanel);
        symptomsDayPanel.setLayout(symptomsDayPanelLayout);
        symptomsDayPanelLayout.setHorizontalGroup(
            symptomsDayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
        );
        symptomsDayPanelLayout.setVerticalGroup(
            symptomsDayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 171, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(symptomNamePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(symptomsDayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(contagiousDaysPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(symptomNamePane, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
            .addComponent(symptomsDayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
            .addComponent(contagiousDaysPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel19);

        jPanel12.setPreferredSize(new java.awt.Dimension(1400, 86));

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel13.setPreferredSize(new java.awt.Dimension(992, 40));

        jPanel17.setBackground(new java.awt.Color(51, 51, 0));
        jPanel17.setAlignmentX(Component.RIGHT_ALIGNMENT);
        jPanel17.setPreferredSize(new java.awt.Dimension(148, 0));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        deathPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        deathPanel.setPreferredSize(new java.awt.Dimension(687, 36));
        deathPanel.setRequestFocusEnabled(false);

        javax.swing.GroupLayout deathPanelLayout = new javax.swing.GroupLayout(deathPanel);
        deathPanel.setLayout(deathPanelLayout);
        deathPanelLayout.setHorizontalGroup(
            deathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        deathPanelLayout.setVerticalGroup(
            deathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel21.setAlignmentX(Component.LEFT_ALIGNMENT);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Death precentage");
        jLabel5.setToolTipText("");
        jLabel5.setAlignmentX(Component.LEFT_ALIGNMENT);
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel5.setPreferredSize(new java.awt.Dimension(91, 32));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(deathPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(deathPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel14.setPreferredSize(new java.awt.Dimension(992, 40));

        immunePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        immunePanel.setPreferredSize(new java.awt.Dimension(687, 36));

        javax.swing.GroupLayout immunePanelLayout = new javax.swing.GroupLayout(immunePanel);
        immunePanel.setLayout(immunePanelLayout);
        immunePanelLayout.setHorizontalGroup(
            immunePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        immunePanelLayout.setVerticalGroup(
            immunePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel16.setBackground(new java.awt.Color(51, 51, 0));
        jPanel16.setAlignmentX(Component.RIGHT_ALIGNMENT);
        jPanel16.setPreferredSize(new java.awt.Dimension(148, 32));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel20.setAlignmentX(Component.LEFT_ALIGNMENT);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Immune Percentage");
        jLabel6.setAlignmentX(Component.LEFT_ALIGNMENT);
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel6.setPreferredSize(new java.awt.Dimension(100, 32));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(immunePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(immunePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel31.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel31.setPreferredSize(new java.awt.Dimension(0, 40));

        jPanel29.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel29.setPreferredSize(new java.awt.Dimension(134, 36));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Human state");
        jLabel10.setToolTipText("");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        humanStatPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout humanStatPanelLayout = new javax.swing.GroupLayout(humanStatPanel);
        humanStatPanel.setLayout(humanStatPanelLayout);
        humanStatPanelLayout.setHorizontalGroup(
            humanStatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        humanStatPanelLayout.setVerticalGroup(
            humanStatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel32.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(humanStatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(humanStatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
            .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel11);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel1.setText("    Distribution of the symptoms in symptom stages");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 374));

        jLabel2.setText("Distribution of symptoms over ages ");

        manageAgeButton.setText("Manage");
        manageAgeButton.setToolTipText("");
        manageAgeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAgeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageAgeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(manageAgeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setPreferredSize(new java.awt.Dimension(1003, 329));

        jPanel6.setPreferredSize(new java.awt.Dimension(994, 310));

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setPreferredSize(new java.awt.Dimension(994, 35));

        ageNamePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ageNamePanel.setPreferredSize(new java.awt.Dimension(0, 31));

        javax.swing.GroupLayout ageNamePanelLayout = new javax.swing.GroupLayout(ageNamePanel);
        ageNamePanel.setLayout(ageNamePanelLayout);
        ageNamePanelLayout.setHorizontalGroup(
            ageNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 908, Short.MAX_VALUE)
        );
        ageNamePanelLayout.setVerticalGroup(
            ageNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel27.setPreferredSize(new java.awt.Dimension(134, 31));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Symptoms");
        jLabel7.setToolTipText("");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel7.setPreferredSize(new java.awt.Dimension(130, 27));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ageNamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setPreferredSize(new java.awt.Dimension(900, 102));

        jPanel10.setPreferredSize(new java.awt.Dimension(900, 100));

        symptomsAgeNamePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        symptomsAgeNamePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        symptomsAgeNamePanel.setPreferredSize(new java.awt.Dimension(134, 4));

        javax.swing.GroupLayout symptomsAgeNamePanelLayout = new javax.swing.GroupLayout(symptomsAgeNamePanel);
        symptomsAgeNamePanel.setLayout(symptomsAgeNamePanelLayout);
        symptomsAgeNamePanelLayout.setHorizontalGroup(
            symptomsAgeNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        symptomsAgeNamePanelLayout.setVerticalGroup(
            symptomsAgeNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        symptomsAgePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout symptomsAgePanelLayout = new javax.swing.GroupLayout(symptomsAgePanel);
        symptomsAgePanel.setLayout(symptomsAgePanelLayout);
        symptomsAgePanelLayout.setHorizontalGroup(
            symptomsAgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        symptomsAgePanelLayout.setVerticalGroup(
            symptomsAgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(symptomsAgeNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(symptomsAgePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(symptomsAgeNamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
            .addComponent(symptomsAgePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(jPanel10);

        jPanel26.setPreferredSize(new java.awt.Dimension(1400, 87));

        jPanel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel23.setPreferredSize(new java.awt.Dimension(354, 40));

        jPanel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel24.setPreferredSize(new java.awt.Dimension(134, 36));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Min Age");
        jLabel8.setToolTipText("");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel8.setPreferredSize(new java.awt.Dimension(130, 32));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        minAgePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout minAgePanelLayout = new javax.swing.GroupLayout(minAgePanel);
        minAgePanel.setLayout(minAgePanelLayout);
        minAgePanelLayout.setHorizontalGroup(
            minAgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        minAgePanelLayout.setVerticalGroup(
            minAgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(minAgePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minAgePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel25.setPreferredSize(new java.awt.Dimension(311, 40));

        jPanel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel28.setPreferredSize(new java.awt.Dimension(134, 36));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Max Age");
        jLabel9.setToolTipText("");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel9.setPreferredSize(new java.awt.Dimension(130, 32));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        maxAgePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout maxAgePanelLayout = new javax.swing.GroupLayout(maxAgePanel);
        maxAgePanel.setLayout(maxAgePanelLayout);
        maxAgePanelLayout.setHorizontalGroup(
            maxAgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        maxAgePanelLayout.setVerticalGroup(
            maxAgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(maxAgePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(maxAgePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane4.setViewportView(jPanel6);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
        );

        jPanel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel33.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel33.setPreferredSize(new java.awt.Dimension(4, 40));

        jLabel11.setText("Location");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel35.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        modelLocationPanel.setPreferredSize(new java.awt.Dimension(1029, 500));

        jPanel34.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Locations");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Monday");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Tuesday");
        jLabel14.setToolTipText("");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Wednesday");
        jLabel15.setToolTipText("");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Thursday");
        jLabel16.setToolTipText("");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Friday");
        jLabel17.setToolTipText("");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Saturday");
        jLabel18.setToolTipText("");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Sunday");
        jLabel19.setToolTipText("");
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Open time");
        jLabel20.setToolTipText("");
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Close time");
        jLabel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 232, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        locationPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout locationPanelLayout = new javax.swing.GroupLayout(locationPanel);
        locationPanel.setLayout(locationPanelLayout);
        locationPanelLayout.setHorizontalGroup(
            locationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        locationPanelLayout.setVerticalGroup(
            locationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout modelLocationPanelLayout = new javax.swing.GroupLayout(modelLocationPanel);
        modelLocationPanel.setLayout(modelLocationPanelLayout);
        modelLocationPanelLayout.setHorizontalGroup(
            modelLocationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(locationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        modelLocationPanelLayout.setVerticalGroup(
            modelLocationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modelLocationPanelLayout.createSequentialGroup()
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane6.setViewportView(modelLocationPanel);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
            .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel36);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1377, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageSymptomStageDistributionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageSymptomStageDistributionButtonActionPerformed
        ManageSymptomStageDistributionDialog dialog = new ManageSymptomStageDistributionDialog(mainframe);
        this.mainframe.setEnabled(false);
        dialog.setVisible(true);
    }//GEN-LAST:event_manageSymptomStageDistributionButtonActionPerformed

    private void manageAgeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAgeButtonActionPerformed
        ManageHumanAgeDistributionDialog dialog = new ManageHumanAgeDistributionDialog(mainframe);
        this.mainframe.setEnabled(false);
        dialog.setVisible(true);
    }//GEN-LAST:event_manageAgeButtonActionPerformed

    public void updateSymptomeStagePanel() {
        this.symptomStageNamePanel.removeAll();
        this.immunePanel.removeAll();
        this.deathPanel.removeAll();
        this.humanStatPanel.removeAll();
        for (SymptomStage st : this.currentModel.getListSymptomStage()) {
            //st.setModel(this.currentModel);
            this.symptomStageNamePanel.add(st.getNameLabel1(), st.getIndex());
            Component c1 = Box.createHorizontalStrut(3);
            st.setcName1(c1);
            this.symptomStageNamePanel.add(c1, st.getIndex() + 1);

            this.immunePanel.add(st.getImmunePercentageTxt(), st.getIndex());
            Component c2 = Box.createHorizontalStrut(3);
            st.setiComponent(c2);
            this.immunePanel.add(c2, st.getIndex() + 1);

            this.deathPanel.add(st.getDeathPercentageTxt(), st.getIndex());
            Component c3 = Box.createHorizontalStrut(3);
            st.setdComponent(c3);
            this.deathPanel.add(c3, st.getIndex() + 1);

            this.humanStatPanel.add(st.getHumanStatBox());
            this.humanStatPanel.add(st.getcHumanStateBox());
        }
        int width = this.currentModel.getListSymptomStage().size() * 123 + 300;
        this.jPanel11.setPreferredSize(new Dimension(width, this.jPanel11.getHeight()));
    }

    public void updateHumanAgePanel() {
        this.ageNamePanel.removeAll();
        this.minAgePanel.removeAll();
        this.maxAgePanel.removeAll();
        int wid = this.currentModel.getListHumanAge().size() * 123 + 150;
        this.jPanel6.setPreferredSize(new Dimension(wid, this.jPanel6.getHeight()));
        for (HumanAge ha : this.currentModel.getListHumanAge()) {
            this.ageNamePanel.add(ha.getNameLabel());
            this.ageNamePanel.add(ha.getcName());

            this.minAgePanel.add(ha.getMinAgeTxt());
            this.minAgePanel.add(ha.getcMinAge());

            this.maxAgePanel.add(ha.getMaxAgeTxt());
            this.maxAgePanel.add(ha.getcMaxAge());
        }
        this.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ageNamePanel;
    private javax.swing.JPanel contagiousDaysPanel;
    private javax.swing.JPanel deathPanel;
    private javax.swing.JPanel humanStatPanel;
    private javax.swing.JPanel immunePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel locationPanel;
    private javax.swing.JButton manageAgeButton;
    private javax.swing.JButton manageSymptomStageDistributionButton;
    private javax.swing.JPanel maxAgePanel;
    private javax.swing.JPanel minAgePanel;
    private javax.swing.JPanel modelLocationPanel;
    private javax.swing.JPanel symptomNamePane;
    private javax.swing.JPanel symptomStageNamePanel;
    private javax.swing.JPanel symptomsAgeNamePanel;
    private javax.swing.JPanel symptomsAgePanel;
    private javax.swing.JPanel symptomsDayPanel;
    // End of variables declaration//GEN-END:variables
}
