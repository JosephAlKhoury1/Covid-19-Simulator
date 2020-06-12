package views1;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import models.locationFactories1.*;
import views.dialog1.NewLocationDialog;

/**
 *
 * @author Joseph
 */
public class NewLocation extends javax.swing.JPanel {

    private final MainFrame mainFrame;
    private final NewLocationDialog dialog;
    private final String name;
    private final String[] locationName = {"House", "Hospital", "School", "University", "Church", "Mosque", "RefugeeCamp", "DisplacementCamp", "Restaurant", "SuperMarket", "Factory"};
    private final String[] hours = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
    private final LocationFactory[] locationFactories = {HouseFactory.INSTANCE,
        HospitalFactory.INSTANCE,
        SchoolFactory.INSTANCE,
        UniversityFactory.INSTANCE,
        ChurchFactory.INSTANCE,
        MosqueFactory.INSTANCE,
        RefugeeCampFactory.INSTANCE,
        DisplacementCampFactory.INSTANCE,
        RestaurantFactory.INSTANCE,
        SuperMarketFactory.INSTANCE,
        FactoryFactory.INSTANCE,};
    private LocationFactory currentFactory = locationFactories[0];
    private String kindName = locationName[0];
    private int index = 0;
    private int quantity = 0;
    private int fixed = 0;
    private double percentage = 50;
    private List<String> listDay;
    private int openTime = 0, closeTime = 0;
    private String days = "";

    public NewLocation(String name, MainFrame mainFrame, NewLocationDialog dialog) {
        initComponents();
        this.mainFrame = mainFrame;
        this.dialog = dialog;
        this.name = name;
        this.nameLabel.setText(name);
        this.listDay = new ArrayList();
        setEnable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        kindBox = new JComboBox(locationName);
        jLabel4 = new javax.swing.JLabel();
        quantityTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        percentageTxt = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        mondayBox = new javax.swing.JCheckBox();
        fridayBox = new javax.swing.JCheckBox();
        tuesdayBox = new javax.swing.JCheckBox();
        wednesdayBox = new javax.swing.JCheckBox();
        thursdayBox = new javax.swing.JCheckBox();
        saturdayBox = new javax.swing.JCheckBox();
        sundayBox = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        openTimeBox = new JComboBox(this.hours)
        ;
        jLabel7 = new javax.swing.JLabel();
        closeTimeBox = new JComboBox(this.hours) ;
        fixedJCheckBox = new javax.swing.JCheckBox();

        jLabel1.setText("New Location");

        jLabel2.setText("Name:");

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Kind:");

        kindBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kindBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantity:");

        quantityTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantityTxt.setText("0");

        jLabel5.setText("Percentage to be sick:");

        percentageTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        percentageTxt.setText("50");
        percentageTxt.setToolTipText("");

        okButton.setText("Ok");
        okButton.setToolTipText("");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Day:");

        mondayBox.setText("Monday");
        mondayBox.setToolTipText("");
        mondayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mondayBoxActionPerformed(evt);
            }
        });

        fridayBox.setText("Friday");
        fridayBox.setToolTipText("");
        fridayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fridayBoxActionPerformed(evt);
            }
        });

        tuesdayBox.setText("Tuesday");
        tuesdayBox.setToolTipText("");
        tuesdayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuesdayBoxActionPerformed(evt);
            }
        });

        wednesdayBox.setText("Wednesday");
        wednesdayBox.setToolTipText("");
        wednesdayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wednesdayBoxActionPerformed(evt);
            }
        });

        thursdayBox.setText("Thursday");
        thursdayBox.setToolTipText("");
        thursdayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thursdayBoxActionPerformed(evt);
            }
        });

        saturdayBox.setText("Saturday");
        saturdayBox.setToolTipText("");
        saturdayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saturdayBoxActionPerformed(evt);
            }
        });

        sundayBox.setText("Sunday");
        sundayBox.setToolTipText("");
        sundayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sundayBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mondayBox)
                    .addComponent(fridayBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tuesdayBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(wednesdayBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(thursdayBox))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(saturdayBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sundayBox)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mondayBox)
                    .addComponent(tuesdayBox)
                    .addComponent(wednesdayBox)
                    .addComponent(thursdayBox))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fridayBox)
                    .addComponent(saturdayBox)
                    .addComponent(sundayBox))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("Time:");

        jLabel6.setText("Open Time:");

        openTimeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openTimeBoxActionPerformed(evt);
            }
        });

        jLabel7.setText("Close Time:");

        closeTimeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeTimeBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(closeTimeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(openTimeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openTimeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeTimeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        fixedJCheckBox.setText("Fixed location");
        fixedJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fixedJCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 208, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kindBox, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(percentageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(79, 79, 79)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fixedJCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kindBox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(percentageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fixedJCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(okButton)
                            .addComponent(cancelButton))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        try {
            this.quantity = Integer.parseInt(quantityTxt.getText());
        } catch (NumberFormatException e) {
            String message = "Quantity must be a number !";
            String title = "Error";
            JOptionPane.showOptionDialog(this.dialog, message, title, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
            return;
        }
        try {
            this.percentage = Double.parseDouble(percentageTxt.getText());
        } catch (NumberFormatException e) {
            String message = "Percentage must be a number !";
            String title = "Error";
            JOptionPane.showOptionDialog(this.dialog, message, title, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
            return;
        }

        for (String d : this.listDay) {
            days = days + d + " ";
        }
        this.mainFrame.setCitySavedButtonEnable();
        this.mainFrame.getCurrentCityPanel().getCity1().setIsSaved(false);
        this.mainFrame.locationListPanel.addNewRow(this.name, this.kindName, this.percentage, this.quantity, days, this.openTime, this.closeTime, this.fixed);
        this.mainFrame.setEnabled(true);
        this.dialog.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        mainFrame.setEnabled(true);
        dialog.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    public void setEnable(boolean enable) {
        this.openTimeBox.setEnabled(enable);
        this.closeTimeBox.setEnabled(enable);
        this.mondayBox.setEnabled(enable);
        this.tuesdayBox.setEnabled(enable);
        this.wednesdayBox.setEnabled(enable);
        this.thursdayBox.setEnabled(enable);
        this.fridayBox.setEnabled(enable);
        this.saturdayBox.setEnabled(enable);
        this.sundayBox.setEnabled(enable);
    }

    public void clearChecked() {
        this.mondayBox.setSelected(false);
        this.tuesdayBox.setSelected(false);
        this.wednesdayBox.setSelected(false);
        this.thursdayBox.setSelected(false);
        this.fridayBox.setSelected(false);
        this.saturdayBox.setSelected(false);
        this.sundayBox.setSelected(false);
    }
    private void kindBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kindBoxActionPerformed
        index = kindBox.getSelectedIndex();
        kindName = kindBox.getItemAt(index);
        currentFactory = locationFactories[index];
        if (currentFactory == HouseFactory.INSTANCE) {
            clearChecked();
            setEnable(false);
            this.listDay.clear();
            this.openTime = 0;
            this.closeTime = 0;
            openTimeBox.setSelectedIndex(0);
            closeTimeBox.setSelectedIndex(0);

        } else {
            setEnable(true);
        }
    }//GEN-LAST:event_kindBoxActionPerformed

    private void mondayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mondayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.listDay.add("Monday");
        } else {
            this.listDay.remove("Monday");
        }
    }//GEN-LAST:event_mondayBoxActionPerformed

    private void tuesdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuesdayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.listDay.add("Tuesday");
        } else {
            this.listDay.remove("Tuesday");
        }
    }//GEN-LAST:event_tuesdayBoxActionPerformed

    private void wednesdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wednesdayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.listDay.add("Wednesday");
        } else {
            this.listDay.remove("Wednesday");
        }
    }//GEN-LAST:event_wednesdayBoxActionPerformed

    private void thursdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thursdayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.listDay.add("Thursday");
        } else {
            this.listDay.remove("Thursday");
        }
    }//GEN-LAST:event_thursdayBoxActionPerformed

    private void fridayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fridayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.listDay.add("Friday");
        } else {
            this.listDay.remove("Friday");
        }
    }//GEN-LAST:event_fridayBoxActionPerformed

    private void saturdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saturdayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.listDay.add("Saturday");
        } else {
            this.listDay.remove("Saturday");
        }
    }//GEN-LAST:event_saturdayBoxActionPerformed

    private void sundayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sundayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.listDay.add("Sunday");
        } else {
            this.listDay.remove("Sunday");
        }
    }//GEN-LAST:event_sundayBoxActionPerformed

    private void openTimeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openTimeBoxActionPerformed
        String openT = this.openTimeBox.getItemAt(this.openTimeBox.getSelectedIndex());
        this.openTime = Integer.parseInt(openT);
    }//GEN-LAST:event_openTimeBoxActionPerformed

    private void closeTimeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeTimeBoxActionPerformed
        String closeT = this.closeTimeBox.getItemAt(this.closeTimeBox.getSelectedIndex());
        this.closeTime = Integer.parseInt(closeT);
    }//GEN-LAST:event_closeTimeBoxActionPerformed

    private void fixedJCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fixedJCheckBoxActionPerformed
        if (this.fixedJCheckBox.isSelected()) {
            this.fixed = 1;
        } else {
            this.fixed = 0;
        }
    }//GEN-LAST:event_fixedJCheckBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> closeTimeBox;
    private javax.swing.JCheckBox fixedJCheckBox;
    private javax.swing.JCheckBox fridayBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> kindBox;
    private javax.swing.JCheckBox mondayBox;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox<String> openTimeBox;
    private javax.swing.JTextField percentageTxt;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JCheckBox saturdayBox;
    private javax.swing.JCheckBox sundayBox;
    private javax.swing.JCheckBox thursdayBox;
    private javax.swing.JCheckBox tuesdayBox;
    private javax.swing.JCheckBox wednesdayBox;
    // End of variables declaration//GEN-END:variables
}
