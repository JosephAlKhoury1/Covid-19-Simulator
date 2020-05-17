package views.dialog1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import models.model.Model;
import views1.MainFrame;
import views1.SaveModelPanel;

/**
 *
 * @author Joseph
 */
public class SaveModelDialog extends JDialog {

    MainFrame frame;

    public SaveModelDialog(MainFrame rf, Model m) {
        super(new JFrame(), "Save the model");
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
        this.add(new SaveModelPanel(frame, this, m));

    }

}
