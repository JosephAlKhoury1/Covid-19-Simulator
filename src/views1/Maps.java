package views1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import models.client1.City;
import models.location1.Location;
import models.location1.LocationCategory;
import models.member1.Member;

public class Maps extends javax.swing.JPanel {

    private int width, height;
    private City city1;
    private final MainFrame mainFrame;
    private final ButtonTilte button;
    private final JTabbedPane pane;
    private JScrollPane scrollPane;

    public Maps(MainFrame mainFrame, City c) {
        this.width = c.getWidth();
        this.height = c.getHeight();
        this.mainFrame = mainFrame;
        this.city1 = c;
        this.button = new ButtonTilte(this);
        //this.pane = mainFrame.getjTabbedPane2();
        this.pane = c.getModel().getModelPanel().getjTabbedPane1();
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

            this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            jLabel1 = new JLabel();
            jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel1.setText(city1.getName() + " Map");

            jButton1 = new JButton();
            jButton1.setText("X");
            jButton1.setToolTipText("");
            jButton1.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
            this.jButton1.setMinimumSize(new Dimension(20, 20));
            this.jButton1.setPreferredSize(new Dimension(20, 20));
            this.jButton1.setMaximumSize(new Dimension(20, 20));
            this.add(this.jLabel1);
            this.add(Box.createHorizontalStrut(3));
            this.add(this.jButton1);
        }

        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel1;

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = pane.indexOfComponent(scrollPane);
            pane.removeTabAt(i);
            city1.getModel().getMapMenu().setEnabled(true);
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
            .addGap(0, 378, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
