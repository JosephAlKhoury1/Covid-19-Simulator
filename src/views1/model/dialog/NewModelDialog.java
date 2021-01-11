package views1.model.dialog;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import views1.MainFrame;
import views1.model.panel.NewModelPanel;

/**
 *
 * @author Joseph
 */
public class NewModelDialog extends JDialog {

    MainFrame frame;

    public NewModelDialog(MainFrame rf) {
        super(new JFrame(), "New model");
        this.frame = rf;
        this.setAlwaysOnTop(true);
        this.setLocation(370, 150);
        this.setSize(545, 475);
        this.setResizable(false);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent evt) {
                frame.setEnabled(true);
            }
        });
        this.add(new NewModelPanel(frame, this));
    }
}
