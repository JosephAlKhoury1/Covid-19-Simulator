package views1;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import models.location1.LocationCategory;
import models.locationFactories1.HouseFactory;

public class LocationProperties extends javax.swing.JPanel {

    private LocationCategory locationCategory;
    private boolean first = true;
    private final String[] hours = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};

    public LocationProperties(LocationCategory lc) {
        this.locationCategory = lc;
        initComponents();
        this.nameLabel1.setText(lc.getName());
        this.kindLabel1.setText(lc.getKind());
        this.quantityLabel1.setText(lc.getQuantity() + "");

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
        if (lc.getFactory() == HouseFactory.INSTANCE) {
            jPanel1.setVisible(false);
            jPanel2.setVisible(false);
        }

        for (int i = 0; i < hours.length; i++) {
            if (this.locationCategory.getOpenTime() == Integer.parseInt(this.hours[i])) {
                this.openTimeBox.setSelectedIndex(i);
            } else if (this.locationCategory.getCloseTime() == Integer.parseInt(this.hours[i])) {
                this.closeTimeBox.setSelectedIndex(i);
            }
        }
        first = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nameLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        kindLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        quantityLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        mondayBox = new javax.swing.JCheckBox();
        tuesdayBox = new javax.swing.JCheckBox();
        wednesdayBox = new javax.swing.JCheckBox();
        thursdayBox = new javax.swing.JCheckBox();
        fridayBox = new javax.swing.JCheckBox();
        saturdayBox = new javax.swing.JCheckBox();
        sundayBox = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        openTimeBox = new JComboBox(this.hours)
        ;
        closeTimeBox = new JComboBox(this.hours);

        jLabel7.setText("Properties:");

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Name:");

        nameLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel1.setToolTipText("");
        nameLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Kind:");

        kindLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kindLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Quantity:");

        quantityLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quantityLabel1.setText("0");
        quantityLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(quantityLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kindLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kindLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        mondayBox.setText("Monday");
        mondayBox.setToolTipText("");
        mondayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mondayBoxActionPerformed(evt);
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

        fridayBox.setText("Friday");
        fridayBox.setToolTipText("");
        fridayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fridayBoxActionPerformed(evt);
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
                .addContainerGap()
                .addComponent(mondayBox)
                .addGap(10, 10, 10)
                .addComponent(tuesdayBox)
                .addGap(10, 10, 10)
                .addComponent(wednesdayBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(thursdayBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fridayBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saturdayBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sundayBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mondayBox)
                    .addComponent(tuesdayBox)
                    .addComponent(wednesdayBox)
                    .addComponent(thursdayBox)
                    .addComponent(fridayBox)
                    .addComponent(saturdayBox)
                    .addComponent(sundayBox))
                .addGap(46, 46, 46))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("Open Time:");

        jLabel11.setText("Close Time:");

        openTimeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openTimeBoxActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(closeTimeBox, 0, 60, Short.MAX_VALUE)
                    .addComponent(openTimeBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openTimeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(closeTimeBox)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mondayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mondayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.locationCategory.addDay(this.locationCategory.getCity().getWeek().getMONDAY());
        } else {
            this.locationCategory.removeDay(this.locationCategory.getCity().getWeek().getMONDAY());
        }
        System.out.println("list days size = " + this.locationCategory.getListDay().size());
    }//GEN-LAST:event_mondayBoxActionPerformed

    private void tuesdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuesdayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.locationCategory.addDay(this.locationCategory.getCity().getWeek().getTUESDAY());
        } else {
            this.locationCategory.removeDay(this.locationCategory.getCity().getWeek().getTUESDAY());
        }
    }//GEN-LAST:event_tuesdayBoxActionPerformed

    private void wednesdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wednesdayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.locationCategory.addDay(this.locationCategory.getCity().getWeek().getWEDNESDAY());
        } else {
            this.locationCategory.removeDay(this.locationCategory.getCity().getWeek().getWEDNESDAY());
        }
    }//GEN-LAST:event_wednesdayBoxActionPerformed

    private void thursdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thursdayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.locationCategory.addDay(this.locationCategory.getCity().getWeek().getTHURSDAY());
        } else {
            this.locationCategory.removeDay(this.locationCategory.getCity().getWeek().getTHURSDAY());
        }
    }//GEN-LAST:event_thursdayBoxActionPerformed

    private void fridayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fridayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.locationCategory.addDay(this.locationCategory.getCity().getWeek().getFRIDAY());
        } else {
            this.locationCategory.removeDay(this.locationCategory.getCity().getWeek().getFRIDAY());
        }
    }//GEN-LAST:event_fridayBoxActionPerformed

    private void saturdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saturdayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.locationCategory.addDay(this.locationCategory.getCity().getWeek().getSATURDAY());
        } else {
            this.locationCategory.removeDay(this.locationCategory.getCity().getWeek().getSATURDAY());
        }
    }//GEN-LAST:event_saturdayBoxActionPerformed

    private void sundayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sundayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.locationCategory.addDay(this.locationCategory.getCity().getWeek().getSUNDAY());
        } else {
            this.locationCategory.removeDay(this.locationCategory.getCity().getWeek().getSUNDAY());
        }
    }//GEN-LAST:event_sundayBoxActionPerformed

    private void openTimeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openTimeBoxActionPerformed
        if (!first) {
            String openT = openTimeBox.getItemAt(openTimeBox.getSelectedIndex());
            this.locationCategory.setOpenTime(Integer.parseInt(openT));
        }
    }//GEN-LAST:event_openTimeBoxActionPerformed

    private void closeTimeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeTimeBoxActionPerformed
        if (!first) {
            String closeT = closeTimeBox.getItemAt(closeTimeBox.getSelectedIndex());
            this.locationCategory.setCloseTime(Integer.parseInt(closeT));
        }
    }//GEN-LAST:event_closeTimeBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> closeTimeBox;
    private javax.swing.JCheckBox fridayBox;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel kindLabel1;
    private javax.swing.JCheckBox mondayBox;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JComboBox<String> openTimeBox;
    private javax.swing.JLabel quantityLabel1;
    private javax.swing.JCheckBox saturdayBox;
    private javax.swing.JCheckBox sundayBox;
    private javax.swing.JCheckBox thursdayBox;
    private javax.swing.JCheckBox tuesdayBox;
    private javax.swing.JCheckBox wednesdayBox;
    // End of variables declaration//GEN-END:variables
}
