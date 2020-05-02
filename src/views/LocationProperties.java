/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import models.client.Day;
import models.client.MonteCarlo;
import models.location.Location;
import static models.location.LocationData.HTILEUNIVERSITY;
import static models.location.LocationData.WTILEUNIVERSITY;
import models.locationFactories.HouseFactory;
import models.locationFactories.LocationFactory;
import views.tile.TileType;

/**
 *
 * @author Joseph
 */
public class LocationProperties extends javax.swing.JPanel {
    
    private final String name;
    private final String locationKind;
    private final int quantity;
    private final Double percentage;
    private final LocationFactory factory;
    private final MainFrame mainFrame;
    private final List<Day> listDay;
    private final List<Location> listLocations;
    private int openTime, closeTime;
    private final String[] hours = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
    
    public List<Location> getListLocations() {
        return listLocations;
    }
    private int q;
    
    public LocationProperties(String name, String locationkind, int quantity, double percentage, LocationFactory factory, List<Day> listDay, int openTime, int closeTime, MainFrame mainFrame) {
        this.name = name;
        this.locationKind = locationkind;
        this.quantity = quantity;
        this.percentage = percentage;
        this.mainFrame = mainFrame;
        this.factory = factory;
        this.listDay = listDay;
        this.openTime = openTime;
        this.closeTime = closeTime;
        initComponents();
        this.nameLabel1.setText(name);
        this.kindLabel1.setText(locationkind);
        this.quantityLabel1.setText(quantity + "");
        this.percentageLabel1.setText(percentage + "");
        this.q = quantity;
        this.listLocations = new ArrayList();
        if (this.factory == HouseFactory.INSTANCE) {
            jPanel1.setVisible(false);
            
            jPanel2.setVisible(false);
        } else {
            for (Day d : listDay) {
                if (d == Day.monday) {
                    mondayBox.setSelected(true);
                }
                if (d == Day.tuesday) {
                    tuesdayBox.setSelected(true);
                }
                if (d == Day.wednesday) {
                    wednesdayBox.setSelected(true);
                }
                if (d == Day.thursday) {
                    thursdayBox.setSelected(true);
                }
                if (d == Day.friday) {
                    fridayBox.setSelected(true);
                }
                if (d == Day.saturday) {
                    saturdayBox.setSelected(true);
                }
                if (d == Day.sunday) {
                    sundayBox.setSelected(true);
                }
            }
        }
        this.openTimeBox.setSelectedIndex(this.openTime);
        this.closeTimeBox.setSelectedIndex(this.closeTime);
    }
    
    public void initLocation() {
        listLocations.clear();
        q = quantity;
        while (q > 0) {
            int i = MonteCarlo.getNextIntBetween(1, 4, mainFrame.city1.getNbw());
            int j = MonteCarlo.getNextIntBetween(1, 4, mainFrame.city1.getNbh());
            boolean draw = true;
            for (int a = 0; a < WTILEUNIVERSITY; a++) {
                for (int b = 0; b < HTILEUNIVERSITY; b++) {
                    if (mainFrame.getCity1().getMap()[i + a][j + b].getTileType() == TileType.buildingTile && mainFrame.getCity1().getMap()[i + a][j + a].isDrawable()) {
                    } else {
                        draw = false;
                    }
                }
            }
            if (draw) {
                Location l = factory.creatLocation(mainFrame.getCity1().getMap()[i][j].getX(), mainFrame.getCity1().getMap()[i][j].getY(), quantity, mainFrame.cityPanel.getCity1());
                listLocations.add(l);
                l.setOpenTime(openTime);
                l.setCloseTime(closeTime);
                for (Day d : listDay) {
                    l.addDay(d);                    
                }
                for (int a = 0; a < WTILEUNIVERSITY; a++) {
                    for (int b = 0; b < HTILEUNIVERSITY; b++) {
                        mainFrame.getCity1().getMap()[i + a][j + b].setWalking(false);
                        l.addTile(mainFrame.getCity1().getMap()[i + a][j + b]);
                    }
                }
                q--;
                for (int k = i - 1; k <= i + WTILEUNIVERSITY; k++) {
                    for (int g = j - 1; g <= j + HTILEUNIVERSITY; g++) {
                        mainFrame.getCity1().getMap()[k][g].setDrawable(false);
                    }
                }
            }
        }
        mainFrame.getCity1().addLocation(name + " " + locationKind, listLocations);
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
        jLabel9 = new javax.swing.JLabel();
        percentageLabel1 = new javax.swing.JLabel();
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

        jLabel9.setText("Percentage to sick:");

        percentageLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        percentageLabel1.setText("50");
        percentageLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(quantityLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(percentageLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(102, 102, 102))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(kindLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(nameLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(percentageLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sundayBox)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(thursdayBox)
                            .addComponent(mondayBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tuesdayBox)
                            .addComponent(fridayBox))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saturdayBox)
                            .addComponent(wednesdayBox))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mondayBox)
                    .addComponent(tuesdayBox)
                    .addComponent(wednesdayBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thursdayBox)
                    .addComponent(fridayBox)
                    .addComponent(saturdayBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sundayBox))
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(openTimeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeTimeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mondayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mondayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.listDay.add(Day.monday);
            for (Location l : listLocations) {
                l.addDay(Day.monday);
            }
        } else {
            this.listDay.remove(Day.monday);
            for (Location l : listLocations) {
                l.removeDay(Day.monday);
            }
        }
    }//GEN-LAST:event_mondayBoxActionPerformed

    private void tuesdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuesdayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.listDay.add(Day.tuesday);
            for (Location l : listLocations) {
                l.addDay(Day.tuesday);
            }
        } else {
            this.listDay.remove(Day.tuesday);
            for (Location l : listLocations) {
                l.removeDay(Day.tuesday);
            }
        }
    }//GEN-LAST:event_tuesdayBoxActionPerformed

    private void wednesdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wednesdayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.listDay.add(Day.wednesday);
            for (Location l : listLocations) {
                l.addDay(Day.wednesday);
            }
        } else {
            this.listDay.remove(Day.wednesday);
            for (Location l : listLocations) {
                l.removeDay(Day.wednesday);
            }
        }
    }//GEN-LAST:event_wednesdayBoxActionPerformed

    private void thursdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thursdayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.listDay.add(Day.thursday);
            for (Location l : listLocations) {
                l.addDay(Day.thursday);
            }
        } else {
            this.listDay.remove(Day.thursday);
            for (Location l : listLocations) {
                l.removeDay(Day.thursday);
            }
        }
    }//GEN-LAST:event_thursdayBoxActionPerformed

    private void fridayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fridayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.listDay.add(Day.friday);
            for (Location l : listLocations) {
                l.addDay(Day.friday);
            }
        } else {
            this.listDay.remove(Day.friday);
            for (Location l : listLocations) {
                l.removeDay(Day.friday);
            }
        }
    }//GEN-LAST:event_fridayBoxActionPerformed

    private void saturdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saturdayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.listDay.add(Day.saturday);
            for (Location l : listLocations) {
                l.addDay(Day.saturday);
            }
        } else {
            this.listDay.remove(Day.saturday);
            for (Location l : listLocations) {
                l.removeDay(Day.saturday);
            }
        }
    }//GEN-LAST:event_saturdayBoxActionPerformed

    private void sundayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sundayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.listDay.add(Day.sunday);
            for (Location l : listLocations) {
                l.addDay(Day.sunday);
            }
        } else {
            this.listDay.remove(Day.sunday);
            for (Location l : listLocations) {
                l.removeDay(Day.sunday);
            }
        }
    }//GEN-LAST:event_sundayBoxActionPerformed

    private void openTimeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openTimeBoxActionPerformed
        String openT = openTimeBox.getItemAt(openTimeBox.getSelectedIndex());
        this.openTime = Integer.parseInt(openT);
        for (Location l : listLocations) {
            l.setOpenTime(openTime);
        }
    }//GEN-LAST:event_openTimeBoxActionPerformed

    private void closeTimeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeTimeBoxActionPerformed
        String closeT = closeTimeBox.getItemAt(closeTimeBox.getSelectedIndex());
        this.closeTime = Integer.parseInt(closeT);
        for (Location l : listLocations) {
            l.setOpenTime(closeTime);
        }
    }//GEN-LAST:event_closeTimeBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> closeTimeBox;
    private javax.swing.JCheckBox fridayBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel kindLabel;
    private javax.swing.JLabel kindLabel1;
    private javax.swing.JCheckBox mondayBox;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JComboBox<String> openTimeBox;
    private javax.swing.JLabel percentageLabel;
    private javax.swing.JLabel percentageLabel1;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JLabel quantityLabel1;
    private javax.swing.JCheckBox saturdayBox;
    private javax.swing.JCheckBox sundayBox;
    private javax.swing.JCheckBox thursdayBox;
    private javax.swing.JCheckBox tuesdayBox;
    private javax.swing.JCheckBox wednesdayBox;
    // End of variables declaration//GEN-END:variables
}
