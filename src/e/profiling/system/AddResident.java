/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.profiling.system;

import JpaImplementation.Barangay;
import JpaImplementation.Resident;
import com.sun.glass.events.KeyEvent;
import static e.profiling.system.AddBarangay.Query;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author PlonGaming
 */
public class AddResident extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddResident
     */
    public AddResident() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fnameField = new javax.swing.JTextField();
        lnameField = new javax.swing.JTextField();
        midField = new javax.swing.JTextField();
        purokField = new javax.swing.JTextField();
        barangayField = new javax.swing.JTextField();
        healthConditionBox = new javax.swing.JComboBox<>();
        residentImage = new javax.swing.JLabel();
        chooseBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        submitBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        brgyIDField = new javax.swing.JTextField();
        genderBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Community e-Profiling System");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/e/profiling/system/logo.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(775, 613));
        setMinimumSize(new java.awt.Dimension(775, 613));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setText("FIRSTNAME");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setText("LASTNAME");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setText("MIDDLE NAME");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setText("BARANGAY");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setText("PUROK");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel8.setText("HEALTH CONDITION");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, -1, 40));

        fnameField.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        fnameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fnameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fnameFieldKeyReleased(evt);
            }
        });
        getContentPane().add(fnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 270, 40));

        lnameField.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lnameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameFieldActionPerformed(evt);
            }
        });
        lnameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lnameFieldKeyReleased(evt);
            }
        });
        getContentPane().add(lnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 270, 40));

        midField.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        midField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        midField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                midFieldKeyReleased(evt);
            }
        });
        getContentPane().add(midField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 270, 40));

        purokField.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        purokField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        purokField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                purokFieldKeyReleased(evt);
            }
        });
        getContentPane().add(purokField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 270, 40));

        barangayField.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        barangayField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        barangayField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                barangayFieldKeyReleased(evt);
            }
        });
        getContentPane().add(barangayField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 270, 40));

        healthConditionBox.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        healthConditionBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECT-", "HEALTHY", "PRE-EXISTING CONDITION", "CHRONIC ILLNESS", "PREGNANT", "PERMANENTLY DISABLED" }));
        healthConditionBox.setToolTipText("");
        healthConditionBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(healthConditionBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 270, 40));

        residentImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(residentImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 170, 170));

        chooseBtn.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        chooseBtn.setText("Choose file...");
        chooseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseBtnActionPerformed(evt);
            }
        });
        getContentPane().add(chooseBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 120, 30));

        clearBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        clearBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Delete_48px.png"))); // NOI18N
        clearBtn.setText("CLEAR");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        getContentPane().add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, 150, 40));

        submitBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        submitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Save_48px.png"))); // NOI18N
        submitBtn.setText("SUBMIT");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(submitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, 150, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel10.setText("GENDER");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel12.setText("BARANGAY ID");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, 40));

        brgyIDField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        brgyIDField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                brgyIDFieldKeyTyped(evt);
            }
        });
        getContentPane().add(brgyIDField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 270, 40));

        genderBox.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        genderBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECT-", "MALE", "FEMALE", "LGBTQ+" }));
        genderBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(genderBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 270, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/e/profiling/system/add.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameFieldActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        clearFields();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void fnameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnameFieldKeyReleased
        fnameField.setText(fnameField.getText().toUpperCase());
    }//GEN-LAST:event_fnameFieldKeyReleased

    private void lnameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnameFieldKeyReleased
        lnameField.setText(lnameField.getText().toUpperCase());
    }//GEN-LAST:event_lnameFieldKeyReleased

    private void midFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_midFieldKeyReleased
        midField.setText(midField.getText().toUpperCase());
    }//GEN-LAST:event_midFieldKeyReleased

    private void purokFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_purokFieldKeyReleased
        purokField.setText(purokField.getText().toUpperCase());
    }//GEN-LAST:event_purokFieldKeyReleased

    private void barangayFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barangayFieldKeyReleased
        barangayField.setText(barangayField.getText().toUpperCase());
    }//GEN-LAST:event_barangayFieldKeyReleased

    private void chooseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseBtnActionPerformed
        getImage();
    }//GEN-LAST:event_chooseBtnActionPerformed

    private void brgyIDFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brgyIDFieldKeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACKSPACE || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_brgyIDFieldKeyTyped

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        String fname = fnameField.getText();
        String lname = lnameField.getText();
        String midName = midField.getText();
        String gend = genderBox.getSelectedItem().toString();
        String purok = purokField.getText();
        String brgy = barangayField.getText();
        String healthCond = healthConditionBox.getSelectedItem().toString();
        String img = residentImage.getText();

        int reply = JOptionPane.showConfirmDialog(null, "Continue to SAVE?", "Community e-Profiling System",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (reply == JOptionPane.YES_OPTION) {
            if (fname.isEmpty() || lname.isEmpty() || midName.isEmpty() || gend.equalsIgnoreCase("-SELECT-") || purok.isEmpty()
                    || brgyIDField.getText().isEmpty() || brgy.isEmpty() || healthCond.equalsIgnoreCase("-SELECT-")) {
                JOptionPane.showMessageDialog(null, "Some FIELDS are EMPTY\nFill them up to CONTINUE.", "Community e-Profiling System", JOptionPane.WARNING_MESSAGE);
                fnameField.requestFocus();
            } else if (img.getBytes().toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Some FIELDS are EMPTY\nFill them up to CONTINUE.", "Community e-Profiling System", JOptionPane.WARNING_MESSAGE);
            } else if (gend.equalsIgnoreCase("MALE") && healthCond.equalsIgnoreCase("PREGNANT")) {
                JOptionPane.showMessageDialog(null, "MALE WON'T GET PREGNANT", "INVALID INPUT", JOptionPane.WARNING_MESSAGE);
            } else {
                addRes();
            }

        } else {

        }
    }//GEN-LAST:event_submitBtnActionPerformed

    public void clearFields() {

        int reply = JOptionPane.showConfirmDialog(null, "Clear entry fields?", "Community e-Profiling System",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (reply == JOptionPane.YES_OPTION) {
            barangayField.setText(null);
            fnameField.setText(null);
            lnameField.setText(null);
            genderBox.setSelectedIndex(0);
            midField.setText(null);
            purokField.setText(null);
            healthConditionBox.setSelectedIndex(0);
            brgyIDField.setText(null);
            residentImage.setIcon(null);
            residentImage.setText(null);
        } else {

        }
    }
    byte[] photo = null;

    public void getImage() {
        try {

            String filename = null;
            JFileChooser choose = new JFileChooser();
            choose.showOpenDialog(null);
            File f = choose.getSelectedFile();
            residentImage.setIcon(new ImageIcon(f.toString()));
            filename = f.getAbsolutePath();
            residentImage.setText(filename);

            try {
                File image = new File(filename);
                FileInputStream fis = new FileInputStream(image);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readNum);
                }
                photo = bos.toByteArray();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (Exception e) {

        }
    }

    public void addRes() {

        String fname = fnameField.getText();
        String lname = lnameField.getText();
        String midName = midField.getText();
        String gend = genderBox.getSelectedItem().toString();
        String purok = purokField.getText();
        int brgyID = new Integer(brgyIDField.getText());
        String brgy = barangayField.getText();
        String healthCond = healthConditionBox.getSelectedItem().toString();
        String img = residentImage.getText();

        try {
            String sql = "SELECT * from resident WHERE res_firstname = \"" + fname + "\" and res_lastname = \"" + lname + "\" and res_midname = \"" + midName + "\""
                    + "and res_gender = \"" + gend + "\" and res_purok = \"" + purok + "\" and res_brgyID = \"" + brgyID + "\" and res_barangay = \"" + brgy + "\""
                    + "and res_HealthCond = \"" + healthCond + "\"";
            ResultSet rs = Query(sql);

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "RESIDENT already EXIST!\nIF you want to CHANGE the address,\nGO-TO LIST OF ALL RESIDENTS MENU.", "DUPLICATION!", JOptionPane.INFORMATION_MESSAGE);
                barangayField.setText(null);
                fnameField.setText(null);
                lnameField.setText(null);
                genderBox.setSelectedIndex(0);
                midField.setText(null);
                purokField.setText(null);
                healthConditionBox.setSelectedIndex(0);
                brgyIDField.setText(null);
                residentImage.setIcon(null);
                residentImage.setText(null);
                brgyIDField.requestFocus();
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        try {
            String sql = "SELECT * from barangay WHERE bar_BrgyID= \"" + brgyID + "\" and bar_BrgyName = \"" + brgy + "\"";
            ResultSet rs = Query(sql);

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Unknown Barangay.", "UNREGISTERED BARANGAY!", JOptionPane.INFORMATION_MESSAGE);
                brgyIDField.requestFocus();
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        try {
            String sql = "SELECT * from barangay WHERE bar_BrgyID = \"" + brgyID + "\" or bar_BrgyName = \"" + brgy + "\"";
            ResultSet rs = Query(sql);

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "INVALID BARANGAY ENTRIES!", "UNKNOWN!", JOptionPane.INFORMATION_MESSAGE);
                brgyIDField.requestFocus();
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        try {
            String sql = "SELECT * from resident WHERE res_firstname = \"" + fname + "\" and res_lastname = \"" + lname + "\" and res_midname = \"" + midName + "\" and res_brgyID = \"" + brgyID + "\" and res_barangay = \"" + brgy + "\"";
            ResultSet rs = Query(sql);

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "RESIDENT already EXIST in a BARANGAY.\nIf you want to CHANGE the address,\nGO-TO LIST OF "
                        + "ALL RESIDENTS MENU!", "UNREGISTERED BARANGAY!", JOptionPane.INFORMATION_MESSAGE);
                barangayField.setText(null);
                fnameField.setText(null);
                lnameField.setText(null);
                midField.setText(null);
                purokField.setText(null);
                healthConditionBox.setSelectedIndex(0);
                brgyIDField.setText(null);
                residentImage.setIcon(null);
                residentImage.setText(null);
                brgyIDField.requestFocus();
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        if (img.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please make sure to ADD an IMAGE\nto IDENTIFY the PERSON!", "Communty e-Profiling System", JOptionPane.WARNING_MESSAGE);
        } else if (gend.equalsIgnoreCase("MALE") && healthCond.equalsIgnoreCase("PREGNANT")) {
            JOptionPane.showMessageDialog(null, "MALE PERSON WON'T GET PREGNANT!", "INVALID ENTRY!", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("e-Profiling_SystemPU");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                Resident res = new Resident();

                try {
                    res.setResFirstname(fname);
                    res.setResLastname(lname);
                    res.setResMidname(midName);
                    res.setResGender(gend);
                    res.setResPurok(purok);
                    res.setResbrgyID(brgyID);
                    res.setResBarangay(brgy);
                    res.setResHealthCond(healthCond);
                    res.setResImage(photo);

                    em.persist(res);
                    em.getTransaction().commit();
                    JOptionPane.showMessageDialog(null, "RESIDENT Successfully ADDED!", "Community e-Profiling System", JOptionPane.INFORMATION_MESSAGE);

                    barangayField.setText(null);
                    fnameField.setText(null);
                    lnameField.setText(null);
                    genderBox.setSelectedIndex(0);
                    midField.setText(null);
                    purokField.setText(null);
                    healthConditionBox.setSelectedIndex(0);
                    brgyIDField.setText(null);
                    residentImage.setIcon(null);
                    residentImage.setText(null);
                    fnameField.requestFocus();
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

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barangayField;
    private javax.swing.JTextField brgyIDField;
    private javax.swing.JButton chooseBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JTextField fnameField;
    private javax.swing.JComboBox<String> genderBox;
    private javax.swing.JComboBox<String> healthConditionBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField lnameField;
    private javax.swing.JTextField midField;
    private javax.swing.JTextField purokField;
    private javax.swing.JLabel residentImage;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}
