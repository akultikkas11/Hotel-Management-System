package Mypackage;

import javax.swing.*;
import java.sql.*;
public class UserValidateLogin {
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

    public int validate(int id, String mail, String pas) {
        int valid = 1;
        try {
            int table_id;
            String table_mail, table_pas;
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("SELECT *FROM customers_email WHERE customer_id = " + id);

            //f rs.next() returns true, it means there is at least one row in the result set where
            // the customer_id matches the provided num.
            // The cursor will move to the first row that satisfies the condition.
            if(rs.next()) {
                table_mail = rs.getString(2);
                table_pas = rs.getString(3);

                if((table_mail.compareTo(mail) == 0) && (table_pas.compareTo(pas) == 0)) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Login Failed due to wrong credentials, Try again");
                    return 0;
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "User not found, Try Again");
                return 0;
            }


            //table_mail = rs.getString()
            //if()
        }
        catch (Exception e) {
            System.out.println("Error 1");
        }
        return valid;

    }
}

