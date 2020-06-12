package views1.model.dialog;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import views1.MainFrame;
import views1.model.panel.ManageHumanAgePanel;

/**
 *
 * @author Joseph
 */
public class ManageHumanAgeDialog extends JDialog {

    MainFrame frame;

    public ManageHumanAgeDialog(MainFrame rf) {
        super(new JFrame(), "Manage human age");
        this.frame = rf;
        this.setAlwaysOnTop(true);
        this.setLocation(500, 200);
        this.setSize(360, 400);
        this.setResizable(false);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent evt) {
                frame.setEnabled(true);
            }
        });
        this.add(new ManageHumanAgePanel(frame, this));

    }

}
