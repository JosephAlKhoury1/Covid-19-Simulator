package models.client;

import resources.Colors.Colors;
import resources.Messages.Messages;
import controller.controllers.HumanCityAgeContoller;
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
    private JTextField minTxt, maxTxt, percentageJtxt, workPercentageTxt;//,placeNumberTxt;
    private JPanel locPanel;
    private JTextFieldMinIntegerListener listMin;
    private JTextFieldMaxIntegerListener listMax;
    private JTextFieldDoubleListener listPer;
    private JTextFieldDoubleListener1 workListener;
    private JButton removeButton;
    private boolean minIsValid = false, maxIsValid = false;

    public HumanCityAgeType(String name, int min, int max, double percentage, double workPercentage, City city) {
        this.name = name;
        this.min = min;
        this.max = max;
        if (this.min != -1) {
            this.minIsValid = true;
        } else {
            minIsValid = false;
            this.name = "Invalid";
        }
        if (this.max != -1) {
            this.maxIsValid = true;
        } else {
            maxIsValid = false;
            this.name = "Invalid";
        }
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
        panel.add(this.workPercentageTxt);
        panel.add(Box.createHorizontalStrut(3));

        this.comp = Box.createVerticalStrut(3);

        this.locPanel = new JPanel();
        locPanel.setPreferredSize(new Dimension(1000, 35));
        locPanel.setMinimumSize(new Dimension(1000, 35));
        locPanel.setMaximumSize(new Dimension(48887888, 35));
        locPanel.setLayout(new BoxLayout(this.locPanel, BoxLayout.X_AXIS));

        for (String s : Data.tabLocation) {
            if (!s.equals("House")) {
                this.listLocationToGoName.add(s);
                LocationToGo lt = new LocationToGo(s, 0.0, this);
                listLocationToGo.add(lt);
                this.locPanel.add(lt.getPercentageTxt());
                this.locPanel.add(lt.getcPercentage());
            }
        }

        this.panel.add(this.locPanel);

        removeButton = new JButton();
        removeButton.setPreferredSize(new Dimension(40, 35));
        removeButton.setMinimumSize(new Dimension(40, 35));
        removeButton.setMaximumSize(new Dimension(40, 35));

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeActionPerformed();
            }
        });
        removeButton.setIcon(Icons.DELETEICON);
        this.panel.add(this.removeButton);

        checkValid();
    }

    public HumanCityAgeType(int id, String name, int min, int max, double percentage, double workPercentage, List<LocationToGo> list, List<String> listN) {
        this.id = id;
        this.name = name;
        this.min = min;
        this.max = max;
        if (this.min != -1) {
            this.minIsValid = true;
        } else {
            minIsValid = false;
            this.name = "Invalid";
        }
        if (this.max != -1) {
            this.maxIsValid = true;
        } else {
            maxIsValid = false;
            this.name = "Invalid";
        }
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

        this.comp = Box.createVerticalStrut(3);

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

        removeButton = new JButton();
        removeButton.setPreferredSize(new Dimension(40, 35));
        removeButton.setMinimumSize(new Dimension(40, 35));
        removeButton.setMaximumSize(new Dimension(40, 35));

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeActionPerformed();
            }
        });
        removeButton.setIcon(Icons.DELETEICON);
        this.panel.add(this.removeButton);
    }

    private void removeActionPerformed() {
        int index = JOptionPane.showOptionDialog(this.city.getMainFrame(), Messages.deleteCityAgeWarning(), "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, Icons.WARNINGICON, null, null);
        if (index == JOptionPane.NO_OPTION || index == JOptionPane.CLOSED_OPTION) {
            return;
        }
        this.setDeleted(true);
        System.out.println("remove action");
        
        setSaved(false);
        city.getMainFrame().setCitySavedButtonEnable();
        city.setIsSaved(false);

        city.removeHumanAgeType(this);
        this.city.checkAgePercentage();
        city.getCityPanel().reinitAgePanel();
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

    public boolean isMinIsValid() {
        return minIsValid;
    }

    public void setMinIsValid(boolean minIsValid) {
        this.minIsValid = minIsValid;
    }

    public boolean isMaxIsValid() {
        return maxIsValid;
    }

    public void setMaxIsValid(boolean maxIsValid) {
        this.maxIsValid = maxIsValid;
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
        System.out.println("save human");
        if (this.isDeleted()) {
            System.out.println("deleted");
            if (this.isNew) {
                System.out.println("isNew");
                return;
            } else {
                System.out.println("not new");
                System.out.println("delete");
                for (LocationToGo lg : this.listLocationToGo) {
                    lg.setDeleted(true);
                    lg.save();
                }
                HumanCityAgeContoller.INSTANCE.delete(id);
            }
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

    private void checkValid() {
        if (!this.minIsValid || !this.maxIsValid) {
            this.name = "Invalid";
            this.nameLabel.setText(name);
            this.nameLabel.setIcon(Icons.WARNINGICON);
            this.nameLabel.setToolTipText(Messages.ThisAgeIsInvalid());
            this.workPercentageTxt.setEnabled(false);
            for (LocationToGo lg : this.listLocationToGo) {
                lg.getPercentageTxt().setEnabled(false);
            }
        } else {
            this.name = "Between " + min + " and " + max;
            this.nameLabel.setText(name);
            this.nameLabel.setText(name);
            this.nameLabel.setIcon(null);
            this.nameLabel.setToolTipText(null);
            this.workPercentageTxt.setEnabled(true);
            for (LocationToGo lg : this.listLocationToGo) {
                lg.getPercentageTxt().setEnabled(true);
            }
        }
    }

    private class JTextFieldMinIntegerListener implements DocumentListener, FocusListener {

        private JTextField jtextField;

        private boolean insert = true;
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
            numTxt = numTxt.trim();
            if (numTxt.equals("-1") || numTxt.equals("-")) {
                if (!this.humanAge.isMinIsValid()) {
                    return;
                }
            }
            if (numTxt.contains("f") || numTxt.contains("d")) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(city.getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(min + "");
                return;
            }

            try {
                int d = Integer.parseInt(numTxt);
                if (!insert) {
                    city.setIsSaved(false);
                    city.getMainFrame().setCitySavedButtonEnable();
                }

            } catch (NumberFormatException ex) {
                insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(city.getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
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
            if (numTxt.equals("-1") || numTxt.equals("-")) {
                if (!this.humanAge.isMinIsValid()) {
                    return;
                }
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
            } else if (numtxt.equals("-1") || numtxt.equals("-")) {
                insert = true;
                if (!this.humanAge.isMinIsValid()) {
                    insertZero(min + "");
                    return;
                }
            } else {
                insert = true;
            }

            int d = Integer.parseInt(numtxt);
            if (d >= max && this.humanAge.isMaxIsValid()) {
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(city.getMainFrame(), Messages.minAgeCantBeHigherThanMaxAge(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(min + "");
            } else {
                boolean isOk = true;
                for (HumanCityAgeType ha : city.getListHumanAgeType()) {
                    if (ha.isMinIsValid() && ha.isMaxIsValid()) {
                        if (ha.getMin() <= d && ha.getMax() >= d && this.humanAge != ha) {
                            isOk = false;
                            break;
                        }
                    }
                }
                if (isOk) {
                    min = d;
                    this.humanAge.setMinIsValid(true);
                    this.humanAge.setSaved(false);
                    city.setIsSaved(false);
                    city.getMainFrame().setCitySavedButtonEnable();
                    checkValid();
                } else {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(city.getMainFrame(), Messages.ThisAgeIsContainsInOtherAge(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(min + "");
                }
            }
        }

    }

    private class JTextFieldMaxIntegerListener implements DocumentListener, FocusListener {

        private JTextField jtextField;
        private boolean insert = true;
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
            if (numTxt.equals("-1") || numTxt.equals("-")) {
                if (!this.humanAge.isMaxIsValid()) {
                    return;
                }
            }
            if (numTxt.contains("f") || numTxt.contains("d")) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(city.getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
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
                    JOptionPane.showOptionDialog(city.getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(max + "");
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            String numTxt = this.jtextField.getText();
            if (numTxt.equals("-1") || numTxt.equals("-")) {
                if (!this.humanAge.isMaxIsValid()) {
                    return;
                }
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
            String numTxt = this.jtextField.getText();
            if (numTxt.equals("")) {
                insert = true;
                insertZero(max + "");
                return;
            } else if (numTxt.equals("-1") || numTxt.equals("-")) {
                insert = true;
                if (!this.humanAge.isMaxIsValid()) {
                    insertZero(max + "");
                    return;
                }
            } else {
                insert = true;
            }

            int d = Integer.parseInt(numTxt);
            if (d <= min && this.humanAge.isMinIsValid()) {
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(city.getMainFrame(), Messages.maxAgeCantBeLowerThanMinAge(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(max + "");
            } else {
                boolean isOk = true;
                for (HumanCityAgeType ha : city.getListHumanAgeType()) {
                    if (ha.isMinIsValid() && ha.isMaxIsValid()) {
                        if (ha.getMin() <= d && ha.getMax() >= d && ha != this.humanAge) {
                            isOk = false;
                            break;
                        }
                    }
                }
                if (isOk) {
                    max = d;
                    this.humanAge.setMaxIsValid(true);
                    this.humanAge.setSaved(false);
                    city.setIsSaved(false);
                    city.getMainFrame().setCitySavedButtonEnable();
                    checkValid();
                } else {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(city.getMainFrame(), Messages.ThisAgeIsContainsInOtherAge(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
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
                    JOptionPane.showOptionDialog(this.loc.getCity().getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
            }
            try {
                Double d = Double.parseDouble(numTxt);
                if (numTxt.contains(" ")) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(this.loc.getCity().getMainFrame(), Messages.percentageCanBbeGreaterThen100(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(this.currentString);
                    this.insert = false;
                    return;
                }
                if (d > 100) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(this.loc.getCity().getMainFrame(), Messages.percentageCanBbeGreaterThen100(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
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
                    JOptionPane.showOptionDialog(this.loc.getCity().getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
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
                    JOptionPane.showOptionDialog(this.loc.getCity().getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
            }
            try {
                if (numTxt.contains(" ")) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(this.loc.getCity().getMainFrame(), Messages.badNumberFormat(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE,
                                null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(this.currentString);
                    this.insert = false;
                    return;
                }
                Double d = Double.parseDouble(numTxt);
                if (d > 100) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(this.loc.getCity().getMainFrame(), Messages.percentageCanBbeGreaterThen100(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(this.currentString);
                    this.insert = false;
                } else {
                    if (!insert) {
                        this.currentString = numTxt;
                        this.loc.setWorkPercentage(Double.parseDouble(numTxt));
                        this.loc.getCity().getMainFrame().setCitySavedButtonEnable();
                        this.loc.getCity().setIsSaved(false);
                        this.loc.setSaved(false);
                    }
                }

            } catch (NumberFormatException ex) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.loc.getCity().getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
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
}
