package models.model;

import controller.controllers.SymptomsController;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import resources.icon.Icons;
import resources.Messages.Messages;

public class SymptomType extends javax.swing.JPanel {
    
    private int id;
    private String name;
    private Model model;
    private List<SymptomStage> listSymptomStage;
    private List<SymptomStage> listDeleted;
    private List<SymptomStage> listAdd;
    
    private boolean saved, inNew, deleted;
    
    private Component cState;
    private Component cName1, cName2;
    private JLabel name1, name2;
    
    private List<SymptomStageType> listSage;
    private List<SymptomStageType> listStageDeleted;
    
    private JButton removeButton;
    
    public SymptomType(String name, List<SymptomStage> listSymptomStageHospital, List<SymptomStage> listNonHospital, Model m) {
        initComponents();
        this.name = name;
        this.model = m;
        this.listDeleted = new ArrayList();
        this.listAdd = new ArrayList();
        this.listSymptomStage = new ArrayList();
        this.listStageDeleted = new ArrayList();
        
        name1 = new JLabel();
        name1.setText(name);
        name1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name1.setToolTipText("");
        name1.setAlignmentX(Component.LEFT_ALIGNMENT);
        name1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        name1.setMaximumSize(new java.awt.Dimension(130, 35));
        name1.setMinimumSize(new java.awt.Dimension(130, 35));
        name1.setPreferredSize(new java.awt.Dimension(130, 35));
        
        this.cName1 = Box.createVerticalStrut(3);
        
        name2 = new javax.swing.JLabel();
        name2.setText(name);
        name2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name2.setToolTipText("");
        name2.setAlignmentX(Component.LEFT_ALIGNMENT);
        name2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        name2.setMaximumSize(new java.awt.Dimension(130, 35));
        name2.setMinimumSize(new java.awt.Dimension(130, 35));
        name2.setPreferredSize(new java.awt.Dimension(130, 35));
        
        this.cName2 = Box.createVerticalStrut(3);
        this.saved = false;
        this.inNew = true;
        this.deleted = false;
        
        removeButton = new JButton();
        removeButton.setPreferredSize(new Dimension(40, 35));
        removeButton.setMinimumSize(new Dimension(40, 35));
        removeButton.setMaximumSize(new Dimension(40, 35));
        
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeActionPerformed();
            }
        });
        removeButton.setIcon(Icons.DELETEICON);
        
        this.symptomeStagePanel.setLayout(new BoxLayout(this.symptomeStagePanel, BoxLayout.X_AXIS));
        
        this.listSage = new ArrayList();
        for (SymptomStage stg : listNonHospital) {
            SymptomStageType stt = new SymptomStageType(this, stg, 0, model);
            this.listSage.add(stt);
            this.symptomeStagePanel.add(stt.getPanel());
            
        }
        for (SymptomStage stg : listSymptomStageHospital) {
            SymptomStageType stt = new SymptomStageType(this, stg, 0, model);
            this.listSage.add(stt);
            this.symptomeStagePanel.add(stt.getPanel());
        }
        
        this.symptomeStagePanel.add(removeButton);
    }
    
    public SymptomType(int id, String name) {
        initComponents();
        this.id = id;
        this.name = name;
        this.listDeleted = new ArrayList();
        this.listAdd = new ArrayList();
        this.listSymptomStage = new ArrayList();
        this.listStageDeleted = new ArrayList();
        name1 = new JLabel();
        name1.setText(name);
        name1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name1.setToolTipText("");
        name1.setAlignmentX(Component.LEFT_ALIGNMENT);
        name1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        name1.setMaximumSize(new java.awt.Dimension(130, 35));
        name1.setMinimumSize(new java.awt.Dimension(130, 35));
        name1.setPreferredSize(new java.awt.Dimension(130, 35));
        
        this.cName1 = Box.createVerticalStrut(3);
        
        name2 = new javax.swing.JLabel();
        name2.setText(name);
        name2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name2.setToolTipText("");
        name2.setAlignmentX(Component.LEFT_ALIGNMENT);
        name2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        name2.setMaximumSize(new java.awt.Dimension(130, 35));
        name2.setMinimumSize(new java.awt.Dimension(130, 35));
        name2.setPreferredSize(new java.awt.Dimension(130, 35));
        
        this.cName2 = Box.createVerticalStrut(3);
        
        removeButton = new JButton();
        removeButton.setPreferredSize(new Dimension(40, 35));
        removeButton.setMinimumSize(new Dimension(40, 35));
        removeButton.setMaximumSize(new Dimension(40, 35));
        
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeActionPerformed();
            }
        });
        removeButton.setIcon(Icons.DELETEICON);
        
        this.saved = true;
        this.inNew = false;
        this.deleted = false;
        this.symptomeStagePanel.setLayout(new BoxLayout(this.symptomeStagePanel, BoxLayout.X_AXIS));
    }
    
    public SymptomType(SymptomType old, Model m) {
        initComponents();
        this.name = old.getName();
        this.model = m;
        this.listDeleted = new ArrayList();
        this.listAdd = new ArrayList();
        this.listSymptomStage = new ArrayList();
        this.listStageDeleted = new ArrayList();
        
        name1 = new JLabel();
        name1.setText(name);
        name1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name1.setToolTipText("");
        name1.setAlignmentX(Component.LEFT_ALIGNMENT);
        name1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        name1.setMaximumSize(new java.awt.Dimension(130, 35));
        name1.setMinimumSize(new java.awt.Dimension(130, 35));
        name1.setPreferredSize(new java.awt.Dimension(130, 35));
        
        this.cName1 = Box.createVerticalStrut(3);
        
        name2 = new javax.swing.JLabel();
        name2.setText(name);
        name2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name2.setToolTipText("");
        name2.setAlignmentX(Component.LEFT_ALIGNMENT);
        name2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        name2.setMaximumSize(new java.awt.Dimension(130, 35));
        name2.setMinimumSize(new java.awt.Dimension(130, 35));
        name2.setPreferredSize(new java.awt.Dimension(130, 35));
        
        this.cName2 = Box.createVerticalStrut(3);
        this.saved = false;
        this.inNew = true;
        this.deleted = false;
        
        removeButton = new JButton();
        removeButton.setPreferredSize(new Dimension(40, 35));
        removeButton.setMinimumSize(new Dimension(40, 35));
        removeButton.setMaximumSize(new Dimension(40, 35));
        
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeActionPerformed();
            }
        });
        removeButton.setIcon(Icons.DELETEICON);
        
        this.symptomeStagePanel.setLayout(new BoxLayout(this.symptomeStagePanel, BoxLayout.X_AXIS));
        
        this.listSage = new ArrayList();
        for (SymptomStage stg : model.getListSymptomStage1sNonHospital()) {
            int days = 0;
            for (SymptomStageType sst : old.getListSage()) {
                if (sst.getSymptomType().getName().equals(this.name) && sst.getSymptomStage().getName().equals(stg.getName())) {
                    days = sst.getDay();
                    break;
                }
            }
            SymptomStageType stt = new SymptomStageType(this, stg, days, model);
            this.listSage.add(stt);
            this.symptomeStagePanel.add(stt.getPanel());
            
        }
        for (SymptomStage stg : m.getListSymptomStage1sHospital()) {
            int days = 0;
            for (SymptomStageType sst : old.getListSage()) {
                if (sst.getSymptomType().getName().equals(this.name) && sst.getSymptomStage().getName().equals(stg.getName())) {
                    days = sst.getDay();
                    break;
                }
            }
            
            SymptomStageType stt = new SymptomStageType(this, stg, days, model);
            this.listSage.add(stt);
            this.symptomeStagePanel.add(stt.getPanel());
        }
        
        this.symptomeStagePanel.add(removeButton);
    }
    
    public void reintSymptomStagePanel() {
        this.symptomeStagePanel.remove(this.removeButton);
        int index = 1;
        this.symptomeStagePanel.removeAll();
        while (index < listSage.size() + 1) {
            for (SymptomStageType stt : listSage) {
                if (stt.getSymptomStage().getIndex() == index) {
                    this.symptomeStagePanel.add(stt.getPanel());
                    index++;
                }
            }
        }
        this.symptomeStagePanel.add(this.removeButton);
    }
    
    public void removeActionPerformed() {
        int index = JOptionPane.showOptionDialog(this.model.getMainFrame(), Messages.DELETESYMPTOMTYPE, "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, Icons.WARNINGICON, null, null);
        
        if (index == JOptionPane.NO_OPTION || index == JOptionPane.CLOSED_OPTION) {
            return;
        }
        this.setDeleted(true);
        this.model.getListSymptomType().remove(this);
        this.model.getListSymptomTypeDeleted().add(this);
        for (HumanAge ha : this.model.getListHumanAge()) {
            ha.removeSymptomType(this);
        }
        for (SymptomStageType sst : this.listSage) {
            sst.setDeleted(true);
        }
        this.model.getModelPanel().reinitPanel();
        this.model.getModelPanel().reinitAgePanel();
        this.model.getMainFrame().setModelSavedButtonEnable();
    }
    
    public List<SymptomStageType> getListStageDeleted() {
        return listStageDeleted;
    }
    
    public List<SymptomStageType> getListSage() {
        return listSage;
    }
    
    public void setListSage(List<SymptomStageType> listSage) {
        this.listSage = listSage;
        int index = 1;
        while (index < listSage.size() + 1) {
            for (SymptomStageType stt : listSage) {
                if (stt.getSymptomStage().getIndex() == index) {
                    this.symptomeStagePanel.add(stt.getPanel());
                    index++;
                }
            }
        }
        this.symptomeStagePanel.add(removeButton);
    }
    
    public void setListStageDeleted(List<SymptomStageType> listStageDeleted) {
        this.listStageDeleted = listStageDeleted;
    }
    
    public int getId() {
        return id;
    }
    
    public JPanel getSymptomeStagePanel() {
        return symptomeStagePanel;
    }
    
    public void setSymptomeStagePanel(JPanel symptomeStagePanel) {
        this.symptomeStagePanel = symptomeStagePanel;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    public JLabel getName1() {
        return name1;
    }
    
    public void setName1(JLabel name1) {
        this.name1 = name1;
    }
    
    public JLabel getName2() {
        return name2;
    }
    
    public void setName2(JLabel name2) {
        this.name2 = name2;
    }
    
    public Model getModel() {
        return model;
    }
    
    public void setModel(Model model) {
        this.model = model;
        for (SymptomStageType sa : this.listSage) {
            sa.setModel(model);
        }
    }
    
    public Component getcName1() {
        return cName1;
    }
    
    public void setcName1(Component cName) {
        this.cName1 = cName;
    }
    
    public boolean isSaved() {
        return saved;
    }
    
    public void setSaved(boolean saved) {
        this.saved = saved;
    }
    
    public boolean isInNew() {
        return inNew;
    }
    
    public void setInNew(boolean inNew) {
        this.inNew = inNew;
    }
    
    public boolean isDeleted() {
        return deleted;
    }
    
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    
    public Component getCState() {
        return cState;
    }
    
    public void setcState(Component component) {
        this.cState = component;
    }
    
    public void save() {
        if (this.isDeleted()) {
            if (this.isInNew()) {
                return;
            }
            SymptomsController.INSTANCE.delete(this.id);
            return;
        }
        if (this.isInNew()) {
            this.id = SymptomsController.INSTANCE.insertSymptom(this);
            this.setInNew(false);
            this.setSaved(true);
        } else {
            if (!this.isSaved()) {
                //SymptomsController.INSTANCE.updateSymptom(this);
                this.setSaved(true);
            } else {
                
            }
        }
        
        save1();
        this.listAdd.clear();
        this.listDeleted.clear();
    }
    
    public void save1() {
        for (SymptomStageType stt : this.listSage) {
            stt.save();
        }
        for (SymptomStageType stt : this.listStageDeleted) {
            stt.save();
        }
        this.listDeleted.clear();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        symptomeStagePanel = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(341411, 35));
        setMinimumSize(new java.awt.Dimension(0, 35));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 35));

        symptomeStagePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        symptomeStagePanel.setMaximumSize(new java.awt.Dimension(32767, 31));
        symptomeStagePanel.setMinimumSize(new java.awt.Dimension(100, 31));
        symptomeStagePanel.setPreferredSize(new java.awt.Dimension(800, 35));

        javax.swing.GroupLayout symptomeStagePanelLayout = new javax.swing.GroupLayout(symptomeStagePanel);
        symptomeStagePanel.setLayout(symptomeStagePanelLayout);
        symptomeStagePanelLayout.setHorizontalGroup(
            symptomeStagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );
        symptomeStagePanelLayout.setVerticalGroup(
            symptomeStagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(symptomeStagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(symptomeStagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
    }// </editor-fold>//GEN-END:initComponents

    public List<SymptomStage> getListSymptomStage() {
        return listSymptomStage;
    }
    
    public void setListSymptomStage(List<SymptomStage> listSymptomStage) {
        this.listSymptomStage = listSymptomStage;
    }
    
    public Component getcName2() {
        return cName2;
    }
    
    public void setcName2(Component cName2) {
        this.cName2 = cName2;
    }
    
    private void updateSymptomStageList(List<SymptomStage> list) {
        for (SymptomStage sts : list) {
            if (sts.isIsNew()) {
                if (!sts.isDeleted()) {
                    
                } else {
                }
            } else {
                for (SymptomStage st : this.listSymptomStage) {
                    if (st.getName().equals(sts.getName())) {
                        if (sts.isDeleted()) {
                            st.setDeleted(true);
                            this.listDeleted.add(st);
                        } else {
                            st.setIndex(sts.getIndex());
                            st.setSaved(false);
                        }
                    }
                }
            }
        }
        for (SymptomStage st : this.listDeleted) {
            this.listSymptomStage.remove(st);
        }
        
        SymptomStage[] tab = new SymptomStage[listSymptomStage.size()];
        for (SymptomStage ss : listSymptomStage) {
            tab[ss.getIndex()] = ss;
        }
        
        listSymptomStage.clear();
        
        for (SymptomStage ss : tab) {
            listSymptomStage.add(ss);
        }
    }
    
    private void updateSymptomStagePanel() {
        this.symptomeStagePanel.removeAll();
        for (SymptomStage ss : this.listSymptomStage) {
            ss.setSymptomType(this);
            this.symptomeStagePanel.add(ss.getDayTxt());
            this.symptomeStagePanel.add(ss.getComponent());
        }
        this.symptomeStagePanel.revalidate();
    }
    
    public void updateSymptomStage(List<SymptomStage> list) {
        this.updateSymptomStageList(list);
        this.updateSymptomStagePanel();;
    }
    
    public void setEnable() {
        for (SymptomStageType ss : this.listSage) {
            ss.setEnable();
        }
        this.removeButton.setEnabled(true);
    }
    
    public void setDisable() {
        for (SymptomStageType ss : this.listSage) {
            ss.setDisable();
            this.removeButton.setEnabled(false);
        }
    }
    
    public void addSymptomStage(SymptomStageType st) {
        
        listSage.add(st);
        SymptomStageType[] tab = new SymptomStageType[listSage.size()];
        for (SymptomStageType stt : listSage) {
            tab[stt.getSymptomStage().getIndex() - 1] = stt;
        }
        listSage.clear();
        for (SymptomStageType stt : tab) {
            listSage.add(stt);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel symptomeStagePanel;
    // End of variables declaration//GEN-END:variables

}
