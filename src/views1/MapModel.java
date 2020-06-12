package views1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import models.client1.Data;
import models.location1.Location;
import models.location1.LocationCategory;
import models.member1.Member;
import models.model.Model;
import views.tile.Tile;
import views.tile.TileType;

public class MapModel extends javax.swing.JPanel {

    private int width, height;
    private Model model;
    private MainFrame mainFrame;
    private ButtonTilte button;
    private JTabbedPane pane;
    private JScrollPane scrollPane;

    private int nbw;
    private int nbh;
    private Tile[][] map;

    public MapModel(MainFrame mainFrame, Model m) {
        this.width = mainFrame.getCurrentCity().getWidth();
        this.height = mainFrame.getCurrentCity().getHeight();
        this.mainFrame = mainFrame;
        this.model = m;
        this.button = new ButtonTilte(this);
        this.pane = mainFrame.getjTabbedPane2();
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
        for (int i = 0; i < this.model.getCity().getNbw(); i++) {
            for (int j = 0; j < this.model.getCity().getNbh(); j++) {
                this.model.getCity().getMap()[i][j].draw(g);
            }
        }
        for (Map.Entry<String, LocationCategory> e : this.model.getCity().getMapLocation().entrySet()) {
            for (Location l : e.getValue().getListLocation()) {
                l.draw(g);
            }
        }
        for (Map.Entry<Integer, Member> e : this.model.getCity().getListMember().entrySet()) {
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

    public void initMapTile() {
        this.nbw = this.getWidth() / (Data.TileWidth + 1);
        int dw = this.getWidth() % (Data.TileWidth + 1);
        this.setWidth(this.getWidth() - dw);
        this.nbh = this.getHeight() / (Data.TileHeight + 1);
        int dh = this.getHeight() % (Data.TileHeight + 1);
        this.setHeight(this.getHeight() - dh);
        map = new Tile[nbw][nbh];
        for (int i = 0; i < nbw; i++) {
            for (int j = 0; j < nbh; j++) {
                map[i][j] = new Tile(i * (Data.TileWidth + 1), j * (Data.TileHeight + 1), TileType.buildingTile, this);
                if (i > 0) {
                    map[i][j].setTopTile(map[i - 1][j]);
                }
                if (j > 0) {
                    map[i][j].setLeftTile(map[i][j - 1]);
                }
            }
        }
    }

    public void removeThisTab() {
        int i = pane.indexOfComponent(this);
        pane.removeTabAt(i);
    }

    public class ButtonTilte extends JPanel implements ActionListener {

        private MapModel mp;

        public ButtonTilte(MapModel mp) {
            initComponents();
            this.mp = mp;
            this.jButton1.addActionListener(this);
        }

        public MapModel getMp() {
            return mp;
        }

        private void initComponents() {

            jLabel1 = new javax.swing.JLabel();
            jButton1 = new javax.swing.JButton();

            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText(model.getModelName() + " Map");

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
            model.getMapMenu().setEnabled(true);
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
            .addGap(0, 608, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
