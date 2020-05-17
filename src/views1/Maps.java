package views1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import models.client1.City;
import models.location1.Location;
import models.location1.LocationCategory;
import models.member1.Member;

/**
 *
 * @author Joseph
 */
public class Maps extends javax.swing.JPanel {

    private int width, height;
    private City city1;
    private final MainFrame mainFrame;
    private final ButtonTilte button;
    private final JTabbedPane pane;
    private JScrollPane scrollPane;
    private final CityPanel cityPanel;

    public Maps(MainFrame mainFrame, CityPanel cityPanel, JTabbedPane pane) {
        this.width = cityPanel.getCity1().getWidth();
        this.height = cityPanel.getCity1().getHeight();
        this.mainFrame = mainFrame;
        this.city1 = cityPanel.getCity1();
        this.cityPanel = cityPanel;
        this.button = new ButtonTilte(this);
        this.pane = pane;
        initComponents();
        this.scrollPane = new JScrollPane(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
        this.mainFrame.repaint();
    }

    public void draw(Graphics g) {
        for (int i = 0; i < this.city1.getNbw(); i++) {
            for (int j = 0; j < this.city1.getNbh(); j++) {
                this.city1.getMap()[i][j].draw(g);
            }
        }
        for (Map.Entry<String, LocationCategory> e : this.city1.getMapLocation().entrySet()) {
            for (Location l : e.getValue().getListLocation()) {
                l.draw(g);
            }
        }
        for (Map.Entry<Integer, Member> e : this.city1.getListMember().entrySet()) {
            e.getValue().draw(g);
        }
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public ButtonTilte getButton() {
        return button;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void addCity(City city) {
        this.city1 = city;
    }

    public City getCity1() {
        return city1;
    }

    public void setCity1(City city1) {
        this.city1 = city1;
    }

    public void removeThisTab() {
        int i = pane.indexOfComponent(this);
        pane.removeTabAt(i);
    }

    public class ButtonTilte extends JPanel implements ActionListener {

        private Maps mp;

        public ButtonTilte(Maps mp) {
            initComponents();
            this.mp = mp;
            this.jButton1.addActionListener(this);
        }

        public Maps getMp() {
            return mp;
        }

        private void initComponents() {

            jLabel1 = new javax.swing.JLabel();
            jButton1 = new javax.swing.JButton();

            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText(city1.getName() + " Map");

            jButton1.setText("X");
            jButton1.setToolTipText("");
            jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(14, 14, 14)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
        }

        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel1;

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = pane.indexOfComponent(scrollPane);
            pane.removeTabAt(i);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setAutoscrolls(true);
        setPreferredSize(new Dimension(this.width,this.height));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
