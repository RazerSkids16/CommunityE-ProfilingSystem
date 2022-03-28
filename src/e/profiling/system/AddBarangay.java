/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.profiling.system;

import JpaImplementation.Accounts;
import JpaImplementation.Barangay;
import static e.profiling.system.CreateAccount.Query;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author PlonGaming
 */
public class AddBarangay extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddBarangay
     */
    public AddBarangay() {
        initComponents();
        setTitle("Community e-Profiling System");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        barangayField = new javax.swing.JTextField();
        cityField = new javax.swing.JTextField();
        provField = new javax.swing.JTextField();
        barCapField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        brgyIDField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Barangay");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("City/Municipality");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Province");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Barangay Captain");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, -1));

        barangayField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        barangayField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        barangayField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barangayFieldActionPerformed(evt);
            }
        });
        barangayField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                barangayFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                barangayFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                barangayFieldKeyTyped(evt);
            }
        });
        getContentPane().add(barangayField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 260, 40));

        cityField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cityField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cityField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cityFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cityFieldKeyTyped(evt);
            }
        });
        getContentPane().add(cityField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 260, 40));

        provField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        provField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        provField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                provFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                provFieldKeyTyped(evt);
            }
        });
        getContentPane().add(provField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 260, 40));

        barCapField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        barCapField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        barCapField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                barCapFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                barCapFieldKeyTyped(evt);
            }
        });
        getContentPane().add(barCapField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 260, 40));

        jButton1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Delete_48px.png"))); // NOI18N
        jButton1.setText("CLEAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 160, 50));

        jButton2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Save_48px.png"))); // NOI18N
        jButton2.setText("SUBMIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 160, 50));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Barangay ID");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, 40));

        brgyIDField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        brgyIDField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                brgyIDFieldKeyTyped(evt);
            }
        });
        getContentPane().add(brgyIDField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 260, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/e/profiling/system/addbarangay.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void barangayFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barangayFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barangayFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clearFields();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void barangayFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barangayFieldKeyReleased
        barangayField.setText(barangayField.getText().toUpperCase());
    }//GEN-LAST:event_barangayFieldKeyReleased

    private void barangayFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barangayFieldKeyPressed
        barangayField.setText(barangayField.getText().toUpperCase());
    }//GEN-LAST:event_barangayFieldKeyPressed

    private void barangayFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barangayFieldKeyTyped
        char a = evt.getKeyChar();

        if (Character.isDigit(a)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_barangayFieldKeyTyped

    private void cityFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cityFieldKeyReleased
        cityField.setText(cityField.getText().toUpperCase());
    }//GEN-LAST:event_cityFieldKeyReleased

    private void provFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_provFieldKeyReleased
        provField.setText(provField.getText().toUpperCase());
    }//GEN-LAST:event_provFieldKeyReleased

    private void barCapFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barCapFieldKeyReleased
        barCapField.setText(barCapField.getText().toUpperCase());
    }//GEN-LAST:event_barCapFieldKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String bar = barangayField.getText();
        String city = cityField.getText();
        String prov = provField.getText();
        String barCap = barCapField.getText();

        int reply = JOptionPane.showConfirmDialog(null, "Continue to SAVE?", "Community e-Profiling System",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (reply == JOptionPane.YES_OPTION) {

            if (bar.isEmpty() || city.isEmpty() || prov.isEmpty() || barCap.isEmpty() || brgyIDField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "SOME FIELDS are EMPTY.", "Community e-Profiling System", JOptionPane.WARNING_MESSAGE);
            } else {
                addBarangay();
            }
        } else {

        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void brgyIDFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brgyIDFieldKeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || c == com.sun.glass.events.KeyEvent.VK_BACKSPACE || c == com.sun.glass.events.KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_brgyIDFieldKeyTyped

    private void cityFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cityFieldKeyTyped
        char a = evt.getKeyChar();

        if (Character.isDigit(a)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_cityFieldKeyTyped

    private void provFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_provFieldKeyTyped
        char a = evt.getKeyChar();

        if (Character.isDigit(a)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_provFieldKeyTyped

    private void barCapFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barCapFieldKeyTyped
        char a = evt.getKeyChar();

        if (Character.isDigit(a)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_barCapFieldKeyTyped

    public void clearFields() {

        int reply = JOptionPane.showConfirmDialog(null, "Clear entry fields?", "Community e-Profiling System",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (reply == JOptionPane.YES_OPTION) {
            barangayField.setText(null);
            cityField.setText(null);
            provField.setText(null);
            barCapField.setText(null);
            brgyIDField.setText(null);
        } else {

        }
    }

    public void addBarangay() {

        String bar = barangayField.getText();
        String city = cityField.getText();
        String prov = provField.getText();
        String barCap = barCapField.getText();
        int brgyID = new Integer(brgyIDField.getText());

        try {
            String sql = "SELECT * from barangay WHERE bar_BrgyID = \"" + brgyID + "\" or bar_BrgyName = \"" + bar + "\"";
            ResultSet rs = Query(sql);

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Barangay Already Exists!", "DUPLICATION!", JOptionPane.INFORMATION_MESSAGE);
                brgyIDField.setText(null);
                brgyIDField.requestFocus();
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        try {
            String sql1 = "SELECT * from barangay WHERE bar_BrgyCaptain = \"" + barCap + "\"";
            ResultSet rs = Query(sql1);

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "There is a Duplication of Entry\nBarangay Captain can only HANDLE one Barangay!", "WARNING!", JOptionPane.WARNING_MESSAGE);
                barCapField.setText(null);
                barCapField.requestFocus();
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("e-Profiling_SystemPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Barangay br = new Barangay();

            try {
                br.setBarBrgyID(brgyID);
                br.setBarBrgyName(bar);
                br.setBarBrgyCaptain(barCap);
                br.setBarCity(city);
                br.setBarProvince(prov);

                em.persist(br);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Barangay has been ADDED!", "Community e-Profiling System", JOptionPane.INFORMATION_MESSAGE);

                barangayField.setText(null);
                barCapField.setText(null);
                brgyIDField.setText(null);
                cityField.setText(null);
                provField.setText(null);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                em.close();
                emf.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection Connect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/rcceps", "root", "");
            Statement st = connect.createStatement();
            return connect;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Can't Connect To Server");
        return null;
    }

    public static ResultSet Query(String query, boolean isUpdate) throws SQLException {
        Statement stmnt = Connect().createStatement();
        System.out.println("Running all queries: " + query);
        if (isUpdate) {
            stmnt.executeUpdate(query);
        } else {
            return stmnt.executeQuery(query);
        }
        stmnt.close();

        return null;

    }

    public static ResultSet Query(String query) throws SQLException {
        return Query(query, false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barCapField;
    private javax.swing.JTextField barangayField;
    private javax.swing.JTextField brgyIDField;
    private javax.swing.JTextField cityField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField provField;
    // End of variables declaration//GEN-END:variables
}
