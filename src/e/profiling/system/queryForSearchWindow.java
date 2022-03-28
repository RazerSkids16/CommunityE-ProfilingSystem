package e.profiling.system;

import java.sql.ResultSet;
import JdbcImplementation.JDBC;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PlonGaming
 */
public class queryForSearchWindow {

    public static final String tableName = "resident";

    private String fname;
    private String lname;
    private String midName;
    private String purok;
    private int brgyID;
    private String brgy;
    private String healthCondition;

    public queryForSearchWindow(String fname, String lname, String midName, String purok, int brgyid, String brgy, String healthCondition) {
        this.fname = fname;
        this.lname = lname;
        this.midName = midName;
        this.purok = purok;
        this.brgyID = brgyid;
        this.brgy = brgy;
        this.healthCondition = healthCondition;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getPurok() {
        return purok;
    }

    public void setPurok(String purok) {
        this.purok = purok;
    }

    public String getBrgy() {
        return brgy;
    }

    public void setBrgy(String brgy) {
        this.brgy = brgy;
    }

    public int getBrgyID() {
        return brgyID;
    }

    public void setBrgyID(int brgyID) {
        this.brgyID = brgyID;
    }

    public String getHealthCondition() {
        return healthCondition;
    }

    public void setHealthCondition(String healthCondition) {
        this.healthCondition = healthCondition;
    }

    public static queryForSearchWindow getResultsByBrgy(String brgy) throws SQLException, Exception {
        String s = String.format("SELECT * FROM %s WHERE res_barangay %s", tableName, brgy);
        ResultSet rs = JDBC.Query(s);

        if (!rs.next()) {
            throw new Exception("Person with this barangay: " + brgy + " not found!");
        }
        queryForSearchWindow q = getQueryFromResult(rs);
        return q;
    }

    public static queryForSearchWindow getResultsByHealthCond(String health) throws SQLException, Exception {
        String s = String.format("SELECT * FROM %s WHERE res_HealthCond %s", tableName, health);
        ResultSet rs = JDBC.Query(s);

        if (!rs.next()) {
            throw new Exception("Person with this Health Condition: " + health + " not found!");
        }
        queryForSearchWindow q = getQueryFromResult(rs);
        return q;
    }

    public static queryForSearchWindow getResultsByBrgyAndHealth(String health, String brgy) throws SQLException, Exception {
        String s = String.format("SELECT * FROM %s WHERE res_HealthCond %s and res_HealthCond %s", tableName, health, brgy);
        ResultSet rs = JDBC.Query(s);

        if (!rs.next()) {
            throw new Exception("Person with this Health Condition: " + health + " from Barangay : " + brgy + " not found!");
        }
        queryForSearchWindow q = getQueryFromResult(rs);
        return q;
    }

    public static ArrayList<queryForSearchWindow> executeQueryByBrgy(String value1) throws SQLException {
        ArrayList<queryForSearchWindow> stud = new ArrayList<>();
        String db = String.format("SELECT * from %s WHERE res_barangay LIKE \"%%%%%s%%%%\" ORDER BY res_lastname", tableName, value1);

        ResultSet res = JDBC.Query(db);

        int i = 0;

        while (res.next()) {
            System.out.print("Query Found");
            queryForSearchWindow info = getQueryFromResult(res);
            System.out.println(info);
            stud.add(info);
            i++;
        }
        if (i < 1) {
            JOptionPane.showMessageDialog(null, "No BARANGAY Found!", "ERROR 404", JOptionPane.ERROR_MESSAGE);
            String q = "SELECT * FROM rcceps.resident";

            ResultSet query = JDBC.Query(q);

            while (query.next()) {
                System.out.println("Found!");
                queryForSearchWindow t = getQueryFromResult(query);
                System.out.println(t);
                stud.add(t);
            }
            return stud;
        }
        return stud;

    }

    public static ArrayList<queryForSearchWindow> executeQueryByBrgyAndHealth(String value1, String val2) throws SQLException {
        ArrayList<queryForSearchWindow> stud = new ArrayList<>();
        String db = String.format("SELECT * FROM %s WHERE res_barangay LIKE \"%%%%%s%%%%\" and res_HealthCond LIKE \"%%%%%s%%%%\" ORDER BY res_lastname", tableName, value1, val2);

        ResultSet res = JDBC.Query(db);

        int i = 0;
        while (res.next()) {
            System.out.print("Query Found");
            queryForSearchWindow info = getQueryFromResult(res);
            System.out.println(info);
            stud.add(info);
            i++;
        }

        if (i < 1) {
            JOptionPane.showMessageDialog(null, "No RECORD Found for BARANGAY and HEALTH CONDITION!", "ERROR 404", JOptionPane.ERROR_MESSAGE);
            String q = "SELECT * FROM rcceps.resident";

            ResultSet query = JDBC.Query(q);

            while (query.next()) {
                System.out.println("Found!");
                queryForSearchWindow t = getQueryFromResult(query);
                System.out.println(t);
                stud.add(t);
            }
            return stud;
        }
        return stud;
    }

    public static ArrayList<queryForSearchWindow> executeQueryByHealthCond(String value1) throws SQLException {
        ArrayList<queryForSearchWindow> stud = new ArrayList<>();
        String db = "SELECT * FROM rcceps.resident where res_HealthCond = '" + value1 + "' ORDER BY res_lastname;";

        ResultSet res = JDBC.Query(db);

        int i = 0;
        while (res.next()) {
            System.out.print("Query Found");
            queryForSearchWindow info = getQueryFromResult(res);
            System.out.println(info);
            stud.add(info);
            i++;
        }

        if (i < 1) {
            JOptionPane.showMessageDialog(null, "No SUCH Health Condition Found!", "ERROR 404", JOptionPane.ERROR_MESSAGE);

            String q = "SELECT * FROM rcceps.resident";

            ResultSet query = JDBC.Query(q);

            while (query.next()) {
                System.out.println("Found!");
                queryForSearchWindow t = getQueryFromResult(query);
                System.out.println(t);
                stud.add(t);
            }
            return stud;
        }
        return stud;
    }

    public static ArrayList<queryForSearchWindow> executeQueryTable() throws SQLException {
        ArrayList<queryForSearchWindow> stud = new ArrayList<>();
        String q = "SELECT * FROM rcceps.resident ORDER BY res_lastname";

        ResultSet query = JDBC.Query(q);

        while (query.next()) {
            System.out.println("Found!");
            queryForSearchWindow t = getQueryFromResult(query);
            System.out.println(t);
            stud.add(t);
        }
        return stud;
    }

    public static queryForSearchWindow getQueryFromResult(ResultSet res) throws SQLException {
        String firstname = res.getString("res_firstname");
        String lastname = res.getString("res_lastname");
        String midname = res.getString("res_midname");
        String purok = res.getString("res_purok");
        int brgyID = res.getInt("res_brgyID");
        String brgy = res.getString("res_barangay");
        String healthCondition = res.getString("res_HealthCond");

        queryForSearchWindow q = new queryForSearchWindow(firstname, lastname, midname, purok, brgyID, brgy, healthCondition);
        return q;
    }

    public static String[][] Arraylist(ArrayList<queryForSearchWindow> ss) {
        int row = ss.size();
        int column = 7;
        String[][] size = new String[row][column];
        for (int i = 0; i < row; i++) {
            queryForSearchWindow que = ss.get(i);

            size[i][0] = que.getFname();
            size[i][1] = que.getLname();
            size[i][2] = que.getMidName();
            size[i][3] = que.getPurok();
            size[i][4] = que.getBrgyID() + "";
            size[i][5] = que.getBrgy();
            size[i][6] = que.getHealthCondition();
        }
        return size;
    }

}
