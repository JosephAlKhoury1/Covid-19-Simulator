package views1.model.dialog;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import models.model.Model;
import views1.MainFrame;
import views1.model.panel.ManageSymptomsTypePanel;

/**
 *
 * @author Joseph
 */
public class ManageSymptomTypeDialog extends JDialog {

    MainFrame frame;

    public ManageSymptomTypeDialog(MainFrame rf, Model model) {
        super(new JFrame(), "New symptom");
        this.frame = rf;
        this.setAlwaysOnTop(true);
        this.setLocation(500, 200);
        this.setSize(455, 400);
        this.setResizable(false);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent evt) {
                frame.setEnabled(true);
            }
        });
        this.add(new ManageSymptomsTypePanel(frame, this, model));

    }

}
