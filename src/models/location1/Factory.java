package models.location1;

import controller.locationController.FactoryController;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import models.client1.City;
import models.client1.Data;
import views.tile.Tile;

public class Factory extends Location {

    public Factory(String name, int x, int y, double average_sick, int locationCategoryId, City city) {
        super(name, x, y, average_sick, locationCategoryId, city);
        this.setWidth(LocationData.WTILEHOSPITAL * Data.TileWidth);
        this.setHeight(LocationData.HTILEHOSPITAL * Data.TileHeight);
        loadImage();

    }

    public Factory(String name, int x, int y, double average_sick, City city) {
        super(name, x, y, average_sick, city);
        this.setWidth(LocationData.WTILEHOSPITAL * Data.TileWidth);
        this.setHeight(LocationData.HTILEHOSPITAL * Data.TileHeight);
        loadImage();
    }

    public Factory(int id, String name, int x, int y, int width, int height, double average_sick, int locationCategoryId, City c) {
        super(id, name, x, y, width, height, average_sick, locationCategoryId, c);
        loadImage();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, map);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    protected void loadImage() {
        ImageIcon ii = new ImageIcon("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\Covid-19 Simulator\\src\\models\\resources\\factory.png");
        image = ii.getImage();
    }

    @Override
    public void initPopulation() {
    }

    @Override
    public void save() {
        if (this.isDeleted()) {
            if (this.id != -1) {
                FactoryController.INSTANCE.delete(this.id);
                for (Tile t : this.listTile) {
                    t.setDrawable(true);
                    t.setWalking(true);
                }
                return;
            }
        }
        if (this.isNew) {
            FactoryController.INSTANCE.insert(this);
            this.isNew = false;
            this.saved = true;
        } else {
            if (!this.saved) {
                FactoryController.INSTANCE.update(this);
                this.saved = true;
            } else {

            }
        }
    }
}
