package Mypackage;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Hotel_Info extends JFrame {

    Connection con;

    public void connect() {
        try {
            // Class.forName("oracle.jdbc.driver.OracleDriver");
            // con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "dbmssql");
            
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
            if (con != null && !con.isClosed())
                con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void showDetails() {
        try {
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("SELECT * FROM Hotel");

            // Set frame layout to null
            this.setLayout(null);

            // Create a panel to hold the hotel information
            JPanel hotelPanel = new JPanel();
            hotelPanel.setLayout(null); // Null layout
            hotelPanel.setBounds(20, 20, 400, 200); // Set bounds

            // Iterate through the result set and create JLabels for each column
            int yPosition = 20; // Initial y position
            while (rs.next()) {
                JLabel nameLabel = new JLabel("Hotel Name:");
                nameLabel.setBounds(20, yPosition, 100, 20);
                JLabel nameValue = new JLabel(rs.getString("hotel_name"));
                nameValue.setBounds(130, yPosition, 200, 20);

                JLabel idLabel = new JLabel("Hotel ID:");
                idLabel.setBounds(20, yPosition + 30, 100, 20);
                JLabel idValue = new JLabel(rs.getString("hotel_id"));
                idValue.setBounds(130, yPosition + 30, 200, 20);

                JLabel pincodeLabel = new JLabel("Pincode:");
                pincodeLabel.setBounds(20, yPosition + 60, 100, 20);
                JLabel pincodeValue = new JLabel(rs.getString("hotel_pincode"));
                pincodeValue.setBounds(130, yPosition + 60, 200, 20);

                // Add labels to the panel
                hotelPanel.add(nameLabel);
                hotelPanel.add(nameValue);
                hotelPanel.add(idLabel);
                hotelPanel.add(idValue);
                hotelPanel.add(pincodeLabel);
                hotelPanel.add(pincodeValue);

//                yPosition += 90; // Increment y position
//                JLabel descriptionValue = new JLabel("Welcome to OurHotel! OurHotel is a cozy retreat nestled in the heart of the city. With comfortable rooms, modern amenities, and exceptional service, we strive to make your stay memorable. Whether you're here for business or leisure, OurHotel offers the perfect blend of comfort and convenience. Explore the city's attractions, indulge in delicious cuisine at our on-site restaurant, or simply unwind in the serene ambiance of your room. Your comfort is our priority at OurHotel.");
//                descriptionValue.setBounds(130, 250, 300, 20);
//
//                // Add labels to the frame
//                //this.add(descriptionLabel);
//                hotelPanel.add(descriptionValue);

            }

            // Add panel to the frame
            this.add(hotelPanel);

            // Create a label for short hotel description
//            JLabel descriptionLabel = new JLabel("Short Description:");
//            descriptionLabel.setBounds(20, 250, 100, 20);
//            JLabel descriptionValue = new JLabel("Welcome to OurHotel! OurHotel is a cozy retreat nestled in the heart of the city. With comfortable rooms, modern amenities, and exceptional service, we strive to make your stay memorable. Whether you're here for business or leisure, OurHotel offers the perfect blend of comfort and convenience. Explore the city's attractions, indulge in delicious cuisine at our on-site restaurant, or simply unwind in the serene ambiance of your room. Your comfort is our priority at OurHotel.");
//            descriptionValue.setBounds(130, 250, 300, 20);
//
//            // Add labels to the frame
//            this.add(descriptionLabel);
//            this.add(descriptionValue);

            this.setVisible(true);
            this.setSize(500, 300);
            this.setLocationRelativeTo(null); // Center the frame
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
