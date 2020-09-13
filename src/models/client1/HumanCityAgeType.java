package models.client1;

import controller.controllers.HumanCityAgeContoller;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import resources.icon.*;

public class HumanCityAgeType extends javax.swing.JPanel {

    private int id;
    private City city;
    private String name;
    private int min;
    private int max;
    private int placeNumber;
    private double workPercentage;

    private double humanPercentage;
    private boolean isNew;
    private boolean saved;
    private boolean deleted;

    private Component comp;
    private List<LocationToGo> listLocationToGo;
    private List<LocationToGo> listLocationAdd;
    private List<LocationToGo> listLocationDeleted;
    private List<String> listLocationToGoName;

    private JPanel panel;
    private JLabel nameLabel;
    private JTextField minTxt, maxTxt, percentageJtxt, placeNumberTxt, workPercentageTxt;
    private JPanel locPanel;
    private JTextFieldMinIntegerListener listMin;
    private JTextFieldMaxIntegerListener listMax;
    private JTextFieldDoubleListener listPer;
    private JTextFieldDoubleListener1 workListener;
    private JTextFieldIntegerListener placeListener;

    public HumanCityAgeType(String name, int min, int max, double percentage, int place, double workPercentage, City city) {
        this.name = name;
        this.min = min;
        this.max = max;
        this.placeNumber = place;
        this.workPercentage = workPercentage;
        this.isNew = true;
        this.saved = false;
        this.deleted = false;
        this.listLocationToGoName = new ArrayList();
        this.humanPercentage = percentage;
        this.city = city;
        this.listLocationToGo = new ArrayList();
        this.listLocationAdd = new ArrayList();
        this.listLocationDeleted = new ArrayList();
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(1000, 35));
        panel.setMinimumSize(new Dimension(1000, 35));
        panel.setMaximumSize(new Dimension(48887888, 35));
        panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createEtchedBorder());

        this.nameLabel = new JLabel(name);
        this.nameLabel.setPreferredSize(new Dimension(124, 31));
        this.nameLabel.setMinimumSize(new Dimension(124, 31));
        this.nameLabel.setMaximumSize(new Dimension(124, 31));
        this.nameLabel.setHorizontalAlignment(SwingUtilities.CENTER);
        this.nameLabel.setBorder(BorderFactory.createEtchedBorder());

        this.minTxt = new JTextField(min + "");
        this.minTxt.setPreferredSize(new Dimension(41, 31));
        this.minTxt.setMinimumSize(new Dimension(41, 31));
        this.minTxt.setMaximumSize(new Dimension(41, 31));
        this.minTxt.setHorizontalAlignment(SwingUtilities.CENTER);
        this.minTxt.setBackground(new Color(255, 204, 51));
        this.listMin = new JTextFieldMinIntegerListener(minTxt, this);
        this.minTxt.addFocusListener(this.listMin);
        this.minTxt.getDocument().addDocumentListener(this.listMin);

        this.maxTxt = new JTextField(max + "");
        this.maxTxt.setPreferredSize(new Dimension(41, 31));
        this.maxTxt.setMinimumSize(new Dimension(41, 31));
        this.maxTxt.setMaximumSize(new Dimension(41, 31));
        this.maxTxt.setHorizontalAlignment(SwingUtilities.CENTER);
        this.maxTxt.setBackground(new Color(255, 204, 51));
        this.listMax = new JTextFieldMaxIntegerListener(maxTxt, this);
        this.maxTxt.addFocusListener(this.listMax);
        this.maxTxt.getDocument().addDocumentListener(this.listMax);

        this.percentageJtxt = new JTextField(this.humanPercentage + "");
        this.percentageJtxt.setPreferredSize(new Dimension(121, 31));
        this.percentageJtxt.setMinimumSize(new Dimension(121, 31));
        this.percentageJtxt.setMaximumSize(new Dimension(121, 31));
        this.percentageJtxt.setHorizontalAlignment(SwingUtilities.CENTER);
        this.listPer = new JTextFieldDoubleListener(this.percentageJtxt, this.humanPercentage + "", this);
        this.percentageJtxt.addFocusListener(this.listPer);
        this.percentageJtxt.getDocument().addDocumentListener(this.listPer);

        this.placeNumberTxt = new JTextField(this.placeNumber + "");
        this.placeNumberTxt.setPreferredSize(new Dimension(121, 31));
        this.placeNumberTxt.setMinimumSize(new Dimension(121, 31));
        this.placeNumberTxt.setMaximumSize(new Dimension(121, 31));
        this.placeNumberTxt.setHorizontalAlignment(SwingUtilities.CENTER);
        this.placeListener = new JTextFieldIntegerListener(this.placeNumberTxt, this);
        this.placeNumberTxt.addFocusListener(this.placeListener);
        this.placeNumberTxt.getDocument().addDocumentListener(this.placeListener);

        this.workPercentageTxt = new JTextField(this.workPercentage + "");
        this.workPercentageTxt.setPreferredSize(new Dimension(121, 31));
        this.workPercentageTxt.setMinimumSize(new Dimension(121, 31));
        this.workPercentageTxt.setMaximumSize(new Dimension(121, 31));
        this.workPercentageTxt.setHorizontalAlignment(SwingUtilities.CENTER);
        this.workListener = new JTextFieldDoubleListener1(this.workPercentageTxt, this.workPercentage + "", this);
        this.workPercentageTxt.addFocusListener(this.workListener);
        this.workPercentageTxt.getDocument().addDocumentListener(this.workListener);

        panel.add(this.nameLabel);
        panel.add(this.minTxt);
        panel.add(this.maxTxt);
        panel.add(this.percentageJtxt);
        panel.add(this.placeNumberTxt);
        panel.add(this.workPercentageTxt);
        panel.add(Box.createHorizontalStrut(3));

        this.locPanel = new JPanel();
        locPanel.setPreferredSize(new Dimension(1000, 35));
        locPanel.setMinimumSize(new Dimension(1000, 35));
        locPanel.setMaximumSize(new Dimension(48887888, 35));
        locPanel.setLayout(new BoxLayout(this.locPanel, BoxLayout.X_AXIS));

        for (String s : Data.tabLocation) {
            this.listLocationToGoName.add(s);
            LocationToGo lt = new LocationToGo(s, 0.0, this);
            listLocationToGo.add(lt);
            this.locPanel.add(lt.getPercentageTxt());
            this.locPanel.add(lt.getcPercentage());
        }
        this.panel.add(this.locPanel);
    }

    public HumanCityAgeType(int id, String name, int min, int max, double percentage, int place, double workPercentage, List<LocationToGo> list, List<String> listN) {
        this.id = id;
        this.name = name;
        this.min = min;
        this.max = max;
        this.placeNumber = place;
        this.workPercentage = workPercentage;
        this.isNew = false;
        this.saved = true;
        this.deleted = false;
        this.humanPercentage = percentage;
        this.listLocationToGoName = listN;
        this.listLocationToGo = list;
        this.listLocationAdd = new ArrayList();
        this.listLocationDeleted = new ArrayList();
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(1000, 35));
        panel.setMinimumSize(new Dimension(1000, 35));
        panel.setMaximumSize(new Dimension(48887888, 35));
        panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createEtchedBorder());

        this.nameLabel = new JLabel(name);
        this.nameLabel.setPreferredSize(new Dimension(124, 31));
        this.nameLabel.setMinimumSize(new Dimension(124, 31));
        this.nameLabel.setMaximumSize(new Dimension(124, 31));
        this.nameLabel.setHorizontalAlignment(SwingUtilities.CENTER);
        this.nameLabel.setBorder(BorderFactory.createEtchedBorder());

        this.minTxt = new JTextField(min + "");
        this.minTxt.setPreferredSize(new Dimension(40, 31));
        this.minTxt.setMinimumSize(new Dimension(40, 31));
        this.minTxt.setMaximumSize(new Dimension(40, 31));
        this.minTxt.setHorizontalAlignment(SwingUtilities.CENTER);
        this.minTxt.setBackground(new Color(255, 204, 51));
        this.listMin = new JTextFieldMinIntegerListener(minTxt, this);
        this.minTxt.addFocusListener(this.listMin);
        this.minTxt.getDocument().addDocumentListener(this.listMin);

        this.maxTxt = new JTextField(max + "");
        this.maxTxt.setPreferredSize(new Dimension(40, 31));
        this.maxTxt.setMinimumSize(new Dimension(40, 31));
        this.maxTxt.setMaximumSize(new Dimension(40, 31));
        this.maxTxt.setHorizontalAlignment(SwingUtilities.CENTER);
        this.maxTxt.setBackground(new Color(255, 204, 51));
        this.listMax = new JTextFieldMaxIntegerListener(maxTxt, this);
        this.maxTxt.addFocusListener(this.listMax);
        this.maxTxt.getDocument().addDocumentListener(this.listMax);

        this.percentageJtxt = new JTextField(this.humanPercentage + "");
        this.percentageJtxt.setPreferredSize(new Dimension(120, 31));
        this.percentageJtxt.setMinimumSize(new Dimension(120, 31));
        this.percentageJtxt.setMaximumSize(new Dimension(120, 31));
        this.percentageJtxt.setHorizontalAlignment(SwingUtilities.CENTER);
        this.listPer = new JTextFieldDoubleListener(this.percentageJtxt, this.humanPercentage + "", this);
        this.percentageJtxt.addFocusListener(this.listPer);
        this.percentageJtxt.getDocument().addDocumentListener(this.listPer);

        this.placeNumberTxt = new JTextField(this.placeNumber + "");
        this.placeNumberTxt.setPreferredSize(new Dimension(121, 31));
        this.placeNumberTxt.setMinimumSize(new Dimension(121, 31));
        this.placeNumberTxt.setMaximumSize(new Dimension(121, 31));
        this.placeNumberTxt.setHorizontalAlignment(SwingUtilities.CENTER);
        this.placeListener = new JTextFieldIntegerListener(this.placeNumberTxt, this);
        this.placeNumberTxt.addFocusListener(this.placeListener);
        this.placeNumberTxt.getDocument().addDocumentListener(this.placeListener);

        this.workPercentageTxt = new JTextField(this.workPercentage + "");
        this.workPercentageTxt.setPreferredSize(new Dimension(121, 31));
        this.workPercentageTxt.setMinimumSize(new Dimension(121, 31));
        this.workPercentageTxt.setMaximumSize(new Dimension(121, 31));
        this.workPercentageTxt.setHorizontalAlignment(SwingUtilities.CENTER);
        this.workListener = new JTextFieldDoubleListener1(this.workPercentageTxt, this.workPercentage + "", this);
        this.workPercentageTxt.addFocusListener(this.workListener);
        this.workPercentageTxt.getDocument().addDocumentListener(this.workListener);

        panel.add(this.nameLabel);
        panel.add(this.minTxt);
        panel.add(this.maxTxt);
        panel.add(this.percentageJtxt);
        panel.add(this.placeNumberTxt);
        panel.add(this.workPercentageTxt);
        panel.add(Box.createHorizontalStrut(3));

        this.locPanel = new JPanel();
        locPanel.setPreferredSize(new Dimension(1000, 35));
        locPanel.setMinimumSize(new Dimension(1000, 35));
        locPanel.setMaximumSize(new Dimension(48887888, 35));
        locPanel.setLayout(new BoxLayout(this.locPanel, BoxLayout.X_AXIS));

        for (LocationToGo lt : this.listLocationToGo) {
            lt.setAgeType(this);
            this.locPanel.add(lt.getPercentageTxt());
            this.locPanel.add(lt.getcPercentage());
        }
        this.panel.add(this.locPanel);
    }

    public int getId() {
        return id;
    }

    public List<String> getListLocationToGoName() {
        return listLocationToGoName;
    }

    public List<LocationToGo> getListLocationToGo() {
        return listLocationToGo;
    }

    public void setListLocationToGo(List<LocationToGo> listLocationToGo) {
        this.listLocationToGo = listLocationToGo;
    }

    public void setListLocationToGoName(List<String> listLocationToGoName) {
        this.listLocationToGoName = listLocationToGoName;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTextField getPercentageJtxt() {
        return percentageJtxt;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public double getWorkPercentage() {
        return workPercentage;
    }

    public void setWorkPercentage(double workPercentage) {
        this.workPercentage = workPercentage;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public Component getComp() {
        return comp;
    }

    public void setComp(Component comp) {
        this.comp = comp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public double getHumanPercentage() {
        return humanPercentage;
    }

    public void setHumanPercentage(double humanPercentage) {
        this.humanPercentage = humanPercentage;
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
            return;
        }
        if (this.isNew) {
            HumanCityAgeContoller.INSTANCE.insertHumanAgeType(this);
            this.setIsNew(false);
            this.setSaved(true);
        } else {
            if (!this.isSaved()) {
                HumanCityAgeContoller.INSTANCE.updateHumanAgeType(this);
                this.setSaved(true);
            } else {

            }
        }
        for (LocationToGo lt : this.listLocationToGo) {
            lt.save();
        }
        for (LocationToGo lt : this.listLocationDeleted) {
            lt.save();
        }
    }

    public void updateLocation(List<LocationToGo> list) {
        updateListLocation(list);
        updateLocationPanel();
    }

    private void updateListLocation(List<LocationToGo> list) {
        for (LocationToGo ha : list) {
            if (ha.isIsNew()) {
                if (!ha.isDeleted()) {
                    LocationToGo han = new LocationToGo(ha.getName(), 0.0, this);
                    this.listLocationToGo.add(han);
                    this.listLocationAdd.add(han);
                } else {

                }
            } else {
                if (ha.isDeleted()) {
                    LocationToGo tmp = null;
                    for (LocationToGo hat : this.listLocationToGo) {
                        if (hat.getName().equals(ha.getName())) {
                            hat.setDeleted(true);
                            tmp = hat;
                            break;
                        }
                    }
                    if (this.listLocationAdd.contains(tmp)) {
                        this.listLocationAdd.remove(tmp);
                    }
                    this.listLocationToGo.remove(tmp);
                    this.listLocationDeleted.add(tmp);
                } else {

                }
            }
        }
    }

    private void updateLocationPanel() {
        this.locPanel.removeAll();
        for (LocationToGo lt : this.listLocationToGo) {
            lt.setAgeType(this);
            this.locPanel.add(lt.getPercentageTxt());
            this.locPanel.add(lt.getcPercentage());
        }
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.city.removeHumanAgeType(this);
        this.city.getMainFrame().getCurrentCityPanel().removeHumaneAgeType(this);
        this.setDeleted(true);
        this.setSaved(false);
        this.city.setIsSaved(false);
    }

    private class JTextFieldMinIntegerListener implements DocumentListener, FocusListener {

        private JTextField jtextField;

        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = true;
        private final String numberHigher = "Min age can't be higher or equal to max age!";
        private HumanCityAgeType humanAge;

        public JTextFieldMinIntegerListener(JTextField textField, HumanCityAgeType humanAge) {
            this.jtextField = textField;
            this.humanAge = humanAge;
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
                    JOptionPane.showOptionDialog(city.getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(min + "");
                return;
            }
            try {
                int d = Integer.parseInt(numTxt);
                if (!insert) {
                    city.getMainFrame().setCitySavedButtonEnable();
                }

            } catch (NumberFormatException ex) {
                insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(city.getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(min + "");
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            String numTxt = this.jtextField.getText();
            if (insert) {
                return;
            }
            if (numTxt.length() <= 0 || numTxt.equals("")) {
                return;
            }
            city.getMainFrame().setCitySavedButtonEnable();
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
            String numtxt = this.jtextField.getText();
            if (numtxt.equals("")) {
                insert = true;
                insertZero(min + "");
                return;
            } else {
                insert = true;
            }
            int d = Integer.parseInt(numtxt);
            if (d >= max) {
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(city.getMainFrame(), this.numberHigher, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(min + "");
            } else {
                boolean isOk = true;
                for (HumanCityAgeType ha : city.getListHumanAgeType()) {
                    if (ha.getMin() <= d && ha.getMax() >= d && this.humanAge != ha) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    min = d;
                    nameLabel.setText("between " + min + " and " + max);
                    this.humanAge.setSaved(false);
                } else {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(city.getMainFrame(), this.numberHigher, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(min + "");
                }
            }
        }

    }

    private class JTextFieldMaxIntegerListener implements DocumentListener, FocusListener {

        private JTextField jtextField;
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = true;
        private final String numberLower = "Max age can't be lower or equal to min age!";
        private HumanCityAgeType humanAge;

        public JTextFieldMaxIntegerListener(JTextField textField, HumanCityAgeType humanAge) {
            this.jtextField = textField;
            this.humanAge = humanAge;
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
                    JOptionPane.showOptionDialog(city.getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(max + "");
                return;
            }
            try {
                int d = Integer.parseInt(numTxt);
                if (!insert) {
                    city.getMainFrame().setCitySavedButtonEnable();
                }

            } catch (NumberFormatException ex) {
                insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(city.getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(max + "");
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            String numTxt = this.jtextField.getText();
            if (numTxt.length() <= 0 || numTxt.equals("")) {
                return;
            }
            city.getMainFrame().setCitySavedButtonEnable();
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
                insertZero(max + "");
                return;
            } else {
                insert = true;
            }
            int d = Integer.parseInt(numTxt);
            if (d <= min) {
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(city.getMainFrame(), this.numberLower, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(max + "");
            } else {
                boolean isOk = true;
                for (HumanCityAgeType ha : city.getListHumanAgeType()) {
                    if (ha.getMin() <= d && ha.getMax() >= d && ha != this.humanAge) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    max = d;
                    nameLabel.setText("between " + min + " and " + max);
                    this.humanAge.setSaved(false);
                } else {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(city.getMainFrame(), "hello", this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(max + "");
                }
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
        private HumanCityAgeType loc;

        public JTextFieldDoubleListener(JTextField textField, String value, HumanCityAgeType loc) {
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
                    JOptionPane.showOptionDialog(this.loc.getCity().getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
            }
            try {
                Double d = Double.parseDouble(numTxt);
                if (d > 100) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(this.loc.getCity().getMainFrame(), this.greaterMessage, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(this.currentString);
                    this.insert = false;
                } else if (!insert) {
                    double totalPer = 0;
                    this.currentString = numTxt;
                    this.loc.setHumanPercentage(Double.parseDouble(numTxt));
                    this.loc.getCity().getMainFrame().setCitySavedButtonEnable();
                    this.loc.getCity().setIsSaved(false);
                    this.loc.setSaved(false);
                    for (HumanCityAgeType ha : city.getListHumanAgeType()) {
                        totalPer += ha.getHumanPercentage();
                    }
                    if (totalPer != 100) {
                        for (HumanCityAgeType ha : city.getListHumanAgeType()) {
                            ha.getPercentageJtxt().setBackground(Colors.WARNINGCOLOR);
                        }
                        city.getCityPanel().percentageOfHumanLabel.setIcon(Icons.WARNINGICON);
                        city.getCityPanel().percentageOfHumanLabel.setToolTipText(Messages.PERCENTAGEOFHUMANHAVINTHISAGEWITHWARNING);
                        city.getCityPanel().percentageOfHumanLabel.setBackground(Colors.WARNINGCOLOR);
                    } else {
                        for (HumanCityAgeType ha : city.getListHumanAgeType()) {
                            ha.getPercentageJtxt().setBackground(Colors.NOWARNINGCOLOR);
                        }
                        city.getCityPanel().percentageOfHumanLabel.setIcon(null);
                        city.getCityPanel().percentageOfHumanLabel.setToolTipText(Messages.PERCENTAGEOFHUMANHAVINTHISAGE);
                        city.getCityPanel().percentageOfHumanLabel.setBackground(Colors.NOWARNINGCOLOR);
                    }
                }

            } catch (NumberFormatException ex) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.loc.getCity().getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
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
            this.loc.setHumanPercentage(Double.parseDouble(s));
            this.loc.getCity().getMainFrame().setCitySavedButtonEnable();
            this.loc.setSaved(false);
            this.loc.getCity().setIsSaved(false);
            double totalPer = 0;
            for (HumanCityAgeType ha : city.getListHumanAgeType()) {
                totalPer += ha.getHumanPercentage();
            }
            if (totalPer != 100) {
                for (HumanCityAgeType ha : city.getListHumanAgeType()) {
                    ha.getPercentageJtxt().setBackground(Colors.WARNINGCOLOR);
                }
                city.getCityPanel().percentageOfHumanLabel.setIcon(Icons.WARNINGICON);
                city.getCityPanel().percentageOfHumanLabel.setToolTipText(Messages.PERCENTAGEOFHUMANHAVINTHISAGEWITHWARNING);
                city.getCityPanel().percentageOfHumanLabel.setBackground(Colors.WARNINGCOLOR);
            } else {
                for (HumanCityAgeType ha : city.getListHumanAgeType()) {
                    ha.getPercentageJtxt().setBackground(Colors.NOWARNINGCOLOR);
                }
                city.getCityPanel().percentageOfHumanLabel.setIcon(null);
                city.getCityPanel().percentageOfHumanLabel.setToolTipText(Messages.PERCENTAGEOFHUMANHAVINTHISAGE);
                city.getCityPanel().percentageOfHumanLabel.setBackground(Colors.NOWARNINGCOLOR);
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

    private class JTextFieldDoubleListener1 implements DocumentListener, FocusListener {

        private final JTextField jtextField;
        private String currentString;
        private final String greaterMessage = "Number can't be greater 100!";
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = false;
        private HumanCityAgeType loc;

        public JTextFieldDoubleListener1(JTextField textField, String value, HumanCityAgeType loc) {
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
                    JOptionPane.showOptionDialog(this.loc.getCity().getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
            }
            try {
                Double d = Double.parseDouble(numTxt);
                if (!insert) {
                    this.currentString = numTxt;
                    this.loc.setWorkPercentage(Double.parseDouble(numTxt));
                    this.loc.getCity().getMainFrame().setCitySavedButtonEnable();
                    this.loc.getCity().setIsSaved(false);
                    this.loc.setSaved(false);
                }
                if (d > 100) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(this.loc.getCity().getMainFrame(), this.greaterMessage, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(this.currentString);
                    this.insert = false;
                }
            } catch (NumberFormatException ex) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.loc.getCity().getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
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
            this.loc.setWorkPercentage(Double.parseDouble(s));
            this.loc.getCity().getMainFrame().setCitySavedButtonEnable();
            this.loc.setSaved(false);
            this.loc.getCity().setIsSaved(false);

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

    private class JTextFieldIntegerListener implements DocumentListener, FocusListener {

        private JTextField jtextField;
        private String currentString;
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = false;
        private final HumanCityAgeType human;

        public JTextFieldIntegerListener(JTextField textField, HumanCityAgeType s) {
            this.jtextField = textField;
            this.currentString = s.getPlaceNumber() + "";
            this.human = s;
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
                    JOptionPane.showOptionDialog(this.human.getCity().getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
                return;
            }
            try {
                int d = Integer.parseInt(numTxt);
                if (!insert) {
                    this.human.setPlaceNumber(d);
                    this.human.setSaved(false);
                    this.human.getCity().setIsSaved(false);
                    this.human.getCity().getMainFrame().setCitySavedButtonEnable();
                    this.currentString = numTxt;
                }

            } catch (NumberFormatException ex) {
                insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.human.getCity().getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
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

            this.human.setPlaceNumber(Integer.parseInt(numTxt));
            this.human.setSaved(false);
            this.human.getCity().setIsSaved(false);
            this.human.getCity().getMainFrame().setCitySavedButtonEnable();
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
}
