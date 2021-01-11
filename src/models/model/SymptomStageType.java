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
import resources.Colors.Colors;
import resources.Messages.Messages;

public class SymptomStageType {

    private int id;
    private SymptomType symptomType;
    private SymptomStage symptomStage;
    private int day;

    private Model model;

    private JTextField dayTxt;
    private JPanel panel;

    private boolean deleted, isNew, saved;

    private JTextFieldIntegerListener dayListener;

    public SymptomStageType(SymptomType type, SymptomStage symptomStage, int day, Model model) {
        this.symptomStage = symptomStage;
        this.symptomType = type;
        this.day = day;
        this.model = model;
        this.deleted = false;
        this.isNew = true;
        this.saved = false;

        this.dayTxt = new JTextField(this.day + "");
        this.dayTxt.setPreferredSize(new Dimension(118, 31));
        this.dayTxt.setMaximumSize(new Dimension(118, 31));
        this.dayTxt.setMinimumSize(new Dimension(118, 31));
        this.dayTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.dayTxt.setToolTipText("");
        this.dayTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        if (this.day == 0) {
            this.dayTxt.setBackground(Colors.LIGHTGRAY);
        } else {
            this.dayTxt.setBackground(Colors.WHITE);
        }

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

    }

    public SymptomStageType(int id, SymptomType symptom, SymptomStage stage, int day, Model model) {
        this.symptomType = symptom;
        this.symptomStage = stage;
        this.day = day;
        this.id = id;
        this.model = model;
        this.deleted = false;
        this.isNew = false;
        this.saved = true;

        this.dayTxt = new JTextField(this.day + "");
        this.dayTxt.setPreferredSize(new Dimension(118, 31));
        this.dayTxt.setMaximumSize(new Dimension(118, 31));
        this.dayTxt.setMinimumSize(new Dimension(118, 31));
        this.dayTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.dayTxt.setToolTipText("");
        this.dayTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        if (this.day == 0) {
            this.dayTxt.setBackground(Colors.LIGHTGRAY);
        } else {
            this.dayTxt.setBackground(Colors.WHITE);
        }

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
    }

    public void setEnable() {
        this.dayTxt.setEnabled(true);
    }

    public void setDisable() {
        this.dayTxt.setEnabled(false);
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

    public void setSymptomStage(SymptomStage symptomStage) {
        this.symptomStage = symptomStage;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void save() {
        if (this.isDeleted()) {
            if (this.isNew) {
                return;
            }
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
        private boolean insert = false;
        private final SymptomStageType symptomstageType;

        public JTextFieldIntegerListener(JTextField textField, SymptomStageType s) {
            this.jtextField = textField;
            this.currentString = s.getDay() + "";
            this.symptomstageType = s;
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
                    JOptionPane.showOptionDialog(this.symptomstageType.getModel().getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
                return;
            }
            try {
                int d = Integer.parseInt(numTxt);
                if (!insert) {
                    this.symptomstageType.setDay(d);
                    this.symptomstageType.setSaved(false);
                    this.symptomstageType.getModel().setSaved(false);
                    symptomType.getModel().getMainFrame().setModelSavedButtonEnable();
                    this.currentString = numTxt;
                }

            } catch (NumberFormatException ex) {
                insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.symptomstageType.getModel().getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
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

            this.symptomstageType.setDay(Integer.parseInt(numTxt));
            this.symptomstageType.setSaved(false);
            this.symptomstageType.getModel().setSaved(false);
            this.currentString = numTxt;
            this.symptomstageType.getModel().getMainFrame().setModelSavedButtonEnable();

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
            int d = Integer.parseInt(this.jtextField.getText());
            if (d == 0) {
                this.jtextField.setBackground(Colors.LIGHTGRAY);
            } else {
                this.jtextField.setBackground(Colors.WHITE);
            }
        }

    }
}
