package models.client1;

import controller.controllers.ReligionTypeController;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import views1.MainFrame;

public class ReligionType extends javax.swing.JPanel {

    private int id;
    private String name;
    private double percentage;
    private City city;
    private String prayLocation;
    private JTextFieldDoubleListener listener;
    private JTextFieldStringListener listn;

    private boolean isNew, isSaved, isdelete;

    private Component comp;

    public ReligionType(String name, double percentage, String prayLoc, City c) {
        initComponents();
        this.name = name;
        this.percentage = percentage;
        this.prayLocation = prayLoc;
        this.city = c;
        this.nameTxt.setText(name);
        this.percentageTxt.setText(percentage + "");
        this.listener = new JTextFieldDoubleListener(this.percentageTxt, c.getMainFrame(), this.percentage + "", this);
        this.percentageTxt.getDocument().addDocumentListener(this.listener);
        this.percentageTxt.addFocusListener(listener);

        this.comp = Box.createVerticalStrut(3);

        this.listn = new JTextFieldStringListener(this.nameTxt, c.getMainFrame());
        this.nameTxt.addMouseListener(listn);
        this.nameTxt.getDocument().addDocumentListener(listn);
        this.nameTxt.addFocusListener(listn);
        this.isNew = true;
        this.isSaved = false;
        this.isdelete = false;
    }

    public ReligionType(int id, String name, double percentage, String prayLoc) {
        initComponents();
        this.id = id;
        this.name = name;
        this.percentage = percentage;
        this.prayLocation = prayLoc;
        this.nameTxt.setText(name);
        this.percentageTxt.setText(percentage + "");
        this.listener = new JTextFieldDoubleListener(this.percentageTxt, this.percentage + "", this);
        this.percentageTxt.getDocument().addDocumentListener(this.listener);
        this.percentageTxt.addFocusListener(this.listener);

        this.comp = Box.createVerticalStrut(3);

        this.listn = new JTextFieldStringListener(this.nameTxt);
        this.nameTxt.addMouseListener(listn);
        this.nameTxt.getDocument().addDocumentListener(listn);
        this.nameTxt.addFocusListener(listn);
        this.isNew = false;
        this.isSaved = true;
        this.isdelete = false;
    }

    public String getPrayLocation() {
        return prayLocation;
    }

    public void setPrayLocation(String prayLocation) {
        this.prayLocation = prayLocation;
    }

    public int getId() {
        return id;
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

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
        this.listener.setMainFrame(this.city.getMainFrame());
        this.listn.setMainFrame(this.city.getMainFrame());
    }

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public boolean isIsSaved() {
        return isSaved;
    }

    public void setIsSaved(boolean isSaved) {
        this.isSaved = isSaved;
    }

    public boolean isIsdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }

    public void save() {
        System.out.println("save:" + name);
        if (this.isdelete) {
            ReligionTypeController.INSTANCE.delete(this.id);
            return;
        }
        if (this.isNew) {
            System.out.println("new");
            this.id = ReligionTypeController.INSTANCE.insert(this);
            this.setIsNew(false);
            this.setIsSaved(true);
        } else {

            System.out.println("old");
            if (!this.isSaved) {
                System.out.println("not saved:" + name);
                ReligionTypeController.INSTANCE.update(this);
            } else {

            }
        }
    }

    public Component getComp() {
        return comp;
    }

    public void setComp(Component comp) {
        this.comp = comp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nameTxt = new javax.swing.JTextField();
        percentageTxt = new javax.swing.JTextField();
        removeButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setMaximumSize(new java.awt.Dimension(426, 35));
        setMinimumSize(new java.awt.Dimension(426, 35));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(424, 35));

        jPanel1.setMaximumSize(new java.awt.Dimension(420, 35));
        jPanel1.setMinimumSize(new java.awt.Dimension(420, 35));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(420, 31));

        nameTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameTxt.setText("0");
        nameTxt.setToolTipText("");
        nameTxt.setEnabled(false);
        nameTxt.setMaximumSize(new java.awt.Dimension(110, 31));
        nameTxt.setMinimumSize(new java.awt.Dimension(110, 31));
        nameTxt.setPreferredSize(new java.awt.Dimension(110, 31));

        percentageTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        percentageTxt.setText("0.0");
        percentageTxt.setToolTipText("");
        percentageTxt.setMaximumSize(new java.awt.Dimension(80, 31));
        percentageTxt.setMinimumSize(new java.awt.Dimension(80, 31));
        percentageTxt.setPreferredSize(new java.awt.Dimension(80, 31));

        removeButton.setText("-");
        removeButton.setToolTipText("");
        removeButton.setMaximumSize(new java.awt.Dimension(37, 31));
        removeButton.setMinimumSize(new java.awt.Dimension(37, 31));
        removeButton.setPreferredSize(new java.awt.Dimension(37, 31));
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed1(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(percentageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jComboBox1, 0, 163, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(percentageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("joseph");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void removeButtonActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed1
        this.city.removeReligion(this);
        this.city.getMainFrame().getCurrentCityPanel().removeReligion(this);
        this.city.setIsSaved(false);
        this.isSaved = false;
        this.isdelete = true;
    }//GEN-LAST:event_removeButtonActionPerformed1


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTextField percentageTxt;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables

    private class JTextFieldDoubleListener implements DocumentListener, FocusListener {

        private final JTextField jtextField;
        private MainFrame mainFrame;
        private String currentString;
        private final String greaterMessage = "Number can't be greater 100!";
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = false;
        private ReligionType religion;

        public JTextFieldDoubleListener(JTextField textField, MainFrame mainFrame, String value, ReligionType religion) {
            this.jtextField = textField;
            this.mainFrame = mainFrame;
            this.currentString = value;
            this.religion = religion;
        }

        public JTextFieldDoubleListener(JTextField textField, String value, ReligionType religion) {
            this.jtextField = textField;
            this.currentString = value;
            this.religion = religion;
        }

        public MainFrame getMainFrame() {
            return mainFrame;
        }

        public void setMainFrame(MainFrame mainFrame) {
            this.mainFrame = mainFrame;
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
                JOptionPane.showOptionDialog(this.mainFrame, this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                insertZero(this.currentString);
            }
            try {
                Double d = Double.parseDouble(numTxt);
                if (d > 100) {
                    JOptionPane.showOptionDialog(this.mainFrame, this.greaterMessage, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    insertZero(this.currentString);
                    this.insert = false;
                }
            } catch (NumberFormatException ex) {
                this.insert = true;
                JOptionPane.showOptionDialog(this.mainFrame, this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                insertZero(this.currentString);
            }
            if (city != null) {
                mainFrame.setCitySavedButtonEnable();
                isSaved = false;
                this.insert = false;
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if (city != null) {
                mainFrame.setCitySavedButtonEnable();
                isSaved = false;
                this.insert = false;
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }

        @Override
        public void focusGained(FocusEvent e) {
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (!insert) {
                if (this.jtextField.getText().equals("")) {
                    insertZero(this.currentString);
                    return;
                }
                double d = Double.parseDouble(this.jtextField.getText());
                if (d <= 0) {
                    String message = "Percentage can't be 0! "
                            + "Do you want to remove this religion?";
                    int reply = JOptionPane.showOptionDialog(this.mainFrame, message, this.badNumberValueTitle, JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    if (reply == JOptionPane.YES_OPTION) {
                        this.religion.setIsdelete(true);
                        city.getMainFrame().getCurrentCityPanel().removeReligion(this.religion);
                        city.removeReligion(religion);
                        city.getMainFrame().setCitySavedButtonEnable();
                    } else if (reply == JOptionPane.NO_OPTION) {
                        insertZero(this.currentString);
                        return;
                    }
                }
                int index = this.jtextField.getText().lastIndexOf('.');
                int len = this.jtextField.getText().length();
                String s = this.jtextField.getText();
                if (index == (len - 1)) {
                    s += 0;
                }
                this.currentString = s;
                this.religion.setPercentage(Double.parseDouble(s));
            }
        }

    }

    private class JTextFieldStringListener implements DocumentListener, FocusListener, MouseListener {

        private final JTextField jtextField;
        private MainFrame mainFrame;
        private String currentString = name;

        public JTextFieldStringListener(JTextField textField, MainFrame mainFrame) {
            this.jtextField = textField;
            this.mainFrame = mainFrame;
        }

        public JTextFieldStringListener(JTextField textField) {
            this.jtextField = textField;
        }

        public MainFrame getMainFrame() {
            return mainFrame;
        }

        public void setMainFrame(MainFrame mainFrame) {
            this.mainFrame = mainFrame;
        }

        private void insertZero(String s) {
            Runnable doHighlight = () -> {
                jtextField.setText(s);
            };
            SwingUtilities.invokeLater(doHighlight);
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            if (city != null) {
                mainFrame.setCitySavedButtonEnable();
                isSaved = false;
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if (city != null) {
                mainFrame.setCitySavedButtonEnable();
                isSaved = false;
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }

        @Override
        public void focusGained(FocusEvent e) {
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (this.jtextField.getText().equals("")) {
                insertZero(this.currentString);
                return;
            }
            this.currentString = this.jtextField.getText();
            name = this.currentString;
            this.jtextField.setEnabled(false);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                this.jtextField.setEnabled(true);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

}
