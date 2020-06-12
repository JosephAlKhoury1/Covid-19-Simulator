package models.model;

import controller.controllers.HumanAgeController;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import views1.MainFrame;

public class HumanAge {

    private int id;
    private String name;
    private int minAge;
    private int maxAge;
    private double percentage;
    private Model model;
    private SymptomType symptomeType;

    private JTextField minAgeTxt, maxAgeTxt, percentageTxt;
    private JLabel nameLabel;
    private Component cName, cMinAge, cMaxAge, cPercentage;

    private boolean isNew, saved, deleted;

    private JTextFieldDoubleListener doubleListener;
    private JTextFieldMinIntegerListener minListener;
    private JTextFieldMaxIntegerListener maxListener;

    public HumanAge(int id, String name, int minAge, int maxAge) {
        this.id = id;
        this.name = name;
        this.minAge = minAge;
        this.maxAge = maxAge;

        this.isNew = false;
        this.saved = true;
        this.deleted = false;

        this.nameLabel = new JLabel(name);
        this.nameLabel.setPreferredSize(new Dimension(120, 18));
        this.nameLabel.setMaximumSize(new Dimension(120, 18));
        this.nameLabel.setMinimumSize(new Dimension(120, 18));
        this.nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.nameLabel.setToolTipText("");
        this.nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.cName = Box.createHorizontalStrut(3);

        this.minAgeTxt = new JTextField(this.minAge + "");
        this.minAgeTxt.setPreferredSize(new Dimension(120, 31));
        this.minAgeTxt.setMaximumSize(new Dimension(120, 31));
        this.minAgeTxt.setMinimumSize(new Dimension(120, 31));
        this.minAgeTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.minAgeTxt.setToolTipText("");
        this.minAgeTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.cMinAge = Box.createHorizontalStrut(3);

        this.maxAgeTxt = new JTextField(this.maxAge + "");
        this.maxAgeTxt.setPreferredSize(new Dimension(120, 31));
        this.maxAgeTxt.setMaximumSize(new Dimension(120, 31));
        this.maxAgeTxt.setMinimumSize(new Dimension(120, 31));
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
    }

    public HumanAge(String name, int minAge, int maxAge, Model model) {
        this.name = name;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.model = model;

        this.isNew = true;
        this.saved = false;
        this.deleted = false;

        this.nameLabel = new JLabel(name);
        this.nameLabel.setPreferredSize(new Dimension(120, 18));
        this.nameLabel.setMaximumSize(new Dimension(120, 18));
        this.nameLabel.setMinimumSize(new Dimension(120, 18));
        this.nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.nameLabel.setToolTipText("");
        this.nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.cName = Box.createHorizontalStrut(3);

        this.minAgeTxt = new JTextField(this.minAge + "");
        this.minAgeTxt.setPreferredSize(new Dimension(120, 31));
        this.minAgeTxt.setMaximumSize(new Dimension(120, 31));
        this.minAgeTxt.setMinimumSize(new Dimension(120, 31));
        this.minAgeTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.minAgeTxt.setToolTipText("");
        this.minAgeTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.cMinAge = Box.createHorizontalStrut(3);

        this.maxAgeTxt = new JTextField(this.maxAge + "");
        this.maxAgeTxt.setPreferredSize(new Dimension(120, 31));
        this.maxAgeTxt.setMaximumSize(new Dimension(120, 31));
        this.maxAgeTxt.setMinimumSize(new Dimension(120, 31));
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
    }

    public HumanAge(int id, String name, double percentage, int minAge, int maxAge) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
        this.minAge = minAge;
        this.maxAge = maxAge;

        this.isNew = false;
        this.saved = true;
        this.deleted = false;

        this.percentageTxt = new JTextField(percentage + "");
        this.percentageTxt.setPreferredSize(new Dimension(120, 31));
        this.percentageTxt.setMaximumSize(new Dimension(120, 31));
        this.percentageTxt.setMinimumSize(new Dimension(120, 31));
        this.percentageTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.percentageTxt.setToolTipText("");
        this.percentageTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.doubleListener = new JTextFieldDoubleListener(this.percentageTxt, this.percentage + "", this);
        this.percentageTxt.addFocusListener(this.doubleListener);
        this.percentageTxt.getDocument().addDocumentListener(this.doubleListener);

        this.cPercentage = Box.createHorizontalStrut(3);

    }

    public HumanAge(String name, double percentage, int minAge, int maxAge, SymptomType st, Model m) {
        this.name = name;
        this.percentage = percentage;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.symptomeType = st;
        this.model = m;

        this.isNew = true;
        this.saved = false;
        this.deleted = false;

        this.percentageTxt = new JTextField(percentage + "");
        this.percentageTxt.setPreferredSize(new Dimension(120, 31));
        this.percentageTxt.setMaximumSize(new Dimension(120, 31));
        this.percentageTxt.setMinimumSize(new Dimension(120, 31));
        this.percentageTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.percentageTxt.setToolTipText("");
        this.percentageTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.doubleListener = new JTextFieldDoubleListener(this.percentageTxt, this.percentage + "", m.getMainFrame(), this);
        this.percentageTxt.addFocusListener(this.doubleListener);
        this.percentageTxt.getDocument().addDocumentListener(this.doubleListener);

        this.cPercentage = Box.createHorizontalStrut(3);

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
        if (this.doubleListener != null) {
            this.doubleListener.setMainFrame(model.getMainFrame());
        }

    }

    public SymptomType getSymptomeType() {
        return symptomeType;
    }

    public void setSymptomeType(SymptomType symptomeType) {
        this.symptomeType = symptomeType;
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

    public JTextField getPercentageTxt() {
        return percentageTxt;
    }

    public void setPercentageTxt(JTextField percentageTxt) {
        this.percentageTxt = percentageTxt;
    }

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
        if (this.isDeleted()) {
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
    }

    public void save1() {
        if (this.isDeleted()) {
            HumanAgeController.INSTANCE.deleteModel(this.id);
            return;
        }
        if (this.isIsNew()) {
            this.id = HumanAgeController.INSTANCE.insertModel(this);
            this.setIsNew(false);
            this.setSaved(true);
        } else {
            if (!this.isSaved()) {
                HumanAgeController.INSTANCE.updateModel(this);
                this.setSaved(true);
            } else {

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
                    this.humanAge.setPercentage(Double.parseDouble(numTxt));
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
            this.humanAge.setPercentage(Double.parseDouble(s));
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
                this.humanAge.setSaved(false);
            }

        }

    }

}
