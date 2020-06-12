package views1.model.panel;

import controller.controllers.HumanAgeNameController;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import models.model.HumanAgeName;
import views1.MainFrame;
import views1.model.dialog.ManageHumanAgeDialog;

public class ManageHumanAgePanel extends javax.swing.JPanel implements ListSelectionListener {

    private MainFrame frame;
    private ManageHumanAgeDialog dialog;
    private String newName;
    private List<HumanAgeName> listHumanAgeNames;

    private JList<String> listHumanAge;
    private final DefaultListModel<String> listModel;

    private List<HumanAgeName> listAdded;
    private List<HumanAgeName> listRemoved;

    private int minAge = 0, maxAge = 1;

    public ManageHumanAgePanel(MainFrame frame, ManageHumanAgeDialog dialog) {
        initComponents();
        this.frame = frame;
        this.dialog = dialog;
        this.listAdded = new ArrayList();
        this.listRemoved = new ArrayList();
        listHumanAgeNames = frame.getListHumanAgeName();

        listModel = new DefaultListModel();

        listHumanAge = new JList(listModel);
        listHumanAge.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listHumanAge.setSelectedIndex(0);
        listHumanAge.addListSelectionListener(this);
        listHumanAge.setVisibleRowCount(JList.VERTICAL);
        listHumanAge.setFont(new Font("Arial", Font.BOLD, 14));
        jPanel2.setLayout(new BorderLayout());
        JScrollPane listScrollPane = new JScrollPane(listHumanAge);
        jPanel2.add(listScrollPane);
        for (HumanAgeName sn : listHumanAgeNames) {
            int index = listHumanAge.getSelectedIndex();
            if (index == -1) {
                index = 0;
            } else {
                index++;
            }
            this.listModel.insertElementAt(sn.getName(), index);
            this.listHumanAge.setSelectedIndex(index);
            this.listHumanAge.ensureIndexIsVisible(index);
            this.removeButton.setEnabled(true);
        }

        AddListener addListener = new AddListener(addButton);
        this.addButton.addActionListener(addListener);
        this.nameTxt.addActionListener(addListener);
        this.nameTxt.getDocument().addDocumentListener(addListener);
        RemoveListener removeListener = new RemoveListener();
        this.removeButton.addActionListener(removeListener);

        JTextFieldMinIntegerListener minList = new JTextFieldMinIntegerListener(this.minAgeTxt, this.maxAgeTxt, this.minAge);
        this.minAgeTxt.addFocusListener(minList);
        this.minAgeTxt.getDocument().addDocumentListener(minList);

        JTextFieldMaxIntegerListener maxList = new JTextFieldMaxIntegerListener(this.maxAgeTxt, this.minAgeTxt, this.maxAge);
        this.maxAgeTxt.addFocusListener(maxList);
        this.maxAgeTxt.getDocument().addDocumentListener(maxList);
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
        minAgeTxt = new javax.swing.JTextField();
        maxAgeTxt = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();

        jLabel1.setText("Manage human age");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setMinimumSize(new java.awt.Dimension(225, 0));
        jPanel2.setName(""); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(243, 275));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 239, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(320, 37));

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
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
            .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        nameTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameTxt.setToolTipText("");

        minAgeTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        minAgeTxt.setText("0");
        minAgeTxt.setToolTipText("");
        minAgeTxt.setEnabled(false);

        maxAgeTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        maxAgeTxt.setText("1");
        maxAgeTxt.setToolTipText("");
        maxAgeTxt.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(nameTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minAgeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maxAgeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(minAgeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(maxAgeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        addButton.setText("Add");
        addButton.setToolTipText("");
        addButton.setPreferredSize(new java.awt.Dimension(105, 23));

        removeButton.setText("Remove");
        removeButton.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 1, Short.MAX_VALUE))
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
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
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
        for (HumanAgeName sn : listAdded) {
            frame.getListHumanAgeName().add(sn);
            sn.setId(HumanAgeNameController.INSTANCE.insert(sn));
        }
        for (HumanAgeName sn : listRemoved) {
            frame.getListHumanAgeName().remove(sn);
            HumanAgeNameController.INSTANCE.delete(sn.getId());
        }
        frame.setEnabled(true);
        dialog.dispose();
    }//GEN-LAST:event_okButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField maxAgeTxt;
    private javax.swing.JTextField minAgeTxt;
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
                maxAgeTxt.setEnabled(false);
                minAgeTxt.setEnabled(false);
            } else {
                listAdded.add(new HumanAgeName(newName, minAge, maxAge));
                listModel.insertElementAt(newName, listModel.getSize());
                listHumanAge.setSelectedIndex(listModel.getSize() - 1);
                listHumanAge.ensureIndexIsVisible(listModel.getSize() - 1);
                removeButton.setEnabled(true);
                okButton.setEnabled(true);
                nameTxt.setText("");
                nameTxt.requestFocusInWindow();
                nameTxt.selectAll();
                System.out.println("min age = " + minAge);
                System.out.println("max age = " + maxAge);
            }
        }

        protected boolean alreadyInList(String name) {
            for (HumanAgeName sn : listHumanAgeNames) {
                if (sn.getName().equals(name)) {
                    return true;
                }
            }
            for (HumanAgeName sn : listAdded) {
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
                maxAgeTxt.setEnabled(false);
                minAgeTxt.setEnabled(false);
                isEnabled = false;
                return true;
            }
            return false;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            enableButton();
            maxAgeTxt.setEnabled(true);
            minAgeTxt.setEnabled(true);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            handleEmptyField(e);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyField(e)) {
                enableButton();
                maxAgeTxt.setEnabled(true);
                minAgeTxt.setEnabled(true);
            }
        }

    }

    private class RemoveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int index = listHumanAge.getSelectedIndex();
            String name = listHumanAge.getSelectedValue();
            String message = "Are you sure you want to delete the Symptom " + name + "?";
            String title = "Delete location";
            if (JOptionPane.showOptionDialog(dialog, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null) == JOptionPane.NO_OPTION) {
                return;
            }
            HumanAgeName removedSym = null;
            for (HumanAgeName sn : listHumanAgeNames) {
                if (sn.getName().equals(name)) {
                    removedSym = sn;
                    break;
                }
            }
            for (HumanAgeName sn : listAdded) {
                if (sn.getName().equals(name)) {
                    removedSym = sn;
                    break;
                }
            }
            if (listAdded.contains(removedSym)) {
                listAdded.remove(removedSym);
            } else {
                listRemoved.add(removedSym);
            }
            listModel.remove(index);
            int size = listModel.getSize();
            if (size == 0) {
                removeButton.setEnabled(false);
            } else {
                if (index == listModel.getSize()) {
                    index--;
                }
                listHumanAge.setSelectedIndex(index);
                listHumanAge.ensureIndexIsVisible(index);
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

    private class JTextFieldMinIntegerListener implements DocumentListener, FocusListener {

        private JTextField jtextField;
        private JTextField jTextField2;
        private MainFrame mainFrame;
        private String currentString;
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = true;

        public JTextFieldMinIntegerListener(JTextField textField, JTextField txt, int value) {
            this.jtextField = textField;
            this.jTextField2 = txt;
            this.currentString = value + "";
        }

        private void insertZero(String s) {
            Runnable doHighlight = new Runnable() {
                @Override
                public void run() {
                    jtextField.setText(s);
                }
            };
            SwingUtilities.invokeLater(doHighlight);
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            String numTxt = this.jtextField.getText();
            if (numTxt.contains("f") || numTxt.contains("d")) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(dialog, this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
                return;
            }
            try {
                int d = Integer.parseInt(numTxt);
                if (!insert) {
                    minAge = d;
                    this.currentString = numTxt;
                }

            } catch (NumberFormatException ex) {
                insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(dialog, this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            String numTxt = this.jtextField.getText();
            if (insert) {
                return;
            }
            if (numTxt.length() <= 0 || numTxt.equals("")) {
                return;
            }
            int d = Integer.parseInt(numTxt);
            minAge = d;
            this.currentString = numTxt;
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }

        @Override
        public void focusGained(FocusEvent e) {
            insert = false;
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (this.jtextField.getText().equals("")) {
                insert = true;
                insertZero(this.currentString);
            } else {
                insert = true;
            }
        }

    }

    private class JTextFieldMaxIntegerListener implements DocumentListener, FocusListener {

        private JTextField jtextField;
        private JTextField jTextField2;
        private MainFrame mainFrame;
        private String currentString;
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = true;

        public JTextFieldMaxIntegerListener(JTextField textField, JTextField txt, int value) {
            this.jtextField = textField;
            this.jTextField2 = txt;
            this.currentString = value + "";
        }

        private void insertZero(String s) {
            Runnable doHighlight = new Runnable() {
                @Override
                public void run() {
                    jtextField.setText(s);
                }
            };
            SwingUtilities.invokeLater(doHighlight);
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            String numTxt = this.jtextField.getText();
            if (numTxt.contains("f") || numTxt.contains("d")) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(dialog, this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
                return;
            }
            try {
                int d = Integer.parseInt(numTxt);
                if (!insert) {
                    maxAge = d;
                    this.currentString = numTxt;
                }

            } catch (NumberFormatException ex) {
                insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(dialog, this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            String numTxt = this.jtextField.getText();
            if (numTxt.length() <= 0 || numTxt.equals("")) {
                return;
            }
            int d = Integer.parseInt(numTxt);
            maxAge = d;
            this.currentString = numTxt;
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }

        @Override
        public void focusGained(FocusEvent e) {
            System.out.println("focus gained");
            insert = false;
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (this.jtextField.getText().equals("")) {
                insert = true;
                insertZero(this.currentString);
            } else {
                insert = true;
            }
        }

    }
}
