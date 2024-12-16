package Mypackage;
import javax.swing.*;
import java.sql.*;

public class FetchDetails {
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

    public void fetch(int id_cus) {
        try {
            Statement smt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Statement smt2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Statement smt3 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Statement smt4 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Statement smt5 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Statement smt6 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = smt.executeQuery("SELECT *FROM customers WHERE customer_id = " + id_cus);
            ResultSet phoneRs = smt2.executeQuery("SELECT * FROM Phone_Numbers WHERE customer_id = " + id_cus);
            ResultSet roomRs = smt3.executeQuery("SELECT * FROM Rooms WHERE customer_id = " + id_cus);
            ResultSet reservationRs = smt4.executeQuery("SELECT * FROM Reservation WHERE customer_id = " + id_cus);
            ResultSet paymentRs = smt5.executeQuery("SELECT * FROM Payment WHERE customer_id = " + id_cus);
            ResultSet mail = smt6.executeQuery("SELECT *FROM customers_email WHERE customer_id = " + id_cus);

            long number1 = 0;
            long number2 = 0;

            int members = 0;
            String roomType = "";

            Date reservationDate = null;
            Date checkInDate = null;
            int daysStay = 0;

            double payableAmount = 0;
            String paymentMode = "";

            if(rs.next() && phoneRs.next() && roomRs.next() && reservationRs.next() && paymentRs.next() && mail.next()) {
                String name = rs.getString("first_name");
                String mname = rs.getString("middle_name");
                String lname = rs.getString("last_name");
                String state = rs.getString("state");
                String pincode = rs.getString("pincode");
                String city = rs.getString("city");
                String email = mail.getString("email");
                String password = mail.getString("password");

                number1 = phoneRs.getLong("number1");
                number2 = phoneRs.getLong("number2");

                members = roomRs.getInt("members");
                roomType = roomRs.getString("room_type");

                reservationDate = reservationRs.getDate("reservation_date");
                checkInDate = reservationRs.getDate("check_in");
                daysStay = reservationRs.getInt("days_stay");

                payableAmount = paymentRs.getDouble("payable_amount");
                paymentMode = paymentRs.getString("payment_mode");

                JLabel name1 = new JLabel("First Name : ");
                name1.setBounds(10, 10, 80, 30);
                JLabel naam = new JLabel(name);
                naam.setBounds(90, 10, 100, 30);

                JLabel name2 = new JLabel("Middle Name : ");
                name2.setBounds(10, 42, 90, 30);
                JLabel mnaam = new JLabel(mname);
                mnaam.setBounds(100, 42, 100, 30);

                JLabel name3 = new JLabel("Last Name : ");
                name3.setBounds(10, 74, 90, 30);
                JLabel lnaam = new JLabel(lname);
                lnaam.setBounds(100, 74, 90, 30);

                JLabel stateLabel = new JLabel("State : ");
                stateLabel.setBounds(10, 106, 90, 30);
                JLabel stateText = new JLabel(state);
                stateText.setBounds(100, 106, 100, 30);

                JLabel pincodeLabel = new JLabel("Pincode : ");
                pincodeLabel.setBounds(10, 138, 90, 30);
                JLabel pincodeText = new JLabel(pincode);
                pincodeText.setBounds(100, 138, 100, 30);

                JLabel cityLabel = new JLabel("City : ");
                cityLabel.setBounds(10, 170, 90, 30);
                JLabel cityText = new JLabel(city);
                cityText.setBounds(100, 170, 100, 30);

                JLabel emailLabel = new JLabel("Email : ");
                emailLabel.setBounds(10, 202, 90, 30);
                JLabel emailText = new JLabel(email);
                emailText.setBounds(100, 202, 100, 30);

                JLabel passwordLabel = new JLabel("Password : ");
                passwordLabel.setBounds(10, 234, 90, 30);
                JLabel passwordText = new JLabel(password);
                passwordText.setBounds(100, 234, 100, 30);

                JLabel number1Label = new JLabel("Number 1 : ");
                number1Label.setBounds(10, 266, 90, 30);
                JLabel number1Text = new JLabel(String.valueOf(number1));
                number1Text.setBounds(100, 266, 100, 30);

                JLabel number2Label = new JLabel("Number 2 : ");
                number2Label.setBounds(10, 298, 90, 30);
                JLabel number2Text = new JLabel(String.valueOf(number2));
                number2Text.setBounds(100, 298, 100, 30);

                JLabel roomTypeLabel = new JLabel("Room Type : ");
                roomTypeLabel.setBounds(10, 330, 90, 30);
                JLabel roomTypeText = new JLabel(roomType);
                roomTypeText.setBounds(100, 330, 100, 30);

                JLabel membersLabel = new JLabel("No of Members : ");
                membersLabel.setBounds(10, 362, 100, 30);
                JLabel membersText = new JLabel(String.valueOf(members));
                membersText.setBounds(120, 362, 100, 30);

                JLabel reservationDateLabel = new JLabel("Reservation Date : ");
                reservationDateLabel.setBounds(10, 394, 130, 30);
                JLabel reservationDateText = new JLabel(String.valueOf(reservationDate));
                reservationDateText.setBounds(150, 394, 140, 30);

                JLabel checkInDateLabel = new JLabel("Check-in Date : ");
                checkInDateLabel.setBounds(10, 426, 130, 30);
                JLabel checkInDateText = new JLabel(String.valueOf(checkInDate));
                checkInDateText.setBounds(150, 426, 140, 30);

                JLabel daysStayLabel = new JLabel("Days Stay : ");
                daysStayLabel.setBounds(10, 458, 130, 30);
                JLabel daysStayText = new JLabel(String.valueOf(daysStay));
                daysStayText.setBounds(150, 458, 140, 30);

                JLabel payableAmountLabel = new JLabel("Payable Amount : ");
                payableAmountLabel.setBounds(10, 490, 130, 30);
                JLabel payableAmountText = new JLabel(String.valueOf(payableAmount));
                payableAmountText.setBounds(150, 490, 140, 30);

                JLabel paymentModeLabel = new JLabel("Payment Mode : ");
                paymentModeLabel.setBounds(10, 522, 130, 30);
                JLabel paymentModeText = new JLabel(paymentMode);
                paymentModeText.setBounds(150, 522, 140, 30);

                //System.out.println(rs.getString("first_name"));

                JFrame dis = new JFrame();
                dis.setSize(300, 750);
                dis.setVisible(true);
                dis.setLayout(null);
                dis.add(name1);
                dis.add(naam);
                dis.add(name2);
                dis.add(mnaam);
                dis.add(name3);
                dis.add(lnaam);
                dis.add(stateLabel);
                dis.add(stateText);
                dis.add(pincodeLabel);
                dis.add(pincodeText);
                dis.add(cityLabel);
                dis.add(cityText);
                dis.add(emailLabel);
                dis.add(emailText);
                dis.add(passwordLabel);
                dis.add(passwordText);

                dis.add(number1Label);
                dis.add(number1Text);
                dis.add(number2Label);
                dis.add(number2Text);

                dis.add(membersLabel);
                dis.add(membersText);
                dis.add(roomTypeLabel);
                dis.add(roomTypeText);

                dis.add(reservationDateLabel);
                dis.add(reservationDateText);
                dis.add(checkInDateLabel);
                dis.add(checkInDateText);
                dis.add(daysStayLabel);
                dis.add(daysStayText);

                dis.add(payableAmountLabel);
                dis.add(payableAmountText);
                dis.add(paymentModeLabel);
                dis.add(paymentModeText);
            }
            else{
                JOptionPane.showMessageDialog(null, "Customer not found");
                // System.out.println("not found");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
