/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.profiling.system;

import JpaImplementation.Resident;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author PlonGaming
 */
public class SearchWindow extends javax.swing.JFrame {

    /**
     * Creates new form SearchWindow
     */
    public SearchWindow() throws SQLException {
        initComponents();
        tableDesign();
        getTableData();
//        sortTable();
        queryByTableData();
        setIconImage();
        enableDate();
        enableTime();
        this.setLocationRelativeTo(null);
        
    }
    
    void enableDate() {
        Date date = new Date();
        SimpleDateFormat time = new SimpleDateFormat("MM-dd-yyyy");
        dateLbl.setText(time.format(date));
    }

    void enableTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Date date = new Date();
                SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
                timeLbl.setText(time.format(date));
            }
        }
        ).start();
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
        queryTable = new javax.swing.JTable();
        queryField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        printBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        healthCondBox = new javax.swing.JComboBox<>();
        bothQueryBtm = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        dateLbl = new javax.swing.JLabel();
        timeLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        displayName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Community e-Profiling System");
        setMaximumSize(new java.awt.Dimension(1272, 827));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        queryTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        queryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Firstname", "Lastname", "Middlename", "Purok", "Barangay ID", "Barangay", "Health Condition"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(queryTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 950, 680));

        queryField.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        queryField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        queryField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        queryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryFieldActionPerformed(evt);
            }
        });
        queryField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                queryFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                queryFieldKeyReleased(evt);
            }
        });
        getContentPane().add(queryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 250, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("SEARCH BARANGAY");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 30));

        printBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        printBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Print_48px.png"))); // NOI18N
        printBtn.setText("PRINT");
        printBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });
        getContentPane().add(printBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 230, 50));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("HEALTH CONDITION");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 30));

        healthCondBox.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        healthCondBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECT-", "HEALTHY", "PRE-EXISTING CONDITION", "CHRONIC ILLNESS", "PREGNANT", "PERMANENTLY DISABLED" }));
        healthCondBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        healthCondBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                healthCondBoxKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                healthCondBoxKeyReleased(evt);
            }
        });
        getContentPane().add(healthCondBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 250, 40));

        bothQueryBtm.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bothQueryBtm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search_48px.png"))); // NOI18N
        bothQueryBtm.setText("SEARCH BOTH");
        bothQueryBtm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bothQueryBtmMouseClicked(evt);
            }
        });
        bothQueryBtm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bothQueryBtmActionPerformed(evt);
            }
        });
        getContentPane().add(bothQueryBtm, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 230, 50));

        refreshBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Restart_48px.png"))); // NOI18N
        refreshBtn.setText("REFRESH TABLE");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });
        getContentPane().add(refreshBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 230, 50));

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Delete_48px.png"))); // NOI18N
        jButton1.setText("CLEAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 230, 50));

        dateLbl.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        dateLbl.setText("DATE");
        getContentPane().add(dateLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 100, -1, -1));

        timeLbl.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        timeLbl.setText("TIME");
        getContentPane().add(timeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 100, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/e/profiling/system/query.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, -1));

        displayName.setText("jTextField1");
        getContentPane().add(displayName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 740, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBtnActionPerformed
        String name = queryField.getText();
        String health = healthCondBox.getSelectedItem().toString();
        MainWindow mw = new MainWindow();
        

        if (name.isEmpty() && health.equalsIgnoreCase("-SELECT-")) {
            JOptionPane.showMessageDialog(null, "Please SPECIFY a Barangay, a Health Condition or BOTH\nTo CONTINUE to PRINT.", "Community e-Profling System", JOptionPane.WARNING_MESSAGE);
        } else {
            MessageFormat header = new MessageFormat("List of Residents in Barangay " + name.toUpperCase());
            MessageFormat footer = new MessageFormat("Page {0,number,integer} | Prepared by: " + displayName.getText() + " | Printed: " + dateLbl.getText() + " " + timeLbl.getText());
            try {
                queryTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            } catch (java.awt.print.PrinterException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_printBtnActionPerformed

    private void queryFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_queryFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            queryByBarangay();
        }
    }//GEN-LAST:event_queryFieldKeyPressed

    private void queryFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_queryFieldKeyReleased
        String q = queryField.getText();

        if (q.isEmpty()) {
            try {
                queryByTableData();
            } catch (SQLException ex) {
                Logger.getLogger(SearchWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_queryFieldKeyReleased

    private void queryFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryFieldActionPerformed

    }//GEN-LAST:event_queryFieldActionPerformed

    private void healthCondBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_healthCondBoxKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            queryByHealthCond();
        }
    }//GEN-LAST:event_healthCondBoxKeyPressed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        try {
            queryByTableData();
            queryField.setText(null);
            healthCondBox.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(SearchWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void healthCondBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_healthCondBoxKeyReleased
        if (healthCondBox.getSelectedItem().equals("-SELECT-")) {
            try {
                queryByTableData();
            } catch (SQLException ex) {
                Logger.getLogger(SearchWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_healthCondBoxKeyReleased

    private void bothQueryBtmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bothQueryBtmActionPerformed

        if (queryField.getText().isEmpty() && healthCondBox.getSelectedItem().equals("-SELECT-")) {
            JOptionPane.showMessageDialog(null, "There is NOTHING to SEARCH!\nFIELDS are EMPTY!", "ERROR", JOptionPane.ERROR_MESSAGE);
            try {
                queryByTableData();
            } catch (SQLException ex) {
                Logger.getLogger(SearchWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            saveTry();
        }
    }//GEN-LAST:event_bothQueryBtmActionPerformed

    private void bothQueryBtmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bothQueryBtmMouseClicked
        
    }//GEN-LAST:event_bothQueryBtmMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            queryByTableData();
            queryField.setText(null);
            healthCondBox.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(SearchWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
//            java.util.logging.Logger.getLogger(SearchWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SearchWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SearchWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SearchWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SearchWindow().setVisible(true);
//            }
//        });
//    }
    public void saveTry() {
        String a = queryField.getText();
        String b = healthCondBox.getSelectedItem().toString();

        if (a.isEmpty() && b.equalsIgnoreCase("-SELECT-")) {
            JOptionPane.showMessageDialog(null, "There is NOTHING to SEARCH!", "Community e-Profiling System", JOptionPane.WARNING_MESSAGE);
        } else {
            queryByHealthCondAndBrgy();
        }
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
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
        String[] colNames = {"FIRSTNAME", "LASTNAME", "MIDDLENAME", "PUROK", "BARANGAY ID", "BARANGAY", "HEALTH CONDITION"};
        queryTable = new javax.swing.JTable(tablemodel);
        queryTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        queryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        queryTable.setShowGrid(true);
        queryTable.setFillsViewportHeight(true);
        queryTable.getTableHeader().setReorderingAllowed(false);
        queryTable.setRowSelectionAllowed(true);
        queryTable.setBackground(Color.getHSBColor(180, 244, 217));
        queryTable.setFont(new java.awt.Font("Century Gothic", 0, 12));
        queryTable.setRowHeight(20);
        jScrollPane1.setViewportView(queryTable);
        JTableHeader head = queryTable.getTableHeader();
        head.setFont(new java.awt.Font("Century Gothic", 1, 12));
        head.setBackground(Color.getHSBColor(255, 204, 217));
        head.setResizingAllowed(false);
        head.setPreferredSize(new Dimension(head.WIDTH, 30));
        for (int i = 0; i < colNames.length;) {
            tablemodel.addColumn(colNames[i]);
            i++;
        }
        TableColumn[] col = new TableColumn[7];
        col[0] = queryTable.getColumnModel().getColumn(0);
        col[0].setPreferredWidth(25);
        col[1] = queryTable.getColumnModel().getColumn(1);
        col[1].setPreferredWidth(25);
        col[2] = queryTable.getColumnModel().getColumn(2);
        col[2].setPreferredWidth(25);
        col[3] = queryTable.getColumnModel().getColumn(3);
        col[3].setPreferredWidth(25);
        col[4] = queryTable.getColumnModel().getColumn(4);
        col[4].setPreferredWidth(15);
        col[5] = queryTable.getColumnModel().getColumn(5);
        col[5].setPreferredWidth(100);
        col[6] = queryTable.getColumnModel().getColumn(6);
        col[6].setPreferredWidth(30);
    }

    public void getTableData() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("e-Profiling_SystemPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Vector row = new Vector();

        try {
            Query q = em.createNamedQuery("Resident.findAll", Resident.class);
            List<Resident> list = q.getResultList();

            if (list.isEmpty()) {
            } else {
                for (Resident r : list) {
                    Vector column = new Vector();
                    column.add(r.getResFirstname());
                    column.add(r.getResLastname());
                    column.add(r.getResMidname());
                    column.add(r.getResPurok());
                    column.add(r.getResbrgyID());
                    column.add(r.getResBarangay());
                    column.add(r.getResHealthCond());
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

    public void queryByBarangay() {
        try {
            String search = queryField.getText();

            if (search.isEmpty()) {
                JOptionPane.showMessageDialog(null, "There is nothing to SEARCH!", "WARNING!", JOptionPane.WARNING_MESSAGE);
            } else {
                String[][] datas = queryForSearchWindow.Arraylist(queryForSearchWindow.executeQueryByBrgy(search));
                String[] ColNames = {"Firstname", "Lastname", "Middlename", "Purok", "Barangay ID", "Barangay", "Health Condition"};

                DefaultTableModel dtm = new DefaultTableModel(datas, ColNames);
                queryTable.setModel(dtm);
                TableColumnModel Col = queryTable.getColumnModel();
                queryTable.setColumnModel(Col);

            }
        } catch (SQLException e) {
            Logger.getLogger(SearchWindow.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void queryByHealthCond() {
        try {
            String health = healthCondBox.getSelectedItem().toString();

            if (health.isEmpty()) {
                JOptionPane.showMessageDialog(null, "There is nothing to SEARCH!", "WARNING!", JOptionPane.WARNING_MESSAGE);
            } else {
                String[][] datas = queryForSearchWindow.Arraylist(queryForSearchWindow.executeQueryByHealthCond(health));
                String[] ColNames = {"Firstname", "Lastname", "Middlename", "Purok", "Barangay ID", "Barangay", "Health Condition"};

                DefaultTableModel dtm = new DefaultTableModel(datas, ColNames);
                queryTable.setModel(dtm);
                TableColumnModel Col = queryTable.getColumnModel();
                queryTable.setColumnModel(Col);
            }
        } catch (SQLException e) {
            Logger.getLogger(SearchWindow.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void queryByHealthCondAndBrgy() {
        try {
            String health = healthCondBox.getSelectedItem().toString();
            String a = queryField.getText();

            if (health.isEmpty() && a.isEmpty()) {
                JOptionPane.showMessageDialog(null, "There is nothing to SEARCH!", "WARNING!", JOptionPane.WARNING_MESSAGE);
            } else {
                String[][] datas = queryForSearchWindow.Arraylist(queryForSearchWindow.executeQueryByBrgyAndHealth(a, health));
                String[] ColNames = {"Firstname", "Lastname", "Middlename", "Purok", "Barangay ID", "Barangay", "Health Condition"};

                DefaultTableModel dtm = new DefaultTableModel(datas, ColNames);
                queryTable.setModel(dtm);
                TableColumnModel Col = queryTable.getColumnModel();
                queryTable.setColumnModel(Col);
            }

        } catch (SQLException e) {
            Logger.getLogger(SearchWindow.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//    
//    public void sortTable(){
//        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(tablemodel);
//        queryTable.setRowSorter(sorter);
//    }

    public void queryByTableData() throws SQLException {
        String[][] datas = queryForSearchWindow.Arraylist(queryForSearchWindow.executeQueryTable());
        String[] ColNames = {"Firstname", "Lastname", "Middlename", "Purok", "Barangay ID", "Barangay", "Health Condition"};
        DefaultTableModel dtm = new DefaultTableModel(datas, ColNames);
        queryTable.setModel(dtm);
        TableColumnModel Col = queryTable.getColumnModel();
        queryTable.setColumnModel(Col);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bothQueryBtm;
    private javax.swing.JLabel dateLbl;
    public javax.swing.JTextField displayName;
    private javax.swing.JComboBox<String> healthCondBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printBtn;
    private javax.swing.JTextField queryField;
    private javax.swing.JTable queryTable;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JLabel timeLbl;
    // End of variables declaration//GEN-END:variables

}
