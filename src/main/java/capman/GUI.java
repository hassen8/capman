package capman;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import org.jfree.ui.RefineryUtilities;
import pcap.spi.Interface;
import pcap.spi.Service;
import statistics.PieChart_AWT;
import statistics.PieChart_AWT2;

public class GUI extends javax.swing.JFrame {

    public static int tcpC;
    public static int udpC;
    public static int ip4C;
    public static int ip6C;
    public static int totC;
    DefaultTableModel tbmPackets;
    CaptureTraffic captureThread;
    Details detail;
    static int deviceIndex;
    static Interface device;

    /**
     * Creates new form GUI
     */
    public GUI(int deviceIndex) {
        // Create a table model
        this.deviceIndex = deviceIndex;
        tbmPackets = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Time", "IP Version", "Source", "Destination", "Protocol", "Packet Details"
                }
        );
        // Initialize thread value
        captureThread = null;

        initComponents();

        scpTblPackets.getViewport().setBackground(Color.white);
        getContentPane().setBackground(Color.white);
    }

    // Add row to the table
    public void addRow(Packet packet) {
        tbmPackets.addRow(new Object[]{
            packet.getTime(), packet.getIpVersion(), packet.getSource(), packet.getDest(), packet.getProtocol(), packet.getData(),});
    }

    // Update packets count
    public void updatePacketsCount() {
        lblPacketsCount.setText(Integer.toString(tbmPackets.getRowCount()));
        totC++;
    }

    // Scroll to bottom of the table
    public void scrollToBottom() {
        JScrollBar scrollBar = scpTblPackets.getVerticalScrollBar();
        scrollBar.setValue(scrollBar.getMaximum());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scpTblPackets = new javax.swing.JScrollPane();
        tblPackets = new javax.swing.JTable();
        btnStartStop = new javax.swing.JButton();
        lblPacketsCountText = new javax.swing.JLabel();
        lblPacketsCount = new javax.swing.JLabel();
        btnClearTable = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuView = new javax.swing.JMenu();
        save = new javax.swing.JMenuItem();
        back = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        viewDetails = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        ipCharts = new javax.swing.JMenuItem();
        protCharts = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        tblPackets.setFont(tblPackets.getFont().deriveFont(tblPackets.getFont().getSize()+3f));
        tblPackets.setModel(tbmPackets);
        tblPackets.setRowHeight(30);
        tblPackets.setSelectionBackground(new java.awt.Color(0, 102, 204));
        tblPackets.setSelectionForeground(new java.awt.Color(255, 255, 255));
        scpTblPackets.setViewportView(tblPackets);

        btnStartStop.setBackground(new java.awt.Color(0, 102, 204));
        btnStartStop.setFont(btnStartStop.getFont().deriveFont(btnStartStop.getFont().getSize()+2f));
        btnStartStop.setForeground(new java.awt.Color(255, 255, 255));
        btnStartStop.setText("Start");
        btnStartStop.setBorder(null);
        btnStartStop.setPreferredSize(new java.awt.Dimension(48, 30));
        btnStartStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartStopActionPerformed(evt);
            }
        });

        lblPacketsCountText.setFont(lblPacketsCountText.getFont().deriveFont(lblPacketsCountText.getFont().getSize()+2f));
        lblPacketsCountText.setText("Total packets captured:");

        lblPacketsCount.setFont(lblPacketsCount.getFont().deriveFont(lblPacketsCount.getFont().getSize()+2f));
        lblPacketsCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPacketsCount.setText("0");

        btnClearTable.setBackground(new java.awt.Color(102, 102, 102));
        btnClearTable.setFont(btnClearTable.getFont().deriveFont(btnClearTable.getFont().getSize()+2f));
        btnClearTable.setForeground(new java.awt.Color(255, 255, 255));
        btnClearTable.setText("Clear");
        btnClearTable.setBorder(null);
        btnClearTable.setPreferredSize(new java.awt.Dimension(48, 30));
        btnClearTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearTableActionPerformed(evt);
            }
        });

        menuView.setText("File");

        save.setText("Save captured packets");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        menuView.add(save);

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        menuView.add(back);

        jMenuBar1.add(menuView);

        jMenu2.setText("View");

        viewDetails.setText("View Device Details");
        viewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailsActionPerformed(evt);
            }
        });
        jMenu2.add(viewDetails);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Statistics");

        ipCharts.setText("Ip Version");
        ipCharts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipChartsActionPerformed(evt);
            }
        });
        jMenu1.add(ipCharts);

        protCharts.setText("Protocols");
        protCharts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                protChartsActionPerformed(evt);
            }
        });
        jMenu1.add(protCharts);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpTblPackets, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPacketsCountText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPacketsCount)
                .addContainerGap(468, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnStartStop, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClearTable, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStartStop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scpTblPackets, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPacketsCountText)
                    .addComponent(lblPacketsCount))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  private void btnStartStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartStopActionPerformed
      if (captureThread == null) {
          captureThread = new CaptureTraffic(this);
          captureThread.start();
          btnStartStop.setText("Stop");
          btnStartStop.setBackground(Color.decode("#990000"));
      } else {
          captureThread.interrupt();
          captureThread = null;
          btnStartStop.setText("Start");
          btnStartStop.setBackground(Color.decode("#0066cc"));
      }
  }//GEN-LAST:event_btnStartStopActionPerformed

  private void btnClearTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearTableActionPerformed
      tbmPackets.setRowCount(0);
      lblPacketsCount.setText("0");
  }//GEN-LAST:event_btnClearTableActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if (captureThread == null) {
            if (tblPackets.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Capture Some Packets first, you DONUT", "No Captured Packets", JOptionPane.WARNING_MESSAGE);
            } else {
                JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                fc.setDialogTitle("Specify a Location to save the file at");
                int userSelection = fc.showSaveDialog(this);
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    saveToFile(fc.getSelectedFile().getPath());

                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please stop capturing packets to save the file", "Stop The Capture", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void viewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailsActionPerformed
        detail = new Details();
        detail.run();
        DeviceDetails obj = new DeviceDetails(device);
        obj.setVisible(true);
        obj.setAlwaysOnTop(true);
        obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_viewDetailsActionPerformed

    private void protChartsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_protChartsActionPerformed
        try {
            if (totC == 0) {
                JOptionPane.showMessageDialog(this, "Can't Perform analysis without Data, Capture some packets first", "No Captured Packets", JOptionPane.WARNING_MESSAGE);
            } else {
                PieChart_AWT demo = new PieChart_AWT("Protocol Based");
                demo.setSize(560, 367);
                RefineryUtilities.centerFrameOnScreen(demo);
                demo.setVisible(true);
                demo.setDefaultCloseOperation(HIDE_ON_CLOSE);

            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_protChartsActionPerformed

    private void ipChartsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipChartsActionPerformed
        try {
            if (totC == 0) {
                JOptionPane.showMessageDialog(this, "Can't Perform analysis without Data, Capture some packets first", "No Captured Packets", JOptionPane.WARNING_MESSAGE);
            } else {
                PieChart_AWT2 demo = new PieChart_AWT2("IP version Based");
                demo.setSize(560, 367);
                RefineryUtilities.centerFrameOnScreen(demo);
                demo.setVisible(true);
                demo.setDefaultCloseOperation(HIDE_ON_CLOSE);

            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_ipChartsActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        DeviceList obj = new DeviceList();
        obj.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        com.formdev.flatlaf.FlatLightLaf.install();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI(-1).setVisible(true);
            }
        });
    }

    public void saveToFile(String path) {
        try {

            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < tblPackets.getRowCount(); i++) {

                for (int j = 0; j < tblPackets.getColumnCount(); j++) {
                    bw.write(tblPackets.getModel().getValueAt(i, j) + " ");
                }
                bw.write("\n");
            }
            //close BufferedWriter
            bw.close();
            //close FileWriter 
            fw.close();
            JOptionPane.showMessageDialog(null, "Packet Capture file is stored successfully in " + path);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem back;
    private javax.swing.JButton btnClearTable;
    private javax.swing.JButton btnStartStop;
    private javax.swing.JMenuItem ipCharts;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblPacketsCount;
    private javax.swing.JLabel lblPacketsCountText;
    private javax.swing.JMenu menuView;
    private javax.swing.JMenuItem protCharts;
    private javax.swing.JMenuItem save;
    private javax.swing.JScrollPane scpTblPackets;
    private javax.swing.JTable tblPackets;
    private javax.swing.JMenuItem viewDetails;
    // End of variables declaration//GEN-END:variables
}

class Details extends Thread {

    Interface device;

    public void run() {
        PacketSniffer packetSniffer = new PacketSniffer();
        Service service = packetSniffer.createService();
        device = packetSniffer.getDevice(service, GUI.deviceIndex);
        GUI.device = device;
    }

}
