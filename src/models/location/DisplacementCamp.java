/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.location;

import java.awt.Graphics;
import models.member.Member;

/**
 *
 * @author Joseph
 */
public class DisplacementCamp extends Location{

    public DisplacementCamp(int id, int x, int y, int width, int height, double average_sick) {
        super(id, x, y, width, height, average_sick);
    }

    public DisplacementCamp() {
    }

    @Override
    protected void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean isIn(Member m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
