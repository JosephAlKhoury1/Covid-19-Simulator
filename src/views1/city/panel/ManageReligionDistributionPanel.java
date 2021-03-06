package views1.city.panel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import models.client.Data;
import models.client.ReligionType;
import models.model.ReligionName;
import views1.MainFrame;
import views1.city.dialog.ManageReligionGoDistributionDialog;

public class ManageReligionDistributionPanel extends javax.swing.JPanel {
    
    private MainFrame mainFrame;
    private ManageReligionGoDistributionDialog dialog;
    private List<ReligionType> listReligion;
    private List<Row> listRow;
    
    public ManageReligionDistributionPanel(MainFrame frame, ManageReligionGoDistributionDialog dialog) {
        initComponents();
        this.mainFrame = frame;
        this.dialog = dialog;
        this.listReligion = new ArrayList();
        
        for (ReligionType ha : this.mainFrame.getCurrentCity().getListrelReligionTypes()) {
            ReligionType han = new ReligionType(ha.getName(), 0.0, ha.getPrayLocation(), ha.getCity());
            han.setIsNew(false);
            han.setIsdelete(false);
            this.listReligion.add(han);
        }
        for (ReligionName rn : this.mainFrame.getListReligionName()) {
            boolean old = false;
            for (ReligionType ha : this.listReligion) {
                if (ha.getName().equals(rn.getName())) {
                    old = true;
                    break;
                }
            }
            if (!old) {
                ReligionType ha = new ReligionType(rn.getName(), 0.0, rn.getPrayLocation(), this.mainFrame.getCurrentCity());
                ha.setIsNew(true);
                ha.setIsdelete(false);
                this.listReligion.add(ha);
            }
        }
        this.listRow = new ArrayList();
        initMainPanel();
    }
    
    private void initMainPanel() {
        this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS));
        this.mainPanel.setPreferredSize(new Dimension(200, this.listReligion.size() * 38));
        for (ReligionType ha : this.listReligion) {
            Row r = new Row(ha);
            this.mainPanel.add(r);
            this.mainPanel.add(Box.createVerticalStrut(3));
            this.listRow.add(r);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(250, 387));

        jLabel1.setText("Manage the age distribution");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jPanel2.setPreferredSize(new java.awt.Dimension(300, 253));

        mainPanel.setPreferredSize(new java.awt.Dimension(160, 291));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainPanel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
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
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.mainFrame.setEnabled(true);
        this.dialog.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        this.mainFrame.getCurrentCity().removeReligion(this.listReligion);
        this.mainFrame.getCurrentCityPanel().updateReligionPanel();
        this.mainFrame.getCurrentCity().setIsSaved(false);
        this.mainFrame.setCitySavedButtonEnable();
        this.mainFrame.setEnabled(true);
        this.mainFrame.repaint();
        this.dialog.dispose();
    }//GEN-LAST:event_okButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
  private class Row extends JPanel {
        
        private ReligionType loc;
        private JCheckBox box;
        
        public Row(ReligionType h) {
            this.loc = h;
            init();
        }
        
        private void init() {
            box = new JCheckBox(this.loc.getName());
            box.setPreferredSize(new Dimension(140, 31));
            box.setMinimumSize(new Dimension(140, 31));
            box.setMaximumSize(new Dimension(140, 31));
            box.setAlignmentX(Component.LEFT_ALIGNMENT);
            this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            if (!this.loc.isIsNew()) {
                box.setSelected(true);
            } else {
                box.setSelected(false);
            }
            box.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boxEvent();
                }
            });
            this.setBorder(BorderFactory.createEtchedBorder());
            this.setPreferredSize(new Dimension(200, 35));
            this.setMaximumSize(new Dimension(220, 35));
            this.setMinimumSize(new Dimension(220, 35));
            this.setAlignmentX(Component.LEFT_ALIGNMENT);
            this.add(box);
        }
        
        private void boxEvent() {
            if (this.box.isSelected()) {
                this.loc.setIsdelete(false);
                this.loc.setIsSaved(false);
            } else {
                this.loc.setIsdelete(true);
                this.loc.setIsSaved(false);
            }
            okButton.setEnabled(true);
        }
    }
}
