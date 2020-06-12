package views1.model.dialog;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import views1.MainFrame;
import views1.model.panel.ManageSymptomStagePanel;
import views1.model.panel.ManageSymptomTypePanel;

/**
 *
 * @author Joseph
 */
public class ManageSymptomStageDialog extends JDialog {

    MainFrame frame;

    public ManageSymptomStageDialog(MainFrame rf) {
        super(new JFrame(), "New symptom");
        this.frame = rf;
        this.setAlwaysOnTop(true);
        this.setLocation(500, 200);
        this.setSize(300, 400);
        this.setResizable(false);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent evt) {
                frame.setEnabled(true);
            }
        });
        this.add(new ManageSymptomStagePanel(frame, this));

    }

}
