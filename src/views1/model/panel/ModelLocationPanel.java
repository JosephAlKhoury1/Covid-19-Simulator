package views1.model.panel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import models.location.LocationCategory;
import models.model.Model;

/**
 *
 * @author Joseph
 */
public class ModelLocationPanel extends javax.swing.JPanel {

    private JList<String> listLocation;
    private final DefaultListModel<String> listModel;

    private Model model;
    private Map<String, ModelLocationProperties> mapProperties;

    public ModelLocationPanel(Model model) {
        initComponents();
        this.model = model;
        this.mapProperties = new HashMap();
        listModel = new DefaultListModel();
        this.propertiesPanel.setLayout(new BorderLayout());
        listLocation = new JList(listModel);
        listLocation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listLocation.setSelectedIndex(0);
        listLocation.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String name = listLocation.getSelectedValue();
                propertiesPanel.removeAll();
                if (mapProperties.get(name) != null) {
                    propertiesPanel.add(mapProperties.get(name));
                }
                propertiesPanel.repaint();
                model.getMainFrame().repaint();
            }
        });
        listLocation.setVisibleRowCount(JList.VERTICAL);
        listLocation.setFont(new Font("Arial", Font.BOLD, 12));
        JScrollPane listScrollPane = new JScrollPane(listLocation);
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(listScrollPane);
        if (this.model.getCity() != null) {
            for (Entry<String, LocationCategory> e : this.model.getCity().getMapLocation().entrySet()) {
                addRows(e.getValue());
            }
        }

    }

    public void reinit() {
        this.mapProperties.clear();
        this.listModel.removeAllElements();
        this.propertiesPanel.removeAll();
        for (Entry<String, LocationCategory> e : this.model.getCity().getMapLocation().entrySet()) {
            addRows(e.getValue());
        }
    }

    private void addRows(LocationCategory lc) {
        int index = listLocation.getSelectedIndex();
        if (index == -1) {
            index = 0;
        } else {
            index++;
        }
        ModelLocationProperties lp = new ModelLocationProperties(lc, model.getMainFrame());
        lc.setModelLocatioProperties(lp);
        this.propertiesPanel.removeAll();
        this.propertiesPanel.add(lp);
        this.listModel.insertElementAt(lc.getName(), index);
        this.listLocation.setSelectedIndex(index);
        this.listLocation.ensureIndexIsVisible(index);
        this.propertiesPanel.repaint();
        this.propertiesPanel.revalidate();
        model.getMainFrame().repaint();
        model.getMainFrame().setVisible(true);
        this.mapProperties.put(lc.getName(), lp);
    }

    public void addRow(LocationCategory lc) {
        int index = listLocation.getSelectedIndex();
        if (index == -1) {
            index = 0;
        } else {
            index++;
        }
        ModelLocationProperties lp = new ModelLocationProperties(lc, model.getMainFrame());
        lc.setModelLocatioProperties(lp);
        this.mapProperties.put(lc.getName(), lp);

        this.propertiesPanel.removeAll();
        this.propertiesPanel.add(lp);
        this.listModel.insertElementAt(lc.getName(), index);
        this.listLocation.setSelectedIndex(index);
        this.listLocation.ensureIndexIsVisible(index);
        this.propertiesPanel.repaint();
    }

    public void removeRow(String name) {
        mapProperties.remove(name);
        int index = listModel.indexOf(name);
        listModel.remove(index);
        model.getCity().removeLocation(name);
        int size = listModel.getSize();
        if (size == 0) {
            propertiesPanel.removeAll();
        } else {
            if (index == listModel.getSize()) {
                index--;
            }
            listLocation.setSelectedIndex(index);
            listLocation.ensureIndexIsVisible(index);
            propertiesPanel.removeAll();
            propertiesPanel.add(mapProperties.get(listLocation.getSelectedValue()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        propertiesPanel = new javax.swing.JPanel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMinimumSize(new java.awt.Dimension(300, 100));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        propertiesPanel.setBackground(new java.awt.Color(255, 255, 255));
        propertiesPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        propertiesPanel.setPreferredSize(new java.awt.Dimension(1000, 4));

        javax.swing.GroupLayout propertiesPanelLayout = new javax.swing.GroupLayout(propertiesPanel);
        propertiesPanel.setLayout(propertiesPanelLayout);
        propertiesPanelLayout.setHorizontalGroup(
            propertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 996, Short.MAX_VALUE)
        );
        propertiesPanelLayout.setVerticalGroup(
            propertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(propertiesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(propertiesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel propertiesPanel;
    // End of variables declaration//GEN-END:variables
}
