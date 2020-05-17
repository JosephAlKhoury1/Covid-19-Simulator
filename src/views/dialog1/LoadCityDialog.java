package views.dialog1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import views1.LoadCityPanel;
import views1.MainFrame;

/**
 *
 * @author Joseph
 */
public class LoadCityDialog extends JDialog {

    MainFrame frame;

    public LoadCityDialog(MainFrame rf) {
        super(new JFrame(), "Load city");
        this.frame = rf;
        this.setAlwaysOnTop(true);
        this.setLocation(370, 150);
        this.setSize(460, 200);
        this.setResizable(false);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent evt) {
                frame.setEnabled(true);
            }
        });
        this.add(new LoadCityPanel(frame, this));

    }

}
