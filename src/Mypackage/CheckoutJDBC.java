package Mypackage;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CheckoutJDBC {
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

    public void Checkk_out(int idd) {
        try {
            Statement smt = con.createStatement();
            Statement smt5 = con.createStatement();
            Statement smt2 = con.createStatement();
            Statement smt3 = con.createStatement();
            Statement smt4 = con.createStatement();
            Statement smt6 = con.createStatement();
            Statement smt7 = con.createStatement();

            int count5 = smt5.executeUpdate("DELETE FROM Phone_Numbers WHERE customer_id = " + idd);
            int count4 = smt4.executeUpdate("DELETE FROM Reservation WHERE customer_id = " + idd);
            int count3 = smt3.executeUpdate("DELETE FROM Payment WHERE customer_id =" + idd);
            int count2 = smt2.executeUpdate("DELETE FROM Rooms WHERE customer_id = " + idd);
            int count6 = smt6.executeUpdate("DELETE FROM customers_email WHERE customer_id = " +idd);
            int count7 = smt7.executeUpdate("DELETE FROM customers WHERE customer_id = "+ idd);
            
            
            if(count2 > 0 && count3 > 0 && count4 > 0 && count5 > 0 && count6 > 0 && count7 > 0) {
                JOptionPane.showMessageDialog(null, "Check-out Successfully");
            }
            else{
                JOptionPane.showMessageDialog(null, "no check out");
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
