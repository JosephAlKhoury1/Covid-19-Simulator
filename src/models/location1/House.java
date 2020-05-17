package models.location1;

import controller.locationController.HouseController;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import models.client1.Data;
import models.client1.MonteCarlo;
import models.client1.ReligionType;
import models.member1.Human;
import models.member1.Member;
import views.tile.Tile;

/**
 *
 * @author Joseph
 */
public class House extends Location {

    private int nbPopulation = 0;
    private List<Member> listPopulation;
    private ReligionType religionType;

    public House(String name, int x, int y, double average_sick, int locationCategoryId) {
        super(name, x, y, average_sick, locationCategoryId);
        this.religionType = MonteCarlo.getHouseReligionType();
        this.setWidth(LocationData.WTILEHOUSE * Data.TileWidth);
        this.setHeight(LocationData.HTILEHOUSE * Data.TileHeight);
        this.listPopulation = new ArrayList();
        loadImage();
    }

    public House(String name, int x, int y, double average_sick) {
        super(name, x, y, average_sick);
        this.setWidth(LocationData.WTILEHOUSE * Data.TileWidth);
        this.setHeight(LocationData.WTILEHOUSE * Data.TileHeight);
        this.listPopulation = new ArrayList();
        loadImage();
    }

    public House(int id, String name, int x, int y, int width, int height, double average_sick, int locationCategoryId) {
        super(id, name, x, y, width, height, average_sick, locationCategoryId);
        this.listPopulation = new ArrayList();
        loadImage();
    }

    public House() {
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, map);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    protected final void loadImage() {
        ImageIcon ii = new ImageIcon("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\Covid-19Sim\\src\\models\\resources\\house.jpg");
        image = ii.getImage();
    }

    public int getNbPopulation() {
        return nbPopulation;
    }

    public void setNbPopulation(int nbPopulation) {
        this.nbPopulation = nbPopulation;
    }

    @Override
    public void initPopulation() {
        this.nbPopulation = MonteCarlo.getHousePopulation();
        this.listPopulation.clear();
        for (int i = 0; i < nbPopulation; i++) {
            Human h = new Human(Data.numberPopulation++, x, y, this, city, this.religionType);
            addMember(h);
            this.listPopulation.add(h);
        }
    }

    public List<Member> getListPopulation() {
        return listPopulation;
    }

    public void setListPopulation(List<Member> listPopulation) {
        this.listPopulation = listPopulation;
    }

    @Override
    public void setOpenTime(double openTime) {
    }

    @Override
    public void setCloseTime(double closeTime) {
    }

    @Override
    public void save() {
        if (this.isDeleted()) {
            if (this.id != -1) {
                HouseController.INSTANCE.delete(this.id);
                for (Tile t : this.listTile) {
                    t.setDrawable(true);
                    t.setWalking(true);
                }
                return;
            }
        }
        if (this.isNew) {
            HouseController.INSTANCE.insert(this);
            this.isNew = false;
            this.saved = true;
        } else {
            if (!this.saved) {
                HouseController.INSTANCE.update(this);
                this.saved = true;
            } else {

            }
        }
    }
}
