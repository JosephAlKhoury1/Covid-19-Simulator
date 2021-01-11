package models.client;

import controller.controllers.HousePopulationController;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import resources.icon.Icons;
import resources.Messages.Messages;

public class HousePopulation extends javax.swing.JPanel {

    private int id;
    private int number;
    private double percentage;
    private City city;

    private boolean isNew, saved, deleted;
    private int[] numTab = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    private JTextFieldDoubleListener listener;
    private boolean first = true;

    private Component comp;

    public HousePopulation(int id, int number, double percentage) {
        this.id = id;
        this.number = number;
        this.percentage = percentage;

        initComponents();
        ((JLabel) this.numBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        for (Integer i : numTab) {
            this.numBox.addItem(i);
            this.first = true;
        }
        this.numBox.setSelectedIndex(this.number);
        this.percentageTxt.setText(this.percentage + "");
        this.isNew = false;
        this.saved = true;
        this.deleted = false;
        this.listener = new JTextFieldDoubleListener(this.percentageTxt, this.percentage + "", this);
        this.percentageTxt.addFocusListener(listener);
        this.percentageTxt.getDocument().addDocumentListener(listener);
    }

    public HousePopulation(City city) {
        List<Integer> list = new ArrayList();
        for (HousePopulation hp : city.getListHousePopulations()) {
            list.add(hp.getNumber());
        }

        for (int i = 0; i < 21; i++) {
            if (!list.contains(i)) {
                this.number = i;
                break;
            }
        }
        this.percentage = 0;
        this.city = city;
        initComponents();
        ((JLabel) this.numBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        for (Integer i : numTab) {
            this.numBox.addItem(i);
            this.first = true;
        }
        this.numBox.setSelectedIndex(this.number);
        this.percentageTxt.setText(this.percentage + "");
        this.isNew = true;
        this.saved = false;
        this.deleted = false;
        listener = new JTextFieldDoubleListener(this.percentageTxt, this.percentage + "", this);
        this.percentageTxt.addFocusListener(listener);
        this.percentageTxt.getDocument().addDocumentListener(listener);
    }

    public HousePopulation(int number, double per, City city) {
        this.number = number;
        this.percentage = per;
        this.city = city;
        initComponents();
        ((JLabel) this.numBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        for (Integer i : numTab) {
            this.numBox.addItem(i);
            this.first = true;
        }

        this.numBox.setSelectedIndex(this.number);
        this.percentageTxt.setText(this.percentage + "");
        this.isNew = true;
        this.saved = false;
        this.deleted = false;
        listener = new JTextFieldDoubleListener(this.percentageTxt, this.percentage + "", this);
        this.percentageTxt.addFocusListener(listener);
        this.percentageTxt.getDocument().addDocumentListener(listener);
    }

    public Component getComp() {
        return comp;
    }

    public void setComp(Component comp) {
        this.comp = comp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        numBox = new javax.swing.JComboBox<>();
        percentageTxt = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setMaximumSize(new java.awt.Dimension(300, 35));
        setMinimumSize(new java.awt.Dimension(300, 35));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(300, 35));

        jPanel1.setMaximumSize(new java.awt.Dimension(294, 35));
        jPanel1.setMinimumSize(new java.awt.Dimension(294, 35));
        jPanel1.setPreferredSize(new java.awt.Dimension(294, 31));

        numBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        numBox.setMaximumSize(new java.awt.Dimension(110, 31));
        numBox.setMinimumSize(new java.awt.Dimension(110, 31));
        numBox.setPreferredSize(new java.awt.Dimension(110, 31));
        numBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numBoxActionPerformed(evt);
            }
        });

        percentageTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        percentageTxt.setText("0.0");
        percentageTxt.setToolTipText("");
        percentageTxt.setMaximumSize(new java.awt.Dimension(80, 31));
        percentageTxt.setMinimumSize(new java.awt.Dimension(80, 31));
        percentageTxt.setPreferredSize(new java.awt.Dimension(110, 31));

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/delete icon.jpg"))); // NOI18N
        deleteButton.setToolTipText("");
        deleteButton.setMaximumSize(new java.awt.Dimension(37, 31));
        deleteButton.setMinimumSize(new java.awt.Dimension(37, 31));
        deleteButton.setPreferredSize(new java.awt.Dimension(37, 31));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(numBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(percentageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(numBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(percentageTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void numBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numBoxActionPerformed
        if (!this.first) {
            this.number = (int) this.numBox.getSelectedItem();
            this.city.setIsSaved(false);
            this.city.getMainFrame().setCitySavedButtonEnable();
            this.setSaved(false);
        }
        this.first = false;
    }//GEN-LAST:event_numBoxActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int index = JOptionPane.showOptionDialog(this.city.getMainFrame(), Messages.deleteHousePopulation(), "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, Icons.WARNINGICON, null, null);

        if (index == JOptionPane.NO_OPTION || index == JOptionPane.CLOSED_OPTION) {
            return;
        }
        
        this.city.removeHousePopulation(this);
        this.city.checkHousePopulationPercentage();
        this.city.getMainFrame().getCurrentCityPanel().removeHousePopulation(this);
        this.setDeleted(true);
        this.setSaved(false);
        this.city.setIsSaved(false);
    }//GEN-LAST:event_deleteButtonActionPerformed

    public void save() {
        if (this.isDeleted()) {
            if (!this.isNew) {
                HousePopulationController.INSTANCE.delete(this.id);
            }
            return;
        }
        if (this.isNew) {
            this.id = HousePopulationController.INSTANCE.insert(this);
            this.setIsNew(false);
            this.setSaved(true);
        } else {
            if (!this.isSaved()) {
                HousePopulationController.INSTANCE.update(this);
                this.setSaved(true);
            } else {
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<Integer> numBox;
    public javax.swing.JTextField percentageTxt;
    // End of variables declaration//GEN-END:variables
 private class JTextFieldDoubleListener implements DocumentListener, FocusListener {

        private final JTextField jtextField;
        private String currentString;
        private boolean insert = false;
        private HousePopulation house;

        public JTextFieldDoubleListener(JTextField textField, String value, HousePopulation house) {
            this.jtextField = textField;
            this.currentString = value;
            this.house = house;
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
                    JOptionPane.showOptionDialog(this.house.getCity().getMainFrame(), Messages.badNumberFormat(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
                return;
            }
            try {
                if (numTxt.contains(" ")) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(this.house.getCity().getMainFrame(), Messages.badNumberFormat(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(this.currentString);
                    this.insert = false;
                    return;
                }
                Double d = Double.parseDouble(numTxt);
                if (d > 100) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(this.house.getCity().getMainFrame(), Messages.percentageCanBbeGreaterThen100(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(this.currentString);
                    this.insert = false;
                } else {
                    if (!insert) {
                        this.currentString = numTxt;
                        this.house.setPercentage(Double.parseDouble(numTxt));
                        this.house.getCity().checkHousePopulationPercentage();
                        this.house.getCity().getMainFrame().setCitySavedButtonEnable();
                        this.house.getCity().setIsSaved(false);
                        this.house.setSaved(false);
                    }
                }
            } catch (NumberFormatException ex) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.house.getCity().getMainFrame(), Messages.badNumberFormat(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
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
            this.house.setPercentage(Double.parseDouble(s));
            this.house.getCity().checkHousePopulationPercentage();
            this.house.getCity().getMainFrame().setCitySavedButtonEnable();
            this.house.setSaved(false);
            this.house.getCity().setIsSaved(false);

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
