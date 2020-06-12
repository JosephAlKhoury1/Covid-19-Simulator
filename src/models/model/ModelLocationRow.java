package models.model;

import java.awt.Component;
import javax.swing.JComboBox;
import models.location1.LocationCategory;

public class ModelLocationRow extends javax.swing.JPanel {

    private LocationCategory locationCategory;
    private Model model;
    private final String[] hours = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};

    public ModelLocationRow(LocationCategory lc, Model m) {
        initComponents();
        this.locationCategory = lc;
        this.model = m;
        this.nameLabel.setText(lc.getName());
        if (this.locationCategory.getKind().equals("House")) {
            this.mondayBox.setEnabled(false);
            this.tuesdayBox.setEnabled(false);
            this.wednesdayBox.setEnabled(false);
            this.thursdayBox.setEnabled(false);
            this.fridayBox.setEnabled(false);
            this.saturdayBox.setEnabled(false);
            this.sundayBox.setEnabled(false);
            this.openTimeComboBox.setEnabled(false);
            this.closeTimeComboBox.setEnabled(false);
        }
        String[] tab = lc.getDays().split(" ");
        for (String s : tab) {
            switch (s) {
                case "Monday":
                    this.mondayBox.setSelected(true);
                    break;
                case "Tuesday":
                    this.tuesdayBox.setSelected(true);
                    break;
                case "Wednesday":
                    this.wednesdayBox.setSelected(true);
                    break;
                case "Thursday":
                    this.thursdayBox.setSelected(true);
                    break;
                case "Friday":
                    this.fridayBox.setSelected(true);
                    break;
                case "Saturday":
                    this.saturdayBox.setSelected(true);
                    break;
                case "Sunday":
                    this.sundayBox.setSelected(true);
                    break;
                default:
                    break;
            }
        }
        for (int i = 0; i < hours.length; i++) {
            if (this.locationCategory.getOpenTime() == Integer.parseInt(this.hours[i])) {
                this.openTimeComboBox.setSelectedIndex(i);
            } else if (this.locationCategory.getCloseTime() == Integer.parseInt(this.hours[i])) {
                this.closeTimeComboBox.setSelectedIndex(i);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        mondayBox = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        tuesdayBox = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        wednesdayBox = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        thursdayBox = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        fridayBox = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        saturdayBox = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        sundayBox = new javax.swing.JCheckBox();
        openTimeComboBox = new JComboBox(this.hours)
        ;
        closeTimeComboBox = new JComboBox(this.hours)
        ;

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setToolTipText("");
        nameLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setAlignmentX(Component.CENTER_ALIGNMENT);

        mondayBox.setToolTipText("");
        mondayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mondayBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(mondayBox)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mondayBox)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setAlignmentX(Component.CENTER_ALIGNMENT);

        tuesdayBox.setToolTipText("");
        tuesdayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuesdayBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tuesdayBox)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tuesdayBox)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setAlignmentX(Component.CENTER_ALIGNMENT);

        wednesdayBox.setToolTipText("");
        wednesdayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wednesdayBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(wednesdayBox)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wednesdayBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        thursdayBox.setToolTipText("");
        thursdayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thursdayBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(thursdayBox)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(thursdayBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setAlignmentX(Component.CENTER_ALIGNMENT);

        fridayBox.setToolTipText("");
        fridayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fridayBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(fridayBox)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fridayBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setAlignmentX(Component.CENTER_ALIGNMENT);

        saturdayBox.setToolTipText("");
        saturdayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saturdayBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(saturdayBox)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saturdayBox)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setAlignmentX(Component.CENTER_ALIGNMENT);

        sundayBox.setToolTipText("");
        sundayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sundayBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(sundayBox)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sundayBox)
                .addContainerGap())
        );

        openTimeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openTimeComboBoxActionPerformed(evt);
            }
        });

        closeTimeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeTimeComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(openTimeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(closeTimeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(openTimeComboBox)
            .addComponent(closeTimeComboBox)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mondayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mondayBoxActionPerformed
        if (this.mondayBox.isSelected()) {
            this.locationCategory.addDayModel(this.model.getCity().getWeek().getMONDAY());
        } else {
            this.locationCategory.removeDayModel(this.model.getCity().getWeek().getMONDAY());
        }
    }//GEN-LAST:event_mondayBoxActionPerformed

    private void tuesdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuesdayBoxActionPerformed
        if (this.mondayBox.isSelected()) {
            this.locationCategory.addDayModel(this.model.getCity().getWeek().getTUESDAY());
        } else {
            this.locationCategory.removeDayModel(this.model.getCity().getWeek().getTUESDAY());
        }
    }//GEN-LAST:event_tuesdayBoxActionPerformed

    private void wednesdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wednesdayBoxActionPerformed
        if (this.mondayBox.isSelected()) {
            this.locationCategory.addDayModel(this.model.getCity().getWeek().getWEDNESDAY());
        } else {
            this.locationCategory.removeDayModel(this.model.getCity().getWeek().getWEDNESDAY());
        }
    }//GEN-LAST:event_wednesdayBoxActionPerformed

    private void thursdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thursdayBoxActionPerformed
        if (this.mondayBox.isSelected()) {
            this.locationCategory.addDayModel(this.model.getCity().getWeek().getTHURSDAY());
        } else {
            this.locationCategory.removeDayModel(this.model.getCity().getWeek().getTHURSDAY());
        }
    }//GEN-LAST:event_thursdayBoxActionPerformed

    private void fridayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fridayBoxActionPerformed
        if (this.mondayBox.isSelected()) {
            this.locationCategory.addDayModel(this.model.getCity().getWeek().getFRIDAY());
        } else {
            this.locationCategory.removeDayModel(this.model.getCity().getWeek().getFRIDAY());
        }
    }//GEN-LAST:event_fridayBoxActionPerformed

    private void saturdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saturdayBoxActionPerformed
        if (this.mondayBox.isSelected()) {
            this.locationCategory.addDayModel(this.model.getCity().getWeek().getSATURDAY());
        } else {
            this.locationCategory.removeDayModel(this.model.getCity().getWeek().getSATURDAY());
        }
    }//GEN-LAST:event_saturdayBoxActionPerformed

    private void sundayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sundayBoxActionPerformed
        if (this.mondayBox.isSelected()) {
            this.locationCategory.addDayModel(this.model.getCity().getWeek().getSUNDAY());
        } else {
            this.locationCategory.removeDayModel(this.model.getCity().getWeek().getSUNDAY());
        }
    }//GEN-LAST:event_sundayBoxActionPerformed

    private void openTimeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openTimeComboBoxActionPerformed
        String h = this.openTimeComboBox.getItemAt(this.openTimeComboBox.getSelectedIndex());
        this.locationCategory.setOpenTimeModel(Integer.parseInt(h));
    }//GEN-LAST:event_openTimeComboBoxActionPerformed

    private void closeTimeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeTimeComboBoxActionPerformed
        String h = this.closeTimeComboBox.getItemAt(this.closeTimeComboBox.getSelectedIndex());
        this.locationCategory.setCloseTimeModel(Integer.parseInt(h));
    }//GEN-LAST:event_closeTimeComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> closeTimeComboBox;
    private javax.swing.JCheckBox fridayBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JCheckBox mondayBox;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JComboBox<String> openTimeComboBox;
    private javax.swing.JCheckBox saturdayBox;
    private javax.swing.JCheckBox sundayBox;
    private javax.swing.JCheckBox thursdayBox;
    private javax.swing.JCheckBox tuesdayBox;
    private javax.swing.JCheckBox wednesdayBox;
    // End of variables declaration//GEN-END:variables
}
