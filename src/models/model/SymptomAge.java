package models.model;

import controller.controllers.HumanAgeSymptomController;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Joseph
 */
public class SymptomAge {
    
    private int id;
    private HumanAge humanAge;
    private SymptomType symptomType;
    private double percentage;
    private JTextField percentageTxt;
    private boolean deleted, isNew, saved;
    
    private Model model;
    private JTextFieldDoubleListener percentageListener;
    
    public void setEnable() {
        this.percentageTxt.setEnabled(true);
    }
    
    public void setDisable() {
        this.percentageTxt.setEnabled(false);
    }

    public SymptomAge(HumanAge humanAge, SymptomType st, double percentage, Model model) {
        this.symptomType = st;
        this.percentage = percentage;
        this.humanAge = humanAge;
        this.model = model;
        this.deleted = false;
        this.isNew = true;
        this.saved = false;
        this.percentageTxt = new JTextField(this.percentage + "");
        this.percentageTxt.setPreferredSize(new Dimension(130, 31));
        this.percentageTxt.setMaximumSize(new Dimension(130, 31));
        this.percentageTxt.setMinimumSize(new Dimension(130, 31));
        this.percentageTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.percentageTxt.setToolTipText("");
        this.percentageTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        this.percentageListener = new JTextFieldDoubleListener(percentageTxt, this);
        this.percentageTxt.getDocument().addDocumentListener(percentageListener);
        this.percentageTxt.addFocusListener(percentageListener);
    }
    
    public SymptomAge(int id, HumanAge humanAge, SymptomType st, double percentage) {
        this.symptomType = st;
        this.id = id;
        this.percentage = percentage;
        this.humanAge = humanAge;
        this.deleted = false;
        this.isNew = false;
        this.saved = true;
        this.percentageTxt = new JTextField(this.percentage + "");
        this.percentageTxt.setPreferredSize(new Dimension(130, 31));
        this.percentageTxt.setMaximumSize(new Dimension(130, 31));
        this.percentageTxt.setMinimumSize(new Dimension(130, 31));
        this.percentageTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.percentageTxt.setToolTipText("");
        this.percentageTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        this.percentageListener = new JTextFieldDoubleListener(percentageTxt, this);
        this.percentageTxt.getDocument().addDocumentListener(percentageListener);
        this.percentageTxt.addFocusListener(percentageListener);
    }
    
    public SymptomType getSymptomType() {
        return symptomType;
    }
    
    public void setSymptomType(SymptomType symptomType) {
        this.symptomType = symptomType;
    }
    
    public double getPercentage() {
        return percentage;
    }
    
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    
    public JTextField getPercentageTxt() {
        return percentageTxt;
    }
    
    public void setPercentageTxt(JTextField percentageTxt) {
        this.percentageTxt = percentageTxt;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public HumanAge getHumanAge() {
        return humanAge;
    }
    
    public Model getModel() {
        return model;
    }
    
    public void setModel(Model model) {
        this.model = model;
    }
    
    public void setHumanAge(HumanAge humanAge) {
        this.humanAge = humanAge;
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
    
    public void save() {
        if (this.isDeleted()) {
            HumanAgeSymptomController.INSTANCE.delete(this.id);
            return;
        }
        if (this.isIsNew()) {
            this.id = HumanAgeSymptomController.INSTANCE.insert(this);
            this.setIsNew(false);
            this.setSaved(true);
        } else {
            if (!this.isSaved()) {
                HumanAgeSymptomController.INSTANCE.update(this);
                this.setSaved(true);
            } else {
                
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
        private SymptomAge symage;
        
        public JTextFieldDoubleListener(JTextField textField, SymptomAge stage) {
            this.jtextField = textField;
            this.currentString = stage.getPercentage() + "";
            this.symage = stage;
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
                    JOptionPane.showOptionDialog(this.symage.getModel().getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
            }
            try {
                Double d = Double.parseDouble(numTxt);
                if (!insert) {
                    this.currentString = numTxt;
                    this.symage.setPercentage(Double.parseDouble(numTxt));
                    this.symage.getModel().getMainFrame().setModelSavedButtonEnable();
                    this.symage.getModel().setSaved(false);
                    this.symage.setSaved(false);
                }
                if (d > 100) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(this.symage.getModel().getMainFrame(), this.greaterMessage, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(this.currentString);
                    this.insert = false;
                }
            } catch (NumberFormatException ex) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.symage.getModel().getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
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
            this.symage.setPercentage(Double.parseDouble(s));
            this.symage.getModel().getMainFrame().setModelSavedButtonEnable();
            this.symage.getModel().setSaved(false);
            this.symage.setSaved(false);
            
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
