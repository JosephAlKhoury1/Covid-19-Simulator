package models.location;

import controller.locationController.SuperMarketController;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import models.client.City;
import models.client.Data;
import views.tile.Tile;

/**
 *
 * @author Joseph
 */
public class SuperMarket extends Location {

    public SuperMarket(String name, int x, int y, double average_sick, int locationCategoryId, City city) {
        super(name, x, y, average_sick,locationCategoryId, city);
        this.setWidth(LocationData.WTILESUPERMARKET * Data.TileWidth);
        this.setHeight(LocationData.HTILESUPERMARKET * Data.TileHeight);
        loadImage();
    }

    public SuperMarket(String name, int x, int y, double average_sick, City city) {
        super(name, x, y, average_sick, city);
        this.setWidth(LocationData.WTILESUPERMARKET * Data.TileWidth);
        this.setHeight(LocationData.HTILESUPERMARKET * Data.TileHeight);
        loadImage();
    }

    public SuperMarket(int id, String name, int x, int y, int width, int height, double average_sick,  int locationCategoryId,
            City c) {
        super(id, name, x, y, width, height, average_sick, locationCategoryId, c);
        loadImage();
    }

    public SuperMarket() {
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, map);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    protected void loadImage() {
        ImageIcon ii = new ImageIcon("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\Covid-19 Simulator\\src\\models\\resources\\superMarket.png");
        image = ii.getImage();
    }

    @Override
    public void initPopulation() {
    }

    @Override
    public void save() {
        if (this.isDeleted()) {
            if (this.id != -1) {
                SuperMarketController.INSTANCE.delete(this.id);
                for (Tile t : this.listTile) {
                    t.setDrawable(true);
                    t.setWalking(true);
                }
                return;
            }
        }
        if (this.isNew) {
            SuperMarketController.INSTANCE.insert(this);
            this.isNew = false;
            this.saved = true;
        } else {
            if (!this.saved) {
                SuperMarketController.INSTANCE.update(this);
                this.saved = true;
            } else {

            }
        }
    }
}
