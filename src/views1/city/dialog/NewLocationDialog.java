package views1.city.dialog;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import views1.MainFrame;
import views1.city.panel.NewLocation;

/**
 *
 * @author Joseph
 */
public class NewLocationDialog extends JDialog {

    MainFrame frame;

    public NewLocationDialog(String name, MainFrame rf) {
        super(new JFrame(), "New Location");
        this.frame = rf;
        this.setAlwaysOnTop(true);
        this.setLocation(370, 150);
        this.setSize(514, 430);
        this.setResizable(false);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent evt) {
                frame.setEnabled(true);
            }
        });
        this.add(new NewLocation(name, frame, this));

    }

}
