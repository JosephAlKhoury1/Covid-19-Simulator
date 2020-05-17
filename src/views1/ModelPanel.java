package views1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import models.model.Model;

/**
 *
 * @author Joseph
 */
public class ModelPanel extends javax.swing.JPanel {

    private final JTabbedPane pane;
    private final ButtonTilte button;
    private Model currentModel;
    private MainFrame frame;
    private final List<JTextField> listDoubleJTexteField;
    private final List<JTextField> listIntegerJTextFields;

    public Model getModel() {
        return currentModel;
    }

    public void setModel(Model model) {
        this.currentModel = model;
    }

    public ModelPanel(MainFrame frame, JTabbedPane pane) {
        initComponents();
        this.pane = pane;
        this.frame = frame;
        this.button = new ButtonTilte(this);
        this.listDoubleJTexteField = new ArrayList();
        this.listIntegerJTextFields = new ArrayList();
        this.listDoubleJTexteField.add(this.noSymHumPerTxt);
        this.listDoubleJTexteField.add(this.noSymDeathPerTxt);
        this.listDoubleJTexteField.add(this.mildSymHumPerTxt);
        this.listDoubleJTexteField.add(this.mildSymdeathPerTxt);
        this.listDoubleJTexteField.add(this.sevSymHumPerTxt);
        this.listDoubleJTexteField.add(this.sevSympDeathPerTxt);
        this.listDoubleJTexteField.add(this.criSymHumPerTxt);
        this.listDoubleJTexteField.add(this.criSymDeathPerTxt);

        this.listDoubleJTexteField.add(this.deathPerNoSymDaysTxt);
        this.listDoubleJTexteField.add(this.deathPerMildDaysTxt);
        this.listDoubleJTexteField.add(this.deathPerSevDaysTxt);
        this.listDoubleJTexteField.add(this.deathPerHosDaysTxt);
        this.listDoubleJTexteField.add(this.deathPerIcuDaysTxt);

        this.listDoubleJTexteField.add(this.imunePerNoSymDayTxt);
        this.listDoubleJTexteField.add(this.imunePerMildDaysTxt);
        this.listDoubleJTexteField.add(this.imunePerSevDayxTxt);
        this.listDoubleJTexteField.add(this.imunePerHosDaysTxt);
        this.listDoubleJTexteField.add(this.imunePerIcuDaysTxt);

        this.listIntegerJTextFields.add(this.noSymContDayTxt);
        this.listIntegerJTextFields.add(this.mildSymConDayTxt);
        this.listIntegerJTextFields.add(this.sevSymContDayTxt);
        this.listIntegerJTextFields.add(this.criSymContDayTxt);

        this.listIntegerJTextFields.add(this.noSymNoSymDayTxt);
        this.listIntegerJTextFields.add(this.noSymMildSymDayTxt);
        this.listIntegerJTextFields.add(this.noSymSevSymDayTxt);
        this.listIntegerJTextFields.add(this.noSymHosSymDaysTxt);
        this.listIntegerJTextFields.add(this.noSymIcuDaysTxt);

        this.listIntegerJTextFields.add(this.mildSymNoSymdaytxt);
        this.listIntegerJTextFields.add(this.mildSymMildSymDayTxt);
        this.listIntegerJTextFields.add(this.milSymSevSymdayTxt);
        this.listIntegerJTextFields.add(this.mildSymHosSymDayTxt);
        this.listIntegerJTextFields.add(this.mildSymIcuDaysTxt);

        this.listIntegerJTextFields.add(this.sevSymNoSymdayTxt);
        this.listIntegerJTextFields.add(this.sevSymMildSymDayTxt);
        this.listIntegerJTextFields.add(this.sevSymSevSymDayTxt);
        this.listIntegerJTextFields.add(this.sevSymHosSymDaysTxt);
        this.listIntegerJTextFields.add(this.sevSymIcudaysTxt);

        this.listIntegerJTextFields.add(this.criSymNoSymDayTxt);
        this.listIntegerJTextFields.add(this.criSymMildSymDayTxt);
        this.listIntegerJTextFields.add(this.criSymSevSymDaysTxt);
        this.listIntegerJTextFields.add(this.criSymHosSymdaysTxt);
        this.listIntegerJTextFields.add(this.criSymIcuDaysTxt);
        this.listDoubleJTexteField.forEach((jtf) -> {
            JTextFieldDoubleListener ja1 = new JTextFieldDoubleListener(jtf, this.frame);
            jtf.getDocument().addDocumentListener(ja1);
            jtf.addFocusListener(ja1);
        });

        this.listIntegerJTextFields.forEach((jtf) -> {
            JTextFieldIntegerListener ja1 = new JTextFieldIntegerListener(jtf, this.frame);
            jtf.getDocument().addDocumentListener(ja1);
            jtf.addFocusListener(ja1);
        });
    }

    public ButtonTilte getButton() {
        return button;
    }

    public void setJtextFieldsModelValues(Model m) {
        this.noSymHumPerTxt.setText(m.getNoSymptoms().getPercentage() + "");
        this.mildSymHumPerTxt.setText(m.getMildSymptoms().getPercentage() + "");
        this.sevSymHumPerTxt.setText(m.getSevereSymptoms().getPercentage() + "");
        this.criSymHumPerTxt.setText(m.getCriticalSymptoms().getPercentage() + "");

        this.noSymDeathPerTxt.setText(m.getNoSymptoms().getDeathPercentage() + "");
        this.mildSymdeathPerTxt.setText(m.getMildSymptoms().getDeathPercentage() + "");
        this.sevSympDeathPerTxt.setText(m.getSevereSymptoms().getDeathPercentage() + "");
        this.criSymDeathPerTxt.setText(m.getCriticalSymptoms().getDeathPercentage() + "");

        this.noSymContDayTxt.setText(m.getNoSymptoms().getContagiousDays() + "");
        this.mildSymConDayTxt.setText(m.getMildSymptoms().getContagiousDays() + "");
        this.sevSymContDayTxt.setText(m.getSevereSymptoms().getContagiousDays() + "");
        this.criSymContDayTxt.setText(m.getCriticalSymptoms().getContagiousDays() + "");

        this.noSymNoSymDayTxt.setText(m.getNoSymptoms().getNoSymptoms().getDay() + "");
        this.mildSymNoSymdaytxt.setText(m.getMildSymptoms().getNoSymptoms().getDay() + "");
        this.sevSymNoSymdayTxt.setText(m.getSevereSymptoms().getNoSymptoms().getDay() + "");
        this.criSymNoSymDayTxt.setText(m.getCriticalSymptoms().getNoSymptoms().getDay() + "");
        this.deathPerNoSymDaysTxt.setText(m.getNoSymptoms().getNoSymptoms().getDeathPercentage() + "");
        this.imunePerNoSymDayTxt.setText(m.getNoSymptoms().getNoSymptoms().getImmunePercentage() + "");

        this.noSymMildSymDayTxt.setText(m.getNoSymptoms().getMildSymptoms().getDay() + "");
        this.mildSymMildSymDayTxt.setText(m.getMildSymptoms().getMildSymptoms().getDay() + "");
        this.sevSymMildSymDayTxt.setText(m.getSevereSymptoms().getMildSymptoms().getDay() + "");
        this.criSymMildSymDayTxt.setText(m.getCriticalSymptoms().getMildSymptoms().getDay() + "");
        this.deathPerMildDaysTxt.setText(m.getMildSymptoms().getMildSymptoms().getDeathPercentage() + "");
        this.imunePerMildDaysTxt.setText(m.getMildSymptoms().getMildSymptoms().getImmunePercentage() + "");

        this.noSymSevSymDayTxt.setText(m.getNoSymptoms().getSevereSymptoms().getDay() + "");
        this.milSymSevSymdayTxt.setText(m.getMildSymptoms().getSevereSymptoms().getDay() + "");
        this.sevSymSevSymDayTxt.setText(m.getSevereSymptoms().getSevereSymptoms().getDay() + "");
        this.criSymSevSymDaysTxt.setText(m.getCriticalSymptoms().getSevereSymptoms().getDay() + "");
        this.deathPerSevDaysTxt.setText(m.getSevereSymptoms().getSevereSymptoms().getDeathPercentage() + "");
        this.imunePerSevDayxTxt.setText(m.getSevereSymptoms().getSevereSymptoms().getImmunePercentage() + "");

        this.noSymHosSymDaysTxt.setText(m.getNoSymptoms().getHospitalization().getDay() + "");
        this.mildSymHosSymDayTxt.setText(m.getMildSymptoms().getHospitalization().getDay() + "");
        this.sevSymHosSymDaysTxt.setText(m.getSevereSymptoms().getHospitalization().getDay() + "");
        this.criSymHosSymdaysTxt.setText(m.getCriticalSymptoms().getHospitalization().getDay() + "");
        this.deathPerHosDaysTxt.setText(m.getCriticalSymptoms().getHospitalization().getDeathPercentage() + "");
        this.imunePerHosDaysTxt.setText(m.getCriticalSymptoms().getHospitalization().getImmunePercentage() + "");

        this.noSymIcuDaysTxt.setText(m.getNoSymptoms().getIcu().getDay() + "");
        this.mildSymIcuDaysTxt.setText(m.getMildSymptoms().getIcu().getDay() + "");
        this.sevSymIcudaysTxt.setText(m.getSevereSymptoms().getIcu().getDay() + "");
        this.criSymIcuDaysTxt.setText(m.getCriticalSymptoms().getIcu().getDay() + "");
        this.deathPerIcuDaysTxt.setText(m.getCriticalSymptoms().getIcu().getDeathPercentage() + "");
        this.imunePerIcuDaysTxt.setText(m.getCriticalSymptoms().getIcu().getImmunePercentage() + "");
    }

    public void initModelParameters() {
        double sp1, sp2, sp3, sp4;
        sp1 = Double.parseDouble(this.noSymHumPerTxt.getText());
        this.currentModel.getNoSymptoms().setPercentage(sp1);
        sp2 = Double.parseDouble(this.mildSymHumPerTxt.getText());
        this.currentModel.getMildSymptoms().setPercentage(sp2);
        sp3 = Double.parseDouble(this.sevSymHumPerTxt.getText());
        this.currentModel.getSevereSymptoms().setPercentage(sp3);
        sp4 = Double.parseDouble(this.criSymHumPerTxt.getText());
        this.currentModel.getCriticalSymptoms().setPercentage(sp4);

        double sd1, sd2, sd3, sd4;
        sd1 = Double.parseDouble(this.noSymDeathPerTxt.getText());
        this.currentModel.getNoSymptoms().setDeathPercentage(sd1);
        sd2 = Double.parseDouble(this.mildSymdeathPerTxt.getText());
        this.currentModel.getMildSymptoms().setDeathPercentage(sd2);
        sd3 = Double.parseDouble(this.sevSympDeathPerTxt.getText());
        this.currentModel.getSevereSymptoms().setDeathPercentage(sd3);
        sd4 = Double.parseDouble(this.criSymDeathPerTxt.getText());
        this.currentModel.getCriticalSymptoms().setDeathPercentage(sd4);

        int sc1, sc2, sc3, sc4;
        sc1 = Integer.parseInt(this.noSymContDayTxt.getText());
        this.currentModel.getNoSymptoms().setContagiousDays(sc1);
        sc2 = Integer.parseInt(this.mildSymConDayTxt.getText());
        this.currentModel.getMildSymptoms().setContagiousDays(sc2);
        sc3 = Integer.parseInt(this.sevSymContDayTxt.getText());
        this.currentModel.getSevereSymptoms().setContagiousDays(sc3);
        sc4 = Integer.parseInt(this.criSymContDayTxt.getText());
        this.currentModel.getCriticalSymptoms().setContagiousDays(sc4);

        int noSym1, noSym2, noSym3, noSym4;
        double noSymd, noSymi;
        noSym1 = Integer.parseInt(this.noSymNoSymDayTxt.getText());
        this.currentModel.getNoSymptoms().getNoSymptoms().setDay(noSym1);
        noSym2 = Integer.parseInt(this.mildSymNoSymdaytxt.getText());
        this.currentModel.getMildSymptoms().getNoSymptoms().setDay(noSym2);
        noSym3 = Integer.parseInt(this.sevSymNoSymdayTxt.getText());
        this.currentModel.getSevereSymptoms().getNoSymptoms().setDay(noSym3);
        noSym4 = Integer.parseInt(this.criSymNoSymDayTxt.getText());
        this.currentModel.getCriticalSymptoms().getNoSymptoms().setDay(noSym4);
        noSymd = Double.parseDouble(this.deathPerNoSymDaysTxt.getText());
        this.currentModel.getNoSymptoms().getNoSymptoms().setDeathPercentage(noSymd);
        this.currentModel.getMildSymptoms().getNoSymptoms().setDeathPercentage(noSymd);
        this.currentModel.getSevereSymptoms().getNoSymptoms().setDeathPercentage(noSymd);
        this.currentModel.getCriticalSymptoms().getNoSymptoms().setDeathPercentage(noSymd);
        noSymi = Double.parseDouble(this.imunePerNoSymDayTxt.getText());
        this.currentModel.getNoSymptoms().getNoSymptoms().setImmunePercentage(noSymi);
        this.currentModel.getMildSymptoms().getNoSymptoms().setImmunePercentage(noSymi);
        this.currentModel.getSevereSymptoms().getNoSymptoms().setImmunePercentage(noSymi);
        this.currentModel.getCriticalSymptoms().getNoSymptoms().setImmunePercentage(noSymi);

        int mildSym1, mildSym2, mildSym3, mildSym4;
        double mildSymd, mildSymi;
        mildSym1 = Integer.parseInt(this.noSymMildSymDayTxt.getText());
        this.currentModel.getNoSymptoms().getMildSymptoms().setDay(mildSym1);
        mildSym2 = Integer.parseInt(this.mildSymMildSymDayTxt.getText());
        this.currentModel.getMildSymptoms().getMildSymptoms().setDay(mildSym2);
        mildSym3 = Integer.parseInt(this.sevSymMildSymDayTxt.getText());
        this.currentModel.getSevereSymptoms().getMildSymptoms().setDay(mildSym3);
        mildSym4 = Integer.parseInt(this.criSymMildSymDayTxt.getText());
        this.currentModel.getCriticalSymptoms().getMildSymptoms().setDay(mildSym4);
        mildSymd = Double.parseDouble(this.deathPerMildDaysTxt.getText());
        this.currentModel.getNoSymptoms().getMildSymptoms().setDeathPercentage(mildSymd);
        this.currentModel.getMildSymptoms().getMildSymptoms().setDeathPercentage(mildSymd);
        this.currentModel.getSevereSymptoms().getMildSymptoms().setDeathPercentage(mildSymd);
        this.currentModel.getCriticalSymptoms().getMildSymptoms().setDeathPercentage(mildSymd);
        mildSymi = Double.parseDouble(this.imunePerMildDaysTxt.getText());
        this.currentModel.getNoSymptoms().getMildSymptoms().setImmunePercentage(mildSymi);
        this.currentModel.getMildSymptoms().getMildSymptoms().setImmunePercentage(mildSymi);
        this.currentModel.getSevereSymptoms().getMildSymptoms().setImmunePercentage(mildSymi);
        this.currentModel.getCriticalSymptoms().getMildSymptoms().setImmunePercentage(mildSymi);

        int sevSym1, sevSym2, sevSym3, sevSym4;
        double sevSymd, sevSymi;
        sevSym1 = Integer.parseInt(this.noSymSevSymDayTxt.getText());
        this.currentModel.getNoSymptoms().getSevereSymptoms().setDay(sevSym1);
        sevSym2 = Integer.parseInt(this.milSymSevSymdayTxt.getText());
        this.currentModel.getMildSymptoms().getSevereSymptoms().setDay(sevSym2);
        sevSym3 = Integer.parseInt(this.sevSymSevSymDayTxt.getText());
        this.currentModel.getSevereSymptoms().getSevereSymptoms().setDay(sevSym3);
        sevSym4 = Integer.parseInt(this.criSymSevSymDaysTxt.getText());
        this.currentModel.getCriticalSymptoms().getSevereSymptoms().setDay(sevSym4);
        sevSymd = Double.parseDouble(this.deathPerSevDaysTxt.getText());
        this.currentModel.getNoSymptoms().getSevereSymptoms().setDeathPercentage(sevSymd);
        this.currentModel.getMildSymptoms().getSevereSymptoms().setDeathPercentage(sevSymd);
        this.currentModel.getSevereSymptoms().getSevereSymptoms().setDeathPercentage(sevSymd);
        this.currentModel.getCriticalSymptoms().getSevereSymptoms().setDeathPercentage(sevSymd);
        sevSymi = Double.parseDouble(this.imunePerSevDayxTxt.getText());
        this.currentModel.getNoSymptoms().getSevereSymptoms().setImmunePercentage(sevSymi);
        this.currentModel.getMildSymptoms().getSevereSymptoms().setImmunePercentage(sevSymi);
        this.currentModel.getSevereSymptoms().getSevereSymptoms().setImmunePercentage(sevSymi);
        this.currentModel.getCriticalSymptoms().getSevereSymptoms().setImmunePercentage(sevSymi);

        int hosSym1, hosSym2, hosSym3, hosSym4;
        double hosSymd, hosSymi;
        hosSym1 = Integer.parseInt(this.noSymHosSymDaysTxt.getText());
        this.currentModel.getNoSymptoms().getHospitalization().setDay(hosSym1);
        hosSym2 = Integer.parseInt(this.mildSymHosSymDayTxt.getText());
        this.currentModel.getMildSymptoms().getHospitalization().setDay(hosSym2);
        hosSym3 = Integer.parseInt(this.sevSymHosSymDaysTxt.getText());
        this.currentModel.getSevereSymptoms().getHospitalization().setDay(hosSym3);
        hosSym4 = Integer.parseInt(this.criSymHosSymdaysTxt.getText());
        this.currentModel.getCriticalSymptoms().getHospitalization().setDay(hosSym4);
        hosSymd = Double.parseDouble(this.deathPerHosDaysTxt.getText());
        this.currentModel.getNoSymptoms().getHospitalization().setDeathPercentage(hosSymd);
        this.currentModel.getMildSymptoms().getHospitalization().setDeathPercentage(hosSymd);
        this.currentModel.getSevereSymptoms().getHospitalization().setDeathPercentage(hosSymd);
        this.currentModel.getCriticalSymptoms().getHospitalization().setDeathPercentage(hosSymd);
        hosSymi = Double.parseDouble(this.imunePerHosDaysTxt.getText());
        this.currentModel.getNoSymptoms().getHospitalization().setImmunePercentage(hosSymi);
        this.currentModel.getMildSymptoms().getHospitalization().setImmunePercentage(hosSymi);
        this.currentModel.getSevereSymptoms().getHospitalization().setImmunePercentage(hosSymi);
        this.currentModel.getCriticalSymptoms().getHospitalization().setImmunePercentage(hosSymi);

        int icuSym1, icuSym2, icuSym3, icuSym4;
        double icuSymd, icuSymi;
        icuSym1 = Integer.parseInt(this.noSymIcuDaysTxt.getText());
        this.currentModel.getNoSymptoms().getIcu().setDay(icuSym1);
        icuSym2 = Integer.parseInt(this.mildSymIcuDaysTxt.getText());
        this.currentModel.getMildSymptoms().getIcu().setDay(icuSym2);
        icuSym3 = Integer.parseInt(this.sevSymIcudaysTxt.getText());
        this.currentModel.getSevereSymptoms().getIcu().setDay(icuSym3);
        icuSym4 = Integer.parseInt(this.criSymIcuDaysTxt.getText());
        this.currentModel.getCriticalSymptoms().getIcu().setDay(icuSym4);
        icuSymd = Double.parseDouble(this.deathPerIcuDaysTxt.getText());
        this.currentModel.getNoSymptoms().getIcu().setDeathPercentage(icuSymd);
        this.currentModel.getMildSymptoms().getIcu().setDeathPercentage(icuSymd);
        this.currentModel.getSevereSymptoms().getIcu().setDeathPercentage(icuSymd);
        this.currentModel.getCriticalSymptoms().getIcu().setDeathPercentage(icuSymd);
        icuSymi = Double.parseDouble(this.imunePerIcuDaysTxt.getText());
        this.currentModel.getNoSymptoms().getIcu().setImmunePercentage(icuSymi);
        this.currentModel.getMildSymptoms().getIcu().setImmunePercentage(icuSymi);
        this.currentModel.getSevereSymptoms().getIcu().setImmunePercentage(icuSymi);
        this.currentModel.getCriticalSymptoms().getIcu().setImmunePercentage(icuSymi);
    }
    
    public void removeThisTab(){
      int i=pane.indexOfComponent(this);
      pane.removeTabAt(i);
    }

    public class ButtonTilte extends JPanel implements ActionListener {

        private ModelPanel mp;

        public ButtonTilte(ModelPanel mp) {
            initComponents();
            this.mp = mp;
            this.jButton1.addActionListener(this);
        }

        public ModelPanel getMp() {
            return mp;
        }

        private void initComponents() {

            jLabel1 = new javax.swing.JLabel();
            jButton1 = new javax.swing.JButton();

            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText("jLabel1");

            jButton1.setText("X");
            jButton1.setToolTipText("");
            jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(14, 14, 14)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
        }

        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel1;

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = pane.indexOfComponent(mp);
            pane.removeTabAt(i);
        }
    }

    private class JTextFieldDoubleListener implements DocumentListener, FocusListener {

        private final JTextField jtextField;
        private final MainFrame mainFrame;
        private String currentString = "0.0";
        private final String greaterMessage = "Number can't be greater 100!";
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = false;

        public JTextFieldDoubleListener(JTextField textField, MainFrame mainFrame) {
            this.jtextField = textField;
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
            frame.setModelSavedButtonEnable();
            if (currentModel != null) {
                currentModel.setSaved(false);
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
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            this.insert = false;
            frame.setModelSavedButtonEnable();
            if (currentModel != null) {
                currentModel.setSaved(false);
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
                int index = this.jtextField.getText().lastIndexOf('.');
                int len = this.jtextField.getText().length();
                System.out.println("index=" + index);
                System.out.println("len=" + len);
                String s = this.jtextField.getText();
                if (index == (len - 1)) {
                    s += 0;
                }
                this.currentString = s;
                insertZero(this.currentString);
            }
        }

    }

    private class JTextFieldIntegerListener implements DocumentListener, FocusListener {

        private final JTextField jtextField;
        private final MainFrame mainFrame;
        private String currentString = "0";
        private final String numberFormat = "Parameter have to be a number!";
        private final String badNumberValueTitle = "Bad Parameter";
        private boolean insert = false;

        public JTextFieldIntegerListener(JTextField textField, MainFrame mainFrame) {
            this.jtextField = textField;
            this.mainFrame = mainFrame;
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
            frame.setModelSavedButtonEnable();
            if (currentModel != null) {
                currentModel.setSaved(false);
            }
            try {
                int d = Integer.parseInt(numTxt);
            } catch (NumberFormatException ex) {
                this.insert = true;
                JOptionPane.showOptionDialog(this.mainFrame, this.numberFormat, this.badNumberValueTitle, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                insertZero(this.currentString);
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            this.insert = false;
            frame.setModelSavedButtonEnable();
            if (currentModel != null) {
                currentModel.setSaved(false);
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
                String s = this.jtextField.getText();
                this.currentString = s;
                insertZero(this.currentString);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel36 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        noSymHumPerTxt = new javax.swing.JTextField();
        mildSymHumPerTxt = new javax.swing.JTextField();
        sevSymHumPerTxt = new javax.swing.JTextField();
        criSymHumPerTxt = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        noSymDeathPerTxt = new javax.swing.JTextField();
        mildSymdeathPerTxt = new javax.swing.JTextField();
        sevSympDeathPerTxt = new javax.swing.JTextField();
        criSymDeathPerTxt = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        noSymContDayTxt = new javax.swing.JTextField();
        mildSymConDayTxt = new javax.swing.JTextField();
        sevSymContDayTxt = new javax.swing.JTextField();
        criSymContDayTxt = new javax.swing.JTextField();
        jPanel38 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        noSymNoSymDayTxt = new javax.swing.JTextField();
        mildSymNoSymdaytxt = new javax.swing.JTextField();
        sevSymNoSymdayTxt = new javax.swing.JTextField();
        criSymNoSymDayTxt = new javax.swing.JTextField();
        deathPerNoSymDaysTxt = new javax.swing.JTextField();
        imunePerNoSymDayTxt = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        noSymMildSymDayTxt = new javax.swing.JTextField();
        mildSymMildSymDayTxt = new javax.swing.JTextField();
        sevSymMildSymDayTxt = new javax.swing.JTextField();
        criSymMildSymDayTxt = new javax.swing.JTextField();
        deathPerMildDaysTxt = new javax.swing.JTextField();
        imunePerMildDaysTxt = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        noSymSevSymDayTxt = new javax.swing.JTextField();
        milSymSevSymdayTxt = new javax.swing.JTextField();
        sevSymSevSymDayTxt = new javax.swing.JTextField();
        criSymSevSymDaysTxt = new javax.swing.JTextField();
        deathPerSevDaysTxt = new javax.swing.JTextField();
        imunePerSevDayxTxt = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        noSymHosSymDaysTxt = new javax.swing.JTextField();
        mildSymHosSymDayTxt = new javax.swing.JTextField();
        sevSymHosSymDaysTxt = new javax.swing.JTextField();
        criSymHosSymdaysTxt = new javax.swing.JTextField();
        deathPerHosDaysTxt = new javax.swing.JTextField();
        imunePerHosDaysTxt = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        noSymIcuDaysTxt = new javax.swing.JTextField();
        mildSymIcuDaysTxt = new javax.swing.JTextField();
        sevSymIcudaysTxt = new javax.swing.JTextField();
        criSymIcuDaysTxt = new javax.swing.JTextField();
        deathPerIcuDaysTxt = new javax.swing.JTextField();
        imunePerIcuDaysTxt = new javax.swing.JTextField();

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Symptoms");
        jLabel27.setToolTipText("");
        jLabel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("% of human");
        jLabel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Death percentage");
        jLabel35.setToolTipText("");
        jLabel35.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Contagious Day");
        jLabel36.setToolTipText("");
        jLabel36.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setPreferredSize(new java.awt.Dimension(600, 138));

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("No Symptoms");
        jLabel29.setToolTipText("");
        jLabel29.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Mild symptoms");
        jLabel30.setToolTipText("");
        jLabel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Severe symptoms");
        jLabel33.setToolTipText("");
        jLabel33.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Critical symptoms");
        jLabel34.setToolTipText("");
        jLabel34.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        noSymHumPerTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        noSymHumPerTxt.setText("0.0");
        noSymHumPerTxt.setToolTipText("");

        mildSymHumPerTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mildSymHumPerTxt.setText("0.014");

        sevSymHumPerTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sevSymHumPerTxt.setText("0.036");

        criSymHumPerTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        criSymHumPerTxt.setText("0.0");
        criSymHumPerTxt.setPreferredSize(new java.awt.Dimension(59, 28));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(noSymHumPerTxt)
            .addComponent(mildSymHumPerTxt)
            .addComponent(sevSymHumPerTxt)
            .addComponent(criSymHumPerTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(noSymHumPerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mildSymHumPerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sevSymHumPerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(criSymHumPerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        noSymDeathPerTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        noSymDeathPerTxt.setText("0.0");
        noSymDeathPerTxt.setToolTipText("");

        mildSymdeathPerTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mildSymdeathPerTxt.setText("0.0");

        sevSympDeathPerTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sevSympDeathPerTxt.setText("0.0");

        criSymDeathPerTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        criSymDeathPerTxt.setText("0.0");
        criSymDeathPerTxt.setToolTipText("");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(noSymDeathPerTxt)
            .addComponent(mildSymdeathPerTxt)
            .addComponent(sevSympDeathPerTxt)
            .addComponent(criSymDeathPerTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(noSymDeathPerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mildSymdeathPerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sevSympDeathPerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(criSymDeathPerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        noSymContDayTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        noSymContDayTxt.setText("0");

        mildSymConDayTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mildSymConDayTxt.setText("0");
        mildSymConDayTxt.setToolTipText("");

        sevSymContDayTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sevSymContDayTxt.setText("0");

        criSymContDayTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        criSymContDayTxt.setText("0");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(noSymContDayTxt)
            .addComponent(mildSymConDayTxt)
            .addComponent(sevSymContDayTxt)
            .addComponent(criSymContDayTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(noSymContDayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mildSymConDayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sevSymContDayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(criSymContDayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel38.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Symptoms");
        jLabel37.setToolTipText("");
        jLabel37.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("No Symptoms Days");
        jLabel43.setToolTipText("");
        jLabel43.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Mild Symptoms days");
        jLabel44.setToolTipText("");
        jLabel44.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Severe Symptoms Days");
        jLabel45.setToolTipText("");
        jLabel45.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Hospitalization Days");
        jLabel46.setToolTipText("");
        jLabel46.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Icu Day");
        jLabel47.setToolTipText("");
        jLabel47.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("No Symptoms");
        jLabel38.setToolTipText("");
        jLabel38.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Mild Symptoms");
        jLabel39.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Severe Symptoms");
        jLabel41.setToolTipText("");
        jLabel41.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Critical Symptoms");
        jLabel42.setToolTipText("");
        jLabel42.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel42.setPreferredSize(new java.awt.Dimension(88, 28));

        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Death Percentage");
        jLabel49.setToolTipText("");
        jLabel49.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Imune Percentage");
        jLabel50.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        noSymNoSymDayTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        noSymNoSymDayTxt.setText("0");
        noSymNoSymDayTxt.setToolTipText("");

        mildSymNoSymdaytxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mildSymNoSymdaytxt.setText("0");

        sevSymNoSymdayTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sevSymNoSymdayTxt.setText("0");

        criSymNoSymDayTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        criSymNoSymDayTxt.setText("0");
        criSymNoSymDayTxt.setPreferredSize(new java.awt.Dimension(12, 28));

        deathPerNoSymDaysTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        deathPerNoSymDaysTxt.setText("0.0");

        imunePerNoSymDayTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        imunePerNoSymDayTxt.setText("0.0");
        imunePerNoSymDayTxt.setToolTipText("");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(noSymNoSymDayTxt)
            .addComponent(mildSymNoSymdaytxt)
            .addComponent(sevSymNoSymdayTxt)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(criSymNoSymDayTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deathPerNoSymDaysTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(imunePerNoSymDayTxt))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(noSymNoSymDayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mildSymNoSymdaytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sevSymNoSymdayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(criSymNoSymDayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deathPerNoSymDaysTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imunePerNoSymDayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        noSymMildSymDayTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        noSymMildSymDayTxt.setText("0");

        mildSymMildSymDayTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mildSymMildSymDayTxt.setText("0");
        mildSymMildSymDayTxt.setToolTipText("");

        sevSymMildSymDayTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sevSymMildSymDayTxt.setText("0");
        sevSymMildSymDayTxt.setToolTipText("");

        criSymMildSymDayTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        criSymMildSymDayTxt.setText("0");
        criSymMildSymDayTxt.setToolTipText("");
        criSymMildSymDayTxt.setPreferredSize(new java.awt.Dimension(59, 28));

        deathPerMildDaysTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        deathPerMildDaysTxt.setText("0.0");

        imunePerMildDaysTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        imunePerMildDaysTxt.setText("0.0");
        imunePerMildDaysTxt.setToolTipText("");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(noSymMildSymDayTxt)
            .addComponent(mildSymMildSymDayTxt)
            .addComponent(sevSymMildSymDayTxt)
            .addComponent(criSymMildSymDayTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deathPerMildDaysTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(imunePerMildDaysTxt))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(noSymMildSymDayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mildSymMildSymDayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sevSymMildSymDayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(criSymMildSymDayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deathPerMildDaysTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imunePerMildDaysTxt))
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        noSymSevSymDayTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        noSymSevSymDayTxt.setText("0");
        noSymSevSymDayTxt.setToolTipText("");

        milSymSevSymdayTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        milSymSevSymdayTxt.setText("0");

        sevSymSevSymDayTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sevSymSevSymDayTxt.setText("0");

        criSymSevSymDaysTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        criSymSevSymDaysTxt.setText("0");
        criSymSevSymDaysTxt.setToolTipText("");

        deathPerSevDaysTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        deathPerSevDaysTxt.setText("0.0");

        imunePerSevDayxTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        imunePerSevDayxTxt.setText("0.0");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(noSymSevSymDayTxt)
            .addComponent(milSymSevSymdayTxt)
            .addComponent(sevSymSevSymDayTxt)
            .addComponent(criSymSevSymDaysTxt)
            .addComponent(deathPerSevDaysTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(imunePerSevDayxTxt)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(noSymSevSymDayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(milSymSevSymdayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sevSymSevSymDayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(criSymSevSymDaysTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deathPerSevDaysTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imunePerSevDayxTxt))
        );

        jPanel31.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        noSymHosSymDaysTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        noSymHosSymDaysTxt.setText("0");

        mildSymHosSymDayTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mildSymHosSymDayTxt.setText("0");

        sevSymHosSymDaysTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sevSymHosSymDaysTxt.setText("0");
        sevSymHosSymDaysTxt.setToolTipText("");

        criSymHosSymdaysTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        criSymHosSymdaysTxt.setText("0");

        deathPerHosDaysTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        deathPerHosDaysTxt.setText("0.0");
        deathPerHosDaysTxt.setToolTipText("");

        imunePerHosDaysTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        imunePerHosDaysTxt.setText("0.0");
        imunePerHosDaysTxt.setToolTipText("");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(noSymHosSymDaysTxt)
            .addComponent(mildSymHosSymDayTxt)
            .addComponent(sevSymHosSymDaysTxt)
            .addComponent(criSymHosSymdaysTxt)
            .addComponent(deathPerHosDaysTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(imunePerHosDaysTxt)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(noSymHosSymDaysTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mildSymHosSymDayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sevSymHosSymDaysTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(criSymHosSymdaysTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deathPerHosDaysTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imunePerHosDaysTxt))
        );

        jPanel32.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        noSymIcuDaysTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        noSymIcuDaysTxt.setText("0");
        noSymIcuDaysTxt.setToolTipText("");

        mildSymIcuDaysTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mildSymIcuDaysTxt.setText("0");
        mildSymIcuDaysTxt.setToolTipText("");

        sevSymIcudaysTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sevSymIcudaysTxt.setText("0");
        sevSymIcudaysTxt.setToolTipText("");

        criSymIcuDaysTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        criSymIcuDaysTxt.setText("0");

        deathPerIcuDaysTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        deathPerIcuDaysTxt.setText("0.0");

        imunePerIcuDaysTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        imunePerIcuDaysTxt.setText("0.0");
        imunePerIcuDaysTxt.setToolTipText("");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(noSymIcuDaysTxt)
            .addComponent(mildSymIcuDaysTxt)
            .addComponent(sevSymIcudaysTxt)
            .addComponent(criSymIcuDaysTxt)
            .addComponent(deathPerIcuDaysTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(imunePerIcuDaysTxt)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addComponent(noSymIcuDaysTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mildSymIcuDaysTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sevSymIcudaysTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(criSymIcuDaysTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deathPerIcuDaysTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imunePerIcuDaysTxt))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 392, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(880, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel36);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField criSymContDayTxt;
    private javax.swing.JTextField criSymDeathPerTxt;
    private javax.swing.JTextField criSymHosSymdaysTxt;
    private javax.swing.JTextField criSymHumPerTxt;
    private javax.swing.JTextField criSymIcuDaysTxt;
    private javax.swing.JTextField criSymMildSymDayTxt;
    private javax.swing.JTextField criSymNoSymDayTxt;
    private javax.swing.JTextField criSymSevSymDaysTxt;
    private javax.swing.JTextField deathPerHosDaysTxt;
    private javax.swing.JTextField deathPerIcuDaysTxt;
    private javax.swing.JTextField deathPerMildDaysTxt;
    private javax.swing.JTextField deathPerNoSymDaysTxt;
    private javax.swing.JTextField deathPerSevDaysTxt;
    private javax.swing.JTextField imunePerHosDaysTxt;
    private javax.swing.JTextField imunePerIcuDaysTxt;
    private javax.swing.JTextField imunePerMildDaysTxt;
    private javax.swing.JTextField imunePerNoSymDayTxt;
    private javax.swing.JTextField imunePerSevDayxTxt;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField milSymSevSymdayTxt;
    private javax.swing.JTextField mildSymConDayTxt;
    private javax.swing.JTextField mildSymHosSymDayTxt;
    private javax.swing.JTextField mildSymHumPerTxt;
    private javax.swing.JTextField mildSymIcuDaysTxt;
    private javax.swing.JTextField mildSymMildSymDayTxt;
    private javax.swing.JTextField mildSymNoSymdaytxt;
    private javax.swing.JTextField mildSymdeathPerTxt;
    private javax.swing.JTextField noSymContDayTxt;
    private javax.swing.JTextField noSymDeathPerTxt;
    private javax.swing.JTextField noSymHosSymDaysTxt;
    private javax.swing.JTextField noSymHumPerTxt;
    private javax.swing.JTextField noSymIcuDaysTxt;
    private javax.swing.JTextField noSymMildSymDayTxt;
    private javax.swing.JTextField noSymNoSymDayTxt;
    private javax.swing.JTextField noSymSevSymDayTxt;
    private javax.swing.JTextField sevSymContDayTxt;
    private javax.swing.JTextField sevSymHosSymDaysTxt;
    private javax.swing.JTextField sevSymHumPerTxt;
    private javax.swing.JTextField sevSymIcudaysTxt;
    private javax.swing.JTextField sevSymMildSymDayTxt;
    private javax.swing.JTextField sevSymNoSymdayTxt;
    private javax.swing.JTextField sevSymSevSymDayTxt;
    private javax.swing.JTextField sevSympDeathPerTxt;
    // End of variables declaration//GEN-END:variables
}
