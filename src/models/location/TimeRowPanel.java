package models.location;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import resources.Colors.Colors;
import resources.icon.Icons;
import resources.Messages.Messages;

public class TimeRowPanel extends javax.swing.JPanel {

    private String[] hours = {" ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};
    private String[] hoursWithoutSpace = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};
    private TimeRow timeRow;
    private boolean openFirst = true, closeFirst = true;

    public TimeRowPanel(TimeRow row) {
        initComponents();
        this.timeRow = row;
        this.nameLabel.setText(row.getName());
        if (row.getOpenTime() == -2) {
            this.firtTmeBox.setSelectedIndex(0);
        } else {
            this.firtTmeBox.removeItemAt(0);
            for (int i = 1; i < hours.length; i++) {
                if (row.getOpenTime() == Integer.parseInt(this.hours[i])) {
                    this.firtTmeBox.setSelectedIndex(i - 1);
                }
            }
        }
        if (row.getCloseTime() == -1) {
            this.secondTimeBox.setSelectedIndex(0);
        } else {
            this.secondTimeBox.removeItemAt(0);
            for (int i = 1; i < hours.length; i++) {
                if (row.getCloseTime() == Integer.parseInt(this.hours[i])) {
                    this.secondTimeBox.setSelectedIndex(i - 1);
                }
            }
        }

        this.percentageOfHumanTxt.setText(row.getHumanPercentage() + "");

        JTextFieldDoubleListener listener = new JTextFieldDoubleListener(percentageOfHumanTxt, timeRow);
        this.percentageOfHumanTxt.addFocusListener(listener);
        this.percentageOfHumanTxt.getDocument().addDocumentListener(listener);
        checkValid();
        openFirst = false;
        closeFirst = false;
    }

    private void checkValid() {
        if (this.timeRow.isMinValid() && this.timeRow.isMaxValid()) {
            this.nameLabel.setIcon(null);
            this.nameLabel.setToolTipText(null);
            this.nameLabel.setBackground(Colors.NOWARNINGCOLOR);
            this.nameLabel.setText("Between " + this.timeRow.getOpenTime() + " and " + this.timeRow.getCloseTime());
            this.percentageOfHumanTxt.setEnabled(true);
        } else {
            this.nameLabel.setIcon(Icons.WARNINGICON);
            this.nameLabel.setToolTipText(Messages.TimeCantBeConsidered());
            this.nameLabel.setBackground(Colors.WARNINGCOLOR);
            this.nameLabel.setText("Invalid");
            this.percentageOfHumanTxt.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        firtTmeBox = new JComboBox(this.hours)
        ;
        secondTimeBox = new JComboBox(this.hours)
        ;
        percentageOfHumanTxt = new javax.swing.JTextField();
        removeButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(32767, 35));
        setMinimumSize(new java.awt.Dimension(0, 35));

        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setToolTipText("");
        nameLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        firtTmeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firtTmeBoxActionPerformed(evt);
            }
        });

        secondTimeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondTimeBoxActionPerformed(evt);
            }
        });

        percentageOfHumanTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        percentageOfHumanTxt.setText("0");
        percentageOfHumanTxt.setToolTipText("");

        removeButton.setText("-");
        removeButton.setToolTipText("");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firtTmeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(secondTimeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(percentageOfHumanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(firtTmeBox)
            .addComponent(secondTimeBox)
            .addComponent(percentageOfHumanTxt)
            .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void firtTmeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firtTmeBoxActionPerformed
        if (openFirst) {
            return;
        }
        String t = this.firtTmeBox.getItemAt(this.firtTmeBox.getSelectedIndex());
        if (t.equals(" ") || t.isEmpty()) {
            if (!this.timeRow.isMinValid()) {
                return;
            }
        }
        int newTime = Integer.parseInt(t);
        if (this.timeRow.isMaxValid()) {
            if (newTime >= this.timeRow.getCloseTime()) {
                if (this.timeRow.isMinValid()) {
                    for (int i = 0; i < hoursWithoutSpace.length; i++) {
                        if (hoursWithoutSpace[i].equals(this.timeRow.getOpenTime() + "")) {
                            this.firtTmeBox.setSelectedIndex(i);
                            System.out.println("i = " + i);
                        }
                    }
                } else {
                    this.firtTmeBox.setSelectedIndex(0);
                }
                JOptionPane.showOptionDialog(timeRow.getDayrow().getLc().getCity().getMainFrame(), Messages.openTimeError(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
            } else {
                for (TimeRow tr : this.timeRow.getDayrow().getListTimeRow()) {
                    if (tr != this.timeRow) {
                        if (newTime >= tr.getOpenTime() && newTime < tr.getCloseTime()) {
                            if (this.timeRow.isMinValid()) {
                                for (int i = 0; i < hoursWithoutSpace.length; i++) {
                                    if (hoursWithoutSpace[i].equals(this.timeRow.getOpenTime() + "")) {
                                        this.firtTmeBox.setSelectedIndex(i);
                                    }
                                }
                            } else {
                                this.firtTmeBox.setSelectedIndex(0);
                            }
                            JOptionPane.showOptionDialog(timeRow.getDayrow().getLc().getCity().getMainFrame(), Messages.timeExistInOtherInterval(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);

                            return;
                        } else {
                            if (newTime <= tr.getOpenTime() && this.timeRow.getCloseTime() >= tr.getCloseTime()) {
                                if (this.timeRow.isMinValid()) {
                                    for (int i = 0; i < hoursWithoutSpace.length; i++) {
                                        if (hoursWithoutSpace[i].equals(this.timeRow.getOpenTime() + "")) {
                                            this.firtTmeBox.setSelectedIndex(i);
                                        }
                                    }
                                } else {
                                    this.firtTmeBox.setSelectedIndex(0);
                                }
                                JOptionPane.showOptionDialog(timeRow.getDayrow().getLc().getCity().getMainFrame(), Messages.timeExistInOtherInterval(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                                return;
                            }
                        }
                    }
                }
                if (!this.timeRow.isMinValid()) {
                    this.firtTmeBox.removeItemAt(0);
                }
                this.timeRow.setOpenTime(newTime);
                this.timeRow.setMinValid(true);
            }
        } else {
            for (TimeRow tr : this.timeRow.getDayrow().getListTimeRow()) {
                if (tr != this.timeRow) {
                    if (newTime >= tr.getOpenTime() && newTime < tr.getCloseTime()) {
                        if (this.timeRow.isMinValid()) {
                            for (int i = 0; i < hoursWithoutSpace.length; i++) {
                                if (hoursWithoutSpace[i].equals(this.timeRow.getOpenTime() + "")) {
                                    this.firtTmeBox.setSelectedIndex(i);
                                    break;
                                }
                            }
                        } else {
                            this.firtTmeBox.setSelectedIndex(0);
                        }
                        JOptionPane.showOptionDialog(timeRow.getDayrow().getLc().getCity().getMainFrame(), Messages.timeExistInOtherInterval(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                        return;
                    }
                }
            }
            if (!this.timeRow.isMinValid()) {
                this.firtTmeBox.removeItemAt(0);
            }
            this.timeRow.setOpenTime(newTime);
            this.timeRow.setMinValid(true);
        }
        checkValid();
    }//GEN-LAST:event_firtTmeBoxActionPerformed

    private void secondTimeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondTimeBoxActionPerformed
        if (closeFirst) {
            return;
        }
        String t = this.secondTimeBox.getItemAt(this.secondTimeBox.getSelectedIndex());

        if (t.equals(" ") || t.isEmpty()) {
            if (!this.timeRow.isMinValid()) {
                return;
            }
        }
        int newTime = Integer.parseInt(t);
        if (this.timeRow.isMinValid()) {
            if (newTime <= this.timeRow.getOpenTime()) {
                if (this.timeRow.isMaxValid()) {
                    for (int i = 0; i < hoursWithoutSpace.length; i++) {
                        if (hoursWithoutSpace[i].equals(this.timeRow.getCloseTime() + "")) {
                            this.secondTimeBox.setSelectedIndex(i);
                        }
                    }
                } else {
                    this.secondTimeBox.setSelectedIndex(0);
                }
                JOptionPane.showOptionDialog(timeRow.getDayrow().getLc().getCity().getMainFrame(), Messages.closeTimeError(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
            } else {
                for (TimeRow tr : this.timeRow.getDayrow().getListTimeRow()) {
                    if (tr != this.timeRow) {
                        if (newTime > tr.getOpenTime() && newTime <= tr.getCloseTime()) {
                            if (this.timeRow.isMaxValid()) {
                                for (int i = 0; i < hoursWithoutSpace.length; i++) {
                                    if (hoursWithoutSpace[i].equals(this.timeRow.getCloseTime() + "")) {
                                        this.secondTimeBox.setSelectedIndex(i);
                                    }
                                }
                            } else {
                                this.secondTimeBox.setSelectedIndex(0);
                            }
                            JOptionPane.showOptionDialog(timeRow.getDayrow().getLc().getCity().getMainFrame(), Messages.timeExistInOtherInterval(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                            return;
                        } else {
                            if (this.timeRow.getOpenTime() <= tr.getOpenTime() && newTime >= tr.getCloseTime()) {
                                if (this.timeRow.isMaxValid()) {
                                    for (int i = 0; i < hoursWithoutSpace.length; i++) {
                                        if (hoursWithoutSpace[i].equals(this.timeRow.getCloseTime() + "")) {
                                            this.secondTimeBox.setSelectedIndex(i);
                                        }
                                    }
                                } else {
                                    this.secondTimeBox.setSelectedIndex(0);
                                }
                                JOptionPane.showOptionDialog(timeRow.getDayrow().getLc().getCity().getMainFrame(), Messages.timeExistInOtherInterval(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                                return;
                            }
                        }
                    }
                }
                if (!this.timeRow.isMaxValid()) {
                    this.secondTimeBox.removeItemAt(0);
                }
                this.timeRow.setCloseTime(newTime);
                this.timeRow.setMaxValid(true);
            }
        } else {
            for (TimeRow tr : this.timeRow.getDayrow().getListTimeRow()) {
                if (tr != this.timeRow) {
                    if (newTime >= tr.getOpenTime() && newTime < tr.getCloseTime()) {
                        if (this.timeRow.isMinValid()) {
                            for (int i = 0; i < hoursWithoutSpace.length; i++) {
                                if (hoursWithoutSpace[i].equals(this.timeRow.getCloseTime() + "")) {
                                    this.secondTimeBox.setSelectedIndex(i);
                                    break;
                                }
                            }
                        } else {
                            this.secondTimeBox.setSelectedIndex(0);
                        }
                        JOptionPane.showOptionDialog(timeRow.getDayrow().getLc().getCity().getMainFrame(), Messages.timeExistInOtherInterval(), "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                        return;
                    }
                }
            }
            if (!this.timeRow.isMaxValid()) {
                this.secondTimeBox.removeItemAt(0);
            }
            this.timeRow.setCloseTime(newTime);
            this.timeRow.setMaxValid(true);
        }
        checkValid();
    }//GEN-LAST:event_secondTimeBoxActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int reply = JOptionPane.showOptionDialog(this.timeRow.getDayrow().getLc().getCity().getMainFrame(), "Are you sure you want to delete this?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, Icons.WARNINGICON, null, null);
        if (reply == JOptionPane.NO_OPTION || reply == JOptionPane.CLOSED_OPTION) {
            return;
        }
        this.timeRow.getDayrow().getListTimeRow().remove(this.timeRow);
        this.timeRow.setDeleted(true);
        this.timeRow.getDayrow().getListDeleted().add(timeRow);
        switch (this.timeRow.getDayrow().getName()) {
            case "Monday":
                if (this.timeRow.getDayrow().getLc().getLocationProperties() != null) {
                    this.timeRow.getDayrow().getLc().getLocationProperties().mondayPanel.remove(this);
                    int he = this.timeRow.getDayrow().getLc().getLocationProperties().mondayPanel.getHeight() - 35;
                    int wi = this.timeRow.getDayrow().getLc().getLocationProperties().mondayPanel.getWidth();
                    this.timeRow.getDayrow().getLc().getLocationProperties().mondayPanel.setPreferredSize(new Dimension(wi, he));
                    this.timeRow.getDayrow().getLc().getLocationProperties().mondayPanel.repaint();
                    this.timeRow.getDayrow().getLc().getCity().getMainFrame().setVisible(true);
                }
                if (this.timeRow.getDayrow().getLc().getModelLocatioProperties() != null) {
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().mondayPanel.remove(this);
                    int he = this.timeRow.getDayrow().getLc().getModelLocatioProperties().mondayPanel.getHeight() - 35;
                    int wi = this.timeRow.getDayrow().getLc().getModelLocatioProperties().mondayPanel.getWidth();
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().mondayPanel.setPreferredSize(new Dimension(wi, he));
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().mondayPanel.repaint();
                    this.timeRow.getDayrow().getLc().getCity().getMainFrame().setVisible(true);
                }
                break;
            case "Tuesday":
                if (this.timeRow.getDayrow().getLc().getLocationProperties() != null) {
                    this.timeRow.getDayrow().getLc().getLocationProperties().tuesdayPanel.remove(this);
                    int he = this.timeRow.getDayrow().getLc().getLocationProperties().tuesdayPanel.getHeight() - 35;
                    int wi = this.timeRow.getDayrow().getLc().getLocationProperties().tuesdayPanel.getWidth();
                    this.timeRow.getDayrow().getLc().getLocationProperties().tuesdayPanel.setPreferredSize(new Dimension(wi, he));
                    this.timeRow.getDayrow().getLc().getLocationProperties().tuesdayPanel.repaint();
                    this.timeRow.getDayrow().getLc().getCity().getMainFrame().setVisible(true);
                }
                if (this.timeRow.getDayrow().getLc().getModelLocatioProperties() != null) {
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().tuesdayPanel.remove(this);
                    int he = this.timeRow.getDayrow().getLc().getModelLocatioProperties().tuesdayPanel.getHeight() - 35;
                    int wi = this.timeRow.getDayrow().getLc().getModelLocatioProperties().tuesdayPanel.getWidth();
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().tuesdayPanel.setPreferredSize(new Dimension(wi, he));
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().tuesdayPanel.repaint();
                    this.timeRow.getDayrow().getLc().getCity().getMainFrame().setVisible(true);
                }
                break;
            case "Wednesday":
                if (this.timeRow.getDayrow().getLc().getLocationProperties() != null) {
                    this.timeRow.getDayrow().getLc().getLocationProperties().wednesdayPanel.remove(this);
                    int he = this.timeRow.getDayrow().getLc().getLocationProperties().wednesdayPanel.getHeight() - 35;
                    int wi = this.timeRow.getDayrow().getLc().getLocationProperties().wednesdayPanel.getWidth();
                    this.timeRow.getDayrow().getLc().getLocationProperties().wednesdayPanel.setPreferredSize(new Dimension(wi, he));
                    this.timeRow.getDayrow().getLc().getLocationProperties().wednesdayPanel.repaint();
                    this.timeRow.getDayrow().getLc().getCity().getMainFrame().setVisible(true);
                }
                if (this.timeRow.getDayrow().getLc().getModelLocatioProperties() != null) {
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().wednesdayPanel.remove(this);
                    int he = this.timeRow.getDayrow().getLc().getModelLocatioProperties().wednesdayPanel.getHeight() - 35;
                    int wi = this.timeRow.getDayrow().getLc().getModelLocatioProperties().wednesdayPanel.getWidth();
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().wednesdayPanel.setPreferredSize(new Dimension(wi, he));
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().wednesdayPanel.repaint();
                    this.timeRow.getDayrow().getLc().getCity().getMainFrame().setVisible(true);
                }
                break;
            case "Thursday":
                if (this.timeRow.getDayrow().getLc().getLocationProperties() != null) {
                    this.timeRow.getDayrow().getLc().getLocationProperties().thursdayPanel.remove(this);
                    int he = this.timeRow.getDayrow().getLc().getLocationProperties().thursdayPanel.getHeight() - 35;
                    int wi = this.timeRow.getDayrow().getLc().getLocationProperties().thursdayPanel.getWidth();
                    this.timeRow.getDayrow().getLc().getLocationProperties().thursdayPanel.setPreferredSize(new Dimension(wi, he));
                    this.timeRow.getDayrow().getLc().getLocationProperties().thursdayPanel.repaint();
                    this.timeRow.getDayrow().getLc().getCity().getMainFrame().setVisible(true);
                }
                if (this.timeRow.getDayrow().getLc().getModelLocatioProperties() != null) {
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().thursdayPanel.remove(this);
                    int he = this.timeRow.getDayrow().getLc().getModelLocatioProperties().thursdayPanel.getHeight() - 35;
                    int wi = this.timeRow.getDayrow().getLc().getModelLocatioProperties().thursdayPanel.getWidth();
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().thursdayPanel.setPreferredSize(new Dimension(wi, he));
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().thursdayPanel.repaint();
                    this.timeRow.getDayrow().getLc().getCity().getMainFrame().setVisible(true);
                }
                break;
            case "Friday":
                if (this.timeRow.getDayrow().getLc().getLocationProperties() != null) {
                    this.timeRow.getDayrow().getLc().getLocationProperties().fridayPanel.remove(this);
                    int he = this.timeRow.getDayrow().getLc().getLocationProperties().fridayPanel.getHeight() - 35;
                    int wi = this.timeRow.getDayrow().getLc().getLocationProperties().fridayPanel.getWidth();
                    this.timeRow.getDayrow().getLc().getLocationProperties().fridayPanel.setPreferredSize(new Dimension(wi, he));
                    this.timeRow.getDayrow().getLc().getLocationProperties().fridayPanel.repaint();
                    this.timeRow.getDayrow().getLc().getCity().getMainFrame().setVisible(true);
                }
                if (this.timeRow.getDayrow().getLc().getModelLocatioProperties() != null) {
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().fridayPanel.remove(this);
                    int he = this.timeRow.getDayrow().getLc().getModelLocatioProperties().fridayPanel.getHeight() - 35;
                    int wi = this.timeRow.getDayrow().getLc().getModelLocatioProperties().fridayPanel.getWidth();
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().fridayPanel.setPreferredSize(new Dimension(wi, he));
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().fridayPanel.repaint();
                    this.timeRow.getDayrow().getLc().getCity().getMainFrame().setVisible(true);
                }
                break;
            case "Saturday":
                if (this.timeRow.getDayrow().getLc().getLocationProperties() != null) {
                    this.timeRow.getDayrow().getLc().getLocationProperties().saturdayPanel.remove(this);
                    int he = this.timeRow.getDayrow().getLc().getLocationProperties().saturdayPanel.getHeight() - 35;
                    int wi = this.timeRow.getDayrow().getLc().getLocationProperties().saturdayPanel.getWidth();
                    this.timeRow.getDayrow().getLc().getLocationProperties().saturdayPanel.setPreferredSize(new Dimension(wi, he));
                    this.timeRow.getDayrow().getLc().getLocationProperties().saturdayPanel.repaint();
                    this.timeRow.getDayrow().getLc().getCity().getMainFrame().setVisible(true);
                }
                if (this.timeRow.getDayrow().getLc().getModelLocatioProperties() != null) {
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().saturdayPanel.remove(this);
                    int he = this.timeRow.getDayrow().getLc().getModelLocatioProperties().saturdayPanel.getHeight() - 35;
                    int wi = this.timeRow.getDayrow().getLc().getModelLocatioProperties().saturdayPanel.getWidth();
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().saturdayPanel.setPreferredSize(new Dimension(wi, he));
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().saturdayPanel.repaint();
                    this.timeRow.getDayrow().getLc().getCity().getMainFrame().setVisible(true);
                }
                break;
            case "Sunday":
                if (this.timeRow.getDayrow().getLc().getLocationProperties() != null) {
                    this.timeRow.getDayrow().getLc().getLocationProperties().sundayPanel.remove(this);
                    int he = this.timeRow.getDayrow().getLc().getLocationProperties().sundayPanel.getHeight() - 35;
                    int wi = this.timeRow.getDayrow().getLc().getLocationProperties().sundayPanel.getWidth();
                    this.timeRow.getDayrow().getLc().getLocationProperties().sundayPanel.setPreferredSize(new Dimension(wi, he));
                    this.timeRow.getDayrow().getLc().getLocationProperties().sundayPanel.repaint();
                    this.timeRow.getDayrow().getLc().getCity().getMainFrame().setVisible(true);
                }
                if (this.timeRow.getDayrow().getLc().getModelLocatioProperties() != null) {
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().sundayPanel.remove(this);
                    int he = this.timeRow.getDayrow().getLc().getModelLocatioProperties().sundayPanel.getHeight() - 35;
                    int wi = this.timeRow.getDayrow().getLc().getModelLocatioProperties().sundayPanel.getWidth();
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().sundayPanel.setPreferredSize(new Dimension(wi, he));
                    this.timeRow.getDayrow().getLc().getModelLocatioProperties().sundayPanel.repaint();
                    this.timeRow.getDayrow().getLc().getCity().getMainFrame().setVisible(true);
                }
                break;
            default:
                break;
        }
        if (this.timeRow.getDayrow().getLc().getCity().getModel() == null) {
            this.timeRow.getDayrow().getLc().getCity().getMainFrame().setCitySavedButtonEnable();
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private class JTextFieldDoubleListener implements DocumentListener, FocusListener {

        private final JTextField jtextField;
        private String currentString;
        private boolean insert = false;
        private TimeRow timeRow;

        public JTextFieldDoubleListener(JTextField textField, TimeRow row) {
            this.jtextField = textField;
            this.currentString = row.getHumanPercentage() + "";
            this.timeRow = row;
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
                    JOptionPane.showOptionDialog(this.timeRow.getDayrow().getLc().getCity().getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
            }
            try {
                if (numTxt.contains(" ")) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(this.timeRow.getDayrow().getLc().getCity().getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(this.currentString);
                    this.insert = false;
                    return;
                }
                Double d = Double.parseDouble(numTxt);
                if (d > 100) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(this.timeRow.getDayrow().getLc().getCity().getMainFrame(), Messages.percentageCanBbeGreaterThen100(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(this.currentString);
                    this.insert = false;
                } else if (!insert) {
                    this.currentString = numTxt;
                    this.timeRow.setHumanPercentage(Double.parseDouble(numTxt));
                    this.timeRow.setSaved(false);
                    this.timeRow.getDayrow().getLc().getCity().setIsSaved(false);
                    this.timeRow.getDayrow().getLc().getCity().getMainFrame().setCitySavedButtonEnable();
                }

            } catch (NumberFormatException ex) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(this.timeRow.getDayrow().getLc().getCity().getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
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
            this.timeRow.setHumanPercentage(Double.parseDouble(s));
            this.timeRow.setSaved(false);
            this.timeRow.getDayrow().getLc().getCity().setIsSaved(false);
            this.timeRow.getDayrow().getLc().getCity().getMainFrame().setCitySavedButtonEnable();
//            double sum = 0;
//            for (SymptomAge sa : humanAge.getListSymptomAges()) {
//                sum += sa.getPercentage();
//            }
//            if (sum != 100) {
//                humanAge.getNameLabel().setBackground(Colors.WARNINGCOLOR);
//                humanAge.getNameLabel().setIcon(Icons.WARNINGICON);
//                humanAge.getNameLabel().setToolTipText(Messages.AGEPERCENTAGEWARNING);
//                for (SymptomAge sa : humanAge.getListSymptomAges()) {
//                    sa.getPercentageTxt().setBackground(Colors.WARNINGCOLOR);
//                }
//            } else {
//                humanAge.getNameLabel().setBackground(Colors.WHITE);
//                humanAge.getNameLabel().setIcon(null);
//                humanAge.getNameLabel().setToolTipText(null);
//                for (SymptomAge sa : humanAge.getListSymptomAges()) {
//                    sa.getPercentageTxt().setBackground(Colors.WHITE);
//                }
//            }

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

    public void setEnable(boolean ok) {
        this.nameLabel.setEnabled(ok);
        this.firtTmeBox.setEnabled(ok);
        this.secondTimeBox.setEnabled(ok);
        this.percentageOfHumanTxt.setEnabled(ok);
        this.removeButton.setEnabled(ok);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> firtTmeBox;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField percentageOfHumanTxt;
    private javax.swing.JButton removeButton;
    private javax.swing.JComboBox<String> secondTimeBox;
    // End of variables declaration//GEN-END:variables
}
