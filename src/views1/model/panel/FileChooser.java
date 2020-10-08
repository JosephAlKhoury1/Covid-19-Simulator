package views1.model.panel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.JFileChooser;

public class FileChooser extends javax.swing.JPanel {

    File file;

    public FileChooser(String defaultName) {
        initComponents();

        String ff = "C:\\Users\\Joseph\\Documents\\";
        file = null;
        int o = 0;
        String fileName;
        while (true) {
            if (o == 0) {
                fileName = ff + defaultName + ".xls";
                file = new File(fileName);
                if (!file.exists()) {
                    break;
                } else {
                    o++;
                }
            } else {
                fileName = ff + defaultName + o + ".xls";
                file = new File(fileName);
                if (!file.exists()) {
                    break;
                } else {
                    o++;
                }
            }
        }
        j.setSelectedFile(file);

        j.addPropertyChangeListener(JFileChooser.DIRECTORY_CHANGED_PROPERTY,
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String path = j.getCurrentDirectory().getAbsolutePath() + "\\";
                int o = 0;
                String fileName;
                while (true) {
                    if (o == 0) {
                        fileName = path + defaultName + ".xls";
                        file = new File(fileName);
                        if (!file.exists()) {
                            break;
                        } else {
                            o++;
                        }
                    } else {
                        fileName = path + defaultName + "(" + o + ")" + ".xls";
                        file = new File(fileName);
                        if (!file.exists()) {
                            break;
                        } else {
                            o++;
                        }
                    }
                }

                j.setSelectedFile(file);

                j.updateUI();
            }
        });
    }

    public File getFile() {
        return file;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        j = new JFileChooser();

        j.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        j.setDialogTitle("");
        j.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        j.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        j.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JFileChooser j;
    // End of variables declaration//GEN-END:variables
}
