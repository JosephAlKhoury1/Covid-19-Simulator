/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import models.locationFactories.LocationFactory;
import views.dialog.NewLocationDialog;

/**
 *
 * @author Joseph
 */
public class LocationListPanel extends JPanel implements ListSelectionListener {

    private final int width;
    private final int height;
    private static JList<String> listLocation;
    private final DefaultListModel<String> listModel;

    private final Map<String, LocationProperties> mapLocation;
    private String newName;

    private final MainFrame mainFrame;

    public LocationListPanel(MainFrame frame, int width, int height) {
        this.width = width;
        this.height = height;
        this.mainFrame = frame;
        this.mapLocation = new HashMap();

        listModel = new DefaultListModel();

        listLocation = new JList(listModel);
        listLocation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listLocation.setSelectedIndex(0);
        listLocation.addListSelectionListener(this);
        listLocation.setVisibleRowCount(JList.VERTICAL);
        listLocation.setFont(new Font("Arial", Font.BOLD, 24));
        JScrollPane listScrollPane = new JScrollPane(listLocation);
        initComponents();
        jPanel1.setLayout(new BorderLayout());
        AddListener addListener = new AddListener(addButton);
        addButton.addActionListener(addListener);
        addButton.setActionCommand("Add");

        nameToAddTxt.addActionListener(addListener);
        nameToAddTxt.getDocument().addDocumentListener(addListener);
        removeButton.addActionListener(new RemoveListener());
        this.jPanel1.add(listScrollPane);
        this.locationPropertiesPanel.setLayout(new BorderLayout());
    }

    public void initLocation() {
        for (Entry<String, LocationProperties> e : mapLocation.entrySet()) {
            e.getValue().initLocation();
        }
    }

    public void addNewRow(String name, String kind, int quantity, double percentage, LocationFactory factory) {
        int index = listLocation.getSelectedIndex();
        if (index == -1) {
            index = 0;
        } else {
            index++;
        }
        mapLocation.put(name, new LocationProperties(name, kind, quantity, percentage, factory, mainFrame));
        this.locationPropertiesPanel.removeAll();
        this.locationPropertiesPanel.add(mapLocation.get(name));
        listModel.insertElementAt(name, index);
        nameToAddTxt.requestFocusInWindow();
        nameToAddTxt.setText("");
        listLocation.setSelectedIndex(index);
        listLocation.ensureIndexIsVisible(index);
        this.locationPropertiesPanel.repaint();
        removeButton.setEnabled(true);
        this.mainFrame.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        nameToAddTxt = new javax.swing.JTextField();
        removeButton = new javax.swing.JButton();
        locationPropertiesPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new Dimension(this.width,this.height));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );

        addButton.setText("Add ");
        addButton.setToolTipText("");
        addButton.setEnabled(false);

        nameToAddTxt.setToolTipText("");

        removeButton.setText("Remove");
        removeButton.setToolTipText("");
        removeButton.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(nameToAddTxt)
                .addGap(28, 28, 28)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeButton))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(nameToAddTxt))
            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
            .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        locationPropertiesPanel.setBackground(new java.awt.Color(255, 255, 255));
        locationPropertiesPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout locationPropertiesPanelLayout = new javax.swing.GroupLayout(locationPropertiesPanel);
        locationPropertiesPanel.setLayout(locationPropertiesPanelLayout);
        locationPropertiesPanelLayout.setHorizontalGroup(
            locationPropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        locationPropertiesPanelLayout.setVerticalGroup(
            locationPropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Locations");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(locationPropertiesPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locationPropertiesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel locationPropertiesPanel;
    private javax.swing.JTextField nameToAddTxt;
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
            newName = nameToAddTxt.getText();
            if (newName.equals("") || newName.startsWith(" ") || alreadyInList(newName)) {
                Toolkit.getDefaultToolkit().beep();
                nameToAddTxt.requestFocusInWindow();
                nameToAddTxt.selectAll();
                return;
            }
            NewLocationDialog dialog = new NewLocationDialog(newName, mainFrame);
            dialog.setVisible(true);
            mainFrame.setEnabled(false);
        }

        protected boolean alreadyInList(String name) {
            return listModel.contains(name);
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
            int index = listLocation.getSelectedIndex();
            String name = listLocation.getSelectedValue();
            String message = "Are you sure you want to delete the location" + name + "?";
            String title = "Delete location";
            if (JOptionPane.showOptionDialog(mainFrame, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null) == JOptionPane.NO_OPTION) {
                return;
            }
            mapLocation.remove(name);
            listModel.remove(index);
            int size = listModel.getSize();
            if (size == 0) {
                removeButton.setEnabled(false);
                locationPropertiesPanel.removeAll();
            } else {
                if (index == listModel.getSize()) {
                    index--;
                }
                listLocation.setSelectedIndex(index);
                listLocation.ensureIndexIsVisible(index);
                locationPropertiesPanel.removeAll();
                locationPropertiesPanel.add(mapLocation.get(listLocation.getSelectedValue()));
            }
            locationPropertiesPanel.repaint();
            mainFrame.setVisible(true);
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        String name = listLocation.getSelectedValue();
        locationPropertiesPanel.removeAll();
        if (mapLocation.get(name) != null) {
            locationPropertiesPanel.add(mapLocation.get(name));
        }
        locationPropertiesPanel.repaint();
        mainFrame.setVisible(true);
    }

}
