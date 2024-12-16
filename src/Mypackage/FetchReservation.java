package Mypackage;

import javax.swing.*;
import java.sql.*;

public class FetchReservation {
    Connection con;
    public void connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String username = "root";
            String passowrd = "MySQL@3421";
            String db = "Hotel";

            con = DriverManager.getConnection(url+db, username, passowrd);
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

    public void fetch_dets(int id) {
        try {
            JLabel hotel_name = new JLabel("Sun Shine Hotel");
            hotel_name.setBounds(50, 10, 200, 30);

            Statement smt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Statement smt2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Statement smt3 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Statement smtPayment = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = smt.executeQuery("SELECT *FROM customers WHERE customer_id = " + id);
            ResultSet roomRs = smt2.executeQuery("SELECT * FROM Rooms WHERE customer_id = " + id);
            ResultSet reservationRs = smt3.executeQuery("SELECT * FROM Reservation WHERE customer_id = " + id);
            ResultSet paymentRs = smtPayment.executeQuery("SELECT * FROM Payment WHERE customer_id = " + id);

            int members = 0;
            String roomType = "";

            Date reservationDate = null;
            Date checkInDate = null;
            int daysStay = 0;

            if(rs.next()) {
                while (roomRs.next() && reservationRs.next() && paymentRs.next()) {
                    //if(rs.next() && roomRs.next() && reservationRs.next() && paymentRs.next()) {
                    String firstName = rs.getString("first_name");
                    String middleName = rs.getString("middle_name");
                    String lastName = rs.getString("last_name");
                    String fullName = firstName + " " + middleName + " " + lastName;

                    String city = rs.getString("city");
                    String state = rs.getString("state");
                    String pincode = rs.getString("pincode");

                    reservationDate = reservationRs.getDate("reservation_date");
                    checkInDate = reservationRs.getDate("check_in");
                    daysStay = reservationRs.getInt("days_stay");

                    members = roomRs.getInt("members");
                    roomType = roomRs.getString("room_type");

                    int payableAmount = paymentRs.getInt("payable_amount");
                    String paymentMode = paymentRs.getString("payment_mode");

                    JLabel fullNameLabel = new JLabel("Name   :    " + fullName);
                    fullNameLabel.setBounds(10, 50, 300, 30);

                    JLabel cityLabel = new JLabel("City  :   " + city);
                    cityLabel.setBounds(10, 90, 300, 30);

                    JLabel stateLabel = new JLabel("State  :   " + state);
                    stateLabel.setBounds(10, 130, 300, 30);

                    JLabel pincodeLabel = new JLabel("Pincode  :   " + pincode);
                    pincodeLabel.setBounds(10, 170, 300, 30);

                    JLabel roomTypeLabel = new JLabel("Room Type  :   " + roomType);
                    roomTypeLabel.setBounds(10, 210, 300, 30);

                    JLabel membersLabel = new JLabel("Members  :  " + members);
                    membersLabel.setBounds(10, 250, 300, 30);

                    JLabel reservationDateLabel = new JLabel("Reservation Date  :   " + reservationDate);
                    reservationDateLabel.setBounds(10, 290, 300, 30);

                    JLabel checkInDateLabel = new JLabel("Check-in Date  :   " + checkInDate);
                    checkInDateLabel.setBounds(10, 330, 300, 30);

                    JLabel daysStayLabel = new JLabel("Days Stay  :   " + daysStay);
                    daysStayLabel.setBounds(10, 370, 300, 30);

                    JLabel payableAmountLabel = new JLabel("Payable Amount  :   " + payableAmount);
                    payableAmountLabel.setBounds(10, 410, 300, 30);

                    JLabel paymentModeLabel = new JLabel("Payment Mode  :   " + paymentMode);
                    paymentModeLabel.setBounds(10, 450, 300, 30);

                    JFrame dis = new JFrame();
                    dis.setSize(400, 700);
                    dis.setLayout(null);
                    dis.add(hotel_name);

                    dis.add(fullNameLabel);

                    dis.add(cityLabel);
                    dis.add(stateLabel);
                    dis.add(pincodeLabel);


                    dis.add(roomTypeLabel);
                    dis.add(membersLabel);

                    dis.add(reservationDateLabel);
                    dis.add(checkInDateLabel);
                    dis.add(daysStayLabel);

                    dis.add(payableAmountLabel);
                    dis.add(paymentModeLabel);

                    dis.setVisible(true);
                }
            }

            else {
                JOptionPane.showMessageDialog(null, "User not found, Try Again");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
