package models.transportation;

import java.awt.Graphics;

/**
 *
 * @author Joseph
 */
public class Bus extends Transportation {

    public Bus(int id, int x, int y, int width, int height, double averageSick, int numberMember) {
        super(id, x, y, width, height, averageSick, numberMember);
    }

    public Bus() {
    }

    @Override
    protected void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
