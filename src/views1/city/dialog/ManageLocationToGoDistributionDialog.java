package views1.city.dialog;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import views1.MainFrame;
import views1.city.panel.ManageLocattionToGoDistributionPanel;

/**
 *
 * @author Joseph
 */
public class ManageLocationToGoDistributionDialog extends JDialog {

    MainFrame frame;

    public ManageLocationToGoDistributionDialog(MainFrame rf) {
        super(new JFrame(), "Manage Location To Go");
        this.frame = rf;
        this.setAlwaysOnTop(true);
        this.setLocation(500, 200);
        this.setSize(250, 400);
        this.setResizable(false);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent evt) {
                frame.setEnabled(true);
            }
        });
        this.add(new ManageLocattionToGoDistributionPanel(frame, this));

    }

}
