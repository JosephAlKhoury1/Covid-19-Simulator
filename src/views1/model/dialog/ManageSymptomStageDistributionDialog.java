package views1.model.dialog;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import views1.MainFrame;
import views1.model.panel.ManageSymptomStageDistributionPanel;

/**
 *
 * @author Joseph
 */
public class ManageSymptomStageDistributionDialog extends JDialog {

    MainFrame frame;
    ManageSymptomStageDistributionPanel panel;

    public ManageSymptomStageDistributionDialog(MainFrame rf) {
        super(new JFrame(), "Manage symptom stage distribution");
        this.frame = rf;
        this.setAlwaysOnTop(true);
        this.setLocation(370, 150);
        this.setSize(370, 400);
        this.setResizable(false);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent evt) {
                frame.setEnabled(true);
            }
        });
        panel = new ManageSymptomStageDistributionPanel(frame, this);
        this.add(panel);
    }

    public ManageSymptomStageDistributionPanel getPanel() {
        return panel;
    }

    public void setPanel(ManageSymptomStageDistributionPanel panel) {
        this.panel = panel;
    }

}
