package views1.model.dialog;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import views1.MainFrame;
import views1.model.panel.LoadModelPanel;

public class LoadModelDialog extends JDialog {

    MainFrame frame;

    public LoadModelDialog(MainFrame rf) {
        super(new JFrame(), "Load model");
        this.frame = rf;
        this.setAlwaysOnTop(true);
        this.setLocation(370, 150);
        this.setSize(470, 300);
        this.setResizable(false);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent evt) {
                frame.setEnabled(true);
            }
        });
        this.add(new LoadModelPanel(frame, this));
    }
}
