package models.model;

import controller.controllers.HumanStateController;
import controller.controllers.SymptomStageController;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import views1.MainFrame;

public class SymptomStage extends JPanel {

    private int id;
    private String name;
    private Model model;

    private int dayNum;
    private double percentageToBeInThisStage;

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
    private JTextFieldDoubleDeathListener dList = null;
    private JTextFieldDoubleImmuneListener iList = null;

    public SymptomStage(int id, String name, double immune, double death, int index) {
        this.name = name;
        this.id = id;
        this.deathPercentage = death;
        this.immunePercentage = immune;
        this.index = index;
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

        this.iList = new JTextFieldDoubleImmuneListener(this.immunePercentageTxt, this.immunePercentage + "", this);
        this.dList = new JTextFieldDoubleDeathListener(this.deathPercentageTxt, this.deathPercentage + "", this);
        immunePercentageTxt.addFocusListener(iList);
        immunePercentageTxt.getDocument().addDocumentListener(iList);
        deathPercentageTxt.addFocusListener(dList);
        deathPercentageTxt.getDocument().addDocumentListener(dList);

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(581, 35));
        this.panel.setMinimumSize(new Dimension(581, 35));
        this.panel.setMaximumSize(new Dimension(581, 35));
        this.panel.setBorder(BorderFactory.createEtchedBorder());
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));
        this.panel.add(this.nameLabel1);
        panel.add(Box.createHorizontalStrut(6));

        this.panel.add(this.immunePercentageTxt);
        panel.add(Box.createHorizontalStrut(6));

        this.panel.add(this.deathPercentageTxt);
        panel.add(Box.createHorizontalStrut(6));

        this.panel.add(this.indexTxt);

        this.isNew = true;
        this.saved = false;
        this.deleted = false;

    }

    public SymptomStage(String name, double deathPercentage, double immunePercentage, int index, Model model) {
        this.name = name;
        this.model = model;
        this.index = index;
        this.deathPercentage = deathPercentage;
        this.immunePercentage = immunePercentage;
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

        this.iList = new JTextFieldDoubleImmuneListener(this.immunePercentageTxt, this.immunePercentage + "", this);
        this.dList = new JTextFieldDoubleDeathListener(this.deathPercentageTxt, this.deathPercentage + "", this);
        immunePercentageTxt.addFocusListener(iList);
        immunePercentageTxt.getDocument().addDocumentListener(iList);
        deathPercentageTxt.addFocusListener(dList);
        deathPercentageTxt.getDocument().addDocumentListener(dList);

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(581, 35));
        this.panel.setMinimumSize(new Dimension(581, 35));
        this.panel.setMaximumSize(new Dimension(581, 35));
        this.panel.setBorder(BorderFactory.createEtchedBorder());
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));
        this.panel.add(this.nameLabel1);
        panel.add(Box.createHorizontalStrut(6));

        this.panel.add(this.immunePercentageTxt);
        panel.add(Box.createHorizontalStrut(6));

        this.panel.add(this.deathPercentageTxt);
        panel.add(Box.createHorizontalStrut(6));

        this.panel.add(this.indexTxt);

        this.isNew = true;
        this.saved = false;
        this.deleted = false;
    }

    public JLabel getNameLabel2() {
        return nameLabel2;
    }

    public SymptomStage(String name, int dayNum, double percentage, double deathPercentage, double immunePercentage, int index, Model model) {
        this.name = name;
        this.model = model;
        this.dayNum = dayNum;
        this.index = index;
        this.deathPercentage = deathPercentage;
        this.immunePercentage = immunePercentage;
        this.percentageToBeInThisStage = percentage;

        dayTxt = new JTextField(this.dayNum + "");
        dayTxt.setHorizontalAlignment(SwingConstants.CENTER);
        dayTxt.setToolTipText("");
        dayTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
        dayTxt.setMaximumSize(new Dimension(55, 31));
        dayTxt.setMinimumSize(new Dimension(55, 31));
        dayTxt.setPreferredSize(new Dimension(55, 31));

        percentageTxt = new JTextField(this.percentageToBeInThisStage + "");
        percentageTxt.setHorizontalAlignment(SwingConstants.CENTER);
        percentageTxt.setToolTipText("");
        percentageTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
        percentageTxt.setMaximumSize(new Dimension(55, 31));
        percentageTxt.setMinimumSize(new Dimension(55, 31));
        percentageTxt.setPreferredSize(new Dimension(55, 31));

        this.component = Box.createHorizontalStrut(3);

        this.component = Box.createHorizontalStrut(3);
        this.listener = new JTextFieldIntegerListener(this.dayTxt, model.getMainFrame(), this);
        this.dayTxt.addFocusListener(listener);
        this.dayTxt.getDocument().addDocumentListener(listener);
        this.isNew = true;
        this.saved = false;
        this.deleted = false;

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(120, 35));
        this.panel.setMinimumSize(new Dimension(120, 35));
        this.panel.setMaximumSize(new Dimension(120, 35));
        this.panel.setBorder(BorderFactory.createEtchedBorder());
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));

        this.panel.add(this.dayTxt);
        this.panel.add(this.percentageTxt);
    }

    public JPanel getPanel() {
        return panel;
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

    ///////
    /* public SymptomStage(String name, double d, double i, int index, Model model) {
        this.name = name;
        this.model = model;
        this.deathPercentage = d;
        this.immunePercentage = i;
        this.index = index;

        this.isNew = true;
        this.saved = false;
        this.deleted = false;

        nameLabel1 = new JLabel(this.name + "");
        nameLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel1.setToolTipText("");
        nameLabel1.setAlignmentX(Component.LEFT_ALIGNMENT);
        nameLabel1.setMaximumSize(new Dimension(120, 18));
        nameLabel1.setMinimumSize(new Dimension(120, 18));
        nameLabel1.setPreferredSize(new Dimension(120, 18));

        deathPercentageTxt = new JTextField(this.deathPercentage + "");
        deathPercentageTxt.setHorizontalAlignment(SwingConstants.CENTER);
        deathPercentageTxt.setToolTipText("");
        deathPercentageTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
        deathPercentageTxt.setMaximumSize(new Dimension(120, 31));
        deathPercentageTxt.setMinimumSize(new Dimension(120, 31));
        deathPercentageTxt.setPreferredSize(new Dimension(120, 31));

        dComponent = Box.createHorizontalStrut(3);

        immunePercentageTxt = new JTextField(this.immunePercentage + "");
        immunePercentageTxt.setHorizontalAlignment(SwingConstants.CENTER);
        immunePercentageTxt.setToolTipText("");
        immunePercentageTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
        immunePercentageTxt.setMaximumSize(new Dimension(120, 31));
        immunePercentageTxt.setMinimumSize(new Dimension(120, 31));
        immunePercentageTxt.setPreferredSize(new Dimension(120, 31));

        this.iList = new JTextFieldDoubleImmuneListener(this.immunePercentageTxt, model.getMainFrame(), this.immunePercentage + "", this);
        this.dList = new JTextFieldDoubleDeathListener(this.deathPercentageTxt, model.getMainFrame(), this.deathPercentage + "", this);
        immunePercentageTxt.addFocusListener(iList);
        immunePercentageTxt.getDocument().addDocumentListener(iList);
        deathPercentageTxt.addFocusListener(dList);
        deathPercentageTxt.getDocument().addDocumentListener(dList);

        iComponent = Box.createHorizontalStrut(3);

        this.humanState = new HumanStat(model.getMainFrame().getListHumanStatName().get(0).getName(), model.getMainFrame().getListHumanStatName().get(0).getColorName(), this);
        humanStatBox = new JComboBox();
        for (String s : model.getMainFrame().getHumanStatTab()) {
            humanStatBox.addItem(s);
        }
        humanStatBox.setPreferredSize(new Dimension(120, 31));
        humanStatBox.setMinimumSize(new Dimension(120, 31));
        humanStatBox.setMaximumSize(new Dimension(120, 31));
        humanStatBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jComboActionEvent();
            }
        });
        this.cHumanStateBox = Box.createHorizontalStrut(3);
    }*/
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

    /* public JTextField getDeathPercentageTxt() {
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
    }*/
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
            SymptomStageController.INSTANCE.delete(this.id);
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
            HumanStateController.INSTANCE.delete(this.humanState.getId());
            SymptomStageController.INSTANCE.deleteModel(this.id);
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
                    JOptionPane.showOptionDialog(this.mainFrame, this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
            }
            try {
                Double d = Double.parseDouble(numTxt);
                if (!insert) {
                    this.currentString = numTxt;
                    this.symStage.setDeathPercentage(Double.parseDouble(numTxt));
                    mainFrame.setModelSavedButtonEnable();
                    this.symStage.getModel().setSaved(false);
                    this.symStage.setSaved(false);
                }
                if (d > 100) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(this.mainFrame, this.greaterMessage, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(this.currentString);
                    this.insert = false;
                }
            } catch (NumberFormatException ex) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.mainFrame, this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
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
            mainFrame.setModelSavedButtonEnable();
            this.symStage.getModel().setSaved(false);
            this.symStage.setSaved(false);

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
                    JOptionPane.showOptionDialog(this.mainFrame, this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
            }
            try {
                Double d = Double.parseDouble(numTxt);
                if (!insert) {
                    this.currentString = numTxt;
                    this.symStage.setImmunePercentage(Double.parseDouble(numTxt));
                    mainFrame.setModelSavedButtonEnable();
                    this.symStage.getModel().setSaved(false);
                    this.symStage.setSaved(false);
                }
                if (d > 100) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(this.mainFrame, this.greaterMessage, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(this.currentString);
                    this.insert = false;
                }
            } catch (NumberFormatException ex) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.mainFrame, this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
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
            mainFrame.setModelSavedButtonEnable();
            this.symStage.getModel().setSaved(false);
            this.symStage.setSaved(false);

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
}
