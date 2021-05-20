/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capman;

/**
 *
 * @author Hassen
 */
public class TrafficTable extends javax.swing.table.DefaultTableModel {

    public TrafficTable() {
        super(new Object[][]{}, new String[]{"Time", "Ip Version", "Source", "Destination", "Data"});
    }

    public void addRows(java.util.ArrayList<Packets> packets) {
        setRowCount(0);
        if (packets.size() > 0) {
            packets.forEach(packet -> addRow(packet));
        }
    }

    public void addRow(Packets packet) {
        addRow(new Object[]{
            packet.getTime(), packet.getIpVersion(), packet.getSource(), packet.getDest(), packet.getData()});
    }

    public void resizeColumns(javax.swing.table.TableColumnModel columnModel) {
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(0).setMaxWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(1).setMaxWidth(100);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(2).setMaxWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(3).setMaxWidth(100);

    }
}
