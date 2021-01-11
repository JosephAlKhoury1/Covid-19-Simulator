package models.model;

import controller.controllers.PauseTimeController;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import resources.icon.Icons;
import resources.Messages.Messages;

public class PauseTime {

    private int id;
    private int day;
    private int modelId;

    private JTextField daysTxt;
    private JPanel panel;
    private JButton removeButton;
    private Model model;
    private boolean hasBeenChecked = false;

    private boolean isNew, saved, deleted;

    public PauseTime(int id, int days) {
        this.id = id;
        this.day = days;
        this.isNew = false;
        this.saved = true;
        this.deleted = false;

        this.daysTxt = new JTextField(this.day + "");
        this.daysTxt.setPreferredSize(new Dimension(200, 31));
        this.daysTxt.setMaximumSize(new Dimension(200, 31));
        this.daysTxt.setMinimumSize(new Dimension(200, 31));
        this.daysTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.daysTxt.setToolTipText("");
        this.daysTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(315, 35));
        this.panel.setMinimumSize(new Dimension(315, 35));
        this.panel.setMaximumSize(new Dimension(315, 35));
        this.panel.setBorder(BorderFactory.createEtchedBorder());
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));

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

        JTextFieldDayListener dayListener = new JTextFieldDayListener(daysTxt, this);
        this.daysTxt.getDocument().addDocumentListener(dayListener);
        this.daysTxt.addFocusListener(dayListener);

        this.panel.add(this.daysTxt);
        this.panel.add(this.removeButton);
    }

    public PauseTime(int days, Model model) {
        this.day = days;
        this.model = model;
        this.isNew = true;
        this.saved = true;
        this.deleted = false;

        this.daysTxt = new JTextField(this.day + "");
        this.daysTxt.setPreferredSize(new Dimension(200, 31));
        this.daysTxt.setMaximumSize(new Dimension(200, 31));
        this.daysTxt.setMinimumSize(new Dimension(200, 31));
        this.daysTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.daysTxt.setToolTipText("");
        this.daysTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(315, 35));
        this.panel.setMinimumSize(new Dimension(315, 35));
        this.panel.setMaximumSize(new Dimension(315, 35));
        this.panel.setBorder(BorderFactory.createEtchedBorder());
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));

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

        JTextFieldDayListener dayListener = new JTextFieldDayListener(daysTxt, this);
        this.daysTxt.getDocument().addDocumentListener(dayListener);
        this.daysTxt.addFocusListener(dayListener);

        this.panel.add(this.daysTxt);
        this.panel.add(this.removeButton);
    }

    public void setEnable() {
        this.daysTxt.setEnabled(true);
        this.removeButton.setEnabled(true);
    }

    public void setDisable() {
        this.daysTxt.setEnabled(false);
        this.removeButton.setEnabled(false);
    }

    private void removeActionPerformed() {
        int reply = JOptionPane.showOptionDialog(this.model.getMainFrame(), Messages.deletePauseTimeWarning(), "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, Icons.WARNINGICON, null, null);

        if (reply == JOptionPane.NO_OPTION || reply == JOptionPane.CLOSED_OPTION) {
            return;
        }
        this.setDeleted(true);
        this.model.getListPauseTime().remove(this);
        this.model.getListPauseTimeDeleted().add(this);
        this.model.getModelPanel().reinitPauseTimePanel();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDays(int days) {
        this.day = days;
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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean isHasBeenChecked() {
        return hasBeenChecked;
    }

    public void setHasBeenChecked(boolean hasBeenChecked) {
        this.hasBeenChecked = hasBeenChecked;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getId() {
        return id;
    }

    public int getDays() {
        return day;
    }

    public int getModelId() {
        return modelId;
    }

    public JTextField getDaysTxt() {
        return daysTxt;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public void save() {
        if (this.isDeleted()) {
            if (!this.isNew) {
                PauseTimeController.INSTANCE.delete(id);
            }
        } else {
            if (this.isNew) {
                PauseTimeController.INSTANCE.insertModel(this);
                this.setIsNew(false);
                this.setSaved(true);
            } else if (!this.isSaved()) {
                PauseTimeController.INSTANCE.updateModel(this);
            }
        }
    }

    private class JTextFieldDayListener implements DocumentListener, FocusListener {

        private JTextField jtextField;
        private String currentString;
        private boolean insert = false;
        private PauseTime pauseTime;

        public JTextFieldDayListener(JTextField textField, PauseTime s) {
            this.jtextField = textField;
            this.currentString = s.getDays() + "";
            this.pauseTime = s;
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
                    JOptionPane.showOptionDialog(this.pauseTime.getModel().getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
                return;
            }
            try {
                int d = Integer.parseInt(numTxt);
                if (!insert) {
                    this.pauseTime.setDays(d);
                    this.pauseTime.setSaved(false);
                    this.pauseTime.getModel().setSaved(false);
                    pauseTime.getModel().getMainFrame().setModelSavedButtonEnable();
                    this.currentString = numTxt;
                }

            } catch (NumberFormatException ex) {
                insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.pauseTime.getModel().getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
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

            this.pauseTime.setDays(Integer.parseInt(numTxt));
            this.pauseTime.setSaved(false);
            this.pauseTime.getModel().setSaved(false);
            this.currentString = numTxt;
            this.pauseTime.getModel().getMainFrame().setModelSavedButtonEnable();

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
