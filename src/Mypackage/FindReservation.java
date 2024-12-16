package Mypackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindReservation extends JFrame implements ActionListener {
    FetchReservation fdd;
    JLabel id;
    JTextField id_field;
    JButton fetch_details, back;

    FindReservation() {
        id = new JLabel("Customer id");
        id.setBounds(20, 50, 100, 30);

        id_field = new JTextField();
        id_field.setBounds(130, 50, 100, 30);

        fetch_details = new JButton("Fetch Details");
        fetch_details.setBounds(30, 100, 200, 50);
        fetch_details.addActionListener(this);
        fetch_details.setFocusable(false);

        back = new JButton("Back");
        back.addActionListener(this);
        back.setFocusable(false);
        back.setBounds(30, 170, 200, 50);

        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        this.add(id_field);
        this.add(id);
        this.add(fetch_details);
        this.add(back);

        fdd = new FetchReservation();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == fetch_details) {
            String eid = id_field.getText();
            int c_id = Integer.parseInt(eid);
            //System.out.println(c_id);

            try{
                fdd.connect();
                fdd.fetch_dets(c_id);
                fdd.disconnect();
            }
            catch (Exception e2) {
                System.out.println(e2);
            }
        }

        else if(e.getSource() == back) {
            this.setVisible(false);
            new User();
        }
    }
}
