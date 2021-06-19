/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class PieChart_AWT2 extends JFrame {
   static String title;   
   
   public PieChart_AWT2( String title ) {
      super( title ); 
      setContentPane(createDemoPanel( ));
      this.title=title;
      setDefaultCloseOperation(HIDE_ON_CLOSE);
   }
   
   private static PieDataset createDataset( ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "Ipv4" ,capman.GUI.ip4C );  
      dataset.setValue( "Ipv6" , capman.GUI.ip6C );   
      dataset.setValue( "Other" , capman.GUI.totC - capman.GUI.tcpC - capman.GUI.udpC);
      return dataset;         
   }
   
   private static JFreeChart createChart( PieDataset dataset,String title ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         title,   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
   
   public static JPanel createDemoPanel( ) {
      JFreeChart chart = createChart(createDataset( ), title );  
      return new ChartPanel( chart ); 
   }

   public static void main( String[ ] args ) {

   }
}