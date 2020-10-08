package models.client1;

import controller.controllers.LocationToGoController;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LocationToGo {

    private int id;
    private String name;
    private double percentage;

    private HumanCityAgeType ageType;

    private JTextField percentageTxt;
    private Component cPercentage;

    private boolean isNew, saved, deleted;

    private JTextFieldDoubleListener listener;

    private City city;
    private JLabel nameLabel;
    private Component cName;

    public LocationToGo(int id, String name, double percentage) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
        this.isNew = false;
        this.saved = true;
        this.deleted = false;
        this.percentageTxt = new JTextField(percentage + "");
        this.percentageTxt.setPreferredSize(new Dimension(120, 31));
        this.percentageTxt.setMinimumSize(new Dimension(120, 31));
        this.percentageTxt.setMaximumSize(new Dimension(120, 31));
        this.percentageTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.cPercentage = Box.createHorizontalStrut(3);

        this.listener = new JTextFieldDoubleListener(percentageTxt, percentage + "", this);
        this.percentageTxt.addFocusListener(listener);
        this.percentageTxt.getDocument().addDocumentListener(listener);
    }

    public LocationToGo(String name, double percentage, HumanCityAgeType ageType) {
        this.name = name;
        this.percentage = percentage;
        this.ageType = ageType;
        this.isNew = true;
        this.saved = false;
        this.deleted = false;
        this.percentageTxt = new JTextField(percentage + "");
        this.percentageTxt.setPreferredSize(new Dimension(120, 31));
        this.percentageTxt.setMinimumSize(new Dimension(120, 31));
        this.percentageTxt.setMaximumSize(new Dimension(120, 31));
        this.percentageTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.cPercentage = Box.createHorizontalStrut(3);

        this.listener = new JTextFieldDoubleListener(percentageTxt, percentage + "", this);
        this.percentageTxt.addFocusListener(listener);
        this.percentageTxt.getDocument().addDocumentListener(listener);
    }

    public LocationToGo(int id, String name) {
        this.id = id;
        this.name = name;
        this.isNew = false;
        this.saved = true;
        this.deleted = false;
        this.nameLabel = new JLabel(name);
        this.nameLabel.setPreferredSize(new Dimension(120, 31));
        this.nameLabel.setMinimumSize(new Dimension(120, 31));
        this.nameLabel.setMaximumSize(new Dimension(120, 31));
        this.nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.nameLabel.setBorder(BorderFactory.createEtchedBorder());

        this.cName = Box.createHorizontalStrut(3);
    }

    public LocationToGo(String name, City city) {
        this.name = name;
        this.city = city;
        this.isNew = true;
        this.saved = false;
        this.deleted = false;
        this.nameLabel = new JLabel(name);
        this.nameLabel.setPreferredSize(new Dimension(120, 31));
        this.nameLabel.setMinimumSize(new Dimension(120, 31));
        this.nameLabel.setMaximumSize(new Dimension(120, 31));
        this.nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.nameLabel.setBorder(BorderFactory.createEtchedBorder());

        this.cName = Box.createHorizontalStrut(3);
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public Component getcName() {
        return cName;
    }

    public void setcName(Component cName) {
        this.cName = cName;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public int getId() {
        return id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public HumanCityAgeType getAgeType() {
        return ageType;
    }

    public void setAgeType(HumanCityAgeType ageType) {
        this.ageType = ageType;
        //this.listener.setMainFrame(ageType.getCity().getMainFrame());
    }

    public JTextField getPercentageTxt() {
        return percentageTxt;
    }

    public void setPercentageTxt(JTextField percentageTxt) {
        this.percentageTxt = percentageTxt;
    }

    public Component getcPercentage() {
        return cPercentage;
    }

    public void setcPercentage(Component cPercentage) {
        this.cPercentage = cPercentage;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void save() {
        if (this.isDeleted()) {
            LocationToGoController.INSTANCE.delete(this.id);
            return;
        }
        if (this.isIsNew()) {
            LocationToGoController.INSTANCE.insert(this);
            this.setIsNew(false);
            this.setSaved(true);
        } else {
            if (!this.isSaved()) {
                LocationToGoController.INSTANCE.update(this);
                this.setSaved(true);
            }
        }
    }

    public void save1() {
        if (this.isDeleted()) {
            LocationToGoController.INSTANCE.deleteCity(this.id);
            return;
        }
        if (this.isIsNew()) {
            LocationToGoController.INSTANCE.insertCity(this);
            this.setIsNew(false);
            this.setSaved(true);
        } else {
            if (!this.isSaved()) {
                //LocationToGoController.INSTANCE.update(this);
                this.setSaved(true);
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
        private LocationToGo loc;

        public JTextFieldDoubleListener(JTextField textField, String value, LocationToGo loc) {
            this.jtextField = textField;
            this.currentString = value;
            this.loc = loc;
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
                    JOptionPane.showOptionDialog(this.loc.getAgeType().getCity().getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
            }
            try {
                Double d = Double.parseDouble(numTxt);
                if (d > 100) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(this.loc.getAgeType().getCity().getMainFrame(), this.greaterMessage, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(this.currentString);
                    this.insert = false;
                } else if (!insert) {
                    this.currentString = numTxt;
                    this.loc.setPercentage(Double.parseDouble(numTxt));
                    this.loc.getAgeType().getCity().getMainFrame().setCitySavedButtonEnable();
                    this.loc.getAgeType().getCity().setIsSaved(false);
                    this.loc.setSaved(false);
                }

            } catch (NumberFormatException ex) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.loc.getAgeType().getCity().getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
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
            this.loc.setPercentage(Double.parseDouble(s));
            this.loc.getAgeType().getCity().getMainFrame().setCitySavedButtonEnable();
            this.loc.setSaved(false);
            this.loc.getAgeType().getCity().setIsSaved(false);

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
