package Mypackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Mypackage.Book_Select_Rooms.per_day_cost;
import static Mypackage.Book_Select_Rooms.type_of_room;
import static Mypackage.UserLogin.c_idd;

public class BookRoom extends JFrame implements ActionListener {

    static int mem, days_staying; //cost_per_day = 1000;
    static String check_in;
    JButton confirm_book, back_button;
    JTextField id_field, no_field, day_len_field;
    JLabel id, cusid,  no_of_customers, days_length, cost, amt, type, type_name, Booking_slot;
    JPanel left_panel, right_panel;
    String[] allowed_members = {"1", "2", "3", "4"};
    String[] dates = {"10-May-2024", "14-May-2024", "16-May-2024", "20-May-2024", "25-May-2024"};
    JComboBox date, members;

    BookRoom() {
        confirm_book = new JButton("Confirm Booking");
        confirm_book.setBounds(20, 360, 150, 50);
        confirm_book.addActionListener(this);
        confirm_book.setFocusable(false);

        back_button = new JButton("Back");
        back_button.setBounds(20, 420, 150, 50);
        back_button.addActionListener(this);
        back_button.setFocusable(false);

        Booking_slot = new JLabel("Booking slot");
        Booking_slot.setBounds(20, 260, 100, 30);
        date = new JComboBox(dates);
        date.setBounds(150, 260, 100, 30);
        date.addActionListener(this);

        cost = new JLabel("Cost per day");
        cost.setBounds(20, 210, 100, 30);

        amt = new JLabel(""+per_day_cost);
        amt.setBounds(140, 210, 100, 30);

        type = new JLabel("Type");
        type.setBounds(20, 170, 100, 30);
        type_name = new JLabel(""+type_of_room);
        type_name.setBounds(140, 170, 100, 30);

        id = new JLabel("Customer id");
        id.setBounds(20, 50, 100, 30);
        cusid = new JLabel("" + c_idd);
        cusid.setBounds(140, 50, 100, 30);

        no_of_customers = new JLabel("No. of Members");
        no_of_customers.setBounds(20, 90, 100, 30);

        days_length = new JLabel("Days length");
        days_length.setBounds(20, 130, 100, 30);

//        id_field = new JTextField(c_idd);
//        id_field.setBounds(140, 50, 100, 30);

        members = new JComboBox(allowed_members);
        members.setBounds(140, 90, 100, 30);
        members.addActionListener(this);
        //no_field = new JTextField();
        //no_field.setBounds(140, 90, 100, 30);

        day_len_field = new JTextField();
        day_len_field.setBounds(140, 130, 100, 30);

        left_panel = new JPanel();
        left_panel.setLayout(null);
        left_panel.setBounds(0, 0, 250, 500);
        left_panel.setBackground(Color.WHITE);

        right_panel = new JPanel();
        right_panel.setLayout(null);
        right_panel.setBounds(250, 0, 250, 500);
        right_panel.setBackground(Color.WHITE);
        left_panel.add(id);
        left_panel.add(no_of_customers);
        left_panel.add(days_length);
        left_panel.add(cusid);
        left_panel.add(members);
        left_panel.add(day_len_field);
        left_panel.add(days_length);
        left_panel.add(confirm_book);
        left_panel.add(cost);
        left_panel.add(amt);
        left_panel.add(back_button);
        left_panel.add(type);
        left_panel.add(type_name);
        left_panel.add(Booking_slot);
        left_panel.add(date);

        this.setSize(500, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.add(left_panel);
        this.add(right_panel);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String d, memb;
        int m_index;
        if(e.getSource() == members) {
            m_index = members.getSelectedIndex();
            memb = allowed_members[m_index];
            mem = Integer.parseInt(memb);
        }

        if(e.getSource() == date) {
            int index = date.getSelectedIndex();
            check_in = dates[index];
        }

        if(e.getSource() == confirm_book) {
            //m = no_field.getText();
            //mem = Integer.parseInt(m);
            d = day_len_field.getText();
            days_staying = Integer.parseInt(d);
            this.setVisible(false);
            new BookRoomConfirm();
        }

        else if(e.getSource() == back_button) {
            this.setVisible(false);
            new Book_Select_Rooms();
        }
    }

    public static void main(String[] args) {
        new BookRoom();
    }
}

