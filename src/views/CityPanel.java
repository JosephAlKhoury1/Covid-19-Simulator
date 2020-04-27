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
    private City city1;

    public CityPanel(int width, int height) {
        this.width = width;
        this.height = height;
        try {
            city = new City(width, height, this);
        } catch (RemoteException ex) {
            Logger.getLogger(CityPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
    }

    public void addCity(City city) {
        this.city1 = city;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        city1.draw(g);
    }

    public ICity getCity() {
        return city;
    }

    public void setCity(ICity city) {
        this.city = city;
    }

    public City getCity1() {
        return city1;
    }

    public void setCity1(City city1) {
        this.city1 = city1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new Dimension(width,height));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
