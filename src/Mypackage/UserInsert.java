package Mypackage;

import javax.swing.*;
import java.sql.*;

public class UserInsert {
    Connection con;
    public void connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String username = "root";
            String password = "MySQL@3421";
            String db = "Hotel";

            con = DriverManager.getConnection(url+db, username, password);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void disconnect() {
        try {
            if(con != null && !con.isClosed())
                con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertUser(String firstname, String middlename, String lastname, String city, String state, String pincde, String email, String password, long cnt1, long cnt2) {
        try {
            //String sql = "INSERT INTO customers_demo (first_name, middle_name, last_name, city, state, pincode, email, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            String sql = "INSERT INTO customers(first_name, middle_name, last_name, city, state, pincode) VALUES (?, ?, ?, ?, ?, ?)";

            //For insertion, use PreparedStatement Class(interface)
            PreparedStatement psmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //For retrival of data, use Statement Class(interface)
            Statement smt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //Insert the values into the table
            psmt.setString(1, firstname);
            psmt.setString(2, middlename);
            psmt.setString(3, lastname);
            psmt.setString(4, city);
            psmt.setString(5, state);
            psmt.setString(6, pincde);
            int affected_rows = psmt.executeUpdate();

            if(affected_rows == 0) {
                JOptionPane.showMessageDialog(null, "Data not inserted");
            }
            else {
                //JOptionPane.showMessageDialog(null, "Account Created");
                ResultSet rs = smt.executeQuery("SELECT *FROM customers");
                rs.last();
                //JOptionPane.showMessageDialog(null, "Note for future reference, Customer ID : " + rs.getInt(1));
                int cus_id = rs.getInt(1);


                String sql2 = "INSERT INTO Phone_numbers VALUES(?, ?, ?)";
                PreparedStatement psmt2 = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
                psmt2.setInt(1, cus_id);
                psmt2.setLong(2, cnt1);
                psmt2.setLong(3, cnt2);
                psmt2.executeUpdate();

                String sql3 = "INSERT INTO customers_email VALUES (?, ?, ?)";
                PreparedStatement psmt3 = con.prepareStatement(sql3);
                psmt3.setInt(1, cus_id);
                psmt3.setString(2, email);
                psmt3.setString(3, password);
                psmt3.executeUpdate();

                JOptionPane.showMessageDialog(null, "Account Created");
                JOptionPane.showMessageDialog(null, "Note for future reference, Customer ID : " + rs.getInt(1));

                //The following statement will open a page if a new user has to make a login
                //new UserNew();
            }

            //psmt.close();
        }
        catch(Exception e) {
            // System.out.println("Error 1");
            e.printStackTrace();
        }
    }
    //public  void insertPrimaryKey(int userID, int primaryKey) {

    //}
}
