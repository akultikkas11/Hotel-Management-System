package Mypackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JFrame implements ActionListener {
    Hotel_Info h;
    ImageIcon image;
    JButton signUp, about_hotel;

    Welcome() {
        image = new ImageIcon("Hotel1.png");
        about_hotel = new JButton("About Hotel");
        about_hotel.setFocusable(false);
        about_hotel.setBounds(120, 190, 130, 60);
        about_hotel.setFont(new Font("Arial", Font.PLAIN, 15));
        about_hotel.setBackground(new Color(255, 230, 150));

        signUp = new JButton();
        signUp.setText("Welcome");
        signUp.setFocusable(false);
        signUp.setBounds(120, 120, 130, 60);
        signUp.setFont(new Font("Arial", Font.PLAIN, 15));
        signUp.setBackground(new Color(255, 230, 150));

        JLabel w_label = new JLabel("Sun Shine Hotel");
        w_label.setFont(new Font("Candara", Font.BOLD, 25));
        w_label.setBounds(100, 0, 200, 80);   //To do this we need to set layout of right panell to null

        JLabel label = new JLabel();
        label.setIcon(image);
        label.setBounds(0, 0, 100, 300);

        JPanel left_panel = new JPanel();
        left_panel.setBackground(Color.WHITE);
        left_panel.add(label);
        left_panel.setBounds(0, 0, 400, 345);

        JPanel right_panel = new JPanel();
        right_panel.setBackground(new Color(255, 255, 80));
        right_panel.setBounds(400, 0, 400, 345);
        right_panel.add(w_label);
        right_panel.setLayout(null);
        right_panel.add(signUp);
        right_panel.add(about_hotel);

        this.setVisible(true);
        this.setSize(800, 345);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(left_panel);
        this.add(right_panel);
        this.setLocationRelativeTo(null); //Center the frame after running
        signUp.addActionListener(this);
        about_hotel.addActionListener(this);

        h = new Hotel_Info();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == signUp) {
            new Registration();
            this.setVisible(false);
        }

        else if(e.getSource() == about_hotel) {
            h.connect();
            h.showDetails();
            h.disconnect();
        }
    }

    public static void main(String[] args) {
        new Welcome();
    }
}


