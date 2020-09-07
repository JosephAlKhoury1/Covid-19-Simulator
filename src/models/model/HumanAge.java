package models.model;

import controller.controllers.HumanAgeController;
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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import models.client1.MonteCarlo;
import views1.MainFrame;

public class HumanAge {

    private int id;
    private String name;
    private int minAge;
    private int maxAge;
    private Model model;

    private JTextField minAgeTxt, maxAgeTxt;
    private JLabel nameLabel;
    private Component cName, cMinAge, cMaxAge;

    private boolean isNew, saved, deleted;

    private JTextFieldMinIntegerListener minListener;
    private JTextFieldMaxIntegerListener maxListener;

    private JPanel panel;
    private Component cPanel;

    private JButton removeButton;

    private List<SymptomAge> listSymptomAges;

    public void setEnable() {
        this.minAgeTxt.setEnabled(true);
        this.maxAgeTxt.setEnabled(true);
        this.removeButton.setEnabled(true);
        for (SymptomAge as : this.listSymptomAges) {
            as.setEnable();
        }
    }

    public void setDisable() {
        this.minAgeTxt.setEnabled(false);
        this.maxAgeTxt.setEnabled(false);
        this.removeButton.setEnabled(false);
        for (SymptomAge as : this.listSymptomAges) {
            as.setDisable();
        }
    }

    public List<SymptomAge> getListSymptomAges() {
        return listSymptomAges;
    }

    public void setListSymptomAges(List<SymptomAge> listSymptomAges) {
        this.listSymptomAges = listSymptomAges;
        this.panel = new JPanel();
        this.panel.setBackground(Color.red);
        this.panel.setPreferredSize(new Dimension(listSymptomAges.size() * 120 + 460, 35));
        this.panel.setMinimumSize(new Dimension(listSymptomAges.size() * 120 + 460, 35));
        this.panel.setMaximumSize(new Dimension(listSymptomAges.size() * 1200, 35));
        this.panel.setBorder(BorderFactory.createEtchedBorder());
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));
        this.cPanel = Box.createVerticalStrut(3);
        this.panel.add(this.nameLabel);
        for (SymptomAge sta : listSymptomAges) {
            this.panel.add(sta.getPercentageTxt());
        }
        this.panel.add(this.minAgeTxt);
        this.panel.add(this.maxAgeTxt);
        this.panel.add(removeButton);
    }

    public HumanAge(int id, String name, int minAge, int maxAge) {
        this.id = id;
        this.name = name;
        this.minAge = minAge;
        this.maxAge = maxAge;

        this.isNew = false;
        this.saved = true;
        this.deleted = false;

        this.nameLabel = new JLabel(name);
        this.nameLabel.setPreferredSize(new Dimension(130, 31));
        this.nameLabel.setMaximumSize(new Dimension(130, 31));
        this.nameLabel.setMinimumSize(new Dimension(130, 31));
        this.nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.nameLabel.setToolTipText("");
        this.nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.nameLabel.setBorder(BorderFactory.createEtchedBorder());

        this.cName = Box.createVerticalStrut(3);

        this.minAgeTxt = new JTextField(this.minAge + "");
        this.minAgeTxt.setPreferredSize(new Dimension(130, 31));
        this.minAgeTxt.setMaximumSize(new Dimension(130, 31));
        this.minAgeTxt.setMinimumSize(new Dimension(130, 31));
        this.minAgeTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.minAgeTxt.setToolTipText("");
        this.minAgeTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.cMinAge = Box.createHorizontalStrut(3);

        this.maxAgeTxt = new JTextField(this.maxAge + "");
        this.maxAgeTxt.setPreferredSize(new Dimension(130, 31));
        this.maxAgeTxt.setMaximumSize(new Dimension(130, 31));
        this.maxAgeTxt.setMinimumSize(new Dimension(130, 31));
        this.maxAgeTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.maxAgeTxt.setToolTipText("");
        this.maxAgeTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.cMaxAge = Box.createHorizontalStrut(3);

        this.minListener = new JTextFieldMinIntegerListener(this.minAgeTxt, this);
        this.minAgeTxt.addFocusListener(this.minListener);
        this.minAgeTxt.getDocument().addDocumentListener(this.minListener);

        this.maxListener = new JTextFieldMaxIntegerListener(this.maxAgeTxt, this);
        this.maxAgeTxt.addFocusListener(this.maxListener);
        this.maxAgeTxt.getDocument().addDocumentListener(this.maxListener);

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
    }

    public HumanAge(String name, int minAge, int maxAge, List<SymptomType> listSymptom, Model model) {
        this.name = "between " + minAge + " and " + maxAge;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.model = model;
        this.isNew = true;
        this.saved = false;
        this.deleted = false;

        this.nameLabel = new JLabel(name);
        this.nameLabel.setPreferredSize(new Dimension(130, 31));
        this.nameLabel.setMaximumSize(new Dimension(130, 31));
        this.nameLabel.setMinimumSize(new Dimension(130, 31));
        this.nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.nameLabel.setToolTipText("");
        this.nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.nameLabel.setBorder(BorderFactory.createEtchedBorder());

        this.cName = Box.createVerticalStrut(3);

        this.minAgeTxt = new JTextField(this.minAge + "");
        this.minAgeTxt.setPreferredSize(new Dimension(130, 31));
        this.minAgeTxt.setMaximumSize(new Dimension(130, 31));
        this.minAgeTxt.setMinimumSize(new Dimension(130, 31));
        this.minAgeTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.minAgeTxt.setToolTipText("");
        this.minAgeTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.cMinAge = Box.createHorizontalStrut(3);

        this.maxAgeTxt = new JTextField(this.maxAge + "");
        this.maxAgeTxt.setPreferredSize(new Dimension(130, 31));
        this.maxAgeTxt.setMaximumSize(new Dimension(130, 31));
        this.maxAgeTxt.setMinimumSize(new Dimension(130, 31));
        this.maxAgeTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.maxAgeTxt.setToolTipText("");
        this.maxAgeTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.cMaxAge = Box.createHorizontalStrut(3);

        this.minListener = new JTextFieldMinIntegerListener(this.minAgeTxt, this);
        this.minAgeTxt.addFocusListener(this.minListener);
        this.minAgeTxt.getDocument().addDocumentListener(this.minListener);

        this.maxListener = new JTextFieldMaxIntegerListener(this.maxAgeTxt, this);
        this.maxAgeTxt.addFocusListener(this.maxListener);
        this.maxAgeTxt.getDocument().addDocumentListener(this.maxListener);

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(listSymptom.size() * 120, 35));
        this.panel.setMinimumSize(new Dimension(listSymptom.size() * 120, 35));
        this.panel.setMaximumSize(new Dimension(listSymptom.size() * 1200, 35));
        this.panel.setBorder(BorderFactory.createEtchedBorder());
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));

        this.cPanel = Box.createVerticalStrut(3);

        this.panel.add(this.nameLabel);
        this.listSymptomAges = new ArrayList();
        for (SymptomType stn : model.getListSymptomType()) {
            SymptomAge sa = new SymptomAge(this, stn, 0, model);
            this.listSymptomAges.add(sa);
            this.panel.add(sa.getPercentageTxt());
        }

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

        this.panel.add(this.minAgeTxt);
        this.panel.add(this.maxAgeTxt);
        this.panel.add(removeButton);
    }

    public Component getcPanel() {
        return cPanel;
    }

    public void setcPanel(Component cPanel) {
        this.cPanel = cPanel;
    }

    public void removeActionPerformed() {
        this.setDeleted(true);
        setSaved(true);
        model.getMainFrame().setModelSavedButtonEnable();
        model.setSaved(false);
        for (SymptomAge sa : this.listSymptomAges) {
            sa.setDeleted(true);
        }
        model.getListHumanAge().remove(this);
        model.getListHumanAgeDeleted().add(this);
        model.getModelPanel().reinitAgePanel();
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
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

    public int getId() {
        return id;
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

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
        for (SymptomAge as : this.listSymptomAges) {
            as.setModel(model);
        }
    }

    public JTextField getMinAgeTxt() {
        return minAgeTxt;
    }

    public void setMinAgeTxt(JTextField minAgeTxt) {
        this.minAgeTxt = minAgeTxt;
    }

    public JTextField getMaxAgeTxt() {
        return maxAgeTxt;
    }

    public void setMaxAgeTxt(JTextField maxAgeTxt) {
        this.maxAgeTxt = maxAgeTxt;
    }

    /* public JTextField getPercentageTxt() {
        return percentageTxt;
    }

    public void setPercentageTxt(JTextField percentageTxt) {
        this.percentageTxt = percentageTxt;
    }*/
    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public Component getcName() {
        return cName;
    }

    public void setcName(Component cName) {
        this.cName = cName;
    }

    public Component getcMinAge() {
        return cMinAge;
    }

    public void setcMinAge(Component cMinAge) {
        this.cMinAge = cMinAge;
    }

    public Component getcMaxAge() {
        return cMaxAge;
    }

    public void setcMaxAge(Component cMaxAge) {
        this.cMaxAge = cMaxAge;
    }

    public void save() {
        System.out.println(" before delete human age min = " + minAge + " max = " + maxAge);
        if (this.isDeleted()) {
            System.out.println("delete human age min = " + minAge + " max = " + maxAge);
            HumanAgeController.INSTANCE.delete(this.id);
            return;
        }
        if (this.isIsNew()) {
            this.id = HumanAgeController.INSTANCE.insert(this);
            this.setIsNew(false);
            this.setSaved(true);
        } else {
            if (!this.isSaved()) {
                HumanAgeController.INSTANCE.update(this);
                this.setSaved(true);
            } else {
            }
        }
        for (SymptomAge as : this.listSymptomAges) {
            as.save();
            as.setIsNew(false);
            as.setSaved(true);
        }
    }

    public SymptomType monteCarlo() {
        while (true) {
            int index = MonteCarlo.uniformFixedSeed.nextInt(this.listSymptomAges.size());
            System.out.println("index");
            SymptomAge sage = (SymptomAge) this.listSymptomAges.get(index);
            Double prob = sage.getPercentage() / 100d;
            double newRandom = MonteCarlo.uniformFixedSeed.nextDouble();
            if (newRandom <= prob) {
                return sage.getSymptomType();
            }
        }
    }

    private class JTextFieldDoubleListener implements DocumentListener, FocusListener {

        private final JTextField jtextField;
        private MainFrame mainFrame;
        private String currentString;
        private final String greaterMessage = "Number can't be greater 100!";
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = false;
        private HumanAge humanAge;

        public JTextFieldDoubleListener(JTextField textField, String value, MainFrame frame, HumanAge humanAge) {
            this.jtextField = textField;
            this.currentString = value;
            this.humanAge = humanAge;
            this.mainFrame = frame;
        }

        public JTextFieldDoubleListener(JTextField textField, String value, HumanAge humanAge) {
            this.jtextField = textField;
            this.currentString = value;
            this.humanAge = humanAge;
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
                    //this.humanAge.setPercentage(Double.parseDouble(numTxt));
                    mainFrame.setModelSavedButtonEnable();
                    this.humanAge.getModel().setSaved(false);
                    this.humanAge.setSaved(false);
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
            // this.humanAge.setPercentage(Double.parseDouble(s));
            mainFrame.setModelSavedButtonEnable();
            this.humanAge.getModel().setSaved(false);
            this.humanAge.setSaved(false);

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

    private class JTextFieldMinIntegerListener implements DocumentListener, FocusListener {

        private JTextField jtextField;

        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = true;
        private final String numberHigher = "Min age can't be higher or equal to max age!";
        private HumanAge humanAge;

        public JTextFieldMinIntegerListener(JTextField textField, HumanAge humanAge) {
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
                    JOptionPane.showOptionDialog(model.getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(minAge + "");
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
                insertZero(minAge + "");
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
            String numtxt = this.jtextField.getText();
            if (numtxt.equals("")) {
                insert = true;
                insertZero(minAge + "");
                return;
            } else {
                insert = true;
            }
            int d = Integer.parseInt(numtxt);
            if (d >= maxAge) {
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(model.getMainFrame(), this.numberHigher, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(minAge + "");
            } else {
                minAge = d;
                name = "between " + minAge + " and " + maxAge;
                nameLabel.setText(name);
                this.humanAge.setSaved(false);
            }
        }

    }

    private class JTextFieldMaxIntegerListener implements DocumentListener, FocusListener {

        private JTextField jtextField;
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = true;
        private final String numberLower = "Max age can't be lower or equal to min age!";
        private HumanAge humanAge;

        public JTextFieldMaxIntegerListener(JTextField textField, HumanAge humanAge) {
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
                    JOptionPane.showOptionDialog(model.getMainFrame(), this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(maxAge + "");
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
                insertZero(maxAge + "");
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
                insertZero(maxAge + "");
                return;
            } else {
                insert = true;
            }
            int d = Integer.parseInt(numTxt);
            if (d <= minAge) {
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(model.getMainFrame(), this.numberLower, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(maxAge + "");
            } else {
                maxAge = d;
                name = "between " + minAge + " and " + maxAge;
                nameLabel.setText(name);
                this.humanAge.setSaved(false);
            }

        }

    }
}
