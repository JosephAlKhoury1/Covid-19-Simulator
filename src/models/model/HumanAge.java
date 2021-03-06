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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import Properties.MonteCarlo;
import resources.Colors.Colors;
import resources.icon.Icons;
import resources.Messages.Messages;

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
    private List<SymptomAge> listSymptomAgesDeleted;

    private boolean minAgeValid = false, maxAgeValid = false;

    public HumanAge(int id, String name, int minAge, int maxAge) {
        this.id = id;
        this.name = name;
        this.minAge = minAge;
        this.maxAge = maxAge;

        if (minAge != -1) {
            this.minAgeValid = true;
        } else {
            this.minAgeValid = false;
            this.name = "Invalid";
        }

        if (maxAge != -1) {
            this.maxAgeValid = true;
        } else {
            this.maxAgeValid = false;
            this.name = "Invalid";
        }

        this.isNew = false;
        this.saved = true;
        this.deleted = false;

        this.listSymptomAgesDeleted = new ArrayList();

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
        this.minAgeTxt.setBackground(new Color(255, 204, 51));

        this.cMinAge = Box.createHorizontalStrut(3);

        this.maxAgeTxt = new JTextField(this.maxAge + "");
        this.maxAgeTxt.setPreferredSize(new Dimension(130, 31));
        this.maxAgeTxt.setMaximumSize(new Dimension(130, 31));
        this.maxAgeTxt.setMinimumSize(new Dimension(130, 31));
        this.maxAgeTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.maxAgeTxt.setToolTipText("");
        this.maxAgeTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.maxAgeTxt.setBackground(new Color(255, 204, 51));

        this.cMaxAge = Box.createHorizontalStrut(3);

        this.minListener = new JTextFieldMinIntegerListener(this.minAgeTxt, this);
        this.minAgeTxt.addFocusListener(this.minListener);
        this.minAgeTxt.getDocument().addDocumentListener(this.minListener);

        this.maxListener = new JTextFieldMaxIntegerListener(this.maxAgeTxt, this);
        this.maxAgeTxt.addFocusListener(this.maxListener);
        this.maxAgeTxt.getDocument().addDocumentListener(this.maxListener);

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
    }

    public HumanAge(String name, int minAge, int maxAge, List<SymptomType> listSymptom, Model model) {
        this.name = "Between " + minAge + " and " + maxAge;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.model = model;
        if (minAge != -1) {
            this.minAgeValid = true;
        } else {
            this.minAgeValid = false;
            this.name = "Invalid";
        }

        if (maxAge != -1) {
            this.maxAgeValid = true;
        } else {
            this.maxAgeValid = false;
            this.name = "Invalid";
        }

        this.isNew = true;
        this.saved = false;
        this.deleted = false;

        this.listSymptomAgesDeleted = new ArrayList();

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
        this.minAgeTxt.setBackground(new Color(255, 204, 51));

        this.cMinAge = Box.createHorizontalStrut(3);

        this.maxAgeTxt = new JTextField(this.maxAge + "");
        this.maxAgeTxt.setPreferredSize(new Dimension(130, 31));
        this.maxAgeTxt.setMaximumSize(new Dimension(130, 31));
        this.maxAgeTxt.setMinimumSize(new Dimension(130, 31));
        this.maxAgeTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.maxAgeTxt.setToolTipText("");
        this.maxAgeTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.maxAgeTxt.setBackground(new Color(255, 204, 51));

        this.cMaxAge = Box.createHorizontalStrut(3);

        this.minListener = new JTextFieldMinIntegerListener(this.minAgeTxt, this);
        this.minAgeTxt.addFocusListener(this.minListener);
        this.minAgeTxt.getDocument().addDocumentListener(this.minListener);

        this.maxListener = new JTextFieldMaxIntegerListener(this.maxAgeTxt, this);
        this.maxAgeTxt.addFocusListener(this.maxListener);
        this.maxAgeTxt.getDocument().addDocumentListener(this.maxListener);

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(listSymptom.size() * 120 + 460, 35));
        this.panel.setMinimumSize(new Dimension(listSymptom.size() * 120 + 460, 35));
        this.panel.setMaximumSize(new Dimension(listSymptom.size() * 1200, 35));
        this.panel.setBorder(BorderFactory.createEtchedBorder());
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));

        this.cPanel = Box.createVerticalStrut(3);

        this.panel.add(this.nameLabel);
        this.panel.add(this.minAgeTxt);
        this.panel.add(this.maxAgeTxt);

        this.listSymptomAges = new ArrayList();
        double sum = 0;
        for (SymptomType stn : model.getListSymptomType()) {
            SymptomAge sa = new SymptomAge(this, stn, 0, model);
            this.listSymptomAges.add(sa);
            this.panel.add(sa.getPercentageTxt());
            sum += sa.getPercentage();
        }

        if (sum != 100) {
            this.nameLabel.setBackground(Colors.WARNINGCOLOR);
            this.nameLabel.setIcon(Icons.WARNINGICON);
            this.nameLabel.setToolTipText(Messages.AGEPERCENTAGEWARNING);
            for (SymptomAge sa : this.listSymptomAges) {
                sa.getPercentageTxt().setBackground(Colors.WARNINGCOLOR);
            }
        } else {
            this.nameLabel.setBackground(Colors.WHITE);
            this.nameLabel.setIcon(null);
            this.nameLabel.setToolTipText(null);
            for (SymptomAge sa : this.listSymptomAges) {
                sa.getPercentageTxt().setBackground(Colors.WHITE);
            }
        }
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
        this.panel.add(removeButton);
        removeButton.setIcon(Icons.DELETEICON);
        checkValid();
    }

    public HumanAge(HumanAge old, Model model) {
        this.name = "Between " + old.minAge + " and " + old.maxAge;
        this.minAge = old.minAge;
        this.maxAge = old.maxAge;
        this.model = model;
        if (minAge != -1) {
            this.minAgeValid = true;
        } else {
            this.minAgeValid = false;
            this.name = "Invalid";
        }

        if (maxAge != -1) {
            this.maxAgeValid = true;
        } else {
            this.maxAgeValid = false;
            this.name = "Invalid";
        }

        this.isNew = true;
        this.saved = false;
        this.deleted = false;

        this.listSymptomAgesDeleted = new ArrayList();

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
        this.minAgeTxt.setBackground(new Color(255, 204, 51));

        this.cMinAge = Box.createHorizontalStrut(3);

        this.maxAgeTxt = new JTextField(this.maxAge + "");
        this.maxAgeTxt.setPreferredSize(new Dimension(130, 31));
        this.maxAgeTxt.setMaximumSize(new Dimension(130, 31));
        this.maxAgeTxt.setMinimumSize(new Dimension(130, 31));
        this.maxAgeTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.maxAgeTxt.setToolTipText("");
        this.maxAgeTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.maxAgeTxt.setBackground(new Color(255, 204, 51));

        this.cMaxAge = Box.createHorizontalStrut(3);

        this.minListener = new JTextFieldMinIntegerListener(this.minAgeTxt, this);
        this.minAgeTxt.addFocusListener(this.minListener);
        this.minAgeTxt.getDocument().addDocumentListener(this.minListener);

        this.maxListener = new JTextFieldMaxIntegerListener(this.maxAgeTxt, this);
        this.maxAgeTxt.addFocusListener(this.maxListener);
        this.maxAgeTxt.getDocument().addDocumentListener(this.maxListener);

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(model.getListSymptomType().size() * 120 + 460, 35));
        this.panel.setMinimumSize(new Dimension(model.getListSymptomType().size() * 120 + 460, 35));
        this.panel.setBorder(BorderFactory.createEtchedBorder());
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));

        this.cPanel = Box.createVerticalStrut(3);

        this.panel.add(this.nameLabel);
        this.panel.add(this.minAgeTxt);
        this.panel.add(this.maxAgeTxt);

        this.listSymptomAges = new ArrayList();
        double sum = 0;
        for (SymptomType stn : model.getListSymptomType()) {
            double percentage = 0.0;
            for (SymptomAge sa : old.getListSymptomAges()) {
                if (sa.getHumanAge().getMinAge() == this.minAge && sa.getHumanAge().getMaxAge() == this.maxAge && sa.getSymptomType().getName().equals(stn.getName())) {
                    percentage = sa.getPercentage();
                    break;
                }
            }
            SymptomAge sa = new SymptomAge(this, stn, percentage, model);
            this.listSymptomAges.add(sa);
            this.panel.add(sa.getPercentageTxt());
            sum += sa.getPercentage();
        }

        if (sum != 100) {
            this.nameLabel.setBackground(Colors.WARNINGCOLOR);
            this.nameLabel.setIcon(Icons.WARNINGICON);
            this.nameLabel.setToolTipText(Messages.AGEPERCENTAGEWARNING);
            for (SymptomAge sa : this.listSymptomAges) {
                sa.getPercentageTxt().setBackground(Colors.WARNINGCOLOR);
            }
        } else {
            this.nameLabel.setBackground(Colors.WHITE);
            this.nameLabel.setIcon(null);
            this.nameLabel.setToolTipText(null);
            for (SymptomAge sa : this.listSymptomAges) {
                sa.getPercentageTxt().setBackground(Colors.WHITE);
            }
        }
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
        this.panel.add(removeButton);
        removeButton.setIcon(Icons.DELETEICON);
        checkValid();
    }

    public Component getcPanel() {
        return cPanel;
    }

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
        this.panel.setPreferredSize(new Dimension(listSymptomAges.size() * 120 + 460, 35));
        this.panel.setMinimumSize(new Dimension(listSymptomAges.size() * 120 + 460, 35));
        this.panel.setMaximumSize(new Dimension(listSymptomAges.size() * 1200, 35));
        this.panel.setBorder(BorderFactory.createEtchedBorder());
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));
        this.cPanel = Box.createVerticalStrut(3);
        this.panel.add(this.nameLabel);
        this.panel.add(this.minAgeTxt);
        this.panel.add(this.maxAgeTxt);

        double sum = 0;
        for (SymptomAge sta : listSymptomAges) {
            this.panel.add(sta.getPercentageTxt());
            sum += sta.getPercentage();
        }
        if (sum != 100) {
            this.nameLabel.setBackground(Colors.WARNINGCOLOR);
            this.nameLabel.setIcon(Icons.WARNINGICON);
            this.nameLabel.setToolTipText(Messages.AGEPERCENTAGEWARNING);
            for (SymptomAge sa : this.listSymptomAges) {
                sa.getPercentageTxt().setBackground(Colors.WARNINGCOLOR);
            }
        } else {
            this.nameLabel.setBackground(Colors.WHITE);
            this.nameLabel.setIcon(null);
            this.nameLabel.setToolTipText(null);
            for (SymptomAge sa : this.listSymptomAges) {
                sa.getPercentageTxt().setBackground(Colors.WHITE);
            }
        }
        this.panel.add(removeButton);
        checkValid();
    }

    public void setcPanel(Component cPanel) {
        this.cPanel = cPanel;
    }

    public void removeActionPerformed() {

        int index = JOptionPane.showOptionDialog(this.model.getMainFrame(), Messages.DELETEHUMANAGE, "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, Icons.WARNINGICON, null, null);

        if (index == JOptionPane.NO_OPTION || index == JOptionPane.CLOSED_OPTION) {
            return;
        }
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

    public boolean isMinAgeValid() {
        return minAgeValid;
    }

    public void setMinAgeValid(boolean minAgeValid) {
        this.minAgeValid = minAgeValid;
    }

    public boolean isMaxAgeValid() {
        return maxAgeValid;
    }

    public void setMaxAgeValid(boolean maxAgeValid) {
        this.maxAgeValid = maxAgeValid;
    }

    public void setcMaxAge(Component cMaxAge) {
        this.cMaxAge = cMaxAge;
    }

    public void save() {
        if (this.isDeleted()) {
            if (this.isNew) {
                return;
            }
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

        for (SymptomAge sa : this.listSymptomAgesDeleted) {
            sa.save();
        }
    }

    public SymptomType monteCarlo() {
        Map<SymptomAge, Double> newMap = new HashMap();
        List<SymptomAge> newList = new ArrayList();
        double sumPercentage = 0;
        boolean allZero = true;

        if (listSymptomAges.isEmpty()) {
            return null;
        }
        for (SymptomAge sa : this.listSymptomAges) {
            sumPercentage += sa.getPercentage();
            if (sa.getPercentage() > 0) {
                allZero = false;
            }
        }
        if (allZero) {
            double newPercentage = 100 / listSymptomAges.size();
            for (SymptomAge sa : this.listSymptomAges) {
                newMap.put(sa, newPercentage);
                newList.add(sa);
            }
        } else {
            for (SymptomAge sa : this.listSymptomAges) {
                if (sa.getPercentage() != 0) {
                    double newPerc = sa.getPercentage() * 100 / sumPercentage;
                    newMap.put(sa, newPerc);
                    newList.add(sa);
                }
            }
        }

        while (true) {
            int index = MonteCarlo.uniformFixedSeed.nextInt(newMap.size());
            SymptomAge sage = (SymptomAge) newList.get(index);
            Double prob = newMap.get(sage) / 100d;
            double newRandom = MonteCarlo.uniformFixedSeed.nextDouble();
            if (newRandom <= prob) {
                return sage.getSymptomType();
            }
        }
    }

    public void addSymptomType(SymptomType st) {
        this.panel.setPreferredSize(new Dimension(listSymptomAges.size() * 120 + 500, 35));
        this.panel.setMinimumSize(new Dimension(listSymptomAges.size() * 120 + 500, 35));
        this.panel.setMaximumSize(new Dimension(listSymptomAges.size() * 1200, 35));
        this.panel.remove(this.removeButton);
        SymptomAge sa = new SymptomAge(this, st, 0.0, model);
        this.listSymptomAges.add(sa);
        this.panel.add(sa.getPercentageTxt());
        this.panel.add(this.removeButton);
        this.panel.repaint();
    }

    private void checkValid() {
        if (!this.minAgeValid || !this.maxAgeValid) {
            this.nameLabel.setIcon(Icons.WARNINGICON);
            this.nameLabel.setToolTipText(Messages.ThisAgeIsInvalid());
            nameLabel.setText("Invalid");

            for (SymptomAge lg : this.listSymptomAges) {
                lg.getPercentageTxt().setEnabled(false);
            }
        } else {
            this.nameLabel.setIcon(null);
            this.nameLabel.setToolTipText(null);
            nameLabel.setText("Between " + this.minAge + " and " + this.maxAge);
            for (SymptomAge lg : this.listSymptomAges) {
                lg.getPercentageTxt().setEnabled(true);
            }
        }
    }

    public void removeSymptomType(SymptomType st) {
        SymptomAge tmp = null;
        double newPer = 0;
        for (SymptomAge sa : this.listSymptomAges) {
            if (sa.getSymptomType() == st) {
                tmp = sa;
            } else {
                newPer += sa.getPercentage();
            }
        }

        tmp.setDeleted(true);
        this.listSymptomAgesDeleted.add(tmp);
        this.listSymptomAges.remove(tmp);
        this.panel.remove(tmp.getPercentageTxt());
        if (newPer != 100) {
            getNameLabel().setBackground(Colors.WARNINGCOLOR);
            getNameLabel().setIcon(Icons.WARNINGICON);
            getNameLabel().setToolTipText(Messages.AGEPERCENTAGEWARNING);
            for (SymptomAge sa : getListSymptomAges()) {
                sa.getPercentageTxt().setBackground(Colors.WARNINGCOLOR);
            }
        } else {
            getNameLabel().setBackground(Colors.WHITE);
            getNameLabel().setIcon(null);
            getNameLabel().setToolTipText(null);
            for (SymptomAge sa : getListSymptomAges()) {
                sa.getPercentageTxt().setBackground(Colors.WHITE);
            }
        }
        this.panel.repaint();
    }

    private class JTextFieldMinIntegerListener implements DocumentListener, FocusListener {

        private JTextField jtextField;

        private boolean insert = true;
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
            if ("-1".equals(numTxt) || "-".equals(numTxt)) {
                if (!this.humanAge.isMinAgeValid()) {
                    return;
                }
            }
            if (numTxt.contains("f") || numTxt.contains("d")) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(model.getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(minAge + "");
                return;
            }
            try {
                Integer.parseInt(numTxt);
            } catch (NumberFormatException ex) {
                insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(model.getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(minAge + "");
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            String numTxt = this.jtextField.getText();
            if ("-1".equals(numTxt) || "-".equals(numTxt)) {
                if (!this.humanAge.isMinAgeValid()) {
                    return;
                }
            }
            if (insert) {
                return;
            }
            if (numTxt.length() <= 0 || numTxt.equals("")) {
                return;
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
            String numtxt = this.jtextField.getText();
            if (numtxt.equals("")) {
                insert = true;
                insertZero(minAge + "");
                return;
            } else if ("-1".equals(numtxt) || "-".equals(numtxt)) {
                insert = true;
                if (!this.humanAge.isMinAgeValid()) {
                    insertZero(minAge + "");
                    return;
                }
            } else {
                insert = true;
            }
            int d = Integer.parseInt(numtxt);
            if (d >= maxAge && this.humanAge.isMaxAgeValid()) {
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(model.getMainFrame(), Messages.minAgeCantBeHigherThanMaxAge(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(minAge + "");
            } else {
                boolean isOk = true;
                for (HumanAge ha : model.getListHumanAge()) {
                    if (ha.isMinAgeValid() && ha.isMaxAgeValid()) {
                        if (this.humanAge != ha && ha.getMinAge() <= d && ha.getMaxAge() >= d) {
                            isOk = false;
                            break;
                        }
                    }
                }
                if (isOk) {
                    minAge = d;
                    this.humanAge.checkValid();
                    this.humanAge.setMinAgeValid(true);
                    model.getMainFrame().setModelSavedButtonEnable();
                    this.humanAge.setSaved(false);
                } else {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(model.getMainFrame(), Messages.ThisAgeIsContainsInOtherAge(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(minAge + "");
                }
            }
        }

    }

    private class JTextFieldMaxIntegerListener implements DocumentListener, FocusListener {

        private JTextField jtextField;
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
            if (numTxt.equals("-1") || numTxt.equals("-")) {
                if (!this.humanAge.isMaxAgeValid()) {
                    return;
                }
            }
            if (numTxt.contains("f") || numTxt.contains("d")) {
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(model.getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(maxAge + "");
                return;
            }
            try {
                Integer.parseInt(numTxt);
            } catch (NumberFormatException ex) {
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(model.getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(maxAge + "");
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            String numTxt = this.jtextField.getText();
            if (numTxt.equals("-1") || numTxt.equals("-")) {
                if (!this.humanAge.isMaxAgeValid()) {
                    return;
                }
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }

        @Override
        public void focusGained(FocusEvent e) {
        }

        @Override
        public void focusLost(FocusEvent e) {
            String numTxt = this.jtextField.getText();
            numTxt = numTxt.trim();
            if (numTxt.equals("")) {
                insertZero(maxAge + "");
                return;
            } else if (numTxt.equals("-1") || numTxt.equals("-")) {
                if (!this.humanAge.isMaxAgeValid()) {
                    insertZero(maxAge + "");
                    return;
                }
            }
            int d = Integer.parseInt(numTxt);
            if (d <= minAge && this.humanAge.isMinAgeValid()) {
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(model.getMainFrame(), Messages.maxAgeCantBeLowerThanMinAge(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(maxAge + "");
            } else {
                boolean isOk = true;
                for (HumanAge ha : model.getListHumanAge()) {
                    if (ha.isMinAgeValid() && ha.isMaxAgeValid()) {
                        if (this.humanAge != ha && ha.getMinAge() <= d && ha.getMaxAge() >= d) {
                            isOk = false;
                            break;
                        }
                    }
                }
                if (isOk) {
                    maxAge = d;
                    this.humanAge.setMaxAgeValid(true);
                    model.getMainFrame().setModelSavedButtonEnable();
                    this.humanAge.setSaved(false);
                    this.humanAge.checkValid();
                } else {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(model.getMainFrame(), Messages.ThisAgeIsContainsInOtherAge(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(maxAge + "");
                }
            }

        }

    }
}
