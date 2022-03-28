/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.profiling.system;

import JpaImplementation.Resident;
import JpaImplementation.Barangay;
import static e.profiling.system.AddBarangay.Query;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.*;

/**
 *
 * @author PlonGaming
 */
public class ListOfAllBarangay extends javax.swing.JFrame {

    /**
     * Creates new form ListOfAllBarangay
     */
    public ListOfAllBarangay() {
        initComponents();
        tableDesign();
        getTableData();
        this.setLocationRelativeTo(null);
        setIconImage();
        sortTable();

        barangayTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getButton() == MouseEvent.BUTTON1) {
                    if (me.getClickCount() == 1) {
                        int row = barangayTable.getSelectedRow();
                        if (row == -1) {

                        } else {
                            brgyID.setText(barangayTable.getValueAt(row, 0).toString());
                            brgy.setText(barangayTable.getValueAt(row, 1).toString());
                            city.setText(barangayTable.getValueAt(row, 2).toString());
                            prov.setText(barangayTable.getValueAt(row, 3).toString());
                            brgyCap.setText(barangayTable.getValueAt(row, 4).toString());
                        }
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {

            }

            @Override
            public void mouseExited(MouseEvent me) {

            }

        });
    }

    DefaultTableModel tablemodel = new DefaultTableModel() {
        public boolean cellManipulation(int row, int col) {
            if (col == 1) {
                return false;
            } else {
                return false;
            }
        }
    };

    public synchronized void tableDesign() {
        String[] colNames = {"BARANGAY ID", "BARANGAY", "CITY", "PROVINCE", "BARANGAY CAPTAIN"};
        barangayTable = new javax.swing.JTable(tablemodel);
        barangayTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        barangayTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        barangayTable.setShowGrid(true);
        barangayTable.setFillsViewportHeight(true);
        barangayTable.getTableHeader().setReorderingAllowed(false);
        barangayTable.setRowSelectionAllowed(true);
        barangayTable.setBackground(Color.getHSBColor(180, 244, 217));
        barangayTable.setFont(new java.awt.Font("Century Gothic", 0, 12));
        barangayTable.setRowHeight(20);
        jScrollPane1.setViewportView(barangayTable);
        JTableHeader head = barangayTable.getTableHeader();
        head.setFont(new java.awt.Font("Century Gothic", 1, 12));
        head.setBackground(Color.getHSBColor(45, 100, 100));
        head.setResizingAllowed(false);
        head.setPreferredSize(new Dimension(head.WIDTH, 30));
        for (int i = 0; i < colNames.length;) {
            tablemodel.addColumn(colNames[i]);
            i++;
        }
        TableColumn[] col = new TableColumn[8];
        col[0] = barangayTable.getColumnModel().getColumn(0);
        col[0].setPreferredWidth(1);
        col[1] = barangayTable.getColumnModel().getColumn(1);
        col[1].setPreferredWidth(70);
        col[1] = barangayTable.getColumnModel().getColumn(2);
        col[1].setPreferredWidth(60);
        col[2] = barangayTable.getColumnModel().getColumn(3);
        col[2].setPreferredWidth(100);
        col[3] = barangayTable.getColumnModel().getColumn(4);
        col[3].setPreferredWidth(150);
    }

    public void getTableData() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("e-Profiling_SystemPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Vector row = new Vector();

        try {
            Query q = em.createNamedQuery("Barangay.findAll", Barangay.class);
            List<Barangay> list = q.getResultList();

            if (list.isEmpty()) {
            } else {
                for (Barangay r : list) {
                    Vector column = new Vector();
                    column.add(r.getBarBrgyID());
                    column.add(r.getBarBrgyName());
                    column.add(r.getBarCity());
                    column.add(r.getBarProvince());
                    column.add(r.getBarBrgyCaptain());
                    row.add(column);
                }
            }
            tablemodel.setRowCount(0);
            for (int i = 0; i < row.size(); i++) {
                tablemodel.addRow((Vector) row.get(i));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void updateData() {

        String brgyCapt = brgyCap.getText();

        if (brgyCapt.isEmpty()) {
            JOptionPane.showMessageDialog(null, "PLEASE FILL UP THE FIELD.", "Community e-Profiling System", JOptionPane.WARNING_MESSAGE);
            brgyCap.requestFocus();
        } else {
            try {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("e-Profiling_SystemPU");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();

                try {

                    int id = Integer.parseInt(brgyID.getText().trim());

                    if (em.find(Barangay.class, id) != null) {
                        Barangay bar = em.find(Barangay.class, id);

                        bar.setBarBrgyID(id);
                        bar.setBarBrgyName(brgy.getText().trim());
                        bar.setBarCity(city.getText().trim());
                        bar.setBarProvince(prov.getText().trim());
                        bar.setBarBrgyCaptain(brgyCap.getText().trim());

                        em.merge(bar);
                        em.getTransaction().commit();
                        JOptionPane.showMessageDialog(null, "DATA SUCCESSFULL UPDATED!", "ATTENTION!",
                                JOptionPane.INFORMATION_MESSAGE);
                        getTableData();
                        brgyID.setText(null);
                        brgy.setText("");
                        city.setText("");
                        prov.setText("");
                        brgyCap.setText(null);
                        brgyCap.requestFocus();

                    } else {
                        JOptionPane.showMessageDialog(null, "DATA NOT FOUND!", "ERROR 404", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
                } finally {
                    em.close();
                    emf.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void sortTable(){
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(tablemodel);
        barangayTable.setRowSorter(sorter);
    }
    
    public void clearFields(){
        brgyID.setText(null);
        brgy.setText(null);
        city.setText(null);
        prov.setText(null);
        brgyCap.setText(null);
        brgyCap.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        barangayTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        brgyCap = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        brgyID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        brgy = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        prov = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Community e-Profiling System");
        setMaximumSize(new java.awt.Dimension(1094, 780));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barangayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Barangay ID", "Barangay", "City", "Province", "Barangay Captain"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(barangayTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 790, 660));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel2.setText("BARANGAY CAPTAIN");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        brgyCap.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        brgyCap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        brgyCap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                brgyCapKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                brgyCapKeyTyped(evt);
            }
        });
        getContentPane().add(brgyCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 240, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel4.setText("BARANGAY ID");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        brgyID.setEditable(false);
        brgyID.setBackground(new java.awt.Color(231, 231, 231));
        brgyID.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        brgyID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(brgyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 240, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel5.setText("BARANGAY");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        brgy.setEditable(false);
        brgy.setBackground(new java.awt.Color(231, 231, 231));
        brgy.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        brgy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(brgy, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 240, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel6.setText("CITY/MUNICIPALITY");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        city.setEditable(false);
        city.setBackground(new java.awt.Color(231, 231, 231));
        city.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        city.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(city, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 240, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel7.setText("PROVINCE");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        prov.setEditable(false);
        prov.setBackground(new java.awt.Color(231, 231, 231));
        prov.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        prov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(prov, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 240, 30));

        saveBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Save_48px.png"))); // NOI18N
        saveBtn.setText("SAVE");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        getContentPane().add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 160, 50));

        cancelBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cancelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Delete_48px.png"))); // NOI18N
        cancelBtn.setText("CANCEL");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        getContentPane().add(cancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 160, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/e/profiling/system/LOAB.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        
        
        int reply = JOptionPane.showConfirmDialog(null, "Do you WISH to accept CHANGES?", "Community e-Profiling System",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (reply == JOptionPane.YES_OPTION) {
            updateData();
        } else {

        }
        
    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        clearFields();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void brgyCapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brgyCapKeyReleased
        brgyCap.setText(brgyCap.getText().toUpperCase());
    }//GEN-LAST:event_brgyCapKeyReleased

    private void brgyCapKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brgyCapKeyTyped
        char a = evt.getKeyChar();
        
        if (Character.isDigit(a)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_brgyCapKeyTyped

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ListOfAllBarangay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ListOfAllBarangay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ListOfAllBarangay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ListOfAllBarangay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ListOfAllBarangay().setVisible(true);
//            }
//        });
//    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable barangayTable;
    private javax.swing.JTextField brgy;
    private javax.swing.JTextField brgyCap;
    private javax.swing.JTextField brgyID;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField city;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField prov;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
