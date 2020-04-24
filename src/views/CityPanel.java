package views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.client.City;
import models.client.ICity;

/**
 *
 * @author Joseph
 */
public class CityPanel extends javax.swing.JPanel {

    private ICity city;
    private int width, height;

    public CityPanel(int width, int height, int hospital, int school, int university, int church,
            int mosque, int shop, int house, int refugeeCamp, int displacementCamp) {
        this.width = width;
        this.height = height;
        try {
            city = new City(width, height, hospital, school, university, church, mosque, shop, house, refugeeCamp, displacementCamp);
        } catch (RemoteException ex) {
            Logger.getLogger(CityPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
    }

    
    @Override
    public void paintComponent(Graphics g) {
        try {
            super.paintComponent(g);
            city.draw(g);
        } catch (RemoteException ex) {
            Logger.getLogger(CityPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public ICity getCity() {
        return city;
    }

    public void setCity(ICity city) {
        this.city = city;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new Dimension(width,height));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
