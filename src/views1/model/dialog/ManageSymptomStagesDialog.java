package views1.model.dialog;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import models.model.Model;
import views1.MainFrame;
import views1.model.panel.ManageSymptomStages;

/**
 *
 * @author Joseph
 */
public class ManageSymptomStagesDialog extends JDialog {

    MainFrame frame;

    public ManageSymptomStagesDialog(MainFrame rf, Model model) {
        super(new JFrame(), "New symptom Stage");
        this.frame = rf;
        this.setAlwaysOnTop(true);
        this.setLocation(500, 200);
        this.setSize(410, 405);
        this.setResizable(false);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent evt) {
                frame.setEnabled(true);
            }
        });
        this.add(new ManageSymptomStages(frame, this, model));

    }

}
