package models.model;

import controller.controllers.SymptomStageController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import models.member1.Member;
import resources.icon.Colors;
import resources.icon.Icons;
import resources.icon.Messages;
import views1.MainFrame;

public class SymptomStage extends JPanel {

    private int id;
    private String name;
    private Model model;
    private int inHospital;

    private int dayNum;

    private SymptomType symptomType;
    private double deathPercentage;
    private double immunePercentage;
    private int index;

    private boolean isNew, saved, deleted;

    private Component component;
    private JTextFieldIntegerListener listener = null;

    private JTextField dayTxt;

    private JTextField percentageTxt;
    private JLabel nameLabel1, nameLabel2;
    private Component cName1;

    private HumanStat humanState;
    private JComboBox<String> humanStatBox;
    private Component cHumanStateBox;

    private JPanel panel;

    private JTextField deathPercentageTxt, immunePercentageTxt, indexTxt;
    private JButton removeButton;
    private JTextFieldDoubleDeathListener dList = null;
    private JTextFieldDoubleImmuneListener iList = null;
    private JTextFieldIndexListener indexListener;

    private JLabel statistiqueNameLabel, statistiqueValueNameLabel;
    private JPanel statistiquePanel;

    private Color color;

    private List<Member> listMember;

    public SymptomStage(int id, String name, double immune, double death, int index, int inHospital) {
        this.name = name;
        this.id = id;
        this.inHospital = inHospital;
        this.deathPercentage = death;
        this.immunePercentage = immune;
        this.listMember = new ArrayList();
        this.index = index;

        this.color = Colors.SYMPTOMSTAGECOLORS[index - 1];

        nameLabel1 = new JLabel(this.name + "");
        nameLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel1.setToolTipText("");
        nameLabel1.setAlignmentX(Component.LEFT_ALIGNMENT);
        nameLabel1.setMaximumSize(new Dimension(140, 31));
        nameLabel1.setMinimumSize(new Dimension(140, 31));
        nameLabel1.setPreferredSize(new Dimension(140, 31));
        nameLabel1.setBorder(BorderFactory.createEtchedBorder());

        nameLabel2 = new JLabel(this.name + "");
        nameLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel2.setToolTipText("");
        nameLabel2.setAlignmentX(Component.LEFT_ALIGNMENT);
        nameLabel2.setMaximumSize(new Dimension(120, 31));
        nameLabel2.setMinimumSize(new Dimension(120, 31));
        nameLabel2.setPreferredSize(new Dimension(120, 31));
        nameLabel2.setBorder(BorderFactory.createEtchedBorder());

        deathPercentageTxt = new JTextField(this.deathPercentage + "");
        deathPercentageTxt.setHorizontalAlignment(SwingConstants.CENTER);
        deathPercentageTxt.setToolTipText("");
        deathPercentageTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
        deathPercentageTxt.setMaximumSize(new Dimension(140, 31));
        deathPercentageTxt.setMinimumSize(new Dimension(140, 31));
        deathPercentageTxt.setPreferredSize(new Dimension(140, 31));

        immunePercentageTxt = new JTextField(this.immunePercentage + "");
        immunePercentageTxt.setHorizontalAlignment(SwingConstants.CENTER);
        immunePercentageTxt.setToolTipText("");
        immunePercentageTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
        immunePercentageTxt.setMaximumSize(new Dimension(140, 31));
        immunePercentageTxt.setMinimumSize(new Dimension(140, 31));
        immunePercentageTxt.setPreferredSize(new Dimension(140, 31));

        indexTxt = new JTextField(this.index + "");
        indexTxt.setHorizontalAlignment(SwingConstants.CENTER);
        indexTxt.setToolTipText("");
        indexTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
        indexTxt.setMaximumSize(new Dimension(140, 31));
        indexTxt.setMinimumSize(new Dimension(140, 31));
        indexTxt.setPreferredSize(new Dimension(140, 31));

        this.indexListener = new JTextFieldIndexListener(indexTxt, this);
        indexTxt.addFocusListener(indexListener);
        indexTxt.getDocument().addDocumentListener(indexListener);

        removeButton = new JButton("-");
        removeButton.setPreferredSize(new Dimension(40, 35));
        removeButton.setMinimumSize(new Dimension(40, 35));
        removeButton.setMaximumSize(new Dimension(40, 35));

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeActionPerformed();
            }
        });

        this.iList = new JTextFieldDoubleImmuneListener(this.immunePercentageTxt, this.immunePercentage + "", this);
        this.dList = new JTextFieldDoubleDeathListener(this.deathPercentageTxt, this.deathPercentage + "", this);
        immunePercentageTxt.addFocusListener(iList);
        immunePercentageTxt.getDocument().addDocumentListener(iList);
        deathPercentageTxt.addFocusListener(dList);
        deathPercentageTxt.getDocument().addDocumentListener(dList);

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(622, 35));
        this.panel.setMinimumSize(new Dimension(622, 35));
        this.panel.setMaximumSize(new Dimension(622, 35));
        this.panel.setBorder(BorderFactory.createEtchedBorder());
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));
        this.panel.add(this.nameLabel1);
        panel.add(Box.createHorizontalStrut(6));

        this.panel.add(this.immunePercentageTxt);
        panel.add(Box.createHorizontalStrut(6));

        this.panel.add(this.deathPercentageTxt);
        panel.add(Box.createHorizontalStrut(6));

        this.panel.add(this.indexTxt);

        panel.add(removeButton);

        this.isNew = false;
        this.saved = true;
        this.deleted = false;

        double sum = this.immunePercentage + this.deathPercentage;
        if (sum != 100) {
            this.immunePercentageTxt.setBackground(Colors.WARNINGCOLOR);
            this.deathPercentageTxt.setBackground(Colors.WARNINGCOLOR);
            this.nameLabel1.setBackground(Colors.WARNINGCOLOR);
            this.nameLabel1.setToolTipText(Messages.IMMUNEDEATHWARNINGMESSAGE);
            this.nameLabel1.setIcon(Icons.WARNINGICON);
        } else {
            this.immunePercentageTxt.setBackground(Colors.NOWARNINGCOLOR);
            this.deathPercentageTxt.setBackground(Colors.NOWARNINGCOLOR);
            this.nameLabel1.setBackground(Colors.NOWARNINGCOLOR);
            this.nameLabel1.setToolTipText(null);
            this.nameLabel1.setIcon(null);
        }

        statistiqueNameLabel = new JLabel();
        statistiqueNameLabel.setText(name);
        statistiqueNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statistiqueNameLabel.setToolTipText("");
        statistiqueNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        statistiqueNameLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        statistiqueNameLabel.setMaximumSize(new java.awt.Dimension(245, 25));
        statistiqueNameLabel.setMinimumSize(new java.awt.Dimension(245, 25));
        statistiqueNameLabel.setPreferredSize(new java.awt.Dimension(245, 25));
        statistiqueNameLabel.setForeground(color);

        statistiqueValueNameLabel = new JLabel();
        statistiqueValueNameLabel.setText("0");
        statistiqueValueNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statistiqueValueNameLabel.setToolTipText("");
        statistiqueValueNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        statistiqueValueNameLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        statistiqueValueNameLabel.setMaximumSize(new java.awt.Dimension(40, 25));
        statistiqueValueNameLabel.setMinimumSize(new java.awt.Dimension(40, 25));
        statistiqueValueNameLabel.setPreferredSize(new java.awt.Dimension(40, 25));
        statistiqueValueNameLabel.setForeground(color);

        this.statistiquePanel = new JPanel();
        this.statistiquePanel.setPreferredSize(new Dimension(294, 27));
        this.statistiquePanel.setMinimumSize(new Dimension(294, 27));
        this.statistiquePanel.setMaximumSize(new Dimension(294, 27));
        this.statistiquePanel.setBorder(BorderFactory.createEtchedBorder());
        this.statistiquePanel.setLayout(new BoxLayout(this.statistiquePanel, BoxLayout.X_AXIS));

        this.statistiquePanel.add(statistiqueNameLabel);
        this.statistiquePanel.add(statistiqueValueNameLabel);

    }

    public SymptomStage(String name, double deathPercentage, double immunePercentage, int index, int inHospital, Model model) {
        this.name = name;
        this.model = model;
        this.inHospital = inHospital;
        this.index = index;
        this.deathPercentage = deathPercentage;
        this.immunePercentage = immunePercentage;
        this.listMember = new ArrayList();

        this.color = Colors.SYMPTOMSTAGECOLORS[index - 1];
        nameLabel1 = new JLabel(this.name + "");
        nameLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel1.setToolTipText("");
        nameLabel1.setAlignmentX(Component.LEFT_ALIGNMENT);
        nameLabel1.setMaximumSize(new Dimension(140, 31));
        nameLabel1.setMinimumSize(new Dimension(140, 31));
        nameLabel1.setPreferredSize(new Dimension(140, 31));
        nameLabel1.setBorder(BorderFactory.createEtchedBorder());

        nameLabel2 = new JLabel(this.name + "");
        nameLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel2.setToolTipText("");
        nameLabel2.setAlignmentX(Component.LEFT_ALIGNMENT);
        nameLabel2.setMaximumSize(new Dimension(120, 31));
        nameLabel2.setMinimumSize(new Dimension(120, 31));
        nameLabel2.setPreferredSize(new Dimension(120, 31));
        nameLabel2.setBorder(BorderFactory.createEtchedBorder());

        deathPercentageTxt = new JTextField(this.deathPercentage + "");
        deathPercentageTxt.setHorizontalAlignment(SwingConstants.CENTER);
        deathPercentageTxt.setToolTipText("");
        deathPercentageTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
        deathPercentageTxt.setMaximumSize(new Dimension(140, 31));
        deathPercentageTxt.setMinimumSize(new Dimension(140, 31));
        deathPercentageTxt.setPreferredSize(new Dimension(140, 31));

        immunePercentageTxt = new JTextField(this.immunePercentage + "");
        immunePercentageTxt.setHorizontalAlignment(SwingConstants.CENTER);
        immunePercentageTxt.setToolTipText("");
        immunePercentageTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
        immunePercentageTxt.setMaximumSize(new Dimension(140, 31));
        immunePercentageTxt.setMinimumSize(new Dimension(140, 31));
        immunePercentageTxt.setPreferredSize(new Dimension(140, 31));

        indexTxt = new JTextField(this.index + "");
        indexTxt.setHorizontalAlignment(SwingConstants.CENTER);
        indexTxt.setToolTipText("");
        indexTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
        indexTxt.setMaximumSize(new Dimension(140, 31));
        indexTxt.setMinimumSize(new Dimension(140, 31));
        indexTxt.setPreferredSize(new Dimension(140, 31));

        this.indexListener = new JTextFieldIndexListener(indexTxt, this);
        indexTxt.addFocusListener(indexListener);
        indexTxt.getDocument().addDocumentListener(indexListener);

        removeButton = new JButton("-");
        removeButton.setPreferredSize(new Dimension(40, 35));
        removeButton.setMinimumSize(new Dimension(40, 35));
        removeButton.setMaximumSize(new Dimension(40, 35));

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeActionPerformed();
            }
        });

        this.iList = new JTextFieldDoubleImmuneListener(this.immunePercentageTxt, this.immunePercentage + "", this);
        this.dList = new JTextFieldDoubleDeathListener(this.deathPercentageTxt, this.deathPercentage + "", this);
        immunePercentageTxt.addFocusListener(iList);
        immunePercentageTxt.getDocument().addDocumentListener(iList);
        deathPercentageTxt.addFocusListener(dList);
        deathPercentageTxt.getDocument().addDocumentListener(dList);

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(622, 35));
        this.panel.setMinimumSize(new Dimension(622, 35));
        this.panel.setMaximumSize(new Dimension(622, 35));
        this.panel.setBorder(BorderFactory.createEtchedBorder());
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));
        this.panel.add(this.nameLabel1);
        panel.add(Box.createHorizontalStrut(6));

        this.panel.add(this.immunePercentageTxt);
        panel.add(Box.createHorizontalStrut(6));

        this.panel.add(this.deathPercentageTxt);
        panel.add(Box.createHorizontalStrut(6));

        this.panel.add(this.indexTxt);

        panel.add(removeButton);

        this.isNew = true;
        this.saved = false;
        this.deleted = false;

        double sum = this.immunePercentage + this.deathPercentage;
        if (sum != 100) {
            this.immunePercentageTxt.setBackground(Colors.WARNINGCOLOR);
            this.deathPercentageTxt.setBackground(Colors.WARNINGCOLOR);
            this.nameLabel1.setBackground(Colors.WARNINGCOLOR);
            this.nameLabel1.setToolTipText(Messages.IMMUNEDEATHWARNINGMESSAGE);
            this.nameLabel1.setIcon(Icons.WARNINGICON);
        } else {
            this.immunePercentageTxt.setBackground(Colors.NOWARNINGCOLOR);
            this.deathPercentageTxt.setBackground(Colors.NOWARNINGCOLOR);
            this.nameLabel1.setBackground(Colors.NOWARNINGCOLOR);
            this.nameLabel1.setToolTipText(null);
            this.nameLabel1.setIcon(null);
        }

        statistiqueNameLabel = new JLabel();
        statistiqueNameLabel.setText(name);
        statistiqueNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statistiqueNameLabel.setToolTipText("");
        statistiqueNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        statistiqueNameLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        statistiqueNameLabel.setMaximumSize(new java.awt.Dimension(245, 25));
        statistiqueNameLabel.setMinimumSize(new java.awt.Dimension(245, 25));
        statistiqueNameLabel.setPreferredSize(new java.awt.Dimension(245, 25));
        statistiqueNameLabel.setForeground(color);

        statistiqueValueNameLabel = new JLabel();
        statistiqueValueNameLabel.setText("0");
        statistiqueValueNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statistiqueValueNameLabel.setToolTipText("");
        statistiqueValueNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        statistiqueValueNameLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        statistiqueValueNameLabel.setMaximumSize(new java.awt.Dimension(40, 25));
        statistiqueValueNameLabel.setMinimumSize(new java.awt.Dimension(40, 25));
        statistiqueValueNameLabel.setPreferredSize(new java.awt.Dimension(40, 25));
        statistiqueValueNameLabel.setForeground(color);

        this.statistiquePanel = new JPanel();
        this.statistiquePanel.setPreferredSize(new Dimension(294, 27));
        this.statistiquePanel.setMinimumSize(new Dimension(294, 27));
        this.statistiquePanel.setMaximumSize(new Dimension(294, 27));
        this.statistiquePanel.setBorder(BorderFactory.createEtchedBorder());
        this.statistiquePanel.setLayout(new BoxLayout(this.statistiquePanel, BoxLayout.X_AXIS));

        this.statistiquePanel.add(statistiqueNameLabel);
        this.statistiquePanel.add(statistiqueValueNameLabel);
    }

    public void removeActionPerformed() {
        int index = JOptionPane.showOptionDialog(this.model.getMainFrame(), Messages.DELETESYMPTOMSTAGE, "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);

        if (index == JOptionPane.NO_OPTION) {
            return;
        }

        this.setDeleted(true);
        if (this.inHospital == 0) {
            this.model.getListSymptomStage1sNonHospital().remove(this);
            this.model.getListSympStageNonHosDeleted().add(this);
        } else {
            this.model.getListSymptomStage1sHospital().remove(this);
            this.model.getListSymptomStagesHosDeleted().add(this);
        }
        for (SymptomStage ss : this.model.getListSymptomStage1sNonHospital()) {
            if (ss.getIndex() > this.index) {
                ss.setIndex((ss.getIndex() - 1));
                ss.setSaved(false);
            }
        }
        for (SymptomStage ss : this.model.getListSymptomStage1sHospital()) {
            if (ss.getIndex() > this.index) {
                ss.setIndex((ss.getIndex() - 1));
                ss.setSaved(false);
            }
        }
        for (SymptomType st : this.model.getListSymptomType()) {
            SymptomStageType tmp = null;
            for (SymptomStageType sst : st.getListSage()) {
                if (sst.getSymptomStage() == this) {
                    sst.setDeleted(true);
                    tmp = sst;
                    break;
                }
            }
            st.getListStageDeleted().add(tmp);
            st.getListSage().remove(tmp);
            st.reintSymptomStagePanel();
        }
        this.model.getModelPanel().reinitSymptomPanel();
        this.model.getModelPanel().reinitPanel();
        this.model.getMainFrame().setModelSavedButtonEnable();
    }

    public void setEnable() {
        this.deathPercentageTxt.setEnabled(true);
        this.immunePercentageTxt.setEnabled(true);
        this.indexTxt.setEnabled(true);
        this.removeButton.setEnabled(true);
    }

    public void setDisable() {
        this.deathPercentageTxt.setEnabled(false);
        this.immunePercentageTxt.setEnabled(false);
        this.indexTxt.setEnabled(false);
        this.removeButton.setEnabled(false);
    }

    public JLabel getNameLabel2() {
        return nameLabel2;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JLabel getStatistiqueNameLabel() {
        return statistiqueNameLabel;
    }

    public List<Member> getListMember() {
        return listMember;
    }

    public void setListMember(List<Member> listMember) {
        this.listMember = listMember;
    }

    public void setStatistiqueNameLabel(JLabel statistiqueNameLabel) {
        this.statistiqueNameLabel = statistiqueNameLabel;
    }

    public JLabel getStatistiqueValueNameLabel() {
        return statistiqueValueNameLabel;
    }

    public void setStatistiqueValueNameLabel(JLabel statistiqueValueNameLabel) {
        this.statistiqueValueNameLabel = statistiqueValueNameLabel;
    }

    public JPanel getStatistiquePanel() {
        return statistiquePanel;
    }

    public void setStatistiquePanel(JPanel statistiquePanel) {
        this.statistiquePanel = statistiquePanel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JTextField getDeathPercentageTxt() {
        return deathPercentageTxt;
    }

    public void setDeathPercentageTxt(JTextField deathPercentageTxt) {
        this.deathPercentageTxt = deathPercentageTxt;
    }

    public JTextField getImmunePercentageTxt() {
        return immunePercentageTxt;
    }

    public void setImmunePercentageTxt(JTextField immunePercentageTxt) {
        this.immunePercentageTxt = immunePercentageTxt;
    }

    public HumanStat getHumanState() {
        return humanState;
    }

    public void setHumanState(HumanStat humanState) {
        this.humanState = humanState;
    }

    public JComboBox<String> getHumanStatBox() {
        return humanStatBox;
    }

    public void setHumanStatBox(JComboBox<String> humanStatBox) {
        this.humanStatBox = humanStatBox;
    }

    public Component getcHumanStateBox() {
        return cHumanStateBox;
    }

    public void setcHumanStateBox(Component cHumanStateBox) {
        this.cHumanStateBox = cHumanStateBox;
    }

    public void jComboActionEvent() {
        String ha = this.humanStatBox.getItemAt(this.humanStatBox.getSelectedIndex());
        for (HumanStatName hs : model.getMainFrame().getListHumanStatName()) {
            if (hs.getName().equals(ha)) {
                this.humanState.setName(hs.getName());
                this.humanState.setColor(hs.getColor());
            }
        }

        this.humanState.setSaved(false);
        this.model.setSaved(false);
        this.model.getMainFrame().setModelSavedButtonEnable();
    }

    public JLabel getNameLabel1() {
        return nameLabel1;
    }

    public int getInHospital() {
        return inHospital;
    }

    public void setInHospital(int inHospital) {
        this.inHospital = inHospital;
    }

    public void setNameLabel1(JLabel nameLabel1) {
        this.nameLabel1 = nameLabel1;
    }

    public Component getcName1() {
        return cName1;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
        this.indexTxt.setText(index + "");
    }

    public void setcName1(Component cName1) {
        this.cName1 = cName1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDeathPercentage() {
        return deathPercentage;
    }

    public void setDeathPercentage(double deathPercentage) {
        this.deathPercentage = deathPercentage;
    }

    public JTextFieldIntegerListener getListener() {
        return listener;
    }

    public void setListener(JTextFieldIntegerListener listener) {
        this.listener = listener;
    }

    public JTextField getDayTxt() {
        return dayTxt;
    }

    public void setDayTxt(JTextField dayTxt) {
        this.dayTxt = dayTxt;
    }

    public double getImmunePercentage() {
        return immunePercentage;
    }

    public void setImmunePercentage(double immunePercentage) {
        this.immunePercentage = immunePercentage;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
        if (this.humanStatBox != null) {
            for (String s : model.getMainFrame().getHumanStatTab()) {
                if (s.equals(this.humanState.getName())) {
                } else {
                    humanStatBox.addItem(s);
                }
            }
        }

        if (this.listener != null) {
            this.listener.setMainFrame(model.getMainFrame());
        }
    }

    public int getDayNum() {
        return dayNum;
    }

    public void setDayNum(int dayNum) {
        this.dayNum = dayNum;
    }

    public SymptomType getSymptomType() {
        return symptomType;
    }

    public void setSymptomType(SymptomType symptomType) {
        this.symptomType = symptomType;

    }

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void save() {
        if (this.isDeleted()) {
            if (this.isNew) {
                return;
            }
            SymptomStageController.INSTANCE.delete(this.id);
            this.setSaved(true);
            this.setIsNew(false);
            return;
        }
        if (this.isNew) {
            SymptomStageController.INSTANCE.insert(this);
            this.setIsNew(false);
            this.setSaved(true);
        } else {
            if (!this.isSaved()) {
                SymptomStageController.INSTANCE.update(this);
                this.setSaved(true);
            } else {

            }
        }
    }

    public void save1() {
        if (this.isDeleted()) {
            if (this.isNew) {
                return;
            }
            SymptomStageController.INSTANCE.deleteModel(this.id);
            this.setSaved(true);
            this.setIsNew(false);
            return;
        }
        if (this.isNew) {
            SymptomStageController.INSTANCE.insertModel(this);
            this.setIsNew(false);
            this.setSaved(true);
        } else {
            if (!this.isSaved()) {
                SymptomStageController.INSTANCE.updateModel(this);
                this.setSaved(true);
            } else {

            }
        }
        //this.humanState.save();
    }

    public void updateStatistique() {
        this.statistiqueValueNameLabel.setText(this.listMember.size() + "");
    }

    private class JTextFieldIntegerListener implements DocumentListener, FocusListener {

        private JTextField jtextField;
        private MainFrame mainFrame;
        private String currentString;
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = false;
        private final SymptomStage symptomStage;

        public JTextFieldIntegerListener(JTextField textField, MainFrame mainFrame, SymptomStage s) {
            this.jtextField = textField;
            this.mainFrame = mainFrame;
            this.currentString = s.getDayNum() + "";
            this.symptomStage = s;
        }

        public JTextFieldIntegerListener(JTextField textField, SymptomStage s) {
            this.jtextField = textField;
            this.currentString = s.getDayNum() + "";
            this.symptomStage = s;
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
                    this.symptomStage.setDayNum(d);
                    this.symptomStage.setSaved(false);
                    this.symptomStage.getSymptomType().getModel().setSaved(false);
                    this.symptomStage.getSymptomType().getModel().getMainFrame().setModelSavedButtonEnable();
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

            this.symptomStage.setDayNum(Integer.parseInt(numTxt));
            this.symptomStage.setSaved(false);
            this.symptomStage.getSymptomType().getModel().setSaved(false);
            this.currentString = numTxt;
            this.symptomStage.getSymptomType().getModel().getMainFrame().setModelSavedButtonEnable();

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

    private class JTextFieldDoubleDeathListener implements DocumentListener, FocusListener {

        private final JTextField jtextField;
        private MainFrame mainFrame;
        private String currentString;
        private final String greaterMessage = "Number can't be greater 100!";
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = false;
        private SymptomStage symStage;

        public JTextFieldDoubleDeathListener(JTextField textField, MainFrame mainFrame, String value, SymptomStage stage) {
            this.jtextField = textField;
            this.mainFrame = mainFrame;
            this.currentString = value;
            this.symStage = stage;
        }

        public JTextFieldDoubleDeathListener(JTextField textField, String value, SymptomStage stage) {
            this.jtextField = textField;
            this.currentString = value;
            this.symStage = stage;
        }

        public MainFrame getMainFrame() {
            return mainFrame;
        }

        public void setMainFrame(MainFrame mainFrame) {
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
            if (numTxt.contains("f") || numTxt.contains("d")) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.symStage.getModel().getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
            }
            try {
                Double d = Double.parseDouble(numTxt);
                if (d > 100) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(this.symStage.getModel().getMainFrame(), this.greaterMessage, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(this.currentString);
                    this.insert = false;
                } else if (!insert) {
                    this.currentString = numTxt;
                    this.symStage.setDeathPercentage(Double.parseDouble(numTxt));
                    this.symStage.getModel().getMainFrame().setModelSavedButtonEnable();
                    this.symStage.getModel().setSaved(false);
                    this.symStage.setSaved(false);
                    double sum = immunePercentage + deathPercentage;
                    if (sum != 100) {
                        immunePercentageTxt.setBackground(Colors.WARNINGCOLOR);
                        deathPercentageTxt.setBackground(Colors.WARNINGCOLOR);
                        nameLabel1.setBackground(Colors.WARNINGCOLOR);
                        nameLabel1.setToolTipText(Messages.IMMUNEDEATHWARNINGMESSAGE);
                        nameLabel1.setIcon(Icons.WARNINGICON);
                    } else {
                        immunePercentageTxt.setBackground(Colors.NOWARNINGCOLOR);
                        deathPercentageTxt.setBackground(Colors.NOWARNINGCOLOR);
                        nameLabel1.setBackground(Colors.NOWARNINGCOLOR);
                        nameLabel1.setToolTipText(null);
                        nameLabel1.setIcon(null);
                    }
                }

            } catch (NumberFormatException ex) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.symStage.getModel().getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
            }
            this.insert = false;
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if (insert) {
                return;
            }
            String s = this.jtextField.getText();
            if (s.length() <= 0 || s.equals("")) {
                return;
            }
            this.currentString = s;
            this.symStage.setDeathPercentage(Double.parseDouble(s));
            this.symStage.getModel().getMainFrame().setModelSavedButtonEnable();
            this.symStage.getModel().setSaved(false);
            this.symStage.setSaved(false);
            double sum = immunePercentage + deathPercentage;
            if (sum != 100) {
                immunePercentageTxt.setBackground(Colors.WARNINGCOLOR);
                deathPercentageTxt.setBackground(Colors.WARNINGCOLOR);
                nameLabel1.setBackground(Colors.WARNINGCOLOR);
                nameLabel1.setToolTipText(Messages.IMMUNEDEATHWARNINGMESSAGE);
                nameLabel1.setIcon(Icons.WARNINGICON);
            } else {
                immunePercentageTxt.setBackground(Colors.NOWARNINGCOLOR);
                deathPercentageTxt.setBackground(Colors.NOWARNINGCOLOR);
                nameLabel1.setBackground(Colors.NOWARNINGCOLOR);
                nameLabel1.setToolTipText(null);
                nameLabel1.setIcon(null);
            }
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
            String numTxt = this.jtextField.getText();
            if (numTxt.equals("")) {
                insert = true;
                insertZero(this.currentString);
            } else if (numTxt.startsWith(".")) {
                this.currentString = "0" + this.currentString;
                insert = true;
                insertZero(this.currentString);
            } else if (numTxt.endsWith(".")) {
                this.currentString = this.currentString + "0";
                insertZero(this.currentString);
            } else {
                insert = false;
            }
        }

    }

    private class JTextFieldDoubleImmuneListener implements DocumentListener, FocusListener {

        private final JTextField jtextField;
        private MainFrame mainFrame;
        private String currentString;
        private final String greaterMessage = "Number can't be greater 100!";
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = false;
        private SymptomStage symStage;

        public JTextFieldDoubleImmuneListener(JTextField textField, MainFrame mainFrame, String value, SymptomStage stage) {
            this.jtextField = textField;
            this.mainFrame = mainFrame;
            this.currentString = value;
            this.symStage = stage;
        }

        public JTextFieldDoubleImmuneListener(JTextField textField, String value, SymptomStage stage) {
            this.jtextField = textField;
            this.currentString = value;
            this.symStage = stage;
        }

        public MainFrame getMainFrame() {
            return mainFrame;
        }

        public void setMainFrame(MainFrame mainFrame) {
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
            if (numTxt.contains("f") || numTxt.contains("d")) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.symStage.getModel().getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
            }
            try {
                Double d = Double.parseDouble(numTxt);
                if (d > 100) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(this.symStage.getModel().getMainFrame(), this.greaterMessage, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(this.currentString);
                    this.insert = false;
                } else if (!insert) {
                    this.currentString = numTxt;
                    this.symStage.setImmunePercentage(Double.parseDouble(numTxt));
                    this.symStage.getModel().getMainFrame().setModelSavedButtonEnable();
                    this.symStage.getModel().setSaved(false);
                    this.symStage.setSaved(false);
                    double sum = immunePercentage + deathPercentage;
                    if (sum != 100) {
                        immunePercentageTxt.setBackground(Colors.WARNINGCOLOR);
                        deathPercentageTxt.setBackground(Colors.WARNINGCOLOR);
                        nameLabel1.setBackground(Colors.WARNINGCOLOR);
                        nameLabel1.setToolTipText(Messages.IMMUNEDEATHWARNINGMESSAGE);
                        nameLabel1.setIcon(Icons.WARNINGICON);
                    } else {
                        immunePercentageTxt.setBackground(Colors.NOWARNINGCOLOR);
                        deathPercentageTxt.setBackground(Colors.NOWARNINGCOLOR);
                        nameLabel1.setBackground(Colors.NOWARNINGCOLOR);
                        nameLabel1.setToolTipText(null);
                        nameLabel1.setIcon(null);
                    }
                }

            } catch (NumberFormatException ex) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.symStage.getModel().getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
            }
            this.insert = false;
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if (insert) {
                return;
            }
            String s = this.jtextField.getText();
            if (s.length() <= 0 || s.equals("")) {
                return;
            }
            this.currentString = s;
            this.symStage.setImmunePercentage(Double.parseDouble(s));
            this.symStage.getModel().getMainFrame().setModelSavedButtonEnable();
            this.symStage.getModel().setSaved(false);
            this.symStage.setSaved(false);
            double sum = immunePercentage + deathPercentage;
            if (sum != 100) {
                immunePercentageTxt.setBackground(Colors.WARNINGCOLOR);
                deathPercentageTxt.setBackground(Colors.WARNINGCOLOR);
                nameLabel1.setBackground(Colors.WARNINGCOLOR);
                nameLabel1.setToolTipText(Messages.IMMUNEDEATHWARNINGMESSAGE);
                nameLabel1.setIcon(Icons.WARNINGICON);
            } else {
                immunePercentageTxt.setBackground(Colors.NOWARNINGCOLOR);
                deathPercentageTxt.setBackground(Colors.NOWARNINGCOLOR);
                nameLabel1.setBackground(Colors.NOWARNINGCOLOR);
                nameLabel1.setToolTipText(null);
                nameLabel1.setIcon(null);
            }

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
            String numTxt = this.jtextField.getText();
            if (numTxt.equals("")) {
                insert = true;
                insertZero(this.currentString);
            } else if (numTxt.startsWith(".")) {
                this.currentString = "0" + this.currentString;
                insert = true;
                insertZero(this.currentString);
            } else if (numTxt.endsWith(".")) {
                this.currentString = this.currentString + "0";
                insertZero(this.currentString);
            } else {
                insert = false;
            }
        }

    }

    private class JTextFieldIndexListener implements DocumentListener, FocusListener {

        private JTextField jtextField;
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = true;
        private final String numberLower = "Max age can't be lower or equal to min age!";
        private SymptomStage stage;

        public JTextFieldIndexListener(JTextField textField, SymptomStage stage) {
            this.jtextField = textField;
            this.stage = stage;
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
                    JOptionPane.showOptionDialog(model.getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(stage.getIndex() + "");
                return;
            }
            try {
                int d = Integer.parseInt(numTxt);
                if (!insert) {
                    model.getMainFrame().setModelSavedButtonEnable();
                }

            } catch (NumberFormatException ex) {
                insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(model.getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(stage.getIndex() + "");
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            String numTxt = this.jtextField.getText();
            if (numTxt.length() <= 0 || numTxt.equals("")) {
                return;
            }
            model.getMainFrame().setModelSavedButtonEnable();
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
            String numTxt = this.jtextField.getText();
            if (numTxt.equals("")) {
                insert = true;
                insertZero(stage.getIndex() + "");
                return;
            } else {
                insert = true;
            }
            int d = Integer.parseInt(numTxt);
            if (d == 0) {
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(model.getMainFrame(), this.numberLower, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(stage.getIndex() + "");
            } else if (stage.getInHospital() == 0) {
                if (d > model.getListSymptomStage1sNonHospital().size()) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(model.getMainFrame(), this.numberLower, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(stage.getIndex() + "");
                } else {
                    int tmp = stage.getIndex();
                    for (SymptomStage ss : model.getListSymptomStage1sNonHospital()) {
                        if (ss.getIndex() == d) {
                            ss.setIndex(tmp);
                            ss.setSaved(false);
                            break;
                        }
                    }
                    stage.setIndex(d);
                    stage.setSaved(false);
                    for (SymptomType st : model.getListSymptomType()) {
                        st.reintSymptomStagePanel();
                    }
                    model.getModelPanel().reinitPanel();
                }
            } else {
                if (d > model.getListSymptomStage1sHospital().size() + model.getListSymptomStage1sNonHospital().size()
                        || d <= model.getListSymptomStage1sNonHospital().size()) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(model.getMainFrame(), this.numberLower, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(stage.getIndex() + "");
                } else {
                    int tmp = stage.getIndex();
                    for (SymptomStage ss : model.getListSymptomStage1sHospital()) {
                        if (ss.getIndex() == d) {
                            ss.setIndex(tmp);
                            ss.setSaved(false);
                            break;
                        }
                    }
                    stage.setIndex(d);
                    stage.setSaved(false);
                    for (SymptomType st : model.getListSymptomType()) {
                        st.reintSymptomStagePanel();
                    }
                    model.getModelPanel().reinitPanel();
                }
            }

        }

    }
}
