package chart;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFactory;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.time.DateRange;
import org.jfree.data.time.Day;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DomainTranslateDemo2 extends ApplicationFrame {

    private static class DemoPanel extends JPanel implements ChangeListener, ActionListener {

        private static int SLIDER_INITIAL_VALUE = 50;
        private JSlider slider;
        private ValueAxis domainAxis;
        private int lastValue = SLIDER_INITIAL_VALUE;
        private double lastValu = 100.0;

        // one month (milliseconds, seconds, minutes, hours, days)
        private int delta = 1000 * 60 * 60 * 24 * 30;
        private Timer timer = new Timer(250, this);

        XYSeries series;
        XYDataset set;

        public DemoPanel() {
            super(new BorderLayout());
            timer.setInitialDelay(1000);

            JFreeChart chart = createChart();
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new java.awt.Dimension(600, 270));
            chartPanel.setDomainZoomable(true);
            chartPanel.setRangeZoomable(true);
            Border border = BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(4, 4, 4, 4),
                    BorderFactory.createEtchedBorder()
            );
            chartPanel.setBorder(border);
            add(chartPanel);

            JPanel dashboard = new JPanel(new BorderLayout());
            dashboard.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));

            this.slider = new JSlider(0, 100, SLIDER_INITIAL_VALUE);
            this.slider.addChangeListener(this);
            dashboard.add(this.slider);
            add(dashboard, BorderLayout.SOUTH);
            timer.start();
        }

        private XYSeries createDataset() {

            XYSeries serie = new XYSeries("2016");
            serie.add(18, 567);
            serie.add(20, 612);
            serie.add(25, 800);
            serie.add(30, 980);
            serie.add(40, 1410);
            serie.add(50, 2350);
            this.lastValu = 50;

            return serie;
        }

        private JFreeChart createChart() {

            XYSeriesCollection timeSeriesCollection = new XYSeriesCollection();
            this.series = createDataset();
            timeSeriesCollection.addSeries(series);

            NumberAxis rangeAxis = new NumberAxis("");
            XYBarRenderer renderer = new XYBarRenderer();
            renderer.setShadowVisible(false);
            // XYPlot plot = new XYPlot(timeSeriesCollection, domainAxis, rangeAxis, renderer);

//            JFreeChart chart = new JFreeChart(
//                    "Dynamic Line And TimeSeries Chart",
//                    "Time",
//                    "Value",
//                    timeSeriesCollection,
//                    true,
//                    true,
//                    false);
            final JFreeChart chart = ChartFactory.createTimeSeriesChart(
                    "Dynamic Line And TimeSeries Chart",
                    "Time",
                    "Value",
                    timeSeriesCollection,
                    true,
                    true,
                    false
            );
            // performance
            final XYPlot plot = chart.getXYPlot();
            this.domainAxis = plot.getDomainAxis();

            ValueAxis xaxis = plot.getDomainAxis();
            xaxis.setAutoRange(true);

            //Domain axis would show data of 60 seconds for a time
            xaxis.setFixedAutoRange(60000.0);  // 60 seconds
            xaxis.setVerticalTickLabels(true);

            ValueAxis yaxis = plot.getRangeAxis();
            yaxis.setRange(0.0, 2500);

            chart.setAntiAlias(false);
            return chart;
        }

        @Override
        public void stateChanged(ChangeEvent event) {
//            int value = this.slider.getValue();
//            long minimum = domainAxis.get
//            ..getTime();
//            long maximum = domainAxis.getMaximumDate().getTime();
//            if (value < lastValue) { // left
//                minimum = minimum - delta;
//                maximum = maximum - delta;
//            } else { // right
//                minimum = minimum + delta;
//                maximum = maximum + delta;
//            }
//            DateRange range = new DateRange(minimum, maximum);
//            domainAxis.setRange(range);
//            lastValue = value;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            final double factor = 0.9 + 0.2 * Math.random();
            this.lastValu = this.lastValu * factor;

            final Millisecond now = new Millisecond();
            this.series.add(this.lastValu + 5, 6);
        }
    }

    public DomainTranslateDemo2(String title) {
        super(title);
        setContentPane(new DemoPanel());
    }

    public static JPanel createDemoPanel() {
        return new DemoPanel();
    }

    public static void main(String[] args) {
        DomainTranslateDemo2 demo = new DomainTranslateDemo2("Translate Demo");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
