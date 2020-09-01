package models.transportation1;

import java.awt.Graphics;

/**
 *
 * @author Joseph
 */
public class Taxi extends Transportation{

    public Taxi(int id, int x, int y, int width, int height, double averageSick, int numberMember) {
        super(id, x, y, width, height, averageSick, numberMember);
    }

    public Taxi() {
    }

    @Override
    protected void draw(Graphics g){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
