package views1.model.panel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import models.model.SymptomStage;
import models.model.SymptomStageName;
import views1.MainFrame;
import views1.model.dialog.ManageSymptomStageDistributionDialog;

public class ManageSymptomStageDistributionPanel extends javax.swing.JPanel {

    private MainFrame frame;
    private ManageSymptomStageDistributionDialog dialog;
    private List<SymptomStage> listSymptomStages;

    private Map<SymptomStage, Row> listRow;
    private int currentIndex = 0;

    public ManageSymptomStageDistributionPanel(MainFrame frame, ManageSymptomStageDistributionDialog dialog) {
        initComponents();
        this.frame = frame;
        this.dialog = dialog;
        //this.listToAdd = new HashMap();
        this.listSymptomStages = new ArrayList();
        for (SymptomStage st : frame.getCurrentModel().getListSymptomStage1s()) {
            SymptomStage ss = new SymptomStage(st.getName(), st.getDeathPercentage(), st.getImmunePercentage(), st.getIndex(), st.getInHospital(),frame.getCurrentModel());
            ss.setIsNew(false);
            ss.setDeleted(false);
            this.listSymptomStages.add(ss);
            this.currentIndex++;
        }
        for (SymptomStageName ssn : frame.getListSymptomStageNames()) {
            boolean old = false;
            for (SymptomStage st : this.listSymptomStages) {
                if (st.getName().equals(ssn.getName())) {
                    old = true;
                    break;
                } else {
                    old = false;
                }
            }
            if (!old) {
                SymptomStage ss = new SymptomStage(ssn.getName(), 0.0, 0.0, -1,ssn.getInHospital(), frame.getCurrentModel());
                ss.setIsNew(true);
                ss.setDeleted(true);
                this.listSymptomStages.add(ss);
            }
        }
        listRow = new HashMap();
        iniSymptomPanel2();
    }

    private void iniSymptomPanel2() {
        this.symptomPanel.setLayout(new BoxLayout(this.symptomPanel, BoxLayout.Y_AXIS));
        this.symptomPanel.setPreferredSize(new Dimension(this.symptomPanel.getWidth(), this.listSymptomStages.size() * 40));
        for (SymptomStage st : this.listSymptomStages) {
//            if (ss.getIndex() != -1) {
//                this.listToAdd.put(ss.getIndex(), ss);
//            }
            Row r = new Row(st);
            this.listRow.put(st, r);
            this.symptomPanel.add(r.getPanel());
            this.symptomPanel.add(r.getC());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        symptomPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        jLabel1.setText("Manage the symptom stages distribution");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        symptomPanel.setPreferredSize(new java.awt.Dimension(200, 283));

        javax.swing.GroupLayout symptomPanelLayout = new javax.swing.GroupLayout(symptomPanel);
        symptomPanel.setLayout(symptomPanelLayout);
        symptomPanelLayout.setHorizontalGroup(
            symptomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );
        symptomPanelLayout.setVerticalGroup(
            symptomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(symptomPanel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText("Ok");
        okButton.setToolTipText("");
        okButton.setEnabled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 103, Short.MAX_VALUE)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        frame.getCurrentModel().removeSymptomStage(listSymptomStages);
        frame.getCurrentModelPanel().updateSymptomeStagePanel();
        frame.setModelSavedButtonEnable();
        frame.setEnabled(true);
        frame.repaint();
        dialog.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.frame.setEnabled(true);
        this.dialog.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel symptomPanel;
    // End of variables declaration//GEN-END:variables
    private class Row {

        private SymptomStage symptomStage;
        private JCheckBox box;
        private JTextField jtxt;
        private JPanel panel;
        private Component c;
        private int index;

        public Row(SymptomStage stage) {
            this.symptomStage = stage;
            this.index = this.symptomStage.getIndex();
            this.c = Box.createVerticalStrut(3);
            panel = new JPanel();
            panel.setPreferredSize(new Dimension(198, 40));
            panel.setMaximumSize(new Dimension(198, 40));
            panel.setMaximumSize(new Dimension(198, 40));
            panel.setBorder(BorderFactory.createEtchedBorder());
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

            box = new JCheckBox();
            box.setText(this.symptomStage.getName());
            box.setPreferredSize(new Dimension(120, 37));
            box.setMaximumSize(new Dimension(120, 37));
            box.setMaximumSize(new Dimension(120, 37));
            box.setHorizontalAlignment(SwingConstants.CENTER);
            box.setToolTipText("");
            box.setAlignmentX(Component.LEFT_ALIGNMENT);
            box.setBorder(BorderFactory.createEtchedBorder());
            if (symptomStage.getIndex() != -1) {
                box.setSelected(true);
            } else {
                box.setSelected(false);
            }
            box.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    checkBoxActionEvent();
                }
            });
            panel.add(box);

            Component c1 = Box.createHorizontalStrut(10);
            panel.add(c1);

            jtxt = new JTextField();
            jtxt.setPreferredSize(new Dimension(45, 37));
            jtxt.setMaximumSize(new Dimension(45, 37));
            jtxt.setMaximumSize(new Dimension(45, 37));
            jtxt.setHorizontalAlignment(SwingConstants.CENTER);
            jtxt.setToolTipText("");
            jtxt.setAlignmentX(Component.LEFT_ALIGNMENT);
            jtxt.setBorder(BorderFactory.createEtchedBorder());
            jtxt.setEnabled(false);

            panel.add(jtxt);
            if (symptomStage.getIndex() != -1) {
                jtxt.setText(symptomStage.getIndex() + "");
            }
        }

        public SymptomStage getSymptomStage() {
            return symptomStage;
        }

        public void setSymptomStage(SymptomStage symptomStage) {
            this.symptomStage = symptomStage;
        }

        public JCheckBox getBox() {
            return box;
        }

        public void setBox(JCheckBox box) {
            this.box = box;
        }

        public JTextField getJtxt() {
            return jtxt;
        }

        public void setJtxt(JTextField jtxt) {
            this.jtxt = jtxt;
        }

        public JPanel getPanel() {
            return panel;
        }

        public void setPanel(JPanel panel) {
            this.panel = panel;
        }

        public Component getC() {
            return c;
        }

        public void setC(Component c) {
            this.c = c;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void checkBoxActionEvent() {
            if (this.box.isSelected()) {
                this.symptomStage.setIndex(currentIndex);
                currentIndex++;
                this.jtxt.setText(this.symptomStage.getIndex() + "");
                this.symptomStage.setDeleted(false);
            } else {
                this.symptomStage.setIndex(-1);
                this.symptomStage.setDeleted(true);
                for (SymptomStage ss : listSymptomStages) {
                    if (ss.getIndex() > index) {
                        ss.setIndex(ss.getIndex() - 1);
                        listRow.get(ss).getJtxt().setText(ss.getIndex() + "");
                        listRow.get(ss).setIndex(ss.getIndex());
                    }
                }
                currentIndex--;
                this.index = -1;
                this.jtxt.setText("");

            }
            okButton.setEnabled(true);
        }

    }

}
