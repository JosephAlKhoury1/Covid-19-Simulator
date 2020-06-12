package views1.model.panel;

import controller.controllers.HumanStateNameController;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import models.model.HumanStatName;
import models.model.Model;
import models.model.SymptomStage;
import views1.MainFrame;
import views1.model.dialog.ManageHumanStateDialog;

public class ManageHumanStatPanel extends javax.swing.JPanel implements ListSelectionListener {

    private MainFrame frame;
    private ManageHumanStateDialog dialog;
    private String newName;
    private String colorName;
    private List<HumanStatName> listSymptomNames;

    private JList<String> listSymptoms;
    private final DefaultListModel<String> listModel;

    private List<HumanStatName> listAdded;
    private List<HumanStatName> listRemoved;

    private String[] colorTabName = {"Red", "Green", "Black", "Orange", "Blue", "Yellow", "Pink", "Gray", "Cyan", "Magenta"};

    public ManageHumanStatPanel(MainFrame frame, ManageHumanStateDialog dialog) {
        initComponents();
        this.frame = frame;
        this.dialog = dialog;
        this.listAdded = new ArrayList();
        this.listRemoved = new ArrayList();
        listSymptomNames = frame.getListHumanStatName();
        this.colorName = "Red";

        listModel = new DefaultListModel();

        listSymptoms = new JList(listModel);
        listSymptoms.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSymptoms.setSelectedIndex(0);
        listSymptoms.addListSelectionListener(this);
        listSymptoms.setVisibleRowCount(JList.VERTICAL);
        listSymptoms.setFont(new Font("Arial", Font.BOLD, 14));
        jPanel2.setLayout(new BorderLayout());
        JScrollPane listScrollPane = new JScrollPane(listSymptoms);
        jPanel2.add(listScrollPane);
        for (HumanStatName sn : listSymptomNames) {
            int index = listSymptoms.getSelectedIndex();
            if (index == -1) {
                index = 0;
            } else {
                index++;
            }
            this.listModel.insertElementAt(sn.getName(), index);
            this.listSymptoms.setSelectedIndex(index);
            this.listSymptoms.ensureIndexIsVisible(index);
            this.removeButton.setEnabled(true);
        }
        if (listSymptomNames.size() == 1) {
            this.removeButton.setEnabled(false);
        }

        AddListener addListener = new AddListener(addButton);
        this.addButton.addActionListener(addListener);
        this.nameTxt.addActionListener(addListener);
        this.nameTxt.getDocument().addDocumentListener(addListener);
        RemoveListener removeListener = new RemoveListener();
        this.removeButton.addActionListener(removeListener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        nameTxt = new javax.swing.JTextField();
        jComboBox1 = new JComboBox(this.colorTabName)
        ;
        removeButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();

        jPanel1.setPreferredSize(new java.awt.Dimension(290, 31));

        jLabel1.setText("Manage symptoms ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 146, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setMinimumSize(new java.awt.Dimension(205, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(290, 37));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setPreferredSize(new java.awt.Dimension(290, 35));

        nameTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameTxt.setToolTipText("");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
            .addComponent(jComboBox1)
        );

        removeButton.setText("Remove");
        removeButton.setToolTipText("");

        addButton.setText("Add");
        addButton.setToolTipText("");
        addButton.setPreferredSize(new java.awt.Dimension(71, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 174, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.frame.setEnabled(true);
        dialog.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        for (HumanStatName sn : listAdded) {
            frame.getListHumanStatName().add(sn);
            sn.setId(HumanStateNameController.INSTANCE.insert(sn));
        }
        for (HumanStatName sn : listRemoved) {
            frame.getListHumanStatName().remove(sn);
            HumanStateNameController.INSTANCE.delete(sn.getId());
        }
        frame.setHumanStatTab(new String[frame.getListHumanStatName().size()]);
        for (int i = 0; i < frame.getListHumanStatName().size(); i++) {
            frame.getHumanStatTab()[i] = frame.getListHumanStatName().get(i).getName();
        }
        for (Model m : frame.getListModel()) {
            for (SymptomStage ss : m.getListSymptomStage()) {
                String selected = ss.getHumanStatBox().getItemAt(ss.getHumanStatBox().getSelectedIndex());
                ss.getHumanStatBox().removeAllItems();
                int index = 0;
                for (int j = 0; j < frame.getHumanStatTab().length; j++) {
                    ss.getHumanStatBox().addItem(frame.getHumanStatTab()[j]);
                    if (selected.equals(frame.getHumanStatTab()[j])) {
                        index = j;
                    }
                }
                ss.getHumanStatBox().setSelectedIndex(index);
                ss.getHumanStatBox().revalidate();
                ss.getHumanStatBox().repaint();
            }
        }
        frame.setEnabled(true);
        dialog.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        this.colorName = this.jComboBox1.getItemAt(this.jComboBox1.getSelectedIndex());
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JButton okButton;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables

    private class AddListener implements ActionListener, DocumentListener {

        private JButton button;
        private boolean isEnabled = false;

        public AddListener(JButton button) {
            this.button = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            newName = nameTxt.getText();
            if (newName.equals("") || newName.startsWith(" ") || alreadyInList(newName)) {
                Toolkit.getDefaultToolkit().beep();
                nameTxt.requestFocusInWindow();
                nameTxt.selectAll();
            } else {
                listAdded.add(new HumanStatName(newName, colorName));
                listModel.insertElementAt(newName, listModel.getSize());
                listSymptoms.setSelectedIndex(listModel.getSize() - 1);
                listSymptoms.ensureIndexIsVisible(listModel.getSize() - 1);
                nameTxt.setText("");
                removeButton.setEnabled(true);
                okButton.setEnabled(true);
            }
        }

        protected boolean alreadyInList(String name) {
            for (HumanStatName sn : listSymptomNames) {
                if (sn.getName().equals(name)) {
                    return true;
                }
            }
            for (HumanStatName sn : listAdded) {
                if (sn.getName().equals(name)) {
                    return true;
                }
            }
            return false;
        }

        private void enableButton() {
            if (!isEnabled) {
                button.setEnabled(true);
            }
        }

        private boolean handleEmptyField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                button.setEnabled(false);
                isEnabled = false;
                return true;
            }
            return false;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            enableButton();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            handleEmptyField(e);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyField(e)) {
                enableButton();
            }
        }

    }

    private class RemoveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int index = listSymptoms.getSelectedIndex();
            if (index == 0) {
                return;
            }
            String name = listSymptoms.getSelectedValue();
            String message = "Are you sure you want to delete the Symptom " + name + "?";
            String title = "Delete location";
            if (JOptionPane.showOptionDialog(dialog, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null) == JOptionPane.NO_OPTION) {
                return;
            }
            HumanStatName removedSym = null;
            for (HumanStatName sn : listSymptomNames) {
                if (sn.getName().equals(name)) {
                    removedSym = sn;
                    break;
                }
            }
            for (HumanStatName sn : listAdded) {
                if (sn.getName().equals(name)) {
                    removedSym = sn;
                }
            }
            if (listAdded.contains(removedSym)) {
                listAdded.remove(removedSym);
            } else {
                listRemoved.add(removedSym);
            }
            listModel.remove(index);
            int size = listModel.getSize();
            if (size == 1) {
                removeButton.setEnabled(false);
            } else {
                if (index == listModel.getSize()) {
                    index--;
                }
                listSymptoms.setSelectedIndex(index);
                listSymptoms.ensureIndexIsVisible(index);
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
//        String name = listLocation.getSelectedValue();
//        if (mapLocation.get(name) != null) {
//            locationPropertiesPanel.add(mapLocation.get(name));
//        }
//        locationPropertiesPanel.repaint();
//        mainFrame.setVisible(true);
    }
}
