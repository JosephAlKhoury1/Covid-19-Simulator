package views.dialog1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import views1.MainFrame;
import views1.NewLocation;

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
        this.setSize(470, 440);
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
