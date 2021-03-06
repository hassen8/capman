/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.About;
import capman.DeviceList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

/**
 *
 * @author Hassen
 */
public class LaunchFrame extends javax.swing.JFrame {

    /**
     * Creates new form LaunchFrame
     */
    public LaunchFrame() {
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(LightOption);
        group.add(DarkOption);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogo = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        Exit = new javax.swing.JMenuItem();
        ThemeOptions = new javax.swing.JMenu();
        LightOption = new javax.swing.JCheckBoxMenuItem();
        DarkOption = new javax.swing.JCheckBoxMenuItem();
        jMenu1 = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N

        btnStart.setBackground(new java.awt.Color(248, 207, 159));
        btnStart.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnStart.setForeground(new java.awt.Color(0, 0, 0));
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        File.setText("File");

        Exit.setText("Exit");
        File.add(Exit);

        MenuBar.add(File);

        ThemeOptions.setText("Theme Options");

        LightOption.setSelected(true);
        LightOption.setText("Light Mode");
        LightOption.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                LightOptionItemStateChanged(evt);
            }
        });
        ThemeOptions.add(LightOption);

        DarkOption.setText("Dark Mode");
        DarkOption.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DarkOptionItemStateChanged(evt);
            }
        });
        ThemeOptions.add(DarkOption);

        MenuBar.add(ThemeOptions);

        jMenu1.setText("About");

        about.setText("About App");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        jMenu1.add(about);

        MenuBar.add(jMenu1);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(270, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(410, 410, 410))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblLogo)
                        .addGap(270, 270, 270))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(lblLogo)
                .addGap(92, 92, 92)
                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LightOptionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_LightOptionItemStateChanged
        setTheme(evt,"light");
    }//GEN-LAST:event_LightOptionItemStateChanged

    private void DarkOptionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DarkOptionItemStateChanged
        setTheme(evt,"dark");
    }//GEN-LAST:event_DarkOptionItemStateChanged

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
       About obj = new About(this, rootPaneCheckingEnabled);
       obj.setVisible(true);       
    }//GEN-LAST:event_aboutActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
       DeviceList obj = new DeviceList();
       obj.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnStartActionPerformed

    /**
     * @param args the command line arguments
     */
    public void setTheme(java.awt.event.ItemEvent evt, String name){
        if (evt.getStateChange() == 1) {
      if ("light".equals(name)) {
        com.formdev.flatlaf.FlatLightLaf.install();
      } else {
        com.formdev.flatlaf.FlatDarculaLaf.install();
      }
      for (java.awt.Window window : javax.swing.JFrame.getWindows()) {
        javax.swing.SwingUtilities.updateComponentTreeUI(window);
      }
    }
     
        
    
    }
    
    public static void main(String args[]) {

        com.formdev.flatlaf.FlatLightLaf.install();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new LaunchFrame().setVisible(true);
               
                
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem DarkOption;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu File;
    private javax.swing.JCheckBoxMenuItem LightOption;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu ThemeOptions;
    private javax.swing.JMenuItem about;
    private javax.swing.JButton btnStart;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel lblLogo;
    // End of variables declaration//GEN-END:variables
}
