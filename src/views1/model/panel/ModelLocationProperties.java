package views1.model.panel;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import models.location.DayRow;
import models.location.LocationCategory;
import models.location.TimeRow;
import models.locationFactories.HouseFactory;
import resources.Messages.Messages;
import views1.MainFrame;

public class ModelLocationProperties extends javax.swing.JPanel {

    private LocationCategory locationCategory;
    private MainFrame mainFrame;

    public ModelLocationProperties(LocationCategory lc, MainFrame frame) {
        this.locationCategory = lc;
        this.mainFrame = frame;
        initComponents();
        lc.setModelLocatioProperties(this);
        this.nameLabel1.setText(lc.getName());
        this.kindLabel1.setText(lc.getKind());
        this.quantityLabel1.setText(lc.getQuantity() + "");

        this.mondayPanel.setLayout(new BoxLayout(this.mondayPanel, BoxLayout.Y_AXIS));
        this.tuesdayPanel.setLayout(new BoxLayout(this.tuesdayPanel, BoxLayout.Y_AXIS));
        this.wednesdayPanel.setLayout(new BoxLayout(this.wednesdayPanel, BoxLayout.Y_AXIS));
        this.thursdayPanel.setLayout(new BoxLayout(this.thursdayPanel, BoxLayout.Y_AXIS));
        this.fridayPanel.setLayout(new BoxLayout(this.fridayPanel, BoxLayout.Y_AXIS));
        this.saturdayPanel.setLayout(new BoxLayout(this.saturdayPanel, BoxLayout.Y_AXIS));
        this.sundayPanel.setLayout(new BoxLayout(this.sundayPanel, BoxLayout.Y_AXIS));

        for (DayRow d : lc.getListDayRowTmp()) {
            if (d.getName().equals("Monday")) {
                if (d.getUsed() == 1) {
                    this.mondayBox.setSelected(true);
                    this.setMondayPanelEnable(true);
                } else {
                    this.setMondayPanelEnable(false);
                }
                for (TimeRow tr : d.getListTimeRow()) {
                    if (tr.getOpenTime() == 0) {
                        for (TimeRow trt : d.getPreviousDayRow().getListTimeRow()) {
                            if (trt.getCloseTime() == 24) {
                                tr.setPreviousTimeRow(trt);
                                trt.setNextTimeRow(tr);
                                break;
                            }
                        }
                    }
                    if (tr.getCloseTime() == 24) {
                        for (TimeRow trt : d.getNextDayRow().getListTimeRow()) {
                            if (trt.getOpenTime() == 0) {
                                tr.setNextTimeRow(trt);
                                trt.setPreviousTimeRow(tr);
                                break;
                            }
                        }
                    }
                    this.mondayPanel.add(tr.getPanel());
                }
            }
            if (d.getName().equals("Tuesday")) {
                if (d.getUsed() == 1) {
                    this.tuesdayBox.setSelected(true);
                    this.setTuesdayPanelEnable(true);
                } else {
                    this.setTuesdayPanelEnable(false);
                }
                for (TimeRow tr : d.getListTimeRow()) {
                    this.tuesdayPanel.add(tr.getPanel());
                    if (tr.getOpenTime() == 0) {
                        for (TimeRow trt : d.getPreviousDayRow().getListTimeRow()) {
                            if (trt.getCloseTime() == 24) {
                                tr.setPreviousTimeRow(trt);
                                trt.setNextTimeRow(tr);
                                break;
                            }
                        }
                    }
                    if (tr.getCloseTime() == 24) {
                        for (TimeRow trt : d.getNextDayRow().getListTimeRow()) {
                            if (trt.getOpenTime() == 0) {
                                tr.setNextTimeRow(trt);
                                trt.setPreviousTimeRow(tr);
                                break;
                            }
                        }
                    }
                }
            }
            if (d.getName().equals("Wednesday")) {
                if (d.getUsed() == 1) {
                    this.wednesdayBox.setSelected(true);
                    this.setWednesdayPanelEnable(true);
                } else {
                    this.setWednesdayPanelEnable(false);
                }
                for (TimeRow tr : d.getListTimeRow()) {
                    this.wednesdayPanel.add(tr.getPanel());
                    if (tr.getOpenTime() == 0) {
                        for (TimeRow trt : d.getPreviousDayRow().getListTimeRow()) {
                            if (trt.getCloseTime() == 24) {
                                tr.setPreviousTimeRow(trt);
                                trt.setNextTimeRow(tr);
                                break;
                            }
                        }
                    }
                    if (tr.getCloseTime() == 24) {
                        for (TimeRow trt : d.getNextDayRow().getListTimeRow()) {
                            if (trt.getOpenTime() == 0) {
                                tr.setNextTimeRow(trt);
                                trt.setPreviousTimeRow(tr);
                                break;
                            }
                        }
                    }
                }
            }
            if (d.getName().equals("Thursday")) {
                if (d.getUsed() == 1) {
                    this.thursdayBox.setSelected(true);
                    this.setThursdayPanelEnable(true);
                } else {
                    this.setThursdayPanelEnable(false);
                }
                for (TimeRow tr : d.getListTimeRow()) {
                    this.thursdayPanel.add(tr.getPanel());
                    if (tr.getOpenTime() == 0) {
                        for (TimeRow trt : d.getPreviousDayRow().getListTimeRow()) {
                            if (trt.getCloseTime() == 24) {
                                tr.setPreviousTimeRow(trt);
                                trt.setNextTimeRow(tr);
                                break;
                            }
                        }
                    }
                    if (tr.getCloseTime() == 24) {
                        for (TimeRow trt : d.getNextDayRow().getListTimeRow()) {
                            if (trt.getOpenTime() == 0) {
                                tr.setNextTimeRow(trt);
                                trt.setPreviousTimeRow(tr);
                                break;
                            }
                        }
                    }
                }
            }
            if (d.getName().equals("Friday")) {
                if (d.getUsed() == 1) {
                    this.fridayBox.setSelected(true);
                    this.setFridayPanelEnable(true);
                } else {
                    this.setFridayPanelEnable(false);
                }
                for (TimeRow tr : d.getListTimeRow()) {
                    this.fridayPanel.add(tr.getPanel());
                    if (tr.getOpenTime() == 0) {
                        for (TimeRow trt : d.getPreviousDayRow().getListTimeRow()) {
                            if (trt.getCloseTime() == 24) {
                                tr.setPreviousTimeRow(trt);
                                trt.setNextTimeRow(tr);
                                break;
                            }
                        }
                    }
                    if (tr.getCloseTime() == 24) {
                        for (TimeRow trt : d.getNextDayRow().getListTimeRow()) {
                            if (trt.getOpenTime() == 0) {
                                tr.setNextTimeRow(trt);
                                trt.setPreviousTimeRow(tr);
                                break;
                            }
                        }
                    }
                }
            }
            if (d.getName().equals("Saturday")) {
                if (d.getUsed() == 1) {
                    this.saturdayBox.setSelected(true);
                    this.setSaturdayPanelEnable(true);
                } else {
                    this.setSaturdayPanelEnable(false);
                }
                for (TimeRow tr : d.getListTimeRow()) {
                    this.saturdayPanel.add(tr.getPanel());
                    if (tr.getOpenTime() == 0) {
                        for (TimeRow trt : d.getPreviousDayRow().getListTimeRow()) {
                            if (trt.getCloseTime() == 24) {
                                tr.setPreviousTimeRow(trt);
                                trt.setNextTimeRow(tr);
                                break;
                            }
                        }
                    }
                    if (tr.getCloseTime() == 24) {
                        for (TimeRow trt : d.getNextDayRow().getListTimeRow()) {
                            if (trt.getOpenTime() == 0) {
                                tr.setNextTimeRow(trt);
                                trt.setPreviousTimeRow(tr);
                                break;
                            }
                        }
                    }
                }
            }
            if (d.getName().equals("Sunday")) {
                if (d.getUsed() == 1) {
                    this.sundayBox.setSelected(true);
                    this.setSundayPanelEnable(true);
                } else {
                    this.setSundayPanelEnable(false);
                }
                for (TimeRow tr : d.getListTimeRow()) {
                    this.sundayPanel.add(tr.getPanel());
                    if (tr.getOpenTime() == 0) {
                        for (TimeRow trt : d.getPreviousDayRow().getListTimeRow()) {
                            if (trt.getCloseTime() == 24) {
                                tr.setPreviousTimeRow(trt);
                                trt.setNextTimeRow(tr);
                                break;
                            }
                        }
                    }
                    if (tr.getCloseTime() == 24) {
                        for (TimeRow trt : d.getNextDayRow().getListTimeRow()) {
                            if (trt.getOpenTime() == 0) {
                                tr.setNextTimeRow(trt);
                                trt.setPreviousTimeRow(tr);
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (lc.getFactory() == HouseFactory.INSTANCE) {
            this.jScrollPane2.setVisible(false);
        }

        JTextFieldDoubleListener listener = new JTextFieldDoubleListener(percentageToInfectTxt);
        this.percentageToInfectTxt.getDocument().addDocumentListener(listener);
        this.percentageToInfectTxt.addFocusListener(listener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nameLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        kindLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        quantityLabel1 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        percentageToInfectLabel = new javax.swing.JLabel();
        percentageToInfectTxt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        mondayBox = new javax.swing.JCheckBox();
        mondayAddButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mondayPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        tuesdayBox = new javax.swing.JCheckBox();
        tuesdayAddButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tuesdayPanel = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        wednesdayBox = new javax.swing.JCheckBox();
        wednesdayAddButton = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        wednesdayPanel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        thursdayBox = new javax.swing.JCheckBox();
        thursdayAddButton = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        thursdayPanel = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        fridayAddButton = new javax.swing.JButton();
        fridayBox = new javax.swing.JCheckBox();
        jPanel18 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        fridayPanel = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        saturdayBox = new javax.swing.JCheckBox();
        saturdayAddButton = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        saturdayPanel = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        sundayAddButton = new javax.swing.JButton();
        sundayBox = new javax.swing.JCheckBox();
        jPanel24 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        sundayPanel = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(715, 2000));

        jLabel7.setText("Properties:");

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Name:");

        nameLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel1.setToolTipText("");
        nameLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Kind:");

        kindLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kindLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Quantity:");

        quantityLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quantityLabel1.setText("0");
        quantityLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        percentageToInfectLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        percentageToInfectLabel.setText("Percentage to infect others:");
        percentageToInfectLabel.setToolTipText("");

        percentageToInfectTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        percentageToInfectTxt.setText("0.0");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(percentageToInfectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(percentageToInfectTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(percentageToInfectLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(percentageToInfectTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kindLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantityLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(quantityLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(kindLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(660, 1620));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(655, 225));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        mondayBox.setText("Monday");
        mondayBox.setToolTipText("");
        mondayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mondayBoxActionPerformed(evt);
            }
        });

        mondayAddButton.setText("+");
        mondayAddButton.setToolTipText("");
        mondayAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mondayAddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mondayBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mondayAddButton)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(mondayBox)
                .addComponent(mondayAddButton))
        );

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        mondayPanel.setPreferredSize(new java.awt.Dimension(747, 150));

        javax.swing.GroupLayout mondayPanelLayout = new javax.swing.GroupLayout(mondayPanel);
        mondayPanel.setLayout(mondayPanelLayout);
        mondayPanelLayout.setHorizontalGroup(
            mondayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
        );
        mondayPanelLayout.setVerticalGroup(
            mondayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mondayPanel);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Time");
        jLabel1.setToolTipText("");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Open Time");
        jLabel2.setToolTipText("");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Close time");
        jLabel3.setToolTipText("");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Human Percentage");
        jLabel5.setToolTipText("");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setPreferredSize(new java.awt.Dimension(655, 225));

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tuesdayBox.setText("Tuesday");
        tuesdayBox.setToolTipText("");
        tuesdayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuesdayBoxActionPerformed(evt);
            }
        });

        tuesdayAddButton.setText("+");
        tuesdayAddButton.setToolTipText("");
        tuesdayAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuesdayAddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tuesdayBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tuesdayAddButton)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tuesdayBox)
                .addComponent(tuesdayAddButton))
        );

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tuesdayPanel.setPreferredSize(new java.awt.Dimension(747, 150));

        javax.swing.GroupLayout tuesdayPanelLayout = new javax.swing.GroupLayout(tuesdayPanel);
        tuesdayPanel.setLayout(tuesdayPanelLayout);
        tuesdayPanelLayout.setHorizontalGroup(
            tuesdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
        );
        tuesdayPanelLayout.setVerticalGroup(
            tuesdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(tuesdayPanel);

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Time");
        jLabel9.setToolTipText("");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Open Time");
        jLabel12.setToolTipText("");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Close time");
        jLabel13.setToolTipText("");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Human Percentage");
        jLabel14.setToolTipText("");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel13.setPreferredSize(new java.awt.Dimension(692, 225));

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        wednesdayBox.setText("Wednesday");
        wednesdayBox.setToolTipText("");
        wednesdayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wednesdayBoxActionPerformed(evt);
            }
        });

        wednesdayAddButton.setText("+");
        wednesdayAddButton.setToolTipText("");
        wednesdayAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wednesdayAddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wednesdayBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(wednesdayAddButton)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(wednesdayBox)
                .addComponent(wednesdayAddButton))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setPreferredSize(new java.awt.Dimension(642, 35));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Time");
        jLabel15.setToolTipText("");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Open time");
        jLabel16.setToolTipText("");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Close time");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Human Percentage");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 46, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane4.setPreferredSize(new java.awt.Dimension(705, 152));

        wednesdayPanel.setPreferredSize(new java.awt.Dimension(703, 150));

        javax.swing.GroupLayout wednesdayPanelLayout = new javax.swing.GroupLayout(wednesdayPanel);
        wednesdayPanel.setLayout(wednesdayPanelLayout);
        wednesdayPanelLayout.setHorizontalGroup(
            wednesdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 764, Short.MAX_VALUE)
        );
        wednesdayPanelLayout.setVerticalGroup(
            wednesdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(wednesdayPanel);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setPreferredSize(new java.awt.Dimension(692, 225));

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        thursdayBox.setText("Thursday");
        thursdayBox.setToolTipText("");
        thursdayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thursdayBoxActionPerformed(evt);
            }
        });

        thursdayAddButton.setText("+");
        thursdayAddButton.setToolTipText("");
        thursdayAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thursdayAddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(thursdayBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(thursdayAddButton)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(thursdayBox)
                .addComponent(thursdayAddButton))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel15.setPreferredSize(new java.awt.Dimension(642, 35));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Time");
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Open time");
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Close time");
        jLabel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("HumanPercentage");
        jLabel22.setToolTipText("");
        jLabel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 46, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane5.setPreferredSize(new java.awt.Dimension(705, 152));

        thursdayPanel.setPreferredSize(new java.awt.Dimension(703, 150));

        javax.swing.GroupLayout thursdayPanelLayout = new javax.swing.GroupLayout(thursdayPanel);
        thursdayPanel.setLayout(thursdayPanelLayout);
        thursdayPanelLayout.setHorizontalGroup(
            thursdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
        );
        thursdayPanelLayout.setVerticalGroup(
            thursdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(thursdayPanel);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel16.setPreferredSize(new java.awt.Dimension(647, 225));

        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        fridayAddButton.setText("+");
        fridayAddButton.setToolTipText("");
        fridayAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fridayAddButtonActionPerformed(evt);
            }
        });

        fridayBox.setText("Friday");
        fridayBox.setToolTipText("");
        fridayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fridayBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fridayBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fridayAddButton)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(fridayAddButton)
                .addComponent(fridayBox))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Time");
        jLabel23.setToolTipText("");
        jLabel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Open time");
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Close time");
        jLabel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Human percentage");
        jLabel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane6.setPreferredSize(new java.awt.Dimension(705, 152));

        fridayPanel.setPreferredSize(new java.awt.Dimension(703, 150));

        javax.swing.GroupLayout fridayPanelLayout = new javax.swing.GroupLayout(fridayPanel);
        fridayPanel.setLayout(fridayPanelLayout);
        fridayPanelLayout.setHorizontalGroup(
            fridayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
        );
        fridayPanelLayout.setVerticalGroup(
            fridayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jScrollPane6.setViewportView(fridayPanel);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel19.setPreferredSize(new java.awt.Dimension(646, 225));

        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        saturdayBox.setText("Saturday");
        saturdayBox.setToolTipText("");
        saturdayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saturdayBoxActionPerformed(evt);
            }
        });

        saturdayAddButton.setText("+");
        saturdayAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saturdayAddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saturdayBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saturdayAddButton)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(saturdayBox)
                .addComponent(saturdayAddButton))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Time");
        jLabel27.setToolTipText("");
        jLabel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Open time");
        jLabel28.setToolTipText("");
        jLabel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Close time");
        jLabel29.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Human percentage");
        jLabel30.setToolTipText("");
        jLabel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        saturdayPanel.setPreferredSize(new java.awt.Dimension(703, 150));

        javax.swing.GroupLayout saturdayPanelLayout = new javax.swing.GroupLayout(saturdayPanel);
        saturdayPanel.setLayout(saturdayPanelLayout);
        saturdayPanelLayout.setHorizontalGroup(
            saturdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
        );
        saturdayPanelLayout.setVerticalGroup(
            saturdayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jScrollPane7.setViewportView(saturdayPanel);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel22.setPreferredSize(new java.awt.Dimension(646, 225));

        jPanel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        sundayAddButton.setText("+");
        sundayAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sundayAddButtonActionPerformed(evt);
            }
        });

        sundayBox.setText("Sunday");
        sundayBox.setToolTipText("");
        sundayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sundayBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sundayBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sundayAddButton)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(sundayAddButton)
                .addComponent(sundayBox))
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Time");
        jLabel31.setToolTipText("");
        jLabel31.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Open time");
        jLabel32.setToolTipText("");
        jLabel32.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Close time");
        jLabel33.setToolTipText("");
        jLabel33.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Human percentage");
        jLabel34.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sundayPanel.setPreferredSize(new java.awt.Dimension(703, 150));

        javax.swing.GroupLayout sundayPanelLayout = new javax.swing.GroupLayout(sundayPanel);
        sundayPanel.setLayout(sundayPanelLayout);
        sundayPanelLayout.setHorizontalGroup(
            sundayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
        );
        sundayPanelLayout.setVerticalGroup(
            sundayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jScrollPane8.setViewportView(sundayPanel);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mondayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mondayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.locationCategory.getListDayRow().add(this.locationCategory.getMondayRow());
            this.setMondayPanelEnable(true);
            this.locationCategory.getMondayRow().setUsed(1);
        } else {
            this.locationCategory.getListDayRow().remove(this.locationCategory.getMondayRow());
            this.setMondayPanelEnable(false);
            this.locationCategory.getMondayRow().setUsed(0);
        }

        this.locationCategory.getMondayRow().setSaved(false);

    }//GEN-LAST:event_mondayBoxActionPerformed

    private void tuesdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuesdayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.locationCategory.getListDayRow().add(this.locationCategory.getTuesdayRow());
            this.setTuesdayPanelEnable(true);
            this.locationCategory.getTuesdayRow().setUsed(1);
        } else {
            this.locationCategory.getListDayRow().remove(this.locationCategory.getTuesdayRow());
            this.setTuesdayPanelEnable(false);
            this.locationCategory.getTuesdayRow().setUsed(0);
        }
    }//GEN-LAST:event_tuesdayBoxActionPerformed

    private void wednesdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wednesdayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.locationCategory.getListDayRow().add(this.locationCategory.getWednesdayRow());
            this.setWednesdayPanelEnable(true);
            this.locationCategory.getWednesdayRow().setUsed(1);
        } else {
            this.locationCategory.getListDayRow().remove(this.locationCategory.getWednesdayRow());
            this.setWednesdayPanelEnable(false);
            this.locationCategory.getWednesdayRow().setUsed(0);
        }
    }//GEN-LAST:event_wednesdayBoxActionPerformed

    private void thursdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thursdayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.locationCategory.getListDayRow().add(this.locationCategory.getThursdayRow());
            this.setThursdayPanelEnable(true);
            this.locationCategory.getThursdayRow().setUsed(1);
        } else {
            this.locationCategory.getListDayRow().remove(this.locationCategory.getThursdayRow());
            this.setThursdayPanelEnable(false);
            this.locationCategory.getThursdayRow().setUsed(0);
        }
    }//GEN-LAST:event_thursdayBoxActionPerformed

    private void fridayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fridayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.locationCategory.getListDayRow().add(this.locationCategory.getFridayRow());
            this.setFridayPanelEnable(true);
            this.locationCategory.getFridayRow().setUsed(1);
        } else {
            this.locationCategory.getListDayRow().remove(this.locationCategory.getFridayRow());
            this.setFridayPanelEnable(false);
            this.locationCategory.getFridayRow().setUsed(0);
        }
    }//GEN-LAST:event_fridayBoxActionPerformed

    private void saturdayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saturdayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.locationCategory.getListDayRow().add(this.locationCategory.getSatursayRow());
            this.setSaturdayPanelEnable(true);
            this.locationCategory.getSatursayRow().setUsed(1);
        } else {
            this.locationCategory.getListDayRow().remove(this.locationCategory.getSatursayRow());
            this.setSaturdayPanelEnable(false);
            this.locationCategory.getSatursayRow().setUsed(0);
        }
    }//GEN-LAST:event_saturdayBoxActionPerformed

    private void sundayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sundayBoxActionPerformed
        JCheckBox cb = (JCheckBox) evt.getSource();
        if (cb.isSelected()) {
            this.locationCategory.getListDayRow().add(this.locationCategory.getSundayRow());
            this.setSundayPanelEnable(true);
            this.locationCategory.getSundayRow().setUsed(1);
        } else {
            this.locationCategory.getListDayRow().remove(this.locationCategory.getSundayRow());
            this.setSundayPanelEnable(false);
            this.locationCategory.getSundayRow().setUsed(0);
        }
    }//GEN-LAST:event_sundayBoxActionPerformed

    private void mondayAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mondayAddButtonActionPerformed
        for (TimeRow tr : this.locationCategory.getMondayRow().getListTimeRow()) {
            if (!tr.isMinValid() || !tr.isMaxValid()) {
                JOptionPane.showOptionDialog(this.mainFrame, Messages.cantAddNewtimeInterval(), "Warning", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                return;
            }
        }
        TimeRow row = new TimeRow(this.locationCategory.getMondayRow());
        this.locationCategory.getMondayRow().getListTimeRow().add(row);
        this.mondayPanel.add(row.getPanel());
        if (this.locationCategory.getCity().getModel() == null) {
            this.locationCategory.getCity().getMainFrame().setCitySavedButtonEnable();
        }
        int newHeight = this.mondayPanel.getHeight() + 35;
        this.mondayPanel.setPreferredSize(new Dimension(this.mondayPanel.getWidth(), newHeight));
        this.mondayPanel.revalidate();
    }//GEN-LAST:event_mondayAddButtonActionPerformed

    private void tuesdayAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuesdayAddButtonActionPerformed
        for (TimeRow tr : this.locationCategory.getTuesdayRow().getListTimeRow()) {
            if (!tr.isMinValid() || !tr.isMaxValid()) {
                JOptionPane.showOptionDialog(this.mainFrame, Messages.cantAddNewtimeInterval(), "Warning", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                return;
            }
        }
        TimeRow row = new TimeRow(this.locationCategory.getTuesdayRow());
        this.locationCategory.getTuesdayRow().getListTimeRow().add(row);
        this.tuesdayPanel.add(row.getPanel());
        if (this.locationCategory.getCity().getModel() == null) {
            this.locationCategory.getCity().getMainFrame().setCitySavedButtonEnable();
        }
        int newHeight = this.tuesdayPanel.getHeight() + 35;
        this.tuesdayPanel.setPreferredSize(new Dimension(this.tuesdayPanel.getWidth(), newHeight));
        this.tuesdayPanel.revalidate();
    }//GEN-LAST:event_tuesdayAddButtonActionPerformed

    private void wednesdayAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wednesdayAddButtonActionPerformed
        for (TimeRow tr : this.locationCategory.getWednesdayRow().getListTimeRow()) {
            if (!tr.isMinValid() || !tr.isMaxValid()) {
                JOptionPane.showOptionDialog(this.mainFrame, Messages.cantAddNewtimeInterval(), "Warning", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                return;
            }
        }
        TimeRow row = new TimeRow(this.locationCategory.getWednesdayRow());
        this.locationCategory.getWednesdayRow().getListTimeRow().add(row);
        this.wednesdayPanel.add(row.getPanel());
        if (this.locationCategory.getCity().getModel() == null) {
            this.locationCategory.getCity().getMainFrame().setCitySavedButtonEnable();
        }
        int newHeight = this.wednesdayPanel.getHeight() + 35;
        this.wednesdayPanel.setPreferredSize(new Dimension(this.wednesdayPanel.getWidth(), newHeight));
        this.wednesdayPanel.revalidate();
    }//GEN-LAST:event_wednesdayAddButtonActionPerformed

    private void thursdayAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thursdayAddButtonActionPerformed
        for (TimeRow tr : this.locationCategory.getThursdayRow().getListTimeRow()) {
            if (!tr.isMinValid() || !tr.isMaxValid()) {
                JOptionPane.showOptionDialog(this.mainFrame, Messages.cantAddNewtimeInterval(), "Warning", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                return;
            }
        }
        TimeRow row = new TimeRow(this.locationCategory.getThursdayRow());
        this.locationCategory.getThursdayRow().getListTimeRow().add(row);
        this.thursdayPanel.add(row.getPanel());
        if (this.locationCategory.getCity().getModel() == null) {
            this.locationCategory.getCity().getMainFrame().setCitySavedButtonEnable();
        }
        int newHeight = this.thursdayPanel.getHeight() + 35;
        this.thursdayPanel.setPreferredSize(new Dimension(this.thursdayPanel.getWidth(), newHeight));
        this.thursdayPanel.revalidate();
    }//GEN-LAST:event_thursdayAddButtonActionPerformed

    private void fridayAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fridayAddButtonActionPerformed
        for (TimeRow tr : this.locationCategory.getFridayRow().getListTimeRow()) {
            if (!tr.isMinValid() || !tr.isMaxValid()) {
                JOptionPane.showOptionDialog(this.mainFrame, Messages.cantAddNewtimeInterval(), "Warning", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                return;
            }
        }
        TimeRow row = new TimeRow(this.locationCategory.getFridayRow());
        this.locationCategory.getFridayRow().getListTimeRow().add(row);
        this.fridayPanel.add(row.getPanel());
        if (this.locationCategory.getCity().getModel() == null) {
            this.locationCategory.getCity().getMainFrame().setCitySavedButtonEnable();
        }
        int newHeight = this.fridayPanel.getHeight() + 35;
        this.fridayPanel.setPreferredSize(new Dimension(this.fridayPanel.getWidth(), newHeight));
        this.fridayPanel.revalidate();
    }//GEN-LAST:event_fridayAddButtonActionPerformed

    private void saturdayAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saturdayAddButtonActionPerformed
        for (TimeRow tr : this.locationCategory.getSatursayRow().getListTimeRow()) {
            if (!tr.isMinValid() || !tr.isMaxValid()) {
                JOptionPane.showOptionDialog(this.mainFrame, Messages.cantAddNewtimeInterval(), "Warning", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                return;
            }
        }
        TimeRow row = new TimeRow(this.locationCategory.getSatursayRow());
        this.locationCategory.getSatursayRow().getListTimeRow().add(row);
        this.saturdayPanel.add(row.getPanel());
        if (this.locationCategory.getCity().getModel() == null) {
            this.locationCategory.getCity().getMainFrame().setCitySavedButtonEnable();
        }
        int newHeight = this.saturdayPanel.getHeight() + 35;
        this.saturdayPanel.setPreferredSize(new Dimension(this.saturdayPanel.getWidth(), newHeight));
        this.saturdayPanel.revalidate();
    }//GEN-LAST:event_saturdayAddButtonActionPerformed

    private void sundayAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sundayAddButtonActionPerformed
        for (TimeRow tr : this.locationCategory.getSundayRow().getListTimeRow()) {
            if (!tr.isMinValid() || !tr.isMaxValid()) {
                JOptionPane.showOptionDialog(this.mainFrame, Messages.cantAddNewtimeInterval(), "Warning", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                return;
            }
        }
        TimeRow row = new TimeRow(this.locationCategory.getSundayRow());
        this.locationCategory.getSundayRow().getListTimeRow().add(row);
        this.sundayPanel.add(row.getPanel());
        if (this.locationCategory.getCity().getModel() == null) {
            this.locationCategory.getCity().getMainFrame().setCitySavedButtonEnable();
        }
        int newHeight = this.sundayPanel.getHeight() + 35;
        this.sundayPanel.setPreferredSize(new Dimension(this.sundayPanel.getWidth(), newHeight));
        this.sundayPanel.revalidate();
    }//GEN-LAST:event_sundayAddButtonActionPerformed

    private void setMondayPanelEnable(boolean ok) {
        this.mondayAddButton.setEnabled(ok);
        this.mondayAddButton.setEnabled(ok);
        for (TimeRow tr : this.locationCategory.getMondayRow().getListTimeRow()) {
            tr.getPanel().setEnable(ok);
        }
    }

    private void setTuesdayPanelEnable(boolean ok) {
        this.tuesdayAddButton.setEnabled(ok);
        this.tuesdayPanel.setEnabled(ok);
        for (TimeRow tr : this.locationCategory.getTuesdayRow().getListTimeRow()) {
            tr.getPanel().setEnable(ok);
        }
    }

    private void setWednesdayPanelEnable(boolean ok) {
        this.wednesdayAddButton.setEnabled(ok);
        this.wednesdayPanel.setEnabled(ok);
        for (TimeRow tr : this.locationCategory.getWednesdayRow().getListTimeRow()) {
            tr.getPanel().setEnable(ok);
        }
    }

    private void setThursdayPanelEnable(boolean ok) {
        this.thursdayAddButton.setEnabled(ok);
        this.thursdayPanel.setEnabled(ok);
        for (TimeRow tr : this.locationCategory.getThursdayRow().getListTimeRow()) {
            tr.getPanel().setEnable(ok);
        }
    }

    private void setFridayPanelEnable(boolean ok) {
        this.fridayAddButton.setEnabled(ok);
        this.fridayPanel.setEnabled(ok);
        for (TimeRow tr : this.locationCategory.getFridayRow().getListTimeRow()) {
            tr.getPanel().setEnable(ok);
        }
    }

    private void setSaturdayPanelEnable(boolean ok) {
        this.saturdayAddButton.setEnabled(ok);
        this.saturdayPanel.setEnabled(ok);
        for (TimeRow tr : this.locationCategory.getSatursayRow().getListTimeRow()) {
            tr.getPanel().setEnable(ok);
        }
    }

    private void setSundayPanelEnable(boolean ok) {
        this.sundayAddButton.setEnabled(ok);
        this.sundayPanel.setEnabled(ok);
        for (TimeRow tr : this.locationCategory.getSundayRow().getListTimeRow()) {
            tr.getPanel().setEnable(ok);
        }
    }

    private class JTextFieldDoubleListener implements DocumentListener, FocusListener {

        private final JTextField jtextField;
        private String currentString;
        private boolean insert = false;

        public JTextFieldDoubleListener(JTextField textField) {
            this.jtextField = textField;
            this.currentString = textField.getText();
        }

        private void insertZero(String s) {
            Runnable doHighlight = () -> {
                jtextField.setText(s);
            };
            SwingUtilities.invokeLater(doHighlight);
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            String numTxt = this.jtextField.getText();
            if (numTxt.contains("f") || numTxt.contains("d")) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(locationCategory.getCity().getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
            }
            try {
                if (numTxt.contains(" ")) {
                    this.insert = true;
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(locationCategory.getCity().getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(this.currentString);
                    return;
                }

                Double d = Double.parseDouble(numTxt);
                if (d > 100) {
                    Runnable doHighlight = () -> {
                        JOptionPane.showOptionDialog(locationCategory.getCity().getMainFrame(), Messages.percentageCanBbeGreaterThen100(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    };
                    SwingUtilities.invokeLater(doHighlight);
                    insertZero(this.currentString);
                    this.insert = false;
                } else if (!insert) {
                    this.currentString = numTxt;
                    locationCategory.setPercentageToBeSick(Integer.parseInt(numTxt));
                }

            } catch (NumberFormatException ex) {
                this.insert = true;
                Runnable doHighlight = () -> {
                    JOptionPane.showOptionDialog(locationCategory.getCity().getMainFrame(), Messages.badNumberFormat(), Messages.error(), JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                };
                SwingUtilities.invokeLater(doHighlight);
                insertZero(this.currentString);
            }
            this.insert = false;
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if (insert) {
                return;
            }
            String s = this.jtextField.getText();
            if (s.length() <= 0 || s.equals("")) {
                return;
            }
            this.currentString = s;
            locationCategory.setPercentageToBeSick(Integer.parseInt(this.currentString));

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
            String numTxt = this.jtextField.getText();
            if (numTxt.equals("")) {
                insert = true;
                insertZero(this.currentString);
            } else if (numTxt.startsWith(".")) {
                this.currentString = "0" + this.currentString;
                insert = true;
                insertZero(this.currentString);
            } else if (numTxt.endsWith(".")) {
                this.currentString = this.currentString + "0";
                insertZero(this.currentString);
            } else {
                insert = false;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fridayAddButton;
    private javax.swing.JCheckBox fridayBox;
    public javax.swing.JPanel fridayPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel kindLabel1;
    private javax.swing.JButton mondayAddButton;
    private javax.swing.JCheckBox mondayBox;
    public javax.swing.JPanel mondayPanel;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JLabel percentageToInfectLabel;
    private javax.swing.JTextField percentageToInfectTxt;
    private javax.swing.JLabel quantityLabel1;
    private javax.swing.JButton saturdayAddButton;
    private javax.swing.JCheckBox saturdayBox;
    public javax.swing.JPanel saturdayPanel;
    private javax.swing.JButton sundayAddButton;
    private javax.swing.JCheckBox sundayBox;
    public javax.swing.JPanel sundayPanel;
    private javax.swing.JButton thursdayAddButton;
    private javax.swing.JCheckBox thursdayBox;
    public javax.swing.JPanel thursdayPanel;
    private javax.swing.JButton tuesdayAddButton;
    private javax.swing.JCheckBox tuesdayBox;
    public javax.swing.JPanel tuesdayPanel;
    private javax.swing.JButton wednesdayAddButton;
    private javax.swing.JCheckBox wednesdayBox;
    public javax.swing.JPanel wednesdayPanel;
    // End of variables declaration//GEN-END:variables
}
