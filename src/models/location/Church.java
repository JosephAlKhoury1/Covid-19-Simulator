package models.location;

import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import models.client.City;
import static models.location.LocationData.*;

/**
 *
 * @author Joseph
 */
public class Church extends Location {

    public Church(int x, int y, double average_sick, JPanel panel, City city) {
        super(x, y, WTILECHURCH, HTILECHURCH, average_sick, panel, city);
        loadImage();
    }

    public Church() {
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, panel);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    protected void loadImage() {
        ImageIcon ii = new ImageIcon("C:\\Users\\Joseph\\Documents\\NetBeansProjects\\Covid-19Sim\\src\\models\\resources\\Church.png");
        image = ii.getImage();
    }

    @Override
    public void initPopulation() {
    }

}
