package Mypackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Mypackage.BookRoom.days_staying;
import static Mypackage.Book_Select_Rooms.per_day_cost;

public class BookRoomConfirm extends JFrame implements ActionListener {
    JButton back_button, proceed;
    JLabel select_room_no, amt;
    BookRoomJdbc bd;
    BookRoomConfirm() {
        amt = new JLabel(""+days_staying*per_day_cost);
        amt.setBounds(150, 20, 100, 30);

        select_room_no = new JLabel("Payment amount : ");
        select_room_no.setBounds(30, 20, 200, 30);

        back_button = new JButton("Back");
        back_button.setBounds(20, 280, 150, 50);
        back_button.addActionListener(this);
        back_button.setFocusable(false);

        proceed = new JButton("Proceed");
        proceed.setBounds(20, 200, 150, 50);
        proceed.addActionListener(this);
        proceed.setFocusable(false);

        this.setSize(400, 400);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.add(back_button);
        this.add(amt);
        this.add(select_room_no);
        this.add(proceed);

        this.setVisible(true);

        bd = new BookRoomJdbc();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == proceed) {
            try{
                this.setVisible(false);
                new ConfirmPayment();
            }
            catch (Exception e2) {
                System.out.println(e2);
            }
        }

        else if(e.getSource() == back_button) {
            this.setVisible(false);
            new BookRoom();
        }
    }

    public static void main(String[] args) {
        new BookRoomConfirm();
    }
}
