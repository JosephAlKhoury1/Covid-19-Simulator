package views1.city.dialog;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import views1.MainFrame;
import views1.city.panel.NewCityPanel;

/**
 *
 * @author Joseph
 */
public class NewCityDialog extends JDialog {

    MainFrame frame;

    public NewCityDialog(MainFrame rf) {
        super(new JFrame(), "New city");
        this.frame = rf;
        this.setAlwaysOnTop(true);
        this.setLocation(370, 150);
        this.setSize(405, 345);
        this.setResizable(false);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent evt) {
                frame.setEnabled(true);
            }
        });
        this.add(new NewCityPanel(frame, this));

    }

}
