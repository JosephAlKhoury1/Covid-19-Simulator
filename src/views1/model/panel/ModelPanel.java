package views1.model.panel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Map.Entry;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import models.client1.City;
import models.location1.LocationCategory;
import models.model.HumanAge;
import models.model.Model;
import models.model.ModelLocationRow;
import models.model.SymptomStage;
import models.model.SymptomType;
import resources.icon.Colors;
import views1.MainFrame;
import views1.model.dialog.ManageSymptomStagesDialog;
import views1.model.dialog.ManageSymptomTypeDialog;

public class ModelPanel extends javax.swing.JPanel {

    private final JTabbedPane pane;
    private final ButtonTilte button;
    private Model currentModel;
    private MainFrame mainframe;

    private JLabel minAgeName, maxAgeName;

    public ModelPanel(MainFrame frame, Model model, JTabbedPane pane) {
        initComponents();
        this.statistiquePanel.setLayout(new BoxLayout(this.statistiquePanel, BoxLayout.Y_AXIS));
        this.mainframe = frame;
        this.currentModel = model;
        this.currentModel.setModelPanel(this);
        this.pane = pane;
        this.currentModel.setMainFrame(frame);
        this.button = new ButtonTilte(this);
        this.locationPanel.setLayout(new BoxLayout(this.locationPanel, BoxLayout.Y_AXIS));
        initPanel();
        initAgePanel();
        initSymptomPanel();
        initLocationPanel();

        JTextFieldIntegerListener jtlistener = new JTextFieldIntegerListener(this.infectedNunberTxt);
        this.infectedNunberTxt.addFocusListener(jtlistener);
        this.infectedNunberTxt.getDocument().addDocumentListener(jtlistener);
    }

    private void initSymptomPanel() {
        this.symptomStageNonHospitalPanel.setLayout(new BoxLayout(this.symptomStageNonHospitalPanel, BoxLayout.Y_AXIS));
        this.symptomStageHospitalPanel.setLayout(new BoxLayout(this.symptomStageHospitalPanel, BoxLayout.Y_AXIS));

        this.noHospitalPanel.setPreferredSize(new Dimension(this.noHospitalPanel.getWidth(), this.currentModel.getListSymptomStage1sNonHospital().size() * 38));
        this.hospitalPanel.setPreferredSize(new Dimension(this.hospitalPanel.getWidth(), this.currentModel.getListSymptomStage1sHospital().size() * 38));

        this.jPanel13.setPreferredSize(new Dimension(this.jPanel13.getWidth(), (this.currentModel.getListSymptomStage1sNonHospital().size() + this.currentModel.getListSymptomStage1sHospital().size()) * 38));

        for (SymptomStage stg : this.currentModel.getListSymptomStage1sNonHospital()) {
            this.symptomStageNonHospitalPanel.add(stg.getPanel());
        }
        for (SymptomStage stg : this.currentModel.getListSymptomStage1sHospital()) {
            this.symptomStageHospitalPanel.add(stg.getPanel());
        }
    }

    public void reinitSymptomPanel() {
        this.symptomStageHospitalPanel.removeAll();
        this.symptomStageNonHospitalPanel.removeAll();
        this.noHospitalPanel.setPreferredSize(new Dimension(this.noHospitalPanel.getWidth(), this.currentModel.getListSymptomStage1sNonHospital().size() * 38));
        this.hospitalPanel.setPreferredSize(new Dimension(this.hospitalPanel.getWidth(), this.currentModel.getListSymptomStage1sHospital().size() * 38));

        this.jPanel13.setPreferredSize(new Dimension(this.jPanel13.getWidth(), (this.currentModel.getListSymptomStage1sNonHospital().size() + this.currentModel.getListSymptomStage1sHospital().size()) * 38));

        for (SymptomStage stg : this.currentModel.getListSymptomStage1sNonHospital()) {
            this.symptomStageNonHospitalPanel.add(stg.getPanel());
        }
        for (SymptomStage stg : this.currentModel.getListSymptomStage1sHospital()) {
            this.symptomStageHospitalPanel.add(stg.getPanel());
        }
        this.mainframe.setVisible(true);
    }

    private void initPanel() {
        this.symptomNamePane.setLayout(new BoxLayout(this.symptomNamePane, BoxLayout.Y_AXIS));
        this.contagiousDaysPanel.setLayout(new BoxLayout(this.contagiousDaysPanel, BoxLayout.Y_AXIS));

        this.symptomsDayPanel.setLayout(new BoxLayout(this.symptomsDayPanel, BoxLayout.Y_AXIS));
        this.symptomStageNamePanel.setLayout(new BoxLayout(this.symptomStageNamePanel, BoxLayout.X_AXIS));

        this.nonHospitalNamePanel.setPreferredSize(new Dimension(this.currentModel.getListSymptomStage1sNonHospital().size() * 122, this.nonHospitalNamePanel.getHeight()));
        this.hospitalPanelName.setPreferredSize(new Dimension(this.currentModel.getListSymptomStage1sHospital().size() * 122, this.hospitalPanelName.getHeight()));

        int index = 1;
        while (index < this.currentModel.getListSymptomStage1sNonHospital().size() + 1) {
            for (SymptomStage stg : this.currentModel.getListSymptomStage1sNonHospital()) {
                if (stg.getIndex() == index) {
                    this.symptomStageNamePanel.add(stg.getNameLabel2());
                    index++;
                }
            }
        }
        index = this.currentModel.getListSymptomStage1sNonHospital().size() + 1;
        while (index < (this.currentModel.getListSymptomStage1sHospital().size() + this.currentModel.getListSymptomStage1sNonHospital().size() + 1)) {
            for (SymptomStage stg : this.currentModel.getListSymptomStage1sHospital()) {
                if (stg.getIndex() == index) {
                    this.symptomStageNamePanel.add(stg.getNameLabel2());
                    index++;
                }
            }
        }

        for (SymptomType st : this.currentModel.getListSymptomType()) {
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
        this.repaint();
    }

    public void reinitPanel() {
        this.symptomStageNamePanel.removeAll();
        this.symptomNamePane.removeAll();
        this.symptomsDayPanel.removeAll();
        this.contagiousDaysPanel.removeAll();

        this.nonHospitalNamePanel.setPreferredSize(new Dimension(this.currentModel.getListSymptomStage1sNonHospital().size() * 122, this.nonHospitalNamePanel.getHeight()));
        this.hospitalPanelName.setPreferredSize(new Dimension(this.currentModel.getListSymptomStage1sHospital().size() * 122, this.hospitalPanelName.getHeight()));
        this.nonHospitalNamePanel.setSize(new Dimension(this.currentModel.getListSymptomStage1sNonHospital().size() * 122, this.nonHospitalNamePanel.getHeight()));
        this.hospitalPanelName.setSize(new Dimension(this.currentModel.getListSymptomStage1sHospital().size() * 122, this.hospitalPanelName.getHeight()));

        this.jPanel17.setPreferredSize(new Dimension(this.jPanel17.getWidth(), this.currentModel.getListSymptomType().size() * 38));
        this.jPanel17.setSize(new Dimension(this.jPanel17.getWidth(), this.currentModel.getListSymptomType().size() * 38));

        int wid = (this.currentModel.getListSymptomStage1sNonHospital().size() + this.currentModel.getListSymptomStage1sHospital().size()) * 120 + 380;
        this.jPanel11.setPreferredSize(new Dimension(wid, this.jPanel11.getHeight()));
        this.jPanel11.setSize(new Dimension(wid, this.jPanel11.getHeight()));

        int index = 1;
        while (index < this.currentModel.getListSymptomStage1sNonHospital().size() + 1) {
            for (SymptomStage stg : this.currentModel.getListSymptomStage1sNonHospital()) {
                if (stg.getIndex() == index) {
                    this.symptomStageNamePanel.add(stg.getNameLabel2());
                    index++;
                }
            }
        }
        index = this.currentModel.getListSymptomStage1sNonHospital().size() + 1;
        while (index < (this.currentModel.getListSymptomStage1sHospital().size() + this.currentModel.getListSymptomStage1sNonHospital().size() + 1)) {
            for (SymptomStage stg : this.currentModel.getListSymptomStage1sHospital()) {
                if (stg.getIndex() == index) {
                    this.symptomStageNamePanel.add(stg.getNameLabel2());
                    index++;
                }
            }
        }
        for (SymptomType st : this.currentModel.getListSymptomType()) {
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
        this.symptomStageNamePanel.repaint();
        this.symptomStageNamePanel.setVisible(true);
        this.mainframe.setVisible(true);
    }

    public JPanel getStatistiquePanel() {
        return statistiquePanel;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    private void initAgePanel() {
        this.minAgeName = new JLabel("Min age");
        this.minAgeName.setPreferredSize(new Dimension(130, 31));
        this.minAgeName.setMaximumSize(new Dimension(130, 31));
        this.minAgeName.setMinimumSize(new Dimension(130, 31));
        this.minAgeName.setHorizontalAlignment(SwingConstants.CENTER);
        this.minAgeName.setToolTipText("");
        this.minAgeName.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.minAgeName.setBorder(BorderFactory.createEtchedBorder());
        this.minAgeName.setBackground(Colors.GOLD);

        this.maxAgeName = new JLabel("Max age");
        this.maxAgeName.setPreferredSize(new Dimension(130, 31));
        this.maxAgeName.setMaximumSize(new Dimension(130, 31));
        this.maxAgeName.setMinimumSize(new Dimension(130, 31));
        this.maxAgeName.setHorizontalAlignment(SwingConstants.CENTER);
        this.maxAgeName.setToolTipText("");
        this.maxAgeName.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.maxAgeName.setBorder(BorderFactory.createEtchedBorder());
        this.maxAgeName.setBackground(Colors.GOLD);

        this.symptomsAgeNamePanel.setLayout(new BoxLayout(this.symptomsAgeNamePanel, BoxLayout.X_AXIS));
        //this.symptomsAgeNamePanel.setPreferredSize(new Dimension(this.currentModel.getListSymptomType().size() * 133, 31));
        this.symptomsAgePanel.setLayout(new BoxLayout(this.symptomsAgePanel, BoxLayout.Y_AXIS));
        this.minMaxPanel.setLayout(new BoxLayout(this.minMaxPanel, BoxLayout.X_AXIS));

        this.jPanel6.setPreferredSize(new Dimension(this.currentModel.getListSymptomType().size() * 135 + 420, this.currentModel.getListHumanAge().size() * 40 + 40));
        this.minMaxPanel.add(this.minAgeName);
        this.minMaxPanel.add(this.maxAgeName);

        for (SymptomType st1 : this.currentModel.getListSymptomType()) {
            this.symptomsAgeNamePanel.add(st1.getName2());
        }
        for (HumanAge ha : this.currentModel.getListHumanAge()) {
            ha.setModel(this.currentModel);
            this.symptomsAgePanel.add(ha.getPanel());
            this.symptomsAgePanel.add(ha.getcPanel());
        }
        // this.symptomsAgePanel.setPreferredSize(new Dimension(this.symptomsAgePanel.getWidth(), this.currentModel.getListHumanAge().size() * 40));
    }

    public void reinitAgePanel() {
        this.jPanel6.setPreferredSize(new Dimension(this.currentModel.getListSymptomType().size() * 135 + 420, this.currentModel.getListHumanAge().size() * 40 + 40));
        this.symptomsAgePanel.removeAll();
        this.symptomsAgeNamePanel.removeAll();
        for (SymptomType st1 : this.currentModel.getListSymptomType()) {
            this.symptomsAgeNamePanel.add(st1.getName2());
        }

        for (HumanAge ha : this.currentModel.getListHumanAge()) {
            ha.setModel(this.currentModel);
            this.symptomsAgePanel.add(ha.getPanel());
            this.symptomsAgePanel.add(ha.getcPanel());
        }
        this.symptomsAgePanel.revalidate();
        this.symptomsAgePanel.repaint();
        this.repaint();
        this.setVisible(true);
    }

    private void initLocationPanel() {
        if (this.currentModel.getCity() != null) {
            this.jPanel30.setVisible(true);
            for (Entry<String, LocationCategory> e : this.currentModel.getCity().getMapLocation().entrySet()) {
                this.locationPanel.add(new ModelLocationRow(e.getValue(), this.currentModel));
                this.locationPanel.add(Box.createVerticalStrut(3));
            }
        } else {
            this.jPanel30.setVisible(false);
        }
    }

    public ModelPanel(MainFrame frame, String name, JTabbedPane pane, City c) {
        initComponents();
        this.statistiquePanel.setLayout(new BoxLayout(this.statistiquePanel, BoxLayout.Y_AXIS));
        this.mainframe = frame;
        this.currentModel = new Model(name, frame, c);
        this.currentModel.setModelPanel(this);
        this.pane = pane;
        this.button = new ButtonTilte(this);
        this.locationPanel.setLayout(new BoxLayout(this.locationPanel, BoxLayout.Y_AXIS));
        this.statistiquePanel.add(c.getStatistiquePanel());
        initPanel();
        initAgePanel();
        initSymptomPanel();
        initLocationPanel();
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
            this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            jLabel1 = new JLabel();
            jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel1.setText(this.mp.getModel().getModelName() + " model");

            jButton1 = new JButton();
            jButton1.setText("X");
            jButton1.setToolTipText("");
            jButton1.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
            this.jButton1.setMinimumSize(new Dimension(20, 20));
            this.jButton1.setPreferredSize(new Dimension(20, 20));
            this.jButton1.setMaximumSize(new Dimension(20, 20));
            this.add(this.jLabel1);
            this.add(Box.createHorizontalStrut(3));
            this.add(this.jButton1);

        }

        private JButton jButton1;
        private JLabel jLabel1;

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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel36 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        manageSymptomTypeButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        symptomStageNamePanel = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel17 = new javax.swing.JPanel();
        symptomNamePane = new javax.swing.JPanel();
        symptomsDayPanel = new javax.swing.JPanel();
        contagiousDaysPanel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        nonHospitalNamePanel = new javax.swing.JPanel();
        nonHospitalLabel = new javax.swing.JLabel();
        hospitalPanelName = new javax.swing.JPanel();
        hospitalLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        manageAgeButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        symptomsAgeNamePanel = new javax.swing.JPanel();
        minMaxPanel = new javax.swing.JPanel();
        symptomsAgePanel = new javax.swing.JPanel();
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
        jPanel37 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        infectedNunberTxt = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        manageStageButton = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        noHospitalPanel = new javax.swing.JPanel();
        symptomStageNonHospitalPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        hospitalPanel = new javax.swing.JPanel();
        symptomStageHospitalPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        statistiquePanel = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1005, 1508));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1000, 1000));

        jPanel36.setPreferredSize(new java.awt.Dimension(1000, 2500));

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setPreferredSize(new java.awt.Dimension(1000, 400));

        jPanel1.setPreferredSize(new java.awt.Dimension(996, 35));

        manageSymptomTypeButton.setText("+");
        manageSymptomTypeButton.setToolTipText("");
        manageSymptomTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageSymptomTypeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 633, Short.MAX_VALUE)
                .addComponent(manageSymptomTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(manageSymptomTypeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(996, 373));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(996, 373));

        jPanel11.setPreferredSize(new java.awt.Dimension(920, 310));

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
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(symptomStageNamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(symptomStageNamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setPreferredSize(new java.awt.Dimension(900, 280));

        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        symptomsDayPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        symptomsDayPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        symptomsDayPanel.setPreferredSize(new java.awt.Dimension(687, 173));

        javax.swing.GroupLayout symptomsDayPanelLayout = new javax.swing.GroupLayout(symptomsDayPanel);
        symptomsDayPanel.setLayout(symptomsDayPanelLayout);
        symptomsDayPanelLayout.setHorizontalGroup(
            symptomsDayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        symptomsDayPanelLayout.setVerticalGroup(
            symptomsDayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        contagiousDaysPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        contagiousDaysPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        contagiousDaysPanel.setPreferredSize(new java.awt.Dimension(134, 4));

        javax.swing.GroupLayout contagiousDaysPanelLayout = new javax.swing.GroupLayout(contagiousDaysPanel);
        contagiousDaysPanel.setLayout(contagiousDaysPanelLayout);
        contagiousDaysPanelLayout.setHorizontalGroup(
            contagiousDaysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );
        contagiousDaysPanelLayout.setVerticalGroup(
            contagiousDaysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(symptomNamePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(symptomsDayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(contagiousDaysPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(symptomNamePane, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
            .addComponent(symptomsDayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
            .addComponent(contagiousDaysPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel17);

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setPreferredSize(new java.awt.Dimension(100, 38));

        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel16.setMaximumSize(new java.awt.Dimension(136, 32767));
        jPanel16.setMinimumSize(new java.awt.Dimension(136, 100));
        jPanel16.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        nonHospitalNamePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nonHospitalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nonHospitalLabel.setText("Non hospital");
        nonHospitalLabel.setToolTipText("");
        nonHospitalLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout nonHospitalNamePanelLayout = new javax.swing.GroupLayout(nonHospitalNamePanel);
        nonHospitalNamePanel.setLayout(nonHospitalNamePanelLayout);
        nonHospitalNamePanelLayout.setHorizontalGroup(
            nonHospitalNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nonHospitalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        nonHospitalNamePanelLayout.setVerticalGroup(
            nonHospitalNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nonHospitalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        hospitalPanelName.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        hospitalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hospitalLabel.setText("Hospital");
        hospitalLabel.setToolTipText("");
        hospitalLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        hospitalLabel.setMaximumSize(new java.awt.Dimension(54545, 18));
        hospitalLabel.setMinimumSize(new java.awt.Dimension(0, 18));

        javax.swing.GroupLayout hospitalPanelNameLayout = new javax.swing.GroupLayout(hospitalPanelName);
        hospitalPanelName.setLayout(hospitalPanelNameLayout);
        hospitalPanelNameLayout.setHorizontalGroup(
            hospitalPanelNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hospitalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        hospitalPanelNameLayout.setVerticalGroup(
            hospitalPanelNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hospitalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(nonHospitalNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(hospitalPanelName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nonHospitalNamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(hospitalPanelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel11);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
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

        manageAgeButton.setText("+");
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
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(manageAgeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setPreferredSize(new java.awt.Dimension(1003, 329));

        jPanel6.setBackground(new java.awt.Color(255, 51, 0));
        jPanel6.setPreferredSize(new java.awt.Dimension(1000, 270));

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setPreferredSize(new java.awt.Dimension(994, 35));

        jPanel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel27.setPreferredSize(new java.awt.Dimension(134, 31));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Age");
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
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        symptomsAgeNamePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        symptomsAgeNamePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        symptomsAgeNamePanel.setPreferredSize(new java.awt.Dimension(134, 4));

        javax.swing.GroupLayout symptomsAgeNamePanelLayout = new javax.swing.GroupLayout(symptomsAgeNamePanel);
        symptomsAgeNamePanel.setLayout(symptomsAgeNamePanelLayout);
        symptomsAgeNamePanelLayout.setHorizontalGroup(
            symptomsAgeNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );
        symptomsAgeNamePanelLayout.setVerticalGroup(
            symptomsAgeNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        minMaxPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout minMaxPanelLayout = new javax.swing.GroupLayout(minMaxPanel);
        minMaxPanel.setLayout(minMaxPanelLayout);
        minMaxPanelLayout.setHorizontalGroup(
            minMaxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );
        minMaxPanelLayout.setVerticalGroup(
            minMaxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(minMaxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(symptomsAgeNamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(symptomsAgeNamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(minMaxPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        symptomsAgePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        symptomsAgePanel.setPreferredSize(new java.awt.Dimension(1048, 206));

        javax.swing.GroupLayout symptomsAgePanelLayout = new javax.swing.GroupLayout(symptomsAgePanel);
        symptomsAgePanel.setLayout(symptomsAgePanelLayout);
        symptomsAgePanelLayout.setHorizontalGroup(
            symptomsAgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        symptomsAgePanelLayout.setVerticalGroup(
            symptomsAgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addComponent(symptomsAgePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(symptomsAgePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel6);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
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
                .addGap(0, 215, Short.MAX_VALUE))
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
            .addGap(0, 1159, Short.MAX_VALUE)
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
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1218, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
            .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel37.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel38.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setText("Number of infected human ");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jPanel39.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setText("Number:");

        infectedNunberTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        infectedNunberTxt.setText("0");

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infectedNunberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 117, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(infectedNunberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Symptom Stages");
        jLabel24.setToolTipText("");
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel24.setPreferredSize(new java.awt.Dimension(85, 18));

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Death percentage");
        jLabel25.setToolTipText("");
        jLabel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Immune percenatge");
        jLabel26.setToolTipText("");
        jLabel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Index");
        jLabel5.setToolTipText("");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Symptom stages");
        jLabel6.setToolTipText("");

        manageStageButton.setText("+");
        manageStageButton.setToolTipText("");
        manageStageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageStageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(manageStageButton))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(manageStageButton))
        );

        jPanel13.setPreferredSize(new java.awt.Dimension(750, 270));

        noHospitalPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        symptomStageNonHospitalPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        symptomStageNonHospitalPanel.setPreferredSize(new java.awt.Dimension(595, 4));

        javax.swing.GroupLayout symptomStageNonHospitalPanelLayout = new javax.swing.GroupLayout(symptomStageNonHospitalPanel);
        symptomStageNonHospitalPanel.setLayout(symptomStageNonHospitalPanelLayout);
        symptomStageNonHospitalPanelLayout.setHorizontalGroup(
            symptomStageNonHospitalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
        );
        symptomStageNonHospitalPanelLayout.setVerticalGroup(
            symptomStageNonHospitalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("No Hospital");

        javax.swing.GroupLayout noHospitalPanelLayout = new javax.swing.GroupLayout(noHospitalPanel);
        noHospitalPanel.setLayout(noHospitalPanelLayout);
        noHospitalPanelLayout.setHorizontalGroup(
            noHospitalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, noHospitalPanelLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(symptomStageNonHospitalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE))
        );
        noHospitalPanelLayout.setVerticalGroup(
            noHospitalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(symptomStageNonHospitalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
        );

        hospitalPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        symptomStageHospitalPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        symptomStageHospitalPanel.setPreferredSize(new java.awt.Dimension(625, 4));

        javax.swing.GroupLayout symptomStageHospitalPanelLayout = new javax.swing.GroupLayout(symptomStageHospitalPanel);
        symptomStageHospitalPanel.setLayout(symptomStageHospitalPanelLayout);
        symptomStageHospitalPanelLayout.setHorizontalGroup(
            symptomStageHospitalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        symptomStageHospitalPanelLayout.setVerticalGroup(
            symptomStageHospitalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Hospital");
        jLabel9.setToolTipText("");
        jLabel9.setMaximumSize(new java.awt.Dimension(54, 14));
        jLabel9.setMinimumSize(new java.awt.Dimension(54, 14));
        jLabel9.setPreferredSize(new java.awt.Dimension(54, 14));

        javax.swing.GroupLayout hospitalPanelLayout = new javax.swing.GroupLayout(hospitalPanel);
        hospitalPanel.setLayout(hospitalPanelLayout);
        hospitalPanelLayout.setHorizontalGroup(
            hospitalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hospitalPanelLayout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(symptomStageHospitalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE))
        );
        hospitalPanelLayout.setVerticalGroup(
            hospitalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(symptomStageHospitalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(noHospitalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(hospitalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(noHospitalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(hospitalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane7.setViewportView(jPanel13);

        jPanel14.setPreferredSize(new java.awt.Dimension(187, 0));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane7)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel36);

        jTabbedPane1.addTab("Properties", null, jScrollPane1, "");

        javax.swing.GroupLayout statistiquePanelLayout = new javax.swing.GroupLayout(statistiquePanel);
        statistiquePanel.setLayout(statistiquePanelLayout);
        statistiquePanelLayout.setHorizontalGroup(
            statistiquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        statistiquePanelLayout.setVerticalGroup(
            statistiquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Statistique", null, statistiquePanel, "");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1508, Short.MAX_VALUE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void manageAgeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAgeButtonActionPerformed
        /*ManageHumanAgeDistributionDialog dialog = new ManageHumanAgeDistributionDialog(mainframe);
        this.mainframe.setEnabled(false);
        dialog.setVisible(true);*/
        this.currentModel.addNewHumanAge();
    }//GEN-LAST:event_manageAgeButtonActionPerformed

    private void manageStageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageStageButtonActionPerformed
        ManageSymptomStagesDialog dialog = new ManageSymptomStagesDialog(mainframe);
        dialog.setVisible(true);
        this.mainframe.setEnabled(false);
    }//GEN-LAST:event_manageStageButtonActionPerformed

    private void manageSymptomTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageSymptomTypeButtonActionPerformed
        ManageSymptomTypeDialog dialog = new ManageSymptomTypeDialog(mainframe, currentModel);
        dialog.setVisible(true);
        this.mainframe.setEnabled(false);
    }//GEN-LAST:event_manageSymptomTypeButtonActionPerformed

    public void updateSymptomeStagePanel() {
        this.symptomStageNamePanel.removeAll();
//        this.immunePanel.removeAll();
//        this.deathPanel.removeAll();
//        this.humanStatPanel.removeAll();
//        for (SymptomStage st : this.currentModel.getListSymptomStage()) {
//            //st.setModel(this.currentModel);
//            this.symptomStageNamePanel.add(st.getNameLabel1(), st.getIndex());
//            Component c1 = Box.createHorizontalStrut(3);
//            st.setcName1(c1);
//            this.symptomStageNamePanel.add(c1, st.getIndex() + 1);
//
//            this.immunePanel.add(st.getImmunePercentageTxt(), st.getIndex());
//            Component c2 = Box.createHorizontalStrut(3);
//            st.setiComponent(c2);
//            this.immunePanel.add(c2, st.getIndex() + 1);
//
//            this.deathPanel.add(st.getDeathPercentageTxt(), st.getIndex());
//            Component c3 = Box.createHorizontalStrut(3);
//            st.setdComponent(c3);
//            this.deathPanel.add(c3, st.getIndex() + 1);
//
//            this.humanStatPanel.add(st.getHumanStatBox());
//            this.humanStatPanel.add(st.getcHumanStateBox());
//        }
//        int width = this.currentModel.getListSymptomStage().size() * 123 + 300;
//        this.jPanel11.setPreferredSize(new Dimension(width, this.jPanel11.getHeight()));
    }

    public void updateHumanAgePanel() {
        int wid = this.currentModel.getListHumanAge().size() * 123 + 150;
        this.jPanel6.setPreferredSize(new Dimension(wid, this.jPanel6.getHeight()));
        for (HumanAge ha : this.currentModel.getListHumanAge()) {

        }
        this.repaint();
    }

    public void setEnable() {
        this.currentModel.setEnable();
        this.manageAgeButton.setEnabled(true);
        this.manageStageButton.setEnabled(true);
        this.infectedNunberTxt.setEnabled(true);
    }

    public void setDisable() {
        this.currentModel.setDisable();
        this.manageAgeButton.setEnabled(false);
        this.manageStageButton.setEnabled(false);
        this.infectedNunberTxt.setEnabled(false);
    }

    private class JTextFieldIntegerListener implements DocumentListener, FocusListener {

        private JTextField jtextField;
        private String currentString;
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = false;

        public JTextFieldIntegerListener(JTextField textField) {
            this.jtextField = textField;
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
            if (numTxt.contains("f") || numTxt.contains("d")) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(mainframe, this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
                return;
            }
            try {
                int d = Integer.parseInt(numTxt);
                if (!insert) {
                    currentModel.changeState(d);
                    this.currentString = numTxt;
                }

            } catch (NumberFormatException ex) {
                insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(mainframe, this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            String numTxt = this.jtextField.getText();
            if (insert) {
                return;
            }
            String s = this.jtextField.getText();
            if (s.length() <= 0 || s.equals("")) {
                return;
            }
            currentModel.changeState(Integer.parseInt(numTxt));
            this.currentString = numTxt;

        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }

        @Override
        public void focusGained(FocusEvent e) {
            insert = false;
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (this.jtextField.getText().equals("")) {
                insert = true;
                insertZero(this.currentString);
            } else {
                insert = false;
            }
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contagiousDaysPanel;
    private javax.swing.JLabel hospitalLabel;
    private javax.swing.JPanel hospitalPanel;
    private javax.swing.JPanel hospitalPanelName;
    private javax.swing.JTextField infectedNunberTxt;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
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
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel locationPanel;
    private javax.swing.JButton manageAgeButton;
    private javax.swing.JButton manageStageButton;
    private javax.swing.JButton manageSymptomTypeButton;
    private javax.swing.JPanel minMaxPanel;
    private javax.swing.JPanel modelLocationPanel;
    private javax.swing.JPanel noHospitalPanel;
    private javax.swing.JLabel nonHospitalLabel;
    private javax.swing.JPanel nonHospitalNamePanel;
    private javax.swing.JPanel statistiquePanel;
    private javax.swing.JPanel symptomNamePane;
    private javax.swing.JPanel symptomStageHospitalPanel;
    private javax.swing.JPanel symptomStageNamePanel;
    private javax.swing.JPanel symptomStageNonHospitalPanel;
    private javax.swing.JPanel symptomsAgeNamePanel;
    private javax.swing.JPanel symptomsAgePanel;
    private javax.swing.JPanel symptomsDayPanel;
    // End of variables declaration//GEN-END:variables
}
