/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.ArrayList;
import java.util.List;
import models.client.MonteCarlo;
import models.location.Location;
import static models.location.LocationData.HTILEUNIVERSITY;
import static models.location.LocationData.WTILEUNIVERSITY;
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
    private int q;

    public LocationProperties(String name, String locationkind, int quantity, double percentage, LocationFactory factory, MainFrame mainFrame) {
        this.name = name;
        this.locationKind = locationkind;
        this.quantity = quantity;
        this.percentage = percentage;
        this.mainFrame = mainFrame;
        this.factory = factory;
        initComponents();
        this.nameLabel.setText(name);
        this.kindLabel.setText(locationkind);
        this.quantityLabel.setText(quantity + "");
        this.percentageLabel.setText(percentage + "");
        this.q = quantity;
        //initLocation();
    }

    public void initLocation() {
        List<Location> list = new ArrayList();
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
                list.add(l);
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
        mainFrame.getCity1().addLocation(name + " " + locationKind, list);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kindLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        percentageLabel = new javax.swing.JLabel();

        jLabel7.setText("Properties:");

        jLabel1.setText("Name:");

        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setToolTipText("");
        nameLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Kind:");

        kindLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kindLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Quantity:");

        quantityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quantityLabel.setText("0");
        quantityLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Percentage to sick:");

        percentageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        percentageLabel.setText("50");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(kindLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quantityLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(percentageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                        .addGap(102, 102, 102))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kindLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(percentageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addContainerGap(219, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel kindLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel percentageLabel;
    private javax.swing.JLabel quantityLabel;
    // End of variables declaration//GEN-END:variables
}
