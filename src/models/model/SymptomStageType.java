package models.model;

import controller.controllers.SymptomStageTypeController;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SymptomStageType {

    private int id;
    private SymptomType symptomType;
    private SymptomStage symptomStage;
    private int day;
    private double percentage;

    private Model model;

    private JTextField dayTxt, percentageTxt;
    private JPanel panel;

    private boolean deleted, isNew, saved;

    private JTextFieldIntegerListener dayListener;
    private JTextFieldDoubleListener percentageListener;

    public SymptomStageType(SymptomType type, SymptomStage symptomStage, int day, double percentage, Model model) {
        this.symptomStage = symptomStage;
        this.symptomType = type;
        this.day = day;
        this.model = model;
        this.deleted = false;
        this.isNew = true;
        this.saved = false;
        this.percentage = percentage;
        this.percentageTxt = new JTextField(this.percentage + "");
        this.percentageTxt.setPreferredSize(new Dimension(55, 31));
        this.percentageTxt.setMaximumSize(new Dimension(55, 31));
        this.percentageTxt.setMinimumSize(new Dimension(55, 31));
        this.percentageTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.percentageTxt.setToolTipText("");
        this.percentageTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.percentageListener = new JTextFieldDoubleListener(percentageTxt, this);
        this.percentageTxt.getDocument().addDocumentListener(percentageListener);
        this.percentageTxt.addFocusListener(percentageListener);

        this.dayTxt = new JTextField(this.day + "");
        this.dayTxt.setPreferredSize(new Dimension(55, 31));
        this.dayTxt.setMaximumSize(new Dimension(55, 31));
        this.dayTxt.setMinimumSize(new Dimension(55, 31));
        this.dayTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.dayTxt.setToolTipText("");
        this.dayTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.dayListener = new JTextFieldIntegerListener(dayTxt, this);
        this.dayTxt.getDocument().addDocumentListener(dayListener);
        this.dayTxt.addFocusListener(dayListener);

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(120, 35));
        this.panel.setMinimumSize(new Dimension(120, 35));
        this.panel.setMaximumSize(new Dimension(120, 35));
        this.panel.setBorder(BorderFactory.createEtchedBorder());
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));

        this.panel.add(this.dayTxt);
        this.panel.add(this.percentageTxt);

    }

    public SymptomStageType(int id, SymptomType symptom, SymptomStage stage, int day, double percentage, Model model) {
        this.symptomType = symptom;
        this.symptomStage = stage;
        this.day = day;
        this.id = id;
        this.model = model;
        this.deleted = false;
        this.isNew = false;
        this.saved = true;
        this.percentage = percentage;
        this.percentageTxt = new JTextField(this.percentage + "");
        this.percentageTxt.setPreferredSize(new Dimension(55, 31));
        this.percentageTxt.setMaximumSize(new Dimension(55, 31));
        this.percentageTxt.setMinimumSize(new Dimension(55, 31));
        this.percentageTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.percentageTxt.setToolTipText("");
        this.percentageTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.percentageListener = new JTextFieldDoubleListener(percentageTxt, this);
        this.percentageTxt.getDocument().addDocumentListener(percentageListener);
        this.percentageTxt.addFocusListener(percentageListener);

        this.dayTxt = new JTextField(this.day + "");
        this.dayTxt.setPreferredSize(new Dimension(55, 31));
        this.dayTxt.setMaximumSize(new Dimension(55, 31));
        this.dayTxt.setMinimumSize(new Dimension(55, 31));
        this.dayTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.dayTxt.setToolTipText("");
        this.dayTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.dayListener = new JTextFieldIntegerListener(dayTxt, this);
        this.dayTxt.getDocument().addDocumentListener(dayListener);
        this.dayTxt.addFocusListener(dayListener);

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(120, 35));
        this.panel.setMinimumSize(new Dimension(120, 35));
        this.panel.setMaximumSize(new Dimension(120, 35));
        this.panel.setBorder(BorderFactory.createEtchedBorder());
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));

        this.panel.add(this.dayTxt);
        this.panel.add(this.percentageTxt);
    }

    public void setEnable() {
        this.dayTxt.setEnabled(true);
        this.percentageTxt.setEnabled(true);
    }

    public void setDisable() {
        this.dayTxt.setEnabled(false);
        this.percentageTxt.setEnabled(false);
    }

    public SymptomStage getSymptomStage() {
        return symptomStage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public SymptomType getSymptomType() {
        return symptomType;
    }

    public void setSymptomType(SymptomType symptomType) {
        this.symptomType = symptomType;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JTextField getDayTxt() {
        return dayTxt;
    }

    public void setDayTxt(JTextField dayTxt) {
        this.dayTxt = dayTxt;
    }

    public JTextField getPercentageTxt() {
        return percentageTxt;
    }

    public void setPercentageTxt(JTextField percentageTxt) {
        this.percentageTxt = percentageTxt;
    }

    public void setSymptomStage(SymptomStage symptomStage) {
        this.symptomStage = symptomStage;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void save() {
        if (this.isDeleted()) {
            SymptomStageTypeController.INSTANCE.delete(this.id);
            return;
        }
        if (this.isIsNew()) {
            this.id = SymptomStageTypeController.INSTANCE.insert(this);
            this.setIsNew(false);
            this.setSaved(true);
        } else {
            if (!this.isSaved()) {
                SymptomStageTypeController.INSTANCE.update(this);
                this.setSaved(true);
            } else {

            }
        }
    }

    private class JTextFieldIntegerListener implements DocumentListener, FocusListener {

        private JTextField jtextField;
        private String currentString;
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = false;
        private final SymptomStageType symptomType;

        public JTextFieldIntegerListener(JTextField textField, SymptomStageType s) {
            this.jtextField = textField;
            this.currentString = s.getDay() + "";
            this.symptomType = s;
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
                if (this.symptomType.getModel() == null) {
                    System.out.println("say null");
                }
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.symptomType.getModel().getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
                return;
            }
            try {
                int d = Integer.parseInt(numTxt);
                if (!insert) {
                    this.symptomType.setDay(d);
                    this.symptomType.setSaved(false);
                    this.symptomType.getModel().setSaved(false);
                    symptomType.getModel().getMainFrame().setModelSavedButtonEnable();
                    this.currentString = numTxt;
                }

            } catch (NumberFormatException ex) {
                insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.symptomType.getModel().getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
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

            this.symptomType.setDay(Integer.parseInt(numTxt));
            this.symptomType.setSaved(false);
            this.symptomType.getModel().setSaved(false);
            this.currentString = numTxt;
            this.symptomType.getModel().getMainFrame().setModelSavedButtonEnable();

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

    private class JTextFieldDoubleListener implements DocumentListener, FocusListener {

        private final JTextField jtextField;
        private String currentString;
        private final String greaterMessage = "Number can't be greater 100!";
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = false;
        private SymptomStageType symStage;

        public JTextFieldDoubleListener(JTextField textField, SymptomStageType stage) {
            this.jtextField = textField;
            this.currentString = stage.getPercentage() + "";
            this.symStage = stage;
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
                if (!insert) {
                    this.currentString = numTxt;
                    this.symStage.setPercentage(Double.parseDouble(numTxt));
                    this.symStage.getModel().getMainFrame().setModelSavedButtonEnable();
                    this.symStage.getModel().setSaved(false);
                    this.symStage.setSaved(false);
                }
                if (d > 100) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(this.symStage.getModel().getMainFrame(), this.greaterMessage, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(this.currentString);
                    this.insert = false;
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
            this.symStage.setPercentage(Double.parseDouble(s));
            this.symStage.getModel().getMainFrame().setModelSavedButtonEnable();
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
