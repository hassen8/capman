/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import javax.swing.JFrame;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.PieSeries.PieSeriesRenderStyle;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.PieStyler.AnnotationType;

/**
 *
 * @author Hassen
 */
public class PieChart04 extends JFrame implements ExampleChart<PieChart> {
    int other;
    
public static void main(String[] args) {
 
    ExampleChart<PieChart> exampleChart = new PieChart04();
    PieChart chart = exampleChart.getChart();
    new SwingWrapper<PieChart>(chart).displayChart();
  }
 
  @Override
  public PieChart getChart() {
 
    // Create Chart
    PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();
 
    // Customize Chart
    chart.getStyler().setLegendVisible(false);
    chart.getStyler().setAnnotationType(AnnotationType.Label);
    chart.getStyler().setAnnotationDistance(.82);
    chart.getStyler().setPlotContentSize(.9);
    chart.getStyler().setDefaultSeriesRenderStyle(PieSeriesRenderStyle.Donut);
    // chart.getStyler().setCircular(false);
 
    // Series
    chart.addSeries("TCP", capman.GUI.tcpC);
    chart.addSeries("UDP",capman.GUI.tcpC );
    chart.addSeries("Hello", 34);
    chart.addSeries("D", 22);
    chart.addSeries("E", 29);
    chart.addSeries("F", 40);
 
    return chart;
  }

    @Override
    public String getExampleChartName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
