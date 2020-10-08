/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import models.model.Model;
import models.model.SymptomStage;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.data.Range;
import org.jfree.data.RangeType;
import org.jfree.data.xy.XYDataItem;

public class LineChartEx extends JPanel implements ActionListener, ChangeListener {

    // private Timer timer = new Timer(1000, this);
    XYSeries series, s1, s2, s3, s4, s5;
    int lastValue = 1;
    private static int SLIDER_INITIAL_VALUE = 1;
    private JSlider slider;
    List<Integer> listValues = new ArrayList();
    int index = 0;
    ValueAxis valueAxis;
    NumberAxis domainAxis;
    boolean isStop = false;
    Model model;
    Map<String, Color> listSeries;
    private Map<String, XYSeries> listSeries2;
    XYSeriesCollection dataset;
    XYLineAndShapeRenderer renderer;
    private int sickNumber = 0;
    private int numberHuman = 0;
    private JPanel checkBoxPanel;
    private int in = 0;
    
    JFreeChart chart;
    
    private List<JCheckBox> listCheckBox;
    
    public LineChartEx(Model model) {
        initUI();
        this.model = model;
        listSeries = new HashMap();
        this.listSeries2 = new HashMap();
    }
    
    private void initUI() {
        this.removeAll();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.slider = new JSlider(0, 1, SLIDER_INITIAL_VALUE);
        this.slider.addChangeListener(this);
        dataset = createDataset();
        chart = createChart(dataset);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);
        JPanel dashboard = new JPanel();
        dashboard.setLayout(new BoxLayout(dashboard, BoxLayout.X_AXIS));
        dashboard.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));
        dashboard.add(this.slider);
        add(dashboard, BorderLayout.SOUTH);
        
        this.checkBoxPanel = new JPanel();
        this.checkBoxPanel.setLayout(new BoxLayout(this.checkBoxPanel, BoxLayout.Y_AXIS));
        add(checkBoxPanel);
        this.listCheckBox = new ArrayList();
        
        this.add(dashboard);
    }
    
    private XYSeriesCollection createDataset() {
        
        XYSeriesCollection set = new XYSeriesCollection();
        return set;
    }
    
    private JFreeChart createChart(XYDataset dataset) {
        JFreeChart ch = ChartFactory.createXYLineChart(
                "Result over time",
                "Day",
                "Human number",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        
        XYPlot plot = ch.getXYPlot();
        
        renderer = new XYLineAndShapeRenderer();
        
        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);
        
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);
        this.domainAxis = (NumberAxis) plot.getDomainAxis();
        
        this.domainAxis.setFixedAutoRange(10);
        
        this.domainAxis.setAutoRange(true);
        this.domainAxis.setTickUnit(new NumberTickUnit(1));
        this.valueAxis = plot.getRangeAxis();
        
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);
        
        ch.getLegend().setFrame(BlockBorder.NONE);
        
        ch.setTitle(new TextTitle("Result of study",
                new Font("Serif", java.awt.Font.BOLD, 18)
        )
        );
        
        return ch;
    }
    
    public void init() {
//        
//        if (isStop) {
//            initUI();
//        }
        this.slider.setMaximum(1);
        this.slider.setMinimum(0);
        this.slider.setValue(1);
        this.lastValue = 1;
        this.dataset.removeAllSeries();
        this.listSeries.clear();
        this.listSeries2.clear();
        this.listCheckBox.clear();
        this.checkBoxPanel.removeAll();
        this.slider.setEnabled(false);
        this.isStop = false;
        for (JCheckBox jc : this.listCheckBox) {
            jc.setEnabled(false);
        }
        
        this.in = 0;
        this.sickNumber = 0;
        this.numberHuman = 0;
        this.numberHuman = model.getCity().getListMember().size();
        this.valueAxis.setRange(new Range(0, model.getListHealth().size() + 20));
        
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
        
        this.checkBoxPanel.add(p);
        XYSeries hS = new XYSeries("Health");
        hS.add(1, model.getListHealth().size());
        this.listSeries.put("Health", Color.GREEN);
        this.listSeries2.put("Health", hS);
        renderer.setSeriesPaint(0, Color.green);
        JCheckBox heBox = new JCheckBox("Health");
        heBox.setForeground(Color.GREEN);
        heBox.setSelected(true);
        heBox.setEnabled(false);
        heBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (heBox.isSelected()) {
                    listSeries.put("Health", Color.GREEN);
                    listSeries2.put("Health", hS);
                } else {
                    listSeries.remove("Health");
                    listSeries2.remove("Health");
                }
                System.out.println("performed");
                reset();
            }
        });
        this.listCheckBox.add(heBox);
        p.add(heBox);
        
        in = 1;
        for (SymptomStage ss : this.model.getListSymptomStage1sNonHospital()) {
            if (in % 6 == 0) {
                p = new JPanel();
                p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
                this.checkBoxPanel.add(p);
            }
            XYSeries s = new XYSeries(ss.getName());
            s.add(1, ss.getListMember().size());
            renderer.setSeriesPaint(in, ss.getColor());
            this.listSeries.put(ss.getName(), ss.getColor());
            this.listSeries2.put(ss.getName(), s);
            JCheckBox box = new JCheckBox(ss.getName());
            box.setForeground(ss.getColor());
            box.setSelected(true);
            box.setEnabled(false);
            box.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (box.isSelected()) {
                        listSeries.put(ss.getName(), ss.getColor());
                        listSeries2.put(ss.getName(), s);
                    } else {
                        listSeries.remove(ss.getName());
                        listSeries2.remove(ss.getName());
                    }
                    reset();
                }
            });
            this.listCheckBox.add(box);
            p.add(box);
            in++;
        }
        for (SymptomStage ss : this.model.getListSymptomStage1sHospital()) {
            if (in % 6 == 0) {
                p = new JPanel();
                p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
                this.checkBoxPanel.add(p);
            }
            
            XYSeries s = new XYSeries(ss.getName());
            s.add(1, ss.getListMember().size());
            this.listSeries.put(ss.getName(), ss.getColor());
            this.listSeries2.put(ss.getName(), s);
            renderer.setSeriesPaint(in, ss.getColor());
            
            JCheckBox box = new JCheckBox(ss.getName());
            box.setForeground(ss.getColor());
            box.setSelected(true);
            box.setEnabled(false);
            box.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (box.isSelected()) {
                        listSeries.put(ss.getName(), ss.getColor());
                        listSeries2.put(ss.getName(), s);
                    } else {
                        listSeries.remove(ss.getName());
                        listSeries2.remove(ss.getName());
                    }
                    reset();
                }
            });
            this.listCheckBox.add(box);
            p.add(box);
            
            in++;
        }
        
        if (in % 6 == 0) {
            p = new JPanel();
            p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
            this.checkBoxPanel.add(p);
        }
        
        XYSeries sI = new XYSeries("Immune");
        sI.add(1, 0);
        this.listSeries.put("Immune", Color.CYAN);
        this.listSeries2.put("Immune", sI);
        renderer.setSeriesPaint(in, Color.CYAN);
        
        JCheckBox IBox = new JCheckBox("Immune");
        IBox.setForeground(Color.CYAN);
        IBox.setSelected(true);
        IBox.setEnabled(false);
        IBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (IBox.isSelected()) {
                    listSeries.put("Immune", Color.CYAN);
                    listSeries2.put("Immune", sI);
                } else {
                    listSeries.remove("Immune");
                    listSeries2.remove("Immune");
                }
                reset();
            }
        });
        this.listCheckBox.add(IBox);
        p.add(IBox);
        
        in++;
        
        if (in % 6 == 0) {
            p = new JPanel();
            p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
            this.checkBoxPanel.add(p);
        }
        
        XYSeries sD = new XYSeries("Death");
        sD.add(1, 0);
        this.listSeries.put("Death", Color.BLACK);
        this.listSeries2.put("Death", sD);
        renderer.setSeriesPaint(in, Color.BLACK);
        
        JCheckBox DBox = new JCheckBox("Death");
        DBox.setForeground(Color.BLACK);
        DBox.setSelected(true);
        DBox.setEnabled(false);
        DBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (DBox.isSelected()) {
                    listSeries.put("Death", Color.BLACK);
                    listSeries2.put("Death", sD);
                } else {
                    listSeries.remove("Death");
                    listSeries2.remove("Death");
                }
                reset();
            }
        });
        this.listCheckBox.add(DBox);
        p.add(DBox);
        
        in++;
        
        if (in % 6 == 0) {
            p = new JPanel();
            p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
            this.checkBoxPanel.add(p);
        }
        
        XYSeries sickSeries = new XYSeries("Sick");
        this.sickNumber = this.numberHuman - model.getListHealth().size();
        sickSeries.add(1, this.sickNumber);
        this.listSeries.put("Sick", Color.RED);
        this.listSeries2.put("Sick", sickSeries);
        renderer.setSeriesPaint(in, Color.RED);
//        renderer.setSeriesStroke(in, new BasicStroke(5.0f));

        JCheckBox sickBox = new JCheckBox("Sick");
        sickBox.setForeground(Color.RED);
        sickBox.setSelected(true);
        sickBox.setEnabled(false);
        sickBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sickBox.isSelected()) {
                    listSeries.put("Sick", Color.RED);
                    listSeries2.put("Sick", sickSeries);
                } else {
                    listSeries.remove("Sick");
                    listSeries2.remove("Sick");
                }
                reset();
            }
        });
        this.listCheckBox.add(sickBox);
        p.add(sickBox);
        
        int o = 0;
        for (Entry<String, XYSeries> s : this.listSeries2.entrySet()) {
            this.dataset.addSeries(s.getValue());
            this.renderer.setSeriesPaint(o, listSeries.get(s.getKey()));
            o++;
        }
        this.slider.setEnabled(false);
        
    }
    
    public void stop() {
        this.slider.setEnabled(true);
        this.isStop = true;
        for (JCheckBox jc : this.listCheckBox) {
            jc.setEnabled(true);
        }
    }
    
    public void reset() {
        int ind = 0;
        this.dataset.removeAllSeries();
        for (Entry<String, XYSeries> e : this.listSeries2.entrySet()) {
            renderer.setSeriesPaint(ind, listSeries.get(e.getKey()));
            this.dataset.addSeries(e.getValue());
            ind++;
        }
    }
    
    public void checkValue() {
        int day = model.getDay();
        this.listSeries2.get("Health").add(day, model.getListHealth().size());
        for (SymptomStage ss : model.getListSymptomStage1sNonHospital()) {
            this.listSeries2.get(ss.getName()).add(day, ss.getListMember().size());
        }
        for (SymptomStage ss : model.getListSymptomStage1sHospital()) {
            this.listSeries2.get(ss.getName()).add(day, ss.getListMember().size());
        }
        this.listSeries2.get("Immune").add(day, model.getListImmune().size());
        this.listSeries2.get("Death").add(day, model.getListDeath().size());
        this.sickNumber = this.numberHuman - model.getListHealth().size();
        this.listSeries2.get("Sick").add(day, this.sickNumber);
        lastValue++;
        this.slider.setMaximum(this.lastValue);
        this.slider.setValue(this.lastValue);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        /*this.lastValue += 1;
        Random r = new Random();
        series.add(lastValue, r.nextInt(2000));
        s1.add(lastValue, r.nextInt(2000));
        s2.add(lastValue, r.nextInt(2000));
        s3.add(lastValue, r.nextInt(2000));
        s4.add(lastValue, r.nextInt(2000));
        s5.add(lastValue, r.nextInt(2000));
        this.listValues.add(this.lastValue);
        this.slider.setMaximum(this.lastValue);
        this.slider.setValue(this.lastValue);

        index += 10;*/
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        if (isStop) {
            int value = this.slider.getValue();
            Range range = null;
            if ((value + 5) > this.lastValue) {
                range = new Range(lastValue - 10, this.lastValue);
            } else if ((value - 5) <= 0) {
                range = new Range(0, 10);
            } else {
                range = new Range(value - 5, value + 5);
            }
            domainAxis.setRange(range);
        }
    }
}
