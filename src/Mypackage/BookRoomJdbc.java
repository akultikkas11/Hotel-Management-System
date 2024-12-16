package Mypackage;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.time.LocalDate;

public class BookRoomJdbc {
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

    public void book_room(int id, int member, String type, int pay_amt, String pay_mode, String check_inn, int days_staying) {
        try{
            String sql = "INSERT INTO rooms (customer_id, members, room_type) VALUES (?, ?, ?)";
            PreparedStatement psmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            psmt.setInt(1, id);
            psmt.setInt(2, member);
            psmt.setString(3, type);
            int affected_rows1 = psmt.executeUpdate();

            String sql2 = "INSERT INTO Payment(customer_id, payable_amount, payment_mode) VALUES(?, ?, ?)";
            PreparedStatement psmt2 = con.prepareStatement(sql2);
            psmt2.setInt(1, id);
            psmt2.setInt(2, pay_amt);
            psmt2.setString(3, pay_mode);
            int afftected_rows2 = psmt2.executeUpdate();

            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            // Parse the date in the input format
            Date date = inputFormat.parse(check_inn);
            
            // Reformat the date to MySQL acceptable format (YYYY-MM-DD)
            String formattedDate = outputFormat.format(date);
            java.sql.Date checkInDate = java.sql.Date.valueOf(formattedDate);

            LocalDate today = LocalDate.now();
            java.sql.Date sqlToday = java.sql.Date.valueOf(today);

            //For insert into reservation table.....
            String sql3 = "INSERT INTO Reservation(customer_id,reservation_date ,check_in, days_stay) VALUES(?,?,?,?)";
            PreparedStatement psmt3 = con.prepareStatement(sql3);
            psmt3.setInt(1, id);
            psmt3.setDate(2, sqlToday);
            psmt3.setDate(3, checkInDate);
            psmt3.setInt(4, days_staying);
            int afftected_rows3 = psmt3.executeUpdate();

            if(affected_rows1 == 0 && afftected_rows2 == 0 && afftected_rows3 == 0) {
                JOptionPane.showMessageDialog(null, "Data not inserted");
            }
            else {
                JOptionPane.showMessageDialog(null, "Booking Confirmed");
            }

        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
