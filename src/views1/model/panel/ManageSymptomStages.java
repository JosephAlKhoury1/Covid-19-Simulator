package views1.model.panel;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import models.model.SymptomStage;
import views1.MainFrame;
import views1.model.dialog.ManageSymptomStagesDialog;

public class ManageSymptomStages extends javax.swing.JPanel {
    
    private MainFrame frame;
    private ManageSymptomStagesDialog dialog;
    
    public ManageSymptomStages(MainFrame frame, ManageSymptomStagesDialog dialog) {
        initComponents();
        this.frame = frame;
        this.dialog = dialog;
        
        ButtonGroup group = new ButtonGroup();
        group.add(this.nonHospitalRadio);
        group.add(this.hospitalRadio);
    }
    
    public MainFrame getFrame() {
        return frame;
    }
    
    public void setFrame(MainFrame frame) {
        this.frame = frame;
    }
    
    public ManageSymptomStagesDialog getDialog() {
        return dialog;
    }
    
    public void setDialog(ManageSymptomStagesDialog dialog) {
        this.dialog = dialog;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        stageNameTxt = new javax.swing.JTextField();
        nonHospitalRadio = new javax.swing.JRadioButton();
        hospitalRadio = new javax.swing.JRadioButton();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Add Symptom Stage");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Name:");

        stageNameTxt.setToolTipText("");

        nonHospitalRadio.setSelected(true);
        nonHospitalRadio.setText("Non hospital");
        nonHospitalRadio.setToolTipText("");

        hospitalRadio.setText("Hospital");
        hospitalRadio.setToolTipText("");

        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText("Ok");
        okButton.setToolTipText("");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("This is a hospital stage ?");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stageNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(nonHospitalRadio)
                                .addGap(33, 33, 33)
                                .addComponent(hospitalRadio)))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stageNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hospitalRadio)
                    .addComponent(nonHospitalRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.frame.setEnabled(true);
        this.dialog.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String name = this.stageNameTxt.getText();
        int inHospital = 0;
        if (name.length() == 0) {
            String message = "The stage name can't be null";
            String title = "Bad stage name";
            JOptionPane.showOptionDialog(dialog, message, title, JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
        } else {
            int index;
            if (this.hospitalRadio.isSelected()) {
                inHospital = 1;
                index = frame.getCurrentModel().getListSymptomStage1sHospital().size() + frame.getCurrentModel().getListSymptomStage1sNonHospital().size() + 1;
            } else {
                inHospital = 0;
                index = frame.getCurrentModel().getListSymptomStage1sNonHospital().size() + 1;
                for (SymptomStage st : frame.getCurrentModel().getListSymptomStage1sHospital()) {
                    st.setIndex(st.getIndex() + 1);
                    st.setSaved(false);
                }
            }
            SymptomStage stage = new SymptomStage(name, 0.0, 0.0, index, inHospital, frame.getCurrentModel());
            
            this.frame.getCurrentModel().addNewSymptomStage(stage);
            frame.setModelSavedButtonEnable();
            this.frame.setEnabled(true);
            this.dialog.dispose();
        }
    }//GEN-LAST:event_okButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JRadioButton hospitalRadio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton nonHospitalRadio;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField stageNameTxt;
    // End of variables declaration//GEN-END:variables
}
