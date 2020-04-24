/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.tile;

import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import models.client.Data;
import models.member.Member;

/**
 *
 * @author Joseph
 */
public class Tile {

    private int x, y;
    private TileType tileType;
    private Image image;
    private JPanel panel;
    private boolean drawable = true;
    private boolean walking = true;
    private Map<Integer, Member> listMember;

    public Tile(int x, int y, TileType type, JPanel panel) {
        this.x = x;
        this.y = y;
        this.tileType = type;
        this.listMember = new HashMap();
        loadImage();
    }

    public void loadImage() {
        ImageIcon ii = new ImageIcon(tileType.getImage());
        image = ii.getImage();
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, Data.TileWidth, Data.TileHeight, panel);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public boolean isDrawable() {
        return drawable;
    }

    public void setDrawable(boolean drawable) {
        this.drawable = drawable;
    }

    public void setTileType(TileType type) {
        this.tileType = type;
        loadImage();
    }

    public TileType getTileType() {
        return this.tileType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isWalking() {
        return walking;
    }

    public void setWalking(boolean walking) {
        this.walking = walking;
    }

    public Map<Integer, Member> getListMember() {
        return listMember;
    }

    public void setListMember(Map<Integer, Member> listMember) {
        this.listMember = listMember;
    }

}
