package models.model;

import java.awt.Component;

public class HumanModelAgeType extends javax.swing.JPanel {

    public HumanModelAgeType() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nameTxt = new javax.swing.JTextField();
        minAgeTxt = new javax.swing.JTextField();
        maxAgeTxt = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(32767, 35));
        setMinimumSize(new java.awt.Dimension(0, 35));
        setPreferredSize(new java.awt.Dimension(400, 35));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setAlignmentX(Component.LEFT_ALIGNMENT);
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 35));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 35));

        nameTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameTxt.setToolTipText("");
        nameTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
        nameTxt.setMaximumSize(new java.awt.Dimension(110, 31));
        nameTxt.setMinimumSize(new java.awt.Dimension(110, 31));
        nameTxt.setPreferredSize(new java.awt.Dimension(110, 31));

        minAgeTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        minAgeTxt.setText("0");
        minAgeTxt.setToolTipText("");
        minAgeTxt.setMaximumSize(new java.awt.Dimension(50, 31));
        minAgeTxt.setMinimumSize(new java.awt.Dimension(50, 31));
        minAgeTxt.setPreferredSize(new java.awt.Dimension(50, 31));

        maxAgeTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        maxAgeTxt.setText("0");
        maxAgeTxt.setToolTipText("");
        maxAgeTxt.setMaximumSize(new java.awt.Dimension(50, 31));
        maxAgeTxt.setMinimumSize(new java.awt.Dimension(50, 31));
        maxAgeTxt.setPreferredSize(new java.awt.Dimension(50, 31));

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("0.0");
        jTextField1.setMaximumSize(new java.awt.Dimension(110, 31));
        jTextField1.setMinimumSize(new java.awt.Dimension(110, 31));
        jTextField1.setPreferredSize(new java.awt.Dimension(110, 31));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minAgeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maxAgeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 257, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minAgeTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(maxAgeTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField maxAgeTxt;
    private javax.swing.JTextField minAgeTxt;
    private javax.swing.JTextField nameTxt;
    // End of variables declaration//GEN-END:variables
}
