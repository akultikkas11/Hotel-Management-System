package Mypackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Mypackage.BookRoom.*;
import static Mypackage.Book_Select_Rooms.per_day_cost;
import static Mypackage.Book_Select_Rooms.type_of_room;
import static Mypackage.UserLogin.c_idd;

public class ConfirmPayment extends JFrame implements ActionListener {
    String payment_mode;
    JComboBox drop_box;

    JLabel select_payment, check_in_date, check_in_value, days_stay, days_stay_value, pay, amt, capacity, capacity_value, cost_day, cost_day_value;
    JButton Proceed;
    String[] pay_mode = {"UPI", "Cash", "Debit Card", "NetBanking"};
    BookRoomJdbc bd;
    ConfirmPayment() {
        select_payment = new JLabel("Payment Mode");
        select_payment.setBounds(10, 20, 100, 30);

        drop_box = new JComboBox(pay_mode);
        drop_box.setBounds(160, 20, 100, 30);
        drop_box.addActionListener(this);

        check_in_date = new JLabel("Check in : ");
        check_in_date.setBounds(10, 60, 100, 30);
        check_in_value = new JLabel(""+check_in);
        check_in_value.setBounds(160, 60, 100, 30);

        days_stay = new JLabel("Days Stay : ");
        days_stay.setBounds(10, 100, 100, 30);
        days_stay_value = new JLabel(""+days_staying);
        days_stay_value.setBounds(160, 100, 100, 30);

        capacity = new JLabel("No. of Members : ");
        capacity.setBounds(10, 140, 200, 30);
        capacity_value = new JLabel(""+mem);
        capacity_value.setBounds(160, 140, 100, 30);

        cost_day = new JLabel("Cost per day : ");
        cost_day.setBounds(10, 180, 100, 30);
        cost_day_value = new JLabel("" + per_day_cost);
        cost_day_value.setBounds(160, 180, 100, 30);

        pay = new JLabel("Total Payable amount : ");
        pay.setBounds(10, 220, 220, 30);
        amt = new JLabel(""+days_staying*per_day_cost);
        amt.setBounds(160, 220, 100, 30);

        Proceed = new JButton("Proceed");
        Proceed.setBounds(150, 300, 100, 40);
        Proceed.addActionListener(this);

        this.setSize(420, 420);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(select_payment);
        this.add(Proceed);
        this.add(drop_box);
        this.add(check_in_date);
        this.add(check_in_value);
        this.add(days_stay);
        this.add(days_stay_value);
        this.add(days_stay);
        this.add(capacity);
        this.add(capacity_value);
        this.add(pay);
        this.add(amt);
        this.add(cost_day);
        this.add(cost_day_value);
        this.setVisible(true);


        bd = new BookRoomJdbc();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == drop_box) {
            int index = drop_box.getSelectedIndex();
            payment_mode = pay_mode[index];
        }

        if(e.getSource() == Proceed) {
            try{
                int pay_amt = days_staying * per_day_cost;
                bd.connect();
                bd.book_room(Integer.parseInt(c_idd), mem, type_of_room, pay_amt, payment_mode, check_in, days_staying);
                bd.disconnect();
                this.setVisible(false);
                new Registration();
            }
            catch (Exception e1) {
                System.out.println(e1);
            }
        }

    }
}
