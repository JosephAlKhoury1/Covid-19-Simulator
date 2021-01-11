/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.transportation;

import java.awt.Graphics;


/**
 *
 * @author Joseph
 */
public class Plain extends Transportation {

    public Plain(int id, int x, int y, int width, int height, double averageSick, int numberMember) {
        super(id, x, y, width, height, averageSick, numberMember);
    }

    public Plain() {
    }

    @Override
    protected void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
