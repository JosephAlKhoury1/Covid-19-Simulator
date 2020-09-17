package views1.model.panel;

import controller.controllers.ModelController;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import resources.icon.Messages;
import views1.MainFrame;
import views1.model.dialog.NewModelDialog;

public class NewModelPanel extends javax.swing.JPanel {

    private final MainFrame mainframe;
    private final NewModelDialog dialog;
    private Map<Integer, String> list;
    private String name;

    public NewModelPanel(MainFrame frame, NewModelDialog dialog) {
        initComponents();
        this.mainframe = frame;
        this.dialog = dialog;
        list = ModelController.INSTANCE.selectAll();
        this.errorLabel.setVisible(false);

        int index = 0;
        for (Entry<Integer, String> e : list.entrySet()) {
            if (e.getValue().length() >= 9) {
                if (e.getValue().substring(0, 9).equals("new model")) {
                    index++;
                }
            } else {
                if (e.getValue().substring(0).equals("new model")) {
                    index++;
                }
            }
        }
        if (index == 0) {
            name = "new model";
        } else {
            name = "new model" + index;
        }
        modelNameTxt.setText(name);
        JTextFieldStringListener listener = new JTextFieldStringListener(modelNameTxt);
        this.modelNameTxt.getDocument().addDocumentListener(listener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        modelNameTxt = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        createButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Create a new Model:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Name:");

        modelNameTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        modelNameTxt.setToolTipText("");

        errorLabel.setBackground(new java.awt.Color(255, 255, 255));
        errorLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/error icon.png"))); // NOI18N
        errorLabel.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modelNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(errorLabel)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        createButton.setText("Create");
        createButton.setToolTipText("create the model");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/help icon.jpg"))); // NOI18N
        jLabel3.setText(Messages.getCreatModelHelpMessage());
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.mainframe.setEnabled(true);
        this.dialog.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        mainframe.newModel(this.name);
        mainframe.setEnabled(true);
        dialog.dispose();
    }//GEN-LAST:event_createButtonActionPerformed

    private class JTextFieldStringListener implements DocumentListener {

        private JTextField jtextField;

        public JTextFieldStringListener(JTextField textField) {
            this.jtextField = textField;
        }

        protected boolean alreadyExist(String name) {
            for (Entry<Integer, String> e : list.entrySet()) {
                if (e.getValue().equals(name)) {
                    return true;

                }
            }
            return false;
        }

        private boolean handleEmptyField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                return true;
            }
            return false;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            if (alreadyExist(jtextField.getText())) {
                createButton.setEnabled(false);
                errorLabel.setText(Messages.getCreatModelExistErrorMessage());
                errorLabel.setVisible(true);
            } else if (jtextField.getText().startsWith(" ")) {
                createButton.setEnabled(false);
                errorLabel.setText(Messages.getCreateModelStartSpaceErrorMessage());
                errorLabel.setVisible(true);
            } else {
                createButton.setEnabled(true);
                errorLabel.setVisible(false);
                name = jtextField.getText();
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if (handleEmptyField(e)) {
                createButton.setEnabled(false);
                errorLabel.setText(Messages.getCreatModelNullErrorMessage());
                errorLabel.setVisible(true);
            } else {
                if (alreadyExist(jtextField.getText())) {
                    createButton.setEnabled(false);
                    errorLabel.setText(Messages.getCreatModelExistErrorMessage());
                    errorLabel.setVisible(true);
                } else if (jtextField.getText().startsWith(" ")) {
                    createButton.setEnabled(false);
                    errorLabel.setText(Messages.getCreateModelStartSpaceErrorMessage());
                    errorLabel.setVisible(true);
                } else {
                    createButton.setEnabled(true);
                    errorLabel.setVisible(false);
                    name = jtextField.getText();
                }
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            if (handleEmptyField(e)) {
                createButton.setEnabled(false);
                errorLabel.setText(Messages.getCreatModelNullErrorMessage());
                errorLabel.setVisible(true);
            } else {
                if (alreadyExist(jtextField.getText())) {
                    createButton.setEnabled(false);
                    errorLabel.setText(Messages.getCreatModelExistErrorMessage());
                    errorLabel.setVisible(true);
                } else {
                    createButton.setEnabled(true);
                    errorLabel.setVisible(false);
                    name = jtextField.getText();
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton createButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField modelNameTxt;
    // End of variables declaration//GEN-END:variables
}
