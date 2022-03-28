/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.profiling.system;

import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import JdbcImplementation.JDBC;
import JpaImplementation.Resident;
import static e.profiling.system.AddBarangay.Query;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author PlonGaming
 */
public class ListOfAllResidents extends javax.swing.JFrame {

    /**
     * Creates new form ListOfAllResidents
     */
    public ListOfAllResidents() throws SQLException {
        initComponents();
        tableDesign();
        getTableData();
        sortTable();
        this.setLocationRelativeTo(null);
        setIconImage();

        residentsTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getButton() == MouseEvent.BUTTON1) {
                    if (me.getClickCount() == 1) {
                        int row = residentsTable.getSelectedRow();
                        if (row == -1) {

                        } else {

                            res_ID.setText(residentsTable.getValueAt(row, 0).toString());
                            firstname.setText(residentsTable.getValueAt(row, 1).toString());
                            lastname.setText(residentsTable.getValueAt(row, 2).toString());
                            midname.setText(residentsTable.getValueAt(row, 3).toString());
                            purok.setText(residentsTable.getValueAt(row, 4).toString());
                            brgyID.setText(residentsTable.getValueAt(row, 5).toString());
                            brgy.setText(residentsTable.getValueAt(row, 6).toString());
                            gendField.setText(residentsTable.getValueAt(row, 7).toString());
                            healthCond.setSelectedItem(residentsTable.getValueAt(row, 8).toString());
                            searchImage();
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
        String[] colNames = {"DB_ID", "FIRSTNAME", "LASTNAME", "MIDDLENAME", "PUROK", "BARANGAY ID", "BARANGAY", "GENDER", "HEALTH CONDITION"};
        residentsTable = new javax.swing.JTable(tablemodel);
        residentsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        residentsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        residentsTable.setShowGrid(true);
        residentsTable.setFillsViewportHeight(true);
        residentsTable.getTableHeader().setReorderingAllowed(false);
        residentsTable.setRowSelectionAllowed(true);
        residentsTable.setBackground(Color.getHSBColor(180, 244, 217));
        residentsTable.setFont(new java.awt.Font("Century Gothic", 0, 12));
        residentsTable.setRowHeight(20);
        jScrollPane1.setViewportView(residentsTable);
        JTableHeader head = residentsTable.getTableHeader();
        head.setFont(new java.awt.Font("Century Gothic", 1, 12));
        head.setBackground(Color.getHSBColor(45, 100, 100));
        head.setResizingAllowed(false);
        head.setPreferredSize(new Dimension(head.WIDTH, 30));
        for (int i = 0; i < colNames.length;) {
            tablemodel.addColumn(colNames[i]);
            i++;
        }
        TableColumn[] col = new TableColumn[8];
        col[0] = residentsTable.getColumnModel().getColumn(0);
        col[0].setPreferredWidth(10);
        col[1] = residentsTable.getColumnModel().getColumn(1);
        col[1].setPreferredWidth(30);
        col[1] = residentsTable.getColumnModel().getColumn(2);
        col[1].setPreferredWidth(30);
        col[2] = residentsTable.getColumnModel().getColumn(3);
        col[2].setPreferredWidth(50);
        col[3] = residentsTable.getColumnModel().getColumn(4);
        col[3].setPreferredWidth(30);
        col[4] = residentsTable.getColumnModel().getColumn(5);
        col[4].setPreferredWidth(15);
        col[6] = residentsTable.getColumnModel().getColumn(6);
        col[6].setPreferredWidth(100);
        col[6] = residentsTable.getColumnModel().getColumn(7);
        col[6].setPreferredWidth(30);
        col[6] = residentsTable.getColumnModel().getColumn(8);
        col[6].setPreferredWidth(90);
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
                    column.add(r.getResId());
                    column.add(r.getResFirstname());
                    column.add(r.getResLastname());
                    column.add(r.getResMidname());
                    column.add(r.getResPurok());
                    column.add(r.getResbrgyID());
                    column.add(r.getResBarangay());
                    column.add(r.getResGender());
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

    public void updateData() {

        String resID = res_ID.getText();
        String fname = firstname.getText();
        String lname = lastname.getText();
        String middlename = midname.getText();
        String brgyid = brgyID.getText();
        String prk = purok.getText();
        String brgyName = brgy.getText();
        String health = healthCond.getSelectedItem().toString();
        String gend = gendField.getText();

        try {
            String sql = "SELECT * from barangay WHERE bar_BrgyID = \"" + brgyid + "\" and bar_BrgyName= \"" + brgyName + "\"";
            ResultSet rs = Query(sql);

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Unknown Barangay.", "UNREGISTERED BARANGAY!", JOptionPane.INFORMATION_MESSAGE);
                brgy.requestFocus();
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        if (gendField.getText().equalsIgnoreCase("male") && healthCond.getSelectedItem().equals("PREGNANT")) {
            JOptionPane.showMessageDialog(null, "MALE WON'T GET PREGNANT", "INVALID INPUT", JOptionPane.WARNING_MESSAGE);
            healthCond.setSelectedIndex(0);
        } else {
            updateMethod2();
        }

    }
    
    public void sortTable(){
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(tablemodel);
        residentsTable.setRowSorter(sorter);
    }

    public void updateMethod2() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("e-Profiling_SystemPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            try {

                int barangayId = Integer.parseInt(brgyID.getText().trim());
                int id = Integer.parseInt(res_ID.getText().trim());

                if (em.find(Resident.class, id) != null) {
                    Resident res = em.find(Resident.class, id);

                    res.setResId(id);
                    res.setResFirstname(firstname.getText().trim());
                    res.setResLastname(lastname.getText().trim());
                    res.setResMidname(midname.getText().trim());
                    res.setResPurok(purok.getText().trim());
                    res.setResbrgyID(barangayId);
                    res.setResBarangay(brgy.getText().trim());
                    res.setResHealthCond(healthCond.getSelectedItem().toString().trim());
                    em.merge(res);
                    em.getTransaction().commit();
                    JOptionPane.showMessageDialog(null, "DATA SUCCESSFULL UPDATED!", "ATTENTION!",
                            JOptionPane.INFORMATION_MESSAGE);
                    getTableData();
                    res_ID.setText(null);
                    firstname.setText("");
                    lastname.setText("");
                    midname.setText("");
                    purok.setText(null);
                    brgyID.setText(null);
                    brgy.setText(null);
                    healthCond.setSelectedIndex(0);
                    lblImage.setText(null);
                    lblImage.setIcon(null);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        residentsTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        midname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        purok = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        brgy = new javax.swing.JTextField();
        healthCond = new javax.swing.JComboBox<>();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        brgyID = new javax.swing.JTextField();
        lblDaw = new javax.swing.JLabel();
        res_ID = new javax.swing.JLabel();
        gendField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Community e-Profilling System");
        setMaximumSize(new java.awt.Dimension(1094, 780));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 120, 110));

        residentsTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        residentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Firstname", "Lastname", "Middlename", "Purok", "Barangay", "Health Condition"
            }
        ));
        residentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                residentsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(residentsTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 790, 660));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("FIRSTNAME");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 30));

        firstname.setEditable(false);
        firstname.setBackground(new java.awt.Color(231, 231, 231));
        firstname.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        firstname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        firstname.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });
        getContentPane().add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 140, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("LASTNAME");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 30));

        lastname.setEditable(false);
        lastname.setBackground(new java.awt.Color(231, 231, 231));
        lastname.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lastname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lastname.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        getContentPane().add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 140, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("MIDDLENAME");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 30));

        midname.setEditable(false);
        midname.setBackground(new java.awt.Color(231, 231, 231));
        midname.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        midname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        midname.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        midname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midnameActionPerformed(evt);
            }
        });
        getContentPane().add(midname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 140, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("PUROK");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, 30));

        purok.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        purok.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        purok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                purokKeyReleased(evt);
            }
        });
        getContentPane().add(purok, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 140, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("BARANGAY");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("HEALTH CONDITION");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, 30));

        brgy.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        brgy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        brgy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brgyActionPerformed(evt);
            }
        });
        brgy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                brgyKeyReleased(evt);
            }
        });
        getContentPane().add(brgy, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 140, 30));

        healthCond.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        healthCond.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECT-", "HEALTHY", "PRE-EXISTING CONDITION", "CHRONIC ILLNESS", "PREGNANT", "PERMANENTLY DISABLED" }));
        healthCond.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(healthCond, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 150, 30));

        saveBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Save_48px.png"))); // NOI18N
        saveBtn.setText("SAVE");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        getContentPane().add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 160, -1));

        cancelBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cancelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Delete_48px.png"))); // NOI18N
        cancelBtn.setText("CANCEL");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        getContentPane().add(cancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 590, 160, 50));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("BARANGAY ID");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, 30));

        brgyID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        brgyID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                brgyIDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                brgyIDKeyTyped(evt);
            }
        });
        getContentPane().add(brgyID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 140, 30));

        lblDaw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/e/profiling/system/LOAR.jpg"))); // NOI18N
        lblDaw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblDaw, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, -1));

        res_ID.setText("jLabel1");
        getContentPane().add(res_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 690, 70, -1));

        gendField.setText("jTextField1");
        getContentPane().add(gendField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 710, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void midnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_midnameActionPerformed

    private void brgyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brgyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brgyActionPerformed

    private void residentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_residentsTableMouseClicked

    }//GEN-LAST:event_residentsTableMouseClicked

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Do you WISH to accept CHANGES?", "Community e-Profiling System",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (firstname.getText().isEmpty() || lastname.getText().isEmpty() || midname.getText().isEmpty() || purok.getText().isEmpty() || brgy.getText().isEmpty()
                || healthCond.getSelectedItem().equals("-SELECT-") || brgyID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Some FIELDS are EMPTY!", "Comunity e-Profiling System", JOptionPane.WARNING_MESSAGE);
        } else if (reply == JOptionPane.YES_OPTION) {
            updateData();
        } else {

        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        clear();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void purokKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_purokKeyReleased
        purok.setText(purok.getText().toUpperCase());
    }//GEN-LAST:event_purokKeyReleased

    private void brgyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brgyKeyReleased
        brgy.setText(brgy.getText().toUpperCase());
    }//GEN-LAST:event_brgyKeyReleased

    private void brgyIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brgyIDKeyReleased
        
    }//GEN-LAST:event_brgyIDKeyReleased

    private void brgyIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brgyIDKeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_brgyIDKeyTyped

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
//            java.util.logging.Logger.getLogger(ListOfAllResidents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ListOfAllResidents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ListOfAllResidents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ListOfAllResidents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ListOfAllResidents().setVisible(true);
//            }
//        });
//    }
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    }


    public void clear() {
        lblDaw.setText(null);
        lblImage.setText(null);
        lblImage.setIcon(null);
        firstname.setText(null);
        lastname.setText(null);
        midname.setText(null);
        purok.setText(null);
        brgyID.setText(null);
        brgy.setText(null);
        healthCond.setSelectedIndex(0);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField brgy;
    private javax.swing.JTextField brgyID;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField firstname;
    private javax.swing.JTextField gendField;
    private javax.swing.JComboBox<String> healthCond;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastname;
    private javax.swing.JLabel lblDaw;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTextField midname;
    private javax.swing.JTextField purok;
    private javax.swing.JLabel res_ID;
    private javax.swing.JTable residentsTable;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
public void searchImage() {
        String search = firstname.getText();
        String search2 = lastname.getText();
        String search3 = midname.getText();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rcceps", "root", "");
            String sql = "SELECT `res_image` FROM `resident` WHERE res_firstname = '" + search + "' and res_lastname = '" + search2 + "' and res_midname = '" + search3 + "'";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                byte[] image = rs.getBytes("res_image");
                ImageIcon image1 = new ImageIcon(image);
                Image mm = image1.getImage();
                Image img = mm.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image2 = new ImageIcon(img);
                lblImage.setIcon(image2);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
