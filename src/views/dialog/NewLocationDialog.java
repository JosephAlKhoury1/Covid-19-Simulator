/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.dialog;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import views.MainFrame;
import views.NewLocation;

/**
 *
 * @author Joseph
 */
public class NewLocationDialog extends JDialog {

    MainFrame frame;

    public NewLocationDialog(String name, MainFrame rf) {
        super(new JFrame(), "Sign In");
        this.frame = rf;
        this.setAlwaysOnTop(true);
        this.setLocation(370, 150);
        this.setSize(570, 470);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent evt) {
                frame.setEnabled(true);
            }
        });
        this.add(new NewLocation(name, frame, this));

    }

}
