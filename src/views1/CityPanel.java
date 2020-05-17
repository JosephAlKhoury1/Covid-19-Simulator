package views1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import models.client1.City;

/**
 *
 * @author Joseph
 */
public class CityPanel extends javax.swing.JPanel {

    private final MainFrame mainFrame;
    private final String[] hours = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
    private City currentCity;
    private final LocationListPanel currentLocationListPanel;
    private Maps currentMap;
    private List<Maps> listMaps;
    private final JTabbedPane pane;
    private final ButtonTilte button;
    private boolean isSaved = false;

  

    public CityPanel(MainFrame mainFrame, JTabbedPane pane, City city) {
        this.mainFrame = mainFrame;
        this.pane = pane;
        this.currentCity = city;
        this.button = new ButtonTilte(this);
        this.currentLocationListPanel = new LocationListPanel(this.mainFrame, this);

        this.listMaps = new ArrayList();
        this.initComponents();
    }

    public CityPanel(MainFrame mainFrame, JTabbedPane pane, String name) {
        this.mainFrame = mainFrame;
        this.pane = pane;
        try {
            this.currentCity = new City(name, 0, 2000, 1000, 1);
        } catch (RemoteException ex) {
            Logger.getLogger(CityPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.button = new ButtonTilte(this);
        this.currentLocationListPanel = new LocationListPanel(this.mainFrame, this);
        this.listMaps = new ArrayList();
        this.initComponents();
    }

   
    public boolean isIsSaved() {
        return isSaved;
    }

    public void setIsSaved(boolean isSaved) {
        this.isSaved = isSaved;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentMap(Maps currentMap) {
        this.currentMap = currentMap;
    }

    public ButtonTilte getButton() {
        return button;
    }

    public LocationListPanel getCurrentLocationListPanel() {
        return currentLocationListPanel;
    }

    public Maps getCurrentMap() {
        return currentMap;
    }

    public void generateMapLocation() {
        this.currentMap = new Maps(mainFrame, this, pane);
        JScrollPane p = new JScrollPane(this.currentMap);
        this.currentMap.setScrollPane(p);
        this.pane.addTab("Map", this.currentMap.getScrollPane());
        this.pane.setTabComponentAt(this.pane.getTabCount() - 1, this.currentMap.getButton());
    }

    public void addCity(City city) {
        this.currentCity = city;
    }

    public void initCityParameters() {
        double h1, h2, h3, h4, h5, h6, h7, h8, h9, h10;
        h1 = Double.parseDouble(this.under5PerTxt.getText());
        this.currentCity.getUnder4().setHumanPercentage(h1);
        h2 = Double.parseDouble(this.bet6and10PerTxt.getText());
        this.currentCity.getBetween4and10().setHumanPercentage(h2);
        h3 = Double.parseDouble(this.bet11and18PerTxt.getText());
        this.currentCity.getBetween11and18().setHumanPercentage(h3);
        h4 = Double.parseDouble(this.bet19and30PerTxt.getText());
        this.currentCity.getBetween19and27().setHumanPercentage(h4);
        h5 = Double.parseDouble(this.bet31and40PerTxt.getText());
        this.currentCity.getBetween28and40().setHumanPercentage(h5);
        h6 = Double.parseDouble(this.bet41and50PerTxt.getText());
        this.currentCity.getBetween41and50().setHumanPercentage(h6);
        h7 = Double.parseDouble(this.bet51and60PerTxt.getText());
        this.currentCity.getBetween51and60().setHumanPercentage(h7);
        h8 = Double.parseDouble(this.bet61and70PerTxt.getText());
        this.currentCity.getBetween61and70().setHumanPercentage(h8);
        h9 = Double.parseDouble(this.bet71and80PerTxt.getText());
        this.currentCity.getBetween71and80().setHumanPercentage(h9);
        h10 = Double.parseDouble(this.above80PerTxt.getText());
        this.currentCity.getAbove80().setHumanPercentage(h10);

        double u1, u2, u3, u4, u5, u6, u7, u8, u9, u10;
        u1 = Double.parseDouble(this.under5unuversityTxt.getText());
        this.currentCity.getUnder4().setGoUniversityPercentage(u1);
        u2 = Double.parseDouble(this.bet6and10UnivTxt.getText());
        this.currentCity.getBetween4and10().setGoUniversityPercentage(u2);
        u3 = Double.parseDouble(this.bet11and18UniTxt.getText());
        this.currentCity.getBetween11and18().setGoUniversityPercentage(u3);
        u4 = Double.parseDouble(this.bet19and30UnivTxt.getText());
        this.currentCity.getBetween19and27().setGoUniversityPercentage(u4);
        u5 = Double.parseDouble(this.bet31and40UniTxt.getText());
        this.currentCity.getBetween28and40().setGoUniversityPercentage(u5);
        u6 = Double.parseDouble(this.bet41and50UniTxt.getText());
        this.currentCity.getBetween41and50().setGoUniversityPercentage(u6);
        u7 = Double.parseDouble(this.bet51and60UniTxt.getText());
        this.currentCity.getBetween51and60().setGoUniversityPercentage(u7);
        u8 = Double.parseDouble(this.bet61and70UniTxt.getText());
        this.currentCity.getBetween61and70().setGoUniversityPercentage(u8);
        u9 = Double.parseDouble(this.bet71and80UniTxt.getText());
        this.currentCity.getBetween71and80().setGoUniversityPercentage(u9);
        u10 = Double.parseDouble(this.above80UniTxt.getText());
        this.currentCity.getAbove80().setGoUniversityPercentage(u10);

        double s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
        s1 = Double.parseDouble(this.under5SchoolTxt.getText());
        this.currentCity.getUnder4().setGoSchoolPercentage(s1);
        s2 = Double.parseDouble(this.bet6and10SchoolTxt.getText());
        this.currentCity.getBetween4and10().setGoSchoolPercentage(s2);
        s3 = Double.parseDouble(this.bet11and18SchTxt.getText());
        this.currentCity.getBetween11and18().setGoSchoolPercentage(s3);
        s4 = Double.parseDouble(this.bet19and30SchTxt.getText());
        this.currentCity.getBetween19and27().setGoSchoolPercentage(s4);
        s5 = Double.parseDouble(this.bet31and40SchTxt.getText());
        this.currentCity.getBetween28and40().setGoSchoolPercentage(s5);
        s6 = Double.parseDouble(this.bet41and50SchTxt.getText());
        this.currentCity.getBetween41and50().setGoSchoolPercentage(s6);
        s7 = Double.parseDouble(this.bet51and60SchTxt.getText());
        this.currentCity.getBetween51and60().setGoSchoolPercentage(s7);
        s8 = Double.parseDouble(this.bet61and70SchTxt.getText());
        this.currentCity.getBetween61and70().setGoSchoolPercentage(s8);
        s9 = Double.parseDouble(this.bet71and80SchTxt.getText());
        this.currentCity.getBetween71and80().setGoSchoolPercentage(s9);
        s10 = Double.parseDouble(this.above80SchTxt.getText());
        this.currentCity.getAbove80().setGoSchoolPercentage(s10);

        double w1, w2, w3, w4, w5, w6, w7, w8, w9, w10;
        w1 = Double.parseDouble(this.under5WorkTxt.getText());
        this.currentCity.getUnder4().setGoWorkPercentage(w1);
        w2 = Double.parseDouble(this.bet6and10WorkTxt.getText());
        this.currentCity.getBetween4and10().setGoWorkPercentage(w2);
        w3 = Double.parseDouble(this.bet11and18WorkTxt.getText());
        this.currentCity.getBetween11and18().setGoWorkPercentage(w3);
        w4 = Double.parseDouble(this.bet19and30WorkTxt.getText());
        this.currentCity.getBetween19and27().setGoWorkPercentage(w4);
        w5 = Double.parseDouble(this.bet31and40WorkTxt.getText());
        this.currentCity.getBetween28and40().setGoWorkPercentage(w5);
        w6 = Double.parseDouble(this.bet41and50WorkTxt.getText());
        this.currentCity.getBetween41and50().setGoWorkPercentage(w6);
        w7 = Double.parseDouble(this.bet51and60WorkTxt.getText());
        this.currentCity.getBetween51and60().setGoWorkPercentage(w7);
        w8 = Double.parseDouble(this.bet61and70WorkTxt.getText());
        this.currentCity.getBetween61and70().setGoWorkPercentage(w8);
        w9 = Double.parseDouble(this.bet71and80WorkTxt.getText());
        this.currentCity.getBetween71and80().setGoWorkPercentage(w9);
        w10 = Double.parseDouble(this.above80WorkTxt.getText());
        this.currentCity.getAbove80().setGoWorkPercentage(w10);
    }

    public void setJTextFieldsCityValues(City m) {
        this.under5PerTxt.setText(m.getUnder4().getHumanPercentage() + "");
        this.bet6and10PerTxt.setText(m.getBetween4and10().getHumanPercentage() + "");
        this.bet11and18PerTxt.setText(m.getBetween11and18().getHumanPercentage() + "");
        this.bet19and30PerTxt.setText(m.getBetween19and27().getHumanPercentage() + "");
        this.bet31and40PerTxt.setText(m.getBetween28and40().getHumanPercentage() + "");
        this.bet41and50PerTxt.setText(m.getBetween41and50().getHumanPercentage() + "");
        this.bet51and60PerTxt.setText(m.getBetween51and60().getHumanPercentage() + "");
        this.bet61and70PerTxt.setText(m.getBetween61and70().getHumanPercentage() + "");
        this.bet71and80PerTxt.setText(m.getBetween71and80().getHumanPercentage() + "");
        this.above80PerTxt.setText(m.getAbove80().getHumanPercentage() + "");

        this.under5unuversityTxt.setText(m.getUnder4().getGoUniversityPercentage() + "");
        this.bet6and10UnivTxt.setText(m.getBetween4and10().getGoUniversityPercentage() + "");
        this.bet11and18UniTxt.setText(m.getBetween11and18().getGoUniversityPercentage() + "");
        this.bet19and30UnivTxt.setText(m.getBetween19and27().getGoUniversityPercentage() + "");
        this.bet31and40UniTxt.setText(m.getBetween28and40().getGoUniversityPercentage() + "");
        this.bet41and50UniTxt.setText(m.getBetween41and50().getGoUniversityPercentage() + "");
        this.bet51and60UniTxt.setText(m.getBetween51and60().getGoUniversityPercentage() + "");
        this.bet61and70UniTxt.setText(m.getBetween61and70().getGoUniversityPercentage() + "");
        this.bet71and80UniTxt.setText(m.getBetween71and80().getGoUniversityPercentage() + "");
        this.above80UniTxt.setText(m.getAbove80().getGoUniversityPercentage() + "");

        this.under5SchoolTxt.setText(m.getUnder4().getGoSchoolPercentage() + "");
        this.bet6and10SchoolTxt.setText(m.getBetween4and10().getGoSchoolPercentage() + "");
        this.bet11and18SchTxt.setText(m.getBetween11and18().getGoSchoolPercentage() + "");
        this.bet19and30SchTxt.setText(m.getBetween19and27().getGoSchoolPercentage() + "");
        this.bet31and40SchTxt.setText(m.getBetween28and40().getGoSchoolPercentage() + "");
        this.bet41and50SchTxt.setText(m.getBetween41and50().getGoSchoolPercentage() + "");
        this.bet51and60SchTxt.setText(m.getBetween51and60().getGoSchoolPercentage() + "");
        this.bet61and70SchTxt.setText(m.getBetween61and70().getGoSchoolPercentage() + "");
        this.bet71and80SchTxt.setText(m.getBetween71and80().getGoSchoolPercentage() + "");
        this.above80SchTxt.setText(m.getAbove80().getGoSchoolPercentage() + "");

        this.under5WorkTxt.setText(m.getUnder4().getGoWorkPercentage() + "");
        this.bet6and10WorkTxt.setText(m.getBetween4and10().getGoWorkPercentage() + "");
        this.bet11and18WorkTxt.setText(m.getBetween11and18().getGoWorkPercentage() + "");
        this.bet19and30WorkTxt.setText(m.getBetween19and27().getGoWorkPercentage() + "");
        this.bet31and40WorkTxt.setText(m.getBetween28and40().getGoWorkPercentage() + "");
        this.bet41and50WorkTxt.setText(m.getBetween41and50().getGoWorkPercentage() + "");
        this.bet51and60WorkTxt.setText(m.getBetween51and60().getGoWorkPercentage() + "");
        this.bet61and70WorkTxt.setText(m.getBetween61and70().getGoWorkPercentage() + "");
        this.bet71and80WorkTxt.setText(m.getBetween71and80().getGoWorkPercentage() + "");
        this.above80WorkTxt.setText(m.getAbove80().getGoWorkPercentage() + "");
    }

    public City getCity1() {
        return currentCity;
    }

    public void setCity1(City city) {
        this.currentCity = city;
    }

    public void removeThisTab() {
        int i = pane.indexOfComponent(this);
        pane.removeTabAt(i);
    }

    public class ButtonTilte extends JPanel implements ActionListener {

        private CityPanel mp;

        public ButtonTilte(CityPanel mp) {
            initComponents();
            this.mp = mp;
            //this.jButton1.addActionListener(this);
        }

        public CityPanel getMp() {
            return mp;
        }

        private void initComponents() {

            jLabel1 = new javax.swing.JLabel();
            //jButton1 = new javax.swing.JButton();

            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText(currentCity.getName() + " city");

            // jButton1.setText("X");
            //jButton1.setToolTipText("");
            //jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(14, 14, 14)
                            //.addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                            ));
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            //.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            ));
        }

        //private javax.swing.JButton jButton1;
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
            mainFrame.setModelSavedButtonEnable();
            if (currentCity != null) {
                currentCity.setIsSaved(false);
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
            mainFrame.setModelSavedButtonEnable();
            if (currentCity != null) {
                currentCity.setIsSaved(false);
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
            mainFrame.setModelSavedButtonEnable();
            if (currentCity != null) {
                currentCity.setIsSaved(false);
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
            mainFrame.setModelSavedButtonEnable();
            if (currentCity != null) {
                currentCity.setIsSaved(false);
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

        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        under5SchoolTxt = new javax.swing.JTextField();
        bet6and10SchoolTxt = new javax.swing.JTextField();
        bet11and18SchTxt = new javax.swing.JTextField();
        bet19and30SchTxt = new javax.swing.JTextField();
        bet31and40SchTxt = new javax.swing.JTextField();
        bet41and50SchTxt = new javax.swing.JTextField();
        bet51and60SchTxt = new javax.swing.JTextField();
        bet61and70SchTxt = new javax.swing.JTextField();
        bet71and80SchTxt = new javax.swing.JTextField();
        above80SchTxt = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        under5unuversityTxt = new javax.swing.JTextField();
        bet6and10UnivTxt = new javax.swing.JTextField();
        bet11and18UniTxt = new javax.swing.JTextField();
        bet19and30UnivTxt = new javax.swing.JTextField();
        bet31and40UniTxt = new javax.swing.JTextField();
        bet41and50UniTxt = new javax.swing.JTextField();
        bet51and60UniTxt = new javax.swing.JTextField();
        bet61and70UniTxt = new javax.swing.JTextField();
        bet71and80UniTxt = new javax.swing.JTextField();
        above80UniTxt = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        under5WorkTxt = new javax.swing.JTextField();
        bet6and10WorkTxt = new javax.swing.JTextField();
        bet11and18WorkTxt = new javax.swing.JTextField();
        bet19and30WorkTxt = new javax.swing.JTextField();
        bet31and40WorkTxt = new javax.swing.JTextField();
        bet41and50WorkTxt = new javax.swing.JTextField();
        bet51and60WorkTxt = new javax.swing.JTextField();
        bet61and70WorkTxt = new javax.swing.JTextField();
        bet71and80WorkTxt = new javax.swing.JTextField();
        above80WorkTxt = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        under5PerTxt = new javax.swing.JTextField();
        bet6and10PerTxt = new javax.swing.JTextField();
        bet11and18PerTxt = new javax.swing.JTextField();
        bet19and30PerTxt = new javax.swing.JTextField();
        bet31and40PerTxt = new javax.swing.JTextField();
        bet41and50PerTxt = new javax.swing.JTextField();
        bet51and60PerTxt = new javax.swing.JTextField();
        bet61and70PerTxt = new javax.swing.JTextField();
        bet71and80PerTxt = new javax.swing.JTextField();
        above80PerTxt = new javax.swing.JTextField();
        jPanel30 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        populationLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new JComboBox(this.hours)
        ;
        jComboBox2 = new JComboBox(this.hours);
        jPanel7 = new javax.swing.JPanel();
        widthTxt = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        heighTxt = new javax.swing.JTextField();

        jPanel47.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel46.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel45.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("under 4");
        jLabel80.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("between 4 and 10");
        jLabel81.setToolTipText("");
        jLabel81.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("between 11 and 18");
        jLabel82.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("between 19 and 30");
        jLabel83.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("between 31 and 40");
        jLabel84.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("between 41 and 50");
        jLabel85.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("between 51 and 60");
        jLabel86.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setText("between 61 and 70");
        jLabel87.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("between 71 and 80");
        jLabel88.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("above 80");
        jLabel89.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
            .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        under5SchoolTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        under5SchoolTxt.setText("0.0");
        under5SchoolTxt.setToolTipText("");

        bet6and10SchoolTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet6and10SchoolTxt.setText("0.0");
        bet6and10SchoolTxt.setToolTipText("");

        bet11and18SchTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet11and18SchTxt.setText("0.0");
        bet11and18SchTxt.setToolTipText("");

        bet19and30SchTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet19and30SchTxt.setText("0.0");
        bet19and30SchTxt.setToolTipText("");

        bet31and40SchTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet31and40SchTxt.setText("0.0");
        bet31and40SchTxt.setToolTipText("");

        bet41and50SchTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet41and50SchTxt.setText("0.0");
        bet41and50SchTxt.setToolTipText("");

        bet51and60SchTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet51and60SchTxt.setText("0.0");
        bet51and60SchTxt.setToolTipText("");

        bet61and70SchTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet61and70SchTxt.setText("0.0");
        bet61and70SchTxt.setToolTipText("");

        bet71and80SchTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet71and80SchTxt.setText("0.0");
        bet71and80SchTxt.setToolTipText("");

        above80SchTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        above80SchTxt.setText("0.0");
        above80SchTxt.setToolTipText("");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(under5SchoolTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
            .addComponent(bet6and10SchoolTxt)
            .addComponent(bet11and18SchTxt)
            .addComponent(bet19and30SchTxt)
            .addComponent(bet31and40SchTxt)
            .addComponent(bet41and50SchTxt)
            .addComponent(bet51and60SchTxt)
            .addComponent(bet61and70SchTxt)
            .addComponent(bet71and80SchTxt)
            .addComponent(above80SchTxt)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(under5SchoolTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet6and10SchoolTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet11and18SchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet19and30SchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet31and40SchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet41and50SchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet51and60SchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet61and70SchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet71and80SchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(above80SchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        under5unuversityTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        under5unuversityTxt.setText("0.0");
        under5unuversityTxt.setToolTipText("");

        bet6and10UnivTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet6and10UnivTxt.setText("0.0");
        bet6and10UnivTxt.setToolTipText("");

        bet11and18UniTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet11and18UniTxt.setText("0.0");
        bet11and18UniTxt.setToolTipText("");

        bet19and30UnivTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet19and30UnivTxt.setText("0.0");
        bet19and30UnivTxt.setToolTipText("");

        bet31and40UniTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet31and40UniTxt.setText("0.0");
        bet31and40UniTxt.setToolTipText("");

        bet41and50UniTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet41and50UniTxt.setText("0.0");
        bet41and50UniTxt.setToolTipText("");

        bet51and60UniTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet51and60UniTxt.setText("0.0");
        bet51and60UniTxt.setToolTipText("");

        bet61and70UniTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet61and70UniTxt.setText("0.0");
        bet61and70UniTxt.setToolTipText("");

        bet71and80UniTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet71and80UniTxt.setText("0.0");
        bet71and80UniTxt.setToolTipText("");

        above80UniTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        above80UniTxt.setText("0.0");
        above80UniTxt.setToolTipText("");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bet6and10UnivTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
            .addComponent(under5unuversityTxt)
            .addComponent(bet11and18UniTxt)
            .addComponent(bet19and30UnivTxt)
            .addComponent(bet31and40UniTxt)
            .addComponent(bet41and50UniTxt)
            .addComponent(bet51and60UniTxt)
            .addComponent(bet61and70UniTxt)
            .addComponent(bet71and80UniTxt)
            .addComponent(above80UniTxt)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(under5unuversityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet6and10UnivTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet11and18UniTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet19and30UnivTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet31and40UniTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet41and50UniTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet51and60UniTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet61and70UniTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet71and80UniTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(above80UniTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        under5WorkTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        under5WorkTxt.setText("0.0");
        under5WorkTxt.setToolTipText("");

        bet6and10WorkTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet6and10WorkTxt.setText("0.0");
        bet6and10WorkTxt.setToolTipText("");

        bet11and18WorkTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet11and18WorkTxt.setText("0.0");
        bet11and18WorkTxt.setToolTipText("");

        bet19and30WorkTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet19and30WorkTxt.setText("0.0");
        bet19and30WorkTxt.setToolTipText("");

        bet31and40WorkTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet31and40WorkTxt.setText("0.0");

        bet41and50WorkTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet41and50WorkTxt.setText("0.0");
        bet41and50WorkTxt.setToolTipText("");

        bet51and60WorkTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet51and60WorkTxt.setText("0.0");
        bet51and60WorkTxt.setToolTipText("");

        bet61and70WorkTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet61and70WorkTxt.setText("0.0");
        bet61and70WorkTxt.setToolTipText("");

        bet71and80WorkTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet71and80WorkTxt.setText("0.0");
        bet71and80WorkTxt.setToolTipText("");

        above80WorkTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        above80WorkTxt.setText("0.0");
        above80WorkTxt.setToolTipText("");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(under5WorkTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
            .addComponent(bet6and10WorkTxt)
            .addComponent(bet11and18WorkTxt)
            .addComponent(bet19and30WorkTxt)
            .addComponent(bet31and40WorkTxt)
            .addComponent(bet41and50WorkTxt)
            .addComponent(bet51and60WorkTxt)
            .addComponent(bet61and70WorkTxt)
            .addComponent(bet71and80WorkTxt)
            .addComponent(above80WorkTxt)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(under5WorkTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet6and10WorkTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet11and18WorkTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet19and30WorkTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet31and40WorkTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet41and50WorkTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet51and60WorkTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet61and70WorkTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet71and80WorkTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(above80WorkTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        under5PerTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        under5PerTxt.setText("0.0");
        under5PerTxt.setToolTipText("");

        bet6and10PerTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet6and10PerTxt.setText("0.0");

        bet11and18PerTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet11and18PerTxt.setText("0.0");

        bet19and30PerTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet19and30PerTxt.setText("0.0");
        bet19and30PerTxt.setToolTipText("");

        bet31and40PerTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet31and40PerTxt.setText("0.0");

        bet41and50PerTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet41and50PerTxt.setText("0.0");
        bet41and50PerTxt.setToolTipText("");

        bet51and60PerTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet51and60PerTxt.setText("0.0");

        bet61and70PerTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet61and70PerTxt.setText("0.0");
        bet61and70PerTxt.setToolTipText("");

        bet71and80PerTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bet71and80PerTxt.setText("0.0");
        bet71and80PerTxt.setToolTipText("");

        above80PerTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        above80PerTxt.setText("0.0");
        above80PerTxt.setToolTipText("");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(under5PerTxt)
            .addComponent(bet6and10PerTxt)
            .addComponent(bet11and18PerTxt)
            .addComponent(bet19and30PerTxt)
            .addComponent(bet31and40PerTxt)
            .addComponent(bet41and50PerTxt)
            .addComponent(bet51and60PerTxt)
            .addComponent(bet61and70PerTxt)
            .addComponent(bet71and80PerTxt)
            .addComponent(above80PerTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(under5PerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet6and10PerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet11and18PerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet19and30PerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet31and40PerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet41and50PerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet51and60PerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet61and70PerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bet71and80PerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(above80PerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jPanel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("year");
        jLabel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("% going to school ");
        jLabel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("% going to university");
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("% going to work");
        jLabel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("% of human");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel40.setText("Stay Home%:");

        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("50");

        jLabel3.setText("Population:");

        populationLabel.setToolTipText("");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(populationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(55, 55, 55))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(populationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Open Time:");

        jLabel10.setText("Close Time:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        widthTxt.setText("2000");
        widthTxt.setToolTipText("");

        jLabel31.setText("width:");

        jLabel32.setText("Height:");

        heighTxt.setText("1000");
        heighTxt.setToolTipText("");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(heighTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(widthTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(widthTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heighTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 307, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField above80PerTxt;
    private javax.swing.JTextField above80SchTxt;
    private javax.swing.JTextField above80UniTxt;
    private javax.swing.JTextField above80WorkTxt;
    private javax.swing.JTextField bet11and18PerTxt;
    private javax.swing.JTextField bet11and18SchTxt;
    private javax.swing.JTextField bet11and18UniTxt;
    private javax.swing.JTextField bet11and18WorkTxt;
    private javax.swing.JTextField bet19and30PerTxt;
    private javax.swing.JTextField bet19and30SchTxt;
    private javax.swing.JTextField bet19and30UnivTxt;
    private javax.swing.JTextField bet19and30WorkTxt;
    private javax.swing.JTextField bet31and40PerTxt;
    private javax.swing.JTextField bet31and40SchTxt;
    private javax.swing.JTextField bet31and40UniTxt;
    private javax.swing.JTextField bet31and40WorkTxt;
    private javax.swing.JTextField bet41and50PerTxt;
    private javax.swing.JTextField bet41and50SchTxt;
    private javax.swing.JTextField bet41and50UniTxt;
    private javax.swing.JTextField bet41and50WorkTxt;
    private javax.swing.JTextField bet51and60PerTxt;
    private javax.swing.JTextField bet51and60SchTxt;
    private javax.swing.JTextField bet51and60UniTxt;
    private javax.swing.JTextField bet51and60WorkTxt;
    private javax.swing.JTextField bet61and70PerTxt;
    private javax.swing.JTextField bet61and70SchTxt;
    private javax.swing.JTextField bet61and70UniTxt;
    private javax.swing.JTextField bet61and70WorkTxt;
    private javax.swing.JTextField bet6and10PerTxt;
    private javax.swing.JTextField bet6and10SchoolTxt;
    private javax.swing.JTextField bet6and10UnivTxt;
    private javax.swing.JTextField bet6and10WorkTxt;
    private javax.swing.JTextField bet71and80PerTxt;
    private javax.swing.JTextField bet71and80SchTxt;
    private javax.swing.JTextField bet71and80UniTxt;
    private javax.swing.JTextField bet71and80WorkTxt;
    private javax.swing.JTextField heighTxt;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel populationLabel;
    private javax.swing.JTextField under5PerTxt;
    private javax.swing.JTextField under5SchoolTxt;
    private javax.swing.JTextField under5WorkTxt;
    private javax.swing.JTextField under5unuversityTxt;
    private javax.swing.JTextField widthTxt;
    // End of variables declaration//GEN-END:variables
}
