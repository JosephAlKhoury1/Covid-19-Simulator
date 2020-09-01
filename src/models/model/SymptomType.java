package models.model;

import controller.controllers.SymptomStageTypeController;
import controller.controllers.SymptomsController;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import views1.MainFrame;

public class SymptomType extends javax.swing.JPanel {

    private int id;
    private String name;
    private Model model;
    private List<SymptomStage> listSymptomStage;
    private List<SymptomStage> listDeleted;
    private List<SymptomStage> listAdd;
    private int contagiousDay;

    private double percentage;

    private boolean saved, inNew, deleted;

    private Component cState;
    private Component cName1, cName2;
    private Component cContDay;
    private JTextFieldIntegerListener listener;
    private JLabel name1, name2;
    private JTextField dayTxt;

    private JPanel panel;
    private List<SymptomStageType> listSage;

    public List<SymptomStageType> getListSage() {
        return listSage;
    }

    public void setListSage(List<SymptomStageType> listSage) {
        this.listSage = listSage;
        for(SymptomStageType stt:listSage){
          this.symptomeStagePanel.add(stt.getPanel());
        }
    }

   
    public SymptomType(String name, int contagiousDay, List<SymptomStageName> list, List<SymptomStage> listSymptomStage, Model m) {
        initComponents();
        this.name = name;
        this.model = m;
        this.contagiousDay = contagiousDay;
        this.listDeleted = new ArrayList();
        this.listAdd = new ArrayList();
        this.listSymptomStage = new ArrayList();

        name1 = new JLabel();
        name1.setText(name);
        name1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name1.setToolTipText("");
        name1.setAlignmentX(Component.LEFT_ALIGNMENT);
        name1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        name1.setMaximumSize(new java.awt.Dimension(130, 35));
        name1.setMinimumSize(new java.awt.Dimension(130, 35));
        name1.setPreferredSize(new java.awt.Dimension(130, 35));

        this.cName1 = Box.createVerticalStrut(3);

        name2 = new javax.swing.JLabel();
        name2.setText(name);
        name2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name2.setToolTipText("");
        name2.setAlignmentX(Component.LEFT_ALIGNMENT);
        name2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        name2.setMaximumSize(new java.awt.Dimension(130, 35));
        name2.setMinimumSize(new java.awt.Dimension(130, 35));
        name2.setPreferredSize(new java.awt.Dimension(130, 35));

        this.cName2 = Box.createVerticalStrut(3);

        dayTxt = new JTextField();
        dayTxt.setText(contagiousDay + "");
        dayTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayTxt.setToolTipText("");
        dayTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
        dayTxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        dayTxt.setMaximumSize(new java.awt.Dimension(130, 35));
        dayTxt.setMinimumSize(new java.awt.Dimension(130, 35));
        dayTxt.setPreferredSize(new java.awt.Dimension(130, 35));

        this.saved = false;
        this.inNew = true;
        this.deleted = false;
        this.dayTxt.setText(contagiousDay + "");

        this.listener = new JTextFieldIntegerListener(dayTxt, m.getMainFrame(), this);
        this.dayTxt.addFocusListener(listener);
        this.dayTxt.getDocument().addDocumentListener(listener);

        //int index = 0;
        this.symptomeStagePanel.setLayout(new BoxLayout(this.symptomeStagePanel, BoxLayout.X_AXIS));

        this.listSage = new ArrayList();
        for (SymptomStage stg : listSymptomStage) {
            SymptomStageType stt = new SymptomStageType(this, stg, 0, 0.0);
            this.listSage.add(stt);
            this.symptomeStagePanel.add(stt.getPanel());
        }

    }

    public SymptomType(int id, String name, int contagiousDay) {
        initComponents();
        this.id = id;
        this.name = name;
        this.contagiousDay = contagiousDay;
        this.listDeleted = new ArrayList();
        this.listAdd = new ArrayList();
        this.listSymptomStage = new ArrayList();

        name1 = new JLabel();
        name1.setText(name);
        name1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name1.setToolTipText("");
        name1.setAlignmentX(Component.LEFT_ALIGNMENT);
        name1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        name1.setMaximumSize(new java.awt.Dimension(130, 35));
        name1.setMinimumSize(new java.awt.Dimension(130, 35));
        name1.setPreferredSize(new java.awt.Dimension(130, 35));

        this.cName1 = Box.createVerticalStrut(3);

        name2 = new javax.swing.JLabel();
        name2.setText(name);
        name2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name2.setToolTipText("");
        name2.setAlignmentX(Component.LEFT_ALIGNMENT);
        name2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        name2.setMaximumSize(new java.awt.Dimension(130, 35));
        name2.setMinimumSize(new java.awt.Dimension(130, 35));
        name2.setPreferredSize(new java.awt.Dimension(130, 35));

        this.cName2 = Box.createVerticalStrut(3);

        dayTxt = new JTextField();
        dayTxt.setText(contagiousDay + "");
        dayTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayTxt.setToolTipText("");
        dayTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
        dayTxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        dayTxt.setMaximumSize(new java.awt.Dimension(130, 35));
        dayTxt.setMinimumSize(new java.awt.Dimension(130, 35));
        dayTxt.setPreferredSize(new java.awt.Dimension(130, 35));

        this.saved = false;
        this.inNew = true;
        this.deleted = false;
        this.dayTxt.setText(contagiousDay + "");

        this.listener = new JTextFieldIntegerListener(dayTxt, this);
        this.dayTxt.addFocusListener(listener);
        this.dayTxt.getDocument().addDocumentListener(listener);

        //int index = 0;
        this.symptomeStagePanel.setLayout(new BoxLayout(this.symptomeStagePanel, BoxLayout.X_AXIS));
    }

    public int getId() {
        return id;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public JPanel getSymptomeStagePanel() {
        return symptomeStagePanel;
    }

    public void setSymptomeStagePanel(JPanel symptomeStagePanel) {
        this.symptomeStagePanel = symptomeStagePanel;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public JLabel getName1() {
        return name1;
    }

    public JTextField getDayTxt() {
        return dayTxt;
    }

    public void setDayTxt(JTextField dayTxt) {
        this.dayTxt = dayTxt;
    }

    public void setName1(JLabel name1) {
        this.name1 = name1;
    }

    public JLabel getName2() {
        return name2;
    }

    public void setName2(JLabel name2) {
        this.name2 = name2;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
        this.listener.setMainFrame(model.getMainFrame());
        /*for (SymptomStage st : this.listSymptomStage) {
            st.setModel(model);
        }*/
//        for (HumanAge ha : this.listHumanAge) {
//            ha.setModel(model);
//        }
    }

    public Component getcName1() {
        return cName1;
    }

    public void setcName1(Component cName) {
        this.cName1 = cName;
    }

    public int getContagiousDay() {
        return contagiousDay;
    }

    public void setContagiousDay(int contagiousDay) {
        this.contagiousDay = contagiousDay;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public boolean isInNew() {
        return inNew;
    }

    public void setInNew(boolean inNew) {
        this.inNew = inNew;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Component getCState() {
        return cState;
    }

    public void setcState(Component component) {
        this.cState = component;
    }

    public void save() {
        if (this.isDeleted()) {
            SymptomsController.INSTANCE.delete(this.id);
            return;
        }
        if (this.isInNew()) {
            this.id = SymptomsController.INSTANCE.insertSymptom(this);
            this.setInNew(false);
            this.setSaved(true);
        } else {
            if (!this.isSaved()) {
                SymptomsController.INSTANCE.updateSymptom(this);
                this.setSaved(true);
            } else {

            }
        }

        save1();
        this.listAdd.clear();
        this.listDeleted.clear();
    }

    public void save1() {
        for (SymptomStageType stt : this.listSage) {
            stt.save();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        symptomeStagePanel = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(341411, 35));
        setMinimumSize(new java.awt.Dimension(0, 35));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 35));

        symptomeStagePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        symptomeStagePanel.setMaximumSize(new java.awt.Dimension(32767, 31));
        symptomeStagePanel.setMinimumSize(new java.awt.Dimension(100, 31));
        symptomeStagePanel.setPreferredSize(new java.awt.Dimension(800, 35));

        javax.swing.GroupLayout symptomeStagePanelLayout = new javax.swing.GroupLayout(symptomeStagePanel);
        symptomeStagePanel.setLayout(symptomeStagePanelLayout);
        symptomeStagePanelLayout.setHorizontalGroup(
            symptomeStagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );
        symptomeStagePanelLayout.setVerticalGroup(
            symptomeStagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(symptomeStagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(symptomeStagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
    }// </editor-fold>//GEN-END:initComponents

    public List<SymptomStage> getListSymptomStage() {
        return listSymptomStage;
    }

    public void setListSymptomStage(List<SymptomStage> listSymptomStage) {
        this.listSymptomStage = listSymptomStage;
    }

    public Component getcContDay() {
        return cContDay;
    }

    public void setcContDay(Component cContDay) {
        this.cContDay = cContDay;
    }

    public Component getcName2() {
        return cName2;
    }

    public void setcName2(Component cName2) {
        this.cName2 = cName2;
    }

    private void updateSymptomStageList(List<SymptomStage> list) {
        for (SymptomStage sts : list) {
            if (sts.isIsNew()) {
                if (!sts.isDeleted()) {
                    SymptomStage ss = new SymptomStage(sts.getName(), 0, 0.0, sts.getDeathPercentage(), sts.getImmunePercentage(), sts.getIndex(), this.model);
                    ss.setSymptomType(this);
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

    private void updateSymptomStagePanel() {
        this.symptomeStagePanel.removeAll();
        for (SymptomStage ss : this.listSymptomStage) {
            ss.setSymptomType(this);
            this.symptomeStagePanel.add(ss.getDayTxt());
            this.symptomeStagePanel.add(ss.getComponent());
        }
        this.symptomeStagePanel.revalidate();
    }

    public void updateSymptomStage(List<SymptomStage> list) {
        this.updateSymptomStageList(list);
        this.updateSymptomStagePanel();;
    }

//    private void updateHumanAgeList(List<HumanAge> list) {
//        for (HumanAge ha : list) {
//            if (ha.isIsNew()) {
//                if (!ha.isDeleted()) {
//                    HumanAge han = new HumanAge(ha.getName(), 0.0, ha.getMinAge(), ha.getMaxAge(), this, ha.getModel());
//                    this.listHumanAge.add(han);
//                    this.listHumanAgeAdd.add(han);
//                } else {
//
//                }
//            } else {
//                if (ha.isDeleted()) {
//                    HumanAge tmp = null;
//                    for (HumanAge hat : this.listHumanAge) {
//                        if (hat.getName().equals(ha.getName())) {
//                            hat.setDeleted(true);
//                            tmp = hat;
//                            break;
//                        }
//                    }
//                    if (this.listHumanAgeAdd.contains(tmp)) {
//                        this.listHumanAgeAdd.remove(tmp);
//                    }
//                    this.listHumanAge.remove(tmp);
//                    this.listHumanAgeDeleted.add(tmp);
//                } else {
//
//                }
//            }
//        }
//    }
//    private void updateHumanAgePanel() {
//        this.agePanel.removeAll();
//        this.agePanel.setPreferredSize(new Dimension(this.listHumanAge.size() * 120, 35));
//        for (HumanAge ha : this.listHumanAge) {
//            ha.setSymptomeType(this);
//            this.agePanel.add(ha.getPercentageTxt());
//            this.agePanel.add(ha.getcPercentage());
//        }
//        this.agePanel.revalidate();
//    }
//    public void updateHumanAge(List<HumanAge> list) {
//        this.updateHumanAgeList(list);
//        this.updateHumanAgePanel();
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel symptomeStagePanel;
    // End of variables declaration//GEN-END:variables

    private class JTextFieldIntegerListener implements DocumentListener, FocusListener {

        private JTextField jtextField;
        private MainFrame mainFrame;
        private String currentString;
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = false;
        private final SymptomType symptomType;

        public JTextFieldIntegerListener(JTextField textField, MainFrame mainFrame, SymptomType s) {
            this.jtextField = textField;
            this.mainFrame = mainFrame;
            this.currentString = s.getContagiousDay() + "";
            this.symptomType = s;
        }

        public JTextFieldIntegerListener(JTextField textField, SymptomType s) {
            this.jtextField = textField;
            this.currentString = s.getContagiousDay() + "";
            this.symptomType = s;
        }

        public MainFrame getMainFrame() {
            return mainFrame;
        }

        public void setMainFrame(MainFrame mainFrame) {
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
            if (numTxt.contains("f") || numTxt.contains("d")) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.mainFrame, this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
                return;
            }
            try {
                int d = Integer.parseInt(numTxt);
                if (!insert) {
                    this.symptomType.setContagiousDay(d);
                    this.symptomType.setSaved(false);
                    this.symptomType.getModel().setSaved(false);
                    mainFrame.setModelSavedButtonEnable();
                    this.currentString = numTxt;
                }

            } catch (NumberFormatException ex) {
                insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.mainFrame, this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
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

            this.symptomType.setContagiousDay(Integer.parseInt(numTxt));
            this.symptomType.setSaved(false);
            this.symptomType.getModel().setSaved(false);
            this.currentString = numTxt;
            mainFrame.setModelSavedButtonEnable();

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
}
