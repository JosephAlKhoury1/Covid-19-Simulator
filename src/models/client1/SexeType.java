package models.client1;

import controller.controllers.SexeTypeController;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import views1.MainFrame;

public class SexeType extends javax.swing.JPanel {

    private int id;
    private String name;
    private double percentage;
    private City city;

    private boolean isNew, saved, deleted;

    private JTextFieldDoubleListener perListener;
    private JTextFieldStringListener nameListner;

    private Component component;

    public SexeType(int id, String name, double per) {
        initComponents();
        this.id = id;
        this.name = name;
        this.percentage = per;
        this.nameTxt.setText(this.name);
        this.percentageTxt.setText(this.percentage + "");

        this.isNew = false;
        this.saved = true;
        this.deleted = false;

        this.perListener = new JTextFieldDoubleListener(this.percentageTxt, this.percentage + "", this);
        this.percentageTxt.getDocument().addDocumentListener(perListener);
        this.percentageTxt.addFocusListener(perListener);

        this.nameListner = new JTextFieldStringListener(nameTxt, this);
        this.nameTxt.getDocument().addDocumentListener(this.nameListner);
        this.nameTxt.addFocusListener(this.nameListner);
        this.nameTxt.addMouseListener(this.nameListner);
    }

    public SexeType(String name, double per, City city) {
        initComponents();
        this.name = name;
        this.percentage = per;
        this.city = city;
        this.nameTxt.setText(this.name);
        this.percentageTxt.setText(this.percentage + "");

        this.isNew = true;
        this.saved = false;
        this.deleted = false;

        this.perListener = new JTextFieldDoubleListener(this.percentageTxt, city.getMainFrame(), this.percentage + "", this);
        this.percentageTxt.getDocument().addDocumentListener(perListener);
        this.percentageTxt.addFocusListener(perListener);

        this.nameListner = new JTextFieldStringListener(nameTxt, city.getMainFrame(), this);
        this.nameTxt.getDocument().addDocumentListener(this.nameListner);
        this.nameTxt.addFocusListener(this.nameListner);
        this.nameTxt.addMouseListener(this.nameListner);
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
        this.perListener.setMainFrame(city.getMainFrame());
        this.nameListner.setMainFrame(city.getMainFrame());
    }

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void save() {
        if (this.isDeleted()) {
            SexeTypeController.INSTANCE.delete(this.id);
            return;
        }
        if (this.isNew) {
            SexeTypeController.INSTANCE.insert(this);
            this.setSaved(true);
            this.setIsNew(false);
        } else {
            if (!this.isSaved()) {
                SexeTypeController.INSTANCE.update(this);
                this.setSaved(true);
            } else {

            }
        }
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nameTxt = new javax.swing.JTextField();
        percentageTxt = new javax.swing.JTextField();

        setAlignmentX(Component.LEFT_ALIGNMENT);
        setMaximumSize(new java.awt.Dimension(250, 35));
        setMinimumSize(new java.awt.Dimension(250, 35));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(250, 35));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMaximumSize(new java.awt.Dimension(250, 35));
        jPanel1.setMinimumSize(new java.awt.Dimension(250, 35));
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 35));

        nameTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameTxt.setToolTipText("");
        nameTxt.setEnabled(false);
        nameTxt.setMaximumSize(new java.awt.Dimension(110, 31));
        nameTxt.setMinimumSize(new java.awt.Dimension(110, 31));
        nameTxt.setPreferredSize(new java.awt.Dimension(120, 31));

        percentageTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        percentageTxt.setText("10.0");
        percentageTxt.setToolTipText("");
        percentageTxt.setMaximumSize(new java.awt.Dimension(80, 31));
        percentageTxt.setMinimumSize(new java.awt.Dimension(80, 31));
        percentageTxt.setPreferredSize(new java.awt.Dimension(120, 31));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(percentageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(percentageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTextField percentageTxt;
    // End of variables declaration//GEN-END:variables

    private class JTextFieldDoubleListener implements DocumentListener, FocusListener {

        private final JTextField jtextField;
        private MainFrame mainFrame;
        private String currentString;
        private final String greaterMessage = "Number can't be greater 100!";
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = false;
        private SexeType sexType;

        public JTextFieldDoubleListener(JTextField textField, MainFrame mainFrame, String value, SexeType sexeType) {
            this.jtextField = textField;
            this.mainFrame = mainFrame;
            this.currentString = value;
            this.sexType = sexeType;
        }

        public JTextFieldDoubleListener(JTextField textField, String value, SexeType sexeType) {
            this.jtextField = textField;
            this.currentString = value;
            this.sexType = sexeType;
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
                saved = false;
                this.insert = false;
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if (city != null) {
                mainFrame.setCitySavedButtonEnable();
                saved = false;
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
                        this.sexType.setDeleted(true);
                        city.getMainFrame().getCurrentCityPanel().removeSexeType(this.sexType);
                        city.removeSexeType(this.sexType);
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
                this.sexType.setPercentage(Double.parseDouble(this.currentString));
            }
        }

    }

    private class JTextFieldStringListener implements DocumentListener, FocusListener, MouseListener {

        private final JTextField jtextField;
        private MainFrame mainFrame;
        private String currentString = name;
        private SexeType sexeType;

        public JTextFieldStringListener(JTextField textField, MainFrame mainFrame, SexeType s) {
            this.jtextField = textField;
            this.mainFrame = mainFrame;
            this.sexeType = s;
        }

        public JTextFieldStringListener(JTextField textField, SexeType s) {
            this.jtextField = textField;
            this.sexeType = s;
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
                city.setIsSaved(false);
                this.sexeType.setSaved(false);
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if (city != null) {
                mainFrame.setCitySavedButtonEnable();
                city.setIsSaved(false);
                this.sexeType.setSaved(false);
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
            this.sexeType.setName(this.currentString);
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
